package GUI;

import Initialization.InitializeData;
import Misc.Dice;
import Misc.BoardLocation;
import Properties.PropertyAttributes;
import Properties.PropertyFinancials;

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

    InitializeData initializeData = new InitializeData();
    ArrayList<BoardLocation> location = initializeData.getLocation();

    DiceGUI diceGUI;
    PropertyGUI propertyGUI;
    TokenGUI tokenGUI;

    public BoardGUI(Dice dice, LinkedHashMap<String, PropertyFinancials> propertyFinancialsMap, HashMap<Integer, String> singlePropertyBoardData,
                    LinkedHashMap<String, PropertyAttributes> propertyAttributesMap) throws IOException {

        // left layered pane setup
        JLayeredPane lLayeredPane = new JLayeredPane();
        lLayeredPane.setBackground(Color.WHITE);
        lLayeredPane.setBounds(0,0, 500, 1000);
        lLayeredPane.setOpaque(true);

        // right layered pane setup
        JLayeredPane rLayeredPane = new JLayeredPane();
        rLayeredPane.setBounds(500,0, 1200, 1000);
        rLayeredPane.setOpaque(true);

//        // overProperyOverLay layered pane setup
//        JLayeredPane overProperyOverLay = new JLayeredPane();
//        overProperyOverLay.setBounds(0,0, 1700, 1000);
//        overProperyOverLay.setBackground(Color.BLACK);
//        overProperyOverLay.setOpaque(true);

        // initialize external GUI classes
        tokenGUI = new TokenGUI(rLayeredPane);
        diceGUI = new DiceGUI(lLayeredPane, dice, tokenGUI, location);
        propertyGUI = new PropertyGUI(rLayeredPane, propertyFinancialsMap, singlePropertyBoardData, propertyAttributesMap);

        // board setup
        BufferedImage board = ImageIO.read(new File("src/MonopolyImages/monopolyBoard.png"));
        JLabel mBoard = new JLabel(new ImageIcon(board.getScaledInstance(950,950, Image.SCALE_DEFAULT)));
        mBoard.setBounds(0,0, 1200, 950);
        mBoard.setVisible(true);
        rLayeredPane.add(mBoard, JLayeredPane.DEFAULT_LAYER);

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
