package main.GUI;

import main.Functions.PlayerProcessor;

import javax.swing.*;
import java.awt.*;

public class ActivePlayerBoxGUI  extends JPanel {

    private final JLabel activePlayer;

    public ActivePlayerBoxGUI() {
        this.setBounds(370, 30, 100, 50);
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.setOpaque(false);
        this.setLayout(new GridLayout(0, 1));
        this.setVisible(true);
        this.add(new JLabel("<html><u>Active Player</u></html>"));
        activePlayer = new JLabel("None");
        this.add(activePlayer);
    }

    public void setActivePlayer(String player){
        //this.removeAll();
        activePlayer.setText(player);
    }
}
