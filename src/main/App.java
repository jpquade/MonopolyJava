package main;

import main.Data.GameData;
import main.Enums.PlayerToken;
import main.GUI.BoardGUI;
import main.GUI.DrawCardGUI;
import main.Functions.Dice;
import main.Functions.PlayerList;
import main.LocationFunctions.LocationProcessor;

import javax.xml.stream.Location;
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
        PlayerList playerList = new PlayerList();
        LocationProcessor locationProcessor = new LocationProcessor();
        playerList.createPlayer(PlayerToken.CAR);
        playerList.createPlayer(PlayerToken.CAT);
        playerList.createPlayer(PlayerToken.SHOE);
        BoardGUI boardGUI = new BoardGUI(dice, gameData.getPropertyFinancialsMap(),gameData.getSinglePropertyBoardData(), gameData.getPropertyAttributesMap(), playerList,locationProcessor);
        DrawCardGUI drawCardGUI = new DrawCardGUI(boardGUI.rLayeredPane);
        //System.out.println(drawCardGUI.drawAChanceCard().toString());
        //System.out.println(drawCardGUI.drawACommunityChestCard().toString());


    }
}