package Initialization;

import Enums.PlayerToken;
import Enums.PropertyColor;
import Enums.PropertyType;
import Properties.ColorGroup;
import Properties.PropertyAttributes;
import Properties.PropertyFinancials;

import java.util.ArrayList;
import java.util.Arrays;

public class InitializeData {

    String mediterraneanAvenue = "Mediterranean Avenue";
    String balticAvenue = "Baltic Avenue";
    String orientalAvenue = "Oriental Avenue";
    String vermontAvenue = "Vermont Avenue";
    String connecticutAvenue = "Connecticut Avenue";
    String stCharlesPlace = "St Charles Place";
    String statesAvenue = "States Avenue";
    String virginiaAvenue = "Virginia Avenue";
    String stJamesPlace = "St James Place";
    String tennesseeAvenue = "Tennessee Avenue";
    String newYorkAvenue = "New York Avenue";
    String kentuckyAvenue = "Kentucky Avenue";
    String indianaAvenue = "Indiana Avenue";
    String illinoisAvenue = "Illinois Avenue";
    String atlanticAvenue = "Atlantic Avenue";
    String ventnorAvenue = "Ventnor Avenue";
    String marvinGardens = "Marvin Gardens";
    String pacificAvenue = "Pacific Avenue";
    String northCarolinaAvenue = "North Carolina Avenue";
    String pennsylvaniaAvenue = "Pennsylvania Avenue";
    String parkPlace = "Park Place";
    String boardWalk = "Boardwalk";
    String electricCompany = "Electric Company";
    String waterWorks = "Water Works";
    String readingRailroad = "Reading Railroad";
    String pennsylvaniaRailRoad = "Pennsylvania RailRoad";
    String bandORailRoad = "B&O RailRoad";
    String shortLineRailroad = "Short Line Railroad";

    private ArrayList<PropertyAttributes> propertyAttributes;
    private ArrayList<PropertyFinancials> propertyFinancialAttributes;
    private ArrayList<String> gameBoard;
    private ArrayList<ColorGroup> colorGroup;

    public InitializeData() {
        initializePropertyAttributes();
        initializePropertyFinancialAttributes();
        initializeGameBoard();
        initializeColorGroup();
    }


    private void initializePropertyAttributes(){

        propertyAttributes = new ArrayList<>(Arrays.asList(
                new PropertyAttributes.PropertyBuilder().propertyType(PropertyType.STANDARD).name(mediterraneanAvenue) .color(PropertyColor.BROWN).improvementAllowed(true).owner(PlayerToken.NONE).build(),
                new PropertyAttributes.PropertyBuilder().propertyType(PropertyType.STANDARD).name(balticAvenue)        .color(PropertyColor.BROWN).improvementAllowed(true).owner(PlayerToken.NONE).build(),

                new PropertyAttributes.PropertyBuilder().propertyType(PropertyType.STANDARD).name(orientalAvenue)      .color(PropertyColor.LIGHTBLUE).improvementAllowed(true).owner(PlayerToken.NONE).build(),
                new PropertyAttributes.PropertyBuilder().propertyType(PropertyType.STANDARD).name(vermontAvenue)       .color(PropertyColor.LIGHTBLUE).improvementAllowed(true).owner(PlayerToken.NONE).build(),
                new PropertyAttributes.PropertyBuilder().propertyType(PropertyType.STANDARD).name(connecticutAvenue)   .color(PropertyColor.LIGHTBLUE).improvementAllowed(true).owner(PlayerToken.NONE).build(),

                new PropertyAttributes.PropertyBuilder().propertyType(PropertyType.STANDARD).name(stCharlesPlace)      .color(PropertyColor.PINK).improvementAllowed(true).owner(PlayerToken.NONE).build(),
                new PropertyAttributes.PropertyBuilder().propertyType(PropertyType.STANDARD).name(statesAvenue)        .color(PropertyColor.PINK).improvementAllowed(true).owner(PlayerToken.NONE).build(),
                new PropertyAttributes.PropertyBuilder().propertyType(PropertyType.STANDARD).name(virginiaAvenue)      .color(PropertyColor.PINK).improvementAllowed(true).owner(PlayerToken.NONE).build(),

                new PropertyAttributes.PropertyBuilder().propertyType(PropertyType.STANDARD).name(stJamesPlace)        .color(PropertyColor.ORANGE).improvementAllowed(true).owner(PlayerToken.NONE).build(),
                new PropertyAttributes.PropertyBuilder().propertyType(PropertyType.STANDARD).name(tennesseeAvenue)     .color(PropertyColor.ORANGE).improvementAllowed(true).owner(PlayerToken.NONE).build(),
                new PropertyAttributes.PropertyBuilder().propertyType(PropertyType.STANDARD).name(newYorkAvenue)       .color(PropertyColor.ORANGE).improvementAllowed(true).owner(PlayerToken.NONE).build(),

                new PropertyAttributes.PropertyBuilder().propertyType(PropertyType.STANDARD).name(kentuckyAvenue)      .color(PropertyColor.RED).improvementAllowed(true).owner(PlayerToken.NONE).build(),
                new PropertyAttributes.PropertyBuilder().propertyType(PropertyType.STANDARD).name(indianaAvenue)       .color(PropertyColor.RED).improvementAllowed(true).owner(PlayerToken.NONE).build(),
                new PropertyAttributes.PropertyBuilder().propertyType(PropertyType.STANDARD).name(illinoisAvenue)      .color(PropertyColor.RED).improvementAllowed(true).owner(PlayerToken.NONE).build(),

                new PropertyAttributes.PropertyBuilder().propertyType(PropertyType.STANDARD).name(atlanticAvenue)      .color(PropertyColor.YELLOW).improvementAllowed(true).owner(PlayerToken.NONE).build(),
                new PropertyAttributes.PropertyBuilder().propertyType(PropertyType.STANDARD).name(ventnorAvenue)       .color(PropertyColor.YELLOW).improvementAllowed(true).owner(PlayerToken.NONE).build(),
                new PropertyAttributes.PropertyBuilder().propertyType(PropertyType.STANDARD).name(marvinGardens)       .color(PropertyColor.YELLOW).improvementAllowed(true).owner(PlayerToken.NONE).build(),

                new PropertyAttributes.PropertyBuilder().propertyType(PropertyType.STANDARD).name(pacificAvenue)       .color(PropertyColor.GREEN).improvementAllowed(true).owner(PlayerToken.NONE).build(),
                new PropertyAttributes.PropertyBuilder().propertyType(PropertyType.STANDARD).name(northCarolinaAvenue) .color(PropertyColor.GREEN).improvementAllowed(true).owner(PlayerToken.NONE).build(),
                new PropertyAttributes.PropertyBuilder().propertyType(PropertyType.STANDARD).name(pennsylvaniaAvenue)  .color(PropertyColor.GREEN).improvementAllowed(true).owner(PlayerToken.NONE).build(),

                new PropertyAttributes.PropertyBuilder().propertyType(PropertyType.STANDARD).name(parkPlace)           .color(PropertyColor.DARKBLUE).improvementAllowed(true).owner(PlayerToken.NONE).build(),
                new PropertyAttributes.PropertyBuilder().propertyType(PropertyType.STANDARD).name(boardWalk)           .color(PropertyColor.DARKBLUE).improvementAllowed(true).owner(PlayerToken.NONE).build(),

                new PropertyAttributes.PropertyBuilder().propertyType(PropertyType.UTILITY).name(electricCompany)      .color(PropertyColor.WHITE).owner(PlayerToken.NONE).build(),
                new PropertyAttributes.PropertyBuilder().propertyType(PropertyType.UTILITY).name(waterWorks)           .color(PropertyColor.WHITE).owner(PlayerToken.NONE).build(),

                new PropertyAttributes.PropertyBuilder().propertyType(PropertyType.RAILROAD).name(readingRailroad)     .color(PropertyColor.BLACK).owner(PlayerToken.NONE).build(),
                new PropertyAttributes.PropertyBuilder().propertyType(PropertyType.RAILROAD).name(pennsylvaniaRailRoad).color(PropertyColor.BLACK).owner(PlayerToken.NONE).build(),
                new PropertyAttributes.PropertyBuilder().propertyType(PropertyType.RAILROAD).name(bandORailRoad)       .color(PropertyColor.BLACK).owner(PlayerToken.NONE).build(),
                new PropertyAttributes.PropertyBuilder().propertyType(PropertyType.RAILROAD).name(shortLineRailroad)   .color(PropertyColor.BLACK).owner(PlayerToken.NONE).build()
        ));
    }

    private void initializePropertyFinancialAttributes(){

        propertyFinancialAttributes = new ArrayList<>(Arrays.asList(
                new PropertyFinancials.PropertyFinancialBuilder().name(mediterraneanAvenue) .price(60).rent(2).pricePerImprovement(50).rentOneHouse(10).rentTwoHouse(30).rentThreeHouse(90).rentFourHouse(160).rentHotel(250).mortgageCost(30).build(),
                new PropertyFinancials.PropertyFinancialBuilder().name(balticAvenue)        .price(60).rent(4).pricePerImprovement(50).rentOneHouse(20).rentTwoHouse(60).rentThreeHouse(180).rentFourHouse(320).rentHotel(450).mortgageCost(30).build(),

                new PropertyFinancials.PropertyFinancialBuilder().name(orientalAvenue)      .price(100).rent(6).pricePerImprovement(50).rentOneHouse(30).rentTwoHouse(90).rentThreeHouse(270).rentFourHouse(400).rentHotel(550).mortgageCost(50).build(),
                new PropertyFinancials.PropertyFinancialBuilder().name(vermontAvenue)       .price(100).rent(6).pricePerImprovement(50).rentOneHouse(30).rentTwoHouse(90).rentThreeHouse(270).rentFourHouse(400).rentHotel(550).mortgageCost(50).build(),
                new PropertyFinancials.PropertyFinancialBuilder().name(connecticutAvenue)   .price(120).rent(8).pricePerImprovement(50).rentOneHouse(40).rentTwoHouse(100).rentThreeHouse(300).rentFourHouse(450).rentHotel(600).mortgageCost(60).build(),

                new PropertyFinancials.PropertyFinancialBuilder().name(stCharlesPlace)      .price(140).rent(10).pricePerImprovement(100).rentOneHouse(50).rentTwoHouse(150).rentThreeHouse(450).rentFourHouse(625).rentHotel(750).mortgageCost(70).build(),
                new PropertyFinancials.PropertyFinancialBuilder().name(statesAvenue)        .price(140).rent(10).pricePerImprovement(100).rentOneHouse(50).rentTwoHouse(150).rentThreeHouse(450).rentFourHouse(625).rentHotel(750).mortgageCost(70).build(),
                new PropertyFinancials.PropertyFinancialBuilder().name(virginiaAvenue)      .price(160).rent(12).pricePerImprovement(100).rentOneHouse(60).rentTwoHouse(180).rentThreeHouse(500).rentFourHouse(700).rentHotel(900).mortgageCost(80).build(),

                new PropertyFinancials.PropertyFinancialBuilder().name(stJamesPlace)        .price(180).rent(14).pricePerImprovement(100).rentOneHouse(70).rentTwoHouse(200).rentThreeHouse(550).rentFourHouse(750).rentHotel(950).mortgageCost(90).build(),
                new PropertyFinancials.PropertyFinancialBuilder().name(tennesseeAvenue)     .price(180).rent(14).pricePerImprovement(100).rentOneHouse(70).rentTwoHouse(200).rentThreeHouse(550).rentFourHouse(750).rentHotel(950).mortgageCost(90).build(),
                new PropertyFinancials.PropertyFinancialBuilder().name(newYorkAvenue)       .price(200).rent(16).pricePerImprovement(100).rentOneHouse(80).rentTwoHouse(220).rentThreeHouse(600).rentFourHouse(800).rentHotel(1000).mortgageCost(90).build(),

                new PropertyFinancials.PropertyFinancialBuilder().name(kentuckyAvenue)      .price(220).rent(18).pricePerImprovement(150).rentOneHouse(90).rentTwoHouse(250).rentThreeHouse(700).rentFourHouse(875).rentHotel(1050).mortgageCost(110).build(),
                new PropertyFinancials.PropertyFinancialBuilder().name(indianaAvenue)       .price(220).rent(18).pricePerImprovement(150).rentOneHouse(90).rentTwoHouse(250).rentThreeHouse(700).rentFourHouse(875).rentHotel(1050).mortgageCost(110).build(),
                new PropertyFinancials.PropertyFinancialBuilder().name(illinoisAvenue)      .price(240).rent(20).pricePerImprovement(150).rentOneHouse(100).rentTwoHouse(300).rentThreeHouse(750).rentFourHouse(925).rentHotel(1100).mortgageCost(120).build(),

                new PropertyFinancials.PropertyFinancialBuilder().name(atlanticAvenue)      .price(260).rent(22).pricePerImprovement(150).rentOneHouse(110).rentTwoHouse(330).rentThreeHouse(800).rentFourHouse(975).rentHotel(1150).mortgageCost(130).build(),
                new PropertyFinancials.PropertyFinancialBuilder().name(ventnorAvenue)       .price(260).rent(22).pricePerImprovement(150).rentOneHouse(110).rentTwoHouse(330).rentThreeHouse(800).rentFourHouse(975).rentHotel(1150).mortgageCost(130).build(),
                new PropertyFinancials.PropertyFinancialBuilder().name(marvinGardens)       .price(280).rent(24).pricePerImprovement(150).rentOneHouse(120).rentTwoHouse(360).rentThreeHouse(850).rentFourHouse(975).rentHotel(1200).mortgageCost(140).build(),

                new PropertyFinancials.PropertyFinancialBuilder().name(pacificAvenue)       .price(300).rent(26).pricePerImprovement(200).rentOneHouse(130).rentTwoHouse(390).rentThreeHouse(900).rentFourHouse(1100).rentHotel(1275).mortgageCost(150).build(),
                new PropertyFinancials.PropertyFinancialBuilder().name(northCarolinaAvenue) .price(300).rent(26).pricePerImprovement(200).rentOneHouse(130).rentTwoHouse(390).rentThreeHouse(900).rentFourHouse(1100).rentHotel(1275).mortgageCost(150).build(),
                new PropertyFinancials.PropertyFinancialBuilder().name(pennsylvaniaAvenue)  .price(320).rent(28).pricePerImprovement(200).rentOneHouse(150).rentTwoHouse(450).rentThreeHouse(1000).rentFourHouse(1200).rentHotel(1400).mortgageCost(160).build(),

                new PropertyFinancials.PropertyFinancialBuilder().name(parkPlace)           .price(350).rent(35).pricePerImprovement(200).rentOneHouse(175).rentTwoHouse(500).rentThreeHouse(1100).rentFourHouse(1300).rentHotel(1500).mortgageCost(175).build(),
                new PropertyFinancials.PropertyFinancialBuilder().name(boardWalk)           .price(400).rent(50).pricePerImprovement(200).rentOneHouse(200).rentTwoHouse(600).rentThreeHouse(1400).rentFourHouse(1700).rentHotel(2000).mortgageCost(200).build(),

                new PropertyFinancials.PropertyFinancialBuilder().name(electricCompany)     .price(150).mortgageCost(75).build(),
                new PropertyFinancials.PropertyFinancialBuilder().name(waterWorks)          .price(150).mortgageCost(75).build(),

                new PropertyFinancials.PropertyFinancialBuilder().name(readingRailroad)     .price(200).mortgageCost(100).build(),
                new PropertyFinancials.PropertyFinancialBuilder().name(pennsylvaniaRailRoad).price(200).mortgageCost(100).build(),
                new PropertyFinancials.PropertyFinancialBuilder().name(bandORailRoad)       .price(200).mortgageCost(100).build(),
                new PropertyFinancials.PropertyFinancialBuilder().name(shortLineRailroad)   .price(200).mortgageCost(100).build()
        ));
    }

    private void initializeGameBoard() {
        gameBoard = new ArrayList<>(Arrays.asList(
                "GO",                      // location 0
                mediterraneanAvenue,       // location 1
                "Community Chest",         // location 2
                balticAvenue,              // location 3
                "Income Tax",              // location 4
                readingRailroad,           // location 5
                orientalAvenue,            // location 6
                "Chance",                  // location 7
                vermontAvenue,             // location 8
                connecticutAvenue,         // location 9
                "Just Visiting Jail",      // location 10
                stCharlesPlace,            // location 11
                electricCompany,           // location 12
                statesAvenue,              // location 13
                virginiaAvenue,            // location 14
                pennsylvaniaRailRoad,      // location 15
                stJamesPlace,              // location 16
                "Community Chest",         // location 17
                tennesseeAvenue,           // location 18
                newYorkAvenue,             // location 19
                "Free Parking",            // location 20
                kentuckyAvenue,            // location 21
                "Chance",                  // location 22
                indianaAvenue,             // location 23
                illinoisAvenue,            // location 24
                bandORailRoad,             // location 25
                atlanticAvenue,            // location 26
                ventnorAvenue,             // location 27
                waterWorks,                // location 28
                marvinGardens,             // location 29
                "Go To Jail",              // location 30
                pacificAvenue,             // location 31
                northCarolinaAvenue,       // location 32
                "Community Chest",         // location 33
                pennsylvaniaAvenue,        // location 34
                shortLineRailroad,         // location 35
                "Chance",                  // location 36
                parkPlace,                 // location 37
                "Luxury Tax",              // location 38
                boardWalk,                 // location 39
                "Jail"                     // location 40 not to be used when counting spaces moved
        ));
    }

    private void initializeColorGroup() {
        colorGroup = new ArrayList<>(Arrays.asList(
            new ColorGroup.ColorGroupBuilder().color(PropertyColor.BROWN).propertyList(new ArrayList<>(Arrays.asList(mediterraneanAvenue, balticAvenue))).build()
            // add all the color groups
        ));
    }

    public ArrayList<PropertyAttributes> getPropertyAttributes() {
        return propertyAttributes;
    }

    public void setPropertyAttributes(ArrayList<PropertyAttributes> propertyAttributes) {
        this.propertyAttributes = propertyAttributes;
    }

    public ArrayList<PropertyFinancials> getPropertyFinancialAttributes() {
        return propertyFinancialAttributes;
    }

    public void setPropertyFinancialAttributes(ArrayList<PropertyFinancials> propertyFinancialAttributes) {
        this.propertyFinancialAttributes = propertyFinancialAttributes;
    }

    public String propertyToString(){
        return propertyAttributes.toString();
    }

    public String propertyFinancialToString(){
        return propertyFinancialAttributes.toString();
    }

    public ArrayList<String> getGameBoard() {
        return gameBoard;
    }

    public void setGameBoard(ArrayList<String> gameBoard) {
        this.gameBoard = gameBoard;
    }
}