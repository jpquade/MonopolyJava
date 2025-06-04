package main.GUI;

import main.Enums.PlayerToken;
import main.Enums.TransactionType;
import main.Functions.MoneyProcessor;
import main.Functions.PlayerProcessor;
import main.Functions.PropertyProcessor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static main.GUI.ActionBoxManagerGUI.ActionBoxType.SELECTION_BOX;

public class PaymentBoxGUI extends JPanel {
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

    public PaymentBoxGUI(MoneyProcessor moneyProcessor, CommandBoxGUI commandBoxGUI,
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

        enum ButtonType {
            PAY(0),
            SELL_PROPERTY(1),
            MORTGAGE(2),
            UNMORTGAGE(3),
            BUILD_HOUSE(4),
            SELL_HOUSE(5),
            BUILD_HOTEL(6),
            SELL_HOTEL(7),
            END_TURN(8);

            private final int index;

            ButtonType(int index) {
                this.index = index;
            }

            public int getIndex(){
                return index;
            }

            public static ButtonType getButtonType(int index){
                for(ButtonType button : ButtonType.values()){
                    if(button.getIndex() == index){
                        return button;
                    }
                }
                return null;
            }
        }

        for(ButtonType button : ButtonType.values()){
            switch(button){
                case ButtonType.PAY:
                    payButton(cost);
                    break;
                case SELL_PROPERTY:
                    sellPropertyButton(propertyProcessor, playerProcessor);
                    break;
                case MORTGAGE:

                    // TODO - add logic
                    mortgageButton(propertyProcessor, playerProcessor);
                    break;
                case UNMORTGAGE:
                    unMortgageButton();
                    break;
                case BUILD_HOUSE:
                    buildHouseButton();
                    break;
                case SELL_HOUSE:
                    sellHouseButton();
                    break;
                case BUILD_HOTEL:
                    buildHotelButton();
                    break;
                case SELL_HOTEL:
                    sellHotelButton();
                    break;
                case END_TURN:
                    endTurnButton();
                    break;
            }
        }

        this.setVisible(true);
    }

    // uses existing transactionType, cost, and otherPlayerToken
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

                // check if player has properties to sell, if all properties have houses or hotels
                if(propertyProcessor.checkPlayerHasProperties(playerProcessor.getActivePlayer().getToken(), propertyProcessor) &&
                        !propertyProcessor.checkPlayerIfAllPropertiesHaveHousesOrHotels(playerProcessor.getActivePlayer().getToken(), propertyProcessor)){
                    removeAllButtonsPanelInvisible();
                    commandBoxGUI.setMessage("Pick a property to sell");
                    propertyProcessorGUI.showSellableProperties();
                }
                else{
                    commandBoxGUI.setMessage("You do not have any valid properties to sell");
                }
            }
        });

        return sellPropertyButton;
    }

    // player sells property with another player
    private void sellPropertyButton(PropertyProcessor propertyProcessor, PlayerProcessor playerProcessor){
        //JButton tradeButton = buttonMap.get(ButtonType.SELL_PROPERTY);
        JButton tradeButton = sellPropertyButtonSetup(propertyProcessor, playerProcessor);
        visibleAddToPanel(tradeButton);
        tradeButton.setText("Sell properties");
    }

    public void mortgageButton(PropertyProcessor propertyProcessor, PlayerProcessor playerProcessor){
        // TODO - add logic
        // need list of properties to mortgage

        JButton mortgageButton = new JButton();
        mortgageButton.setHorizontalAlignment(SwingConstants.LEFT);

        mortgageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // check if player has properties, if all properties have houses or hotels, or all properties are already mortgaged
                if(propertyProcessor.checkPlayerHasProperties(playerProcessor.getActivePlayer().getToken(), propertyProcessor) &&
                        !propertyProcessor.checkPlayerIfAllPropertiesHaveHousesOrHotels(playerProcessor.getActivePlayer().getToken(), propertyProcessor) &&
                !propertyProcessor.checkPlayerIfAllPropertiesMortgages(playerProcessor.getActivePlayer().getToken(), propertyProcessor)){
                    removeAllButtonsPanelInvisible();
                    commandBoxGUI.setMessage("Pick a property to mortgage");
                    //propertyProcessorGUI.showSellableProperties();
                    propertyProcessorGUI.showMortgageableProperties(playerProcessor.getActivePlayer().getToken());
                    propertyProcessorGUI.showPropertiesThatCanBeMortgaged(paymentBoxGUI, propertyProcessorGUI, playerProcessor, transactionHistoryGUI, moneyProcessor,
                            mortgagePropertyBoxGUI, commandBoxGUI);
                }
                else{
                    commandBoxGUI.setMessage("You do not have any valid properties to mortgage");
                }
            }
        });
        mortgageButton.setText("Mortgage properties");
        visibleAddToPanel(mortgageButton);
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
