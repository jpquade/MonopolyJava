package main.GameProcessor;

import main.Data.GameData;
import main.Enums.BoardSpaceElement;
import main.Enums.PlayerToken;
import main.Enums.PropertyColor;
import main.Functions.*;
import main.Properties.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class TurnTracker {

    private int numberOfPlayers;
    private final PlayerList players;
    private final ArrayList<Player> playerList;
    private final ArrayList<String> tokenList;
    private final Scanner scanner;
    private final ArrayList<String> gameBoard;
    private final LinkedHashMap<String, PropertyAttributes> propertyAttributesMap;
    private final LinkedHashMap<String, PropertyFinancials> propertyFinancialsMap;
    private final LinkedHashMap<PropertyColor, ColorGroup> colorGroupMap;
    private final Dice dice;
    private final MoneyProcessor moneyProcessor;
    private final NumberValueCheck numberValueCheck;
    private final PropertyMerchant propertyMerchant;
    private int currentPlayerIndex;

    public TurnTracker() throws FileNotFoundException {
        this.players = new PlayerList();
        GameData gameData = new GameData();
        numberOfPlayers = 0;
        playerList = new ArrayList<>();
        tokenList = new ArrayList<>(Arrays.asList("DOG", "CAT", "BATTLESHIP", "PENGUIN", "RUBBERDUCKY", "TOPHAT", "RACECAR", "THIMBLE"));
        // scanner = new Scanner(System.in); // disabled while debugging
        scanner = new Scanner(new File("userInputs.txt"));
        gameBoard = gameData.getGameBoard();
        propertyAttributesMap = new LinkedHashMap<>(gameData.getPropertyAttributesMap());
        propertyFinancialsMap = new LinkedHashMap<>(gameData.getPropertyFinancialsMap());
        colorGroupMap = new LinkedHashMap<>(gameData.getColorGroupMap());
        dice = new Dice();
        moneyProcessor = new MoneyProcessor(players);
        numberValueCheck = new NumberValueCheck();
        propertyMerchant = new PropertyMerchant();
        currentPlayerIndex = 0;
    }

    public void sendToJail(Player player){
        player.setBoardLocation(BoardSpaceElement.JAIL);
        player.setInJail(true);
        player.setDoubleDiceCount(0);
    }

    public Player currentPlayer(){
        return playerList.get(currentPlayerIndex);
    }

    private boolean isInJail(String entry, Player player){

        System.out.println();
        System.out.println(STR."1: Use your \"Get Out of Jail Free\" card if you have one.");
        System.out.println(STR."2: Pay $50 to leave jail.");
        System.out.println(STR."3: Roll the dice.");
        System.out.println();
        System.out.println(STR."Get out of jail free cards: \{player.getGetOutOfJailFreeCount()}");
        System.out.println(STR."\{player.getToken()} has \{player.getCash()} cash.");

        // enabled while debugging
        Scanner jailScan = new Scanner(System.in);

        System.out.println(STR."\{player.getToken()}S time in jail \{player.getTimeInJail()} turn(s).");

        int jailSelection = Integer.parseInt(numberValueCheck.validEntry(1, 3, jailScan));

        switch (jailSelection) {

            // use get out of jail free card
            case 1:
                if(player.getGetOutOfJailFreeCount() > 0){
                    player.setGetOutOfJailFreeCount(player.getGetOutOfJailFreeCount() - 1);

                    player.setInJail(false);
                    System.out.println(STR."\{player.getToken()} used Get out of Jail Free card");
                    System.out.println(STR."\{player.getToken()} now has \{player.getGetOutOfJailFreeCount()} get out of Jail Free cards");
                    System.out.println(STR."\{player.getToken()} is now out of jail");

                    // rolling dice
                    dice.roll();
                    return true;
                } else{
                    System.out.println();
                    System.out.println("No get out of free jail cards available.");
                }
                break;

            // attempt to pay to get out of jail
            case 2:
                if (player.getCash() >= 50) {

                    System.out.println(STR."\{player.getToken()} has \{player.getCash()} cash.");
                    player.setCash(player.getCash() - 50);

                    player.setInJail(false);
                    System.out.println(STR."\{player.getToken()} paid (-50) to get out of jail.");
                    System.out.println(STR."\{player.getToken()} now has \{player.getCash()} cash.");
                    System.out.println(STR."\{player.getToken()} is now out of jail");

                    // rolling dice
                    dice.roll();
                    return true;

                } else {

                    System.out.println();
                    System.out.println("Insufficient funds, raise money");
                    System.out.println();

                    moneyProcessor.raiseMoneyOptions(player, propertyAttributesMap, numberValueCheck,
                            propertyFinancialsMap, playerList, jailScan);

                }
                break;

            // attempt to roll to get out of jail
            case 3:

                // rolling dice
                dice.roll();

                // player rolled doubles and left jail
                if (dice.getDiceOne() == dice.getDiceTwo()) {

                    player.setInJail(false);
                    System.out.println(STR."\{player.getToken()} rolled doubles");
                    return true;
                }

                // player has to pay to get out of jail after 3rd roll
                else if (player.getTimeInJail() >= 3) {

                    System.out.println();
                    System.out.println(STR."\{player.getToken()} did not get doubles and must pay to get out of jail.");

                    // ways to raise funds
                    while (player.getCash() < 50) {

                        System.out.println("Insufficient funds to get out of jail after your 3rd roll.");
                        System.out.println("Raise money");
                        System.out.println(STR."\{player.getToken()} has \{player.getCash()} cash.");
                        System.out.println();
                        System.out.println("####################");
                        System.out.println();
                        System.out.println("Return to main options has been disabled until you raise enough funds.");
                        System.out.println();

                        moneyProcessor.raiseMoneyOptions(player, propertyAttributesMap, numberValueCheck,
                                propertyFinancialsMap, playerList, jailScan);
                    }

                    System.out.println(STR."\{player.getToken()} has \{player.getCash()} cash.");
                    player.setCash(player.getCash() - 50);

                    player.setInJail(false);
                    System.out.println(STR."\{player.getToken()} (-50) paid to get out of jail.");
                    System.out.println(STR."\{player.getToken()} now has \{player.getCash()} cash.");
                    System.out.println(STR."\{player.getToken()} is now out of jail");

                    return true;
                }
                return true;
            }
        return false;
    }

    public void turnProgression() throws FileNotFoundException {

        String entry = "";

        do{
            System.out.println();
            System.out.print("What is the number of players (Make sure to only enter a valid number \"2-8\")? ");
            entry = scanner.nextLine().trim();
        }
        while(numberValueCheck.notValidNumber(entry) || numberValueCheck.notInRange(entry, 2 , 8));

        numberOfPlayers = Integer.parseInt(entry);

        // used for testing
        Scanner tempScan = new Scanner(new File("playerTemp.txt"));

        // players select tokens
        for (int index = 0; index < numberOfPlayers; index++){
            int playerNumber = index + 1;

                System.out.println();
                System.out.println("########################################################");
                System.out.println(STR."Player \{index + 1}, which playerToken do you want to use?");
                System.out.println();

                for(int tokenIndex = 0; tokenIndex < tokenList.size(); tokenIndex++){
                    System.out.println(STR."\{tokenIndex + 1}: \{tokenList.get(tokenIndex)}");
                }

            int tokenNumber = Integer.parseInt(numberValueCheck.validEntry(1, tokenList.size(), scanner)) - 1;

            // disabled while debugging
            // playerList.add(new Player(playerNumber, Token.valueOf(tokenList.get(tokenNumber)),0,1500, false, 0, 0,0));

            //temporary used for testing
            String playerNum = tempScan.next();
            String playerToken = tempScan.next();
            String boardLocation = tempScan.next();
            String cash = tempScan.next();
            String inJail = tempScan.next();
            String doubleDiceCount = tempScan.next();
            String getOutOfJailFreeCount = tempScan.next();
            String timeInJail = tempScan.nextLine().trim();

            //System.out.println(playerNum + playerToken + boardLocation + cash + inJail + doubleDiceCount + getOutOfJailFreeCount + timeInJail);
            playerList.add(new Player(Integer.parseInt(playerNum), PlayerToken.valueOf(playerToken), Integer.parseInt(cash),
                    Boolean.parseBoolean(inJail), Integer.parseInt(doubleDiceCount), Integer.parseInt(getOutOfJailFreeCount),
                    0,0,Integer.parseInt(timeInJail),0,0, false));

            tokenList.remove(tokenNumber);

            System.out.println();
            System.out.println(STR."Player \{playerNumber} is the \{playerList.get(index).getToken()}.");
        }

        // enabled while debugging
        String prop = "Mediterranean Avenue";
        propertyMerchant.purchaseProperty(playerList.get(0), propertyAttributesMap.get(prop), propertyFinancialsMap.get(prop), colorGroupMap.get(propertyAttributesMap.get(prop).getColor()), propertyAttributesMap);

        prop = "Baltic Avenue";
        propertyMerchant.purchaseProperty(playerList.get(0), propertyAttributesMap.get(prop), propertyFinancialsMap.get(prop), colorGroupMap.get(propertyAttributesMap.get(prop).getColor()), propertyAttributesMap);


        System.out.println();
        System.out.println("Shuffling player order...");

        // disabled while debugging
        //Collections.shuffle(playerList);

        System.out.println();
        System.out.println("########################################################");
        System.out.println("Starting game");
        System.out.println("########################################################");

        // add code to check for number of players...if there is only one, then continue game is false
        // and a winner is declared
        boolean continueGame = true;

        // temporary
        int testIndex = 0;
        // start game
        // keeps going until there is only one player left
        while(testIndex < 80){
            if(currentPlayerIndex == playerList.size() - 1) currentPlayerIndex = 0;
            else currentPlayerIndex++;

            Player player = playerList.get(currentPlayerIndex);

            System.out.println();
            System.out.println("***********************************************");
            System.out.println(STR."Turn: \{testIndex + 1}");
            System.out.println(STR."\{player.getToken()}'S TURN");
            System.out.println(STR."\{player.getToken()} has \{player.getCash()} cash.");
            System.out.println(STR."Times rolled doubles: \{player.getDoubleDiceCount()} at start of turn");

            // checks if player is in jail and remains in while loop until it is resolved
            if(player.isInJail()){

                // increases the in jail counter every turn that player is in jail
                player.setTimeInJail(player.getTimeInJail() + 1);

                // canEscape variable allows for a player to exit this block if out of jail to take rest of turn
                // or if rolled while in jail for non-movement related activities
                boolean canEscape = false;
                while(player.isInJail() && !canEscape){
                    canEscape = isInJail(entry, player);
                }
                // this block will not execute if dice rolled and still in jail
                if(!player.isInJail()){
                    player.setTimeInJail(0);
                    player.setBoardLocation(BoardSpaceElement.JUST_VISITING_JAIL);
                }
            } else{
                // not in jail roll dice
                dice.roll();

                // tracking doubles rolled
                if(dice.getDiceOne() == dice.getDiceTwo()){
                    player.setDoubleDiceCount(player.getDoubleDiceCount() + 1);
                    System.out.println(STR."\{player.getToken()} rolled doubles and will roll again after this turn.");

                    // if player rolled doubles three times, go to jail
                    if(player.getDoubleDiceCount() == 3) {
                        sendToJail(player);
                        System.out.println(STR."\{player.getToken()} rolled 3 doubles");
                        System.out.println(STR."\{player.getToken()} has been sent to jail.");
                    }
                    else{
                        // sets current player index back one so that this player can roll again after doubles rolled
                        if(currentPlayerIndex == 0) currentPlayerIndex = playerList.size() - 1;
                        else currentPlayerIndex--;
                    }
                }
                else player.setDoubleDiceCount(0);
            }

            // recording starting location
            int startLocation = player.getBoardLocation().ordinal();
            String currentNamedLocation = gameBoard.get(player.getBoardLocation().ordinal());

            // player moves to a new location if not in jail
            if(!player.isInJail()){
                int locationTotal = player.getBoardLocation().ordinal() + dice.getDiceOne() + dice.getDiceTwo();

                // disabled while debugging
                //int locationTotal = player.getBoardLocation() + 1;

                // adjusts movement to number of spaces on board
                if(locationTotal > 39){
                    locationTotal = locationTotal % 39;
                }

                player.setBoardLocation(BoardSpaceElement.values()[locationTotal]);
                System.out.println(STR."\{player.getToken()} will move \{dice.getDiceOne() + dice.getDiceTwo()} spaces.");
            }

            System.out.println(STR."Started on. Index: \{startLocation} - \{currentNamedLocation}");

            int finalLocation = player.getBoardLocation().ordinal();

            // added a condition for displaying alternate message if player doesn't move i.e. being in jail
            if(startLocation != finalLocation){
                System.out.println(STR."Moved to.   Index: \{finalLocation} - \{gameBoard.get(player.getBoardLocation().ordinal())}");
            } else {
                System.out.println(STR."Stayed on.  Index: \{finalLocation} - \{gameBoard.get(player.getBoardLocation().ordinal())}");
            }

            testIndex++;
        }
    }

    public int getCurrentPlayerIndex() {
        return currentPlayerIndex;
    }
}
