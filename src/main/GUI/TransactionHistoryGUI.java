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
        historyPanel.setOpaque(false);
        historyPanel.setLayout(new GridLayout(0, 1));
        historyPanel.setVisible(true);
        historyPanel.add(new JLabel("<html><u>Transaction History</u></html>"));

        historyLinkedList = new LinkedList<>();
        historyLabelArrayList = new ArrayList<>();
        for(int i = 0; i < MAX_HISTORY; i++){
            historyLabelArrayList.add(new JLabel());
            //historyPanel.add(transactionHistoryLabel.get(i));
        }


//        for(int i = MAX_HISTORY - 1; i >= 0; i--){
//            historyPanel.add(historyLabelArrayList.get(i));
//        }
        for(int i = 0; i < MAX_HISTORY; i++){
            historyPanel.add(historyLabelArrayList.get(i));
        }

    }

//    public void addTransaction(String transaction){
//        if(historyLinkedList.size() == MAX_HISTORY){
//            System.out.println(STR."Removed from transaction history - \{historyLinkedList.poll()}");
//        }
//        // add the transaction to the linked list
//        historyLinkedList.offer(transaction);
//
//        for(int i = 0; i < historyLinkedList.size(); i++){
//           //istoryLabelArrayList.get(i).setText(historyLinkedList.get(i));
//
//            // reverse the entry of the linked list into the arraylist
//            historyLabelArrayList.get(i).setText(historyLinkedList.get(historyLinkedList.size() - i - 1));
//        }
//    }

    // transactions added to the top of the list
    public void addTransaction(String transaction){
        if(historyLinkedList.size() == MAX_HISTORY){
            System.out.println("Removed from transaction history - " + historyLinkedList.poll());
        }
        // add the transaction to the linked list
        historyLinkedList.offer(transaction);

        // transactions start at the top and move down in a FIFO manner
        for(int i = 0; i < historyLinkedList.size(); i++){
           //istoryLabelArrayList.get(i).setText(historyLinkedList.get(i));

            // reverse the entry of the linked list into the arraylist
            if(i == 0){
                historyLabelArrayList.get(i).setText(historyLinkedList.get(historyLinkedList.size() - i - 1));
                historyLabelArrayList.get(i).setForeground(Color.BLACK);
            }
            else{
                historyLabelArrayList.get(i).setText(historyLinkedList.get(historyLinkedList.size() - i - 1));
                historyLabelArrayList.get(i).setForeground(Color.LIGHT_GRAY);
            }
            //historyLabelArrayList.get(i).setText(historyLinkedList.get(historyLinkedList.size() - i - 1));
            //historyLabelArrayList.get(i).setText(historyLinkedList.get(i));
        }
    }

    public JPanel getHistoryPanel(){
        return historyPanel;
    }
}
