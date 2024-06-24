import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class TurnTracker {

    int numberOfPlayers;

    public void turnProgression(){
        Scanner keyboard = new Scanner(System.in);

        ArrayList<Player> playerList = new ArrayList<>();
        ArrayList<String> tokenList;

        tokenList = new ArrayList<>(Arrays.asList("DOG", "CAT", "BATTLESHIP", "PENGUIN", "RUBBERDUCKY", "TOPHAT", "RACECAR", "THIMBLE"));

        System.out.println("What is the number of players?");
        numberOfPlayers = keyboard.nextInt();

        System.out.println(numberOfPlayers);

        for (int i = 0; i < numberOfPlayers; i++){
            System.out.println("Player" + i + ": " + "which token do you want to play?");

            for(int j = 0; j < tokenList.size(); j++){
                System.out.println("");
            }




            playerList(new Player(,0,1500));
        }
    }
}
