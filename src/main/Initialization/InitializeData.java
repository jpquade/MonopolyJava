package main.Initialization;

import main.Enums.PlayerToken;
import main.Enums.PropertyColor;
import main.Enums.PropertyType;
import main.Misc.BoardLocation;
import main.Properties.ColorGroup;
import main.Properties.PropertyAttributes;
import main.Properties.PropertyFinancials;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class InitializeData {

    private final String mediterraneanAvenue = "Mediterranean Avenue";
    private final String balticAvenue = "Baltic Avenue";
    private final String orientalAvenue = "Oriental Avenue";
    private final String vermontAvenue = "Vermont Avenue";
    private final String connecticutAvenue = "Connecticut Avenue";
    private final String stCharlesPlace = "St Charles Place";
    private final String statesAvenue = "States Avenue";
    private final String virginiaAvenue = "Virginia Avenue";
    private final String stJamesPlace = "St James Place";
    private final String tennesseeAvenue = "Tennessee Avenue";
    private final String newYorkAvenue = "New York Avenue";
    private final String kentuckyAvenue = "Kentucky Avenue";
    private final String indianaAvenue = "Indiana Avenue";
    private final String illinoisAvenue = "Illinois Avenue";
    private final String atlanticAvenue = "Atlantic Avenue";
    private final String ventnorAvenue = "Ventnor Avenue";
    private final String marvinGardens = "Marvin Gardens";
    private final String pacificAvenue = "Pacific Avenue";
    private final String northCarolinaAvenue = "North Carolina Avenue";
    private final String pennsylvaniaAvenue = "Pennsylvania Avenue";
    private final String parkPlace = "Park Place";
    private final String boardWalk = "Boardwalk";
    private final String electricCompany = "Electric Company";
    private final String waterWorks = "Water Works";
    private final String readingRailroad = "Reading Railroad";
    private final String pennsylvaniaRailRoad = "Pennsylvania RailRoad";
    private final String bandORailRoad = "B&O RailRoad";
    private final String shortLineRailroad = "Short Line Railroad";

    private ArrayList<PropertyAttributes> propertyAttributes;
    private ArrayList<PropertyFinancials> propertyFinancialAttributes;
    private ArrayList<String> gameBoard;
    private ArrayList<ColorGroup> colorGroup;

    private final ArrayList<BoardLocation> location;
    private ArrayList<String> singlePropertyAccess;

    private final LinkedList<String> chanceCards;
    private final LinkedList<String> communityChestCards;

    public InitializeData() {
        initializePropertyAttributes();
        initializePropertyFinancialAttributes();
        initializeColorGroup();
        initializeGameBoard();
        location = new ArrayList<>();
        initializeLocation();
        initializeSinglePropertyAccess();
        chanceCards = new LinkedList<>();
        communityChestCards = new LinkedList<>();
        initializeChanceCards();
        initializeCommunityChestCards();
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

    private void initializeColorGroup() {
        colorGroup = new ArrayList<>(Arrays.asList(
                new ColorGroup.ColorGroupBuilder().color(PropertyColor.BROWN).propertyList(new ArrayList<>(Arrays.asList(mediterraneanAvenue, balticAvenue))).build(),
                new ColorGroup.ColorGroupBuilder().color(PropertyColor.LIGHTBLUE).propertyList(new ArrayList<>(Arrays.asList(orientalAvenue, vermontAvenue, connecticutAvenue))).build(),
                new ColorGroup.ColorGroupBuilder().color(PropertyColor.PINK).propertyList(new ArrayList<>(Arrays.asList(stCharlesPlace, statesAvenue, virginiaAvenue))).build(),
                new ColorGroup.ColorGroupBuilder().color(PropertyColor.ORANGE).propertyList(new ArrayList<>(Arrays.asList(stJamesPlace, tennesseeAvenue, newYorkAvenue))).build(),
                new ColorGroup.ColorGroupBuilder().color(PropertyColor.RED).propertyList(new ArrayList<>(Arrays.asList(kentuckyAvenue, indianaAvenue, illinoisAvenue))).build(),
                new ColorGroup.ColorGroupBuilder().color(PropertyColor.YELLOW).propertyList(new ArrayList<>(Arrays.asList(atlanticAvenue, ventnorAvenue, marvinGardens))).build(),
                new ColorGroup.ColorGroupBuilder().color(PropertyColor.GREEN).propertyList(new ArrayList<>(Arrays.asList(pacificAvenue, northCarolinaAvenue, pennsylvaniaAvenue))).build(),
                new ColorGroup.ColorGroupBuilder().color(PropertyColor.DARKBLUE).propertyList(new ArrayList<>(Arrays.asList(parkPlace, boardWalk))).build(),
                new ColorGroup.ColorGroupBuilder().color(PropertyColor.WHITE).propertyList(new ArrayList<>(Arrays.asList(electricCompany, waterWorks))).build(),
                new ColorGroup.ColorGroupBuilder().color(PropertyColor.BLACK).propertyList(new ArrayList<>(Arrays.asList(readingRailroad, pennsylvaniaRailRoad, bandORailRoad, shortLineRailroad))).build()
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

    private void initializeLocation() {
        int xFirstThree = 0;
        int xSecondThree = 0;
        int xLastTwo = 0;
        int yFirstThree = 0;
        int XAll = 0;
        int YAll = 0;

        // go
        location.add(new BoardLocation(new ArrayList<>(Arrays.asList(985 + xFirstThree, 985 + xFirstThree, 985 + xFirstThree, 950 + xSecondThree, 950 + xSecondThree, 950 + xSecondThree, 1020 + xLastTwo, 1020 + xLastTwo)), // x values
                                       new ArrayList<>(Arrays.asList(855,885,915,855,885,915,845,885)))); // y values
        // mediterranean avenue
        xFirstThree  -= 85;
        xSecondThree -= 80;
        xLastTwo     -= 95;

        location.add(new BoardLocation(new ArrayList<>(Arrays.asList(985 + xFirstThree, 985 + xFirstThree, 985 + xFirstThree, 950 + xSecondThree, 950 + xSecondThree, 950 + xSecondThree, 1020 + xLastTwo, 1020 + xLastTwo)), // x values
                                       new ArrayList<>(Arrays.asList(855,885,915,855,885,915,845,885)))); // y values
        // community chest
        xFirstThree  -= 85;
        xSecondThree -= 85;
        xLastTwo     -= 85;
        location.add(new BoardLocation(new ArrayList<>(Arrays.asList(985 + xFirstThree, 985 + xFirstThree, 985 + xFirstThree, 950 + xSecondThree, 950 + xSecondThree, 950 + xSecondThree, 1020 + xLastTwo, 1020 + xLastTwo)), // x values
                                       new ArrayList<>(Arrays.asList(855,885,915,855,885,915,845,885)))); // y values
        // baltic avenue
        xFirstThree  -= 75;
        xSecondThree -= 75;
        xLastTwo     -= 75;

        location.add(new BoardLocation(new ArrayList<>(Arrays.asList(985 + xFirstThree, 985 + xFirstThree, 985 + xFirstThree, 950 + xSecondThree, 950 + xSecondThree, 950 + xSecondThree, 1020 + xLastTwo, 1020 + xLastTwo)), // x values
                                       new ArrayList<>(Arrays.asList(855,885,915,855,885,915,845,885)))); // y values
        // income tax
        xFirstThree  -= 75;
        xSecondThree -= 75;
        xLastTwo     -= 75;

        location.add(new BoardLocation(new ArrayList<>(Arrays.asList(985 + xFirstThree, 985 + xFirstThree, 985 + xFirstThree, 950 + xSecondThree, 950 + xSecondThree, 950 + xSecondThree, 1020 + xLastTwo, 1020 + xLastTwo)), // x values
                                       new ArrayList<>(Arrays.asList(855,885,915,855,885,915,845,885)))); // y values
        // reading railroad
        xFirstThree  -= 85;
        xSecondThree -= 75;
        xLastTwo     -= 75;
        location.add(new BoardLocation(new ArrayList<>(Arrays.asList(985 + xFirstThree, 985 + xFirstThree, 985 + xFirstThree, 950 + xSecondThree, 950 + xSecondThree, 950 + xSecondThree, 1020 + xLastTwo, 1020 + xLastTwo)), // x values
                                       new ArrayList<>(Arrays.asList(855,885,915,855,885,915,845,885)))); // y values
        // oriental avenue
        xFirstThree  -= 80;
        xSecondThree -= 80;
        xLastTwo     -= 85;
        location.add(new BoardLocation(new ArrayList<>(Arrays.asList(985 + xFirstThree, 985 + xFirstThree, 985 + xFirstThree, 950 + xSecondThree, 950 + xSecondThree, 950 + xSecondThree, 1020 + xLastTwo, 1020 + xLastTwo)), // x values
                                       new ArrayList<>(Arrays.asList(855,885,915,855,885,915,845,885)))); // y values
        // chance
        xFirstThree  -= 80;
        xSecondThree -= 80;
        xLastTwo     -= 85;
        location.add(new BoardLocation(new ArrayList<>(Arrays.asList(985 + xFirstThree, 985 + xFirstThree, 985 + xFirstThree, 950 + xSecondThree, 950 + xSecondThree, 950 + xSecondThree, 1020 + xLastTwo, 1020 + xLastTwo)), // x values
                                       new ArrayList<>(Arrays.asList(855,885,915,855,885,915,845,885)))); // y values
        // vermont avenue
        xFirstThree  -= 80;
        xSecondThree -= 80;
        xLastTwo     -= 80;
        location.add(new BoardLocation(new ArrayList<>(Arrays.asList(985 + xFirstThree, 985 + xFirstThree, 985 + xFirstThree, 950 + xSecondThree, 950 + xSecondThree, 950 + xSecondThree, 1020 + xLastTwo, 1020 + xLastTwo)), // x values
                                       new ArrayList<>(Arrays.asList(855,885,915,855,885,915,845,885)))); // y values
        // connecticut avenue
        xFirstThree  -= 75;
        xSecondThree -= 80;
        xLastTwo     -= 75;
        location.add(new BoardLocation(new ArrayList<>(Arrays.asList(985 + xFirstThree, 985 + xFirstThree, 985 + xFirstThree, 950 + xSecondThree, 950 + xSecondThree, 950 + xSecondThree, 1020 + xLastTwo, 1020 + xLastTwo)), // x values
                                       new ArrayList<>(Arrays.asList(855,885,915,855,885,915,845,885)))); // y values
        // just visiting jail
        xSecondThree -= 120;
        xLastTwo     -= 75;
        yFirstThree  -= 45;
        location.add(new BoardLocation(new ArrayList<>(Arrays.asList(985 + xFirstThree - 145, 985 + xFirstThree - 145, 985 + xFirstThree - 110, 950 + xSecondThree, 950 + xSecondThree, 950 + xSecondThree, 1020 + xLastTwo - 30, 1020 + xLastTwo)), // x values
                                       new ArrayList<>(Arrays.asList(855 + 45,885 + 40,915,855 - 35,885 + yFirstThree,915 + yFirstThree,845 + 65,885 + 20)))); // y values
        // st charles place
        XAll -= 100;
        YAll -= 120;
        location.add(new BoardLocation(new ArrayList<>(Arrays.asList(256 + XAll, 265 + XAll, 265 + XAll, 240 + XAll, 240 + XAll, 240 + XAll, 290 + XAll, 290 + XAll)), // x values
                                       new ArrayList<>(Arrays.asList(855 + YAll + 10,885 + YAll,915 + YAll,855 + YAll + 10,885 + YAll,915 + YAll,845 + YAll + 10,885 + YAll)))); // y values
        // electric company
        YAll -= 75;
        location.add(new BoardLocation(new ArrayList<>(Arrays.asList(256 + XAll, 265 + XAll, 265 + XAll, 240 + XAll, 240 + XAll, 240 + XAll, 290 + XAll, 290 + XAll)), // x values
                new ArrayList<>(Arrays.asList(855 + YAll + 10,885 + YAll,915 + YAll,855 + YAll + 10,885 + YAll,915 + YAll,845 + YAll + 10,885 + YAll)))); // y values
        // states avenue
        YAll -= 85;
        location.add(new BoardLocation(new ArrayList<>(Arrays.asList(256 + XAll, 265 + XAll, 265 + XAll, 240 + XAll, 240 + XAll, 240 + XAll, 290 + XAll, 290 + XAll)), // x values
                new ArrayList<>(Arrays.asList(855 + YAll + 10,885 + YAll,915 + YAll,855 + YAll + 10,885 + YAll,915 + YAll,845 + YAll + 10,885 + YAll)))); // y values
        // virginia avenue
        YAll -= 75;
        location.add(new BoardLocation(new ArrayList<>(Arrays.asList(256 + XAll, 265 + XAll, 265 + XAll, 240 + XAll, 240 + XAll, 240 + XAll, 290 + XAll, 290 + XAll)), // x values
                new ArrayList<>(Arrays.asList(855 + YAll + 10,885 + YAll,915 + YAll,855 + YAll + 10,885 + YAll,915 + YAll,845 + YAll + 10,885 + YAll)))); // y values
        // pennsylvania railroad
        YAll -= 75;
        location.add(new BoardLocation(new ArrayList<>(Arrays.asList(256 + XAll, 265 + XAll, 265 + XAll, 240 + XAll, 240 + XAll, 240 + XAll, 290 + XAll, 290 + XAll)), // x values
                new ArrayList<>(Arrays.asList(855 + YAll + 10,885 + YAll,915 + YAll,855 + YAll + 10,885 + YAll,915 + YAll,845 + YAll + 10,885 + YAll)))); // y values
        // st james avenue
        YAll -= 80;
        location.add(new BoardLocation(new ArrayList<>(Arrays.asList(256 + XAll, 265 + XAll, 265 + XAll, 240 + XAll, 240 + XAll, 240 + XAll, 290 + XAll, 290 + XAll)), // x values
                new ArrayList<>(Arrays.asList(855 + YAll + 10,885 + YAll,915 + YAll,855 + YAll + 10,885 + YAll,915 + YAll,845 + YAll + 10,885 + YAll)))); // y values
        // community chest
        YAll -= 80;
        location.add(new BoardLocation(new ArrayList<>(Arrays.asList(256 + XAll, 265 + XAll, 265 + XAll, 240 + XAll, 240 + XAll, 240 + XAll, 290 + XAll, 290 + XAll)), // x values
                new ArrayList<>(Arrays.asList(855 + YAll + 10,885 + YAll,915 + YAll,855 + YAll + 10,885 + YAll,915 + YAll,845 + YAll + 10,885 + YAll)))); // y values
        // tennessee avenue
        YAll -= 80;
        location.add(new BoardLocation(new ArrayList<>(Arrays.asList(256 + XAll, 265 + XAll, 265 + XAll, 240 + XAll, 240 + XAll, 240 + XAll, 290 + XAll, 290 + XAll)), // x values
                new ArrayList<>(Arrays.asList(855 + YAll + 10,885 + YAll,915 + YAll,855 + YAll + 10,885 + YAll,915 + YAll,845 + YAll + 10,885 + YAll)))); // y values
        // new york avenue
        YAll -= 80;
        location.add(new BoardLocation(new ArrayList<>(Arrays.asList(256 + XAll, 265 + XAll, 265 + XAll, 240 + XAll, 240 + XAll, 240 + XAll, 290 + XAll, 290 + XAll)), // x values
                new ArrayList<>(Arrays.asList(855 + YAll + 10,885 + YAll,915 + YAll,855 + YAll + 10,885 + YAll,915 + YAll,845 + YAll + 10,885 + YAll)))); // y values
        // free parking
        YAll -= 100;
        location.add(new BoardLocation(new ArrayList<>(Arrays.asList(256 + XAll, 265 + XAll, 265 + XAll, 240 + XAll, 240 + XAll, 240 + XAll, 290 + XAll, 290 + XAll)), // x values
                new ArrayList<>(Arrays.asList(855 + YAll + 10,885 + YAll,915 + YAll,855 + YAll + 10,885 + YAll,915 + YAll,845 + YAll + 10,885 + YAll)))); // y values
        // kentucky avenue
        XAll += 100;
        location.add(new BoardLocation(new ArrayList<>(Arrays.asList(256 + XAll, 265 + XAll, 265 + XAll, 240 + XAll, 240 + XAll, 240 + XAll, 290 + XAll, 290 + XAll)), // x values
                new ArrayList<>(Arrays.asList(855 + YAll + 10,885 + YAll,915 + YAll,855 + YAll + 10,885 + YAll,915 + YAll,845 + YAll + 10,885 + YAll)))); // y values
        // chance
        XAll += 80;
        location.add(new BoardLocation(new ArrayList<>(Arrays.asList(256 + XAll, 265 + XAll, 265 + XAll, 240 + XAll, 240 + XAll, 240 + XAll, 290 + XAll, 290 + XAll)), // x values
                new ArrayList<>(Arrays.asList(855 + YAll + 10,885 + YAll,915 + YAll,855 + YAll + 10,885 + YAll,915 + YAll,845 + YAll + 10,885 + YAll)))); // y values
        // indiana avenue
        XAll += 80;
        location.add(new BoardLocation(new ArrayList<>(Arrays.asList(256 + XAll, 265 + XAll, 265 + XAll, 240 + XAll, 240 + XAll, 240 + XAll, 290 + XAll, 290 + XAll)), // x values
                new ArrayList<>(Arrays.asList(855 + YAll + 10,885 + YAll,915 + YAll,855 + YAll + 10,885 + YAll,915 + YAll,845 + YAll + 10,885 + YAll)))); // y values
        // illinois avenue
        XAll += 80;
        location.add(new BoardLocation(new ArrayList<>(Arrays.asList(256 + XAll, 265 + XAll, 265 + XAll, 240 + XAll, 240 + XAll, 240 + XAll, 290 + XAll, 290 + XAll)), // x values
                new ArrayList<>(Arrays.asList(855 + YAll + 10,885 + YAll,915 + YAll,855 + YAll + 10,885 + YAll,915 + YAll,845 + YAll + 10,885 + YAll)))); // y values
        // b&o railroad
        XAll += 80;
        location.add(new BoardLocation(new ArrayList<>(Arrays.asList(256 + XAll, 265 + XAll, 265 + XAll, 240 + XAll, 240 + XAll, 240 + XAll, 290 + XAll, 290 + XAll)), // x values
                new ArrayList<>(Arrays.asList(855 + YAll + 10,885 + YAll,915 + YAll,855 + YAll + 10,885 + YAll,915 + YAll,845 + YAll + 10,885 + YAll)))); // y values
        // atlantic avenue
        XAll += 70;
        location.add(new BoardLocation(new ArrayList<>(Arrays.asList(256 + XAll, 265 + XAll, 265 + XAll, 240 + XAll, 240 + XAll, 240 + XAll, 290 + XAll, 290 + XAll)), // x values
                new ArrayList<>(Arrays.asList(855 + YAll + 10,885 + YAll,915 + YAll,855 + YAll + 10,885 + YAll,915 + YAll,845 + YAll + 10,885 + YAll)))); // y values
        // water works
        XAll += 80;
        location.add(new BoardLocation(new ArrayList<>(Arrays.asList(256 + XAll, 265 + XAll, 265 + XAll, 240 + XAll, 240 + XAll, 240 + XAll, 290 + XAll, 290 + XAll)), // x values
                new ArrayList<>(Arrays.asList(855 + YAll + 10,885 + YAll,915 + YAll,855 + YAll + 10,885 + YAll,915 + YAll,845 + YAll + 10,885 + YAll)))); // y values
        // ventnor avenue
        XAll += 80;
        location.add(new BoardLocation(new ArrayList<>(Arrays.asList(256 + XAll, 265 + XAll, 265 + XAll, 240 + XAll, 240 + XAll, 240 + XAll, 290 + XAll, 290 + XAll)), // x values
                new ArrayList<>(Arrays.asList(855 + YAll + 10,885 + YAll,915 + YAll,855 + YAll + 10,885 + YAll,915 + YAll,845 + YAll + 10,885 + YAll)))); // y values
        // marvin gardens
        XAll += 80;
        location.add(new BoardLocation(new ArrayList<>(Arrays.asList(256 + XAll, 265 + XAll, 265 + XAll, 240 + XAll, 240 + XAll, 240 + XAll, 290 + XAll, 290 + XAll)), // x values
                new ArrayList<>(Arrays.asList(855 + YAll + 10,885 + YAll,915 + YAll,855 + YAll + 10,885 + YAll,915 + YAll,845 + YAll + 10,885 + YAll)))); // y values
        // go to jail
        XAll += 110;
        location.add(new BoardLocation(new ArrayList<>(Arrays.asList(256 + XAll, 265 + XAll, 265 + XAll, 240 + XAll, 240 + XAll, 240 + XAll, 290 + XAll, 290 + XAll)), // x values
                new ArrayList<>(Arrays.asList(855 + YAll + 10,885 + YAll,915 + YAll,855 + YAll + 10,885 + YAll,915 + YAll,845 + YAll + 10,885 + YAll)))); // y values
        // pacific avenue
        YAll += 105;
        location.add(new BoardLocation(new ArrayList<>(Arrays.asList(256 + XAll, 265 + XAll, 265 + XAll, 240 + XAll, 240 + XAll, 240 + XAll, 290 + XAll, 290 + XAll)), // x values
                new ArrayList<>(Arrays.asList(855 + YAll + 10,885 + YAll,915 + YAll,855 + YAll + 10,885 + YAll,915 + YAll,845 + YAll + 10,885 + YAll)))); // y values
        // north carolina avenue
        YAll += 70;
        location.add(new BoardLocation(new ArrayList<>(Arrays.asList(256 + XAll, 265 + XAll, 265 + XAll, 240 + XAll, 240 + XAll, 240 + XAll, 290 + XAll, 290 + XAll)), // x values
                new ArrayList<>(Arrays.asList(855 + YAll + 10,885 + YAll,915 + YAll,855 + YAll + 10,885 + YAll,915 + YAll,845 + YAll + 10,885 + YAll)))); // y values
        // community chest
        YAll += 80;
        location.add(new BoardLocation(new ArrayList<>(Arrays.asList(256 + XAll, 265 + XAll, 265 + XAll, 240 + XAll, 240 + XAll, 240 + XAll, 290 + XAll, 290 + XAll)), // x values
                new ArrayList<>(Arrays.asList(855 + YAll + 10,885 + YAll,915 + YAll,855 + YAll + 10,885 + YAll,915 + YAll,845 + YAll + 10,885 + YAll)))); // y values
        // pennsylvania avenue
        YAll += 80;
        location.add(new BoardLocation(new ArrayList<>(Arrays.asList(256 + XAll, 265 + XAll, 265 + XAll, 240 + XAll, 240 + XAll, 240 + XAll, 290 + XAll, 290 + XAll)), // x values
                new ArrayList<>(Arrays.asList(855 + YAll + 10,885 + YAll,915 + YAll,855 + YAll + 10,885 + YAll,915 + YAll,845 + YAll + 10,885 + YAll)))); // y values
        // short line
        YAll += 80;
        location.add(new BoardLocation(new ArrayList<>(Arrays.asList(256 + XAll, 265 + XAll, 265 + XAll, 240 + XAll, 240 + XAll, 240 + XAll, 290 + XAll, 290 + XAll)), // x values
                new ArrayList<>(Arrays.asList(855 + YAll + 10,885 + YAll,915 + YAll,855 + YAll + 10,885 + YAll,915 + YAll,845 + YAll + 10,885 + YAll)))); // y values
        // chance
        YAll += 80;
        location.add(new BoardLocation(new ArrayList<>(Arrays.asList(256 + XAll, 265 + XAll, 265 + XAll, 240 + XAll, 240 + XAll, 240 + XAll, 290 + XAll, 290 + XAll)), // x values
                new ArrayList<>(Arrays.asList(855 + YAll + 10,885 + YAll,915 + YAll,855 + YAll + 10,885 + YAll,915 + YAll,845 + YAll + 10,885 + YAll)))); // y values
        // park place
        YAll += 75;
        location.add(new BoardLocation(new ArrayList<>(Arrays.asList(256 + XAll, 265 + XAll, 265 + XAll, 240 + XAll, 240 + XAll, 240 + XAll, 290 + XAll, 290 + XAll)), // x values
                new ArrayList<>(Arrays.asList(855 + YAll + 10,885 + YAll,915 + YAll,855 + YAll + 10,885 + YAll,915 + YAll,845 + YAll + 10,885 + YAll)))); // y values
        // luxury tax
        YAll += 75;
        location.add(new BoardLocation(new ArrayList<>(Arrays.asList(256 + XAll, 265 + XAll, 265 + XAll, 240 + XAll, 240 + XAll, 240 + XAll, 290 + XAll, 290 + XAll)), // x values
                new ArrayList<>(Arrays.asList(855 + YAll + 10,885 + YAll,915 + YAll,855 + YAll + 10,885 + YAll,915 + YAll,845 + YAll + 10,885 + YAll)))); // y values
        // board walk
        YAll += 80;
        location.add(new BoardLocation(new ArrayList<>(Arrays.asList(256 + XAll, 265 + XAll, 265 + XAll, 240 + XAll, 240 + XAll, 240 + XAll, 290 + XAll, 290 + XAll)), // x values
                new ArrayList<>(Arrays.asList(855 + YAll + 10,885 + YAll,915 + YAll,855 + YAll + 10,885 + YAll,915 + YAll,845 + YAll + 10,885 + YAll)))); // y values
    }

    public void initializeSinglePropertyAccess(){

        singlePropertyAccess = new ArrayList<>(Arrays.asList(
                mediterraneanAvenue,
                balticAvenue,
                readingRailroad,
                orientalAvenue,
                vermontAvenue,
                connecticutAvenue,
                stCharlesPlace,
                electricCompany,
                statesAvenue,
                virginiaAvenue,
                pennsylvaniaRailRoad,
                stJamesPlace,
                tennesseeAvenue,
                newYorkAvenue,
                kentuckyAvenue,
                indianaAvenue,
                illinoisAvenue,
                bandORailRoad,
                atlanticAvenue,
                waterWorks,
                ventnorAvenue,
                marvinGardens,
                pacificAvenue,
                northCarolinaAvenue,
                pennsylvaniaAvenue,
                shortLineRailroad,
                parkPlace,
                boardWalk
                ));
    }

    public void initializeChanceCards(){
        chanceCards.add("Chance_Advance_To_Boardwalk");
        chanceCards.add("Chance_Advance_To_Go");
        chanceCards.add("Chance_ATIA");
        chanceCards.add("Chance_ATSCP");
        chanceCards.add("Chance_ATTNR");
        chanceCards.add("Chance_ATTNU");
        chanceCards.add("Chance_BPYD");
        chanceCards.add("Chance_GB3S");
        chanceCards.add("Chance_GOOJF");
        chanceCards.add("Chance_GTJ");
        chanceCards.add("Chance_MGR");
        chanceCards.add("Chance_PPT");
        chanceCards.add("Chance_TAROTR");
        chanceCards.add("Chance_YBALM");
        chanceCards.add("Chance_YHBAECOTB");
    }

    private void initializeCommunityChestCards(){
        communityChestCards.add("Community_Chest_Advance_to_Go");
        communityChestCards.add("Community_Chest_BEIYF");
        communityChestCards.add("Community_Chest_DF");
        communityChestCards.add("Community_Chest_FSOS");
        communityChestCards.add("Community_Chest_GOO");
        communityChestCards.add("Community_Chest_GOOJF");
        communityChestCards.add("Community_Chest_GTJ");
        communityChestCards.add("Community_Chest_ITR");
        communityChestCards.add("Community_Chest_LIM");
        communityChestCards.add("Community_Chest_PH");
        communityChestCards.add("Community_Chest_PST");
        communityChestCards.add("Community_Chest_RFS");
        communityChestCards.add("Community_Chest_XFM");
        communityChestCards.add("Community_Chest_YAAFSR");
        communityChestCards.add("Community_Chest_YHWSPIABC");
        communityChestCards.add("Community_Chest_YI");
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

    public ArrayList<ColorGroup> getColorGroup() {
        return colorGroup;
    }

    public void setColorGroup(ArrayList<ColorGroup> colorGroup) {
        this.colorGroup = colorGroup;
    }

    public ArrayList<String> getGameBoard() {
        return gameBoard;
    }

    public void setGameBoard(ArrayList<String> gameBoard) {
        this.gameBoard = gameBoard;
    }

    public ArrayList<String> getSinglePropertyAccess() {
        return singlePropertyAccess;
    }

    public ArrayList<BoardLocation> getLocation() {
        return location;
    }

    public LinkedList<String> getChanceCards(){ return chanceCards;}

    public LinkedList<String> getCommunityChestCards(){ return communityChestCards;}
}