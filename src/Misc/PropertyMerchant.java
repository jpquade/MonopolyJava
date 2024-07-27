package Misc;

import Enums.PlayerToken;
import Properties.PropertyAttributes;
import Properties.PropertyFinancials;

public class PropertyMerchant {

    public void purchaseProperty(Player player, PropertyAttributes attributes, PropertyFinancials financials){
        if(attributes.getOwner() == PlayerToken.NONE && financials.getPrice() <= player.getCash()){
            System.out.println(player.getToken() + " had " + player.getCash());
            player.setCash(player.getCash() - financials.getPrice());
            attributes.setOwner(player.getToken());


            System.out.println(player.getToken() + " paid " + financials.getPrice() + " cash and now has " + player.getCash());
            System.out.println(player.getToken() + " has purchased " + attributes.getName());

            // search for a monopoly and print if there is a monopoly
        }
    }

}
