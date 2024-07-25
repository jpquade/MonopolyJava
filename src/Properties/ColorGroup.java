package Properties;

import Enums.PropertyColor;
import Misc.Player;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class ColorGroup {

    private PropertyColor color;
    private boolean isMonopoly;
    private int totalHouseCount;
    private int totalHotelCount;
    private int propertyCount;
    private ArrayList<String> propertyList;
    private LinkedHashMap<Integer, String> houseStock;

    private ColorGroup(PropertyColor color, boolean isMonopoly, int totalHouseCount, int totalHotelCount, int propertyCount, ArrayList<String> propertyList, LinkedHashMap<Integer, String> houseStock) {
        this.color = color;
        this.isMonopoly = isMonopoly;
        this.totalHouseCount = totalHouseCount;
        this.propertyCount = propertyCount;
        this.propertyList = propertyList;
        this.houseStock = houseStock;
        this.totalHotelCount = totalHotelCount;
    }

    public boolean checkForMonopoly(Player player, LinkedHashMap<String, PropertyAttributes> propertyAttributesMap){
        for(String propertyName : propertyList){
            if(propertyAttributesMap.get(propertyName).getOwner() != player.getToken()) return false;
        }

        return true;
    }

    public boolean colorHotelsExist(LinkedHashMap<String, PropertyAttributes> propertyAttributesMap){

        for(String propertyName : propertyList){
            if(propertyAttributesMap.get(propertyName).hasHotel()) return false;
        }

        return true;
    }

    public boolean canAddHouse(PropertyAttributes attributes, LinkedHashMap<String, PropertyAttributes> propertyAttributesMap){

        // checks for color group monopoly and if improvements can be built
        if(!isMonopoly || !attributes.isImprovementAllowed()) return false;

        // if any hotels exist on color group then houses cannot be purchased
        if(colorHotelsExist(propertyAttributesMap)) return false;


        if(propertyList.size() == 2){
            // property group of size 2
            if(totalHouseCount == 0 || totalHouseCount == 1){
                return attributes.getHouse() < 1;
            }
            else if(totalHouseCount == 2 || totalHouseCount == 3){
                return attributes.getHouse() < 2;
            }
            else if(totalHouseCount == 4 || totalHouseCount == 5){
                return attributes.getHouse() < 3;
            }
            else if(totalHouseCount == 6 || totalHouseCount == 7){
                return attributes.getHouse() < 4;
            }
        }
        else{
            // property group of size 3
            if(totalHouseCount >= 0 && totalHouseCount <= 2){
                return attributes.getHouse() < 1;
            }
            else if(totalHouseCount >= 3 && totalHouseCount <= 5){
                return attributes.getHouse() < 2;
            }
            else if(totalHouseCount >= 6 && totalHouseCount <= 8){
                return attributes.getHouse() < 3;
            }
            else if(totalHouseCount >= 9 && totalHouseCount <= 11){
                return attributes.getHouse() < 4;
            }
        }

        return false;
    }

    public boolean canAddHotel(PropertyAttributes attributes){

        // add conditions for adding hotels

        // 0 hotels
        // 1 hotel
        // 2 hotel
        // 3 hotel etc

        // conditions for group of 2 or group of 3

        if(totalHotelCount >= 0 && totalHotelCount <= 2){
            //if(totalHotelCount)

            return !attributes.hasHotel();
        }
        return false;
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

    public LinkedHashMap<Integer, String> getHouseStock() {
        return houseStock;
    }

    public void setHouseStock(LinkedHashMap<Integer, String> houseStock) {
        this.houseStock = houseStock;
    }

    public int getTotalHotelCount() {
        return totalHotelCount;
    }

    public void setTotalHotelCount(int totalHotelCount) {
        this.totalHotelCount = totalHotelCount;
    }

    public static class ColorGroupBuilder {

        private PropertyColor color;
        private boolean isMonopoly;
        private int totalHouseCount;
        private int totalHotelCount;
        private int propertyCount;
        private ArrayList<String> propertyList;
        private LinkedHashMap<Integer, String> houseStock;

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

        public ColorGroupBuilder totalHotelCount(int totalHotelCount) {
            this.totalHotelCount = totalHotelCount;
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

        public ColorGroupBuilder houseStock(LinkedHashMap<Integer, String> houseStock) {
            this.houseStock = houseStock;
            return this;
        }

        public ColorGroup build() {
            return new ColorGroup(color, isMonopoly, totalHouseCount, totalHotelCount, propertyCount, propertyList, houseStock);
        }
    }
}
