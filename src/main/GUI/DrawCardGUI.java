package main.GUI;

import main.Enums.Chance;
import main.Enums.CommunityChest;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class DrawCardGUI {

    private final LinkedList<Chance> chanceCards;
    private final LinkedList<CommunityChest> communityChestCards;

    private final HashMap<String, JLabel> chanceLabelMap;
    private final HashMap<String, JLabel> communityChestLabelMap;

    private JLayeredPane chanceCardPane;
    private JLayeredPane communityChestCardPane;

    InvisibleBoardButtonGUI chanceInvisibleButton;
    InvisibleBoardButtonGUI communityChestInvisibleButton;

    //JButton overLayButton;

    // pane is the right layered pane for the monopoly board
    public DrawCardGUI(JLayeredPane pane) throws IOException {

        chanceCards = new LinkedList<>();
        chanceCards.addAll(Arrays.asList(Chance.values()));

        communityChestCards = new LinkedList<>();
        communityChestCards.addAll(Arrays.asList(CommunityChest.values()));

        chanceLabelMap = new HashMap<>();
        communityChestLabelMap = new HashMap<>();

        // shuffle the cards
        Collections.shuffle(chanceCards);
        Collections.shuffle(communityChestCards);

        chanceGuiSetup(pane, chanceLabelMap);
        communityChestGuiSetup(pane, communityChestLabelMap);

        // setup invisible overlay buttons
        chanceInvisibleButton = new InvisibleBoardButtonGUI(chanceCardPane, chanceLabelMap);
        communityChestInvisibleButton = new InvisibleBoardButtonGUI(chanceCardPane, communityChestLabelMap);

        // add the invisible overlay buttons to the card pane
        pane.add(chanceInvisibleButton);
        pane.add(communityChestInvisibleButton);
    }


    private void chanceGuiSetup(JLayeredPane pane, HashMap<String, JLabel> labelMap) throws IOException {

        int imageWidth = 350;
        int imageHeight = 200;

        // layered pane for chance cards
        chanceCardPane = new JLayeredPane();
        chanceCardPane.setVisible(false);     // set this cardPane.setVisible() to true to view the cards 1/2
        pane.add(chanceCardPane, JLayeredPane.POPUP_LAYER);
        chanceCardPane.setBounds(450,350,imageWidth,imageHeight);

        for (Chance card : Chance.values()) {
            // creates a path to the chance card image
            String cardString = card.toString();
            String chancePartialPath = "ChanceList/Chance_" + cardString;
            String s = "src/main/MonopolyImages/" + chancePartialPath + ".png";
            BufferedImage image = ImageIO.read(new File(s));

            // creates a label for the chance card image
            labelMap.put(cardString, new JLabel(new ImageIcon(image.getScaledInstance(imageWidth, imageHeight, Image.SCALE_DEFAULT))));
            labelMap.get(cardString).setBounds(0, 0, imageWidth, imageHeight);
            labelMap.get(cardString).setVisible(false); // set this cardPane.setVisible() to true to view the cards 2/2
            chanceCardPane.add(labelMap.get(cardString), JLayeredPane.DEFAULT_LAYER);
        }
    }

    private void communityChestGuiSetup(JLayeredPane pane, HashMap<String, JLabel> labelMap) throws IOException {

        int imageWidth = 350;
        int imageHeight = 200;

        // layered pane for chance cards
        communityChestCardPane = new JLayeredPane();
        communityChestCardPane.setVisible(false);     // set this cardPane.setVisible() to true to view the cards 1/2
        pane.add(communityChestCardPane, JLayeredPane.POPUP_LAYER);
        communityChestCardPane.setBounds(450,350,imageWidth,imageHeight);

        for (CommunityChest card : CommunityChest.values()) {
            // creates a path to the chance card image
            String cardString = card.toString();
            String communityChestPartialPath = "CommunityChestList/Community_Chest_" + cardString;
            String s = "src/main/MonopolyImages/" + communityChestPartialPath + ".png";
            BufferedImage image = ImageIO.read(new File(s));

            // creates a label for the chance card image
            labelMap.put(cardString, new JLabel(new ImageIcon(image.getScaledInstance(imageWidth, imageHeight, Image.SCALE_DEFAULT))));
            labelMap.get(cardString).setBounds(0, 0, imageWidth, imageHeight);
            labelMap.get(cardString).setVisible(false); // set this cardPane.setVisible() to true to view the cards 2/2
            communityChestCardPane.add(labelMap.get(cardString), JLayeredPane.DEFAULT_LAYER);
        }
    }

    /**
     * Draws a chance card and processes the action associated with it.
     *
     * @return The drawn chance card.
     */
    public Chance drawAChanceCard(){

        // sets the pane which contains the card images to visible
        chanceCardPane.setVisible(true);
        // sets the invisible overlay button to visible
        chanceInvisibleButton.setVisible(true);

        Chance chanceCard = chanceCards.pop();
        chanceCards.addLast(chanceCard);

        chanceLabelMap.get(chanceCard.toString()).setVisible(true);
        return chanceCard;
    }

    /**
     * Draws a community chest card and processes the action associated with it.
     *
     * @return The drawn community chest card.
     */
    public CommunityChest drawACommunityChestCard(){

        // sets the pane which contains the card images to visible
        communityChestCardPane.setVisible(true);
        // sets the invisible overlay button to visible
        communityChestInvisibleButton.setVisible(true);

        CommunityChest communityChestCard = communityChestCards.pop();
        communityChestCards.addLast(communityChestCard);

        communityChestLabelMap.get(communityChestCard.toString()).setVisible(true);
        return communityChestCard;
    }
}
