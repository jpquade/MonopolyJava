import Data.GameData;
import Enums.Token;
import Properties.*;


import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class TurnTracker {

    private int numberOfPlayers;
    private final ArrayList<Player> playerList;
    private final ArrayList<String> tokenList;
    private final Scanner scanner;
    private final GameData gameData;
    private final Map<String, Property> propertyAttributes;
    private final Map<String, PropertyFinancials> propertyFinancials;

    public TurnTracker() {
        numberOfPlayers = 0;
        playerList = new ArrayList<>();
        tokenList = new ArrayList<>(Arrays.asList("DOG", "CAT", "BATTLESHIP", "PENGUIN", "RUBBERDUCKY", "TOPHAT", "RACECAR", "THIMBLE"));
        scanner = new Scanner(System.in);
        gameData = new GameData();
        propertyAttributes = new HashMap<>(gameData.getPropertyMap());
        propertyFinancials = new HashMap<>(gameData.getPropertyFinancialsMap());
    }

    // checks if string contains a valid number
    private boolean isValidNumber(String s) {
        int radix = 10;

        if(s.isEmpty()) return false;
        for(int index = 0; index < s.length(); index++) {
            if(index == 0 && s.charAt(index) == '-') {
                if(s.length() == 1) return false;
                else continue;
            }
            if(Character.digit(s.charAt(index),radix) < 0) return false;
        }
        return true;
    }

    // checks if string converted into number is in a range
    private boolean inRange(String s, int lo, int hi){
        return lo <= Integer.parseInt(s) || Integer.parseInt(s) <= hi;
    }

    private void jailOptionGenerator(){

    }

    private void isInJail(String entry, Player player){
        // checks if player is in jail
        if(player.isInJail()) {

            // increases the in jail counter every turn that player is in jail
            player.setTimeInJail(player.getTimeInJail() + 1);

            // if player has get out of jail card / and time in jail is less than 3
            if (player.getGetOutOfJailFreeCount() > 0 && player.getTimeInJail() <= 3) {

                do {
                    System.out.println();
                    System.out.println(STR."1: Use your \"Get Out of Jail Free\" card?");
                    System.out.println(STR."2: Pay $50 to leave jail?");
                    System.out.println(STR."3: Roll the dice?");
                    System.out.print("Please enter a valid selection:  ");
                    entry = scanner.nextLine().trim().toLowerCase();

                }
                while (!isValidNumber(entry) && !inRange(entry, 1, 3));

                int jailSelection = Integer.parseInt(entry);

                switch (jailSelection) {
                    // use get out of jail free card
                    case 1:
                        player.setGetOutOfJailFreeCount(player
                                .getGetOutOfJailFreeCount() - 1);
                        player.setInJail(false);
                        player.setBoardLocation(10);
                        player.setDoubleDiceCount(0);
                        break;
                    // attempt to pay to get out of jail
                    case 2:
                        if (player.getCash() < 50) {

                            do {
                                System.out.println("Insufficient funds");
                                System.out.println("1: Raise money");
                                System.out.println("2: Return to main Jail Options");
                                System.out.print("Please enter a valid selection:  ");
                                entry = scanner.nextLine().trim().toLowerCase();
                            }
                            while (!isValidNumber(entry) && !inRange(entry, 1, 2));

                            int getOutofJailSelection = Integer.parseInt(entry);

                            switch(getOutofJailSelection){
                                case 1:

                                case 2:
                                    return;

                            }
                        }
                        else{
                            player.setCash(player.getCash() - 50);
                            player.setInJail(false);
                            player.setBoardLocation(10);
                        }
                        break;
                    // attempt to roll to get out of jail
                    case 3:
                        System.out.println();
                        System.out.println("Rolling dice");

                        int diceOne = ThreadLocalRandom.current().nextInt(1, 6 + 1);

                        int diceTwo = ThreadLocalRandom.current().nextInt(1, 6 + 1);

                        System.out.println(STR."First Dice Roll:  \{diceOne}");
                        System.out.println(STR."Second Dice Roll: \{diceTwo}");

                        // player rolled doubles and left jail
                        if(player.getTimeInJail() == 3){
                            if(diceOne == diceTwo){
                                player.setInJail(false);
                                player.setBoardLocation(10);
                            }
                            // player has to pay to get out of jail after 3rd roll
                            else{
                                do {
                                    System.out.println("Insufficient funds");
                                    System.out.println("Raise money");
                                    System.out.println("####################");
                                    // ways to raise funds
                                    System.out.println("1. Mortgage Property");
                                    System.out.println("2. Sell Improvements");
                                    System.out.println("3. Sell Property");
                                    System.out.println("4: Return to main Jail Options");
                                    System.out.print("Please enter a valid selection:  ");

                                    entry = scanner.nextLine().trim().toLowerCase();
                                }
                                while (!isValidNumber(entry) && !inRange(entry, 1, 2));

                                // index to keep track of element number
                                int i;
                                int paymentOptions = Integer.parseInt(entry);

                                // choose how to get additional funding
                                switch(paymentOptions){
                                    case 1:

                                        System.out.println("List of un-mortgaged properties you own:");
                                        System.out.println();

                                        i = 0;

                                        ArrayList<String> listOfUnMortgaged = new ArrayList<>();

                                        for(Property property: propertyAttributes.values()){
                                            if(!property.isMortgaged() && property.getOwner() == player.getToken()){
                                                System.out.println(STR."\{i + 1}: \{property.getName()} mortgage amount: \{propertyFinancials
                                                        .get(property.getName()).getMortgageAmount()}");
                                                listOfUnMortgaged.add(property.getName());
                                            }
                                            i++;
                                        }
                                        System.out.println(STR."\{i + 1}: Return to main Jail Options");

                                        System.out.println("Select which property you want to mortgage.");

                                        do {
                                            System.out.print("Please enter a valid selection:  ");
                                            entry = scanner.nextLine().trim().toLowerCase();
                                        }
                                        while (!isValidNumber(entry) && !inRange(entry, i, i + 1));

                                        int mortgageSelection = Integer.parseInt(entry) - 1;

                                        if(inRange(entry, 0, i)){
                                            // set player cash (current player cash + mortgage amt)
                                            player.setCash(player
                                                    .getCash() + propertyFinancials.get(listOfUnMortgaged
                                                    .get(mortgageSelection)).getMortgageAmount());
                                            // mortgage property set to true
                                            propertyAttributes.get(listOfUnMortgaged.get(mortgageSelection)).setMortgaged(true);

                                            System.out.println(STR."Mortgaged \{listOfUnMortgaged.get(mortgageSelection)} and added \{gameData
                                                    .getPropertyFinancialsMap().get(listOfUnMortgaged.get(mortgageSelection)).getMortgageAmount()} to wallet.");
                                            System.out.println(STR."\{player
                                                    .getToken()}'S current cash: \{player.getCash()}");
                                        }
                                        //  else return to main jail options
                                        else return;

                                        break;
                                    case 2:
                                        // find improvements to sell

                                        System.out.println("List of improved properties you own:");
                                        System.out.println();

                                        // index to keep track of element number within listOfUnMortgaged
                                        i = 0;

                                        ArrayList<String> listOfImproved = new ArrayList<>();

                                        for(Property property: propertyAttributes.values()){
                                            if(property.getHouse() > 0 || property.isHotel()){

                                                if(property.getHouse() > 0){
                                                    System.out.println(STR."\{i + 1}: \{property.getName()} has  \{propertyAttributes
                                                            .get(property.getName()).getHouse()} house(s) that sell for \{gameData
                                                            .getPropertyFinancialsMap().get(property.getName()).getPricePerImprovement() / 2} each}");
                                                }
                                                else{
                                                    System.out.println(STR."\{i + 1}: \{property.getName()} has a \{propertyAttributes
                                                            .get(property.getName()).isHotel()} hotel that sells for \{gameData
                                                            .getPropertyFinancialsMap().get(property.getName()).getPricePerImprovement() / 2}.}");
                                                }
                                                listOfImproved.add(property.getName());
                                            }
                                            i++;
                                        }

                                        System.out.println(STR."\{i + 1}: Return to main Jail Options");

                                        System.out.println("Select which property you want to sell improvements from.");

                                        do {
                                            System.out.print("Please enter a valid selection:  ");
                                            entry = scanner.nextLine().trim().toLowerCase();
                                        }
                                        while (!isValidNumber(entry) && !inRange(entry, 0, i + 1));

                                        int improvementSelection = Integer.parseInt(entry) - 1;

                                        // if option selected is 0 to i - sell a property
                                        if(inRange(entry, 0, i)) {

                                            int numberOfHouses = propertyAttributes.get(listOfImproved.get(improvementSelection)).getHouse();
                                            //boolean hotelExists = propertyAttributes.get(listOfImproved.get(improvementSelection)).isHotel();

                                            // sell houses
                                            if (numberOfHouses > 0) {

                                                System.out.println(STR."How many houses do you want to sell out of \{numberOfHouses} house(s)?");
                                                System.out.println();
                                                System.out.println(STR."Enter number of houses up to \{numberOfHouses}");
                                                System.out.println(STR."\{numberOfHouses + 1}: Return to main Jail Options");

                                                do {
                                                    System.out.print("Please enter a valid selection: ");
                                                    entry = scanner.nextLine().trim().toLowerCase();
                                                }
                                                while (!isValidNumber(entry) && !inRange(entry, 1, numberOfHouses));

                                                int housesToSell = Integer.parseInt(entry);

                                                // remove houses sold
                                                propertyAttributes.get(listOfImproved.get(improvementSelection)).setHouse(propertyAttributes
                                                        .get(listOfImproved.get(improvementSelection)).getHouse() - housesToSell);

                                                // add cash from sold houses to player
                                                player.setCash(player.getCash()
                                                        + (housesToSell * propertyFinancials.get(listOfImproved.get(improvementSelection)).getPricePerImprovement() / 2));

                                                System.out.println(STR."Selling \{numberOfHouses} house(s) for half of \{propertyFinancials
                                                        .get(listOfImproved.get(improvementSelection)).getPricePerImprovement()} each.");

                                                System.out.println(STR."\{player.getToken()} now has \{player.getCash()}");


                                            }
                                            // sell hotel
                                            else{
                                                System.out.println(STR."1: Sell your hotel.");
                                                System.out.println(STR."2: Return to main Jail Options");
                                                System.out.println();

                                                do {
                                                    System.out.print("Please enter a valid selection: ");
                                                    entry = scanner.nextLine().trim().toLowerCase();
                                                }
                                                while (!isValidNumber(entry) && !inRange(entry, 1, 2));

                                                int sellHotelSelection = Integer.parseInt(entry);

                                                if(sellHotelSelection == 1){

                                                    // remove hotel sold
                                                    propertyAttributes.get(listOfImproved.get(improvementSelection)).setHotel(false);

                                                    // add cash from sold hotel to player
                                                    player.setCash(player.getCash()
                                                            + propertyFinancials.get(listOfImproved.get(improvementSelection)).getPricePerImprovement() / 2);

                                                    System.out.println(STR."Selling hotel for half of \{propertyFinancials.get(listOfImproved
                                                            .get(improvementSelection)).getPricePerImprovement()}.");
                                                    System.out.println(STR."\{player.getToken()} now has \{player.getCash()}");

                                                }
                                                else return;

                                            }
                                        }
                                        // if option i + 1 return to main menu
                                        else return;

                                        break;
                                    case 3:
                                        // find properties to sell to other players
                                        break;
                                    case 4:
                                        return;
                                }
                            }
                        }
                        break;
                }
            }
            else {
                do {
                    System.out.println();

                    System.out.println(STR."1: Would you like to pay $50 to leave jail?");
                    System.out.println(STR."2: Would you like to roll the dice?");
                    System.out.print("Please enter a valid selection:  ");
                    entry = scanner.nextLine().trim().toLowerCase();

                }
                while (!isValidNumber(entry) && !inRange(entry, 1, 2));
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
        while(!isValidNumber(entry) || !inRange(entry, 2 , 8));

        numberOfPlayers = Integer.parseInt(entry);

        for (int index = 0; index < numberOfPlayers; index++){
            int playerNumber = index + 1;
            do{
                System.out.println();
                System.out.println("########################################################");
                System.out.println(STR."Player \{index + 1}, which token do you want to use?");
                System.out.println();

                for(int tokenIndex = 0; tokenIndex < tokenList.size(); tokenIndex++){
                    System.out.println(STR."\{tokenIndex}: \{tokenList.get(tokenIndex)}");
                }

                System.out.println();
                System.out.print("Enter the valid number of the token you want to use: ");
                entry = scanner.nextLine().trim();
            }
            while(!isValidNumber(entry) || !inRange(entry, 0, tokenList.size() - 1));

            int tokenNumber = Integer.parseInt(entry);

            playerList.add(new Player(playerNumber, Token.valueOf(tokenList.get(tokenNumber)),0,1500, false, 0, 0,0));
            tokenList.remove(tokenNumber);

            System.out.println();
            System.out.println(STR."Player \{playerNumber} is the \{playerList.get(index).getToken()}");
        }

        System.out.println();
        System.out.println("########################################################");
        System.out.println("Shuffling player order");

        Collections.shuffle(playerList);

        System.out.println();

        boolean continueGame = true;

        int currentPlayerIndex = 0;

        // game keeps going until there is only one player left
        while(continueGame){
            if(currentPlayerIndex == playerList.size() - 1) currentPlayerIndex = 0;
            else currentPlayerIndex++;

            Player player = playerList.get(currentPlayerIndex);

            System.out.println();
            System.out.println(STR."\{player.getToken()}'S TURN");

            // checks if player is in jail and remains in while loop until it is resolved
            while(player.isInJail()){
                isInJail(entry, player);
            }

            System.out.println();
            System.out.println("Rolling dice");

            int diceOne = ThreadLocalRandom.current().nextInt(1, 6 + 1);

            int diceTwo = ThreadLocalRandom.current().nextInt(1, 6 + 1);

            System.out.println(STR."First Dice Roll:  \{diceOne}");
            System.out.println(STR."Second Dice Roll: \{diceTwo}");
        }



    }
}
