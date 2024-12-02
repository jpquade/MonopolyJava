package Misc;

import GamePlaying.TurnTracker;
import Properties.LocationProcessor;

public class PlayerProcessing {

    LocationProcessor locationProcessor;
    TurnTracker turnTracker;

    public PlayerProcessing(LocationProcessor locationProcessor, TurnTracker turnTracker){
        this.locationProcessor = locationProcessor;
        this.turnTracker = turnTracker;
    }

    public void movePlayerToLocation(Integer boardLocation){
        locationProcessor.locationProcessing(turnTracker.currentPlayer(), boardLocation);
    }

}
