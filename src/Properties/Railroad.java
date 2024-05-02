package Properties;

import Properties.Owner;
import Properties.Property;

public class Railroad extends Property {

    int railCount;
    int railRent;

    public Railroad(String name, int cost, boolean mortgaged, String color, Owner owner) {
        super(name, cost, mortgaged, color, owner);

        railCount = 0;
        railRent = 25;
    }

    public Railroad(String name, int cost, String color) {
        super(name, cost, color);

        railCount = 0;
        railRent = 25;
    }
}
