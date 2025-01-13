package main.Functions;

import main.Enums.BoardSpaceElement;
import main.GameProcessor.TurnTracker;
import main.LocationFunctions.LocationProcessor;

public class PlayerProcessor {

    LocationProcessor locationProcessor;
    TurnTracker turnTracker;

    public PlayerProcessor(LocationProcessor locationProcessor, TurnTracker turnTracker){
        this.locationProcessor = locationProcessor;
        this.turnTracker = turnTracker;
    }

    public void movePlayerToLocation(BoardSpaceElement boardSpaceElement){
        locationProcessor.locationProcessing(turnTracker.currentPlayer(), boardSpaceElement);
    }

}
