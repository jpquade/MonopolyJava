package main.Misc;

import main.Enums.PlayerToken;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class BoardLocation {


    private final ArrayList<Integer> xList;
    private final ArrayList<Integer> yList;
    private final PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
    private final HashMap<PlayerToken, Integer> hashMap = new HashMap<>();

    public BoardLocation(ArrayList<Integer> xList, ArrayList<Integer> yList) {
        this.xList = xList;
        this.yList = yList;
        initializePriorityQueue();
    }

    private void initializePriorityQueue(){
        for(int i = 0 ; i < 8; i++){
            priorityQueue.offer(i);
        }
    }

    // adds token prioritizing the lower index numbers for insertion
    public ArrayList<Integer> addToken(PlayerToken token){
        hashMap.put(token, priorityQueue.poll());
        int xCoor = xList.get(hashMap.get(token));
        int yCoor = yList.get(hashMap.get(token));

        return new ArrayList<>(Arrays.asList(xCoor, yCoor));
    }

    public void removeToken(PlayerToken token){
        priorityQueue.offer(hashMap.get(token));
    }

    public ArrayList<Integer> getXList() {
        return xList;
    }

    public ArrayList<Integer> getYList() {
        return yList;
    }
}
