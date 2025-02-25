package main.GUI;

import main.Enums.PropertyGroup;
import main.Enums.PropertyNames;
import main.Enums.PropertyTileOrder;
import main.Functions.PropertyProcessor;
import main.Properties.Property;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class PropertyProcessorGUI {

    private final int propertyViewWidth;
    private final int propertyViewHeight;
    private final int elementCount;

    private final HashMap<PropertyTileOrder, JButton> tileButtonMap;
    private final HashMap<PropertyTileOrder, PropertyCoordinates> tileButtonCoordinateMap;
    private final HashMap<PropertyTileOrder, JLabel> propertyViewMap;
    private final HashMap<PropertyTileOrder, Boolean> enableSellMap;

    private final ArrayList<JLabel> propertyElementLabelList;
    private final ArrayList<Integer> xPropButtonList;
    private final ArrayList<Integer> yPropButtonList;
    private final ArrayList<Integer> xLargePropertyPaneList;
    private final ArrayList<Integer> yLargePropertyPaneList;
    private final ArrayList<Float> largePropertyTextSizeList;

    private BufferedImage propertyImageTemplateBUfferedImage;
    private JLabel propertyImageTemplateLabel;
    private JLayeredPane propertyPane;

    private final PropertyProcessor propertyProcessor;
    private InvisibleOverLayButtonGUI invisibleOverLayButtonGUI;

    public PropertyProcessorGUI(PropertyProcessor propertyProcessor, JLayeredPane boardSidePane) throws IOException {

        propertyViewWidth = 350;
        propertyViewHeight = 400;
        elementCount = 13;

        tileButtonMap = new HashMap<>();
        tileButtonCoordinateMap = new HashMap<>();
        propertyViewMap = new HashMap<>();
        enableSellMap = new HashMap<>();

        propertyElementLabelList = new ArrayList<>();
        xPropButtonList = new ArrayList<>(Arrays.asList(875,718,562,483,327,249,128,128,128,128,128,128,128,128,249,405,483,561,639,717,796,874,953,953,953,953,953,953));
        yPropButtonList = new ArrayList<>(Arrays.asList(826,826,826,826,826,826,749,671,593,515,437,359,202,124,3,3,3,3,3,3,3,3,123,202,358,436,593,749));
        xLargePropertyPaneList = new ArrayList<>(Arrays.asList(50,250,269,269,269,0,0,0,0,0,0,0,23));
        yLargePropertyPaneList = new ArrayList<>(Arrays.asList(-27,-62,-39,-16,7,47,68,89,110,-140,165,-92,25));
        largePropertyTextSizeList = new ArrayList<>(Arrays.asList(17.0F,17.0F,17.0F,17.0F,17.0F,18.0F,18.0F,18.0F,18.0F,26.0F,10.0F,18.0F));

        this.propertyProcessor = propertyProcessor;

        propertyPaneSetup(boardSidePane);
        propertyImageBlankLabelSetup();
        elementLabelListSetup();
        coordinateMapSetup();
        propertyViewSetup(boardSidePane);
        removeViewInvisibleButtonSetup(boardSidePane);
        enableSellSetup();
    }

    // adds a mouse listener to each property tile button to enable selling
    public void enableSellSetup(){
        for(PropertyTileOrder propertyTile : PropertyTileOrder.values()){
            enableSellMap.put(propertyTile, false);
        }

        for(PropertyTileOrder propertyTile : PropertyTileOrder.values()){
            tileButtonMap.get(propertyTile).addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e){
                    if(enableSellMap.get(propertyTile)) {
                        // sell property
                        System.out.println("Sell Property: " + propertyTile);
                    }
                }
            });
        }
    }

    // add large property display to the board Side Pane
    public void propertyPaneSetup(JLayeredPane boardSidePane){
        propertyPane = new JLayeredPane();
        propertyPane.setBounds(400,250, propertyViewWidth, propertyViewHeight);
        boardSidePane.add(propertyPane, JLayeredPane.PALETTE_LAYER);
    }

    public void propertyImageBlankLabelSetup() throws IOException {
        propertyImageTemplateBUfferedImage = ImageIO.read(new File("src/main/MonopolyImages/monopolyPropertyBlank.png"));
        propertyImageTemplateLabel = new JLabel(new ImageIcon(propertyImageTemplateBUfferedImage.getScaledInstance(propertyViewWidth, propertyViewHeight, Image.SCALE_SMOOTH)));
        propertyImageTemplateLabel.setBounds(0,0, propertyViewWidth, propertyViewHeight);
        propertyImageTemplateLabel.setHorizontalAlignment(0);
        propertyImageTemplateLabel.setVisible(false);

        // Add property template to the propertyPane
        propertyPane.add(propertyImageTemplateLabel, JLayeredPane.DEFAULT_LAYER);
    }

    // create property elements for each blank property tile
    public void elementLabelListSetup(){

        for (int i = 0; i < elementCount; i++) {

            propertyElementLabelList.add(new JLabel());
            propertyElementLabelList.get(i).setVisible(true);

        }
    }

    // adds coordinates to every board tile
    public void coordinateMapSetup(){
        for(PropertyTileOrder propertyName: PropertyTileOrder.values()){
            tileButtonCoordinateMap.put(propertyName, new PropertyCoordinates(xPropButtonList.get(propertyName.getValue()), yPropButtonList.get(propertyName.getValue())));
        }
    }

    public void removeViewInvisibleButtonSetup(JLayeredPane boardSidePane){
        // invisible clickable board size button for making large property card view disappear
        invisibleOverLayButtonGUI = new InvisibleOverLayButtonGUI(propertyImageTemplateLabel, propertyViewMap);

        // add overLayButton to the right pane
        boardSidePane.add(invisibleOverLayButtonGUI, JLayeredPane.DRAG_LAYER);
    }

    public void propertyViewSetup(JLayeredPane boardSidePane) throws IOException {

        // view property label
        JLabel viewPropertyLabel;

        for(PropertyTileOrder propertyTile : PropertyTileOrder.values()) {

            // create a button for each property tile
            if(propertyTile == PropertyTileOrder.ELECTRIC_COMPANY || propertyTile == PropertyTileOrder.WATER_WORKS){
                BufferedImage bufferedImage;

                if(propertyTile == PropertyTileOrder.ELECTRIC_COMPANY){
                    bufferedImage = ImageIO.read(new File("src/main/MonopolyImages/ElectricCompany.png"));
                }
                else{
                    bufferedImage = ImageIO.read(new File("src/main/MonopolyImages/WaterWorks.png"));
                }

                viewPropertyLabel = new JLabel(new ImageIcon(bufferedImage.getScaledInstance(propertyViewWidth, propertyViewHeight, Image.SCALE_SMOOTH)));
                viewPropertyLabel.setVisible(false);
                viewPropertyLabel.setBounds(0, 0, propertyViewWidth, propertyViewHeight);
                propertyViewMap.put(propertyTile, viewPropertyLabel);
            }
            else if(propertyTile == PropertyTileOrder.READING_RAILROAD || propertyTile == PropertyTileOrder.PENNSYLVANIA_RAILROAD || propertyTile == PropertyTileOrder.B_AND_O_RAILROAD || propertyTile == PropertyTileOrder.SHORT_LINE_RAILROAD){
                BufferedImage bufferedImage;

                if(propertyTile == PropertyTileOrder.READING_RAILROAD){
                    bufferedImage = ImageIO.read(new File("src/main/MonopolyImages/ReadingRR.jpg"));
                }
                else if(propertyTile == PropertyTileOrder.PENNSYLVANIA_RAILROAD){
                    bufferedImage = ImageIO.read(new File("src/main/MonopolyImages/PennsylvaniaRR.jpg"));
                }
                else if(propertyTile == PropertyTileOrder.B_AND_O_RAILROAD){
                    bufferedImage = ImageIO.read(new File("src/main/MonopolyImages/BandORR.jpg"));
                }
                else{
                    bufferedImage = ImageIO.read(new File("src/main/MonopolyImages/ShortLineRR.jpg"));
                }

                viewPropertyLabel = new JLabel(new ImageIcon(bufferedImage.getScaledInstance(propertyViewWidth, propertyViewHeight, Image.SCALE_SMOOTH)));
                viewPropertyLabel.setVisible(false);
                viewPropertyLabel.setBounds(0, 0, propertyViewWidth, propertyViewHeight);
                propertyViewMap.put(propertyTile, viewPropertyLabel);
            }
            else{
                viewPropertyLabel = new JLabel();
                viewPropertyLabel.setBounds(0,0, propertyViewWidth, propertyViewHeight);

                //addTileElements(jLabel, propertyTile);
                propertyViewMap.put(propertyTile, viewPropertyLabel);
            }

            // create a button for each property tile
            tileButtonBuilder(propertyTile, viewPropertyLabel , boardSidePane);

            // add large property display to the propertyPane
            propertyPane.add(propertyViewMap.get(propertyTile), JLayeredPane.MODAL_LAYER);
        }
    }

    public void tileButtonBuilder(PropertyTileOrder propertyTile ,JLabel viewPropertyLabel, JLayeredPane boardSidePane) throws IOException {

        // property button sizes
        final int tileWidth = 77;
        final int tileHeight = 120;

        int tileIndex = propertyTile.getValue();
        tileButtonMap.put(propertyTile, new JButton());

        // modify empty invisible button for property tile
        JButton invisibleTileButton = tileButtonMap.get(propertyTile);
        invisibleTileButton.setContentAreaFilled(false); // makes the button clear color
        invisibleTileButton.setBorderPainted(false);     // removes the border color

        // adds an invisible button over the property tile
        boardSidePane.add(invisibleTileButton, JLayeredPane.POPUP_LAYER);

        int buttonXCoordinate = tileButtonCoordinateMap.get(propertyTile).x();
        int buttonYCoordinate = tileButtonCoordinateMap.get(propertyTile).y();

        // position each invisible button on the board
        if(tileIndex <= 5) invisibleTileButton.setBounds(buttonXCoordinate, buttonYCoordinate, tileWidth, tileHeight);       // bottom side of board
        else if(tileIndex <= 13) invisibleTileButton.setBounds(buttonXCoordinate, buttonYCoordinate, tileHeight, tileWidth); // left side of board
        else if(tileIndex <= 21) invisibleTileButton.setBounds(buttonXCoordinate, buttonYCoordinate, tileWidth, tileHeight); // top side of board
        else invisibleTileButton.setBounds(buttonXCoordinate, buttonYCoordinate, tileHeight, tileWidth);                     // right side of board

        invisibleTileButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                // add the property name using the tobeClosed method to the invisible button
                // so that property can be closed when the invisible button is clicked
                invisibleOverLayButtonGUI.tobeClosed(propertyTile);

                // set the invisible button to enabled for clicking
                invisibleOverLayButtonGUI.setVisible(true);

                // set the invisible button to enabled for clicking
                propertyViewMap.get(propertyTile).setVisible(true);

                // prints to console the property clicked
                System.out.println("Element: " + propertyTile);
            }
        });

        invisibleTileButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                // if the property is not a utility or railroad, display the property image template and add elements
                if(propertyTile != PropertyTileOrder.ELECTRIC_COMPANY && propertyTile != PropertyTileOrder.WATER_WORKS &&
                        propertyTile != PropertyTileOrder.READING_RAILROAD && propertyTile != PropertyTileOrder.PENNSYLVANIA_RAILROAD &&
                        propertyTile != PropertyTileOrder.B_AND_O_RAILROAD && propertyTile != PropertyTileOrder.SHORT_LINE_RAILROAD){

                    // makes the property image template visible
                    propertyImageTemplateLabel.setVisible(true);

                    // adds elements to property view label
                    addTileElements(viewPropertyLabel, propertyTile);
                }
            }
        });
    }

    public void addTileElements(JLabel viewPropertyLabel, PropertyTileOrder propertyTileOrder){

        // convert the enum to a property name, then to a property
        PropertyNames propertyName = propertyProcessor.convertBoardPropertyTileOrderToPopertyNames(propertyTileOrder);
        Property property = propertyProcessor.getProperty(propertyName);

        // elements get set to blankLabelProperty
        for (JLabel jLabel : propertyElementLabelList) {
            viewPropertyLabel.add(jLabel);
        }

        // set the text for each element
        for(int i = 0; i < propertyElementLabelList.size(); i++) {

            JLabel elementLabel = propertyElementLabelList.get(i);

            if(i != 12){
                elementLabel.setFont(elementLabel.getFont().deriveFont(largePropertyTextSizeList.get(i)));
                elementLabel.setBounds(xLargePropertyPaneList.get(i), yLargePropertyPaneList.get(i), propertyViewWidth, propertyViewHeight);
            }

            if (i == 0) {
                elementLabel.setText("<html>With 1 House <br>" +
                        "                With 2 Houses      <br>" +
                        "                With 3 Houses      <br>" +
                        "                With 4 Houses</html>");
                elementLabel.setFont(elementLabel.getFont().deriveFont(17.0F));
            }
            else if (i == 1) elementLabel.setText("$  " + property.getRentOneHouse());
            else if (i == 2) elementLabel.setText(Integer.toString(property.getRentTwoHouse()));
            else if (i == 3) elementLabel.setText(Integer.toString(property.getRentThreeHouse()));
            else if (i == 4) elementLabel.setText(Integer.toString(property.getRentFourHouse()));
            else if (i == 5) {
                elementLabel.setText("With HOTEL $" + property.getRentHotel());
                elementLabel.setHorizontalAlignment(0);
            } else if (i == 6) {
                elementLabel.setText("Mortgage Value $" + property.getMortgageAmount());
                elementLabel.setHorizontalAlignment(0);
            } else if (i == 7) {
                elementLabel.setText("Houses cost $" + property.getPricePerImprovement() + ". each");
                elementLabel.setHorizontalAlignment(0);
            } else if (i == 8) {
                elementLabel.setText("Hotels, $" + property.getPricePerImprovement() + ". plus 4 houses");
                elementLabel.setHorizontalAlignment(0);
            } else if (i == 9) {
                elementLabel.setText(propertyProcessor.getPropertyNameString(propertyName)); // title name
                //largePropertyTileLabel.setText(propertyFinancials.getName()); // title name
                elementLabel.setHorizontalAlignment(0);
            } else if (i == 10) {
                elementLabel.setText("<html><center>If a player owns ALL the Lots of any Color-Group, the <p> rent is Doubled on Unimproved Lots in that group</center></html>");
                elementLabel.setHorizontalAlignment(0);
            } else if (i == 11) {
                elementLabel.setText("RENT $" + property.getRent());
                elementLabel.setHorizontalAlignment(0);
            } else if(i == 12){
                elementLabel.setOpaque(true);
                elementLabel.setBounds(xLargePropertyPaneList.get(i), yLargePropertyPaneList.get(i), 305, 70);
                switch(property.getColor()){
                    case PropertyGroup.BROWN:
                        elementLabel.setBackground(new Color(121,65,54));
                        propertyElementLabelList.get(9).setForeground(Color.WHITE);
                        break;
                    case PropertyGroup.LIGHTBLUE:
                        elementLabel.setBackground(new Color(171,232,241));
                        propertyElementLabelList.get(9).setForeground(Color.BLACK);
                        break;
                    case PropertyGroup.PINK:
                        elementLabel.setBackground(new Color(227,57,194));
                        propertyElementLabelList.get(9).setForeground(Color.BLACK);
                        break;
                    case PropertyGroup.ORANGE:
                        elementLabel.setBackground(new Color(250,182,46));
                        propertyElementLabelList.get(9).setForeground(Color.BLACK);
                        break;
                    case PropertyGroup.RED:
                        elementLabel.setBackground(new Color(250,70,46));
                        propertyElementLabelList.get(9).setForeground(Color.BLACK);
                        break;
                    case PropertyGroup.YELLOW:
                        elementLabel.setBackground(new Color(247,250,51));
                        propertyElementLabelList.get(9).setForeground(Color.BLACK);
                        break;
                    case PropertyGroup.GREEN:
                        elementLabel.setBackground(new Color(14,109,45));
                        propertyElementLabelList.get(9).setForeground(Color.WHITE);
                        break;
                    case PropertyGroup.DARKBLUE:
                        elementLabel.setBackground(new Color(59,54,218));
                        propertyElementLabelList.get(9).setForeground(Color.WHITE);
                        break;
                    case PropertyGroup.UTILITY:
                    case PropertyGroup.RAILROAD:
                        break;
                }
            }
        }
    }


    public void highLightActivePlayerProperty(){
        ArrayList<Property> ownedProperties;

        ownedProperties = propertyProcessor.findOwnedProperties();

        // TODO - access each propertyTile and highlight it

    }

    record PropertyCoordinates(int x, int y) {
    }
}
