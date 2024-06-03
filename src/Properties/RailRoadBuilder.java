package Properties;

import Misc.Owner;

public class RailRoadBuilder {

    private String name;
    private int cost;
    private boolean mortgaged;
    private String color;
    private int count;
    private double rent;
    private Owner owner;

    public RailRoadBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public RailRoadBuilder setCost(int cost) {
        this.cost = cost;
        return this;
    }

    public RailRoadBuilder mortgaged(boolean mortgaged) {
        this.mortgaged = mortgaged;
        return this;
    }

    public RailRoadBuilder color(String color) {
        this.color = color;
        return this;
    }

    public RailRoadBuilder count(int count) {
        this.count = count;
        return this;
    }

    public RailRoadBuilder rent(double rent) {
        this.rent = rent;
        return this;
    }

    public RailRoadBuilder owner(Owner owner) {
        this.owner = owner;
        return this;
    }

    public RailRoad build() {

        return new RailRoad(name, cost, mortgaged, color, count, rent, owner);
    }
}
