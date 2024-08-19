package GUI;

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
import java.util.Arrays;

public class PropertyGUI {

    public PropertyGUI(JLayeredPane rLayeredPane) throws IOException {

        // property button setup
        ArrayList<JButton> propertyButtonsList = new ArrayList<>();
        ArrayList<Integer> xList = new ArrayList<>(Arrays.asList(875,718,562,483,327,249,128,128,128,128,128,128,128,128,249,405,483,561,639,717,796,874,953,953,953,953,953,953));
        ArrayList<Integer> yList = new ArrayList<>(Arrays.asList(826,826,826,826,826,826,749,671,593,515,437,359,202,124,3,3,3,3,3,3,3,3,123,202,358,436,593,749));

        // property button sizes
        int smallEdge = 77;
        int longEdge = 120;

        // single property display sizes
        int propertyScaleW = 400;
        int propertyScaleH = 400;

        // displays one property at a time for clicking on a board property
        BufferedImage singlePropertyDisplayImage = ImageIO.read(new File("src/MonopolyImages/monopolyPropertyBlank.png"));
        JLabel singlePropertyDisplayLabel = new JLabel(new ImageIcon(singlePropertyDisplayImage.getScaledInstance(propertyScaleW,propertyScaleH, Image.SCALE_DEFAULT)));
        singlePropertyDisplayLabel.setBounds(400,300,propertyScaleW,propertyScaleH);
        singlePropertyDisplayLabel.setVisible(false);
        singlePropertyDisplayLabel.setText(singlePropertyDisplayLabel.getText() + "somethingtttttttttttttttttttttttttttttttt");
        //singlePropertyDisplayLabel.set
        singlePropertyDisplayLabel.setVerticalAlignment(JLabel.CENTER);
        singlePropertyDisplayLabel.setHorizontalAlignment(JLabel.CENTER);
        rLayeredPane.add(singlePropertyDisplayLabel);

        JButton overLayButton = new JButton();
        overLayButton.setBounds(0,0, 1200, 950);
        overLayButton.setOpaque(false);
        overLayButton.setContentAreaFilled(false);
        overLayButton.setBorderPainted(false);
        overLayButton.setVisible(false);
        overLayButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Overlay set to false");
                overLayButton.setVisible(false);
                singlePropertyDisplayLabel.setVisible(false);
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

        rLayeredPane.add(overLayButton, JLayeredPane.POPUP_LAYER);



        for(int i = 0; i < xList.size(); i++){
            int index = i;

            propertyButtonsList.add(new JButton());
            JButton propButton = propertyButtonsList.get(i);
            if(i <= 5) propButton.setBounds(xList.get(i), yList.get(i), smallEdge, longEdge);
            else if(i <= 13) propButton.setBounds(xList.get(i), yList.get(i), longEdge, smallEdge);
            else if(i <= 21) propButton.setBounds(xList.get(i), yList.get(i), smallEdge, longEdge);
            else propButton.setBounds(xList.get(i), yList.get(i), longEdge, smallEdge);

            propButton.setFocusable(false);
            propButton.setOpaque(false);
            propButton.setContentAreaFilled(false);
            propButton.setBorderPainted(false);
            propButton.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    System.out.println("Overlay set to true");
                    overLayButton.setVisible(true);
                    singlePropertyDisplayLabel.setVisible(true);
                }

                @Override
                public void mousePressed(MouseEvent e) {

                }

                @Override
                public void mouseReleased(MouseEvent e) {

                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    //System.out.print("Entered: " + index);

                }

                @Override
                public void mouseExited(MouseEvent e) {
                    //System.out.println(" -- Exited: " + index);
                }
            });

            propButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("Element: " + index);

                }
            });
            rLayeredPane.add(propButton, JLayeredPane.MODAL_LAYER);
        }
    }


}
