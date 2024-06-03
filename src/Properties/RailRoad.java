package Properties;

import Misc.Owner;

public class RailRoad extends Property {

    RailRoad(String name, int cost, boolean mortgaged, String color, int count, double rent, Owner owner) {
        super(name, cost, mortgaged, color, count, rent, owner);

        count = 0;
        rent = 25;
    }

    RailRoad(String name, int cost, String color) {
        super(name, cost, color);

        count = 0;
        rent = 25;
    }

}
