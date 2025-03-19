package main.GUI;

import javax.swing.*;
import java.awt.*;

public class InformationPane extends JLayeredPane{

   // private final JLayeredPane informationSidePane;

    public InformationPane() {
        this.setBackground(Color.WHITE);
        this.setBounds(0,0, 500, 1000);
        this.setOpaque(true);
    }

//    public void add(JLabel label) {this.add(label, JLayeredPane.PALETTE_LAYER);}

//    public void add(JButton button) {
//        this.add(button, JLayeredPane.PALETTE_LAYER);
//    }
//
//    public void add(JPanel historyPanel) {
//        this.add(historyPanel, JLayeredPane.PALETTE_LAYER);
//    }
}
