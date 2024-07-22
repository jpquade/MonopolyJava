import GamePlaying.TurnTracker;

import java.io.FileNotFoundException;


public class App {
    public static void main(String[] args) throws FileNotFoundException {
        TurnTracker turnTracker = new TurnTracker();

        turnTracker.turnProgression();
        
    }
}