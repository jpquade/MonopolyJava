package main.GUI;

import main.Enums.PlayerToken;
import main.Enums.PropertyTileOrder;
import main.Enums.TransactionType;
import main.Functions.MoneyProcessor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;

public class SelectionBoxButtonGUI {
    private final MoneyProcessor moneyProcessor;
    private final CommandBoxGUI commandBoxGUI;
    final private JPanel selectionBoxButtonPanel;
    final int MAX_BUTTONS;
    private final SellPropertySubBoxGUI sellPropertySubBoxGUI;
    private final PropertyProcessorGUI propertyProcessorGUI;

    private enum ButtonType {
        PAY,
        SELL_PROPERTY,
        MORTGAGE,
        UNMORTGAGE,
        BUILD_HOUSE,
        SELL_HOUSE,
        BUILD_HOTEL,
        SELL_HOTEL,
        END_TURN
    }
    private final HashMap<ButtonType, JButton> buttonMap = new HashMap<>();

    TransactionType transactionType = TransactionType.OTHER_PLAYER_PAY_ACTIVE_PLAYER;
    PlayerToken otherPlayerToken = PlayerToken.NONE;
    int cost = 5000;

    public SelectionBoxButtonGUI(MoneyProcessor moneyProcessor, CommandBoxGUI commandBoxGUI,
                                 PropertyProcessorGUI propertyProcessorGUI, SellPropertySubBoxGUI sellPropertySubBoxGUI) {
        this.moneyProcessor = moneyProcessor;
        this.commandBoxGUI = commandBoxGUI;
        this.sellPropertySubBoxGUI = sellPropertySubBoxGUI;
        this.propertyProcessorGUI = propertyProcessorGUI;
        selectionBoxButtonPanel = new JPanel();
        MAX_BUTTONS = 10;
        selectionBoxButtonPanel.setBounds(20, 250, 450, 350);
        selectionBoxButtonPanel.setLayout(new GridLayout(MAX_BUTTONS, 1));
        selectionBoxButtonPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        selectionBoxButtonPanel.setOpaque(false);
        selectionBoxButtonPanel.setVisible(true);
        buttonSetup(propertyProcessorGUI);
        checkIfSellablePropertySetup();
    }

    // TODO add buttons for each needed menu option

    public JPanel getSelectionBoxButtonPanel() {
        return selectionBoxButtonPanel;
    }



    public void paymentOptions(TransactionType transactionType, int cost, PlayerToken otherPlayerToken, PropertyProcessorGUI propertyProcessorGUI) {
        // TODO - enable this method for use independently

        this.transactionType = transactionType;
        this.cost = cost;
        this.otherPlayerToken = otherPlayerToken;

        System.out.println("Transaction Type: " + transactionType);
        System.out.println("Cost: " + cost);
        System.out.println("Other Player Token: " + otherPlayerToken);

        // remove all buttons
        selectionBoxButtonPanel.removeAll();

        selectionBoxButtonPanel.add(new JLabel("<html><u>Selection Buttons</u></html>"));

        String[] financialOptions = {"payButton", "sellPropertyButton", "mortgageButton", "unMortgageButton", "buildHouseButton", "sellHouseButton", "buildHotelButton", "sellHotelButton", "endTurnButton"};

        for(String methodName : financialOptions){
            switch(methodName){
                case "payButton":
                    payButton(transactionType, otherPlayerToken, cost);
                    break;
                case "sellPropertyButton":
                    sellPropertyButton();
                    break;
                case "mortgageButton":
                    mortgageButton();
                    break;
                case "unMortgageButton":
                    unMortgageButton();
                    break;
                case "buildHouseButton":
                    buildHouseButton();
                    break;
                case "sellHouseButton":
                    sellHouseButton();
                    break;
                case "buildHotelButton":
                    buildHotelButton();
                    break;
                case "sellHotelButton":
                    sellHotelButton();
                    break;
                case "endTurnButton":
                    endTurnButton();
                    break;
            }
        }

        selectionBoxButtonPanel.setVisible(true);

    }

    public void buttonSetup(PropertyProcessorGUI propertyProcessorGUI){
        payButtonSetup();
        sellPropertyButtonSetup(propertyProcessorGUI);
    }

    private void visibleAddToPanel(JButton jButton){
        jButton.setVisible(true);
        selectionBoxButtonPanel.add(jButton);
    }

    private void removeAllButtonsPanelInvisible(){
        selectionBoxButtonPanel.removeAll();
        selectionBoxButtonPanel.setVisible(false);
    }

    // adds a mouse listener to each property tile button to enable selling
    public void checkIfSellablePropertySetup(){
//        // sets all properties to be false for selling
//        for(PropertyTileOrder propertyTile : PropertyTileOrder.values()){
//            enableSellMap.put(propertyTile, false);
//        }

        for(PropertyTileOrder propertyTile : PropertyTileOrder.values()){
            JButton tile = propertyProcessorGUI.getTileButtonMap().get(propertyTile);
            tile.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e){

                    //System.out.println(enableSellMap.get(propertyTile));
                    if(propertyProcessorGUI.getEnableSellMap().get(propertyTile)) {
                        // sell property
                        System.out.println("Sell Property: " + propertyTile);
                        //getSelectionBoxButtonPanel().setVisible(false);
                        sellPropertySubBoxGUI.retrieveProperty(propertyTile);
                        sellPropertySubBoxGUI.getSellPropertySubBoxGUIPanel().setVisible(true);
                        sellPropertySubBoxGUI.sellingPropertyMenu();

                    }
                }
            });
        }
    }

    private void payButtonSetup(){
        JButton payB = new JButton();
        payB.setHorizontalAlignment(SwingConstants.LEFT);
        payB.setVisible(false);
        //payB.setPreferredSize(new Dimension(200, 50));
        payB.addActionListener(e -> {
            if(moneyProcessor.transactionHandler(transactionType, otherPlayerToken, cost)) {
                removeAllButtonsPanelInvisible();
                //selectionBoxButtonPanel.add(new JLabel("<html><u>Selection Buttons</u></html>"));
            }
        });

        buttonMap.put(ButtonType.PAY, payB);
    }

    public void payButton(TransactionType transactionType, PlayerToken otherPlayerToken, int cost){
        commandBoxGUI.setMessage("Make a payment");

        JButton payB = buttonMap.get(ButtonType.PAY);
        payB.setText("Pay: " + cost);
        visibleAddToPanel(payB);
    }

    private void sellPropertyButtonSetup(PropertyProcessorGUI propertyProcessorGUI){
        JButton jButton = new JButton();
        jButton.setHorizontalAlignment(SwingConstants.LEFT);
        jButton.setVisible(false);

        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeAllButtonsPanelInvisible();
                commandBoxGUI.setMessage("Pick a property to sell");
            }

        });
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                propertyProcessorGUI.showSellableProperty();
                propertyProcessorGUI.enableSellableProperty();
            }
        });

        buttonMap.put(ButtonType.SELL_PROPERTY, jButton);
    }



    // TODO - Work on this one first
    // player trades property with another player
    private void sellPropertyButton() {
        JButton tradeButton = buttonMap.get(ButtonType.SELL_PROPERTY);
        tradeButton.setText("Sell properties");

        visibleAddToPanel(tradeButton);
    }

    private void unMortgageButton() {
        // TODO - add logic
    }

    private void buildHouseButton() {
        // TODO - add logic
    }

    private void sellHouseButton() {
        // TODO - add logic
    }

    private void buildHotelButton() {
        // TODO - add logic
    }

    private void sellHotelButton() {
        // TODO - add logic
    }

    private void endTurnButton() {
        // TODO - add logic
    }

    public void mortgageButton(){

        // need list of properties to sell

//        buttonList.get(buttonTempIndex).setText("HighLight Properties You Can Mortgage");
//        buttonList.get(buttonTempIndex).setVisible(true);
//        buttonList.get(buttonTempIndex).addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                for(JButton button : buttonList){
//                    button.setVisible(false);
//                }
//            }
//        });
    }
}
