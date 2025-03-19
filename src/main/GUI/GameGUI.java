package main.GUI;

import main.Data.GameData;
import main.Functions.Dice;
import main.Functions.PlayerProcessor;
import main.Functions.PropertyProcessor;
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
    private final JLayeredPane boardSidePane; // used for board

    public GameGUI(PropertyProcessor propertyProcessor ,Dice dice, InformationPane informationPane, BoardSidePaneGUI boardSidePane,
                   LinkedHashMap<String, PropertyFinancials> propertyFinancialsMap, HashMap<Integer, String> singlePropertyBoardData,
                   LinkedHashMap<String, PropertyAttributes> propertyAttributesMap, PlayerProcessor playerProcessor,
                   LocationProcessor locationProcessor, TransactionHistoryGUI transactionHistoryGUI) throws IOException {
        //this.tokenGUI = tokenGUI;

        this.boardSidePane = boardSidePane;

        // initialize external main.GUI classes
        DiceGUI diceGUI = new DiceGUI(playerProcessor, informationPane, dice, locationProcessor, transactionHistoryGUI);
        //PropertyProcessorGUI2 propertyProcessorGUI = new PropertyProcessorGUI2(propertyProcessor,boardSidePane, propertyFinancialsMap, singlePropertyBoardData, propertyAttributesMap);
        //PropertyProcessorGUI propertyProcessorGUI = new PropertyProcessorGUI(propertyProcessor, boardSidePane);
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

        // board adjustments and setup
        this.setIconImage(board);
        this.setTitle("Java Monopoly");
        this.setSize(1700, 1000);
        this.setLayout(null);
        //this.add(overProperyOverLay);
        this.add(informationPane);
        this.add(boardSidePane);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // keep at end
        this.setVisible(true); // keep at end

    }
}
