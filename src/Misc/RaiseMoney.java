package Misc;

import Properties.PropertyAttributes;
import Properties.PropertyFinancials;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class RaiseMoney {



    public RaiseMoney(){}

    // different ways to raise money
    public void raiseMoneyOptions(Player player, LinkedHashMap<String, PropertyAttributes> propertyAttributes, NumberValueCheck numberValueCheck,
                                  LinkedHashMap<String, PropertyFinancials> propertyFinancials, ArrayList<Player> playerList, Scanner scanner){

        System.out.println("1. Mortgage Property");
        System.out.println("2. Sell Improvements");
        System.out.println("3. Sell Property");
        System.out.println("4: Return to main Options");

        switch(Integer.parseInt(numberValueCheck.validEntry(1, 4, scanner))){

            case 1: // mortgage propertyAttributes
                mortgageProperty(player, propertyAttributes, propertyFinancials, numberValueCheck, scanner);
                break;
            case 2: // sell improvements
                sellImprovements(player, propertyAttributes, numberValueCheck, propertyFinancials, scanner);
                break;
            case 3: // sell propertyAttributes
                sellProperty(player, playerList, numberValueCheck, propertyAttributes, propertyFinancials, scanner);
                break;
        }
    }

    private void mortgageProperty(Player player, LinkedHashMap<String, PropertyAttributes> propertyAttributes, LinkedHashMap<String, PropertyFinancials> propertyFinancials,
                                  NumberValueCheck numberValueCheck, Scanner scanner){

        System.out.println(STR."List of properties \{player.getToken()} has:");
        System.out.println();

        LinkedHashMap<Integer, String> listOfUnMortgaged = new LinkedHashMap<>();
        int i = 1;

        // checks for player owned properties with no improvements that can be mortgaged
        for(PropertyAttributes propertyFeatures: propertyAttributes.values()){

            // messages are generated when propertyAttributes cannot be mortgaged
            ArrayList<String> mortgageList = new ArrayList<>();
            StringBuilder cannotMortgageMessage = new StringBuilder();

            // propertyAttributes is not mortgaged and is owned my current player
            if(!propertyFeatures.isMortgaged() && propertyFeatures.getOwner() == player.getToken()){

                if(propertyFeatures.getHouse() > 0){
                    String improvement = STR."House(s) on property";
                    mortgageList.add(improvement);
                }
                else if(propertyFeatures.hasHotel()){
                    String improvement = STR."Hotel on property";
                    mortgageList.add(improvement);
                }

                // searches for properties of the same color with hotels and houses that need to be sold first
                for(PropertyAttributes propertyAttributesColor : propertyAttributes.values()){

                    // checks other properties that are the same color having improvements built on them
                    if(!propertyAttributesColor.getName().equals(propertyFeatures.getName()) && propertyAttributesColor.getColor() == propertyFeatures.getColor()){
                        if(propertyAttributesColor.getHouse() > 0){
                            String colorPropertyHouse = STR."Property of same color (\{propertyAttributesColor.getName()}) has house(s)";
                            mortgageList.add(colorPropertyHouse);
                        }
                        else if(propertyAttributesColor.hasHotel()){
                            String colorPropertyHotel = STR."Property of same color (\{propertyAttributesColor.getName()}) has a hotel)";
                            mortgageList.add(colorPropertyHotel);
                        }
                    }
                }

                // propertyAttributes will be listed if it can be mortgaged
                if(mortgageList.isEmpty()){
                    System.out.printf("%1$-30s %2$s %n", STR."\{i}. \{propertyFeatures.getName()}",
                            STR."Mortgage for:    \{propertyFinancials.get(propertyFeatures.getName()).getMortgageAmount()}");
                    listOfUnMortgaged.put(i, propertyFeatures.getName());
                    i++;
                }
                else{
                    // list of reasons propertyAttributes cannot be mortgaged
                    for(String message : mortgageList){
                        cannotMortgageMessage.append(STR."\{message}, ");
                    }

                    System.out.printf("%1$-30s %2$s%3$s %n", STR."/: \{propertyFeatures.getName()}", "Cannot mortgage: ",
                            cannotMortgageMessage.substring(0, cannotMortgageMessage.length() - 2));
                }
            }
        }
        System.out.println(STR."\{i}: Return to main Options");

        System.out.println("Select which property you want to mortgage or return to main options.");

        String userEntry = numberValueCheck.validEntry(1, i, scanner);

        int mortgageSelection = Integer.parseInt(userEntry);

        if(!numberValueCheck.notInRange(userEntry, 0, i - 1)){

            System.out.println(STR."\{player.getToken()} started with \{player.getCash()} cash.");

            // set player cash (current player cash + mortgage amount)
            player.setCash(player
                    .getCash() + propertyFinancials.get(listOfUnMortgaged
                    .get(mortgageSelection)).getMortgageAmount());

            // mortgage propertyAttributes set to true
            propertyAttributes.get(listOfUnMortgaged.get(mortgageSelection)).setMortgaged(true);

            System.out.println(STR."Mortgaged \{listOfUnMortgaged.get(mortgageSelection)} and added \{propertyFinancials
                    .get(listOfUnMortgaged.get(mortgageSelection)).getMortgageAmount()} to wallet.");
            System.out.println(STR."\{player
                    .getToken()} now has \{player.getCash()} cash.");
        }
    }

    private void sellImprovements(Player player, LinkedHashMap<String, PropertyAttributes> propertyAttributes, NumberValueCheck numberValueCheck,
                                  LinkedHashMap<String, PropertyFinancials> propertyFinancials, Scanner scanner){

        System.out.println(STR."List of improved properties \{player.getToken()} owns:");
        System.out.println();

        // index to keep track of element number within listOfUnMortgaged
        int i = 1;

        LinkedHashMap<Integer, String> listOfImproved = new LinkedHashMap<>();

        for(PropertyAttributes propertyfeatures: propertyAttributes.values()){
            if(propertyfeatures.isImprovementAllowed()){

                // checks if property has houses
                if(propertyfeatures.getHouse() > 0){

                    // messages are generated when propertyAttributes cannot be mortgaged
                    ArrayList<String> improvementList = new ArrayList<>();
                    StringBuilder cannotSellHouse = new StringBuilder();

                    // searches for properties of the same color with hotels that need to be sold first
                    for(PropertyAttributes propertyAttributesColor : propertyAttributes.values()){
                        if(!propertyAttributesColor.getName().equals(propertyfeatures.getName()) && propertyAttributesColor.getColor() == propertyfeatures.getColor() && propertyAttributesColor.hasHotel()){
                            //System.out.println(STR."/: hotels on same propertyAttributes color \{propertyColor.getName()} must be sold first");
                            String hotelImprovement = STR."Same propertyAttributes color \{propertyAttributesColor.getName()} has hotels that must be sold first";
                            improvementList.add(hotelImprovement);
                        }
                    }

                    System.out.println(STR."\{i}: \{propertyfeatures.getName()} has \{propertyAttributes
                            .get(propertyfeatures.getName()).getHouse()} house(s) for \{propertyFinancials
                            .get(propertyfeatures.getName()).getPricePerImprovement() / 2} each");
                    listOfImproved.put(i, propertyfeatures.getName());
                    i++;
                }
                // checks if property has hotels
                else if(propertyfeatures.hasHotel()){
                    System.out.println(STR."\{i}: \{propertyfeatures.getName()} has hotel for \{propertyFinancials
                            .get(propertyfeatures.getName()).getPricePerImprovement() / 2}.");
                    listOfImproved.put(i, propertyfeatures.getName());
                    i++;
                }
            }
        }

        System.out.println(STR."\{i}: Return to Main Options");

        System.out.println("Select which property you want to sell improvements from or return to main options.");

        String userEntry = numberValueCheck.validEntry(0, i, scanner);

        int improvementSelection = Integer.parseInt(userEntry) - 1;

        // if option selected is 0 to i - sell a property
        if(numberValueCheck.notInRange(userEntry, 0, i)) {

            PropertyAttributes selectedPropertyAttributesAttributes = propertyAttributes.get(listOfImproved.get(improvementSelection));
            PropertyFinancials selectedPropertyFinancials = propertyFinancials.get(listOfImproved.get(improvementSelection));

            int numberOfHouses = selectedPropertyAttributesAttributes.getHouse();

            // sell houses
            if (numberOfHouses > 0) {

                // check if another property of the same color has a hotel that needs to be sold first before houses on this property
                for(PropertyAttributes propertyAttributesColor : propertyAttributes.values()){
                    if(!propertyAttributesColor.getName().equals(selectedPropertyAttributesAttributes.getName())
                            && propertyAttributesColor.getColor() == selectedPropertyAttributesAttributes.getColor() && propertyAttributesColor.hasHotel()){

                        System.out.println("This property color shares another property that has a hotel which must be sold first before selling houses on this property");
                        return;
                    }
                }

                System.out.println(STR."How many houses do you want to sell? You have \{numberOfHouses} house(s) on this property.");
                System.out.println();
                System.out.println(STR."Enter number of houses up to \{numberOfHouses}");
                System.out.println(STR."\{numberOfHouses + 1}: Return to main Options");

                int housesToSell = Integer.parseInt(numberValueCheck.validEntry(1, numberOfHouses, scanner));

                // remove houses sold
                selectedPropertyAttributesAttributes.setHouse(selectedPropertyAttributesAttributes.getHouse() - housesToSell);

                // add cash from sold houses to player
                player.setCash(player.getCash()
                        + (housesToSell * selectedPropertyFinancials.getPricePerImprovement() / 2));

                System.out.println(STR."Selling \{numberOfHouses} house(s) for half of \{selectedPropertyFinancials
                        .getPricePerImprovement()} each.");

                System.out.println(STR."\{player.getToken()} now has \{player.getCash()}");

            }
            // sell hotel
            else{
                System.out.println(STR."1: Sell your hotel.");
                System.out.println(STR."2: Return to main Options");
                System.out.println();

                int sellHotelSelection = Integer.parseInt(numberValueCheck.validEntry(1, 2, scanner));

                if(sellHotelSelection == 1){

                    // remove hotel sold
                    selectedPropertyAttributesAttributes.setHotel(false);

                    // add cash from sold hotel to player
                    player.setCash(player.getCash() + selectedPropertyFinancials.getPricePerImprovement() / 2);

                    System.out.println(STR."Selling hotel for half of \{selectedPropertyFinancials.getPricePerImprovement()}.");
                    System.out.println(STR."\{player.getToken()} now has \{player.getCash()}");
                }
            }
        }
    }

    private void sellProperty(Player player, ArrayList<Player> playerList, NumberValueCheck numberValueCheck,
                              LinkedHashMap<String, PropertyAttributes> propertyAttributes, LinkedHashMap<String,
            PropertyFinancials> propertyFinancials, Scanner scanner){
        LinkedHashMap<Integer, Integer> playerChoice = new LinkedHashMap<>();
        int i = 1;

        System.out.println(STR."Which player if any wants to purchase a property from \{player.getToken()}");
        System.out.println();
        for(Player otherPlayer : playerList){
            if(otherPlayer != player){
                System.out.println(STR."\{i}: \{otherPlayer.getToken()}");
                playerChoice.put(i, otherPlayer.getPlayerNumber());
            }

            i++;
        }

        System.out.println(STR."\{i}: Return to main Options");

        int playerPay = Integer.parseInt(numberValueCheck.validEntry(1, i, scanner));

        Player selectedPlayer = playerList.get(playerChoice.get(playerPay));

        System.out.println(STR."Here is a list of properties player:\{selectedPlayer.getToken()}can purchase.");
        System.out.println();

        ArrayList<String> listOfProperties = new ArrayList<>();

        i = 0;

        for(PropertyAttributes propertyFeatures: propertyAttributes.values()){
            if(propertyFeatures.getOwner() == player.getToken()){
                if(!propertyFeatures.isMortgaged()){
                    System.out.println(STR."\{i + 1}: \{propertyFeatures.getName()}");
                }
                else{
                    System.out.println(STR. "\{i + 1}: \{propertyFeatures.getName()} is currently mortgaged and will cost an additional 10% of the mortgage rate to purchase");
                }
                listOfProperties.add(propertyFeatures.getName());
            }
            i++;
        }

        System.out.println(STR."\{i}: Return to main Options");

        int selectProperty = Integer.parseInt(numberValueCheck.validEntry(1, i, scanner));

        PropertyAttributes selectedPropertyAttributesAttributes = propertyAttributes.get(listOfProperties.get(selectProperty));
        PropertyFinancials selectedPropertyFinancials = propertyFinancials.get(listOfProperties.get(selectProperty));

        if(selectedPropertyAttributesAttributes.isMortgaged()){
            System.out.println(STR."Property selected is mortgaged. The interest \{selectedPropertyFinancials
                    .getMortgageAmount() * .10} + the amount entered will be the final cost.");

            System.out.println("Enter an amount the property will be purchased for in whole dollars only");

            int propertyCost = Integer.parseInt(numberValueCheck.validEntry(1, selectedPlayer.getCash(), scanner));

            System.out.println(STR."Are you sure you want to purchase this property for the sum of:\{propertyCost} + \{selectedPropertyFinancials
                    .getMortgageAmount() * .10}");

            String entry = "";

            do {
                System.out.print("Please enter y/n ");
                entry = scanner.nextLine().trim().toLowerCase();
            }
            while (!entry.equals("y") && !entry.equals("n"));

            if(entry.equals("y")){
                // if player purchasing propertyAttributes has enough cash
                if(selectedPlayer.getCash() - (propertyCost + selectedPropertyFinancials.getMortgageAmount() * .10) >= 0){
                    selectedPlayer.setCash(selectedPlayer.getCash() - (int)(propertyCost + selectedPropertyFinancials.getMortgageAmount() * .10));
                }
                else{
                    System.out.println();
                    System.out.println(STR."\{selectedPlayer.getToken()} doesn't have enough cash.");
                }
            }
        }
        else {
            // if propertyAttributes is not mortgaged
            System.out.println("Enter an amount the property will be purchased for in whole dollars only");

            int propertyCost = Integer.parseInt(numberValueCheck.validEntry(1, selectedPlayer.getCash(), scanner));

            System.out.println(STR."Are you sure you want to purchase this property for the sum of:\{propertyCost}");

            String entry = "";

            do {
                System.out.print("Please enter y/n ");
                entry = scanner.nextLine().trim().toLowerCase();
            }
            while (!entry.equals("y") && !entry.equals("n"));

            if(entry.equals("y")){
                // if player purchasing propertyAttributes has enough cash
                if(selectedPlayer.getCash() - (propertyCost + selectedPropertyFinancials.getMortgageAmount() * .10) >= 0){
                    selectedPlayer.setCash(selectedPlayer.getCash() - (propertyCost));
                }
                else{
                    System.out.println();
                    System.out.println(STR."\{selectedPlayer.getToken()} doesn't have enough cash.");
                }
            }
        }
    }
}
