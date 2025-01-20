package main;

import main.Data.GameData;
import main.Enums.PlayerToken;
import main.Functions.MoneyProcessor;
import main.GUI.*;
import main.Functions.Dice;
import main.Functions.PlayerList;
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
        //LinkedHashMap<Integer, ArrayList<Integer>> dogMovement  = new LinkedHashMap<>();
        //ArrayList<ArrayList> locationTracker = new ArrayList<>();

        //dogMovement.put(0, new ArrayList<>(Arrays.asList(0, 1)));

        Dice dice = new Dice();
        PlayerList playerList = new PlayerList();
        JLayeredPane boardSidePane = new JLayeredPane();
        InformationPane informationPane = new InformationPane();
        MoneyProcessor moneyProcessor = new MoneyProcessor(playerList);
        //JLayeredPane informationSidePane = new JLayeredPane();
        TokenGUI tokenGUI = new TokenGUI(boardSidePane);
        SelectionBoxButtonGUI selectionBoxButtonGUI = new SelectionBoxButtonGUI();
        TransactionHistoryGUI transactionHistoryGUI = new TransactionHistoryGUI();
        informationPane.add(selectionBoxButtonGUI.getSelectionBoxButtonPanel());
        informationPane.add(transactionHistoryGUI.getHistoryPanel());
        playerList.createPlayer(PlayerToken.CAR);
        playerList.createPlayer(PlayerToken.CAT);
        playerList.createPlayer(PlayerToken.DOG);
        tokenGUI.startingPosition(playerList);
        LocationProcessor locationProcessor = new LocationProcessor(tokenGUI);
        GameGUI gameGUI = new GameGUI(dice,informationPane , boardSidePane, gameData.getPropertyFinancialsMap(), gameData.getSinglePropertyBoardData(), gameData.getPropertyAttributesMap(), playerList, locationProcessor, transactionHistoryGUI);
        DrawCardGUI drawCardGUI = new DrawCardGUI(boardSidePane);

        selectionBoxButtonGUI.getPaymentOptions(true, true, true, true, 10,moneyProcessor);
        //System.out.println(drawCardGUI.drawAChanceCard().toString());
        //System.out.println(drawCardGUI.drawACommunityChestCard().toString());


    }
}