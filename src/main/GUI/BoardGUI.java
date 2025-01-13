package main.GUI;

import main.Data.GameData;
import main.Enums.PlayerToken;
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

public class BoardGUI extends JFrame{
    GameData gameData = new GameData();
    ArrayList<TokenBoardLocation> location = gameData.getLocation();

    public DrawCardGUI drawCardGUI;
    public JLayeredPane lLayeredPane; // used for dice
    public JLayeredPane rLayeredPane; // used for board/property

    public JLabel carMoney;
    JLabel catMoney;
    JLabel dogMoney;
    JLabel hatMoney;
    JLabel ironMoney;
    JLabel shipMoney;
    JLabel shoeMoney;
    JLabel thimbleMoney;

    public BoardGUI(Dice dice, LinkedHashMap<String, PropertyFinancials> propertyFinancialsMap, HashMap<Integer, String> singlePropertyBoardData,
                    LinkedHashMap<String, PropertyAttributes> propertyAttributesMap, PlayerList playerList, LocationProcessor locationProcessor) throws IOException {

        // left layered pane setup
        lLayeredPane = new JLayeredPane();
        lLayeredPane.setBackground(Color.WHITE);
        lLayeredPane.setBounds(0,0, 500, 1000);
        lLayeredPane.setOpaque(true);

        // right layered pane setup
        rLayeredPane = new JLayeredPane();
        rLayeredPane.setBounds(500,0, 1200, 1000);
        rLayeredPane.setOpaque(true);

        // initialize external main.GUI classes
        TokenGUI tokenGUI = new TokenGUI(rLayeredPane, locationProcessor);
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

        // money panel tracking
        moneyTable(playerList);

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

    // money panel tracking
    public void moneyTable(PlayerList playerList){
        // money panel tracking settings
        JPanel moneyPanel = new JPanel();
        moneyPanel.setBounds(270, 700, 450, 100);
        //moneyPanel.setBackground();
        moneyPanel.setOpaque(false);
        moneyPanel.setLayout(new GridLayout(2, 8));
        //moneyPanel.setBorder(BorderFactory);
        //moneyPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        moneyPanel.setVisible(true);
        moneyPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        rLayeredPane.add(moneyPanel, JLayeredPane.PALETTE_LAYER);

        JLabel car = new JLabel(STR."\{PlayerToken.CAR} $");
        JLabel cat = new JLabel(STR."\{PlayerToken.CAT} $");
        JLabel dog = new JLabel(STR."\{PlayerToken.DOG} $");
        JLabel hat = new JLabel(STR."\{PlayerToken.HAT} $");
        JLabel iron = new JLabel(STR."\{PlayerToken.IRON} $");
        JLabel ship = new JLabel(STR."\{PlayerToken.SHIP} $");
        JLabel shoe = new JLabel(STR."\{PlayerToken.SHOE} $");
        JLabel thimble = new JLabel(STR."\{PlayerToken.THIMBLE} $");
        thimble.setFont(new Font("Arial", Font.BOLD, 10));

        if(playerList.playerExists(PlayerToken.CAR)){
            carMoney = new JLabel(Integer.toString(playerList.getPlayer(PlayerToken.CAR).getCash()));
        } else{
            carMoney = new JLabel("NA");
        }

        if(playerList.playerExists(PlayerToken.CAT)){
            catMoney = new JLabel(Integer.toString(playerList.getPlayer(PlayerToken.CAT).getCash()));
        } else{
            catMoney = new JLabel("NA");
        }

        if(playerList.playerExists(PlayerToken.DOG)){
            dogMoney = new JLabel(Integer.toString(playerList.getPlayer(PlayerToken.DOG).getCash()));
        } else{
            dogMoney = new JLabel("NA");
        }

        if(playerList.playerExists(PlayerToken.HAT)){
            hatMoney = new JLabel(Integer.toString(playerList.getPlayer(PlayerToken.HAT).getCash()));
        } else{
            hatMoney = new JLabel("NA");
        }

        if(playerList.playerExists(PlayerToken.IRON)){
            ironMoney = new JLabel(Integer.toString(playerList.getPlayer(PlayerToken.IRON).getCash()));
        } else{
            ironMoney = new JLabel("NA");
        }

        if(playerList.playerExists(PlayerToken.SHIP)){
            shipMoney = new JLabel(Integer.toString(playerList.getPlayer(PlayerToken.SHIP).getCash()));
        } else{
            shipMoney = new JLabel("NA");
        }

        if(playerList.playerExists(PlayerToken.SHOE)){
            shoeMoney = new JLabel(Integer.toString(playerList.getPlayer(PlayerToken.SHOE).getCash()));
        } else{
            shoeMoney = new JLabel("NA");
        }

        if(playerList.playerExists(PlayerToken.THIMBLE)){
            thimbleMoney = new JLabel(Integer.toString(playerList.getPlayer(PlayerToken.THIMBLE).getCash()));
        } else{
            thimbleMoney = new JLabel("NA");
        }

        moneyPanel.add(car);
        moneyPanel.add(carMoney);
        moneyPanel.add(cat);
        moneyPanel.add(catMoney);
        moneyPanel.add(dog);
        moneyPanel.add(dogMoney);
        moneyPanel.add(hat);
        moneyPanel.add(hatMoney);
        moneyPanel.add(iron);
        moneyPanel.add(ironMoney);
        moneyPanel.add(ship);
        moneyPanel.add(shipMoney);
        moneyPanel.add(shoe);
        moneyPanel.add(shoeMoney);
        moneyPanel.add(thimble);
        moneyPanel.add(thimbleMoney);

        System.out.println(STR."Money Panel Components - \{moneyPanel.getComponentCount()}");
    }
}
