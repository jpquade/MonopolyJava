package main.GUI;

import main.Enums.PlayerToken;
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

    private final PropertyProcessor propertyProcessor;
    private final int centerPropertyScaleW;
    private final int centerPropertyScaleH;
    private final ArrayList<JLabel> propertyElementLabelList;
    private final int boardPropertyTileElementCount;

    private final HashMap<PropertyTileOrder, JButton> tileButtonMap;
    private final HashMap<PropertyTileOrder, PropertyCoordinates> propertyBoardLocationsMap;
    private final HashMap<PropertyTileOrder, JLabel> propertyViewLabelMap;
    private JLayeredPane propertyPane;

    // invisible board property tile buttons and positions
    private final ArrayList<Integer> xPropButtonList = new ArrayList<>(Arrays.asList(875,718,562,483,327,249,128,128,128,128,128,128,128,128,249,405,483,561,639,717,796,874,953,953,953,953,953,953));
    private final ArrayList<Integer> yPropButtonList = new ArrayList<>(Arrays.asList(826,826,826,826,826,826,749,671,593,515,437,359,202,124,3,3,3,3,3,3,3,3,123,202,358,436,593,749));

    private final ArrayList<Integer> xLargePropertyPaneList = new ArrayList<>(Arrays.asList(50,250,269,269,269,0,0,0,0,0,0,0,23));
    private final ArrayList<Integer> yLargePropertyPaneList = new ArrayList<>(Arrays.asList(-27,-62,-39,-16,7,47,68,89,110,-140,165,-92,25));

    private final ArrayList<Float> largePropertyTextSizeList = new ArrayList<>(Arrays.asList(17.0F,17.0F,17.0F,17.0F,17.0F,18.0F,18.0F,18.0F,18.0F,26.0F,10.0F,18.0F));

    private BufferedImage propertyImageTemplateBUfferedImage;
    private JLabel propertyImageTemplateLabel;

    private InvisibleOverLayButtonGUI invisibleLargeTileButton;

    public PropertyProcessorGUI(PropertyProcessor propertyProcessor, JLayeredPane boardSidePane) throws IOException {

        this.propertyProcessor = propertyProcessor;
        centerPropertyScaleW = 350;
        centerPropertyScaleH = 400;

        //TODO: Refactor this section to have a hashmap of the property names and their positions

        // large property display and positions of text
        //propertyViewLabelList = new ArrayList<>();
        propertyElementLabelList = new ArrayList<>();
        boardPropertyTileElementCount = 13;

        tileButtonMap = new HashMap<>();
        propertyBoardLocationsMap = new HashMap<>();
        propertyViewLabelMap = new HashMap<>();

        propertyPaneSetup(boardSidePane);
        propertyImageBlankLabelSetup();
        elementLabelListSetup();
        coordinateMapSetup();

        propertyViewSetup(boardSidePane);
        removeViewInvisibleButtonSetup(boardSidePane);

    }

    // add large property display to the board Side Pane
    public void propertyPaneSetup(JLayeredPane boardSidePane){
        propertyPane = new JLayeredPane();
        propertyPane.setBounds(400,250,centerPropertyScaleW,centerPropertyScaleH);
        boardSidePane.add(propertyPane, JLayeredPane.PALETTE_LAYER);
    }

    public void propertyImageBlankLabelSetup() throws IOException {
        propertyImageTemplateBUfferedImage = ImageIO.read(new File("src/main/MonopolyImages/monopolyPropertyBlank.png"));
        propertyImageTemplateLabel = new JLabel(new ImageIcon(propertyImageTemplateBUfferedImage.getScaledInstance(centerPropertyScaleW,centerPropertyScaleH, Image.SCALE_SMOOTH)));
        propertyImageTemplateLabel.setBounds(0,0,centerPropertyScaleW,centerPropertyScaleH);
        propertyImageTemplateLabel.setHorizontalAlignment(0);
        propertyImageTemplateLabel.setVisible(false);

        // Add property template to the propertyPane
        propertyPane.add(propertyImageTemplateLabel, JLayeredPane.DEFAULT_LAYER);
    }

    // create property elements for each blank property tile
    public void elementLabelListSetup(){

        for (int i = 0; i < boardPropertyTileElementCount; i++) {

            propertyElementLabelList.add(new JLabel());
            propertyElementLabelList.get(i).setVisible(true);

        }
    }

    // adds coordinates to every board tile
    public void coordinateMapSetup(){
        for(PropertyTileOrder propertyName: PropertyTileOrder.values()){
            propertyBoardLocationsMap.put(propertyName, new PropertyCoordinates(xPropButtonList.get(propertyName.getValue()), yPropButtonList.get(propertyName.getValue())));
        }
    }

    public void removeViewInvisibleButtonSetup(JLayeredPane boardSidePane){
        // invisible clickable board size button for making large property card view disappear
        invisibleLargeTileButton = new InvisibleOverLayButtonGUI(propertyImageTemplateLabel, propertyViewLabelMap);

        // add overLayButton to the right pane
        boardSidePane.add(invisibleLargeTileButton, JLayeredPane.DRAG_LAYER);
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

                viewPropertyLabel = new JLabel(new ImageIcon(bufferedImage.getScaledInstance(centerPropertyScaleW,centerPropertyScaleH, Image.SCALE_SMOOTH)));
                viewPropertyLabel.setVisible(false);
                viewPropertyLabel.setBounds(0, 0, centerPropertyScaleW, centerPropertyScaleH);
                propertyViewLabelMap.put(propertyTile, viewPropertyLabel);
                //propertyPane.add(jLabel, JLayeredPane.PALETTE_LAYER);
                //largePropertyTileLabelList.add(jLabel);
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

                viewPropertyLabel = new JLabel(new ImageIcon(bufferedImage.getScaledInstance(centerPropertyScaleW,centerPropertyScaleH, Image.SCALE_SMOOTH)));
                viewPropertyLabel.setVisible(false);
                viewPropertyLabel.setBounds(0, 0, centerPropertyScaleW, centerPropertyScaleH);
                propertyViewLabelMap.put(propertyTile, viewPropertyLabel);
            }
            else{
                viewPropertyLabel = new JLabel();
                viewPropertyLabel.setBounds(0,0,centerPropertyScaleW,centerPropertyScaleH);
                //viewPropertyLabel.setHorizontalAlignment(0);
                //viewPropertyLabel.setVisible(true);


                //addTileElements(jLabel, propertyTile);
                propertyViewLabelMap.put(propertyTile, viewPropertyLabel);
            }

            tileButtonBuilder(propertyTile, viewPropertyLabel , boardSidePane);

            // add large property display to the propertyPane
            propertyPane.add(propertyViewLabelMap.get(propertyTile), JLayeredPane.MODAL_LAYER);
        }
    }

    public void tileButtonBuilder(PropertyTileOrder propertyTile ,JLabel viewPropertyLabel, JLayeredPane boardSidePane) throws IOException {

        //TODO: Refactor this section to have a hashmap of the property names and their positions

        // property button sizes
        final int tileWidth = 77;
        final int tileHeight = 120;

        int tileIndex = propertyTile.getValue();
        tileButtonMap.put(propertyTile, new JButton());

        //Property property = propertyProcessor.getProperty(propertyProcessor.convertBoardPropertyTileOrderToPopertyNames(propertyTIleOrder));

        JButton invisibleTileButton = tileButtonMap.get(propertyTile);
        invisibleTileButton.setContentAreaFilled(false); // makes the button clear color
        invisibleTileButton.setBorderPainted(false);     // removes the border color

        int buttonXCoordinate = propertyBoardLocationsMap.get(propertyTile).x();
        int buttonYCoordinate = propertyBoardLocationsMap.get(propertyTile).y();

        // position each invisible button on the board
        if(tileIndex <= 5) invisibleTileButton.setBounds(buttonXCoordinate, buttonYCoordinate, tileWidth, tileHeight);       // bottom side of board
        else if(tileIndex <= 13) invisibleTileButton.setBounds(buttonXCoordinate, buttonYCoordinate, tileHeight, tileWidth); // left side of board
        else if(tileIndex <= 21) invisibleTileButton.setBounds(buttonXCoordinate, buttonYCoordinate, tileWidth, tileHeight); // top side of board
        else invisibleTileButton.setBounds(buttonXCoordinate, buttonYCoordinate, tileHeight, tileWidth);             // right side of board

        invisibleTileButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                invisibleLargeTileButton.setVisible(true);

                // prints to console the property clicked
                System.out.println("Element: " + propertyTile);

                if(propertyTile == PropertyTileOrder.ELECTRIC_COMPANY)              propertyViewLabelMap.get(PropertyTileOrder.ELECTRIC_COMPANY).setVisible(true);
                else if (propertyTile == PropertyTileOrder.WATER_WORKS)             propertyViewLabelMap.get(PropertyTileOrder.WATER_WORKS).setVisible(true);
                else if (propertyTile == PropertyTileOrder.READING_RAILROAD)        propertyViewLabelMap.get(PropertyTileOrder.READING_RAILROAD).setVisible(true);
                else if (propertyTile == PropertyTileOrder.PENNSYLVANIA_RAILROAD)   propertyViewLabelMap.get(PropertyTileOrder.PENNSYLVANIA_RAILROAD).setVisible(true);
                else if (propertyTile == PropertyTileOrder.B_AND_O_RAILROAD)        propertyViewLabelMap.get(PropertyTileOrder.B_AND_O_RAILROAD).setVisible(true);
                else if (propertyTile == PropertyTileOrder.SHORT_LINE_RAILROAD)     propertyViewLabelMap.get(PropertyTileOrder.SHORT_LINE_RAILROAD).setVisible(true);
                else {
                    // contains property image template
                    propertyImageTemplateLabel.setVisible(true);
                    propertyViewLabelMap.get(propertyTile).setVisible(true);

                    // sets all large property display elements to visible if not utility or RR
                    addTileElements(viewPropertyLabel, propertyTile);
                }
            }
        });

        // adds an invisible button over the property tile
        boardSidePane.add(invisibleTileButton, JLayeredPane.POPUP_LAYER);
    }

    public void addTileElements(JLabel viewPropertyLabel, PropertyTileOrder propertyTileOrder){

        // convert the enum to a property name, then to a property
        PropertyNames propertyName = propertyProcessor.convertBoardPropertyTileOrderToPopertyNames(propertyTileOrder);
        Property property = propertyProcessor.getProperty(propertyName);

        // elements get set to blankLabelProperty and set visible
        for (JLabel jLabel : propertyElementLabelList) {
            jLabel.setVisible(true);
            viewPropertyLabel.add(jLabel);
        }

        for(int i = 0; i < propertyElementLabelList.size(); i++) {

            JLabel elementLabel = propertyElementLabelList.get(i);

            if(i != 12){
                elementLabel.setFont(elementLabel.getFont().deriveFont(largePropertyTextSizeList.get(i)));
                elementLabel.setBounds(xLargePropertyPaneList.get(i), yLargePropertyPaneList.get(i), centerPropertyScaleW, centerPropertyScaleH);
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

    public void highLightProperty(PlayerToken playerToken){
        ArrayList<Property> ownedProperties;

        ownedProperties = propertyProcessor.findOwnedProperties(playerToken);

        // TODO - access each propertyTile and highlight it

    }

    record PropertyCoordinates(int x, int y) {
    }
}
