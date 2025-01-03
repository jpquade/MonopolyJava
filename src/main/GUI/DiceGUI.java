package main.GUI;

import main.Enums.PlayerToken;
import main.Misc.BoardLocation;
import main.Misc.Dice;

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

    ArrayList<BufferedImage> diceImage;
    ArrayList<String> diceImageSrc;
    ArrayList<JLabel> diceLabelLeft;
    ArrayList<JLabel> diceLabelRight;

    int locationIncrement;
    int tokenIncrement;

    public DiceGUI(JLayeredPane lLayeredPane, Dice dice, TokenGUI tokenGUI, ArrayList<BoardLocation> location) throws IOException {

        int diceSize = 30;
        int leftX = 135;
        int rightX = 170;
        int diceY = 30;
        locationIncrement = 0;
        tokenIncrement = 1;

        diceImage = new ArrayList<>();
        diceImageSrc = new ArrayList<>(Arrays.asList("src/main/MonopolyImages/DiceList/dice-1.512x512.png", "src/main/MonopolyImages/DiceList/dice-2.512x512.png",
                "src/main/MonopolyImages/DiceList/dice-3.512x512.png", "src/main/MonopolyImages/DiceList/dice-4.512x512.png",
                "src/main/MonopolyImages/DiceList/dice-5.512x512.png", "src/main/MonopolyImages/DiceList/dice-6.512x512.png"));
        diceLabelLeft = new ArrayList<>();
        diceLabelRight = new ArrayList<>();

        for(int i = 0; i < 6; i++){

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

                for(int i = 0; i < 6; i++){
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

                PlayerToken[] tokenList = PlayerToken.values();

                //for (int i = 1; i < 9; i++){

                    tokenGUI.moveToken(tokenList[tokenIncrement],locationIncrement, location);
                    if(tokenIncrement == 8){
                        locationIncrement++;
                        tokenIncrement = 0;
                    }

                //}
                tokenIncrement++;

            }
        });
    }
}
