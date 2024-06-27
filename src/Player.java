import Enums.Token;

public class Player {

    private int playerNumber;
    private Token token;
    private int boardLocation;
    private double cash;
    private boolean inJail;
    private int doubleDiceCount;
    private int getOutOfJailFreeCount;
    private int timeInJail;

    public Player(int playerNumber, Token token, int boardLocation, double cash, boolean inJail, int doubleDiceCount, int getOutOfJailFreeCount, int timeInJail) {
        this.playerNumber = playerNumber;
        this.token = token;
        this.boardLocation = boardLocation;
        this.cash = cash;
        this.inJail = inJail;
        this.doubleDiceCount = doubleDiceCount;
        this.getOutOfJailFreeCount = getOutOfJailFreeCount;
        this.timeInJail = timeInJail;
    }

    public int getPlayerNumber() { return playerNumber;}

    public void setPlayerNumber(int playerNumber) { this.playerNumber = playerNumber;}

    public Token getToken() {
        return token;
    }

    public void setToken(Token token) {
        this.token = token;
    }

    public int getBoardLocation() {
        return boardLocation;
    }

    public void setBoardLocation(int boardLocation) {
        this.boardLocation = boardLocation;
    }

    public double getCash() {
        return cash;
    }

    public void setCash(double cash) {
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
}
