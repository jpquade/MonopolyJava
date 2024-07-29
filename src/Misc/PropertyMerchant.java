package Misc;

import Enums.PlayerToken;
import Properties.ColorGroup;
import Properties.PropertyAttributes;
import Properties.PropertyFinancials;

import java.util.LinkedHashMap;

public class PropertyMerchant {

    public void purchaseProperty(Player player, PropertyAttributes attributes, PropertyFinancials financials, ColorGroup colorGroup,
                                 LinkedHashMap<String, PropertyAttributes> propertyAttributesMap){
        // player purchases property if requirements met
        if(attributes.getOwner() == PlayerToken.NONE && financials.getPrice() <= player.getCash()){
            System.out.println(STR."\{player.getToken()} had \{player.getCash()}");
            player.setCash(player.getCash() - financials.getPrice());
            attributes.setOwner(player.getToken());


            System.out.println(STR."\{player.getToken()} paid \{financials.getPrice()} cash and now has \{player.getCash()}");
            System.out.println(STR."\{player.getToken()} has purchased \{attributes.getName()}");

            // search for a monopoly and print if true
            if(colorGroup.checkForMonopoly(player, propertyAttributesMap)){
                System.out.println();
                System.out.println(STR."\{player.getToken()} now has a monopoly with the \{attributes.getColor()} group.");
            }

        } else {
            System.out.println("Insufficient funds.");
            System.out.println(STR."\{player.getToken()} has \{player.getCash()} cash. The property costs\{financials.getPrice()}");
        }
    }
}
