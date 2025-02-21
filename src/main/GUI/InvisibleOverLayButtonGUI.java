package main.GUI;

import main.Enums.PropertyTileOrder;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.HashMap;

public class InvisibleOverLayButtonGUI extends JButton {

    public InvisibleOverLayButtonGUI(JLayeredPane pane, HashMap<String, JLabel> labelMap){
        this.setBounds(0,0, 1200, 950);
        this.setOpaque(false);
        this.setContentAreaFilled(false);
        this.setBorderPainted(false);
        this.setVisible(false);

        setMouseListener(pane, labelMap, this);
    }

    public InvisibleOverLayButtonGUI(JLabel label, ArrayList<JLabel> labelList){
        this.setBounds(0,0, 1200, 950);
        this.setOpaque(false);
        this.setContentAreaFilled(false);
        this.setBorderPainted(false);
        this.setVisible(false);

        setMouseListener(label, labelList, this);
    }

    public InvisibleOverLayButtonGUI(JLayeredPane pane, ArrayList<JLabel> labelList){
        this.setBounds(0,0, 1200, 950);
        this.setOpaque(false);
        this.setContentAreaFilled(false);
        this.setBorderPainted(false);
        this.setVisible(false);

        setMouseListener(pane, labelList, this);
    }

    public InvisibleOverLayButtonGUI(JLabel propertyImageTemplateLabel, HashMap<PropertyTileOrder, JLabel> propertyViewLabelMap) {
        this.setBounds(0,0, 1200, 950);
        this.setOpaque(false);
        this.setContentAreaFilled(false);
        this.setBorderPainted(false);
        this.setVisible(false);

        setMouseListener(propertyImageTemplateLabel, propertyViewLabelMap, this);
    }

    private void setMouseListener(JLabel propertyImageTemplateLabel, HashMap<PropertyTileOrder, JLabel> propertyViewLabelMap, InvisibleOverLayButtonGUI invisibleOverLayButtonGUI) {
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Property Button Clicked");
                invisibleOverLayButtonGUI.setVisible(false);
                propertyImageTemplateLabel.setVisible(false);
                // TODO: only make the active view invisible
                // large property view text set to invisible
                for (JLabel jLabel : propertyViewLabelMap.values()) {
                    jLabel.setVisible(false);
                }
            }
        });

    }

    private void setMouseListener(JLayeredPane pane, HashMap<String, JLabel> labelMap, InvisibleOverLayButtonGUI currentButton){

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Property Button Clicked");
                currentButton.setVisible(false);
                pane.setVisible(false);

                // large property view text set to invisible
                for (JLabel jLabel : labelMap.values()) {
                    jLabel.setVisible(false);
                }
            }
        });
    }

    /**
     * Sets the mouse listener for the invisible property button.
     *
     * @param label The label associated with the button.
     * @param labelList The list of labels to be controlled by the button.
     * @param currentButton The current instance of InvisibleOverLayButtonGUI.
     */
    private void setMouseListener(JLabel label, ArrayList<JLabel> labelList, InvisibleOverLayButtonGUI currentButton){

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Property Button Clicked");
                currentButton.setVisible(false);
                label.setVisible(false);
                //singlePropertyDisplayLabel.setVisible(false);

                // property view text set to invisible
                for (JLabel jLabel : labelList) {
                    jLabel.setVisible(false);
                }
            }
        });
    }

    /**
     * Sets the mouse listener for the invisible card button.
     *
     * @param pane The layered pane associated with the button.
     * @param labelList The list of labels to be controlled by the button.
     * @param currentButton The current instance of InvisibleOverLayButtonGUI.
     */
    private void setMouseListener(JLayeredPane pane, ArrayList<JLabel> labelList, InvisibleOverLayButtonGUI currentButton){

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Card Button Clicked");
                currentButton.setVisible(false);
                pane.setVisible(false);

                // large property view text set to invisible
                for (JLabel jLabel : labelList) {
                    jLabel.setVisible(false);
                }
            }
        });
    }
}
