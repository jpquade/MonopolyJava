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

            playerList.add(new Player(playerNumber, Token.valueOf(tokenList.get(tokenNumber)),0,1500, false, 0, 0));
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

        ArrayList<String> jailOptions = new ArrayList<>();
        jailOptions.add("Would you like to use your \"Get Out of Jail Free\" card?");
        jailOptions.add("Would you like to pay $50 to leave jail?");
        jailOptions.add("Would you like to roll the dice?");

        if(playerList.get(currentPlayerIndex).isInJail()) {
            if (playerList.get(currentPlayerIndex).getGetOutOfJailFreeCount() > 0){
                do {
                    System.out.println();
                    System.out.println(STR."1: \{jailOptions.get(0)}");
                    System.out.println(STR."2: \{jailOptions.get(1)}");
                    System.out.println(STR."3: \{jailOptions.get(2)}");
                    System.out.print("Please enter a valid selection:  ");
                    entry = scanner.nextLine().trim().toLowerCase();

                }
                while (!isNumber(entry) && !checkRange(entry, 1,3));

            }
            int jailSelection = Integer.parseInt(entry);

            switch(jailSelection){
                case 1:

                    break;
                case 2:
                    break;
                case 3:
                    break;
            }
        }

        System.out.println();
        System.out.println("Rolling dice");

        int diceOne = ThreadLocalRandom.current().nextInt(1, 6 + 1);

        int diceTwo = ThreadLocalRandom.current().nextInt(1, 6 + 1);

        System.out.println(STR."First Dice Roll:  \{diceOne}");
        System.out.println(STR."Second Dice Roll: \{diceTwo}");

    }
}
