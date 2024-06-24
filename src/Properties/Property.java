package Properties;

import Enums.Color;
import Enums.Token;
import Enums.PropertyType;

public class Property {
    private PropertyType propertyType;
    private String name;
    private Color color;
    private boolean improvementAllowed;
    private int house;
    private boolean hotel;
    private boolean isMortgaged;
    private int colorCount;
    private boolean monopoly;
    private Token token;

    private Property(PropertyType propertyType, String name, Color color, boolean improvementAllowed, int house, boolean hotel, boolean isMortgaged, int colorCount, boolean monopoly, Token token) {
        this.propertyType = propertyType;
        this.name = name;
        this.color = color;
        this.improvementAllowed = improvementAllowed;
        this.house = house;
        this.hotel = hotel;
        this.isMortgaged = isMortgaged;
        this.colorCount = colorCount;
        this.monopoly = monopoly;
        this.token = token;
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

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
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

    public Token getOwner() {
        return token;
    }

    public void setOwner(Token token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "Property{" +
                "propertyType=" + propertyType +
                ", name='" + name + '\'' +
                ", color=" + color +
                ", improvementAllowed=" + improvementAllowed +
                ", house=" + house +
                ", hotel=" + hotel +
                ", isMortgaged=" + isMortgaged +
                ", colorCount=" + colorCount +
                ", monopoly=" + monopoly +
                ", owner=" + token +
                '}';
    }

    public static class PropertyBuilder {

        private PropertyType propertyType;
        private String name;
        private Color color;
        private boolean improvementAllowed;
        private int house;
        private boolean hotel;
        private boolean isMortgaged;
        private int colorCount;
        private boolean monopoly;
        private Token token;

        public PropertyBuilder propertyType(PropertyType propertyType) {
            this.propertyType = propertyType;
            return this;
        }

        public PropertyBuilder name(String name) {
            this.name = name;
            return this;
        }

        public PropertyBuilder color(Color color) {
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

        public PropertyBuilder owner(Token token) {
            this.token = token;
            return this;
        }

        public Property build() {
            return new Property(propertyType, name, color, improvementAllowed, house, hotel, isMortgaged, colorCount, monopoly, token);
        }
    }
}