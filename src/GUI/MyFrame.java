package GUI;

import Misc.Dice;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;



public class MyFrame extends JFrame{

    private Dice dice;

    private BufferedImage dice1;

    public MyFrame() throws IOException {

        dice = new Dice();

        // dice button logic
        JButton button = new JButton();
        button.setBounds(30,30,100,30);
        //button.addActionListener(e -> System.out.println("Test"));
        button.setText("Roll Dice");
        button.setFocusable(false);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBounds(0,0,200, 100);
        buttonPanel.add(button);

        JLabel myLabel2 = new JLabel();
        //myLabel.set

        JLayeredPane lLayeredPane = new JLayeredPane();
        lLayeredPane.setBackground(Color.WHITE);
        lLayeredPane.setBounds(0,0, 500, 1000);
        lLayeredPane.setOpaque(true);
        lLayeredPane.add(button, JLayeredPane.PALETTE_LAYER);

        // dice image setup
        BufferedImage dice1 = ImageIO.read(new File("dice-1.512x512.png"));
        JLabel dice1LeftLabel = new JLabel(new ImageIcon(dice1.getScaledInstance(30,30, Image.SCALE_DEFAULT)));
        dice1LeftLabel.setBounds(130,21,50,50);
        dice1LeftLabel.setVisible(false);
        lLayeredPane.add(dice1LeftLabel, JLayeredPane.PALETTE_LAYER);

        JLabel dice1RightLabel = new JLabel(new ImageIcon(dice1.getScaledInstance(30,30, Image.SCALE_DEFAULT)));
        dice1RightLabel.setBounds(165,21,50,50);
        dice1RightLabel.setVisible(false);
        lLayeredPane.add(dice1RightLabel, JLayeredPane.PALETTE_LAYER);

        BufferedImage dice2 = ImageIO.read(new File("dice-2.512x512.png"));
        JLabel dice2LeftLabel = new JLabel(new ImageIcon(dice2.getScaledInstance(30,30, Image.SCALE_DEFAULT)));
        dice2LeftLabel.setBounds(130,21,50,50);
        dice2LeftLabel.setVisible(false);
        lLayeredPane.add(dice2LeftLabel, JLayeredPane.PALETTE_LAYER);

        JLabel dice2RightLabel = new JLabel(new ImageIcon(dice2.getScaledInstance(30,30, Image.SCALE_DEFAULT)));
        dice2RightLabel.setBounds(165,21,50,50);
        dice2RightLabel.setVisible(false);
        lLayeredPane.add(dice2RightLabel, JLayeredPane.PALETTE_LAYER);

        BufferedImage dice3 = ImageIO.read(new File("dice-3.512x512.png"));
        JLabel dice3LeftLabel = new JLabel(new ImageIcon(dice3.getScaledInstance(30,30, Image.SCALE_DEFAULT)));
        dice3LeftLabel.setBounds(130,21,50,50);
        dice3LeftLabel.setVisible(false);
        lLayeredPane.add(dice3LeftLabel, JLayeredPane.PALETTE_LAYER);

        JLabel dice3RightLabel = new JLabel(new ImageIcon(dice3.getScaledInstance(30,30, Image.SCALE_DEFAULT)));
        dice3RightLabel.setBounds(165,21,50,50);
        dice3RightLabel.setVisible(false);
        lLayeredPane.add(dice3RightLabel, JLayeredPane.PALETTE_LAYER);

        BufferedImage dice4 = ImageIO.read(new File("dice-4.512x512.png"));
        JLabel dice4LeftLabel = new JLabel(new ImageIcon(dice4.getScaledInstance(30,30, Image.SCALE_DEFAULT)));
        dice4LeftLabel.setBounds(130,21,50,50);
        dice4LeftLabel.setVisible(false);
        lLayeredPane.add(dice4LeftLabel, JLayeredPane.PALETTE_LAYER);

        JLabel dice4RightLabel = new JLabel(new ImageIcon(dice4.getScaledInstance(30,30, Image.SCALE_DEFAULT)));
        dice4RightLabel.setBounds(165,21,50,50);
        dice4RightLabel.setVisible(false);
        lLayeredPane.add(dice4RightLabel, JLayeredPane.PALETTE_LAYER);

        BufferedImage dice5 = ImageIO.read(new File("dice-5.512x512.png"));
        JLabel dice5LeftLabel = new JLabel(new ImageIcon(dice5.getScaledInstance(30,30, Image.SCALE_DEFAULT)));
        dice5LeftLabel.setBounds(130,21,50,50);
        dice5LeftLabel.setVisible(false);
        lLayeredPane.add(dice5LeftLabel, JLayeredPane.PALETTE_LAYER);

        JLabel dice5RightLabel = new JLabel(new ImageIcon(dice5.getScaledInstance(30,30, Image.SCALE_DEFAULT)));
        dice5RightLabel.setBounds(165,21,50,50);
        dice5RightLabel.setVisible(false);
        lLayeredPane.add(dice5RightLabel, JLayeredPane.PALETTE_LAYER);

        BufferedImage dice6 = ImageIO.read(new File("dice-6.512x512.png"));
        JLabel dice6LeftLabel = new JLabel(new ImageIcon(dice6.getScaledInstance(30,30, Image.SCALE_DEFAULT)));
        dice6LeftLabel.setBounds(130,21,50,50);
        dice6LeftLabel.setVisible(false);
        lLayeredPane.add(dice6LeftLabel, JLayeredPane.PALETTE_LAYER);

        JLabel dice6RightLabel = new JLabel(new ImageIcon(dice6.getScaledInstance(30,30, Image.SCALE_DEFAULT)));
        dice6RightLabel.setBounds(165,21,50,50);
        dice6RightLabel.setVisible(false);
        lLayeredPane.add(dice6RightLabel, JLayeredPane.PALETTE_LAYER);

        //JPanel lPanel = new JPanel();
        //lPanel.setBackground(Color.BLUE);
        //lPanel.setBounds(200,200, 500, 1000);

        BufferedImage myPicture = ImageIO.read(new File("monopolyBoard.png"));
        JLabel myLabel = new JLabel(new ImageIcon(myPicture.getScaledInstance(950,950, Image.SCALE_DEFAULT)));

        JPanel rPanel = new JPanel();
        rPanel.setBounds(500,0, 1200, 1000);
        rPanel.add(myLabel);
        //rPanel.add(button);

        this.setTitle("Java Monopoly");
        this.setSize(1700, 1000);
        this.setLayout(null);

        ImageIcon icon = new ImageIcon("monopolyBoard.png");


        this.setIconImage(icon.getImage());
        this.add(lLayeredPane);
        this.add(rPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // keep at end
        this.setVisible(true); // keep at end


        button.addActionListener(new ActionListener() {
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

            }
        });
    }
}
