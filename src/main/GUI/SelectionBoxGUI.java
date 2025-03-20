package main.GUI;

import main.Enums.PlayerToken;
import main.Enums.TransactionType;
import main.Functions.MoneyProcessor;
import main.Functions.PlayerProcessor;
import main.Functions.PropertyProcessor;
import main.Properties.Property;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static main.GUI.ActionBoxManagerGUI.ActionBoxType.SELECTION_BOX;

public class SelectionBoxGUI extends JPanel {
    private final MoneyProcessor moneyProcessor;
    private final CommandBoxGUI commandBoxGUI;
    //final private JPanel selectionBoxButtonPanel;
    final int MAX_BUTTONS;
    private final SellPropertyBoxGUI sellPropertyBoxGUI;
    private final PropertyProcessorGUI propertyProcessorGUI;
    private final ActionBoxManagerGUI actionBoxManagerGUI;

    //private final HashMap<ButtonType, JButton> buttonMap = new HashMap<>();

    private TransactionType transactionType;
    private PlayerToken otherPlayerToken;
    private int cost;

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

    public SelectionBoxGUI(MoneyProcessor moneyProcessor, CommandBoxGUI commandBoxGUI,
                           PropertyProcessorGUI propertyProcessorGUI, SellPropertyBoxGUI sellPropertyBoxGUI,
                           ActionBoxManagerGUI actionBoxManagerGUI) {
        this.moneyProcessor = moneyProcessor;
        this.commandBoxGUI = commandBoxGUI;
        this.sellPropertyBoxGUI = sellPropertyBoxGUI;
        this.propertyProcessorGUI = propertyProcessorGUI;
        this.actionBoxManagerGUI = actionBoxManagerGUI;
        actionBoxManagerGUI.addActionBox(SELECTION_BOX, this);

        MAX_BUTTONS = 10;
        this.setBounds(20, 250, 450, 350);
        this.setLayout(new GridLayout(MAX_BUTTONS, 1));
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.setOpaque(false);
        this.setVisible(true);
        //buttonSetup(propertyProcessorGUI);
    }

    public void paymentMenuList(PropertyProcessor propertyProcessor, PlayerProcessor playerProcessor) {

        // remove all buttons from this panel
        //this.removeAll();

        this.add(new JLabel("<html><u>Selection Buttons</u></html>"));

        String[] financialOptions = {"payButton", "sellPropertyButton", "mortgageButton", "unMortgageButton", "buildHouseButton", "sellHouseButton", "buildHotelButton", "sellHotelButton", "endTurnButton"};

        for(String methodName : financialOptions){
            switch(methodName){
                case "payButton":
                    payButton(cost);
                    break;
                case "sellPropertyButton":
                    sellPropertyButton(propertyProcessor, playerProcessor);
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

        this.setVisible(true);
    }

    // uses existint transactionType, cost, and otherPlayerToken
    public void paymentOptions(PropertyProcessor propertyProcessor, PlayerProcessor playerProcessor) {
        paymentMenuList(propertyProcessor, playerProcessor);
    }

    // updates values with parameters
    public void paymentOptions(TransactionType transactionType, int cost, PlayerToken otherPlayerToken, PropertyProcessor propertyProcessor, PlayerProcessor playerProcessor) {

        this.transactionType = transactionType;
        this.cost = cost;
        this.otherPlayerToken = otherPlayerToken;

        paymentMenuList(propertyProcessor, playerProcessor);
    }

    public void buttonSetup(PropertyProcessorGUI propertyProcessorGUI){
        //payButtonSetup();
        //sellPropertyButtonSetup();
    }

    private void visibleAddToPanel(JButton jButton){

        this.add(jButton);
        jButton.setVisible(true);
    }

    private void removeAllButtonsPanelInvisible(){
        this.removeAll();
        this.setVisible(false);
    }

    private JButton payButtonSetup(){
        JButton payB = new JButton();
        payB.setHorizontalAlignment(SwingConstants.LEFT);
        //payB.setVisible(false);
        //payB.setPreferredSize(new Dimension(200, 50));
        payB.addActionListener(e -> {
            if(moneyProcessor.transactionHandler(transactionType, otherPlayerToken, cost)) {
                removeAllButtonsPanelInvisible();
                //selectionBoxButtonPanel.add(new JLabel("<html><u>Selection Buttons</u></html>"));
            }
        });

        return payB;

        //buttonMap.put(ButtonType.PAY, payB);
    }

    public void payButton(int cost){
        commandBoxGUI.setMessage("Make a payment");

        JButton payB = payButtonSetup();
        visibleAddToPanel(payB);
        payB.setText("Pay: " + cost);

    }

    private JButton sellPropertyButtonSetup(PropertyProcessor propertyProcessor, PlayerProcessor playerProcessor){
        JButton sellPropertyButton = new JButton();
        sellPropertyButton.setHorizontalAlignment(SwingConstants.LEFT);
        //sellPropertyButton.setVisible(false);

        sellPropertyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // if player has properties then go to sell property box
                if(propertyProcessor.checkPlayerHasProperties(playerProcessor.getActivePlayer().getToken(), propertyProcessor)) {
                    removeAllButtonsPanelInvisible();
                    commandBoxGUI.setMessage("Pick a property to sell");
                    propertyProcessorGUI.showSellableProperties();
                }
            }

        });

//        sellPropertyButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                checkPlayerHasProperties(PlayerToken playerToken, PropertyProcessor propertyProcessor)
//            }
//        });

        //buttonMap.put(ButtonType.SELL_PROPERTY, sellPropertyButton);

        return sellPropertyButton;
    }

    // player sells property with another player
    private void sellPropertyButton(PropertyProcessor propertyProcessor, PlayerProcessor playerProcessor){
        //JButton tradeButton = buttonMap.get(ButtonType.SELL_PROPERTY);
        JButton tradeButton = sellPropertyButtonSetup(propertyProcessor, playerProcessor);
        visibleAddToPanel(tradeButton);
        tradeButton.setText("Sell properties");
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

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public PlayerToken getOtherPlayerToken() {
        return otherPlayerToken;
    }

    public int getCost() {
        return cost;
    }
}
