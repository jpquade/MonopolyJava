package main.GUI;

import main.Functions.MoneyProcessor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SelectionBoxButtonGUI {
    final private JPanel selectionBoxButtonPanel;
    final int MAX_BUTTONS = 7;
    private final ArrayList<JButton> buttonList;

    public SelectionBoxButtonGUI() {
        selectionBoxButtonPanel = new JPanel();
        selectionBoxButtonPanel.setBounds(20, 200, 450, 200);
        selectionBoxButtonPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        //moneyPanel.setBackground();
        selectionBoxButtonPanel.setOpaque(false);
        selectionBoxButtonPanel.setLayout(new GridLayout(7, 1));
        //moneyPanel.setBorder(BorderFactory);
        //moneyPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        selectionBoxButtonPanel.setVisible(true);
        selectionBoxButtonPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

        buttonList = new ArrayList<>();
        for (int i = 0; i < MAX_BUTTONS; i++) {
            buttonList.add(new JButton());
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

    public void setButtonList() {
//        buttonList.get(0).setText("Buy Property");
//        buttonList.get(1).setText("Sell Property");
//        buttonList.get(2).setText("Mortgage Property");
//        buttonList.get(3).setText("Unmortgage Property");
//        buttonList.get(4).setText("Build House");
//        buttonList.get(5).setText("Sell House");
//        buttonList.get(6).setText("End Turn");
    }

    // after moving the token to a new location, the player is presented with a menu
    // menu purchase options are determined by boolean values that are called
    // cost < wallet
    // 0 < property count
    // 0 < property count and mortgage count < property count
    // 0 < improvements count
    public void getPaymentOptions(boolean canBuy, boolean propertyExists, boolean unmortgagedExists, boolean improvementsExist, int cost, MoneyProcessor moneyProcessor) {
        if(canBuy){
            buttonList.get(0).setText("Pay: " + cost);
            buttonList.get(0).setVisible(true);
            buttonList.get(0).addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    moneyProcessor.pay(cost);
                    for(JButton button : buttonList){
                        button.setVisible(false);
                    }
                }
            });

            //moneyProcessor.pay(cost);
            //return;
        }
        else if(propertyExists ){
            buttonList.get(1).setText("Sell Property Menu");
            buttonList.get(1).setVisible(true);
            buttonList.get(1).addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    for(JButton button : buttonList){
                        button.setVisible(false);
                    }
                }
            });

            // need list of properties to sell

            if(unmortgagedExists){
                buttonList.get(2).setText("Mortgage Property Menu");
                buttonList.get(2).setVisible(true);
                buttonList.get(2).addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        for(JButton button : buttonList){
                            button.setVisible(false);
                        }
                    }
                });
            }
            if(improvementsExist){
                buttonList.get(3).setText("Build House Menu");
                buttonList.get(3).setVisible(true);
            }
        }
    }

    // after the token movement phase, the normal phase options are presented
    public void getNormalOptions() {
        for (JButton button : buttonList) {
            button.setVisible(true);
        }
    }

}
