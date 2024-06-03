package Properties;

import Misc.Owner;

public abstract class Property {
    // name of property
    protected String name;

    // cost of property
    protected int cost;

    // number of houses on property
    //private int houseCount;

    // are houses/hotels allowed on this property
    //private boolean improvementAllowed;

    // number of hotels on property
    //private int hotelCount;

    // property is mortgaged or not
    protected boolean mortgaged;

    // property color
    protected String color;

    protected int count;

    protected double rent;

    // which player owns the propery
    protected Owner owner;

    protected Property(String name, int cost, boolean mortgaged, String color, int count, double rent, Owner owner) {
        this.name = name;
        this.cost = cost;
        this.mortgaged = mortgaged;
        this.color = color;
        this.owner = owner;
    }

    protected Property(String name, int cost, String color) {
        this.name = name;
        this.cost = cost;
        this.mortgaged = false;
        this.color = color;
        this.owner = Owner.NONE;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public boolean isMortgaged() {
        return mortgaged;
    }

    public void setMortgaged(boolean mortgaged) {
        this.mortgaged = mortgaged;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getRent() {
        return rent;
    }

    public void setRent(int rent) {
        this.rent = rent;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }
}
