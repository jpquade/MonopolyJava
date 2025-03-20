package main.Functions;

import main.Enums.BoardSpaceElement;
import main.Enums.PlayerToken;
import main.GUI.TokenGUI;

public class LocationProcessor {

    private final TokenGUI tokenGui;

    public LocationProcessor(TokenGUI tokenGui){
        this.tokenGui = tokenGui;

    }

    public void locationProcessing(Player player, BoardSpaceElement boardSpaceElement){
        // empty - come up way of dealing with rental on property or buying it
        
        player.setBoardLocation(boardSpaceElement);
    }

    // when player moves to location and had to deal with actions on particular location
    public void locationProcessing(Player player, BoardSpaceElement boardSpaceElement, Integer paymentModification){
        // empty - come up way of dealing with rental on property or buying it

        player.setBoardLocation(boardSpaceElement);
    }

    // move player token to location
    public void movePlayer(PlayerProcessor playerProcessor, PlayerToken playerToken, BoardSpaceElement boardSpaceElement){
        tokenGui.moveToken(playerProcessor,playerToken, boardSpaceElement);
        playerProcessor.getPlayer(playerToken).setBoardLocation(boardSpaceElement);
    }
}
