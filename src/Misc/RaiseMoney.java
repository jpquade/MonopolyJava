package Misc;

import Properties.Property;
import Properties.PropertyFinancials;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.Stack;

public class RaiseMoney {



    public RaiseMoney(){}

    // different ways to raise money
    public void raiseMoneyOptions(Player player, LinkedHashMap<String, Property> propertyAttributes, NumberValueCheck numberValueCheck,
                                  LinkedHashMap<String, PropertyFinancials> propertyFinancials, ArrayList<Player> playerList, Scanner scanner){

        System.out.println("1. Mortgage Property");
        System.out.println("2. Sell Improvements");
        System.out.println("3. Sell Property");
        System.out.println("4: Return to main Options");

        switch(Integer.parseInt(numberValueCheck.validEntry(1, 4, scanner))){

            case 1: // mortgage property
                mortgageProperty(player, propertyAttributes, propertyFinancials, numberValueCheck, scanner);
                break;
            case 2: // sell improvements
                sellImprovements(player, propertyAttributes, numberValueCheck, propertyFinancials, scanner);
                break;
            case 3: // sell property
                sellProperty(player, playerList, numberValueCheck, propertyAttributes, propertyFinancials, scanner);
                break;
        }
    }

    private void mortgageProperty(Player player, LinkedHashMap<String, Property> propertyAttributes, LinkedHashMap<String, PropertyFinancials> propertyFinancials,
                                  NumberValueCheck numberValueCheck, Scanner scanner){

        System.out.println("List of properties you own");
        System.out.println();

        LinkedHashMap<Integer, String> listOfUnMortgaged = new LinkedHashMap<>();
        int i = 1;



        // checks for player owned properties with no improvements that can be mortgaged
        for(Property property: propertyAttributes.values()){

            // messages are generated as to why property cannot be mortgaged if applicable
            ArrayList<String> mortgageList = new ArrayList<>();
            StringBuilder cannotMortgageMessage = new StringBuilder();

            // property is not mortgaged and is owned my current player
            if(!property.isMortgaged() && property.getOwner() == player.getToken()){

                if(property.getHouse() > 0){
                    String propertyHouse = STR."has house(s)";
                    mortgageList.add(propertyHouse);
                }
                else if(property.hasHotel()){
                    String propertyHotel = STR."has a hotel";
                    mortgageList.add(propertyHotel);
                }

                // searches for properties of the same color with hotels and houses that need to be sold first
                for(Property propertyColor : propertyAttributes.values()){

                    // checks other properties that are the same color having improvements built on them
                    if(!propertyColor.getName().equals(property.getName()) && propertyColor.getColor() == property.getColor()){
                        if(propertyColor.getHouse() > 0){
                            String colorPropertyHouse = STR."Property of same color (\{propertyColor.getName()}) has house(s)";
                            mortgageList.add(colorPropertyHouse);
                        }
                        else if(propertyColor.hasHotel()){
                            String colorPropertyHotel = STR."Property of same color (\{propertyColor.getName()}) has a hotel)";
                            mortgageList.add(colorPropertyHotel);
                        }
                    }
                }

                // property will be listed as able to mortgage
                if(mortgageList.isEmpty()){
                    System.out.println(STR."\{i}. \{property.getName()} - Mortgage amount: \{propertyFinancials
                            .get(property.getName()).getMortgageAmount()}");
                    listOfUnMortgaged.put(i, property.getName());
                    i++;
                }
                else{
                    // print list of why property cannot be mortgaged
                    cannotMortgageMessage.append(STR."/: \{property.getName()} ");
                    cannotMortgageMessage.append("(Can't mortgage): ");
                    for(String message : mortgageList){
                        cannotMortgageMessage.append(STR."\{message}, ");
                    }

                    System.out.println(cannotMortgageMessage.substring(0, cannotMortgageMessage.length() - 2));
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

            // mortgage property set to true
            propertyAttributes.get(listOfUnMortgaged.get(mortgageSelection)).setMortgaged(true);

            System.out.println(STR."Mortgaged \{listOfUnMortgaged.get(mortgageSelection)} and added \{propertyFinancials
                    .get(listOfUnMortgaged.get(mortgageSelection)).getMortgageAmount()} to wallet.");
            System.out.println(STR."\{player
                    .getToken()} now has \{player.getCash()} cash.");
        }
    }

    private void sellImprovements(Player player, LinkedHashMap<String, Property> propertyAttributes, NumberValueCheck numberValueCheck,
                                  LinkedHashMap<String, PropertyFinancials> propertyFinancials, Scanner scanner){

        System.out.println("List of improved properties you own:");
        System.out.println();

        // index to keep track of element number within listOfUnMortgaged
        int i = 1;

        LinkedHashMap<Integer, String> listOfImproved = new LinkedHashMap<>();

        for(Property property: propertyAttributes.values()){
            if(property.isImprovementAllowed() && (property.getHouse() > 0 || property.hasHotel())){

                if(property.getHouse() > 0){

                    // searches for properties of the same color with hotels that need to be sold first
                    for(Property propertyColor : propertyAttributes.values()){
                        if(!propertyColor.getName().equals(property.getName()) && propertyColor.getColor() == property.getColor() && propertyColor.hasHotel()){
                            System.out.println(STR." : \{property.getName()} has \{propertyAttributes
                                    .get(property.getName()).getHouse()} house(s) that cannot be sold until the hotels are sold on \{propertyColor.getName()}");
                        }
                    }

                    System.out.println(STR."\{i}: \{property.getName()} has \{propertyAttributes
                            .get(property.getName()).getHouse()} house(s) that sell for \{propertyFinancials
                            .get(property.getName()).getPricePerImprovement() / 2} each}");
                }
                else{
                    System.out.println(STR."\{i}: \{property.getName()} has a hotel that sells for \{propertyFinancials
                            .get(property.getName()).getPricePerImprovement() / 2}.}");
                }
                listOfImproved.put(i, property.getName());
            }
            i++;
        }

        System.out.println(STR."\{i}: Return to main Options");

        System.out.println("Select which property you want to sell improvements from.");

        String userEntry = numberValueCheck.validEntry(0, i, scanner);

        int improvementSelection = Integer.parseInt(userEntry) - 1;

        // if option selected is 0 to i - sell a property
        if(numberValueCheck.notInRange(userEntry, 0, i)) {

            Property selectedPropertyAttributes = propertyAttributes.get(listOfImproved.get(improvementSelection));
            PropertyFinancials selectedPropertyFinancials = propertyFinancials.get(listOfImproved.get(improvementSelection));

            int numberOfHouses = selectedPropertyAttributes.getHouse();

            // sell houses
            if (numberOfHouses > 0) {

                // check if another property of the same color has a hotel that needs to be sold first before houses on this property
                for(Property propertyColor : propertyAttributes.values()){
                    if(!propertyColor.getName().equals(selectedPropertyAttributes.getName())
                            && propertyColor.getColor() == selectedPropertyAttributes.getColor() && propertyColor.hasHotel()){

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
                selectedPropertyAttributes.setHouse(selectedPropertyAttributes.getHouse() - housesToSell);

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
                    selectedPropertyAttributes.setHotel(false);

                    // add cash from sold hotel to player
                    player.setCash(player.getCash() + selectedPropertyFinancials.getPricePerImprovement() / 2);

                    System.out.println(STR."Selling hotel for half of \{selectedPropertyFinancials.getPricePerImprovement()}.");
                    System.out.println(STR."\{player.getToken()} now has \{player.getCash()}");
                }
            }
        }
    }

    private void sellProperty(Player player, ArrayList<Player> playerList, NumberValueCheck numberValueCheck,
                              LinkedHashMap<String, Property> propertyAttributes, LinkedHashMap<String,
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

        for(Property property: propertyAttributes.values()){
            if(property.getOwner() == player.getToken()){
                if(!property.isMortgaged()){
                    System.out.println(STR."\{i + 1}: \{property.getName()}");
                }
                else{
                    System.out.println(STR. "\{i + 1}: \{property.getName()} is currently mortgaged and will cost an additional 10% of the mortgage rate to purchase");
                }
                listOfProperties.add(property.getName());
            }
            i++;
        }

        System.out.println(STR."\{i}: Return to main Options");

        int selectProperty = Integer.parseInt(numberValueCheck.validEntry(1, i, scanner));

        Property selectedPropertyAttributes = propertyAttributes.get(listOfProperties.get(selectProperty));
        PropertyFinancials selectedPropertyFinancials = propertyFinancials.get(listOfProperties.get(selectProperty));

        if(selectedPropertyAttributes.isMortgaged()){
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
                // if player purchasing property has enough cash
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
            // if property is not mortgaged
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
                // if player purchasing property has enough cash
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
