package main;

import main.Data.GameData;
import main.Enums.PlayerToken;
import main.Enums.PropertyNames;
import main.Enums.PropertyTileOrder;
import main.Enums.TransactionType;
import main.Functions.MoneyProcessor;
import main.Functions.PropertyProcessor;
import main.GUI.*;
import main.Functions.Dice;
import main.Functions.PlayerProcessor;
import main.LocationFunctions.LocationProcessor;

import javax.swing.*;
import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException {
//        TurnTracker turnTracker = new TurnTracker();
//        turnTracker.turnProgression();

        GameData gameData = new GameData();
        //LinkedHashMap<Integer, ArrayList<Integer>> dogMovement  = new LinkedHashMap<>();
        //ArrayList<ArrayList> locationTracker = new ArrayList<>();

        //dogMovement.put(0, new ArrayList<>(Arrays.asList(0, 1)));

        Dice dice = new Dice();
        PlayerProcessor playerProcessor = new PlayerProcessor();
        PropertyProcessor propertyProcessor = new PropertyProcessor(playerProcessor);
        JLayeredPane boardSidePane = new JLayeredPane();
        InformationPane informationPane = new InformationPane();
        CommandBoxGUI commandBoxGUI = new CommandBoxGUI();
        TransactionHistoryGUI transactionHistoryGUI = new TransactionHistoryGUI();
        MoneyProcessor moneyProcessor = new MoneyProcessor(playerProcessor, transactionHistoryGUI, commandBoxGUI);
        //SelectionBoxButtonGUI selectionBoxButtonGUI = new SelectionBoxButtonGUI(moneyProcessor, commandBoxGUI);
        SellPropertySubBoxGUI sellPropertySubBoxGUI = new SellPropertySubBoxGUI(moneyProcessor, commandBoxGUI);
        PropertyProcessorGUI propertyProcessorGUI = new PropertyProcessorGUI(propertyProcessor, boardSidePane);

        //JLayeredPane informationSidePane = new JLayeredPane();
        TokenGUI tokenGUI = new TokenGUI(boardSidePane);

        informationPane.add(commandBoxGUI.getCommandBoxGUIPanel());
        //informationPane.add(selectionBoxButtonGUI.getSelectionBoxButtonPanel());
        informationPane.add(sellPropertySubBoxGUI.getSellPropertySubBoxGUIPanel());
        informationPane.add(transactionHistoryGUI.getHistoryPanel());

        playerProcessor.createPlayer(PlayerToken.CAR);
        playerProcessor.createPlayer(PlayerToken.CAT);
        playerProcessor.createPlayer(PlayerToken.DOG);
        playerProcessor.getPlayer(PlayerToken.CAR).setCash(1500);
        playerProcessor.getPlayer(PlayerToken.CAT).setCash(1500);
        playerProcessor.getPlayer(PlayerToken.DOG).setCash(1500);

        propertyProcessor.setPropertyOwnership(PlayerToken.CAR, PropertyNames.PARK_PLACE);
        propertyProcessor.setPropertyOwnership(PlayerToken.CAR, PropertyNames.ATLANTIC_AVENUE);
        propertyProcessor.setPropertyOwnership(PlayerToken.CAT, PropertyNames.BALTIC_AVENUE);
        propertyProcessor.setPropertyOwnership(PlayerToken.CAT, PropertyNames.B_AND_O_RAILROAD);
        propertyProcessor.setPropertyOwnership(PlayerToken.DOG, PropertyNames.BOARDWALK);
        propertyProcessor.setPropertyOwnership(PlayerToken.DOG, PropertyNames.PENNSYLVANIA_RAILROAD);

        tokenGUI.startingPosition(playerProcessor);
        LocationProcessor locationProcessor = new LocationProcessor(tokenGUI);
        GameGUI gameGUI = new GameGUI(propertyProcessor, dice,informationPane , boardSidePane, gameData.getPropertyFinancialsMap(), gameData.getSinglePropertyBoardData(), gameData.getPropertyAttributesMap(), playerProcessor, locationProcessor, transactionHistoryGUI);
        DrawCardGUI drawCardGUI = new DrawCardGUI(boardSidePane);

        //selectionBoxButtonGUI.paymentOptions(TransactionType.ACTIVE_PLAYER_PAY_BANK, 10 , PlayerToken.NONE);
        //selectionBoxButtonGUI.actionOptions(TransactionType.ACTIVE_PLAYER_PAY_BANK, 10 , PlayerToken.NONE, propertyProcessorGUI);
        sellPropertySubBoxGUI.actionOptions();
        //selectionBoxButtonGUI.actionOptions();
        //System.out.println(drawCardGUI.drawAChanceCard().toString());
        //System.out.println(drawCardGUI.drawACommunityChestCard().toString());


    }
}