package Properties;

import Enums.PropertyColor;

import java.util.ArrayList;

public class ColorGroup {

    private PropertyColor color;
    private boolean isMonopoly;
    private int totalHouseCount;
    private int propertyCount;
    private ArrayList<String> propertyList;

    private ColorGroup(PropertyColor color, boolean isMonopoly, int totalHouseCount, int propertyCount, ArrayList<String> propertyList) {
        this.color = color;
        this.isMonopoly = isMonopoly;
        this.totalHouseCount = totalHouseCount;
        this.propertyCount = propertyCount;
        this.propertyList = propertyList;
    }

    public PropertyColor getColor() {
        return color;
    }

    public void setColor(PropertyColor color) {
        this.color = color;
    }

    public boolean isMonopoly() {
        return isMonopoly;
    }

    public void setMonopoly(boolean monopoly) {
        this.isMonopoly = monopoly;
    }

    public int getTotalHouseCount() {
        return totalHouseCount;
    }

    public void setTotalHouseCount(int totalHouseCount) {
        this.totalHouseCount = totalHouseCount;
    }

    public int getPropertyCount() {
        return propertyCount;
    }

    public void setPropertyCount(int propertyCount) {
        this.propertyCount = propertyCount;
    }

    public ArrayList<String> getPropertyList() {
        return propertyList;
    }

    public void setPropertyList(ArrayList<String> propertyList) {
        this.propertyList = propertyList;
    }

    public static class ColorGroupBuilder {

        private PropertyColor color;
        private boolean isMonopoly;
        private int totalHouseCount;
        private int propertyCount;
        private ArrayList<String> propertyList;

        public ColorGroupBuilder color(PropertyColor color) {
            this.color = color;
            return this;
        }

        public ColorGroupBuilder isMonopoly(boolean isMonopoly) {
            this.isMonopoly = isMonopoly;
            return this;
        }

        public ColorGroupBuilder totalHouseCount(int totalHouseCount) {
            this.totalHouseCount = totalHouseCount;
            return this;
        }

        public ColorGroupBuilder propertyCount(int propertyCount) {
            this.propertyCount = propertyCount;
            return this;
        }

        public ColorGroupBuilder propertyList(ArrayList<String> propertyList) {
            this.propertyList = propertyList;
            return this;
        }

        public ColorGroup build() {
            return new ColorGroup(color, isMonopoly, totalHouseCount, propertyCount, propertyList);
        }
    }
}
