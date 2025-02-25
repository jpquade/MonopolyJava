package main.Properties;

import main.Enums.PlayerToken;
import main.Enums.PropertyGroup;
import main.Enums.PropertyNames;
import main.Functions.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class PropertyGroupProcessor {

    private PropertyGroup color;
    private boolean isMonopoly;
    private ArrayList<String> propertyList;
    private LinkedHashMap<Integer, String> houseStockOrder;
    private LinkedHashMap<Integer, String> hotelStockOrder;

    private HashMap<PropertyNames, PlayerToken> propertyOwnerMap = new HashMap<>();
    private HashMap<PropertyGroup, HashMap<PropertyNames,PlayerToken>> propertyGroupMap = new HashMap<>();

    private boolean brownMonopoly;
    private boolean lightBlueMonopoly;
    private boolean pinkMonopoly;
    private boolean orangeMonopoly;
    private boolean redMonopoly;
    private boolean yellowMonopoly;
    private boolean greenMonopoly;
    private boolean darkBlueMonopoly;

    private PropertyGroupProcessor(PropertyGroup color, boolean isMonopoly, ArrayList<String> propertyList) {
        propertyOwnerMap = new HashMap<>();
        propertyGroupMap = new HashMap<>();


        for(PropertyNames propertyName : PropertyNames.values()){
            propertyOwnerMap.put(propertyName, PlayerToken.NONE);
        }





        brownMonopoly = false;
        lightBlueMonopoly = false;
        pinkMonopoly = false;
        orangeMonopoly = false;
        redMonopoly = false;
        yellowMonopoly = false;
        greenMonopoly = false;
        darkBlueMonopoly = false;


        this.color = color;
        this.isMonopoly = isMonopoly;
        this.propertyList = propertyList;
        houseStockOrder = new LinkedHashMap<>();
        hotelStockOrder = new LinkedHashMap<>();
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

    public boolean colorGroupHasMortgaged(LinkedHashMap<String, PropertyAttributes> propertyAttributesMap){

        for(String propertyName : propertyList){
            if(propertyAttributesMap.get(propertyName).isMortgaged()) return false;
        }

        return true;
    }

    public int getColorGroupHouseCount(LinkedHashMap<String, PropertyAttributes> propertyAttributesMap){
        int houseCount = 0;

        for(String propertyName : propertyList){
            houseCount += propertyAttributesMap.get(propertyName).getHouse();
        }

        return houseCount;
    }

    public int getColorGroupHotelCount(LinkedHashMap<String, PropertyAttributes> propertyAttributesMap) {
        int hotelCount = 0;

        for(String propertyName : propertyList){
            if(propertyAttributesMap.get(propertyName).hasHotel()) hotelCount++;
        }

        return hotelCount;
    }

//    // this method might change. When buying a house I might give them a choice of color group then available properties they can buy houses for
//    public void buildHouse(Player player, PropertyAttributes attributes, PropertyFinancials financials,LinkedHashMap<String, PropertyAttributes> propertyAttributesMap){
//
//        // if player has enough cash to purchase house and meets other requirements to purchase a house
//        if(financials.getPricePerImprovement() <= player.getCash() && canAddHouse(attributes, propertyAttributesMap)){
//            player.setCash(player.getCash() - financials.getPricePerImprovement());
//            attributes.setHouse(attributes.getHouse() + 1);
//            houseStock.put(houseStock.size() + 1 , attributes.getName());
//
//            System.out.println(STR."\{player.getToken()} purchased a house for \{attributes.getName()}");
//            System.out.println(STR."\{attributes.getName()} now has \{attributes.getHouse()} house(s).");
//        }
//    }
//
//    // this method might change. When buying a hotel I might give them a choice of color group then available properties they can buy hotels for
//    public void buildHotel(Player player, PropertyAttributes attributes, PropertyFinancials financials,LinkedHashMap<String, PropertyAttributes> propertyAttributesMap){
//
//        // if player has enough cash to purchase house and meets other requirements to purchase a house
//        if(financials.getPricePerImprovement() <= player.getCash() && canAddHotel(attributes, propertyAttributesMap)){
//            player.setCash(player.getCash() - financials.getPricePerImprovement());
//            attributes.setHotel(true);
//
//            System.out.println(STR."\{player.getToken()} purchased hotel for \{attributes.getName()}");
//            System.out.println(STR."\{attributes.getName()} now has a hotel");
//        }
//    }
//
//    public boolean canAddHouse(PropertyAttributes attributes, LinkedHashMap<String, PropertyAttributes> propertyAttributesMap){
//
//        // checks for color group monopoly, if improvements can be built, if the color group has a mortgage, color group has hotels
//        if(!isMonopoly || !attributes.isImprovementAllowed()
//                || colorGroupHasMortgaged(propertyAttributesMap)
//                || colorHotelsExist(propertyAttributesMap)) return false;
//
//        int totalHouseCount = getColorGroupHouseCount(propertyAttributesMap);
//
//        if(propertyList.size() == 2){
//            // property color group of size 2
//            if(totalHouseCount == 0 || totalHouseCount == 1){
//                return attributes.getHouse() < 1;
//            }
//            else if(totalHouseCount == 2 || totalHouseCount == 3){
//                return attributes.getHouse() < 2;
//            }
//            else if(totalHouseCount == 4 || totalHouseCount == 5){
//                return attributes.getHouse() < 3;
//            }
//            else if(totalHouseCount == 6 || totalHouseCount == 7){
//                return attributes.getHouse() < 4;
//            }
//        } else{
//            // property color group of size 3
//            if(totalHouseCount >= 0 && totalHouseCount <= 2){
//                return attributes.getHouse() < 1;
//            }
//            else if(totalHouseCount >= 3 && totalHouseCount <= 5){
//                return attributes.getHouse() < 2;
//            }
//            else if(totalHouseCount >= 6 && totalHouseCount <= 8){
//                return attributes.getHouse() < 3;
//            }
//            else if(totalHouseCount >= 9 && totalHouseCount <= 11){
//                return attributes.getHouse() < 4;
//            }
//        }
//
//        return false;
//    }
//
//    public boolean canAddHotel(PropertyAttributes attributes, LinkedHashMap<String, PropertyAttributes> propertyAttributesMap){
//
//        int totalHouseCount = getColorGroupHouseCount(propertyAttributesMap);
//        int totalHotelCount = getColorGroupHotelCount(propertyAttributesMap);
//
//        if(propertyList.size() == 2){
//            // property color group of size 2
//            if(totalHouseCount == 8) return true;
//            else return totalHouseCount == 4 && totalHotelCount == 1 && !attributes.hasHotel();
//        } else{
//            // property color group of size 3
//            if(totalHouseCount == 12) return true;
//            else if(totalHouseCount == 8 && totalHotelCount == 1 && !attributes.hasHotel()) return true;
//            else return totalHouseCount == 4 && totalHotelCount == 2 && !attributes.hasHotel();
//        }
//    }

    public PropertyGroup getColor() {
        return color;
    }

    public boolean isMonopoly() {
        return isMonopoly;
    }

    public void setMonopoly(boolean monopoly) {
        this.isMonopoly = monopoly;
    }

    public ArrayList<String> getPropertyList() {
        return propertyList;
    }

    public LinkedHashMap<Integer, String> getHouseStockOrder() {
        return houseStockOrder;
    }

    public static class ColorGroupBuilder {

        private PropertyGroup color;
        private boolean isMonopoly;
        private ArrayList<String> propertyList;
        private LinkedHashMap<Integer, String> houseStock;

        public ColorGroupBuilder color(PropertyGroup color) {
            this.color = color;
            return this;
        }

        public ColorGroupBuilder isMonopoly(boolean isMonopoly) {
            this.isMonopoly = isMonopoly;
            return this;
        }

        public ColorGroupBuilder propertyList(ArrayList<String> propertyList) {
            this.propertyList = propertyList;
            return this;
        }

        public PropertyGroupProcessor build() {
            return new PropertyGroupProcessor(color, isMonopoly, propertyList);
        }
    }
}
