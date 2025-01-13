package main.GUI;

import main.Enums.BoardSpaceElement;
import main.Enums.PlayerToken;
import main.Functions.Player;
import main.Functions.PlayerList;
import main.LocationFunctions.LocationProcessor;
import main.LocationFunctions.TokenBoardLocation;
import main.Functions.Dice;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class DiceGUI{

    private final ArrayList<BufferedImage> diceImage;
    private final ArrayList<String> diceImageSrc;
    private final ArrayList<JLabel> diceLabelLeft;
    private final ArrayList<JLabel> diceLabelRight;

    private int locationIncrement;
    private int tokenIncrement;

    public DiceGUI(PlayerList playerList, JLayeredPane lLayeredPane, Dice dice, LocationProcessor locationProcessor) throws IOException {

        int diceSize = 30;
        int leftX = 135;
        int rightX = 170;
        int diceY = 30;
        int diceFaces = 6;  // 6 sided dice
        locationIncrement = 1;
        tokenIncrement = 1;

        diceImage = new ArrayList<>();
        diceImageSrc = new ArrayList<>(Arrays.asList(
                "src/main/MonopolyImages/DiceList/dice-1.512x512.png",
                "src/main/MonopolyImages/DiceList/dice-2.512x512.png",
                "src/main/MonopolyImages/DiceList/dice-3.512x512.png",
                "src/main/MonopolyImages/DiceList/dice-4.512x512.png",
                "src/main/MonopolyImages/DiceList/dice-5.512x512.png",
                "src/main/MonopolyImages/DiceList/dice-6.512x512.png"));
        diceLabelLeft = new ArrayList<>();
        diceLabelRight = new ArrayList<>();

        for(int i = 0; i < diceFaces; i++){

            diceImage.add(ImageIO.read(new File(diceImageSrc.get(i))));

            diceLabelLeft.add(new JLabel(new ImageIcon(diceImage.get(i).getScaledInstance(diceSize,diceSize, Image.SCALE_DEFAULT))));
            diceLabelLeft.get(i).setBounds(leftX,diceY,diceSize,diceSize);
            diceLabelLeft.get(i).setVisible(false);
            lLayeredPane.add(diceLabelLeft.get(i), JLayeredPane.PALETTE_LAYER);

            diceLabelRight.add(new JLabel(new ImageIcon(diceImage.get(i).getScaledInstance(diceSize,diceSize, Image.SCALE_DEFAULT))));
            diceLabelRight.get(i).setBounds(rightX,diceY,diceSize,diceSize);
            diceLabelRight.get(i).setVisible(false);
            lLayeredPane.add(diceLabelRight.get(i), JLayeredPane.PALETTE_LAYER);

        }

        //  roll button setup
        JButton rollButton = new JButton();
        rollButton.setBounds(30,30,100,30);
        rollButton.setText("Roll Dice");
        rollButton.setFocusable(false);

        lLayeredPane.add(rollButton, JLayeredPane.PALETTE_LAYER);

        rollButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dice.roll();

                for(int i = 0; i < diceFaces; i++){
                    diceLabelLeft.get(i).setVisible(false);
                    diceLabelRight.get(i).setVisible(false);
                }

                switch (dice.getDiceOne()){
                    case 1: diceLabelLeft.get(0).setVisible(true);
                        break;
                    case 2: diceLabelLeft.get(1).setVisible(true);
                        break;
                    case 3: diceLabelLeft.get(2).setVisible(true);
                        break;
                    case 4: diceLabelLeft.get(3).setVisible(true);
                        break;
                    case 5: diceLabelLeft.get(4).setVisible(true);
                        break;
                    case 6: diceLabelLeft.get(5).setVisible(true);
                        break;
                }

                switch (dice.getDiceTwo()){
                    case 1: diceLabelRight.get(0).setVisible(true);
                        break;
                    case 2: diceLabelRight.get(1).setVisible(true);
                        break;
                    case 3: diceLabelRight.get(2).setVisible(true);
                        break;
                    case 4: diceLabelRight.get(3).setVisible(true);
                        break;
                    case 5: diceLabelRight.get(4).setVisible(true);
                        break;
                    case 6: diceLabelRight.get(5).setVisible(true);
                        break;
                }

                // todo - remove this section after testing it increments tokens by one to each property
                // increments a token location by one every time the dice is rolled
                PlayerToken[] tokenList = PlayerToken.values();

                if(locationIncrement == 40){
                    locationIncrement = 0;
                }

                //tokenGUI.moveToken(tokenList[tokenIncrement],locationIncrement, location);
                locationProcessor.movePlayer(playerList, tokenList[tokenIncrement], BoardSpaceElement.values()[locationIncrement]);
                if(tokenIncrement == 3){
                    locationIncrement++;
                    tokenIncrement = 0;
                }

                tokenIncrement++;
            }
        });
    }
}
