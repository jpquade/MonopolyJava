package GUI;

import Enums.PlayerToken;
import Initialization.InitializeData;
import Misc.Dice;
import Misc.BoardLocation;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public class BoardGUI extends JFrame{

    JLabel carLabel;
    JLabel catLabel;
    JLabel dogLabel;
    JLabel hatLabel;
    JLabel ironLabel;
    JLabel shipLabel;
    JLabel shoeLabel;
    JLabel thimbleLabel;
    int locationIncrement = 0;
    InitializeData initializeData = new InitializeData();
    ArrayList<BoardLocation> location = initializeData.getLocation();

    public BoardGUI(Dice dice) throws IOException {

        // left layered pane setup
        JLayeredPane lLayeredPane = new JLayeredPane();
        lLayeredPane.setBackground(Color.WHITE);
        lLayeredPane.setBounds(0,0, 500, 1000);
        lLayeredPane.setOpaque(true);

        // right layered pane setup
        JLayeredPane rLayeredPane = new JLayeredPane();
        rLayeredPane.setBounds(500,0, 1200, 1000);
        rLayeredPane.setOpaque(true);

        // button setup
        JButton rollButton = new JButton();
        rollButton.setBounds(30,30,100,30);
        rollButton.setText("Roll Dice");
        rollButton.setFocusable(false);
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBounds(0,0,200, 100);
        buttonPanel.add(rollButton);

        lLayeredPane.add(rollButton, JLayeredPane.PALETTE_LAYER);

        // dice setup
        int diceSize = 30;
        int leftX = 135;
        int rightX = 170;
        int diceY = 30;

        BufferedImage dice1 = ImageIO.read(new File("src/GUI/dice-1.512x512.png"));
        BufferedImage dice2 = ImageIO.read(new File("src/GUI/dice-2.512x512.png"));
        BufferedImage dice3 = ImageIO.read(new File("src/GUI/dice-3.512x512.png"));
        BufferedImage dice4 = ImageIO.read(new File("src/GUI/dice-4.512x512.png"));
        BufferedImage dice5 = ImageIO.read(new File("src/GUI/dice-5.512x512.png"));
        BufferedImage dice6 = ImageIO.read(new File("src/GUI/dice-6.512x512.png"));

        JLabel dice1LeftLabel = new JLabel(new ImageIcon(dice1.getScaledInstance(diceSize,diceSize, Image.SCALE_DEFAULT)));
        JLabel dice2LeftLabel = new JLabel(new ImageIcon(dice2.getScaledInstance(diceSize,diceSize, Image.SCALE_DEFAULT)));
        JLabel dice3LeftLabel = new JLabel(new ImageIcon(dice3.getScaledInstance(diceSize,diceSize, Image.SCALE_DEFAULT)));
        JLabel dice4LeftLabel = new JLabel(new ImageIcon(dice4.getScaledInstance(diceSize,diceSize, Image.SCALE_DEFAULT)));
        JLabel dice5LeftLabel = new JLabel(new ImageIcon(dice5.getScaledInstance(diceSize,diceSize, Image.SCALE_DEFAULT)));
        JLabel dice6LeftLabel = new JLabel(new ImageIcon(dice6.getScaledInstance(diceSize,diceSize, Image.SCALE_DEFAULT)));

        JLabel dice1RightLabel = new JLabel(new ImageIcon(dice1.getScaledInstance(diceSize,diceSize, Image.SCALE_DEFAULT)));
        JLabel dice2RightLabel = new JLabel(new ImageIcon(dice2.getScaledInstance(diceSize,diceSize, Image.SCALE_DEFAULT)));
        JLabel dice3RightLabel = new JLabel(new ImageIcon(dice3.getScaledInstance(diceSize,diceSize, Image.SCALE_DEFAULT)));
        JLabel dice4RightLabel = new JLabel(new ImageIcon(dice4.getScaledInstance(diceSize,diceSize, Image.SCALE_DEFAULT)));
        JLabel dice5RightLabel = new JLabel(new ImageIcon(dice5.getScaledInstance(diceSize,diceSize, Image.SCALE_DEFAULT)));
        JLabel dice6RightLabel = new JLabel(new ImageIcon(dice6.getScaledInstance(diceSize,diceSize, Image.SCALE_DEFAULT)));

        dice1LeftLabel.setBounds(leftX,diceY,diceSize,diceSize);
        dice2LeftLabel.setBounds(leftX,diceY,diceSize,diceSize);
        dice3LeftLabel.setBounds(leftX,diceY,diceSize,diceSize);
        dice4LeftLabel.setBounds(leftX,diceY,diceSize,diceSize);
        dice5LeftLabel.setBounds(leftX,diceY,diceSize,diceSize);
        dice6LeftLabel.setBounds(leftX,diceY,diceSize,diceSize);

        dice1RightLabel.setBounds(rightX,diceY,diceSize,diceSize);
        dice2RightLabel.setBounds(rightX,diceY,diceSize,diceSize);
        dice3RightLabel.setBounds(rightX,diceY,diceSize,diceSize);
        dice4RightLabel.setBounds(rightX,diceY,diceSize,diceSize);
        dice5RightLabel.setBounds(rightX,diceY,diceSize,diceSize);
        dice6RightLabel.setBounds(rightX,diceY,diceSize,diceSize);

        dice1LeftLabel.setVisible(false);
        dice2LeftLabel.setVisible(false);
        dice3LeftLabel.setVisible(false);
        dice4LeftLabel.setVisible(false);
        dice5LeftLabel.setVisible(false);
        dice6LeftLabel.setVisible(false);

        dice1RightLabel.setVisible(false);
        dice2RightLabel.setVisible(false);
        dice3RightLabel.setVisible(false);
        dice4RightLabel.setVisible(false);
        dice5RightLabel.setVisible(false);
        dice6RightLabel.setVisible(false);

        lLayeredPane.add(dice1LeftLabel, JLayeredPane.PALETTE_LAYER);
        lLayeredPane.add(dice2LeftLabel, JLayeredPane.PALETTE_LAYER);
        lLayeredPane.add(dice3LeftLabel, JLayeredPane.PALETTE_LAYER);
        lLayeredPane.add(dice4LeftLabel, JLayeredPane.PALETTE_LAYER);
        lLayeredPane.add(dice5LeftLabel, JLayeredPane.PALETTE_LAYER);
        lLayeredPane.add(dice6LeftLabel, JLayeredPane.PALETTE_LAYER);

        lLayeredPane.add(dice1RightLabel, JLayeredPane.PALETTE_LAYER);
        lLayeredPane.add(dice2RightLabel, JLayeredPane.PALETTE_LAYER);
        lLayeredPane.add(dice3RightLabel, JLayeredPane.PALETTE_LAYER);
        lLayeredPane.add(dice4RightLabel, JLayeredPane.PALETTE_LAYER);
        lLayeredPane.add(dice5RightLabel, JLayeredPane.PALETTE_LAYER);
        lLayeredPane.add(dice6RightLabel, JLayeredPane.PALETTE_LAYER);

        // board setup
        BufferedImage board = ImageIO.read(new File("src/GUI/monopolyBoard.png"));
        JLabel mBoard = new JLabel(new ImageIcon(board.getScaledInstance(950,950, Image.SCALE_DEFAULT)));
        mBoard.setBounds(0,0, 1200, 950);
        mBoard.setVisible(true);
        rLayeredPane.add(mBoard, JLayeredPane.PALETTE_LAYER);

        // token setup
        int tokenSize = 40;

        BufferedImage car = ImageIO.read(new File("src/GUI/car.png"));
        BufferedImage cat = ImageIO.read(new File("src/GUI/cat.png"));
        BufferedImage dog = ImageIO.read(new File("src/GUI/dog.png"));
        BufferedImage hat = ImageIO.read(new File("src/GUI/hat.png"));
        BufferedImage iron = ImageIO.read(new File("src/GUI/iron.png"));
        BufferedImage ship = ImageIO.read(new File("src/GUI/ship.png"));
        BufferedImage shoe = ImageIO.read(new File("src/GUI/shoe.png"));
        BufferedImage thimble = ImageIO.read(new File("src/GUI/thimble.png"));

        carLabel = new JLabel(new ImageIcon(car.getScaledInstance(tokenSize,tokenSize, Image.SCALE_DEFAULT)));
        catLabel = new JLabel(new ImageIcon(cat.getScaledInstance(tokenSize,tokenSize, Image.SCALE_DEFAULT)));
        dogLabel = new JLabel(new ImageIcon(dog.getScaledInstance(tokenSize,tokenSize, Image.SCALE_DEFAULT)));
        hatLabel = new JLabel(new ImageIcon(hat.getScaledInstance(tokenSize,tokenSize, Image.SCALE_DEFAULT)));
        ironLabel = new JLabel(new ImageIcon(iron.getScaledInstance(tokenSize,tokenSize, Image.SCALE_DEFAULT)));
        shipLabel = new JLabel(new ImageIcon(ship.getScaledInstance(tokenSize,tokenSize, Image.SCALE_DEFAULT)));
        shoeLabel = new JLabel(new ImageIcon(shoe.getScaledInstance(tokenSize,tokenSize, Image.SCALE_DEFAULT)));
        thimbleLabel = new JLabel(new ImageIcon(thimble.getScaledInstance(tokenSize,tokenSize, Image.SCALE_DEFAULT)));

        //carLabel.setBounds(950,855,tokenSize,tokenSize);
        //catLabel.setBounds(950,885,tokenSize,tokenSize);
        //dogLabel.setBounds(950,915,tokenSize,tokenSize);

        //hatLabel.setBounds(985,855,tokenSize,tokenSize);
        //ironLabel.setBounds(985,885,tokenSize,tokenSize);
        //shipLabel.setBounds(985,915,tokenSize,tokenSize);

        //shoeLabel.setBounds(1020,855,tokenSize,tokenSize);
        //thimbleLabel.setBounds(1020,885,tokenSize,tokenSize);

        rLayeredPane.add(carLabel, JLayeredPane.MODAL_LAYER);
        rLayeredPane.add(catLabel, JLayeredPane.MODAL_LAYER);
        rLayeredPane.add(dogLabel, JLayeredPane.MODAL_LAYER);
        rLayeredPane.add(hatLabel, JLayeredPane.MODAL_LAYER);
        rLayeredPane.add(ironLabel, JLayeredPane.MODAL_LAYER);
        rLayeredPane.add(shipLabel, JLayeredPane.MODAL_LAYER);
        rLayeredPane.add(shoeLabel, JLayeredPane.MODAL_LAYER);
        rLayeredPane.add(thimbleLabel, JLayeredPane.MODAL_LAYER);

        carLabel.setVisible(true);
        catLabel.setVisible(true);
        dogLabel.setVisible(true);
        hatLabel.setVisible(true);
        ironLabel.setVisible(true);
        shipLabel.setVisible(true);
        shoeLabel.setVisible(true);
        thimbleLabel.setVisible(true);

        this.setIconImage(board);
        this.setTitle("Java Monopoly");
        this.setSize(1700, 1000);
        this.setLayout(null);
        this.add(lLayeredPane);
        this.add(rLayeredPane);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // keep at end
        this.setVisible(true); // keep at end

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

        rollButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dice.roll();

                dice1LeftLabel.setVisible(false);
                dice2LeftLabel.setVisible(false);
                dice3LeftLabel.setVisible(false);
                dice4LeftLabel.setVisible(false);
                dice5LeftLabel.setVisible(false);
                dice6LeftLabel.setVisible(false);

                dice1RightLabel.setVisible(false);
                dice2RightLabel.setVisible(false);
                dice3RightLabel.setVisible(false);
                dice4RightLabel.setVisible(false);
                dice5RightLabel.setVisible(false);
                dice6RightLabel.setVisible(false);

                switch (dice.getDiceOne()){
                    case 1: dice1LeftLabel.setVisible(true);
                        break;
                    case 2: dice2LeftLabel.setVisible(true);
                        break;
                    case 3: dice3LeftLabel.setVisible(true);
                        break;
                    case 4: dice4LeftLabel.setVisible(true);
                        break;
                    case 5: dice5LeftLabel.setVisible(true);
                        break;
                    case 6: dice6LeftLabel.setVisible(true);
                        break;
                }

                switch (dice.getDiceTwo()){
                    case 1: dice1RightLabel.setVisible(true);
                        break;
                    case 2: dice2RightLabel.setVisible(true);
                        break;
                    case 3: dice3RightLabel.setVisible(true);
                        break;
                    case 4: dice4RightLabel.setVisible(true);
                        break;
                    case 5: dice5RightLabel.setVisible(true);
                        break;
                    case 6: dice6RightLabel.setVisible(true);
                        break;
                }

                PlayerToken[] tokenList = PlayerToken.values();

                for (int i = 0; i < 8; i++){

                    moveToken(tokenList[i], locationIncrement);
                }

                locationIncrement++;

            }
        });
    }

    public void moveToken(PlayerToken playerToken, int locationIndex){
        int tokenSize = 40;

        ArrayList<Integer> locationList = location.get(locationIndex).addToken(playerToken);
        int xLoc = locationList.get(0);
        int yLoc = locationList.get(1);

        switch(playerToken){
            case PlayerToken.CAR :
                carLabel.setBounds(xLoc, yLoc, tokenSize, tokenSize);
                break;
            case PlayerToken.CAT :
                catLabel.setBounds(xLoc, yLoc, tokenSize, tokenSize);
                break;
            case PlayerToken.DOG:
                dogLabel.setBounds(xLoc, yLoc, tokenSize, tokenSize);
                break;
            case PlayerToken.HAT :
                hatLabel.setBounds(xLoc, yLoc, tokenSize, tokenSize);
                break;
            case PlayerToken.IRON :
                ironLabel.setBounds(xLoc, yLoc, tokenSize, tokenSize);
                break;
            case PlayerToken.SHIP :
                shipLabel.setBounds(xLoc, yLoc, tokenSize, tokenSize);
                break;
            case PlayerToken.SHOE :
                shoeLabel.setBounds(xLoc, yLoc, tokenSize, tokenSize);
                break;
            case PlayerToken.THIMBLE :
                thimbleLabel.setBounds(xLoc, yLoc, tokenSize, tokenSize);
                break;

        }
    }
}
