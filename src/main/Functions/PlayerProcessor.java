package main.Functions;

import main.Enums.PlayerToken;

import java.util.ArrayList;
import java.util.HashMap;

public class PlayerProcessor {
    private int playerCount;
    private int activePlayerElementNumber;

    private final ArrayList<PlayerToken> playerOrder;
    private final HashMap<PlayerToken, Player> mapOfPlayers = new HashMap<>();

    public PlayerProcessor() {
        playerCount = 0;
        activePlayerElementNumber = 0;
        playerOrder = new ArrayList<>();
    }

    public void createPlayer(PlayerToken playerToken) {
        mapOfPlayers.put(playerToken, new Player());
        mapOfPlayers.get(playerToken).setPlayerToken(playerToken);
        playerOrder.add(playerToken);
        playerCount++;
        randomizePlayerOrder();
    }

    public int getPlayerCount() {
        return playerCount;
    }

    public HashMap<PlayerToken, Player> getMapOfPlayers() {
        return mapOfPlayers;
    }

    public Player getActivePlayer(){
        return mapOfPlayers.get(playerOrder.get(activePlayerElementNumber));
    }

    public void nextPlayer(){
        activePlayerElementNumber++;
        if(activePlayerElementNumber >= playerCount){
            activePlayerElementNumber = 0;
        }
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
        return mapOfPlayers.containsKey(playerToken);
    }

    public Player getPlayer(PlayerToken playerToken){
        return mapOfPlayers.get(playerToken);
    }

    public Player addMoney(PlayerToken playerToken, int amount){
        mapOfPlayers.get(playerToken).setCash(mapOfPlayers.get(playerToken).getCash() + amount);
        return mapOfPlayers.get(playerToken);
    }

    public Player subtractMoney(PlayerToken playerToken, int amount){
        mapOfPlayers.get(playerToken).setCash(mapOfPlayers.get(playerToken).getCash() - amount);
        return mapOfPlayers.get(playerToken);
    }


}
