package GamePlaying;

import Data.GameData;
import Enums.Token;
import Properties.*;
import Utilities.Dice;
import Utilities.NumberValueCheck;
import Utilities.Player;
import Utilities.RaiseMoney;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class TurnTracker {

    private int numberOfPlayers;
    private final ArrayList<Player> playerList;
    private final ArrayList<String> tokenList;
    private final Scanner scanner;
    private final ArrayList<String> gameBoard;
    private final LinkedHashMap<String, Property> propertyAttributes;
    private final LinkedHashMap<String, PropertyFinancials> propertyFinancials;
    private final Dice dice;
    private final RaiseMoney raiseMoney;
    NumberValueCheck numberValueCheck;

    public TurnTracker() throws FileNotFoundException {
        GameData gameData = new GameData();
        numberOfPlayers = 0;
        playerList = new ArrayList<>();
        tokenList = new ArrayList<>(Arrays.asList("DOG", "CAT", "BATTLESHIP", "PENGUIN", "RUBBERDUCKY", "TOPHAT", "RACECAR", "THIMBLE"));
        //scanner = new Scanner(System.in); // disables while debugging
        scanner = new Scanner(new File("userInputs.txt"));
        gameBoard = gameData.getGameBoard();
        propertyAttributes = new LinkedHashMap<>(gameData.getPropertyMap());
        propertyFinancials = new LinkedHashMap<>(gameData.getPropertyFinancialsMap());
        dice = new Dice();
        raiseMoney = new RaiseMoney();
        numberValueCheck = new NumberValueCheck();
    }

    public void sendToJail(Player player){
        player.setBoardLocation(40);
        player.setInJail(true);
        player.setDoubleDiceCount(0);
    }

    private void isInJail(String entry, Player player){

        // increases the in jail counter every turn that player is in jail
        player.setTimeInJail(player.getTimeInJail() + 1);

        // if player has get out of jail card and time in jail is less than 3
        if (player.getGetOutOfJailFreeCount() > 0 && player.getTimeInJail() <= 3) {

            System.out.println();
            System.out.println(STR."1: Use your \"Get Out of Jail Free\" card.");
            System.out.println(STR."2: Pay $50 to leave jail.");
            System.out.println(STR."3: Roll the dice.");

            int jailSelection = Integer.parseInt(numberValueCheck.validEntry(1, 3, scanner));

            switch (jailSelection) {
                // use get out of jail free card
                case 1:
                    player.setGetOutOfJailFreeCount(player.getGetOutOfJailFreeCount() - 1);
                    player.setInJail(false);
                    player.setBoardLocation(10);
                    player.setDoubleDiceCount(0);

                    // rolling dice
                    dice.roll();;
                    player.setBoardLocation(10);
                    break;

                // attempt to pay to get out of jail
                case 2:
                    if (player.getCash() >= 50) {

                        player.setCash(player.getCash() - 50);

                        // sets player to no longer in jail
                        player.setInJail(false);

                        // set player on just visiting
                        player.setBoardLocation(10);

                        // rolling dice
                        dice.roll();;

                    } else {

                        System.out.println("Insufficient funds raise money");

                        raiseMoney.raiseMoneyOptions(player, propertyAttributes, numberValueCheck,
                                propertyFinancials, playerList, scanner);
                    }
                    break;

                // attempt to roll to get out of jail
                case 3:

                    // rolling dice
                    dice.roll();;

                    // player rolled doubles and left jail
                    if (dice.getDiceOne() == dice.getDiceTwo()) {

                        // reset the player double count to 1
                        player.setDoubleDiceCount(1);
                        System.out.println("You rolled doubles and are out of jail");
                    }

                    // player has to pay to get out of jail after 3rd roll
                    else if (player.getTimeInJail() == 3) {

                        // ways to raise funds
                        while (player.getCash() < 50) {
                            System.out.println("Insufficient funds to get out of jail after your 3rd roll");
                            System.out.println("Raise money");
                            System.out.println("####################");

                            raiseMoney.raiseMoneyOptions(player, propertyAttributes, numberValueCheck,
                                    propertyFinancials, playerList, scanner);
                        }
                        // reset the player double count to 0
                        player.setDoubleDiceCount(0);
                    }

                    // sets player to no longer in jail
                    player.setInJail(false);

                    // moves player to just visiting
                    player.setBoardLocation(10);

                break;
            }
        }
    }

    public void turnProgression(){

        String entry = "";

        do{
            System.out.println();
            System.out.print("What is the number of players(Make sure to only enter a valid number \"2-8\")? ");
            entry = scanner.nextLine().trim();
        }
        while(numberValueCheck.notValidNumber(entry) || numberValueCheck.notInRange(entry, 2 , 8));

        numberOfPlayers = Integer.parseInt(entry);

        // players select tokens
        for (int index = 0; index < numberOfPlayers; index++){
            int playerNumber = index + 1;

                System.out.println();
                System.out.println("########################################################");
                System.out.println(STR."Utilities.Player \{index + 1}, which token do you want to use?");
                System.out.println();

                for(int tokenIndex = 0; tokenIndex < tokenList.size(); tokenIndex++){
                    System.out.println(STR."\{tokenIndex + 1}: \{tokenList.get(tokenIndex)}");
                }

            int tokenNumber = Integer.parseInt(numberValueCheck.validEntry(1, tokenList.size(), scanner)) - 1;

            //playerList.add(new Player(playerNumber, Token.valueOf(tokenList.get(tokenNumber)),0,1500, false, 0, 0,0));
            playerList.add(new Player(playerNumber, Token.valueOf(tokenList.get(tokenNumber)),0,35, true, 0, 1,0));
            tokenList.remove(tokenNumber);

            System.out.println();
            System.out.println(STR."Utilities.Player \{playerNumber} is the \{playerList.get(index).getToken()}");
        }

        System.out.println();
        System.out.println("Shuffling player order");

        Collections.shuffle(playerList);

        System.out.println();
        System.out.println("########################################################");
        System.out.println("Starting game");
        System.out.println("########################################################");

        boolean continueGame = true;

        int currentPlayerIndex = 0;

        int testIndex = 0;
        // start game
        // keeps going until there is only one player left
        while(testIndex < 80){
            if(currentPlayerIndex == playerList.size() - 1) currentPlayerIndex = 0;
            else currentPlayerIndex++;

            Player player = playerList.get(currentPlayerIndex);

            System.out.println();
            System.out.println(STR."Turn: \{testIndex + 1}");
            System.out.println(STR."\{player.getToken()}'S TURN");

            String initialLocation = STR."Started on. Index: \{player.getBoardLocation()} - \{gameBoard.get(player.getBoardLocation())}";

            //System.out.println(STR."Index Location: \{player.getBoardLocation()} - Utilities.Player started on \{gameBoard().get(player.getBoardLocation())}");

            // checks if player is in jail and remains in while loop until it is resolved
            if(player.isInJail()){
                while(player.isInJail()){
                    isInJail(entry, player);
                }
            } else{
                dice.roll();
            }
            // tracking doubles rolled for each player
            if(dice.getDiceOne() == dice.getDiceTwo()){player.setDoubleDiceCount(player.getDoubleDiceCount() + 1);}
            else player.setDoubleDiceCount(0);

            // if player rolled doubles three times, go to jail
            if(player.getDoubleDiceCount() == 3){
                sendToJail(player);
            }else{

                int locationTotal = player.getBoardLocation() + dice.getDiceOne() + dice.getDiceTwo();
                //int locationTotal = player.getBoardLocation() + 1;

                // adjusts movement to number of spaces on board
                if(locationTotal > 39){
                    locationTotal = locationTotal % 39;
                }

                // player can move while not in jail
                if(!player.isInJail()){

                    player.setBoardLocation(locationTotal);
                }

            }
            System.out.println(initialLocation);
            System.out.println(STR."Moved to.   Index: \{player.getBoardLocation()} - \{gameBoard.get(player.getBoardLocation())}");

            // add roll again for doubles after initial turn but can't roll again if in jail(and gets out of jail during this turn) or sent to jail

            testIndex++;

        }
    }
}
