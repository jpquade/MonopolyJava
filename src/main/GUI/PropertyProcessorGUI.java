package main.GUI;

import main.Enums.BoardPropertyTileOrder;
import main.Enums.PlayerToken;
import main.Enums.PropertyGroup;
import main.Enums.PropertyNames;
import main.Functions.PropertyProcessor;
import main.Properties.Property;
import main.Properties.PropertyAttributes;
import main.Properties.PropertyFinancials;

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

public class PropertyProcessorGUI {

    private final PropertyProcessor propertyProcessor;
    // center of board large single property display sizes
    private final int centerPropertyScaleW;
    private final int centerPropertyScaleH;
    private final ArrayList<JLabel> largePropertyLabelList;
    final int boardPropertyTileElementCount;

    private final HashMap<BoardPropertyTileOrder, JButton> propertyButtonsMap;
    private final HashMap<BoardPropertyTileOrder, PropertyCoordinates> propertyBoardLocationsMap;

    public PropertyProcessorGUI(PropertyProcessor propertyProcessor, JLayeredPane boardSidePane, LinkedHashMap<String, PropertyFinancials> propertyFinancialsMap, HashMap<Integer,
            String> singlePropertyBoardData, LinkedHashMap<String, PropertyAttributes> propertyAttributesMap) throws IOException {

        this.propertyProcessor = propertyProcessor;
        centerPropertyScaleW = 350;
        centerPropertyScaleH = 400;

        //TODO: Refactor this section to have a hashmap of the property names and their positions

        // large property display and positions of text
        largePropertyLabelList = new ArrayList<>();
        boardPropertyTileElementCount = 13;

        propertyButtonsMap = new HashMap<>();
        propertyBoardLocationsMap = new HashMap<>();

        JLabel singlePropertyDisplayLabel = setupUtilityRRSingleLargePropertyView(boardSidePane);

        setupPropertyTileButtons(singlePropertyDisplayLabel, boardSidePane, propertyFinancialsMap, singlePropertyBoardData, propertyAttributesMap);
    }

    public JLabel setupUtilityRRSingleLargePropertyView(JLayeredPane boardSidePane) throws IOException {



        // displays one property at a time for clicking on a board property
        BufferedImage singlePropertyDisplayImage = ImageIO.read(new File("src/main/MonopolyImages/monopolyPropertyBlank.png"));
        JLabel singlePropertyDisplayLabel = new JLabel(new ImageIcon(singlePropertyDisplayImage.getScaledInstance(centerPropertyScaleW,centerPropertyScaleH, Image.SCALE_SMOOTH)));
        singlePropertyDisplayLabel.setBounds(0,0,centerPropertyScaleW,centerPropertyScaleH);
        singlePropertyDisplayLabel.setHorizontalAlignment(0);
        singlePropertyDisplayLabel.setVisible(false);

        JLayeredPane propertyPane = new JLayeredPane();
        propertyPane.add(singlePropertyDisplayLabel, JLayeredPane.DEFAULT_LAYER);
        propertyPane.setBounds(400,250,centerPropertyScaleW,centerPropertyScaleH);
        boardSidePane.add(propertyPane, JLayeredPane.MODAL_LAYER);

        // create JLabels for each property tile element
        for(int i = 0; i < boardPropertyTileElementCount ; i++) {

            JLabel jLabel = new JLabel();
            propertyPane.add(jLabel, JLayeredPane.MODAL_LAYER);
            largePropertyLabelList.add(jLabel);
        }

        // create JLabels for each utility
        for(PropertyGroup.UTILITY_GROUP utility: PropertyGroup.UTILITY_GROUP.values()){
            BufferedImage bufferedImage;

            if(utility == PropertyGroup.UTILITY_GROUP.ELECTRIC_COMPANY){
                bufferedImage = ImageIO.read(new File("src/main/MonopolyImages/ElectricCompany.png"));
            }
            else{
                bufferedImage = ImageIO.read(new File("src/main/MonopolyImages/WaterWorks.png"));
            }

            JLabel jLabel = new JLabel(new ImageIcon(bufferedImage.getScaledInstance(centerPropertyScaleW,centerPropertyScaleH, Image.SCALE_SMOOTH)));
            jLabel.setVisible(false);
            jLabel.setBounds(0, 0, centerPropertyScaleW, centerPropertyScaleH);
            propertyPane.add(jLabel, JLayeredPane.MODAL_LAYER);
            largePropertyLabelList.add(jLabel);
        }

        // create JLabels for each railroad
        for(PropertyGroup.RAILROAD_GROUP railRoad: PropertyGroup.RAILROAD_GROUP.values()){
            BufferedImage bufferedImage;

            if(railRoad == PropertyGroup.RAILROAD_GROUP.READING_RAILROAD){
                bufferedImage = ImageIO.read(new File("src/main/MonopolyImages/ReadingRR.jpg"));
            }
            else if(railRoad == PropertyGroup.RAILROAD_GROUP.PENNSYLVANIA_RAILROAD){
                bufferedImage = ImageIO.read(new File("src/main/MonopolyImages/PennsylvaniaRR.jpg"));
            }
            else if(railRoad == PropertyGroup.RAILROAD_GROUP.B_AND_O_RAILROAD){
                bufferedImage = ImageIO.read(new File("src/main/MonopolyImages/BandORR.jpg"));
            }
            else{
                bufferedImage = ImageIO.read(new File("src/main/MonopolyImages/ShortLineRR.jpg"));
            }

            JLabel jLabel = new JLabel(new ImageIcon(bufferedImage.getScaledInstance(centerPropertyScaleW,centerPropertyScaleH, Image.SCALE_SMOOTH)));
            jLabel.setVisible(false);
            jLabel.setBounds(0, 0, centerPropertyScaleW, centerPropertyScaleH);
            propertyPane.add(jLabel, JLayeredPane.MODAL_LAYER);
            largePropertyLabelList.add(jLabel);
        }

        return singlePropertyDisplayLabel;
    }

    public void setupPropertyTileButtons(JLabel singlePropertyDisplayLabel, JLayeredPane boardSidePane, LinkedHashMap<String, PropertyFinancials> propertyFinancialsMap, HashMap<Integer,
            String> singlePropertyBoardData, LinkedHashMap<String, PropertyAttributes> propertyAttributesMap) throws IOException {

        //TODO: Refactor this section to have a hashmap of the property names and their positions

        // large property view for positions of elements inside
        // there are 13 elements in the large property display
        ArrayList<Integer> xLargePropertyPaneList = new ArrayList<>(Arrays.asList(50,250,269,269,269,0,0,0,0,0,0,0,23));
        ArrayList<Integer> yLargePropertyPaneList = new ArrayList<>(Arrays.asList(-27,-62,-39,-16,7,47,68,89,110,-140,165,-92,25));

        // invisible board property tile buttons and positions
        ArrayList<Integer> xPropButtonList = new ArrayList<>(Arrays.asList(875,718,562,483,327,249,128,128,128,128,128,128,128,128,249,405,483,561,639,717,796,874,953,953,953,953,953,953));
        ArrayList<Integer> yPropButtonList = new ArrayList<>(Arrays.asList(826,826,826,826,826,826,749,671,593,515,437,359,202,124,3,3,3,3,3,3,3,3,123,202,358,436,593,749));

        for(BoardPropertyTileOrder propertyName: BoardPropertyTileOrder.values()){
            propertyBoardLocationsMap.put(propertyName, new PropertyCoordinates(xPropButtonList.get(propertyName.getValue()), yPropButtonList.get(propertyName.getValue())));
        }

        // large property view size of text
        ArrayList<Float> largePropertyTextSizeList = new ArrayList<>(Arrays.asList(17.0F,17.0F,17.0F,17.0F,17.0F,18.0F,18.0F,18.0F,18.0F,26.0F,10.0F,18.0F));

        // property button sizes
        final int boardSpacePropertyWidth = 77;
        final int boardSpacePropertyHeight = 120;

        // utility label index and index location according to property only list
        int electricCompanyLabelIndex = 13;              // label list index
        int electricCompanyShortBoardIndex = 7;          // order of property on board index

        int waterWorksLabelIndex = 14;                   // label list index
        int waterWorksLabelShortBoardIndex = 19;         // order of property on board index

        // RR label index and index location according to property only list
        int readingRailRoadLabelIndex = 15;              // label list index
        int readingRailRoadShortBoardIndex = 2;          // order of property on board index

        int pennsylvaniaRailRoadLabelIndex = 16;         // label list index
        int pennsylvaniaRailRoadShortBoardIndex = 10;    // order of property on board index

        int bAndORailRoadLabelIndex = 17;                // label list index
        int bAndORailRoadShortBoardIndex = 17;           // order of property on board index

        int shortLineRailRoadLabelIndex = 18;            // label list index
        int shortLineRailRoadLabelShortBoardIndex = 25;  // order of property on board index

        // invisible clickable board size button for making large property card view disappear
        InvisibleOverLayButtonGUI overLayButton = new InvisibleOverLayButtonGUI(singlePropertyDisplayLabel, largePropertyLabelList);

        // add overLayButton to the right pane
        boardSidePane.add(overLayButton, JLayeredPane.DRAG_LAYER);

        // creates a button for each property to click and get large display of the information
        //for(PropertyNames propertyName : PropertyNames.values()){

        for(BoardPropertyTileOrder propertyName : BoardPropertyTileOrder.values()){

            int i = propertyName.getValue();

            // single singlePropertyBoardData has a different order than the property names data
            //PropertyFinancials propertyFinancials = propertyFinancialsMap.get(singlePropertyBoardData.get(i));
            //PropertyAttributes propertyAttributes = propertyAttributesMap.get(singlePropertyBoardData.get(i));
            Property propertyFinancials = propertyProcessor.getProperty(propertyName);
            Property propertyAttributes = propertyProcessor.getProperty(propertyName);


            //propertyButtonsMap.put(PropertyNames.values()[i], new JButton());
            propertyButtonsMap.put(propertyName, new JButton());

            JButton propButton = propertyButtonsMap.get(propertyName);
            int xCoordinate = propertyBoardLocationsMap.get(propertyName).x();
            int yCoordinate = propertyBoardLocationsMap.get(propertyName).y();

            if(i <= 5) propButton.setBounds(xCoordinate, yCoordinate, boardSpacePropertyWidth, boardSpacePropertyHeight);       // bottom side of board
            else if(i <= 13) propButton.setBounds(xCoordinate, yCoordinate, boardSpacePropertyHeight, boardSpacePropertyWidth); // left side of board
            else if(i <= 21) propButton.setBounds(xCoordinate, yCoordinate, boardSpacePropertyWidth, boardSpacePropertyHeight); // top side of board
            else propButton.setBounds(xCoordinate, yCoordinate, boardSpacePropertyHeight, boardSpacePropertyWidth);             // right side of board

            // make the property buttons clear but still functional
            propButton.setFocusable(false);
            propButton.setOpaque(false);
            propButton.setContentAreaFilled(false);
            propButton.setBorderPainted(false);

            propButton.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {

                    overLayButton.setVisible(true);

                    if(i == electricCompanyShortBoardIndex)              largePropertyLabelList.get(electricCompanyLabelIndex).setVisible(true);
                    else if (i == waterWorksLabelShortBoardIndex)        largePropertyLabelList.get(waterWorksLabelIndex).setVisible(true);
                    else if (i == readingRailRoadShortBoardIndex)        largePropertyLabelList.get(readingRailRoadLabelIndex).setVisible(true);
                    else if (i == pennsylvaniaRailRoadShortBoardIndex)   largePropertyLabelList.get(pennsylvaniaRailRoadLabelIndex).setVisible(true);
                    else if (i == bAndORailRoadShortBoardIndex)          largePropertyLabelList.get(bAndORailRoadLabelIndex).setVisible(true);
                    else if (i == shortLineRailRoadLabelShortBoardIndex) largePropertyLabelList.get(shortLineRailRoadLabelIndex).setVisible(true);
                    else {

                        // sets all large property display elements to visible

                        singlePropertyDisplayLabel.setVisible(true);

                        for (int j = 0; j < boardPropertyTileElementCount; j++) {

                            largePropertyLabelList.get(j).setVisible(true);

                        }
                    }

                    // display text for standard property cards other than RR's and utilities
                    if(i != electricCompanyShortBoardIndex && i != waterWorksLabelShortBoardIndex &&
                            i != readingRailRoadShortBoardIndex && i != pennsylvaniaRailRoadShortBoardIndex &&
                            i != bAndORailRoadShortBoardIndex && i != shortLineRailRoadLabelShortBoardIndex){
                        for(int j = 0; j < boardPropertyTileElementCount; j++) {

                            JLabel largePropertyLabel = largePropertyLabelList.get(j);

                            if(j != 12){
                                largePropertyLabel.setFont(largePropertyLabel.getFont().deriveFont(largePropertyTextSizeList.get(j)));
                                largePropertyLabel.setBounds(xLargePropertyPaneList.get(j), yLargePropertyPaneList.get(j), centerPropertyScaleW, centerPropertyScaleH);
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
                                largePropertyLabel.setText(propertyProcessor.getPropertyNameString(propertyFinancials.getName())); // title name
                                //largePropertyLabel.setText(propertyFinancials.getName()); // title name
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
                                    case PropertyGroup.BROWN:
                                        largePropertyLabel.setBackground(new java.awt.Color(121,65,54));
                                        largePropertyLabelList.get(9).setForeground(Color.WHITE);
                                        break;
                                    case PropertyGroup.LIGHTBLUE:
                                        largePropertyLabel.setBackground(new java.awt.Color(171,232,241));
                                        largePropertyLabelList.get(9).setForeground(Color.BLACK);
                                        break;
                                    case PropertyGroup.PINK:
                                        largePropertyLabel.setBackground(new java.awt.Color(227,57,194));
                                        largePropertyLabelList.get(9).setForeground(Color.BLACK);
                                        break;
                                    case PropertyGroup.ORANGE:
                                        largePropertyLabel.setBackground(new java.awt.Color(250,182,46));
                                        largePropertyLabelList.get(9).setForeground(Color.BLACK);
                                        break;
                                    case PropertyGroup.RED:
                                        largePropertyLabel.setBackground(new java.awt.Color(250,70,46));
                                        largePropertyLabelList.get(9).setForeground(Color.BLACK);
                                        break;
                                    case PropertyGroup.YELLOW:
                                        largePropertyLabel.setBackground(new java.awt.Color(247,250,51));
                                        largePropertyLabelList.get(9).setForeground(Color.BLACK);
                                        break;
                                    case PropertyGroup.GREEN:
                                        largePropertyLabel.setBackground(new java.awt.Color(14,109,45));
                                        largePropertyLabelList.get(9).setForeground(Color.WHITE);
                                        break;
                                    case PropertyGroup.DARKBLUE:
                                        largePropertyLabel.setBackground(new java.awt.Color(59,54,218));
                                        largePropertyLabelList.get(9).setForeground(Color.WHITE);
                                        break;
                                    case PropertyGroup.UTILITY:
                                        break;
                                    case PropertyGroup.RAILROAD:
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

            // prints to console the property clicked
            propButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("Element: " + i);
                }
            });
            boardSidePane.add(propButton, JLayeredPane.POPUP_LAYER);
        }
    }

    public void highLightProperty(PlayerToken playerToken){
        ArrayList<Property> ownedProperties;

        ownedProperties = propertyProcessor.findOwnedProperties(playerToken);

        // TODO - access each propertyTile and highlight it

    }

    record PropertyCoordinates(int x, int y) {
    }
}
