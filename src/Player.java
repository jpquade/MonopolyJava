import Enums.Token;

public class Player {

    private int playerNumber;
    private Token token;
    private int boardLocation;
    private double cash;

    public Player(int playerNumber, Token token, int boardLocation, double cash) {
        this.playerNumber = playerNumber;
        this.token = token;
        this.boardLocation = boardLocation;
        this.cash = cash;
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
}
