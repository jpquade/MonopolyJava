package main.GUI;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;

public class TransactionHistoryGUI {

    private final JPanel historyPanel;
    private final LinkedList<String> historyLinkedList;
    private final ArrayList<JLabel> historyLabelArrayList;
    private final int MAX_HISTORY = 6;


    public TransactionHistoryGUI(){

        historyPanel = new JPanel();
        historyPanel.setBounds(20, 850, 450, 100);
        historyPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        //moneyPanel.setBackground();
        historyPanel.setOpaque(false);
        historyPanel.setLayout(new GridLayout(7, 1));
        //moneyPanel.setBorder(BorderFactory);
        //moneyPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        historyPanel.setVisible(true);
        historyPanel.setAlignmentX(Component.LEFT_ALIGNMENT);


        historyLinkedList = new LinkedList<>();
        historyLabelArrayList = new ArrayList<>();
        for(int i = 0; i < MAX_HISTORY; i++){
            historyLabelArrayList.add(new JLabel());
            //historyPanel.add(transactionHistoryLabel.get(i));
        }
        historyPanel.add(new JLabel("<html><u>Transaction History</u></html>"));

        for(int i = MAX_HISTORY - 1; i >= 0; i--){
            historyPanel.add(historyLabelArrayList.get(i));
        }
    }

    public void addTransaction(String transaction){
        if(historyLinkedList.size() == MAX_HISTORY){
            System.out.println(STR."Removed from transaction history - \{historyLinkedList.poll()}");
        }
        // add the transaction to the linked list
        historyLinkedList.offer(transaction);

        for(int i = 0; i < historyLinkedList.size(); i++){
           //istoryLabelArrayList.get(i).setText(historyLinkedList.get(i));

            // reverse the entry of the linked list into the arraylist
            historyLabelArrayList.get(i).setText(historyLinkedList.get(historyLinkedList.size() - i - 1));
        }
    }

    public JPanel getHistoryPanel(){
        return historyPanel;
    }
}
