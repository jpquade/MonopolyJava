package main.GUI;

import main.Enums.BoardSpaceElement;
import main.Enums.PlayerToken;
import main.LocationFunctions.LocationProcessor;
import main.LocationFunctions.TokenBoardLocation;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.xml.stream.Location;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class TokenGUI {

    private final int tokenSize;
    private final ArrayList<BufferedImage> tokenImage;
    private final ArrayList<String> tokenImageSrc;
    private final ArrayList<JLabel> tokenLabel;
    private final LocationProcessor locationProcessor;

    public TokenGUI(JLayeredPane rLayeredPane, LocationProcessor locationProcessor) throws IOException {

        tokenSize = 40;
        tokenImage = new ArrayList<>();
        tokenImageSrc = new ArrayList<>(Arrays.asList(
                "src/main/MonopolyImages/Tokens/car.png",
                "src/main/MonopolyImages/Tokens/cat.png",
                "src/main/MonopolyImages/Tokens/dog.png",
                "src/main/MonopolyImages/Tokens/hat.png",
                "src/main/MonopolyImages/Tokens/iron.png",
                "src/main/MonopolyImages/Tokens/ship.png",
                "src/main/MonopolyImages/Tokens/shoe.png",
                "src/main/MonopolyImages/Tokens/thimble.png"));
        tokenLabel = new ArrayList<>();

        for(int i = 0; i < tokenImageSrc.size(); i++){

            tokenImage.add(ImageIO.read(new File(tokenImageSrc.get(i))));
            tokenLabel.add(new JLabel(new ImageIcon(tokenImage.get(i).getScaledInstance(tokenSize,tokenSize, Image.SCALE_DEFAULT))));
            rLayeredPane.add(tokenLabel.get(i), JLayeredPane.PALETTE_LAYER);
            tokenLabel.get(i).setVisible(true);
        }

        this.locationProcessor = locationProcessor;

    }

//    public void moveToken(PlayerToken playerToken, int locationIndex, ArrayList<TokenBoardLocation> location){
//
//        ArrayList<Integer> locationList = location.get(locationIndex).addToken(playerToken);
//        int xLoc = locationList.get(0);
//        int yLoc = locationList.get(1);
//
//        switch(playerToken){
//            case PlayerToken.CAR :
//                tokenLabel.get(0).setBounds(xLoc, yLoc, tokenSize, tokenSize);
//                break;
//            case PlayerToken.CAT :
//                tokenLabel.get(1).setBounds(xLoc, yLoc, tokenSize, tokenSize);
//                break;
//            case PlayerToken.DOG:
//                tokenLabel.get(2).setBounds(xLoc, yLoc, tokenSize, tokenSize);
//                break;
//            case PlayerToken.HAT :
//                tokenLabel.get(3).setBounds(xLoc, yLoc, tokenSize, tokenSize);
//                break;
//            case PlayerToken.IRON :
//                tokenLabel.get(4).setBounds(xLoc, yLoc, tokenSize, tokenSize);
//                break;
//            case PlayerToken.SHIP :
//                tokenLabel.get(5).setBounds(xLoc, yLoc, tokenSize, tokenSize);
//                break;
//            case PlayerToken.SHOE :
//                tokenLabel.get(6).setBounds(xLoc, yLoc, tokenSize, tokenSize);
//                break;
//            case PlayerToken.THIMBLE :
//                tokenLabel.get(7).setBounds(xLoc, yLoc, tokenSize, tokenSize);
//                break;
//
//        }
//    }

    public void moveToken(PlayerToken playerToken, BoardSpaceElement boardSpaceElement){

        ArrayList<Integer> locationList = locationProcessor.getBoardLocation(boardSpaceElement).addToken(playerToken);
        int xLoc = locationList.get(0);
        int yLoc = locationList.get(1);

        switch(playerToken){
            case PlayerToken.CAR :
                tokenLabel.get(0).setBounds(xLoc, yLoc, tokenSize, tokenSize);
                break;
            case PlayerToken.CAT :
                tokenLabel.get(1).setBounds(xLoc, yLoc, tokenSize, tokenSize);
                break;
            case PlayerToken.DOG:
                tokenLabel.get(2).setBounds(xLoc, yLoc, tokenSize, tokenSize);
                break;
            case PlayerToken.HAT :
                tokenLabel.get(3).setBounds(xLoc, yLoc, tokenSize, tokenSize);
                break;
            case PlayerToken.IRON :
                tokenLabel.get(4).setBounds(xLoc, yLoc, tokenSize, tokenSize);
                break;
            case PlayerToken.SHIP :
                tokenLabel.get(5).setBounds(xLoc, yLoc, tokenSize, tokenSize);
                break;
            case PlayerToken.SHOE :
                tokenLabel.get(6).setBounds(xLoc, yLoc, tokenSize, tokenSize);
                break;
            case PlayerToken.THIMBLE :
                tokenLabel.get(7).setBounds(xLoc, yLoc, tokenSize, tokenSize);
                break;

        }
    }

    // todo - add a overloaded method for moveToken that takes in a player token and a number to increment token by
}
