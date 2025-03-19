package main.GUI;

import main.Enums.PlayerToken;
import main.Enums.PropertyNames;
import main.Enums.PropertyTile;
import main.Enums.TransactionType;
import main.Functions.MoneyProcessor;
import main.Functions.PlayerProcessor;
import main.Functions.PropertyProcessor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Objects;

import static main.GUI.ActionBoxManagerGUI.ActionBoxType.SELL_PROPERTY_SUB_BOX;

public class SellPropertySubBoxGUI extends JPanel{

    private final PropertyProcessor propertyProcessor;
    private PropertyTile currentPropertyToSell;
    //final private JPanel sellPropertySubBoxGUIPanel;
    final int MAX_BUTTONS;

    private final CommandBoxGUI commandBoxGUI;
    private final ActionBoxManagerGUI actionBoxManagerGUI;

    private PlayerToken selectedPlayer;

    JTextField priceField;



    private enum ButtonType {
        PROPERTY_DISPLAY,
        PRICE_DISPLAY,
        PLAYER_LIST_DISPLAY,
        CONFIRM_BUTTON,
        CANCEL_BUTTON
    }

    public SellPropertySubBoxGUI(CommandBoxGUI commandBoxGUI, PropertyProcessor propertyProcessor, ActionBoxManagerGUI actionBoxManagerGUI) {
        this.propertyProcessor = propertyProcessor;
        this.commandBoxGUI = commandBoxGUI;
        this.actionBoxManagerGUI = actionBoxManagerGUI;
        //sellPropertySubBoxGUIPanel = new JPanel();
        actionBoxManagerGUI.addActionBox(SELL_PROPERTY_SUB_BOX,this);
        MAX_BUTTONS = 12;
        this.setBounds(20, 250, 450, 350);
        this.setLayout(new GridLayout(12, 1));
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.setOpaque(false);
        this.setVisible(false);

    }

//    public JPanel getSellPropertySubBoxGUIPanel() {
//        return this;
//    }

    public void sellingPropertyMenu(SelectionBoxButtonGUI selectionBoxButtonGUI, PropertyProcessorGUI propertyProcessorGUI,
                                    PlayerProcessor playerProcessor, TransactionHistoryGUI transactionHistoryGUI, MoneyProcessor moneyProcessor) {
        // TODO - enable this method for use independently
        this.removeAll();
        this.setVisible(true);
        this.add(new JLabel("<html><u>Sell Property</u></html>"));

        for(ButtonType buttonType : ButtonType.values()){

            switch(buttonType){
                case PROPERTY_DISPLAY:
                    propertyNameTag();
                    break;
                case PRICE_DISPLAY:
                    //playerListDisplay();
                    priceDisplay();
                    break;
                case PLAYER_LIST_DISPLAY:
                    playerListDisplaySetup();
                    break;
                case CONFIRM_BUTTON:
                    confirmButton(playerProcessor, transactionHistoryGUI, moneyProcessor, propertyProcessorGUI, selectionBoxButtonGUI);
                    break;
                case CANCEL_BUTTON:
                    cancelButton(selectionBoxButtonGUI, propertyProcessorGUI);
                    break;
            }
        }
    }

    // adds a mouse listener to each property tile button to enable selling
    public void checkIfSellablePropertySetup(SelectionBoxButtonGUI selectionBoxButtonGUI, PropertyProcessorGUI propertyProcessorGUI,
                                             PlayerProcessor playerProcessor, TransactionHistoryGUI transactionHistoryGUI, MoneyProcessor moneyProcessor) {
        for(PropertyTile propertyTile : PropertyTile.values()){
            JButton tile = propertyProcessorGUI.getTileButtonMap().get(propertyTile);
            tile.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e){
                    if(propertyProcessorGUI.getEnableSellMap().get(propertyTile)) {;
                        setCurrentPropertyToSell(propertyTile);
                        sellingPropertyMenu(selectionBoxButtonGUI, propertyProcessorGUI, playerProcessor, transactionHistoryGUI, moneyProcessor);
                        commandBoxGUI.setMessage("Changes options to sell property");
                    }
                }
            });
        }
    }

    public void propertyNameTag(){
        // TODO - add logic

        PropertyNames propertyNames = propertyProcessor.convertBoardPropertyTileOrderToPropertyNames(currentPropertyToSell);
        String name = propertyProcessor.convertPropertyNameToString(propertyNames);
        JLabel propertyDisplay = new JLabel("Sell " + name + " for dollar amount - ");
        //propertyDisplay.setText("Sell " + name + " for dollar amount - ");
        this.add(propertyDisplay);
    }

    public void priceDisplay(){

        priceField = new JTextField(10);
        this.add(priceField);

//        priceField.addActionListener(e -> {
//            //String cost = priceField.getText();
//            //System.out.println(cost);
//        });
    }

    public void playerListDisplaySetup(){

        //JComboBox<PlayerToken> jComboBox = new JComboBox<>(PlayerToken.values());
        JComboBox<PlayerToken> jComboBox = new JComboBox<>();


        // TODO - add logic to display only players that are active players
        for(PlayerToken playerToken : PlayerToken.values()){
            if(playerToken != PlayerToken.NONE){
                jComboBox.addItem(playerToken);
            }
        }

        jComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //PlayerToken selectedPlayer = PlayerToken.valueOf(Objects.requireNonNull(jComboBox.getSelectedItem()).toString());

                selectedPlayer = PlayerToken.valueOf(Objects.requireNonNull(jComboBox.getSelectedItem()).toString());
                System.out.println("Selected player to Sell to - " + selectedPlayer);
            }
        });

        jComboBox.setVisible(true);
        this.add(jComboBox);

    }

    public void confirmButton(PlayerProcessor playerProcessor, TransactionHistoryGUI transactionHistoryGUI, MoneyProcessor moneyProcessor,
                              PropertyProcessorGUI propertyProcessorGUI, SelectionBoxButtonGUI selectionBoxButtonGUI){
        JButton confirmButton = new JButton();
        confirmButton.setText("Confirm");
        this.add(confirmButton);
        confirmButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                // TODO - add logic to confirm button

                String numberCheck = priceField.getText();

                // check if the input is a number
                try{
                    Integer.parseInt(numberCheck);
                    //System.out.println("Success!");
                    System.out.println("Price: " + numberCheck);

                    // check if a player has been selected
                    if(selectedPlayer != null && selectedPlayer != PlayerToken.NONE){
                        System.out.println(selectedPlayer);

                        int pay = Integer.parseInt(numberCheck);

                        if(playerProcessor.getPlayer(selectedPlayer).getCash() >= pay){

                            moneyProcessor.transactionHandler(TransactionType.OTHER_PLAYER_PAY_ACTIVE_PLAYER, selectedPlayer, pay);

                            System.out.println(currentPropertyToSell + "Before owned by " + propertyProcessor.getProperty(propertyProcessor.convertBoardPropertyTileOrderToPropertyNames(currentPropertyToSell)).getOwner());

                            // sell property to player
                            propertyProcessor.transferProperty(currentPropertyToSell, selectedPlayer);



                            System.out.println(currentPropertyToSell + "After owned by " + propertyProcessor.getProperty(propertyProcessor.convertBoardPropertyTileOrderToPropertyNames(currentPropertyToSell)).getOwner());

                            // Set the sell property sub box to invisible
                            SellPropertySubBoxGUI.this.setVisible(false);

                            // removes black border and sets the property to not sellable
                            propertyProcessorGUI.removeSellablePropertyTile();

                            // Set the selection box button panel to visible
                            selectionBoxButtonGUI.paymentOptions();

                        } else{
                            commandBoxGUI.setMessage("Player does not have enough money to buy property");
                            System.out.println("Player does not have enough money to buy property");
                        }

                    }
                    else{
                        commandBoxGUI.setMessage("Please select a player to sell to");
                        System.out.println("Please select a player to sell to");
                    };

                } catch(NumberFormatException ex){
                    commandBoxGUI.setMessage("Please enter a valid number and try again");
                    System.out.println("Please enter a valid number and try again");
                }
            }
        });
    }

    public void cancelButton(SelectionBoxButtonGUI selectionBoxButtonGUI, PropertyProcessorGUI propertyProcessorGUI){
        JButton cancelButton = new JButton();
        cancelButton.setText("Cancel");
        this.add(cancelButton);
        cancelButton.addActionListener(e -> {

            // Set the sell property sub box to invisible
            this.setVisible(false);

            // removes black border and sets the property to not sellable
            propertyProcessorGUI.removeSellablePropertyTile();

            // Set the selection box button panel to visible
            selectionBoxButtonGUI.paymentOptions();

        });
    }

    public void setCurrentPropertyToSell(PropertyTile propertyTile) {
        currentPropertyToSell = propertyTile;
    }
}
