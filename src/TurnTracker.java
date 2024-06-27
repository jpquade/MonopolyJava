import Data.GameData;
import Enums.Token;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class TurnTracker {

    private int numberOfPlayers;
    private final ArrayList<Player> playerList;
    private final ArrayList<String> tokenList;
    private final Scanner scanner;

    public TurnTracker() {
        numberOfPlayers = 0;
        playerList = new ArrayList<>();
        tokenList = new ArrayList<>(Arrays.asList("DOG", "CAT", "BATTLESHIP", "PENGUIN", "RUBBERDUCKY", "TOPHAT", "RACECAR", "THIMBLE"));
        scanner = new Scanner(System.in);
    }

    // checks if string contains a valid number
    private boolean isNumber(String s) {
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
    private boolean checkRange(String s, int lo, int hi){
        return Integer.parseInt(s) < lo || hi < Integer.parseInt(s);
    }

    private void jailOptionGenerator(){

    }

    private void isInJail(int currentPlayerIndex, String entry){
        // checks if player is in jail
        if(playerList.get(currentPlayerIndex).isInJail()) {

            // increases the in jail counter every turn that player is in jail
            playerList.get(currentPlayerIndex).setTimeInJail(playerList.get(currentPlayerIndex).getTimeInJail() + 1);

            // if player has get out of jail card / and time in jail is less than 3
            if (playerList.get(currentPlayerIndex).getGetOutOfJailFreeCount() > 0 && playerList.get(currentPlayerIndex).getTimeInJail() <= 3) {

                do {
                    System.out.println();
                    System.out.println(STR."1: Use your \"Get Out of Jail Free\" card?");
                    System.out.println(STR."2: Pay $50 to leave jail?");
                    System.out.println(STR."3: Roll the dice?");
                    System.out.print("Please enter a valid selection:  ");
                    entry = scanner.nextLine().trim().toLowerCase();

                }
                while (!isNumber(entry) && !checkRange(entry, 1, 3));

                int jailSelection = Integer.parseInt(entry);

                switch (jailSelection) {
                    // use get out of jail free card
                    case 1:
                        playerList.get(currentPlayerIndex).setGetOutOfJailFreeCount(playerList.get(currentPlayerIndex).getGetOutOfJailFreeCount() - 1);
                        playerList.get(currentPlayerIndex).setInJail(false);
                        playerList.get(currentPlayerIndex).setBoardLocation(10);
                        playerList.get(currentPlayerIndex).setDoubleDiceCount(0);
                        break;
                    // attempt to pay to get out of jail
                    case 2:
                        if (playerList.get(currentPlayerIndex).getCash() < 50) {

                            do {
                                System.out.println("Insufficient funds");
                                System.out.println("1: Return to main Jail Options");
                                System.out.println("2: Raise money");
                                System.out.print("Please enter a valid selection:  ");
                                entry = scanner.nextLine().trim().toLowerCase();
                            }
                            while (!isNumber(entry) && !checkRange(entry, 1, 2));

                            int getOutofJailSelection = Integer.parseInt(entry);

                            switch(getOutofJailSelection){
                                case 1:
                                    return;
                                case 2:


                            }
                        }
                        else{
                            playerList.get(currentPlayerIndex).setCash(playerList.get(currentPlayerIndex).getCash() - 50);
                            playerList.get(currentPlayerIndex).setInJail(false);
                            playerList.get(currentPlayerIndex).setBoardLocation(10);
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
                        if(playerList.get(currentPlayerIndex).getTimeInJail() == 3){
                            if(diceOne == diceTwo){
                                playerList.get(currentPlayerIndex).setInJail(false);
                                playerList.get(currentPlayerIndex).setBoardLocation(10);
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
                                    System.out.print("Please enter a valid selection:  ");

                                    entry = scanner.nextLine().trim().toLowerCase();
                                }
                                while (!isNumber(entry) && !checkRange(entry, 1, 2));

                                int paymentOptions = Integer.parseInt(entry);

                                switch(paymentOptions){
                                    case 1:
//                                        if(playerList.get(currentPlayerIndex).)
                                }

                            }
                        }
                        break;


                }
            } else {
                do {
                    System.out.println();

                    System.out.println(STR."1: Would you like to pay $50 to leave jail?");
                    System.out.println(STR."2: Would you like to roll the dice?");
                    System.out.print("Please enter a valid selection:  ");
                    entry = scanner.nextLine().trim().toLowerCase();

                }
                while (!isNumber(entry) && !checkRange(entry, 1, 2));
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
        while(!isNumber(entry) || checkRange(entry, 2 , 8));

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
            while(!isNumber(entry) || checkRange(entry, 0, tokenList.size() - 1));

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

        boolean gameContinues = true;

        GameData gameData = new GameData();

        int currentPlayerIndex = 0;

        if(currentPlayerIndex == playerList.size() - 1) currentPlayerIndex = 0;
        else currentPlayerIndex++;

        System.out.println();
        System.out.println(STR."\{playerList.get(currentPlayerIndex).getToken()}'S TURN");

        // checks if player is in jail and remains in while loop until it is resolved
        while(playerList.get(currentPlayerIndex).isInJail()){
            isInJail(currentPlayerIndex, entry);
        }

        System.out.println();
        System.out.println("Rolling dice");

        int diceOne = ThreadLocalRandom.current().nextInt(1, 6 + 1);

        int diceTwo = ThreadLocalRandom.current().nextInt(1, 6 + 1);

        System.out.println(STR."First Dice Roll:  \{diceOne}");
        System.out.println(STR."Second Dice Roll: \{diceTwo}");

    }
}
