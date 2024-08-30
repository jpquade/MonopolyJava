package Misc;

import Enums.PlayerToken;

public class Player {

    private int playerNumber;
    private PlayerToken playerToken;
    private int boardLocation;
    private int cash;
    private boolean inJail;
    private int doubleDiceCount;
    private int getOutOfJailFreeCount;
    private int chanceGetOutOfJailFreeCount;
    private int ccGetOutOfJailFreeCount;
    private int timeInJail;

    public Player(int playerNumber, PlayerToken playerToken, int boardLocation, int cash, boolean inJail,
                  int doubleDiceCount, int getOutOfJailFreeCount, int chanceGetOutOfJailFreeCount,
                  int ccGetOutOfJailFreeCount,int timeInJail) {
        this.playerNumber = playerNumber;
        this.playerToken = playerToken;
        this.boardLocation = boardLocation;
        this.cash = cash;
        this.inJail = inJail;
        this.doubleDiceCount = doubleDiceCount;
        this.getOutOfJailFreeCount = getOutOfJailFreeCount;
        this.chanceGetOutOfJailFreeCount = chanceGetOutOfJailFreeCount;
        this.ccGetOutOfJailFreeCount = ccGetOutOfJailFreeCount;
        this.timeInJail = timeInJail;
    }

    public int getPlayerNumber() { return playerNumber;}

    public void setPlayerNumber(int playerNumber) { this.playerNumber = playerNumber;}

    public PlayerToken getToken() {
        return playerToken;
    }

    public void setToken(PlayerToken playerToken) {
        this.playerToken = playerToken;
    }

    public int getBoardLocation() {
        return boardLocation;
    }

    public void setBoardLocation(int boardLocation) {
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
}
