package main.GUI;

import main.Enums.PropertyTileOrder;
import main.Enums.PlayerToken;
import main.Enums.PropertyGroup;
import main.Functions.PropertyProcessor;
import main.Properties.Property;
import main.Properties.PropertyAttributes;
import main.Properties.PropertyFinancials;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class PropertyProcessorGUI3 {

    private final PropertyProcessor propertyProcessor;
    // center of board large single property display sizes
    private final int centerPropertyScaleW;
    private final int centerPropertyScaleH;
    private final ArrayList<JLabel> largePropertyTileLabelList;
    private final ArrayList<JLabel> propertyElementLabelList;
    private final int boardPropertyTileElementCount;

    private final HashMap<PropertyTileOrder, JButton> propertyButtonsMap;
    private final HashMap<PropertyTileOrder, PropertyCoordinates> propertyBoardLocationsMap;

    private final HashMap<PropertyTileOrder, JLabel> largePropertyTileLabelMap;

    BufferedImage largePropertyTileImage;
    JLabel largePropertyTileLabel;

    JLayeredPane propertyPane;

    // invisible board property tile buttons and positions
    private final ArrayList<Integer> xPropButtonList = new ArrayList<>(Arrays.asList(875,718,562,483,327,249,128,128,128,128,128,128,128,128,249,405,483,561,639,717,796,874,953,953,953,953,953,953));
    private final ArrayList<Integer> yPropButtonList = new ArrayList<>(Arrays.asList(826,826,826,826,826,826,749,671,593,515,437,359,202,124,3,3,3,3,3,3,3,3,123,202,358,436,593,749));

    private final ArrayList<Integer> xLargePropertyPaneList = new ArrayList<>(Arrays.asList(50,250,269,269,269,0,0,0,0,0,0,0,23));
    private final ArrayList<Integer> yLargePropertyPaneList = new ArrayList<>(Arrays.asList(-27,-62,-39,-16,7,47,68,89,110,-140,165,-92,25));

    private final ArrayList<Float> largePropertyTextSizeList = new ArrayList<>(Arrays.asList(17.0F,17.0F,17.0F,17.0F,17.0F,18.0F,18.0F,18.0F,18.0F,26.0F,10.0F,18.0F));

    public PropertyProcessorGUI3(PropertyProcessor propertyProcessor, JLayeredPane boardSidePane, LinkedHashMap<String, PropertyFinancials> propertyFinancialsMap, HashMap<Integer,
            String> singlePropertyBoardData, LinkedHashMap<String, PropertyAttributes> propertyAttributesMap) throws IOException {

        this.propertyProcessor = propertyProcessor;
        centerPropertyScaleW = 350;
        centerPropertyScaleH = 400;

        //TODO: Refactor this section to have a hashmap of the property names and their positions

        // large property display and positions of text
        largePropertyTileLabelList = new ArrayList<>();
        propertyElementLabelList = new ArrayList<>();
        boardPropertyTileElementCount = 13;

        propertyButtonsMap = new HashMap<>();
        propertyBoardLocationsMap = new HashMap<>();
        largePropertyTileLabelMap = new HashMap<>();

        largePropertyTileImage = ImageIO.read(new File("src/main/MonopolyImages/monopolyPropertyBlank.png"));
        largePropertyTileLabel = new JLabel(new ImageIcon(largePropertyTileImage.getScaledInstance(centerPropertyScaleW,centerPropertyScaleH, Image.SCALE_SMOOTH)));


        setupUtilityRRSingleLargePropertyView(boardSidePane);
        
        setupPropertyTileButtons(largePropertyTileLabel, boardSidePane, propertyFinancialsMap, singlePropertyBoardData, propertyAttributesMap);
    }

    public void setupUtilityRRSingleLargePropertyView(JLayeredPane boardSidePane) throws IOException {

        // displays one property at a time for clicking on a board property

        largePropertyTileLabel.setBounds(0,0,centerPropertyScaleW,centerPropertyScaleH);
        largePropertyTileLabel.setHorizontalAlignment(0);
        largePropertyTileLabel.setVisible(false);

        JLayeredPane propertyPane = new JLayeredPane();
        propertyPane.add(largePropertyTileLabel, JLayeredPane.DEFAULT_LAYER);
        propertyPane.setBounds(400,250,centerPropertyScaleW,centerPropertyScaleH);
        boardSidePane.add(propertyPane, JLayeredPane.PALETTE_LAYER);

        // create JLabels for each property tile element
        for(int i = 0; i < boardPropertyTileElementCount ; i++) {

            JLabel jLabel = new JLabel();
            propertyPane.add(jLabel, JLayeredPane.PALETTE_LAYER);
            largePropertyTileLabelList.add(jLabel);
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
            propertyPane.add(jLabel, JLayeredPane.PALETTE_LAYER);
            largePropertyTileLabelList.add(jLabel);
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
            propertyPane.add(jLabel, JLayeredPane.PALETTE_LAYER);
            largePropertyTileLabelList.add(jLabel);
        }


    }

    // adds coordinates to the property board location map
    public void setupPropertyBoardLocationMap(){
        for(PropertyTileOrder propertyName: PropertyTileOrder.values()){
            propertyBoardLocationsMap.put(propertyName, new PropertyCoordinates(xPropButtonList.get(propertyName.getValue()), yPropButtonList.get(propertyName.getValue())));
        }
    }

    public void setupPropertyTileButtons(JLabel singlePropertyDisplayLabel, JLayeredPane boardSidePane, LinkedHashMap<String, PropertyFinancials> propertyFinancialsMap, HashMap<Integer,
            String> singlePropertyBoardData, LinkedHashMap<String, PropertyAttributes> propertyAttributesMap) throws IOException {

        //TODO: Refactor this section to have a hashmap of the property names and their positions

        // large property view for positions of elements inside
        // there are 13 elements in the large property display
        //ArrayList<Integer> xLargePropertyPaneList = new ArrayList<>(Arrays.asList(50,250,269,269,269,0,0,0,0,0,0,0,23));
        //ArrayList<Integer> yLargePropertyPaneList = new ArrayList<>(Arrays.asList(-27,-62,-39,-16,7,47,68,89,110,-140,165,-92,25));

        // invisible board property tile buttons and positions
        //ArrayList<Integer> xPropButtonList = new ArrayList<>(Arrays.asList(875,718,562,483,327,249,128,128,128,128,128,128,128,128,249,405,483,561,639,717,796,874,953,953,953,953,953,953));
        //ArrayList<Integer> yPropButtonList = new ArrayList<>(Arrays.asList(826,826,826,826,826,826,749,671,593,515,437,359,202,124,3,3,3,3,3,3,3,3,123,202,358,436,593,749));


        // adds coordinates to the property board location map
        setupPropertyBoardLocationMap();

        // large property view size of text
        //ArrayList<Float> largePropertyTextSizeList = new ArrayList<>(Arrays.asList(17.0F,17.0F,17.0F,17.0F,17.0F,18.0F,18.0F,18.0F,18.0F,26.0F,10.0F,18.0F));

        // property button sizes
        final int boardSpacePropertyWidth = 77;
        final int boardSpacePropertyHeight = 120;

        // utility label index and index location according to property only list
        int electricCompanyLabelIndex = 13;              // label list index
        int waterWorksLabelIndex = 14;                   // label list index

        // RR label index and index location according to property only list
        int readingRailRoadLabelIndex = 15;              // label list index
        int pennsylvaniaRailRoadLabelIndex = 16;         // label list index
        int bAndORailRoadLabelIndex = 17;                // label list index
        int shortLineRailRoadLabelIndex = 18;            // label list index


        // invisible clickable board size button for making large property card view disappear
        InvisibleOverLayButtonGUI invisibleLargeTileButton = new InvisibleOverLayButtonGUI(singlePropertyDisplayLabel, largePropertyTileLabelList);

        // add overLayButton to the right pane
        boardSidePane.add(invisibleLargeTileButton, JLayeredPane.DRAG_LAYER);

        // creates a button for each property to click and get large display of the information
        for(PropertyTileOrder smallPropertyTile : PropertyTileOrder.values()){

            int propertyTileIndex = smallPropertyTile.getValue();

            Property property = propertyProcessor.getProperty(propertyProcessor.convertBoardPropertyTileOrderToPopertyNames(smallPropertyTile));

            propertyButtonsMap.put(smallPropertyTile, new JButton());

            JButton invisibleSmallTileButton = propertyButtonsMap.get(smallPropertyTile);
            invisibleSmallTileButton.setContentAreaFilled(false); // makes the button clear color
            invisibleSmallTileButton.setBorderPainted(false);     // removes the border color

            int buttonXCoordinate = propertyBoardLocationsMap.get(smallPropertyTile).x();
            int buttonYCoordinate = propertyBoardLocationsMap.get(smallPropertyTile).y();

            if(propertyTileIndex <= 5) invisibleSmallTileButton.setBounds(buttonXCoordinate, buttonYCoordinate, boardSpacePropertyWidth, boardSpacePropertyHeight);       // bottom side of board
            else if(propertyTileIndex <= 13) invisibleSmallTileButton.setBounds(buttonXCoordinate, buttonYCoordinate, boardSpacePropertyHeight, boardSpacePropertyWidth); // left side of board
            else if(propertyTileIndex <= 21) invisibleSmallTileButton.setBounds(buttonXCoordinate, buttonYCoordinate, boardSpacePropertyWidth, boardSpacePropertyHeight); // top side of board
            else invisibleSmallTileButton.setBounds(buttonXCoordinate, buttonYCoordinate, boardSpacePropertyHeight, boardSpacePropertyWidth);             // right side of board

            // make the property buttons clear color but still functional
            //propButton.setFocusable(false);
            //propButton.setOpaque(false);


            invisibleSmallTileButton.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {

                    invisibleLargeTileButton.setVisible(true);

                    //if(propertyTileIndex == electricCompanyShortBoardIndex)              largePropertyLabelList.get(electricCompanyLabelIndex).setVisible(true);
                    if(smallPropertyTile == PropertyTileOrder.ELECTRIC_COMPANY)              largePropertyTileLabelList.get(electricCompanyLabelIndex).setVisible(true);
                    else if (smallPropertyTile == PropertyTileOrder.WATER_WORKS)             largePropertyTileLabelList.get(waterWorksLabelIndex).setVisible(true);
                    else if (smallPropertyTile == PropertyTileOrder.READING_RAILROAD)        largePropertyTileLabelList.get(readingRailRoadLabelIndex).setVisible(true);
                    else if (smallPropertyTile == PropertyTileOrder.PENNSYLVANIA_RAILROAD)   largePropertyTileLabelList.get(pennsylvaniaRailRoadLabelIndex).setVisible(true);
                    else if (smallPropertyTile == PropertyTileOrder.B_AND_O_RAILROAD)        largePropertyTileLabelList.get(bAndORailRoadLabelIndex).setVisible(true);
                    else if (smallPropertyTile == PropertyTileOrder.SHORT_LINE_RAILROAD)     largePropertyTileLabelList.get(shortLineRailRoadLabelIndex).setVisible(true);
                    else {
                        //overLayButton.setVisible(true);

                        singlePropertyDisplayLabel.setVisible(true);

                        // sets all large property display elements to visible if not utility or RR
                        smallPropertyTileElementSetup(singlePropertyDisplayLabel, largePropertyTextSizeList, xLargePropertyPaneList, yLargePropertyPaneList, property,smallPropertyTile);

                    }
                    // prints to console the property clicked
                    System.out.println("Element: " + smallPropertyTile);
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

            boardSidePane.add(invisibleSmallTileButton, JLayeredPane.POPUP_LAYER);
        }
    }

    public void smallPropertyTileElementSetup(JLabel singlePropertyDisplayLabel, ArrayList<Float> largePropertyTextSizeList, ArrayList<Integer> xLargePropertyPaneList, ArrayList<Integer> yLargePropertyPaneList, Property property, PropertyTileOrder smallPropertyTile){

        // displays the label with the generic empty image of a property card
        //singlePropertyDisplayLabel.setVisible(true);

        for (int j = 0; j < boardPropertyTileElementCount; j++) {

            largePropertyTileLabelList.get(j).setVisible(true);
        }

        for(int j = 0; j < boardPropertyTileElementCount; j++) {

            JLabel largePropertyTileLabel = largePropertyTileLabelList.get(j);

            if(j != 12){
                largePropertyTileLabel.setFont(largePropertyTileLabel.getFont().deriveFont(largePropertyTextSizeList.get(j)));
                largePropertyTileLabel.setBounds(xLargePropertyPaneList.get(j), yLargePropertyPaneList.get(j), centerPropertyScaleW, centerPropertyScaleH);
            }

            if (j == 0) {
                largePropertyTileLabel.setText("<html>With 1 House <br>" +
                        "                With 2 Houses      <br>" +
                        "                With 3 Houses      <br>" +
                        "                With 4 Houses</html>");
                largePropertyTileLabel.setFont(largePropertyTileLabel.getFont().deriveFont(17.0F));
            }
            else if (j == 1) largePropertyTileLabel.setText("$  " + property.getRentOneHouse());
            else if (j == 2) largePropertyTileLabel.setText(Integer.toString(property.getRentTwoHouse()));
            else if (j == 3) largePropertyTileLabel.setText(Integer.toString(property.getRentThreeHouse()));
            else if (j == 4) largePropertyTileLabel.setText(Integer.toString(property.getRentFourHouse()));
            else if (j == 5) {
                largePropertyTileLabel.setText("With HOTEL $" + property.getRentHotel());
                largePropertyTileLabel.setHorizontalAlignment(0);
            } else if (j == 6) {
                largePropertyTileLabel.setText("Mortgage Value $" + property.getMortgageAmount());
                largePropertyTileLabel.setHorizontalAlignment(0);
            } else if (j == 7) {
                largePropertyTileLabel.setText("Houses cost $" + property.getPricePerImprovement() + ". each");
                largePropertyTileLabel.setHorizontalAlignment(0);
            } else if (j == 8) {
                largePropertyTileLabel.setText("Hotels, $" + property.getPricePerImprovement() + ". plus 4 houses");
                largePropertyTileLabel.setHorizontalAlignment(0);
            } else if (j == 9) {
                largePropertyTileLabel.setText(propertyProcessor.getPropertyNameString(propertyProcessor.convertBoardPropertyTileOrderToPopertyNames(smallPropertyTile))); // title name
                //largePropertyTileLabel.setText(propertyFinancials.getName()); // title name
                largePropertyTileLabel.setHorizontalAlignment(0);
            } else if (j == 10) {
                largePropertyTileLabel.setText("<html><center>If a player owns ALL the Lots of any Color-Group, the <p> rent is Doubled on Unimproved Lots in that group</center></html>");
                largePropertyTileLabel.setHorizontalAlignment(0);
            } else if (j == 11) {
                largePropertyTileLabel.setText("RENT $" + property.getRent());
                largePropertyTileLabel.setHorizontalAlignment(0);
            } else if(j == 12){
                largePropertyTileLabel.setOpaque(true);
                largePropertyTileLabel.setBounds(xLargePropertyPaneList.get(j), yLargePropertyPaneList.get(j), 305, 70);
                switch(property.getColor()){
                    case PropertyGroup.BROWN:
                        largePropertyTileLabel.setBackground(new java.awt.Color(121,65,54));
                        largePropertyTileLabelList.get(9).setForeground(Color.WHITE);
                        break;
                    case PropertyGroup.LIGHTBLUE:
                        largePropertyTileLabel.setBackground(new java.awt.Color(171,232,241));
                        largePropertyTileLabelList.get(9).setForeground(Color.BLACK);
                        break;
                    case PropertyGroup.PINK:
                        largePropertyTileLabel.setBackground(new java.awt.Color(227,57,194));
                        largePropertyTileLabelList.get(9).setForeground(Color.BLACK);
                        break;
                    case PropertyGroup.ORANGE:
                        largePropertyTileLabel.setBackground(new java.awt.Color(250,182,46));
                        largePropertyTileLabelList.get(9).setForeground(Color.BLACK);
                        break;
                    case PropertyGroup.RED:
                        largePropertyTileLabel.setBackground(new java.awt.Color(250,70,46));
                        largePropertyTileLabelList.get(9).setForeground(Color.BLACK);
                        break;
                    case PropertyGroup.YELLOW:
                        largePropertyTileLabel.setBackground(new java.awt.Color(247,250,51));
                        largePropertyTileLabelList.get(9).setForeground(Color.BLACK);
                        break;
                    case PropertyGroup.GREEN:
                        largePropertyTileLabel.setBackground(new java.awt.Color(14,109,45));
                        largePropertyTileLabelList.get(9).setForeground(Color.WHITE);
                        break;
                    case PropertyGroup.DARKBLUE:
                        largePropertyTileLabel.setBackground(new java.awt.Color(59,54,218));
                        largePropertyTileLabelList.get(9).setForeground(Color.WHITE);
                        break;
                    case PropertyGroup.UTILITY:
                    case PropertyGroup.RAILROAD:
                        break;
                }
            }
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
