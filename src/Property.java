public class Property {
    // name of property
    private String name;

    // cost of property
    private int cost;

    // number of houses on property
    private int houseCount;

    // are houses allowed on this property
    private boolean houseAllowed;

    // number of hotels on property
    private int hotelCount;

    // are hotels allowed on this property
    private boolean hotelAllowed;

    // property is mortgaged or not
    private boolean mortgaged;

    // property color
    private String color;

    // which player owns the propery
    private Owner owner;

    // enumerator for name of piece that owns property
    private enum Owner{
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

    public Property(String name, int cost, int houseCount, int hotelCount, boolean mortgaged, String color, Owner owner) {
        this.name = name;
        this.cost = cost;
        this.houseCount = houseCount;
        this.hotelCount = hotelCount;
        this.mortgaged = mortgaged;
        this.color = color;
        this.owner = owner;
    }

    public Property(String name, int cost, String color, Boolean hotelAllowed, Boolean houseAllowed) {
        this.name = name;
        this.cost = cost;
        this.houseCount = 0;
        this.hotelCount = 0;
        this.mortgaged = false;
        this.color = color;
        this.owner = Owner.NONE;
        this.hotelAllowed = hotelAllowed;
        this.houseAllowed = houseAllowed;
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

    public int getHouseCount() {
        return houseCount;
    }

    public void setHouseCount(int houseCount) {
        this.houseCount = houseCount;
    }

    public boolean isHouseAllowed() {
        return houseAllowed;
    }

    public int getHotelCount() {
        return hotelCount;
    }

    public void setHotelCount(int hotelCount) {
        this.hotelCount = hotelCount;
    }

    public boolean isHotelAllowed() {
        return hotelAllowed;
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
