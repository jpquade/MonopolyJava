package main.GUI;

import main.Enums.PropertyNames;
import main.Enums.TransactionType;
import main.Functions.MoneyProcessor;
import main.Functions.PlayerProcessor;
import main.Functions.PropertyProcessor;

import javax.swing.*;
import java.awt.*;



public class MortgagePropertyBoxGUI extends JPanel{

    private final int MAX_BUTTONS;
    private PropertyProcessor propertyProcessor;
    private JTextField priceField;

    public MortgagePropertyBoxGUI(CommandBoxGUI commandBoxGUI, PropertyProcessor propertyProcessor, ActionBoxManagerGUI actionBoxManagerGUI){
        //this.propertyProcessor = propertyProcessor;
        //this.commandBoxGUI = commandBoxGUI;
        //this.actionBoxManagerGUI = actionBoxManagerGUI;
        //sellPropertySubBoxGUIPanel = new JPanel();

        this.propertyProcessor = propertyProcessor;
        actionBoxManagerGUI.addActionBox(ActionBoxManagerGUI.ActionBoxType.MORTGAGE_PROPERTY_BOX,this);
        MAX_BUTTONS = 12;
        this.setBounds(20, 250, 450, 350);
        this.setLayout(new GridLayout(MAX_BUTTONS, 1));
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.setOpaque(false);
        this.setVisible(false);
    }

    // Todo come up with mortgage list menu
    public void mortgagePropertyMenu(PropertyProcessorGUI propertyProcessorGUI, MoneyProcessor moneyProcessor, PlayerProcessor playerProcessor, PaymentBoxGUI paymentBoxGUI){
        this.setVisible(true);
        this.removeAll();
        this.add(new JLabel("<html><u>Mortgage Property</u></html>"));


        // TODO add "Mortgage Property" name?
        // TODO add Yes no buttons

       // mortgageProperty();
        propertyNameTag();
        priceDisplay();
        yesButton(propertyProcessorGUI, moneyProcessor, playerProcessor, paymentBoxGUI);
        // TODO add cancel button
        cancelButton(propertyProcessorGUI, paymentBoxGUI, playerProcessor);
        // TODO switch from showing mortgage property to click and show menu
    }

    private void mortgageProperty() {
    }

    public void propertyNameTag() {
        PropertyNames propertyNames = propertyProcessor.convertBoardPropertyTileOrderToPropertyNames(propertyProcessor.getCurrentPropertyToMortgage());
        String name = propertyProcessor.convertPropertyNameToString(propertyNames);
        JLabel propertyDisplay = new JLabel("Mortgage " + name + " for dollar amount - ");
        this.add(propertyDisplay);
    }

    public void priceDisplay() {
        priceField = new JTextField(10);
        this.add(priceField);
    }

    public void yesButton(PropertyProcessorGUI propertyProcessorGUI, MoneyProcessor moneyProcessor, PlayerProcessor playerProcessor, PaymentBoxGUI paymentBoxGUI){
        JButton yesButton = new JButton("Yes");
        this.add(yesButton);

        yesButton.addActionListener(e -> {

            // removes red border from all property tiles
            propertyProcessorGUI.removeRedBorderMortgageProperty();

            // TODO add mortgage property code

            // mortgage property
            propertyProcessor.mortgageProperty(propertyProcessor.getCurrentPropertyToMortgage());

            // add money to active player
            moneyProcessor.transactionHandler(TransactionType.BANK_PAY_ACTIVE_PLAYER,
                    playerProcessor.getActivePlayer().getToken(),
                    propertyProcessor.getMortgageValue(propertyProcessor.getCurrentPropertyToMortgage()));

            // return to previous menu

            paymentBoxGUI.paymentOptions(propertyProcessor, playerProcessor);

            this.setVisible(false);
        });
    }

    public void cancelButton(PropertyProcessorGUI propertyProcessorGUI, PaymentBoxGUI paymentBoxGUI, PlayerProcessor playerProcessor){
        JButton cancelButton = new JButton("Cancel");
        this.add(cancelButton);

        cancelButton.addActionListener(e -> {
            // TODO add logic to cancel button
            // remove red border from all property tiles
            propertyProcessorGUI.removeRedBorderMortgageProperty();

            // Set the selection box button panel to visible
            paymentBoxGUI.paymentOptions(propertyProcessor, playerProcessor);

            // Set the MortgagePropertyBoxGUI to not visible
            this.setVisible(false);
        });
    }
}
