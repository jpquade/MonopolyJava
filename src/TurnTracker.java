import Enums.Token;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class TurnTracker {

    int numberOfPlayers;
    ArrayList<Player> playerList = new ArrayList<>();
    ArrayList<String> tokenList;
    ArrayList<Integer> randomPlayerList = new ArrayList<>();
    Token token = Token.NONE;

    public TurnTracker() {
        this.numberOfPlayers = 0;
        this.playerList = new ArrayList<>();
        this.tokenList = tokenList = new ArrayList<>();
        this.randomPlayerList = randomPlayerList = new ArrayList<>();
        this.token = Token.NONE;
    }

    public void turnProgression(){
        Scanner keyboard = new Scanner(System.in);

        tokenList = new ArrayList<>(Arrays.asList("DOG", "CAT", "BATTLESHIP", "PENGUIN", "RUBBERDUCKY", "TOPHAT", "RACECAR", "THIMBLE"));

        System.out.println();
        System.out.print("What is the number of players? ");

        numberOfPlayers = Integer.parseInt(keyboard.nextLine());

        System.out.println();

        for (int i = 0; i < numberOfPlayers; i++){
            System.out.println();
            System.out.println("########################################################");
            System.out.println(STR."Player \{i + 1}, which token do you want to use?");
            System.out.println();

            for(int j = 0; j < tokenList.size(); j++){
                System.out.println(STR."\{j}: \{tokenList.get(j)}");

            }

            System.out.println();
            System.out.print("Enter the number of the token you want to use: ");

            int entry = Integer.parseInt(keyboard.nextLine());

            playerList.add(new Player(Token.valueOf(tokenList.get(entry)),0,1500));
            tokenList.remove(entry);
        }
    }
}
