package main.Properties;

import main.Enums.PlayerToken;
import main.Enums.PropertyGroup;
import main.Enums.PropertyNames;
import main.Enums.PropertyType;

public class Property {

    private final PropertyNames propertyName;

    private final PropertyType propertyType;
    private final PropertyGroup color;
    private boolean improvementAllowed;
    private int house;
    private boolean hotel;
    private boolean isMortgaged;
    private boolean monopoly;
    private final PlayerToken playerTokenOwner;

    private int price;
    private int rent;
    private int pricePerImprovement;
    private int rentOneHouse;
    private int rentTwoHouse;
    private int rentThreeHouse;
    private int rentFourHouse;
    private int rentHotel;
    private int mortgageAmount;

    public Property(PropertyNames propertyName, PropertyType propertyType, PropertyGroup propertyGroup,
                    boolean improvementAllowed, int house, boolean hotel, boolean isMortgaged, boolean monopoly,
                    PlayerToken playerTokenOwner, int price, int rent, int pricePerImprovement, int rentOneHouse,
                    int rentTwoHouse, int rentThreeHouse, int rentFourHouse, int rentHotel, int mortgageAmount) {
        this.propertyName = propertyName;
        this.propertyType = propertyType;
        this.color = propertyGroup;
        this.improvementAllowed = improvementAllowed;
        this.house = house;
        this.hotel = hotel;
        this.isMortgaged = isMortgaged;
        this.monopoly = monopoly;
        this.playerTokenOwner = playerTokenOwner;
        this.price = price;
        this.rent = rent;
        this.pricePerImprovement = pricePerImprovement;
        this.rentOneHouse = rentOneHouse;
        this.rentTwoHouse = rentTwoHouse;
        this.rentThreeHouse = rentThreeHouse;
        this.rentFourHouse = rentFourHouse;
        this.rentHotel = rentHotel;
        this.mortgageAmount = mortgageAmount;
    }

    public PropertyNames getPropertyName() {
        return propertyName;
    }

    public PropertyType getPropertyType() {
        return propertyType;
    }

    public PropertyGroup getColor() {
        return color;
    }

    public boolean isImprovementAllowed() {
        return improvementAllowed;
    }

    public void setImprovementAllowed(boolean improvementAllowed) {
        this.improvementAllowed = improvementAllowed;
    }

    public int getHouse() {
        return house;
    }

    public void setHouse(int house) {
        this.house = house;
    }

    public boolean isHotel() {
        return hotel;
    }

    public void setHotel(boolean hotel) {
        this.hotel = hotel;
    }

    public boolean isMortgaged() {
        return isMortgaged;
    }

    public void setMortgaged(boolean mortgaged) {
        isMortgaged = mortgaged;
    }

    public boolean isMonopoly() {
        return monopoly;
    }

    public void setMonopoly(boolean monopoly) {
        this.monopoly = monopoly;
    }

    public PlayerToken getPlayerTokenOwner() {
        return playerTokenOwner;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getRent() {
        return rent;
    }

    public void setRent(int rent) {
        this.rent = rent;
    }

    public int getPricePerImprovement() {
        return pricePerImprovement;
    }

    public void setPricePerImprovement(int pricePerImprovement) {
        this.pricePerImprovement = pricePerImprovement;
    }

    public int getRentOneHouse() {
        return rentOneHouse;
    }

    public void setRentOneHouse(int rentOneHouse) {
        this.rentOneHouse = rentOneHouse;
    }

    public int getRentTwoHouse() {
        return rentTwoHouse;
    }

    public void setRentTwoHouse(int rentTwoHouse) {
        this.rentTwoHouse = rentTwoHouse;
    }

    public int getRentThreeHouse() {
        return rentThreeHouse;
    }

    public void setRentThreeHouse(int rentThreeHouse) {
        this.rentThreeHouse = rentThreeHouse;
    }

    public int getRentFourHouse() {
        return rentFourHouse;
    }

    public void setRentFourHouse(int rentFourHouse) {
        this.rentFourHouse = rentFourHouse;
    }

    public int getRentHotel() {
        return rentHotel;
    }

    public void setRentHotel(int rentHotel) {
        this.rentHotel = rentHotel;
    }

    public int getMortgageAmount() {
        return mortgageAmount;
    }

    public void setMortgageAmount(int mortgageAmount) {
        this.mortgageAmount = mortgageAmount;
    }

    public static class PropertyBuilder{
        private PropertyNames propertyName;
        private PropertyType propertyType;
        private PropertyGroup color;
        private boolean improvementAllowed;
        private int house;
        private boolean hotel;
        private boolean isMortgaged;
        private boolean monopoly;
        private PlayerToken playerTokenOwner;
        private int price;
        private int rent;
        private int pricePerImprovement;
        private int rentOneHouse;
        private int rentTwoHouse;
        private int rentThreeHouse;
        private int rentFourHouse;
        private int rentHotel;
        private int mortgageAmount;

        public PropertyBuilder propertyName(PropertyNames propertyName) {
            this.propertyName = propertyName;
            return this;
        }

        public PropertyBuilder propertyType(PropertyType propertyType) {
            this.propertyType = propertyType;
            return this;
        }

        public PropertyBuilder color(PropertyGroup color) {
            this.color = color;
            return this;
        }

        public PropertyBuilder improvementAllowed(boolean improvementAllowed) {
            this.improvementAllowed = improvementAllowed;
            return this;
        }

        public PropertyBuilder house(int house) {
            this.house = house;
            return this;
        }

        public PropertyBuilder hotel(boolean hotel) {
            this.hotel = hotel;
            return this;
        }

        public PropertyBuilder mortgaged(boolean mortgaged) {
            isMortgaged = mortgaged;
            return this;
        }

        public PropertyBuilder monopoly(boolean monopoly) {
            this.monopoly = monopoly;
            return this;
        }

        public PropertyBuilder playerTokenOwner(PlayerToken playerTokenOwner) {
            this.playerTokenOwner = playerTokenOwner;
            return this;
        }

        public PropertyBuilder price(int price) {
            this.price = price;
            return this;
        }

        public PropertyBuilder rent(int rent) {
            this.rent = rent;
            return this;
        }

        public PropertyBuilder pricePerImprovement(int pricePerImprovement) {
            this.pricePerImprovement = pricePerImprovement;
            return this;
        }

        public PropertyBuilder rentOneHouse(int rentOneHouse) {
            this.rentOneHouse = rentOneHouse;
            return this;
        }

        public PropertyBuilder rentTwoHouse(int rentTwoHouse) {
            this.rentTwoHouse = rentTwoHouse;
            return this;
        }

        public PropertyBuilder rentThreeHouse(int rentThreeHouse) {
            this.rentThreeHouse = rentThreeHouse;
            return this;
        }

        public PropertyBuilder rentFourHouse(int rentFourHouse) {
            this.rentFourHouse = rentFourHouse;
            return this;
        }

        public PropertyBuilder rentHotel(int rentHotel) {
            this.rentHotel = rentHotel;
            return this;
        }

        public PropertyBuilder mortgageAmount(int mortgageAmount) {
            this.mortgageAmount = mortgageAmount;
            return this;
        }

        public Property build(){
            return new Property(propertyName, propertyType, color, improvementAllowed, house, hotel, isMortgaged, monopoly, playerTokenOwner, price, rent, pricePerImprovement, rentOneHouse, rentTwoHouse, rentThreeHouse, rentFourHouse, rentHotel, mortgageAmount);
        }
    }

}
