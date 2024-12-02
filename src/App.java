import Data.GameData;
import GUI.BoardGUI;
import Misc.Dice;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class App {
    public static void main(String[] args) throws IOException {
//        TurnTracker turnTracker = new TurnTracker();
//        turnTracker.turnProgression();
        GameData gameData = new GameData();
        LinkedHashMap<Integer, ArrayList<Integer>> dogMovement  = new LinkedHashMap<>();
        //ArrayList<ArrayList> locationTracker = new ArrayList<>();

        //dogMovement.put(0, new ArrayList<>(Arrays.asList(0, 1)));

        Dice dice = new Dice();
        BoardGUI boardGUI = new BoardGUI(dice, gameData.getPropertyFinancialsMap(),gameData.getSinglePropertyBoardData(), gameData.getPropertyAttributesMap());
        //boardGUI.drawCardGUI.drawACard();

    }
}