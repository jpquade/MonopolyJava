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
}
