package main.GUI;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class CommandBoxGUI extends JPanel{

    //final private JPanel commandBoxGUIPanel;

    JLabel boxLabel;
    JLabel messageComponent;
    final int emptyLines = 3;

    public CommandBoxGUI() {
        //this = new JPanel();
        this.setBounds(20, 100, 450, 100);
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.setOpaque(false);
        this.setLayout(new GridLayout(0, 1));
        this.setVisible(true);
        boxLabel = new JLabel("<html><u>Command Box</u></html>");
        this.add(boxLabel);
        messageComponent = new JLabel();

        this.add(messageComponent);

        // fill the rest of the panel with empty lines
        // prevents the message from being displayed away from the top of the panel
        for(int i = 0; i < emptyLines; i++){
            this.add(new JLabel());
        }
    }

    public void setMessage(String message){
        messageComponent.setText(message);
    }
}
