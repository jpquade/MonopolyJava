package main.Functions;

import main.Enums.PlayerToken;
import main.GUI.ActivePlayerBoxGUI;

import java.util.ArrayList;
import java.util.HashMap;

public class PlayerProcessor {
    private int playerCount;
    private int activePlayerElementNumber;

    private final ArrayList<PlayerToken> playerOrder;
    private final HashMap<PlayerToken, Player> mapOfCurrentPlayers = new HashMap<>();

    public PlayerProcessor() {
        playerCount = 0;
        activePlayerElementNumber = 0;
        playerOrder = new ArrayList<>();
    }

    public void createPlayer(PlayerToken playerToken, ActivePlayerBoxGUI activePlayerBoxGUI) {
        mapOfCurrentPlayers.put(playerToken, new Player());
        mapOfCurrentPlayers.get(playerToken).setToken(playerToken);
        playerOrder.add(playerToken);
        playerCount++;
        randomizePlayerOrder();
        System.out.println("Active player: " + getActivePlayer().getToken());

        activePlayerBoxGUI.setActivePlayer(getActivePlayer().getToken().toString());
    }

    public int getPlayerCount() {
        return playerCount;
    }

    public HashMap<PlayerToken, Player> getMapOfCurrentPlayers() {
        return mapOfCurrentPlayers;
    }

    public Player getActivePlayer(){
        return mapOfCurrentPlayers.get(playerOrder.get(activePlayerElementNumber));
    }

    public void nextPlayer(ActivePlayerBoxGUI activePlayerBoxGUI){
        activePlayerElementNumber++;
        if(activePlayerElementNumber >= playerCount){
            activePlayerElementNumber = 0;
        }
        System.out.println("Active player: " + getActivePlayer().getToken());

        activePlayerBoxGUI.setActivePlayer(getActivePlayer().getToken().toString());
    }

    public void randomizePlayerOrder(){
        // Fisher-Yates shuffle
        for (int i = playerOrder.size() - 1; i > 0; i--) {
            int j = (int) Math.floor(Math.random() * (i + 1));
            PlayerToken temp = playerOrder.get(i);
            playerOrder.set(i, playerOrder.get(j));
            playerOrder.set(j, temp);
        }
    }

    public boolean ifPlayerExists(PlayerToken playerToken){
        return mapOfCurrentPlayers.containsKey(playerToken);
    }

    public Player getPlayer(PlayerToken playerToken){
        return mapOfCurrentPlayers.get(playerToken);
    }

    public void addMoney(PlayerToken playerToken, int amount){
        mapOfCurrentPlayers.get(playerToken).setCash(mapOfCurrentPlayers.get(playerToken).getCash() + amount);
    }

    public void subtractMoney(PlayerToken playerToken, int amount){
        mapOfCurrentPlayers.get(playerToken).setCash(mapOfCurrentPlayers.get(playerToken).getCash() - amount);

    }


}
