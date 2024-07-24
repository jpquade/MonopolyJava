package Properties;

import Enums.PlayerToken;
import Enums.PropertyColor;
import Enums.PropertyType;

public class PropertyAttributes {
    private PropertyType propertyType;
    private String name;
    private PropertyColor color;
    private boolean improvementAllowed;
    private int house;
    private boolean hotel;
    private boolean isMortgaged;
    private int colorCount;
    private boolean monopoly;
    private PlayerToken playerTokenOwner;

    private PropertyAttributes(PropertyType propertyType, String name, PropertyColor color, boolean improvementAllowed, int house, boolean hotel, boolean isMortgaged, int colorCount, boolean monopoly, PlayerToken playerTokenOwner) {
        this.propertyType = propertyType;
        this.name = name;
        this.color = color;
        this.improvementAllowed = improvementAllowed;
        this.house = house;
        this.hotel = hotel;
        this.isMortgaged = isMortgaged;
        this.colorCount = colorCount;
        this.monopoly = monopoly;
        this.playerTokenOwner = playerTokenOwner;
    }

    public PropertyType getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(PropertyType propertyType) {
        this.propertyType = propertyType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PropertyColor getColor() {return color;}

    public void setColor(PropertyColor color) {
        this.color = color;
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

    public void setHouse(int house) {this.house = house;}

    public boolean hasHotel() {
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

    public int getColorCount() {
        return colorCount;
    }

    public void setColorCount(int colorCount) {
        this.colorCount = colorCount;
    }

    public boolean isMonopoly() {
        return monopoly;
    }

    public void setMonopoly(boolean monopoly) {
        this.monopoly = monopoly;
    }

    public PlayerToken getOwner() {
        return playerTokenOwner;
    }

    public void setOwner(PlayerToken playerToken) {
        this.playerTokenOwner = playerToken;
    }

    public static class PropertyBuilder {

        private PropertyType propertyType;
        private String name;
        private PropertyColor color;
        private boolean improvementAllowed;
        private int house;
        private boolean hotel;
        private boolean isMortgaged;
        private int colorCount;
        private boolean monopoly;
        private PlayerToken playerTokenOwner;

        public PropertyBuilder propertyType(PropertyType propertyType) {
            this.propertyType = propertyType;
            return this;
        }

        public PropertyBuilder name(String name) {
            this.name = name;
            return this;
        }

        public PropertyBuilder color(PropertyColor color) {
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

        public PropertyBuilder colorCount(int colorCount) {
            this.colorCount = colorCount;
            return this;
        }

        public PropertyBuilder monopoly(boolean monopoly) {
            this.monopoly = monopoly;
            return this;
        }

        public PropertyBuilder owner(PlayerToken playerTokenOwner) {
            this.playerTokenOwner = playerTokenOwner;
            return this;
        }

        public PropertyAttributes build() {
            return new PropertyAttributes(propertyType, name, color, improvementAllowed, house, hotel, isMortgaged, colorCount, monopoly, playerTokenOwner);
        }
    }
}