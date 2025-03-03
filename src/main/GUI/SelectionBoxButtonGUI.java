package main.GUI;

import main.Enums.PlayerToken;
import main.Enums.PropertyTileOrder;
import main.Enums.TransactionType;
import main.Functions.MoneyProcessor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SelectionBoxButtonGUI {
    private final MoneyProcessor moneyProcessor;
    private final CommandBoxGUI commandBoxGUI;
    final private JPanel selectionBoxButtonPanel;
    final int MAX_BUTTONS;
    private final ArrayList<JButton> buttonList;
    private int buttonTempIndex;

    public SelectionBoxButtonGUI(MoneyProcessor moneyProcessor, CommandBoxGUI commandBoxGUI) {
        this.moneyProcessor = moneyProcessor;
        this.commandBoxGUI = commandBoxGUI;
        selectionBoxButtonPanel = new JPanel();
        MAX_BUTTONS = 10;
        selectionBoxButtonPanel.setBounds(20, 250, 450, 350);
        selectionBoxButtonPanel.setLayout(new GridLayout(0, 1));
        selectionBoxButtonPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        selectionBoxButtonPanel.setOpaque(false);
        selectionBoxButtonPanel.setVisible(true);
        selectionBoxButtonPanel.add(new JLabel("<html><u>Selection Buttons</u></html>"));
        buttonTempIndex = 0;

        buttonList = new ArrayList<>();
        for (int i = 0; i < MAX_BUTTONS; i++) {
            buttonList.add(new JButton());
            buttonList.get(i).setHorizontalAlignment(SwingConstants.LEFT);
            buttonList.get(i).setVisible(false);
        }

        for (JButton button : buttonList) {
            selectionBoxButtonPanel.add(button);
        }
    }

    // TODO add buttons for each needed menu option

    public JPanel getSelectionBoxButtonPanel() {
        return selectionBoxButtonPanel;
    }

    public void setButtonList() {}

    public void actionOptions(TransactionType transactionType, int cost, PlayerToken otherPlayerToken, PropertyProcessorGUI propertyProcessorGUI) {
        // TODO - enable this method for use independently

        // clears the button index list for new buttons
        resetButtonIndex();

        String[] financialOptions = {"payButton", "sellPropertyButton", "mortgageButton", "unMortgageButton", "buildHouseButton", "sellHouseButton", "buildHotelButton", "sellHotelButton", "endTurnButton"};

        for(String methodName : financialOptions){
            switch(methodName){
                case "payButton":
                    payButton(transactionType, otherPlayerToken, cost);
                    break;
                case "sellPropertyButton":
                    sellPropertyButton(propertyProcessorGUI);
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
            incrementButtonIndex();
        }

    }

    public void actionOptions(TransactionType transactionType, int cost, PlayerToken otherPlayerToken) {
        resetButtonIndex();

    }

    public void payButton(TransactionType transactionType, PlayerToken otherPlayerToken, int cost){
        commandBoxGUI.setMessage("Make a payment");
        JButton payButton = buttonList.get(buttonTempIndex);

        payButton.setText("Pay: " + cost);
        payButton.setVisible(true);
        payButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(moneyProcessor.transactionHandler(transactionType, otherPlayerToken, cost)) {
                    for (JButton button : buttonList) {
                        button.setVisible(false);
                    }
                }
            }
        });
    }

    // TODO - Work on this one first
    // player trades property with another player
    private void sellPropertyButton(PropertyProcessorGUI propertyProcessorGUI) {

        JButton tradeButton = buttonList.get(buttonTempIndex);

        // TODO - make properties sellable with cash only

        tradeButton.setText("Sell properties");
        tradeButton.setVisible(true);
        tradeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // make all the financial buttons invisible
                for(JButton button : buttonList){
                    button.setVisible(false);
                }
                commandBoxGUI.setMessage("Pick a property to trade");
            }

        });
        tradeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                propertyProcessorGUI.showSellableProperty();
                propertyProcessorGUI.enableSellableProperty();
            }
        });
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

    public void sellPropertyOptions(PropertyTileOrder propertyTile){
        JButton propertyNameButton = new JButton();
        propertyNameButton.setText("Sell: " + propertyTile.toString());


    }

//    public void sellPropertyButton(){
//        buttonList.get(buttonTempIndex).setText("Sell Properties");
//        buttonList.get(buttonTempIndex).setVisible(true);
//        buttonList.get(buttonTempIndex).addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
////                    for(JButton button : buttonList){
////                        button.setVisible(false);
////                    }
//            }
//        });
//    }

    public void mortgageButton(){

        // need list of properties to sell

        buttonList.get(buttonTempIndex).setText("HighLight Properties You Can Mortgage");
        buttonList.get(buttonTempIndex).setVisible(true);
        buttonList.get(buttonTempIndex).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(JButton button : buttonList){
                    button.setVisible(false);
                }
            }
        });
    }

    // button location index
    private void incrementButtonIndex(){
        buttonTempIndex++;
    }
    // reset button location index
    private void resetButtonIndex(){
        buttonTempIndex = 0;
    }
}
