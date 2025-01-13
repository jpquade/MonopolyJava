package main;

import main.Data.GameData;
import main.Enums.PlayerToken;
import main.GUI.BoardGUI;
import main.GUI.DrawCardGUI;
import main.Functions.Dice;
import main.Functions.PlayerList;
import main.GUI.TokenGUI;
import main.LocationFunctions.LocationProcessor;

import javax.swing.*;
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
        JLayeredPane boardSidePane = new JLayeredPane();
        TokenGUI tokenGUI = new TokenGUI(boardSidePane);
        playerList.createPlayer(PlayerToken.CAR);
        playerList.createPlayer(PlayerToken.CAT);
        playerList.createPlayer(PlayerToken.DOG);
        tokenGUI.startingPosition(playerList);
        LocationProcessor locationProcessor = new LocationProcessor(tokenGUI);
        BoardGUI boardGUI = new BoardGUI(dice, tokenGUI, boardSidePane, gameData.getPropertyFinancialsMap(), gameData.getSinglePropertyBoardData(), gameData.getPropertyAttributesMap(), playerList, locationProcessor);
        DrawCardGUI drawCardGUI = new DrawCardGUI(boardSidePane);
        //System.out.println(drawCardGUI.drawAChanceCard().toString());
        //System.out.println(drawCardGUI.drawACommunityChestCard().toString());


    }
}