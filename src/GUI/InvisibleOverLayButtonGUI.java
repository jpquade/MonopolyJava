package GUI;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class InvisibleOverLayButtonGUI extends JButton {

    public InvisibleOverLayButtonGUI(JLabel label, ArrayList<JLabel> labelList){
        this.setBounds(0,0, 1200, 950);
        this.setOpaque(false);
        this.setContentAreaFilled(false);
        this.setBorderPainted(false);
        this.setVisible(false);

        setMouseListener(label, labelList, this);
    }

    public InvisibleOverLayButtonGUI(JLabel label){
        this.setBounds(0,0, 1200, 950);
        this.setOpaque(false);
        this.setContentAreaFilled(false);
        this.setBorderPainted(false);
        this.setVisible(false);

        setMouseListener(label, this);
    }

    private void setMouseListener(JLabel label, ArrayList<JLabel> labelList, InvisibleOverLayButtonGUI currentButton){

            this.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    currentButton.setVisible(false);
                    label.setVisible(false);

                    // large property view text set to invisible
                    for (JLabel jLabel : labelList) {
                        jLabel.setVisible(false);
                    }
                }

                @Override
                public void mousePressed(MouseEvent e) {

                }

                @Override
                public void mouseReleased(MouseEvent e) {

                }

                @Override
                public void mouseEntered(MouseEvent e) {

                }

                @Override
                public void mouseExited(MouseEvent e) {

                }
            });
    }

    private void setMouseListener(JLabel label, InvisibleOverLayButtonGUI currentButton){

        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                currentButton.setVisible(false);
                label.setVisible(false);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }
}
