package GUI;

import Misc.Player;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;

public class DrawCardGUI {

    private final LinkedList<String> chanceCards;
    private final LinkedList<String> communityChestCards;

    public DrawCardGUI(LinkedList<String> chanceCards, LinkedList<String> communityChestCards, JLayeredPane pane) throws IOException {
        this.chanceCards = chanceCards;
        this.communityChestCards = communityChestCards;

        shuffleCards(chanceCards);
        shuffleCards(communityChestCards);

        guiSetup(chanceCards, pane);
        guiSetup(communityChestCards, pane);
    }

    private void guiSetup(LinkedList<String> cards, JLayeredPane pane) throws IOException {

        int imageWidth = 350;
        int imageHeight = 200;

        for (String card : cards) {

            String s = "src/MonopolyImages/" + card + ".png";
            BufferedImage image = ImageIO.read(new File(s));
            JLabel label = new JLabel(new ImageIcon(image.getScaledInstance(imageWidth, imageHeight, Image.SCALE_DEFAULT)));
            label.setBounds(420, 350, imageWidth, imageHeight);
            label.setVisible(false);
            pane.add(label, JLayeredPane.MODAL_LAYER);

        }
    }

    private void shuffleCards(LinkedList<String> cards){

        Collections.shuffle(cards);

    }

    public String drawACard(String s, Player player){
        if(s.equals("chance")){
            if(chanceCards.peek().equals("Chance_GOOJF")){
                player.setGetOutOfJailFreeCount(player.getGetOutOfJailFreeCount() + 1);
            }

            return chanceCards.pop();
        } else{
            return communityChestCards.pop();
        }
    }

}
