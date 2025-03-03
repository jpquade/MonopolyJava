package main.GUI;

import main.Enums.PlayerToken;
import main.Enums.PropertyTileOrder;
import main.Enums.TransactionType;
import main.Functions.MoneyProcessor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SellPropertySubBoxGUI {
    private final MoneyProcessor moneyProcessor;
    private final CommandBoxGUI commandBoxGUI;
    final private JPanel sellPropertySubBoxGUIPanel;
    final int MAX_BUTTONS;
    //private final ArrayList<JButton> buttonList;
    private int buttonTempIndex;

    private final JLabel propertyDisplay = new JLabel();

    private final JList<String> list;

    public SellPropertySubBoxGUI(MoneyProcessor moneyProcessor, CommandBoxGUI commandBoxGUI) {
        this.moneyProcessor = moneyProcessor;
        this.commandBoxGUI = commandBoxGUI;
        sellPropertySubBoxGUIPanel = new JPanel();
        MAX_BUTTONS = 10;
        sellPropertySubBoxGUIPanel.setBounds(20, 250, 450, 350);
        sellPropertySubBoxGUIPanel.setLayout(new GridLayout(0, 1));
        sellPropertySubBoxGUIPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        sellPropertySubBoxGUIPanel.setOpaque(false);
        sellPropertySubBoxGUIPanel.setVisible(true);
        sellPropertySubBoxGUIPanel.add(new JLabel("<html><u>Sell Property</u></html>"));
        buttonTempIndex = 0;

        //list = new JList<>();

        String[] playerList = {"Player 1", "Player 2", "Player 3"};
        list = new JList<>(playerList);



//        buttonList = new ArrayList<>();
//        for (int i = 0; i < MAX_BUTTONS; i++) {
//            buttonList.add(new JButton());
//            buttonList.get(i).setHorizontalAlignment(SwingConstants.LEFT);
//            buttonList.get(i).setVisible(false);
//        }
//
//        for (JButton button : buttonList) {
//            sellPropertySubBoxGUI.add(button);
//        }
    }

    public JPanel getSellPropertySubBoxGUIPanel() {
        return sellPropertySubBoxGUIPanel;
    }

    public void propertyDisplay(PropertyTileOrder propertyTile){
        // TODO - add logic
        propertyDisplay.setText("Sell: " + propertyTile.toString());
        sellPropertySubBoxGUIPanel.add(propertyDisplay);
    }

    public void playerListDisplay(){

        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JScrollPane listScroll = new JScrollPane(list);
        sellPropertySubBoxGUIPanel.add(listScroll);
        listScroll.setVisible(true);
        //list.getSelectedIndex();
        System.out.println(list.getSelectedIndex());

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

    public void actionOptions() {
        // TODO - enable this method for use independently

        // clears the button index list for new buttons
        resetButtonIndex();

        String[] financialOptions = {"propertyDisplay", "playerListDisplay"};

        for(String methodName : financialOptions){
            switch(methodName){
                case "propertyDisplay":
                    //payButton(transactionType, otherPlayerToken, cost);
                    break;
                case "playerListDisplay":
                    //sellPropertyButton(propertyProcessorGUI);
                    break;
            }
            incrementButtonIndex();
        }

    }

    // TODO - add sell""
    // add to player
    // add for:
    // confirm/cancel



//    public void actionOptions(TransactionType transactionType, int cost, PlayerToken otherPlayerToken) {
//        resetButtonIndex();
//
//    }

//    public void payButton(TransactionType transactionType, PlayerToken otherPlayerToken, int cost){
//        commandBoxGUI.setMessage("Make a payment");
//        JButton payButton = buttonList.get(buttonTempIndex);
//
//        payButton.setText("Pay: " + cost);
//        payButton.setVisible(true);
//        payButton.addActionListener(new ActionListener() {
//
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                if(moneyProcessor.transactionHandler(transactionType, otherPlayerToken, cost)) {
//                    for (JButton button : buttonList) {
//                        button.setVisible(false);
//                    }
//                }
//            }
//        });
//    }

//    // TODO - Work on this one first
//    // player trades property with another player
//    private void sellPropertyButton(PropertyProcessorGUI propertyProcessorGUI) {
//
//        JButton tradeButton = buttonList.get(buttonTempIndex);
//
//        // TODO - make properties sellable with cash only
//
//        tradeButton.setText("Sell properties");
//        tradeButton.setVisible(true);
//        tradeButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//
//                // make all the financial buttons invisible
//                for(JButton button : buttonList){
//                    button.setVisible(false);
//                }
//                commandBoxGUI.setMessage("Pick a property to trade");
//            }
//
//        });
//        tradeButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                propertyProcessorGUI.showSellableProperty();
//                propertyProcessorGUI.enableSellableProperty();
//            }
//        });
//    }



//    private void unMortgageButton() {
//        // TODO - add logic
//    }
//
//    private void buildHouseButton() {
//        // TODO - add logic
//    }
//
//    private void sellHouseButton() {
//        // TODO - add logic
//    }
//
//    private void buildHotelButton() {
//        // TODO - add logic
//    }
//
//    private void sellHotelButton() {
//        // TODO - add logic
//    }
//
//    private void endTurnButton() {
//        // TODO - add logic
//    }

//    public void sellPropertyOptions(PropertyTileOrder propertyTile){
//        JButton propertyNameButton = new JButton();
//        propertyNameButton.setText("Sell: " + propertyTile.toString());
//
//
//    }

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

//    public void mortgageButton(){
//
//        // need list of properties to sell
//
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
//    }

    // button location index
    private void incrementButtonIndex(){
        buttonTempIndex++;
    }
    // reset button location index
    private void resetButtonIndex(){
        buttonTempIndex = 0;
    }
}
