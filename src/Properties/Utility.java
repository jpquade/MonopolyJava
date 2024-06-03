package Properties;

public class Utility extends Property{

    int utilityCount;

    int utilityRent;

    public Utility(String name, int cost, boolean mortgaged, String color, Owner owner) {
        super(name, cost, mortgaged, color, owner);

        utilityCount = 0;
        utilityRent = 25;
    }

    public Utility(String name, int cost, String color) {
        super(name, cost, color);

        utilityCount = 0;
        utilityRent = 25;
    }

    public int rentOneUtility(int diceRoll){
        // Return 4 * dice roll
        return  4 * diceRoll;
    }

    public int rentTwoUtility(int diceRoll){
        // Return 10 * dice roll
        return  10 * diceRoll;
    }
}
