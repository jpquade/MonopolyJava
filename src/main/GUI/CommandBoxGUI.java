package main.GUI;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class CommandBoxGUI {

    final private JPanel commandBoxGUIPanel;

    JLabel boxLabel;
    JLabel messageComponent;
    final int emptyLines = 3;

    public CommandBoxGUI() {
        commandBoxGUIPanel = new JPanel();
        commandBoxGUIPanel.setBounds(20, 100, 450, 100);
        commandBoxGUIPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        commandBoxGUIPanel.setOpaque(false);
        commandBoxGUIPanel.setLayout(new GridLayout(0, 1));
        commandBoxGUIPanel.setVisible(true);
        boxLabel = new JLabel("<html><u>Command Box</u></html>");
        commandBoxGUIPanel.add(boxLabel);
        messageComponent = new JLabel();

        commandBoxGUIPanel.add(messageComponent);

        // fill the rest of the panel with empty lines
        // prevents the message from being displayed away from the top of the panel
        for(int i = 0; i < emptyLines; i++){
            commandBoxGUIPanel.add(new JLabel());
        }
    }

    public void setMessage(String message){
        messageComponent.setText(message);
    }

    public JPanel getCommandBoxGUIPanel() {
        return commandBoxGUIPanel;
    }
}
