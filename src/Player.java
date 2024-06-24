import Enums.Token;

public class Player {

    // Player token choice
    Token token;
    // Location on board by number position
    int location;
    // Cash player has
    double cash;

    public Player(Token token, int location, double cash) {
        this.token = token;
        this.location = location;
        this.cash = cash;
    }

    public Token getToken() {
        return token;
    }

    public void setToken(Token token) {
        this.token = token;
    }

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    public double getCash() {
        return cash;
    }

    public void setCash(double cash) {
        this.cash = cash;
    }
}
