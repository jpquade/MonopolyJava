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
    private int timeInJail;

    public Player(int playerNumber, PlayerToken playerToken, int boardLocation, int cash, boolean inJail, int doubleDiceCount, int getOutOfJailFreeCount, int timeInJail) {
        this.playerNumber = playerNumber;
        this.playerToken = playerToken;
        this.boardLocation = boardLocation;
        this.cash = cash;
        this.inJail = inJail;
        this.doubleDiceCount = doubleDiceCount;
        this.getOutOfJailFreeCount = getOutOfJailFreeCount;
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

    public int getTimeInJail() {return timeInJail;}

    public void setTimeInJail(int timeInJail) {this.timeInJail = timeInJail;}

    @Override
    public String toString() {
        return "Player{" +
                "playerNumber=" + playerNumber +
                ", token=" + playerToken +
                ", boardLocation=" + boardLocation +
                ", cash=" + cash +
                ", inJail=" + inJail +
                ", doubleDiceCount=" + doubleDiceCount +
                ", getOutOfJailFreeCount=" + getOutOfJailFreeCount +
                ", timeInJail=" + timeInJail +
                '}';
    }
}
