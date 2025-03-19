package main.Functions;

import main.Enums.BoardSpaceElement;
import main.Enums.PlayerToken;

public class Player {

    private int playerNumber;
    private PlayerToken playerToken;
    private BoardSpaceElement boardLocation;
    private int cash;
    private boolean inJail;
    private int doubleDiceCount;
    private int getOutOfJailFreeCount;
    private int chanceGetOutOfJailFreeCount;
    private int ccGetOutOfJailFreeCount;
    private int timeInJail;
    private int totalHouses;
    private int totalHotels;
    private boolean bankrupt;

    public Player(int playerNumber, PlayerToken playerToken, int cash, boolean inJail,
                  int doubleDiceCount, int getOutOfJailFreeCount, int chanceGetOutOfJailFreeCount,
                  int ccGetOutOfJailFreeCount,int timeInJail, int totalHouses, int totalHotels, boolean bankrupt) {
        this.playerNumber = playerNumber;
        this.playerToken = playerToken;
        boardLocation = BoardSpaceElement.GO;
        this.cash = cash;
        this.inJail = inJail;
        this.doubleDiceCount = doubleDiceCount;
        this.getOutOfJailFreeCount = getOutOfJailFreeCount;
        this.chanceGetOutOfJailFreeCount = chanceGetOutOfJailFreeCount;
        this.ccGetOutOfJailFreeCount = ccGetOutOfJailFreeCount;
        this.timeInJail = timeInJail;
        this.totalHouses = totalHouses;
        this.totalHotels = totalHotels;
        this.bankrupt = bankrupt;
    }
//    public Player(PlayerToken playerToken){
//        this.playerToken = playerToken;
//    }

    public Player() {
        playerNumber = 0;
        playerToken = null;
        boardLocation = BoardSpaceElement.GO;
        cash = 0;
        inJail = false;
        doubleDiceCount = 0;
        getOutOfJailFreeCount = 0;
        chanceGetOutOfJailFreeCount = 0;
        ccGetOutOfJailFreeCount = 0;
        timeInJail = 0;
        totalHouses = 0;
        totalHotels = 0;
        bankrupt = false;
    }

    public int getPlayerNumber() { return playerNumber;}

    public void setPlayerNumber(int playerNumber) { this.playerNumber = playerNumber;}

    public PlayerToken getToken() {
        return playerToken;
    }

    public void setToken(PlayerToken playerToken) {
        this.playerToken = playerToken;
    }

    public BoardSpaceElement getBoardLocation() {
        return boardLocation;
    }

    public void setBoardLocation(BoardSpaceElement boardLocation) {
        this.boardLocation = boardLocation;
    }

    public int getCash() {
        return cash;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }

    public boolean isInJail() {return inJail;}

    public void setInJail(boolean inJail) {this.inJail = inJail;}

    public int getDoubleDiceCount() {return doubleDiceCount;}

    public void setDoubleDiceCount(int doubleDiceCount) {this.doubleDiceCount = doubleDiceCount;}

    public int getGetOutOfJailFreeCount() {return getOutOfJailFreeCount;}

    public void setGetOutOfJailFreeCount(int getOutOfJailFreeCount) {this.getOutOfJailFreeCount = getOutOfJailFreeCount;}

    public int getChanceGetOutOfJailFreeCount() { return chanceGetOutOfJailFreeCount; }

    public void setChanceGetOutOfJailFreeCount(int chanceGetOutOfJailFreeCount) { this.chanceGetOutOfJailFreeCount = chanceGetOutOfJailFreeCount; }

    public int getCcGetOutOfJailFreeCount(){ return ccGetOutOfJailFreeCount; }

    public void setCcGetOutOfJailFreeCount(int ccGetOutOfJailFreeCount) { this.ccGetOutOfJailFreeCount = ccGetOutOfJailFreeCount; }

    public int getTimeInJail() {return timeInJail;}

    public void setTimeInJail(int timeInJail) {this.timeInJail = timeInJail;}

    public int getTotalHouses() {
        return totalHouses;
    }

    public void setTotalHouses(int totalHouses) {
        this.totalHouses = totalHouses;
    }

    public int getTotalHotels() {
        return totalHotels;
    }

    public void setTotalHotels(int totalHotels) {
        this.totalHotels = totalHotels;
    }

    public boolean isBankrupt() {
        return bankrupt;
    }

    public void setBankrupt(boolean bankrupt) {
        this.bankrupt = bankrupt;
    }
}
