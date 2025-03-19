package main.GUI;

import main.Enums.PlayerToken;
import main.Enums.TransactionType;
import main.Functions.MoneyProcessor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import static main.GUI.ActionBoxManagerGUI.ActionBoxType.SELECTION_BOX;

public class SelectionBoxButtonGUI extends JPanel {
    private final MoneyProcessor moneyProcessor;
    private final CommandBoxGUI commandBoxGUI;
    //final private JPanel selectionBoxButtonPanel;
    final int MAX_BUTTONS;
    private final SellPropertySubBoxGUI sellPropertySubBoxGUI;
    private final PropertyProcessorGUI propertyProcessorGUI;
    private final ActionBoxManagerGUI actionBoxManagerGUI;

    private final HashMap<ButtonType, JButton> buttonMap = new HashMap<>();

    private TransactionType transactionType = TransactionType.OTHER_PLAYER_PAY_ACTIVE_PLAYER;
    private PlayerToken otherPlayerToken = PlayerToken.NONE;
    private int cost = 5000;

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

    public SelectionBoxButtonGUI(MoneyProcessor moneyProcessor, CommandBoxGUI commandBoxGUI,
                                 PropertyProcessorGUI propertyProcessorGUI, SellPropertySubBoxGUI sellPropertySubBoxGUI,
                                 ActionBoxManagerGUI actionBoxManagerGUI) {
        this.moneyProcessor = moneyProcessor;
        this.commandBoxGUI = commandBoxGUI;
        this.sellPropertySubBoxGUI = sellPropertySubBoxGUI;
        this.propertyProcessorGUI = propertyProcessorGUI;
        this.actionBoxManagerGUI = actionBoxManagerGUI;
        //selectionBoxButtonPanel = new JPanel();
        actionBoxManagerGUI.addActionBox(SELECTION_BOX, this);

        MAX_BUTTONS = 10;
        this.setBounds(20, 250, 450, 350);
        this.setLayout(new GridLayout(MAX_BUTTONS, 1));
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.setOpaque(false);
        this.setVisible(true);
        buttonSetup(propertyProcessorGUI);
        //checkIfSellablePropertySetup(selectionBoxButtonGUI);
    }

    public void paymentMenuList(){

        // remove all buttons from this panel
        this.removeAll();

        this.setVisible(true);

        this.add(new JLabel("<html><u>Selection Buttons</u></html>"));

        String[] financialOptions = {"payButton", "sellPropertyButton", "mortgageButton", "unMortgageButton", "buildHouseButton", "sellHouseButton", "buildHotelButton", "sellHotelButton", "endTurnButton"};

        for(String methodName : financialOptions){
            switch(methodName){
                case "payButton":
                    payButton(cost);
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
    }

    // uses existint transactionType, cost, and otherPlayerToken
    public void paymentOptions() {
        paymentMenuList();
    }

    // updates values with parameters
    public void paymentOptions(TransactionType transactionType, int cost, PlayerToken otherPlayerToken) {

        this.transactionType = transactionType;
        this.cost = cost;
        this.otherPlayerToken = otherPlayerToken;

        paymentMenuList();
    }

    public void buttonSetup(PropertyProcessorGUI propertyProcessorGUI){
        payButtonSetup();
        sellPropertyButtonSetup(propertyProcessorGUI);
    }

    private void visibleAddToPanel(JButton jButton){
        jButton.setVisible(true);
        this.add(jButton);
    }

    private void removeAllButtonsPanelInvisible(){
        this.removeAll();
        this.setVisible(false);
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

    public void payButton(int cost){
        commandBoxGUI.setMessage("Make a payment");

        JButton payB = buttonMap.get(ButtonType.PAY);
        payB.setText("Pay: " + cost);
        visibleAddToPanel(payB);
    }

    private void sellPropertyButtonSetup(PropertyProcessorGUI propertyProcessorGUI){
        JButton sellPropertyButton = new JButton();
        sellPropertyButton.setHorizontalAlignment(SwingConstants.LEFT);
        sellPropertyButton.setVisible(false);

        sellPropertyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeAllButtonsPanelInvisible();
                commandBoxGUI.setMessage("Pick a property to sell");
            }

        });
        sellPropertyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                propertyProcessorGUI.showSellableProperty();
                propertyProcessorGUI.enableSellableProperty();
            }
        });

        buttonMap.put(ButtonType.SELL_PROPERTY, sellPropertyButton);
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
