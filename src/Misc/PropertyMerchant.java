package Misc;

import Enums.PlayerToken;
import Properties.ColorGroup;
import Properties.PropertyAttributes;
import Properties.PropertyFinancials;

import java.util.LinkedHashMap;

public class PropertyMerchant {

    public PropertyMerchant(){}

    public void purchaseProperty(Player player, PropertyAttributes attributes, PropertyFinancials financials, ColorGroup colorGroup,
                                 LinkedHashMap<String, PropertyAttributes> propertyAttributesMap){

        // player purchases property if requirements met
        if(attributes.getOwner() == PlayerToken.NONE && financials.getPrice() <= player.getCash()){
            System.out.println();
            System.out.println(STR."\{player.getToken()} has \{player.getCash()}.");
            player.setCash(player.getCash() - financials.getPrice());
            attributes.setOwner(player.getToken());


            System.out.println(STR."\{player.getToken()} paid \{financials.getPrice()} cash and now has \{player.getCash()}.");
            System.out.println(STR."\{player.getToken()} has purchased \{attributes.getName()}.");

            // search for a monopoly and print if true
            if(colorGroup.checkForMonopoly(player, propertyAttributesMap)){
                System.out.println();
                System.out.println(STR."\{player.getToken()} now has a monopoly with the \{attributes.getColor()} color group which includes...");
                System.out.println(colorGroup.getPropertyList());
            }

        } else {
            System.out.println();
            System.out.println("Insufficient funds.");
            System.out.println(STR."\{player.getToken()} has \{player.getCash()} cash. The property costs \{financials.getPrice()}.");
        }
    }

    // this method might change. When buying a house I might give them a choice of color group then available properties they can buy houses for
    public void buildHouse(Player player, PropertyAttributes attributes, PropertyFinancials financials,LinkedHashMap<String, PropertyAttributes> propertyAttributesMap, ColorGroup colorGroup){

        // given list of properties you have monopolies of
        // ie oriental - 4 houses
        //     ventnor - 3 houses

        if(!canAddHouse(attributes, propertyAttributesMap, colorGroup)){
            System.out.println("Can't buy a house in the current color group at this time.");
            return;
        }

        System.out.println("Locations you can build a house:");
        for(int i = 0; i < colorGroup.getPropertyList().size(); i++){

            int colorSize = colorGroup.getPropertyList().size();

            // color group of size 2 with available house spots to build
            if(colorSize == 2){

            } else{

                // color group of size 3 with available house spots to build

                LinkedHashMap<Integer, String> listOfHouses = new LinkedHashMap<>();

                if(colorSize >= 0 && colorSize <= 2){

                    // find properties with 0 houses
                    for(int j = 0; j < colorGroup.getPropertyList().size(); j++){

                    }
                }
                else if(colorSize >= 3 && colorSize <= 5){
                    // find properties with 1 houses
                }
                else if(colorSize >= 6 && colorSize <= 8){
                    // find properties with 2 houses
                }
                else if(colorSize >= 9 && colorSize <= 11){
                    // find properties with 3 houses
                }
            }
        }

        // if player has enough cash to purchase house and meets other requirements to purchase a house
        if(financials.getPricePerImprovement() <= player.getCash()){
            player.setCash(player.getCash() - financials.getPricePerImprovement());
            attributes.setHouse(attributes.getHouse() + 1);
            colorGroup.getHouseStockOrder().put(colorGroup.getHouseStockOrder().size() + 1 , attributes.getName());

            System.out.println(STR."\{player.getToken()} purchased a house for \{attributes.getName()}");
            System.out.println(STR."\{attributes.getName()} now has \{attributes.getHouse()} house(s).");
        }
    }

    // checks non-financial requirements for building a house
    private boolean canAddHouse(PropertyAttributes attributes, LinkedHashMap<String, PropertyAttributes> propertyAttributesMap, ColorGroup colorGroup){

        // checks for color group monopoly, if improvements can be built, if the color group has a mortgage, color group has hotels, maxed out on houses
        if(!colorGroup.isMonopoly() || !attributes.isImprovementAllowed()
                || colorGroup.colorGroupHasMortgaged(propertyAttributesMap)
                || colorGroup.colorHotelsExist(propertyAttributesMap)
                || colorGroup.getHouseStockOrder().size() == 12) return false;

        // checks number of houses already

        int totalHouseCount = colorGroup.getColorGroupHouseCount(propertyAttributesMap);

        if(colorGroup.getPropertyList().size() == 2){
            // property color group of size 2
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
        } else{
            // property color group of size 3
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

    // this method might change. When buying a hotel I might give them a choice of color group then available properties they can buy hotels for
    public void buildHotel(Player player, PropertyAttributes attributes, PropertyFinancials financials,LinkedHashMap<String, PropertyAttributes> propertyAttributesMap, ColorGroup colorGroup){

        // if player has enough cash to purchase house and meets other requirements to purchase a house
        if(financials.getPricePerImprovement() <= player.getCash() && canAddHotel(attributes, propertyAttributesMap, colorGroup)){
            player.setCash(player.getCash() - financials.getPricePerImprovement());
            attributes.setHotel(true);

            System.out.println(STR."\{player.getToken()} purchased hotel for \{attributes.getName()}");
            System.out.println(STR."\{attributes.getName()} now has a hotel");
        }
    }



    private boolean canAddHotel(PropertyAttributes attributes, LinkedHashMap<String, PropertyAttributes> propertyAttributesMap, ColorGroup colorGroup){

        int totalHouseCount = colorGroup.getColorGroupHouseCount(propertyAttributesMap);
        int totalHotelCount = colorGroup.getColorGroupHotelCount(propertyAttributesMap);

        if(colorGroup.getPropertyList().size() == 2){
            // property color group of size 2
            if(totalHouseCount == 8) return true;
            else return totalHouseCount == 4 && totalHotelCount == 1 && !attributes.hasHotel();
        } else{
            // property color group of size 3
            if(totalHouseCount == 12) return true;
            else if(totalHouseCount == 8 && totalHotelCount == 1 && !attributes.hasHotel()) return true;
            else return totalHouseCount == 4 && totalHotelCount == 2 && !attributes.hasHotel();
        }
    }
}
