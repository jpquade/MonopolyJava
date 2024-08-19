package GUI;

import Enums.PlayerToken;
import Misc.BoardLocation;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class TokenGUI {

    int tokenSize;
    ArrayList<BufferedImage> tokenImage;
    ArrayList<String> tokenImageSrc;
    ArrayList<JLabel> tokenLabel;

    public TokenGUI(JLayeredPane rLayeredPane) throws IOException {

        tokenSize = 40;
        tokenImage = new ArrayList<>();
        tokenImageSrc = new ArrayList<>(Arrays.asList("src/MonopolyImages/car.png", "src/MonopolyImages/cat.png",
                "src/MonopolyImages/dog.png", "src/MonopolyImages/hat.png", "src/MonopolyImages/iron.png", "src/MonopolyImages/ship.png",
                "src/MonopolyImages/shoe.png", "src/MonopolyImages/thimble.png"));
        tokenLabel = new ArrayList<>();

        for(int i = 0; i < 8; i++){

            tokenImage.add(ImageIO.read(new File(tokenImageSrc.get(i))));
            tokenLabel.add(new JLabel(new ImageIcon(tokenImage.get(i).getScaledInstance(tokenSize,tokenSize, Image.SCALE_DEFAULT))));
            rLayeredPane.add(tokenLabel.get(i), JLayeredPane.PALETTE_LAYER);
            tokenLabel.get(i).setVisible(true);
        }

    }

    public void moveToken(PlayerToken playerToken, int locationIndex, ArrayList<BoardLocation> location){

        ArrayList<Integer> locationList = location.get(locationIndex).addToken(playerToken);
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
}
