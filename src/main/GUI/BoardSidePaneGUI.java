package main.GUI;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BoardSidePaneGUI extends JLayeredPane {



    public BoardSidePaneGUI(){
        this.setBounds(500,0, 1200, 1000);
        this.setOpaque(true);

        // temporary mouse location listener
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();

                System.out.println("X:" + x + "Y:" + y);
            }
        });

    }
}
