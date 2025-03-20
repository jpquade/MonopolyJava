package main.Functions;

import main.Enums.PlayerToken;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class TokenBoardLocation {

    private final ArrayList<Integer> xList;
    private final ArrayList<Integer> yList;
    private final PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
    private final HashMap<PlayerToken, Integer> hashMap = new HashMap<>();

    public TokenBoardLocation(ArrayList<Integer> xList, ArrayList<Integer> yList) {
        this.xList = xList;
        this.yList = yList;
        for (int i = 0; i < xList.size(); i++){
            priorityQueue.offer(i);
        }
    }

    // tokens are prioritized in the lower index numbers for insertion
    public ArrayList<Integer> addToken(PlayerToken token){
        hashMap.put(token, priorityQueue.poll());
        int xCoordinate = xList.get(hashMap.get(token));
        int yCoordinate = yList.get(hashMap.get(token));

        return new ArrayList<>(Arrays.asList(xCoordinate, yCoordinate));
    }

    public void removeToken(PlayerToken playerToken){
        priorityQueue.offer(hashMap.get(playerToken));
    }
}
