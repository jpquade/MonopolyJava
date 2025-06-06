package main.GUI;

import main.Enums.PlayerToken;
import main.Enums.PropertyGroup;
import main.Enums.PropertyNames;
import main.Enums.PropertyTile;
import main.Functions.MoneyProcessor;
import main.Functions.PlayerProcessor;
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

    private final HashMap<PropertyTile, JButton> tileButtonMap;
    private final HashMap<PropertyTile, PropertyCoordinates> tileButtonCoordinateMap;
    private final HashMap<PropertyTile, JLabel> propertyViewMap;
    private final HashMap<PropertyTile, Boolean> enableSellMap;
    private final HashMap<PropertyTile, Boolean> mortgageMap;

    private final ArrayList<JLabel> elementLabelList;
    private final ArrayList<Integer> xCoordinateTileButtonList;
    private final ArrayList<Integer> yCoordinateTileButtonList;
    private final ArrayList<Integer> xCoordinateViewList;
    private final ArrayList<Integer> yCoordinateViewList;
    private final ArrayList<Float> elementTextSizeList;

    private BufferedImage propertyImageTemplateBufferedImage;
    private JLabel propertyImageTemplateLabel;
    private JLayeredPane propertyViewPane;

    private final PropertyProcessor propertyProcessor;
    private InvisibleBoardButtonGUI invisibleBoardButtonGUI;

    private PropertyTile activeView;

    private PropertyTile currentPropertyToMortgage;

    public PropertyProcessorGUI(PropertyProcessor propertyProcessor, BoardSidePaneGUI boardSidePane) throws IOException {
        mortgageMap = new HashMap<>();
        this.activeView = null;

        propertyViewWidth = 350;
        propertyViewHeight = 400;
        elementCount = 13;

        tileButtonMap = new HashMap<>();
        tileButtonCoordinateMap = new HashMap<>();
        propertyViewMap = new HashMap<>();
        enableSellMap = new HashMap<>();
        enableSellMapSetup();

        elementLabelList = new ArrayList<>();
        xCoordinateTileButtonList = new ArrayList<>(Arrays.asList(875,718,562,483,327,249,128,128,128,128,128,128,128,128,249,405,483,561,639,717,796,874,953,953,953,953,953,953));
        yCoordinateTileButtonList = new ArrayList<>(Arrays.asList(826,826,826,826,826,826,749,671,593,515,437,359,202,124,3,3,3,3,3,3,3,3,123,202,358,436,593,749));
        xCoordinateViewList = new ArrayList<>(Arrays.asList(50,250,269,269,269,0,0,0,0,0,0,0,23));
        yCoordinateViewList = new ArrayList<>(Arrays.asList(-27,-62,-39,-16,7,47,68,89,110,-140,165,-92,25));
        elementTextSizeList = new ArrayList<>(Arrays.asList(17.0F,17.0F,17.0F,17.0F,17.0F,18.0F,18.0F,18.0F,18.0F,26.0F,10.0F,18.0F));

        this.propertyProcessor = propertyProcessor;

        //this.sellPropertySubBoxGUI = sellPropertySubBoxGUI;

        //this.selectionBoxButtonGUI = selectionBoxButtonGUI;

        propertyPaneSetup(boardSidePane);
        propertyImageBlankLabelSetup();
        elementLabelListSetup();
        coordinateMapSetup();
        propertyViewSetup(boardSidePane);
        removeViewInvisibleButtonSetup(boardSidePane);
        //checkIfSellablePropertySetup();
    }

    public HashMap<PropertyTile, JButton> getTileButtonMap() {
        return tileButtonMap;
    }

    private void enableSellMapSetup(){
        for(PropertyTile propertyTile : PropertyTile.values()){
            enableSellMap.put(propertyTile, false);
        }
    }

    private void enableMortgageMapSetup(){
        for(PropertyTile propertyTile : PropertyTile.values()){
            mortgageMap.put(propertyTile, false);
        }
    }

    // add large property display to the board Side Pane
    public void propertyPaneSetup(JLayeredPane boardSidePane){
        propertyViewPane = new JLayeredPane();
        propertyViewPane.setBounds(400,250, propertyViewWidth, propertyViewHeight);
        boardSidePane.add(propertyViewPane, JLayeredPane.PALETTE_LAYER);
    }

    public void propertyImageBlankLabelSetup() throws IOException {
        propertyImageTemplateBufferedImage = ImageIO.read(new File("src/main/MonopolyImages/monopolyPropertyBlank.png"));
        propertyImageTemplateLabel = new JLabel(new ImageIcon(propertyImageTemplateBufferedImage.getScaledInstance(propertyViewWidth, propertyViewHeight, Image.SCALE_SMOOTH)));
        propertyImageTemplateLabel.setBounds(0,0, propertyViewWidth, propertyViewHeight);
        propertyImageTemplateLabel.setHorizontalAlignment(0);
        propertyImageTemplateLabel.setVisible(false);

        // Add property template to the propertyPane
        propertyViewPane.add(propertyImageTemplateLabel, JLayeredPane.DEFAULT_LAYER);
    }

    // create property elements for each blank property tile
    public void elementLabelListSetup(){

        for (int i = 0; i < elementCount; i++) {

            elementLabelList.add(new JLabel());
            elementLabelList.get(i).setVisible(true);
        }
    }

    // adds coordinates to every board tile
    public void coordinateMapSetup(){
        for(PropertyTile propertyName: PropertyTile.values()){
            tileButtonCoordinateMap.put(propertyName, new PropertyCoordinates(xCoordinateTileButtonList.get(propertyName.getValue()), yCoordinateTileButtonList.get(propertyName.getValue())));
        }
    }

    public void removeViewInvisibleButtonSetup(JLayeredPane boardSidePane){
        // invisible clickable board size button for making large property card view disappear
        invisibleBoardButtonGUI = new InvisibleBoardButtonGUI(propertyImageTemplateLabel, propertyViewMap);

        // add overLayButton to the right pane
        boardSidePane.add(invisibleBoardButtonGUI, JLayeredPane.DRAG_LAYER);
    }

    public void propertyViewSetup(JLayeredPane boardSidePane) throws IOException {

        // view property label
        JLabel viewPropertyLabel;

        for(PropertyTile propertyTile : PropertyTile.values()) {

            // create a button for each property tile
            if(propertyTile == PropertyTile.ELECTRIC_COMPANY || propertyTile == PropertyTile.WATER_WORKS){
                BufferedImage bufferedImage;

                if(propertyTile == PropertyTile.ELECTRIC_COMPANY){
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
            else if(propertyTile == PropertyTile.READING_RAILROAD || propertyTile == PropertyTile.PENNSYLVANIA_RAILROAD || propertyTile == PropertyTile.B_AND_O_RAILROAD || propertyTile == PropertyTile.SHORT_LINE_RAILROAD){
                BufferedImage bufferedImage;

                if(propertyTile == PropertyTile.READING_RAILROAD){
                    bufferedImage = ImageIO.read(new File("src/main/MonopolyImages/ReadingRR.jpg"));
                }
                else if(propertyTile == PropertyTile.PENNSYLVANIA_RAILROAD){
                    bufferedImage = ImageIO.read(new File("src/main/MonopolyImages/PennsylvaniaRR.jpg"));
                }
                else if(propertyTile == PropertyTile.B_AND_O_RAILROAD){
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
            propertyViewPane.add(propertyViewMap.get(propertyTile), JLayeredPane.MODAL_LAYER);
        }
    }

    public HashMap<PropertyTile, Boolean> getEnableSellMap(){
        return enableSellMap;
    }

    public void tileButtonBuilder(PropertyTile propertyTile , JLabel viewPropertyLabel, JLayeredPane boardSidePane) throws IOException {

        // create a button property tile
        tileButtonMap.put(propertyTile, new JButton());

        // modify empty invisible button for property tile
        JButton invisibleTileButton = tileButtonMap.get(propertyTile);

        // adds an invisible button over the property tile
        boardSidePane.add(invisibleTileButton, JLayeredPane.POPUP_LAYER);

        invisibleTileButton.setContentAreaFilled(false); // makes the button clear color
        invisibleTileButton.setBorderPainted(false);     // removes the border color

        // get the x and y coordinates for each property tile
        int buttonXCoordinate = tileButtonCoordinateMap.get(propertyTile).x();
        int buttonYCoordinate = tileButtonCoordinateMap.get(propertyTile).y();

        // property button sizes
        final int tileWidth = 77;
        final int tileHeight = 120;

        int tileIndex = propertyTile.getValue();

        // position each invisible button on the board
        if(tileIndex <= 5) invisibleTileButton.setBounds(buttonXCoordinate, buttonYCoordinate, tileWidth, tileHeight);       // bottom side of board
        else if(tileIndex <= 13) invisibleTileButton.setBounds(buttonXCoordinate, buttonYCoordinate, tileHeight, tileWidth); // left side of board
        else if(tileIndex <= 21) invisibleTileButton.setBounds(buttonXCoordinate, buttonYCoordinate, tileWidth, tileHeight); // top side of board
        else invisibleTileButton.setBounds(buttonXCoordinate, buttonYCoordinate, tileHeight, tileWidth);                     // right side of board

        // setup for closing the last selected tile and also enabling the invisible button
        invisibleTileButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                if (activeView != null) propertyViewMap.get(activeView).setVisible(false);
                // add the property name using the tobeClosed method to the invisible button
                // so that property can be closed when the invisible button is clicked
                invisibleBoardButtonGUI.tobeClosed(propertyTile);

                // set the board button to enabled for clicking
                invisibleBoardButtonGUI.setVisible(true);

                // set the invisible button to enabled for clicking
                propertyViewMap.get(propertyTile).setVisible(true);

                // sets current active tile for tracking
                activeView = propertyTile;

                // prints to console the property clicked
                System.out.println("Element: " + propertyTile);
            }
        });

        // setup for property view
        invisibleTileButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                // if the property is not a utility or railroad, display the property image template and add elements
                if(propertyTile != PropertyTile.ELECTRIC_COMPANY && propertyTile != PropertyTile.WATER_WORKS &&
                        propertyTile != PropertyTile.READING_RAILROAD && propertyTile != PropertyTile.PENNSYLVANIA_RAILROAD &&
                        propertyTile != PropertyTile.B_AND_O_RAILROAD && propertyTile != PropertyTile.SHORT_LINE_RAILROAD){

                    // makes the property image template visible
                    propertyImageTemplateLabel.setVisible(true);

                    // adds elements to property view label
                    addTileElements(viewPropertyLabel, propertyTile);
                }
            }
        });
    }

    public void addTileElements(JLabel viewPropertyLabel, PropertyTile propertyTile){

        // convert the enum to a property name, then to a property
        PropertyNames propertyName = propertyProcessor.convertBoardPropertyTileOrderToPropertyNames(propertyTile);
        Property property = propertyProcessor.getProperty(propertyName);

        // elements get set to blankLabelProperty
        for (JLabel jLabel : elementLabelList) {
            viewPropertyLabel.add(jLabel);
        }

        // set the text for each element
        for(int i = 0; i < elementLabelList.size(); i++) {

            JLabel elementLabel = elementLabelList.get(i);

            if(i != 12){
                elementLabel.setFont(elementLabel.getFont().deriveFont(elementTextSizeList.get(i)));
                elementLabel.setBounds(xCoordinateViewList.get(i), yCoordinateViewList.get(i), propertyViewWidth, propertyViewHeight);
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
                elementLabel.setText(propertyProcessor.convertPropertyNameToString(propertyName)); // title name
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
                elementLabel.setBounds(xCoordinateViewList.get(i), yCoordinateViewList.get(i), 305, 70);
                switch(property.getColor()){
                    case PropertyGroup.BROWN:
                        elementLabel.setBackground(new Color(121,65,54));
                        elementLabelList.get(9).setForeground(Color.WHITE);
                        break;
                    case PropertyGroup.LIGHTBLUE:
                        elementLabel.setBackground(new Color(171,232,241));
                        elementLabelList.get(9).setForeground(Color.BLACK);
                        break;
                    case PropertyGroup.PINK:
                        elementLabel.setBackground(new Color(227,57,194));
                        elementLabelList.get(9).setForeground(Color.BLACK);
                        break;
                    case PropertyGroup.ORANGE:
                        elementLabel.setBackground(new Color(250,182,46));
                        elementLabelList.get(9).setForeground(Color.BLACK);
                        break;
                    case PropertyGroup.RED:
                        elementLabel.setBackground(new Color(250,70,46));
                        elementLabelList.get(9).setForeground(Color.BLACK);
                        break;
                    case PropertyGroup.YELLOW:
                        elementLabel.setBackground(new Color(247,250,51));
                        elementLabelList.get(9).setForeground(Color.BLACK);
                        break;
                    case PropertyGroup.GREEN:
                        elementLabel.setBackground(new Color(14,109,45));
                        elementLabelList.get(9).setForeground(Color.WHITE);
                        break;
                    case PropertyGroup.DARKBLUE:
                        elementLabel.setBackground(new Color(59,54,218));
                        elementLabelList.get(9).setForeground(Color.WHITE);
                        break;
                    case PropertyGroup.UTILITY:
                    case PropertyGroup.RAILROAD:
                        break;
                }
            }
        }
    }

    // puts black border around tiles and sets each tile to be enabled for selling
    public void showSellableProperties(){

        // locates all the properties without houses/hotels owned by the active player
        ArrayList<Property> ownedProperties = propertyProcessor.findActivePlayerPropertiesWithoutImprovements();

        for(Property property : ownedProperties) {
           PropertyTile propertyTile = propertyProcessor.convertNameToTile(property.getPropertyName());

           JButton tileButton = tileButtonMap.get(propertyTile);

           // puts a black border around each player owned property
           tileButton.setBorderPainted(true);
           tileButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 10));

           // sets each property to be sellable for the active player as bool true
           enableSellMap.put(propertyTile, true);
        }
    }

    public void hideSellableProperty(){

        for(Property property : propertyProcessor.getPropertyMap().values()) {
            PropertyTile propertyTile = propertyProcessor.convertNameToTile(property.getPropertyName());

            JButton tileButton = tileButtonMap.get(propertyTile);
            tileButton.setBorderPainted(false);
            //tileButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 10));
        }
    }

    public void setSellablePropertiesFalse(){
        // locates all the properties owned by the active player
//        ArrayList<Property> ownedProperties = propertyProcessor.findSellableProperties();

        // sets each property to be sellable for the active player as bool false
        for(Property property : propertyProcessor.getPropertyMap().values()) {
            PropertyTile propertyTile = propertyProcessor.convertNameToTile(property.getPropertyName());

            //System.out.println(propertyTile.toString() + " Converted");

            enableSellMap.put(propertyTile, false);
        }
    }

    // removes black border and sets the property to not sellable
    public void removeBlackBorderNotSellable(){
        // Set the enable sell bool to false
        setSellablePropertiesFalse();

        // Hide the Black Borders around the property tiles
        hideSellableProperty();
    }

    public void removeRedBorderMortgageProperty(){
        // Hide the Red Borders around the property tiles
        for(Property property : propertyProcessor.getPropertyMap().values()) {
            PropertyTile propertyTile = propertyProcessor.convertNameToTile(property.getPropertyName());

            mortgageMap.put(propertyTile, false);
        }
    }

    public void showMortgageableProperties(PlayerToken playerToken) {
        // Todo complete logic

        // sets the ability to mortgage properties to true
        propertyProcessor.setMortgageFlag();


        // locates all the properties owned by the active player
        ArrayList<Property> ownedProperties = propertyProcessor.findValidPropertiesToMortgage(playerToken);

        System.out.println(ownedProperties.toString());

        // puts a red border around each property that can be mortgaged by the player
        for(Property property : ownedProperties) {
            PropertyTile propertyTile = propertyProcessor.convertNameToTile(property.getPropertyName());

            JButton tileButton = tileButtonMap.get(propertyTile);

            // puts a red border around each active player property that can be mortgaged
            tileButton.setBorderPainted(true);
            tileButton.setBorder(BorderFactory.createLineBorder(Color.RED, 10));

            // sets each property to mortgage for the active player to true
            mortgageMap.put(propertyTile, true);
        }
    }

    // adds a mouse listener to each property tile button to enable mortgaging
    public void showPropertiesThatCanBeMortgaged(PaymentBoxGUI paymentBoxGUI, PropertyProcessorGUI propertyProcessorGUI,
                                             PlayerProcessor playerProcessor, TransactionHistoryGUI transactionHistoryGUI, MoneyProcessor moneyProcessor,
                                                 MortgagePropertyBoxGUI mortgagePropertyBoxGUI, CommandBoxGUI commandBoxGUI) {
        // loop applies a mouse listener to each property tile button when clicked
        for(PropertyTile propertyTile : PropertyTile.values()){
            JButton tile = propertyProcessorGUI.getTileButtonMap().get(propertyTile);
            tile.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e){
                System.out.println("Checking if mortgage property is true for " + propertyTile +  propertyProcessorGUI.getMortgageMap().get(propertyTile));
                // if property in a mortgage map is set to true
                if(propertyProcessorGUI.getMortgageMap().get(propertyTile)) {;

                    setCurrentPropertyToMortgage(propertyTile);
                    mortgagePropertyBoxGUI.mortgagePropertyMenu(propertyProcessorGUI, moneyProcessor, playerProcessor, paymentBoxGUI);
                    commandBoxGUI.setMessage("Changes options to mortgage property");
                }
                }
            });
        }
    }

    public HashMap<PropertyTile, Boolean> getMortgageMap(){
        return mortgageMap;
    }

    record PropertyCoordinates(int x, int y) {
    }

    public void setCurrentPropertyToMortgage(PropertyTile propertyTile){
        currentPropertyToMortgage = propertyTile;
    }
}