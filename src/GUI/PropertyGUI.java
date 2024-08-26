package GUI;

import Enums.PropertyColor;
import Properties.PropertyAttributes;
import Properties.PropertyFinancials;

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
import java.util.HashMap;
import java.util.LinkedHashMap;

public class PropertyGUI {

    public PropertyGUI(JLayeredPane rLayeredPane, LinkedHashMap<String, PropertyFinancials> propertyFinancialsMap, HashMap<Integer,
            String> singlePropertyBoardData,LinkedHashMap<String, PropertyAttributes> propertyAttributesMap) throws IOException {

        // property buttons and positions
        ArrayList<JButton> propertyButtonsList = new ArrayList<>();
        ArrayList<Integer> xPropButtonList = new ArrayList<>(Arrays.asList(875,718,562,483,327,249,128,128,128,128,128,128,128,128,249,405,483,561,639,717,796,874,953,953,953,953,953,953));
        ArrayList<Integer> yPropButtonList = new ArrayList<>(Arrays.asList(826,826,826,826,826,826,749,671,593,515,437,359,202,124,3,3,3,3,3,3,3,3,123,202,358,436,593,749));

        // large property display and positions of text
        ArrayList<JLabel> largePropertyLabelList = new ArrayList<>();
        ArrayList<Integer> xLargePropertyPaneList = new ArrayList<>(Arrays.asList(50,250,269,269,269,0,0,0,0,0,0,0,23,0,0,0,0,0,0));
        ArrayList<Integer> yLargePropertyPaneList = new ArrayList<>(Arrays.asList(-27,-62,-39,-16,7,47,68,89,110,-140,165,-92,25,0,0,0,0,0,0));
        ArrayList<Float> largePropertyTextSizeList = new ArrayList<>(Arrays.asList(17.0F,17.0F,17.0F,17.0F,17.0F,18.0F,18.0F,18.0F,18.0F,26.0F,10.0F,18.0F));

        // count for all properties/railroads/utilities
        int allLargePropertyViewSize = xLargePropertyPaneList.size();

        // count without railroads/utilities
        int noRRULargePropertyViewSize = xLargePropertyPaneList.size() - 6;

        // property button sizes
        int smallEdge = 77;
        int longEdge = 120;

        // single property display sizes
        int propertyScaleW = 350;
        int propertyScaleH = 400;

        // utility label index and index location according to property only list
        int electricCompanyLabelIndex = 13;
        int electricCompanyShortBoardIndex = 7;

        int waterWorksLabelIndex = 14;
        int waterWorksLabelShortBoardIndex = 19;

        // RR label index and index location according to property only list
        int readingRailRoadLabelIndex = 15;
        int readingRailRoadShortBoardIndex = 2;

        int pennsylvaniaRailRoadLabelIndex = 16;
        int pennsylvaniaRailRoadShortBoardIndex = 10;

        int bAndORailRoadLabelIndex = 17;
        int bAndORailRoadShortBoardIndex = 17;

        int shortLineRailRoadLabelIndex = 18;
        int shortLineRailRoadLabelShortBoardIndex = 25;

        // displays one property at a time for clicking on a board property
        BufferedImage singlePropertyDisplayImage = ImageIO.read(new File("src/MonopolyImages/monopolyPropertyBlank.png"));
        JLabel singlePropertyDisplayLabel = new JLabel(new ImageIcon(singlePropertyDisplayImage.getScaledInstance(propertyScaleW,propertyScaleH, Image.SCALE_SMOOTH)));
        singlePropertyDisplayLabel.setBounds(0,0,propertyScaleW,propertyScaleH);
        singlePropertyDisplayLabel.setHorizontalAlignment(0);
        singlePropertyDisplayLabel.setVisible(false);

        JLayeredPane propertyPane = new JLayeredPane();
        propertyPane.add(singlePropertyDisplayLabel, JLayeredPane.DEFAULT_LAYER);
        propertyPane.setBounds(400,250,propertyScaleW,propertyScaleH);
        rLayeredPane.add(propertyPane);

        // create empty label template for adding large property view
        for(int i = 0; i < allLargePropertyViewSize; i++){

            if(i == electricCompanyLabelIndex){
                BufferedImage electricCompanyImage = ImageIO.read(new File("src/MonopolyImages/ElectricCompany.png"));
                largePropertyLabelList.add(new JLabel(new ImageIcon(electricCompanyImage.getScaledInstance(propertyScaleW,propertyScaleH, Image.SCALE_SMOOTH))));
                largePropertyLabelList.get(electricCompanyLabelIndex).setVisible(false);
                largePropertyLabelList.get(electricCompanyLabelIndex).setBounds(xLargePropertyPaneList.get(i), yLargePropertyPaneList.get(i), propertyScaleW, propertyScaleH);
                propertyPane.add(largePropertyLabelList.get(i), JLayeredPane.PALETTE_LAYER);
            }
            else if(i == waterWorksLabelIndex){
                BufferedImage waterWorksImage = ImageIO.read(new File("src/MonopolyImages/WaterWorks.png"));
                largePropertyLabelList.add(new JLabel(new ImageIcon(waterWorksImage.getScaledInstance(propertyScaleW,propertyScaleH, Image.SCALE_SMOOTH))));
                largePropertyLabelList.get(waterWorksLabelIndex).setVisible(false);
                largePropertyLabelList.get(waterWorksLabelIndex).setBounds(xLargePropertyPaneList.get(i), yLargePropertyPaneList.get(i), propertyScaleW, propertyScaleH);
                propertyPane.add(largePropertyLabelList.get(i), JLayeredPane.PALETTE_LAYER);
            }
            else if(i == readingRailRoadLabelIndex){
                BufferedImage readingRRImage = ImageIO.read(new File("src/MonopolyImages/ReadingRR.jpg"));
                largePropertyLabelList.add(new JLabel(new ImageIcon(readingRRImage.getScaledInstance(propertyScaleW,propertyScaleH, Image.SCALE_SMOOTH))));
                largePropertyLabelList.get(readingRailRoadLabelIndex).setVisible(false);
                largePropertyLabelList.get(readingRailRoadLabelIndex).setBounds(xLargePropertyPaneList.get(i), yLargePropertyPaneList.get(i), propertyScaleW, propertyScaleH);
                propertyPane.add(largePropertyLabelList.get(i), JLayeredPane.PALETTE_LAYER);
            }
            else if(i == pennsylvaniaRailRoadLabelIndex){
                BufferedImage pennsylvaniaRRImage = ImageIO.read(new File("src/MonopolyImages/PennsylvaniaRR.jpg"));
                largePropertyLabelList.add(new JLabel(new ImageIcon(pennsylvaniaRRImage.getScaledInstance(propertyScaleW,propertyScaleH, Image.SCALE_SMOOTH))));
                largePropertyLabelList.get(pennsylvaniaRailRoadLabelIndex).setVisible(false);
                largePropertyLabelList.get(pennsylvaniaRailRoadLabelIndex).setBounds(xLargePropertyPaneList.get(i), yLargePropertyPaneList.get(i), propertyScaleW, propertyScaleH);
                propertyPane.add(largePropertyLabelList.get(i), JLayeredPane.PALETTE_LAYER);
            }
            else if(i == bAndORailRoadLabelIndex){
                BufferedImage bAndORRImage = ImageIO.read(new File("src/MonopolyImages/BandORR.jpg"));
                largePropertyLabelList.add(new JLabel(new ImageIcon(bAndORRImage.getScaledInstance(propertyScaleW,propertyScaleH, Image.SCALE_SMOOTH))));
                largePropertyLabelList.get(bAndORailRoadLabelIndex).setVisible(false);
                largePropertyLabelList.get(bAndORailRoadLabelIndex).setBounds(xLargePropertyPaneList.get(i), yLargePropertyPaneList.get(i), propertyScaleW, propertyScaleH);
                propertyPane.add(largePropertyLabelList.get(i), JLayeredPane.PALETTE_LAYER);
            }
            else if(i == shortLineRailRoadLabelIndex){
                BufferedImage shortLineRRImage = ImageIO.read(new File("src/MonopolyImages/ShortLineRR.jpg"));
                largePropertyLabelList.add(new JLabel(new ImageIcon(shortLineRRImage.getScaledInstance(propertyScaleW,propertyScaleH, Image.SCALE_SMOOTH))));
                largePropertyLabelList.get(shortLineRailRoadLabelIndex).setVisible(false);
                largePropertyLabelList.get(shortLineRailRoadLabelIndex).setBounds(xLargePropertyPaneList.get(i), yLargePropertyPaneList.get(i), propertyScaleW, propertyScaleH);
                propertyPane.add(largePropertyLabelList.get(i), JLayeredPane.PALETTE_LAYER);
            }
            else{
                largePropertyLabelList.add(new JLabel());
                propertyPane.add(largePropertyLabelList.get(i), JLayeredPane.PALETTE_LAYER);
            }
        }

        JButton overLayButton = new JButton();
        overLayButton.setBounds(0,0, 1200, 950);
        overLayButton.setOpaque(false);
        overLayButton.setContentAreaFilled(false);
        overLayButton.setBorderPainted(false);
        overLayButton.setVisible(false);
        overLayButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                overLayButton.setVisible(false);
                singlePropertyDisplayLabel.setVisible(false);

                // large property view text set to invisible
                for(int i  = 0; i < allLargePropertyViewSize; i++){
                    largePropertyLabelList.get(i).setVisible(false);
                }
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

        // creates a button for each property to click and get large display of the information
        for(int i = 0; i < xPropButtonList.size(); i++){

            int index = i;
            PropertyFinancials propertyFinancials = propertyFinancialsMap.get(singlePropertyBoardData.get(index));
            PropertyAttributes propertyAttributes = propertyAttributesMap.get(singlePropertyBoardData.get(index));

            // setup property buttons
            propertyButtonsList.add(new JButton());
            JButton propButton = propertyButtonsList.get(i);
            if(i <= 5) propButton.setBounds(xPropButtonList.get(i), yPropButtonList.get(i), smallEdge, longEdge);
            else if(i <= 13) propButton.setBounds(xPropButtonList.get(i), yPropButtonList.get(i), longEdge, smallEdge);
            else if(i <= 21) propButton.setBounds(xPropButtonList.get(i), yPropButtonList.get(i), smallEdge, longEdge);
            else propButton.setBounds(xPropButtonList.get(i), yPropButtonList.get(i), longEdge, smallEdge);

            // make the property buttons clear but still functional
            propButton.setFocusable(false);
            propButton.setOpaque(false);
            propButton.setContentAreaFilled(false);
            propButton.setBorderPainted(false);

            propButton.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {

                    overLayButton.setVisible(true);

                    if(index == electricCompanyShortBoardIndex)              largePropertyLabelList.get(electricCompanyLabelIndex).setVisible(true);
                    else if (index == waterWorksLabelShortBoardIndex)        largePropertyLabelList.get(waterWorksLabelIndex).setVisible(true);
                    else if (index == readingRailRoadShortBoardIndex)        largePropertyLabelList.get(readingRailRoadLabelIndex).setVisible(true);
                    else if (index == pennsylvaniaRailRoadShortBoardIndex)   largePropertyLabelList.get(pennsylvaniaRailRoadLabelIndex).setVisible(true);
                    else if (index == bAndORailRoadShortBoardIndex)          largePropertyLabelList.get(bAndORailRoadLabelIndex).setVisible(true);
                    else if (index == shortLineRailRoadLabelShortBoardIndex) largePropertyLabelList.get(shortLineRailRoadLabelIndex).setVisible(true);
                    else {
                        singlePropertyDisplayLabel.setVisible(true);

                        for (int j = 0; j < noRRULargePropertyViewSize; j++) {

                            largePropertyLabelList.get(j).setVisible(true);

                        }
                    }

                    // display text for standard property cards other that RR's and utilities
                    if(index != electricCompanyShortBoardIndex && index != waterWorksLabelShortBoardIndex &&
                            index != readingRailRoadShortBoardIndex && index != pennsylvaniaRailRoadShortBoardIndex &&
                            index != bAndORailRoadShortBoardIndex && index != shortLineRailRoadLabelShortBoardIndex){
                        for(int j = 0; j < noRRULargePropertyViewSize; j++) {

                            JLabel largePropertyLabel = largePropertyLabelList.get(j);

                            if(j != 12){
                                largePropertyLabel.setFont(largePropertyLabel.getFont().deriveFont(largePropertyTextSizeList.get(j)));
                                largePropertyLabel.setBounds(xLargePropertyPaneList.get(j), yLargePropertyPaneList.get(j), propertyScaleW, propertyScaleH);
                            }

                            if (j == 0) {
                                largePropertyLabel.setText("<html>With 1 House <br>" +
                                        "                With 2 Houses      <br>" +
                                        "                With 3 Houses      <br>" +
                                        "                With 4 Houses</html>");
                                largePropertyLabel.setFont(largePropertyLabel.getFont().deriveFont(17.0F));
                            }
                            else if (j == 1) largePropertyLabel.setText("$  " + propertyFinancials.getRentOneHouse());
                            else if (j == 2) largePropertyLabel.setText(Integer.toString(propertyFinancials.getRentTwoHouse()));
                            else if (j == 3) largePropertyLabel.setText(Integer.toString(propertyFinancials.getRentThreeHouse()));
                            else if (j == 4) largePropertyLabel.setText(Integer.toString(propertyFinancials.getRentFourHouse()));
                            else if (j == 5) {
                                largePropertyLabel.setText("With HOTEL $" + propertyFinancials.getRentHotel());
                                largePropertyLabel.setHorizontalAlignment(0);
                            } else if (j == 6) {
                                largePropertyLabel.setText("Mortgage Value $" + propertyFinancials.getMortgageAmount());
                                largePropertyLabel.setHorizontalAlignment(0);
                            } else if (j == 7) {
                                largePropertyLabel.setText("Houses cost $" + propertyFinancials.getPricePerImprovement() + ". each");
                                largePropertyLabel.setHorizontalAlignment(0);
                            } else if (j == 8) {
                                largePropertyLabel.setText("Hotels, $" + propertyFinancials.getPricePerImprovement() + ". plus 4 houses");
                                largePropertyLabel.setHorizontalAlignment(0);
                            } else if (j == 9) {
                                largePropertyLabel.setText(propertyFinancials.getName()); // title name
                                largePropertyLabel.setHorizontalAlignment(0);
                            } else if (j == 10) {
                                largePropertyLabel.setText("<html><center>If a player owns ALL the Lots of any Color-Group, the <p> rent is Doubled on Unimproved Lots in that group</center></html>");
                                largePropertyLabel.setHorizontalAlignment(0);
                            } else if (j == 11) {
                                largePropertyLabel.setText("RENT $" + propertyFinancials.getRent());
                                largePropertyLabel.setHorizontalAlignment(0);
                            } else if(j == 12){
                                largePropertyLabel.setOpaque(true);
                                largePropertyLabel.setBounds(xLargePropertyPaneList.get(j), yLargePropertyPaneList.get(j), 305, 70);
                                switch(propertyAttributes.getColor()){
                                    case PropertyColor.BROWN:
                                        largePropertyLabel.setBackground(new java.awt.Color(121,65,54));
                                        largePropertyLabelList.get(9).setForeground(Color.WHITE);
                                        break;
                                    case PropertyColor.LIGHTBLUE:
                                        largePropertyLabel.setBackground(new java.awt.Color(171,232,241));
                                        largePropertyLabelList.get(9).setForeground(Color.BLACK);
                                        break;
                                    case PropertyColor.PINK:
                                        largePropertyLabel.setBackground(new java.awt.Color(227,57,194));
                                        largePropertyLabelList.get(9).setForeground(Color.BLACK);
                                        break;
                                    case PropertyColor.ORANGE:
                                        largePropertyLabel.setBackground(new java.awt.Color(250,182,46));
                                        largePropertyLabelList.get(9).setForeground(Color.BLACK);
                                        break;
                                    case PropertyColor.RED:
                                        largePropertyLabel.setBackground(new java.awt.Color(250,70,46));
                                        largePropertyLabelList.get(9).setForeground(Color.BLACK);
                                        break;
                                    case PropertyColor.YELLOW:
                                        largePropertyLabel.setBackground(new java.awt.Color(247,250,51));
                                        largePropertyLabelList.get(9).setForeground(Color.BLACK);
                                        break;
                                    case PropertyColor.GREEN:
                                        largePropertyLabel.setBackground(new java.awt.Color(14,109,45));
                                        largePropertyLabelList.get(9).setForeground(Color.WHITE);
                                        break;
                                    case PropertyColor.DARKBLUE:
                                        largePropertyLabel.setBackground(new java.awt.Color(59,54,218));
                                        largePropertyLabelList.get(9).setForeground(Color.WHITE);
                                        break;
                                    case PropertyColor.WHITE:
                                        break;
                                    case PropertyColor.BLACK:
                                        break;
                                }
                            }
                        }

                    }
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
