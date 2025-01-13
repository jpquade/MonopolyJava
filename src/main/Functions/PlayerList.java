package main.Functions;

import main.Enums.PlayerToken;

import java.util.ArrayList;
import java.util.HashMap;

public class PlayerList {
    private int playerCount;
    private int currentPlayerElement;

    private final ArrayList<PlayerToken> playerOrder;

    private final HashMap<PlayerToken, Player> players = new HashMap<>();

    public PlayerList() {
        playerCount = 0;
        currentPlayerElement = 0;
        playerOrder = new ArrayList<>();
    }

    public void createPlayer(PlayerToken playerToken) {
        players.put(playerToken, new Player());
        players.get(playerToken).setPlayerToken(playerToken);
        playerOrder.add(playerToken);
        playerCount++;
        randomizePlayerOrder();
    }

    public int getPlayerCount() {
        return playerCount;
    }

    public Player getCurrentPlayer(){
        return players.get(playerOrder.get(currentPlayerElement));
    }

    public void nextPlayer(){
        currentPlayerElement++;
        if(currentPlayerElement >= playerCount){
            currentPlayerElement = 0;
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

    public boolean playerExists (PlayerToken playerToken){
        return players.containsKey(playerToken);
    }

    public Player getPlayer(PlayerToken playerToken){
        return players.get(playerToken);
    }
}
