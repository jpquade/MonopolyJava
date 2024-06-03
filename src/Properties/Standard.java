package Properties;

public class Standard extends Property{

    int rent;

    public Standard(String name, int cost, boolean mortgaged, String color, Owner owner, int rent) {
        super(name, cost, mortgaged, color, owner);
        this.rent = rent;
    }

    public Standard(String name, int cost, String color, int rent) {
        super(name, cost, color);
        this.rent = rent;
    }
}
