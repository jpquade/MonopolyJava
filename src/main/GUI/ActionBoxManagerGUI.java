package main.GUI;

import javax.swing.*;
import java.util.HashMap;

public class ActionBoxManagerGUI {

    public enum ActionBoxType {
        SELECTION_BOX,
        SELL_PROPERTY_SUB_BOX,
        PROPERTY_PROCESSOR_GUI,
        MORTGAGE_PROPERTY_BOX
    }

    private final HashMap<ActionBoxType, JPanel> actionBoxTypeJPanelHashMap;

    public ActionBoxManagerGUI() {
        actionBoxTypeJPanelHashMap = new HashMap<>();
    }

    public JPanel getActionBox(ActionBoxType actionBoxType) {
        return actionBoxTypeJPanelHashMap.get(actionBoxType);
    }

    public void addActionBox(ActionBoxType actionBoxType, JPanel jPanel) {
        actionBoxTypeJPanelHashMap.put(actionBoxType, jPanel);
    }
}
