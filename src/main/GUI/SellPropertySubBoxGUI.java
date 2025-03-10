package main.GUI;

import main.Enums.PlayerToken;
import main.Enums.PropertyNames;
import main.Enums.PropertyTileOrder;
import main.Functions.MoneyProcessor;
import main.Functions.PropertyProcessor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

public class SellPropertySubBoxGUI {

    private final PropertyProcessor propertyProcessor;
    private PropertyTileOrder currentPropertyName;
    final private JPanel sellPropertySubBoxGUIPanel;
    final int MAX_BUTTONS;

    private final JLabel propertyDisplay = new JLabel();

    //private final JList<String> list;

    private enum ButtonType {
        PROPERTY_DISPLAY,
        PRICE_DISPLAY,
        PLAYER_LIST_DISPLAY,
        CONFIRM_BUTTON,
        CANCEL_BUTTON
    }

    public SellPropertySubBoxGUI(MoneyProcessor moneyProcessor, CommandBoxGUI commandBoxGUI, PropertyProcessor propertyProcessor) {
        this.propertyProcessor = propertyProcessor;
        sellPropertySubBoxGUIPanel = new JPanel();
        MAX_BUTTONS = 12;
        sellPropertySubBoxGUIPanel.setBounds(20, 250, 450, 350);
        sellPropertySubBoxGUIPanel.setLayout(new GridLayout(12, 1));
        sellPropertySubBoxGUIPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        sellPropertySubBoxGUIPanel.setOpaque(false);
        sellPropertySubBoxGUIPanel.setVisible(false);
        sellPropertySubBoxGUIPanel.add(new JLabel("<html><u>Sell Property</u></html>"));

        sellPropertySubBoxGUIPanel.add(propertyDisplay);
    }

    public JPanel getSellPropertySubBoxGUIPanel() {
        return sellPropertySubBoxGUIPanel;
    }

    public void sellingPropertyMenu() {
        // TODO - enable this method for use independently

        sellPropertySubBoxGUIPanel.removeAll();
        sellPropertySubBoxGUIPanel.add(new JLabel("<html><u>Sell Property</u></html>"));

        for(ButtonType buttonType : ButtonType.values()){

            switch(buttonType){
                case PROPERTY_DISPLAY:
                    propertyNameTag();
                    break;
                case PRICE_DISPLAY:
                    playerListDisplay();
                    break;
                case PLAYER_LIST_DISPLAY:
                    break;
                case CONFIRM_BUTTON:
                    break;
                case CANCEL_BUTTON:
                    break;
            }
        }
        sellPropertySubBoxGUIPanel.setVisible(true);

    }

    public void propertyNameTag(){
        // TODO - add logic
        PropertyNames propertyNames = propertyProcessor.convertBoardPropertyTileOrderToPropertyNames(currentPropertyName);
        String name = propertyProcessor.convertPropertyNameToString(propertyNames);
        propertyDisplay.setText("Sell: " + name + " to: ");
        sellPropertySubBoxGUIPanel.add(propertyDisplay);
    }

    public void priceDisplay(){
        // TODO - add logic
        
    }

    public void playerListDisplay(){

        HashMap<String, PlayerToken> playerList = new HashMap<>();

        for(PlayerToken playerToken : PlayerToken.values()){
            if(playerToken != PlayerToken.NONE){
                playerList.put(playerToken.toString(), playerToken);
            }
        }

        JComboBox<String> jComboBox = new JComboBox<>(playerList.keySet().toArray(new String[0]));
        jComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedPlayer = (String)jComboBox.getSelectedItem();

                System.out.println(selectedPlayer);
            }
        });

        sellPropertySubBoxGUIPanel.add(jComboBox);

        //System.out.println(list.getSelectedIndex());

    }

    public void confirmButton(){
        JButton confirmButton = new JButton();
        confirmButton.setText("Confirm");
        sellPropertySubBoxGUIPanel.add(confirmButton);
        confirmButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public void retrieveProperty(PropertyTileOrder propertyTile) {
        currentPropertyName = propertyTile;
    }
}
