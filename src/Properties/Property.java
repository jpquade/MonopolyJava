package Properties;

// enumerator for name of piece that owns property
enum Owner{
    NONE,
    DOG,
    CAT,
    BATTLESHIP,
    PENGUIN,
    RUBBERDUCKY,
    TOPHAT,
    RACECAR,
    THIMBLE;
}

public class Property {
    // name of property
    private String name;

    // cost of property
    private int cost;

    // number of houses on property
    //private int houseCount;

    // are houses/hotels allowed on this property
    //private boolean improvementAllowed;

    // number of hotels on property
    //private int hotelCount;

    // property is mortgaged or not
    private boolean mortgaged;

    // property color
    private String color;

    // which player owns the propery
    private Owner owner;

    public Property(String name, int cost, boolean mortgaged, String color, Owner owner) {
        this.name = name;
        this.cost = cost;
        this.mortgaged = mortgaged;
        this.color = color;
        this.owner = owner;
    }

    public Property(String name, int cost, String color) {
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

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }
}
