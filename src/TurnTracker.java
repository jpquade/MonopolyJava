import Enums.Token;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class TurnTracker {

    private int numberOfPlayers;
    private final ArrayList<Player> playerList;
    private final ArrayList<String> tokenList;
    private ArrayList<Integer> randomPlayerList;
    private final Scanner scanner;

    public TurnTracker() {
        numberOfPlayers = 0;
        playerList = new ArrayList<>();
        tokenList = new ArrayList<>(Arrays.asList("DOG", "CAT", "BATTLESHIP", "PENGUIN", "RUBBERDUCKY", "TOPHAT", "RACECAR", "THIMBLE"));
        randomPlayerList = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    private boolean isInteger(String s) {
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

    private boolean between(String s){
        return Integer.parseInt(s) < 2 || 8 < Integer.parseInt(s);
    }

    public void turnProgression(){

        String entry = "";

//        do{
//            System.out.println();
//            System.out.print("What is the number of players(Make sure to only enter a valid number \"2-8\")? ");
//            entry = scanner.nextLine().trim();
//        }
//        while(!isInteger(entry) || between(entry));
//
//        numberOfPlayers = Integer.parseInt(entry);
        boolean isNumber = false;
        int value = 0;
        while(!isInteger(entry) || between(entry)){
            System.out.println();
            System.out.print("What is the number of players(Make sure to only enter a valid number \"2-8\")? ");
            entry = scanner.nextLine().trim();

            if(isInteger(entry)){

            }
        }
        numberOfPlayers = Integer.parseInt(entry);

        System.out.println();

        for (int index = 0; index < numberOfPlayers; index++){
            System.out.println();
            System.out.println("########################################################");
            System.out.println(STR."Player \{index + 1}, which token do you want to use?");
            System.out.println();

            for(int tokenIndex = 0; tokenIndex < tokenList.size(); tokenIndex++){
                System.out.println(STR."\{tokenIndex}: \{tokenList.get(tokenIndex)}");
            }
                int playerNumber = index + 1;

            System.out.println();
            System.out.print("Enter the number of the token you want to use: ");

            int tokenNumber = Integer.parseInt(scanner.nextLine().trim());

            playerList.add(new Player(playerNumber, Token.valueOf(tokenList.get(tokenNumber)),0,1500));
            tokenList.remove(tokenNumber);

            System.out.println();
            System.out.println(STR."Player \{playerNumber} is the \{playerList.get(index).getToken()}");
        }

        System.out.println();
        Iterator<Player> iterator = playerList.iterator();

//        while(iterator.hasNext()){
//            System.out.println(iterator.next() + " ");
//        }
        // randomize which player starts



    }
}
