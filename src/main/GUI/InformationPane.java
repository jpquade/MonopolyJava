package main.GUI;

import javax.swing.*;
import java.awt.*;

public class InformationPane {

    private final JLayeredPane informationSidePane;

    public InformationPane() {
        // setup for the information side pane
        informationSidePane = new JLayeredPane();
        informationSidePane.setBackground(Color.WHITE);
        informationSidePane.setBounds(0,0, 500, 1000);
        informationSidePane.setOpaque(true);
    }

    public void add(JLabel label) {
        informationSidePane.add(label, JLayeredPane.PALETTE_LAYER);
    }

    public void add(JButton button) {
        informationSidePane.add(button, JLayeredPane.PALETTE_LAYER);
    }

    public void add(JPanel historyPanel) {
        informationSidePane.add(historyPanel, JLayeredPane.PALETTE_LAYER);
    }

    public JLayeredPane getInformationSidePane() {
        return informationSidePane;
    }
}
