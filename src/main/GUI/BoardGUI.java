package main.GUI;

import main.Data.GameData;
import main.Misc.Dice;
import main.Misc.BoardLocation;
import main.Properties.PropertyAttributes;
import main.Properties.PropertyFinancials;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class BoardGUI extends JFrame{
    GameData gameData = new GameData();
    ArrayList<BoardLocation> location = gameData.getLocation();

    public DrawCardGUI drawCardGUI;
    public JLayeredPane rLayeredPane;

    public BoardGUI(Dice dice, LinkedHashMap<String, PropertyFinancials> propertyFinancialsMap, HashMap<Integer, String> singlePropertyBoardData,
                    LinkedHashMap<String, PropertyAttributes> propertyAttributesMap) throws IOException {

        // left layered pane setup
        JLayeredPane lLayeredPane = new JLayeredPane();
        lLayeredPane.setBackground(Color.WHITE);
        lLayeredPane.setBounds(0,0, 500, 1000);
        lLayeredPane.setOpaque(true);

        // right layered pane setup
        rLayeredPane = new JLayeredPane();
        rLayeredPane.setBounds(500,0, 1200, 1000);
        rLayeredPane.setOpaque(true);

        // initialize external main.GUI classes
        TokenGUI tokenGUI = new TokenGUI(rLayeredPane);
        DiceGUI diceGUI = new DiceGUI(lLayeredPane, dice, tokenGUI, location);
        PropertyGUI propertyGUI = new PropertyGUI(rLayeredPane, propertyFinancialsMap, singlePropertyBoardData, propertyAttributesMap);
        drawCardGUI = new DrawCardGUI(rLayeredPane);

        //drawCardGUI.guiSetup(rLayeredPane);

        // board setup
        BufferedImage board = ImageIO.read(new File("src/main/MonopolyImages/monopolyBoard.png"));
        JLabel mBoard = new JLabel(new ImageIcon(board.getScaledInstance(950,950, Image.SCALE_DEFAULT)));
        mBoard.setBounds(0,0, 1200, 950);
        mBoard.setVisible(true);
        rLayeredPane.add(mBoard, JLayeredPane.DEFAULT_LAYER);

        // back of chance card image
        int chanceSize = 230;
        BufferedImage rotateChanceCard = ImageIO.read(new File("src/main/MonopolyImages/ChanceCardBack45.png"));
        JLabel rotateChanceLabel = new JLabel(new ImageIcon(rotateChanceCard.getScaledInstance(chanceSize,chanceSize, Image.SCALE_DEFAULT)));
        rotateChanceLabel.setBounds(706,573, chanceSize, chanceSize);
        rotateChanceLabel.setVisible(true);
        rLayeredPane.add(rotateChanceLabel, JLayeredPane.PALETTE_LAYER);

        // back of community chest card image
        int communityChestSize = 240;
        BufferedImage rotateCommunityChestCard = ImageIO.read(new File("src/main/MonopolyImages/CommunityChestCardBack45.png"));
        JLabel rotateCommunityChestCardLabel = new JLabel(new ImageIcon(rotateCommunityChestCard.getScaledInstance(communityChestSize,communityChestSize, Image.SCALE_DEFAULT)));
        rotateCommunityChestCardLabel.setBounds(265,149, communityChestSize, communityChestSize);
        rotateCommunityChestCardLabel.setVisible(true);
        rLayeredPane.add(rotateCommunityChestCardLabel, JLayeredPane.PALETTE_LAYER);

        // board adjustments and setup
        this.setIconImage(board);
        this.setTitle("Java Monopoly");
        this.setSize(1700, 1000);
        this.setLayout(null);
        //this.add(overProperyOverLay);
        this.add(lLayeredPane);
        this.add(rLayeredPane);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // keep at end
        this.setVisible(true); // keep at end

        // temporary mouse location listener
        rLayeredPane.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();

                System.out.println(STR."X:\{x} Y:\{y}");
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }
}
