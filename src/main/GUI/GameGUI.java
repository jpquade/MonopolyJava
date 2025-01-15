package main.GUI;

import main.Data.GameData;
import main.Functions.Dice;
import main.Functions.PlayerList;
import main.LocationFunctions.LocationProcessor;
import main.LocationFunctions.TokenBoardLocation;
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

public class GameGUI extends JFrame{
    GameData gameData = new GameData();
    ArrayList<TokenBoardLocation> location = gameData.getLocation();

    public DrawCardGUI drawCardGUI;
    //public JLayeredPane lLayeredPane; // used for dice
    //private final JLayeredPane boardSidePane; // used for board
    //private TokenGUI tokenGUI;
    public MoneyGridGUI moneyGridGUI;

    public GameGUI(Dice dice,InformationPane informationPane,JLayeredPane boardSidePane, LinkedHashMap<String, PropertyFinancials> propertyFinancialsMap, HashMap<Integer, String> singlePropertyBoardData,
                   LinkedHashMap<String, PropertyAttributes> propertyAttributesMap, PlayerList playerList, LocationProcessor locationProcessor, TransactionHistoryGUI transactionHistoryGUI) throws IOException {
        //this.tokenGUI = tokenGUI;

        // left layered pane setup
//        informationSidePane = new JLayeredPane();
//        informationSidePane.setBackground(Color.WHITE);
//        informationSidePane.setBounds(0,0, 500, 1000);
//        informationSidePane.setOpaque(true);

        // boardSidePane layered pane setup
        //this.boardSidePane = boardSidePane;
        boardSidePane.setBounds(500,0, 1200, 1000);
        boardSidePane.setOpaque(true);

        // initialize external main.GUI classes
        DiceGUI diceGUI = new DiceGUI(playerList, informationPane, dice, locationProcessor, transactionHistoryGUI);
        PropertyGUI propertyGUI = new PropertyGUI(boardSidePane, propertyFinancialsMap, singlePropertyBoardData, propertyAttributesMap);
        drawCardGUI = new DrawCardGUI(boardSidePane);

        //drawCardGUI.guiSetup(boardSidePane);

        // board setup
        BufferedImage board = ImageIO.read(new File("src/main/MonopolyImages/monopolyBoard.png"));
        JLabel mBoard = new JLabel(new ImageIcon(board.getScaledInstance(950,950, Image.SCALE_DEFAULT)));
        mBoard.setBounds(0,0, 1200, 950);
        mBoard.setVisible(true);
        boardSidePane.add(mBoard, JLayeredPane.DEFAULT_LAYER);

        // back of chance card image
        int chanceSize = 230;
        BufferedImage rotateChanceCard = ImageIO.read(new File("src/main/MonopolyImages/ChanceCardBack45.png"));
        JLabel rotateChanceLabel = new JLabel(new ImageIcon(rotateChanceCard.getScaledInstance(chanceSize,chanceSize, Image.SCALE_DEFAULT)));
        rotateChanceLabel.setBounds(706,573, chanceSize, chanceSize);
        rotateChanceLabel.setVisible(true);
        boardSidePane.add(rotateChanceLabel, JLayeredPane.PALETTE_LAYER);

        // back of community chest card image
        int communityChestSize = 240;
        BufferedImage rotateCommunityChestCard = ImageIO.read(new File("src/main/MonopolyImages/CommunityChestCardBack45.png"));
        JLabel rotateCommunityChestCardLabel = new JLabel(new ImageIcon(rotateCommunityChestCard.getScaledInstance(communityChestSize,communityChestSize, Image.SCALE_DEFAULT)));
        rotateCommunityChestCardLabel.setBounds(265,149, communityChestSize, communityChestSize);
        rotateCommunityChestCardLabel.setVisible(true);
        boardSidePane.add(rotateCommunityChestCardLabel, JLayeredPane.PALETTE_LAYER);

        // money panel tracking
        //moneyTable(playerList);
        moneyGridGUI =  new MoneyGridGUI(playerList, boardSidePane);

        // board adjustments and setup
        this.setIconImage(board);
        this.setTitle("Java Monopoly");
        this.setSize(1700, 1000);
        this.setLayout(null);
        //this.add(overProperyOverLay);
        this.add(informationPane.getInformationSidePane());
        this.add(boardSidePane);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // keep at end
        this.setVisible(true); // keep at end

        // temporary mouse location listener
        boardSidePane.addMouseListener(new MouseListener() {
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
