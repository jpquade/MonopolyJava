package main.Functions;

import main.Enums.*;
import main.GUI.*;
import main.Properties.Property;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;

public class PropertyProcessor {

    private final HashMap<PropertyNames, String> propertyNamesStringMap;
    private final HashMap<PropertyNames, Property> propertyMap;
    private final HashMap<PropertyTile, PropertyNames> tileOrderConvertToPropertyNames;
    private final HashMap<PropertyNames, PropertyTile> propertyNamesConvertToTileOrder;
    private final PlayerProcessor playerProcessor;
    private boolean mortgageFlag;

    private PropertyTile currentPropertyToMortgage;

    //TODO - create BoardPropertyTileOrder to PropertyNames map converter

    public PropertyProcessor(PlayerProcessor playerProcessor) {
        mortgageFlag = false;
        propertyMap = new HashMap<>();
        propertyNamesStringMap = new HashMap<>();
        tileOrderConvertToPropertyNames = new HashMap<>();
        propertyNamesConvertToTileOrder = new HashMap<>();
        initializePropertyNameStringMap();
        initializePropertyMap();
        initializeTileOrderConvertToPropertyNames();
        initializePropertyNamesConvertToTileOrder();

        this.playerProcessor = playerProcessor;
    }

    public HashMap<PropertyNames, Property> getPropertyMap() {
        return propertyMap;
    }

    public Property getProperty(PropertyNames propertyNames) {
        return propertyMap.get(propertyNames);
    }

    public Property getProperty(PropertyTile propertyTile) {
        return propertyMap.get(tileOrderConvertToPropertyNames.get(propertyTile));
    }

    public String convertPropertyNameToString(PropertyNames propertyNames) {
        return propertyNamesStringMap.get(propertyNames);
    }

    public PropertyNames convertBoardPropertyTileOrderToPropertyNames(PropertyTile propertyTile){
        return tileOrderConvertToPropertyNames.get(propertyTile);
    }

    public PropertyTile convertNameToTile(PropertyNames propertyNames){
        return propertyNamesConvertToTileOrder.get(propertyNames);
    }

    public Property convertColorGroupToProperty(PropertyGroup propertyGroup){
        for(Property property : propertyMap.values()){
            if(property.getColor() == propertyGroup){
                return property;
            }
        }
        return null;
    }

    private void findOwnedProperties(ArrayList<Property> ownedProperties) {
        PlayerToken playerToken = playerProcessor.getActivePlayer().getToken();

        //ArrayList<Property> ownedProperties = new ArrayList<>();
        for (Property property : propertyMap.values()) {
            if (property.getOwner() == playerToken) {
                ownedProperties.add(property);
            }
        }
    }

    public ArrayList<Property> findActivePlayerPropertiesWithoutImprovements(){
        ArrayList<Property> ownedProperties = new ArrayList<>();

        PlayerToken playerToken = playerProcessor.getActivePlayer().getToken();
        for(Property property : propertyMap.values()){
            PropertyGroup color = property.getColor();

            if(property.getOwner() == playerToken && !colorGroupImprovementChecker(color)){
                ownedProperties.add(property);
            }
        }

        return ownedProperties;
    }

    public boolean colorGroupImprovementChecker(PropertyGroup propertyGroup){

        // checks if a colorgroup has improvements
        switch(propertyGroup){
            case PropertyGroup.BROWN:
                for(PropertyGroup.BROWN_GROUP brown : PropertyGroup.BROWN_GROUP.values()){
                    Property property = propertyMap.get(convertBrownColorToPropertyName(brown));
                    if(property.hotelExists() || property.getHouseCount() > 0){
                        return true;
                    }
                }
                break;
            case PropertyGroup.LIGHTBLUE:
                for(PropertyGroup.LIGHT_BLUE_GROUP lightBlue : PropertyGroup.LIGHT_BLUE_GROUP.values()){
                    Property property = propertyMap.get(convertLightBlueColorToPropertyName(lightBlue));
                    if(property.hotelExists() || property.getHouseCount() > 0){
                        return true;
                    }
                }
                break;
            case PropertyGroup.PINK:
                for(PropertyGroup.PINK_GROUP pink : PropertyGroup.PINK_GROUP.values()){
                    Property property = propertyMap.get(convertPinkColorToPropertyName(pink));
                    if(property.hotelExists() || property.getHouseCount() > 0){
                        return true;
                    }
                }
                break;
            case PropertyGroup.ORANGE:
                for(PropertyGroup.ORANGE_GROUP orange : PropertyGroup.ORANGE_GROUP.values()){
                    Property property = propertyMap.get(convertOrangeColorToPropertyName(orange));
                    if(property.hotelExists() || property.getHouseCount() > 0){
                        return true;
                    }
                }
                break;
            case PropertyGroup.RED:
                for(PropertyGroup.RED_GROUP red : PropertyGroup.RED_GROUP.values()){
                    Property property = propertyMap.get(convertRedColorToPropertyName(red));
                    if(property.hotelExists() || property.getHouseCount() > 0){
                        return true;
                    }
                }
                break;
                case PropertyGroup.YELLOW:
                for(PropertyGroup.YELLOW_GROUP yellow : PropertyGroup.YELLOW_GROUP.values()){
                    Property property = propertyMap.get(convertYellowColorToPropertyName(yellow));
                    if(property.hotelExists() || property.getHouseCount() > 0){
                        return true;
                    }
                }
                break;
            case PropertyGroup.GREEN:
                for(PropertyGroup.GREEN_GROUP green : PropertyGroup.GREEN_GROUP.values()){
                    Property property = propertyMap.get(convertGreenColorToPropertyName(green));
                    if(property.hotelExists() || property.getHouseCount() > 0){
                        return true;
                    }
                }
                break;
            case PropertyGroup.DARKBLUE:
                for(PropertyGroup.DARK_BLUE_GROUP darkBlue : PropertyGroup.DARK_BLUE_GROUP.values()){
                    Property property = propertyMap.get(convertDarkBlueColorToPropertyName(darkBlue));
                    if(property.hotelExists() || property.getHouseCount() > 0){
                        return true;
                    }
                }
                break;
            case PropertyGroup.UTILITY, PropertyGroup.RAILROAD:
                return false;
        }
        return false;
    }



    public PropertyNames convertBrownColorToPropertyName(PropertyGroup.BROWN_GROUP propertyGroup){

        return switch (propertyGroup) {
            case PropertyGroup.BROWN_GROUP.MEDITERRANEAN_AVENUE -> PropertyNames.MEDITERRANEAN_AVENUE;
            case PropertyGroup.BROWN_GROUP.BALTIC_AVENUE -> PropertyNames.BALTIC_AVENUE;
        };

    }

    public PropertyNames convertLightBlueColorToPropertyName(PropertyGroup.LIGHT_BLUE_GROUP propertyGroup){

        return switch (propertyGroup) {
            case PropertyGroup.LIGHT_BLUE_GROUP.ORIENTAL_AVENUE  -> PropertyNames.ORIENTAL_AVENUE;
            case PropertyGroup.LIGHT_BLUE_GROUP.VERMONT_AVENUE -> PropertyNames.VERMONT_AVENUE;
            case PropertyGroup.LIGHT_BLUE_GROUP.CONNECTICUT_AVENUE -> PropertyNames.CONNECTICUT_AVENUE;
        };
    }

    public PropertyNames convertPinkColorToPropertyName(PropertyGroup.PINK_GROUP propertyGroup){

        return switch (propertyGroup) {
            case PropertyGroup.PINK_GROUP.ST_CHARLES_PLACE -> PropertyNames.ST_CHARLES_PLACE;
            case PropertyGroup.PINK_GROUP.STATES_AVENUE -> PropertyNames.STATES_AVENUE;
            case PropertyGroup.PINK_GROUP.VIRGINIA_AVENUE -> PropertyNames.VIRGINIA_AVENUE;
        };
    }

    public PropertyNames convertOrangeColorToPropertyName(PropertyGroup.ORANGE_GROUP propertyGroup){

        return switch (propertyGroup) {
            case PropertyGroup.ORANGE_GROUP.ST_JAMES_PLACE -> PropertyNames.ST_JAMES_PLACE;
            case PropertyGroup.ORANGE_GROUP.TENNESSEE_AVENUE -> PropertyNames.TENNESSEE_AVENUE;
            case PropertyGroup.ORANGE_GROUP.NEW_YORK_AVENUE -> PropertyNames.NEW_YORK_AVENUE;
        };
    }

    public PropertyNames convertRedColorToPropertyName(PropertyGroup.RED_GROUP propertyGroup){

        return switch (propertyGroup) {
            case PropertyGroup.RED_GROUP.KENTUCKY_AVENUE -> PropertyNames.KENTUCKY_AVENUE;
            case PropertyGroup.RED_GROUP.INDIANA_AVENUE -> PropertyNames.INDIANA_AVENUE;
            case PropertyGroup.RED_GROUP.ILLINOIS_AVENUE -> PropertyNames.ILLINOIS_AVENUE;
        };
    }

    public PropertyNames convertYellowColorToPropertyName(PropertyGroup.YELLOW_GROUP propertyGroup){

        return switch (propertyGroup) {
            case PropertyGroup.YELLOW_GROUP.ATLANTIC_AVENUE -> PropertyNames.ATLANTIC_AVENUE;
            case PropertyGroup.YELLOW_GROUP.VENTNOR_AVENUE -> PropertyNames.VENTNOR_AVENUE;
            case PropertyGroup.YELLOW_GROUP.MARVIN_GARDENS -> PropertyNames.MARVIN_GARDENS;
        };
    }

    public PropertyNames convertGreenColorToPropertyName(PropertyGroup.GREEN_GROUP propertyGroup){

        return switch (propertyGroup) {
            case PropertyGroup.GREEN_GROUP.PACIFIC_AVENUE -> PropertyNames.PACIFIC_AVENUE;
            case PropertyGroup.GREEN_GROUP.NORTH_CAROLINA_AVENUE -> PropertyNames.NORTH_CAROLINA_AVENUE;
            case PropertyGroup.GREEN_GROUP.PENNSYLVANIA_AVENUE -> PropertyNames.PENNSYLVANIA_AVENUE;
        };
    }

    public PropertyNames convertDarkBlueColorToPropertyName(PropertyGroup.DARK_BLUE_GROUP propertyGroup){

        return switch (propertyGroup) {
            case PropertyGroup.DARK_BLUE_GROUP.PARK_PLACE -> PropertyNames.PARK_PLACE;
            case PropertyGroup.DARK_BLUE_GROUP.BOARDWALK -> PropertyNames.BOARDWALK;
        };
    }

    public PropertyNames convertUtilityColorToPropertyName(PropertyGroup.UTILITY_GROUP propertyGroup){

        return switch (propertyGroup) {
            case PropertyGroup.UTILITY_GROUP.ELECTRIC_COMPANY -> PropertyNames.ELECTRIC_COMPANY;
            case PropertyGroup.UTILITY_GROUP.WATER_WORKS -> PropertyNames.WATER_WORKS;
        };
    }

    public PropertyNames convertRailroadColorToPropertyName(PropertyGroup.RAILROAD_GROUP propertyGroup){

        return switch (propertyGroup) {
            case PropertyGroup.RAILROAD_GROUP.READING_RAILROAD -> PropertyNames.READING_RAILROAD;
            case PropertyGroup.RAILROAD_GROUP.PENNSYLVANIA_RAILROAD -> PropertyNames.PENNSYLVANIA_RAILROAD;
            case PropertyGroup.RAILROAD_GROUP.B_AND_O_RAILROAD -> PropertyNames.B_AND_O_RAILROAD;
            case PropertyGroup.RAILROAD_GROUP.SHORT_LINE_RAILROAD -> PropertyNames.SHORT_LINE_RAILROAD;
        };
    }




    public void setPropertyOwnership(PlayerToken playerToken, PropertyNames propertyName){
        propertyMap.get(propertyName).setOwner(playerToken);
    }

    // finds properties that are owned by the player and don't have improvements
//    public ArrayList<Property> findSellableProperties(){
//        //ArrayList<Property> ownedProperties = new ArrayList<>();
//
//
//        //findOwnedProperties(ownedProperties);
//        //ownedProperties.removeIf(property -> property.getHouseCount() > 0 || property.hotelExists());
//        return findOwnedPropertiesWithoutImprovements();
//        //return ownedProperties;
//    }

    private void initializePropertyNameStringMap() {

        propertyNamesStringMap.put(PropertyNames.MEDITERRANEAN_AVENUE, "Mediterranean Avenue");
        propertyNamesStringMap.put(PropertyNames.BALTIC_AVENUE, "Baltic Avenue");
        propertyNamesStringMap.put(PropertyNames.ORIENTAL_AVENUE, "Oriental Avenue");
        propertyNamesStringMap.put(PropertyNames.VERMONT_AVENUE, "Vermont Avenue");
        propertyNamesStringMap.put(PropertyNames.CONNECTICUT_AVENUE, "Connecticut Avenue");
        propertyNamesStringMap.put(PropertyNames.ST_CHARLES_PLACE, "St Charles Place");
        propertyNamesStringMap.put(PropertyNames.STATES_AVENUE, "States Avenue");
        propertyNamesStringMap.put(PropertyNames.VIRGINIA_AVENUE, "Virginia Avenue");
        propertyNamesStringMap.put(PropertyNames.ST_JAMES_PLACE, "St James Place");
        propertyNamesStringMap.put(PropertyNames.TENNESSEE_AVENUE, "Tennessee Avenue");
        propertyNamesStringMap.put(PropertyNames.NEW_YORK_AVENUE, "New York Avenue");
        propertyNamesStringMap.put(PropertyNames.KENTUCKY_AVENUE, "Kentucky Avenue");
        propertyNamesStringMap.put(PropertyNames.INDIANA_AVENUE, "Indiana Avenue");
        propertyNamesStringMap.put(PropertyNames.ILLINOIS_AVENUE, "Illinois Avenue");
        propertyNamesStringMap.put(PropertyNames.ATLANTIC_AVENUE, "Atlantic Avenue");
        propertyNamesStringMap.put(PropertyNames.VENTNOR_AVENUE, "Ventnor Avenue");
        propertyNamesStringMap.put(PropertyNames.MARVIN_GARDENS, "Marvin Gardens");
        propertyNamesStringMap.put(PropertyNames.PACIFIC_AVENUE, "Pacific Avenue");
        propertyNamesStringMap.put(PropertyNames.NORTH_CAROLINA_AVENUE, "North Carolina Avenue");
        propertyNamesStringMap.put(PropertyNames.PENNSYLVANIA_AVENUE, "Pennsylvania Avenue");
        propertyNamesStringMap.put(PropertyNames.PARK_PLACE, "Park Place");
        propertyNamesStringMap.put(PropertyNames.BOARDWALK, "Boardwalk");

        propertyNamesStringMap.put(PropertyNames.ELECTRIC_COMPANY, "Electric Company");
        propertyNamesStringMap.put(PropertyNames.WATER_WORKS, "Water Works");

        propertyNamesStringMap.put(PropertyNames.READING_RAILROAD, "Reading Railroad");
        propertyNamesStringMap.put(PropertyNames.PENNSYLVANIA_RAILROAD, "Pennsylvania RailRoad");
        propertyNamesStringMap.put(PropertyNames.B_AND_O_RAILROAD, "B&O RailRoad");
        propertyNamesStringMap.put(PropertyNames.SHORT_LINE_RAILROAD, "Short Line Railroad");
    }

    private void initializePropertyMap() {
        // Brown Properties
        propertyMap.put(PropertyNames.MEDITERRANEAN_AVENUE, new Property.PropertyBuilder()
                .propertyName(PropertyNames.MEDITERRANEAN_AVENUE).propertyType(PropertyType.STANDARD).color(PropertyGroup.BROWN).improvementAllowed(true).playerTokenOwner(PlayerToken.NONE)
                .price(60).rent(2).pricePerImprovement(50).rentOneHouse(10).rentTwoHouse(30).rentThreeHouse(90).rentFourHouse(160).rentHotel(250).mortgageAmount(30).build());
        propertyMap.put(PropertyNames.BALTIC_AVENUE, new Property.PropertyBuilder()
                .propertyName(PropertyNames.BALTIC_AVENUE).propertyType(PropertyType.STANDARD).color(PropertyGroup.BROWN).improvementAllowed(true).playerTokenOwner(PlayerToken.NONE)
                .price(50).rent(4).pricePerImprovement(50).rentOneHouse(20).rentTwoHouse(60).rentThreeHouse(180).rentFourHouse(320).rentHotel(450).mortgageAmount(30).build());

        // Light Blue Properties
        propertyMap.put(PropertyNames.ORIENTAL_AVENUE, new Property.PropertyBuilder()
                .propertyName(PropertyNames.ORIENTAL_AVENUE).propertyType(PropertyType.STANDARD).color(PropertyGroup.LIGHTBLUE).improvementAllowed(true).playerTokenOwner(PlayerToken.NONE)
                .price(100).rent(6).pricePerImprovement(50).rentOneHouse(30).rentTwoHouse(90).rentThreeHouse(270).rentFourHouse(400).rentHotel(550).mortgageAmount(50).build());
        propertyMap.put(PropertyNames.VERMONT_AVENUE, new Property.PropertyBuilder()
                .propertyName(PropertyNames.VERMONT_AVENUE).propertyType(PropertyType.STANDARD).color(PropertyGroup.LIGHTBLUE).improvementAllowed(true).playerTokenOwner(PlayerToken.NONE)
                .price(100).rent(6).pricePerImprovement(50).rentOneHouse(30).rentTwoHouse(90).rentThreeHouse(270).rentFourHouse(400).rentHotel(550).mortgageAmount(50).build());
        propertyMap.put(PropertyNames.CONNECTICUT_AVENUE, new Property.PropertyBuilder()
                .propertyName(PropertyNames.CONNECTICUT_AVENUE).propertyType(PropertyType.STANDARD).color(PropertyGroup.LIGHTBLUE).improvementAllowed(true).playerTokenOwner(PlayerToken.NONE)
                .price(120).rent(8).pricePerImprovement(50).rentOneHouse(40).rentTwoHouse(100).rentThreeHouse(300).rentFourHouse(450).rentHotel(600).mortgageAmount(60).build());

        // Pink Properties
        propertyMap.put(PropertyNames.ST_CHARLES_PLACE, new Property.PropertyBuilder()
                .propertyName(PropertyNames.ST_CHARLES_PLACE).propertyType(PropertyType.STANDARD).color(PropertyGroup.PINK).improvementAllowed(true).playerTokenOwner(PlayerToken.NONE)
                .price(140).rent(10).pricePerImprovement(100).rentOneHouse(50).rentTwoHouse(150).rentThreeHouse(450).rentFourHouse(625).rentHotel(750).mortgageAmount(70).build());
        propertyMap.put(PropertyNames.STATES_AVENUE, new Property.PropertyBuilder()
                .propertyName(PropertyNames.STATES_AVENUE).propertyType(PropertyType.STANDARD).color(PropertyGroup.PINK).improvementAllowed(true).playerTokenOwner(PlayerToken.NONE)
                .price(140).rent(10).pricePerImprovement(100).rentOneHouse(50).rentTwoHouse(150).rentThreeHouse(450).rentFourHouse(625).rentHotel(750).mortgageAmount(70).build());
        propertyMap.put(PropertyNames.VIRGINIA_AVENUE, new Property.PropertyBuilder()
                .propertyName(PropertyNames.VIRGINIA_AVENUE).propertyType(PropertyType.STANDARD).color(PropertyGroup.PINK).improvementAllowed(true).playerTokenOwner(PlayerToken.NONE)
                .price(160).rent(12).pricePerImprovement(100).rentOneHouse(60).rentTwoHouse(180).rentThreeHouse(500).rentFourHouse(700).rentHotel(900).mortgageAmount(80).build());

        // Orange Properties
        propertyMap.put(PropertyNames.ST_JAMES_PLACE, new Property.PropertyBuilder()
                .propertyName(PropertyNames.ST_JAMES_PLACE).propertyType(PropertyType.STANDARD).color(PropertyGroup.ORANGE).improvementAllowed(true).playerTokenOwner(PlayerToken.NONE)
                .price(180).rent(14).pricePerImprovement(100).rentOneHouse(70).rentTwoHouse(200).rentThreeHouse(550).rentFourHouse(750).rentHotel(950).mortgageAmount(90).build());
        propertyMap.put(PropertyNames.TENNESSEE_AVENUE, new Property.PropertyBuilder()
                .propertyName(PropertyNames.TENNESSEE_AVENUE).propertyType(PropertyType.STANDARD).color(PropertyGroup.ORANGE).improvementAllowed(true).playerTokenOwner(PlayerToken.NONE)
                .price(180).rent(14).pricePerImprovement(100).rentOneHouse(70).rentTwoHouse(200).rentThreeHouse(550).rentFourHouse(750).rentHotel(950).mortgageAmount(90).build());
        propertyMap.put(PropertyNames.NEW_YORK_AVENUE, new Property.PropertyBuilder()
                .propertyName(PropertyNames.NEW_YORK_AVENUE).propertyType(PropertyType.STANDARD).color(PropertyGroup.ORANGE).improvementAllowed(true).playerTokenOwner(PlayerToken.NONE)
                .price(200).rent(16).pricePerImprovement(100).rentOneHouse(80).rentTwoHouse(220).rentThreeHouse(600).rentFourHouse(800).rentHotel(1000).mortgageAmount(100).build());

        // Red Properties
        propertyMap.put(PropertyNames.KENTUCKY_AVENUE, new Property.PropertyBuilder()
                .propertyName(PropertyNames.KENTUCKY_AVENUE).propertyType(PropertyType.STANDARD).color(PropertyGroup.RED).improvementAllowed(true).playerTokenOwner(PlayerToken.NONE)
                .price(220).rent(18).pricePerImprovement(150).rentOneHouse(90).rentTwoHouse(250).rentThreeHouse(700).rentFourHouse(875).rentHotel(1050).mortgageAmount(110).build());
        propertyMap.put(PropertyNames.INDIANA_AVENUE, new Property.PropertyBuilder()
                .propertyName(PropertyNames.INDIANA_AVENUE).propertyType(PropertyType.STANDARD).color(PropertyGroup.RED).improvementAllowed(true).playerTokenOwner(PlayerToken.NONE)
                .price(220).rent(18).pricePerImprovement(150).rentOneHouse(90).rentTwoHouse(250).rentThreeHouse(700).rentFourHouse(875).rentHotel(1050).mortgageAmount(110).build());
        propertyMap.put(PropertyNames.ILLINOIS_AVENUE, new Property.PropertyBuilder()
                .propertyName(PropertyNames.ILLINOIS_AVENUE).propertyType(PropertyType.STANDARD).color(PropertyGroup.RED).improvementAllowed(true).playerTokenOwner(PlayerToken.NONE)
                .price(240).rent(20).pricePerImprovement(150).rentOneHouse(100).rentTwoHouse(300).rentThreeHouse(750).rentFourHouse(925).rentHotel(1100).mortgageAmount(120).build());

        // Yellow Properties
        propertyMap.put(PropertyNames.ATLANTIC_AVENUE, new Property.PropertyBuilder()
                .propertyName(PropertyNames.ATLANTIC_AVENUE).propertyType(PropertyType.STANDARD).color(PropertyGroup.YELLOW).improvementAllowed(true).playerTokenOwner(PlayerToken.NONE)
                .price(260).rent(22).pricePerImprovement(150).rentOneHouse(110).rentTwoHouse(330).rentThreeHouse(800).rentFourHouse(975).rentHotel(1175).mortgageAmount(130).build());
        propertyMap.put(PropertyNames.VENTNOR_AVENUE, new Property.PropertyBuilder()
                .propertyName(PropertyNames.VENTNOR_AVENUE).propertyType(PropertyType.STANDARD).color(PropertyGroup.YELLOW).improvementAllowed(true).playerTokenOwner(PlayerToken.NONE)
                .price(260).rent(22).pricePerImprovement(150).rentOneHouse(110).rentTwoHouse(330).rentThreeHouse(800).rentFourHouse(975).rentHotel(1175).mortgageAmount(130).build());
        propertyMap.put(PropertyNames.MARVIN_GARDENS, new Property.PropertyBuilder()
                .propertyName(PropertyNames.MARVIN_GARDENS).propertyType(PropertyType.STANDARD).color(PropertyGroup.YELLOW).improvementAllowed(true).playerTokenOwner(PlayerToken.NONE)
                .price(280).rent(24).pricePerImprovement(150).rentOneHouse(120).rentTwoHouse(360).rentThreeHouse(850).rentFourHouse(1025).rentHotel(1200).mortgageAmount(140).build());

        // Green Properties
        propertyMap.put(PropertyNames.PACIFIC_AVENUE, new Property.PropertyBuilder()
                .propertyName(PropertyNames.PACIFIC_AVENUE).propertyType(PropertyType.STANDARD).color(PropertyGroup.GREEN).improvementAllowed(true).playerTokenOwner(PlayerToken.NONE)
                .price(300).rent(26).pricePerImprovement(200).rentOneHouse(130).rentTwoHouse(390).rentThreeHouse(900).rentFourHouse(1100).rentHotel(1275).mortgageAmount(150).build());
        propertyMap.put(PropertyNames.NORTH_CAROLINA_AVENUE, new Property.PropertyBuilder()
                .propertyName(PropertyNames.NORTH_CAROLINA_AVENUE).propertyType(PropertyType.STANDARD).color(PropertyGroup.GREEN).improvementAllowed(true).playerTokenOwner(PlayerToken.NONE)
                .price(300).rent(26).pricePerImprovement(200).rentOneHouse(130).rentTwoHouse(390).rentThreeHouse(900).rentFourHouse(1100).rentHotel(1275).mortgageAmount(150).build());
        propertyMap.put(PropertyNames.PENNSYLVANIA_AVENUE, new Property.PropertyBuilder()
                .propertyName(PropertyNames.PENNSYLVANIA_AVENUE).propertyType(PropertyType.STANDARD).color(PropertyGroup.GREEN).improvementAllowed(true).playerTokenOwner(PlayerToken.NONE)
                .price(320).rent(28).pricePerImprovement(200).rentOneHouse(150).rentTwoHouse(450).rentThreeHouse(1000).rentFourHouse(1200).rentHotel(1400).mortgageAmount(160).build());

        // Dark Blue Properties
        propertyMap.put(PropertyNames.PARK_PLACE, new Property.PropertyBuilder()
                .propertyName(PropertyNames.PARK_PLACE).propertyType(PropertyType.STANDARD).color(PropertyGroup.DARKBLUE).improvementAllowed(true).playerTokenOwner(PlayerToken.NONE)
                .price(350).rent(35).pricePerImprovement(200).rentOneHouse(175).rentTwoHouse(500).rentThreeHouse(1100).rentFourHouse(1300).rentHotel(1500).mortgageAmount(175).build());
        propertyMap.put(PropertyNames.BOARDWALK, new Property.PropertyBuilder()
                .propertyName(PropertyNames.BOARDWALK).propertyType(PropertyType.STANDARD).color(PropertyGroup.DARKBLUE).improvementAllowed(true).playerTokenOwner(PlayerToken.NONE)
                .price(400).rent(50).pricePerImprovement(200).rentOneHouse(200).rentTwoHouse(600).rentThreeHouse(1400).rentFourHouse(1700).rentHotel(2000).mortgageAmount(200).build());

        // Utilities
        propertyMap.put(PropertyNames.ELECTRIC_COMPANY, new Property.PropertyBuilder()
                .propertyName(PropertyNames.ELECTRIC_COMPANY).propertyType(PropertyType.UTILITY).color(PropertyGroup.UTILITY).improvementAllowed(false).playerTokenOwner(PlayerToken.NONE)
                .price(150).mortgageAmount(75).build());
        propertyMap.put(PropertyNames.WATER_WORKS, new Property.PropertyBuilder()
                .propertyName(PropertyNames.WATER_WORKS).propertyType(PropertyType.UTILITY).color(PropertyGroup.UTILITY).improvementAllowed(false).playerTokenOwner(PlayerToken.NONE)
                .price(150).mortgageAmount(75).build());

        // Railroads
        propertyMap.put(PropertyNames.READING_RAILROAD, new Property.PropertyBuilder()
                .propertyName(PropertyNames.READING_RAILROAD).propertyType(PropertyType.RAILROAD).color(PropertyGroup.UTILITY).improvementAllowed(false).playerTokenOwner(PlayerToken.NONE)
                .price(200).mortgageAmount(100).build());
        propertyMap.put(PropertyNames.PENNSYLVANIA_RAILROAD, new Property.PropertyBuilder()
                .propertyName(PropertyNames.PENNSYLVANIA_RAILROAD).propertyType(PropertyType.RAILROAD).color(PropertyGroup.UTILITY).improvementAllowed(false).playerTokenOwner(PlayerToken.NONE)
                .price(200).mortgageAmount(100).build());
        propertyMap.put(PropertyNames.B_AND_O_RAILROAD, new Property.PropertyBuilder()
                .propertyName(PropertyNames.B_AND_O_RAILROAD).propertyType(PropertyType.RAILROAD).color(PropertyGroup.UTILITY).improvementAllowed(false).playerTokenOwner(PlayerToken.NONE)
                .price(200).mortgageAmount(100).build());
        propertyMap.put(PropertyNames.SHORT_LINE_RAILROAD, new Property.PropertyBuilder()
                .propertyName(PropertyNames.SHORT_LINE_RAILROAD).propertyType(PropertyType.RAILROAD).color(PropertyGroup.UTILITY).improvementAllowed(false).playerTokenOwner(PlayerToken.NONE)
                .price(200).mortgageAmount(100).build());

    }

    private void initializeTileOrderConvertToPropertyNames(){
        tileOrderConvertToPropertyNames.put(PropertyTile.MEDITERRANEAN_AVENUE, PropertyNames.MEDITERRANEAN_AVENUE);
        tileOrderConvertToPropertyNames.put(PropertyTile.BALTIC_AVENUE, PropertyNames.BALTIC_AVENUE);
        tileOrderConvertToPropertyNames.put(PropertyTile.ORIENTAL_AVENUE, PropertyNames.ORIENTAL_AVENUE);
        tileOrderConvertToPropertyNames.put(PropertyTile.VERMONT_AVENUE, PropertyNames.VERMONT_AVENUE);
        tileOrderConvertToPropertyNames.put(PropertyTile.CONNECTICUT_AVENUE, PropertyNames.CONNECTICUT_AVENUE);
        tileOrderConvertToPropertyNames.put(PropertyTile.ST_CHARLES_PLACE, PropertyNames.ST_CHARLES_PLACE);
        tileOrderConvertToPropertyNames.put(PropertyTile.STATES_AVENUE, PropertyNames.STATES_AVENUE);
        tileOrderConvertToPropertyNames.put(PropertyTile.VIRGINIA_AVENUE, PropertyNames.VIRGINIA_AVENUE);
        tileOrderConvertToPropertyNames.put(PropertyTile.ST_JAMES_PLACE, PropertyNames.ST_JAMES_PLACE);
        tileOrderConvertToPropertyNames.put(PropertyTile.TENNESSEE_AVENUE, PropertyNames.TENNESSEE_AVENUE);
        tileOrderConvertToPropertyNames.put(PropertyTile.NEW_YORK_AVENUE, PropertyNames.NEW_YORK_AVENUE);
        tileOrderConvertToPropertyNames.put(PropertyTile.KENTUCKY_AVENUE, PropertyNames.KENTUCKY_AVENUE);
        tileOrderConvertToPropertyNames.put(PropertyTile.INDIANA_AVENUE, PropertyNames.INDIANA_AVENUE);
        tileOrderConvertToPropertyNames.put(PropertyTile.ILLINOIS_AVENUE, PropertyNames.ILLINOIS_AVENUE);
        tileOrderConvertToPropertyNames.put(PropertyTile.ATLANTIC_AVENUE, PropertyNames.ATLANTIC_AVENUE);
        tileOrderConvertToPropertyNames.put(PropertyTile.VENTNOR_AVENUE, PropertyNames.VENTNOR_AVENUE);
        tileOrderConvertToPropertyNames.put(PropertyTile.MARVIN_GARDENS, PropertyNames.MARVIN_GARDENS);
        tileOrderConvertToPropertyNames.put(PropertyTile.PACIFIC_AVENUE, PropertyNames.PACIFIC_AVENUE);
        tileOrderConvertToPropertyNames.put(PropertyTile.NORTH_CAROLINA_AVENUE, PropertyNames.NORTH_CAROLINA_AVENUE);
        tileOrderConvertToPropertyNames.put(PropertyTile.PENNSYLVANIA_AVENUE, PropertyNames.PENNSYLVANIA_AVENUE);
        tileOrderConvertToPropertyNames.put(PropertyTile.PARK_PLACE, PropertyNames.PARK_PLACE);
        tileOrderConvertToPropertyNames.put(PropertyTile.BOARDWALK, PropertyNames.BOARDWALK);
        tileOrderConvertToPropertyNames.put(PropertyTile.ELECTRIC_COMPANY, PropertyNames.ELECTRIC_COMPANY);
        tileOrderConvertToPropertyNames.put(PropertyTile.WATER_WORKS, PropertyNames.WATER_WORKS);
        tileOrderConvertToPropertyNames.put(PropertyTile.READING_RAILROAD, PropertyNames.READING_RAILROAD);
        tileOrderConvertToPropertyNames.put(PropertyTile.PENNSYLVANIA_RAILROAD, PropertyNames.PENNSYLVANIA_RAILROAD);
        tileOrderConvertToPropertyNames.put(PropertyTile.B_AND_O_RAILROAD, PropertyNames.B_AND_O_RAILROAD);
        tileOrderConvertToPropertyNames.put(PropertyTile.SHORT_LINE_RAILROAD, PropertyNames.SHORT_LINE_RAILROAD);

    }

    private void initializePropertyNamesConvertToTileOrder() {
        propertyNamesConvertToTileOrder.put(PropertyNames.MEDITERRANEAN_AVENUE, PropertyTile.MEDITERRANEAN_AVENUE);
        propertyNamesConvertToTileOrder.put(PropertyNames.BALTIC_AVENUE, PropertyTile.BALTIC_AVENUE);
        propertyNamesConvertToTileOrder.put(PropertyNames.ORIENTAL_AVENUE, PropertyTile.ORIENTAL_AVENUE);
        propertyNamesConvertToTileOrder.put(PropertyNames.VERMONT_AVENUE, PropertyTile.VERMONT_AVENUE);
        propertyNamesConvertToTileOrder.put(PropertyNames.CONNECTICUT_AVENUE, PropertyTile.CONNECTICUT_AVENUE);
        propertyNamesConvertToTileOrder.put(PropertyNames.ST_CHARLES_PLACE, PropertyTile.ST_CHARLES_PLACE);
        propertyNamesConvertToTileOrder.put(PropertyNames.STATES_AVENUE, PropertyTile.STATES_AVENUE);
        propertyNamesConvertToTileOrder.put(PropertyNames.VIRGINIA_AVENUE, PropertyTile.VIRGINIA_AVENUE);
        propertyNamesConvertToTileOrder.put(PropertyNames.ST_JAMES_PLACE, PropertyTile.ST_JAMES_PLACE);
        propertyNamesConvertToTileOrder.put(PropertyNames.TENNESSEE_AVENUE, PropertyTile.TENNESSEE_AVENUE);
        propertyNamesConvertToTileOrder.put(PropertyNames.NEW_YORK_AVENUE, PropertyTile.NEW_YORK_AVENUE);
        propertyNamesConvertToTileOrder.put(PropertyNames.KENTUCKY_AVENUE, PropertyTile.KENTUCKY_AVENUE);
        propertyNamesConvertToTileOrder.put(PropertyNames.INDIANA_AVENUE, PropertyTile.INDIANA_AVENUE);
        propertyNamesConvertToTileOrder.put(PropertyNames.ILLINOIS_AVENUE, PropertyTile.ILLINOIS_AVENUE);
        propertyNamesConvertToTileOrder.put(PropertyNames.ATLANTIC_AVENUE, PropertyTile.ATLANTIC_AVENUE);
        propertyNamesConvertToTileOrder.put(PropertyNames.VENTNOR_AVENUE, PropertyTile.VENTNOR_AVENUE);
        propertyNamesConvertToTileOrder.put(PropertyNames.MARVIN_GARDENS, PropertyTile.MARVIN_GARDENS);
        propertyNamesConvertToTileOrder.put(PropertyNames.PACIFIC_AVENUE, PropertyTile.PACIFIC_AVENUE);
        propertyNamesConvertToTileOrder.put(PropertyNames.NORTH_CAROLINA_AVENUE, PropertyTile.NORTH_CAROLINA_AVENUE);
        propertyNamesConvertToTileOrder.put(PropertyNames.PENNSYLVANIA_AVENUE, PropertyTile.PENNSYLVANIA_AVENUE);
        propertyNamesConvertToTileOrder.put(PropertyNames.PARK_PLACE, PropertyTile.PARK_PLACE);
        propertyNamesConvertToTileOrder.put(PropertyNames.BOARDWALK, PropertyTile.BOARDWALK);
        propertyNamesConvertToTileOrder.put(PropertyNames.ELECTRIC_COMPANY, PropertyTile.ELECTRIC_COMPANY);
        propertyNamesConvertToTileOrder.put(PropertyNames.WATER_WORKS, PropertyTile.WATER_WORKS);
        propertyNamesConvertToTileOrder.put(PropertyNames.READING_RAILROAD, PropertyTile.READING_RAILROAD);
        propertyNamesConvertToTileOrder.put(PropertyNames.PENNSYLVANIA_RAILROAD, PropertyTile.PENNSYLVANIA_RAILROAD);
        propertyNamesConvertToTileOrder.put(PropertyNames.B_AND_O_RAILROAD, PropertyTile.B_AND_O_RAILROAD);
        propertyNamesConvertToTileOrder.put(PropertyNames.SHORT_LINE_RAILROAD, PropertyTile.SHORT_LINE_RAILROAD);
    }

    public void transferProperty(PropertyTile currentPropertyToSell, PlayerToken selectedPlayer) {
        PropertyNames propertyName = tileOrderConvertToPropertyNames.get(currentPropertyToSell);
        Property property = propertyMap.get(propertyName);

        property.setOwner(selectedPlayer);
    }

    public boolean checkPlayerHasProperties(PlayerToken playerToken, PropertyProcessor propertyProcessor){
        for(Property property : propertyProcessor.getPropertyMap().values()){
            if(property.getOwner() == playerToken){
                return true;
            }
        }

        return false;
    }

    public boolean checkPlayerIfAllPropertiesMortgages(PlayerToken playerToken, PropertyProcessor propertyProcessor){
        for(Property property : propertyProcessor.getPropertyMap().values()){
            if(property.getOwner() == playerToken && !property.isMortgaged()){
                return false;
            }
        }

        return true;
    }

    public ArrayList<Property> findMortagedProperties(PlayerToken playerToken){
        ArrayList<Property> mortgagedProperties = new ArrayList<>();
        for(Property property : getPropertyMap().values()){
            if(property.getOwner() == playerToken && property.isMortgaged()){
                mortgagedProperties.add(property);
            }
        }

        return mortgagedProperties;
    }

    public ArrayList<Property> findValidPropertiesToMortgage(PlayerToken playerToken){
        ArrayList<Property> mortgagedProperties = new ArrayList<>();
        for(Property property : getPropertyMap().values()){
            if(property.getOwner() == playerToken && !property.isMortgaged() && property.getHouseCount() == 0 && !property.hotelExists()){
                mortgagedProperties.add(property);
            }
        }

        return mortgagedProperties;
    }

    public boolean checkPlayerIfAllPropertiesHaveHouses(PlayerToken playerToken, PropertyProcessor propertyProcessor){
        for(Property property : propertyProcessor.getPropertyMap().values()){
            if(property.getOwner() == playerToken && property.getHouseCount() == 0){
                return false;
            }
        }

        return true;
    }

    public boolean checkPlayerIfAllPropertiesHaveHotels(PlayerToken playerToken, PropertyProcessor propertyProcessor){
        for(Property property : propertyProcessor.getPropertyMap().values()){
            if(property.getOwner() == playerToken && !property.hotelExists()){
                return false;
            }
        }

        return true;
    }

    public boolean checkPlayerIfAllPropertiesHaveHousesOrHotels(PlayerToken playerToken, PropertyProcessor propertyProcessor){
        if (checkPlayerIfAllPropertiesHaveHouses(playerToken, propertyProcessor)) {
            return checkPlayerIfAllPropertiesHaveHotels(playerToken, propertyProcessor);
        }

        return false;
    }

    public void mortgageProperty(PropertyNames propertyNames){
        propertyMap.get(propertyNames).setMortgaged(true);
    }
    public void mortgageProperty(PropertyTile propertyTile){
        PropertyNames propertyNames = tileOrderConvertToPropertyNames.get(propertyTile);
        propertyMap.get(propertyNames).setMortgaged(true);
    }

    public void setMortgageFlag(){
        mortgageFlag = true;
    }
    public void clearMortgageFlag(){
        mortgageFlag = false;
    }

    // adds a mouse listener to each property tile button to enable selling
    public void checkIfMortgagedPropertySetup(PaymentBoxGUI paymentBoxGUI, PropertyProcessorGUI propertyProcessorGUI,
                                              PlayerProcessor playerProcessor, TransactionHistoryGUI transactionHistoryGUI,
                                              MoneyProcessor moneyProcessor, CommandBoxGUI commandBoxGUI, SellPropertyBoxGUI sellPropertyBoxGUI,
                                              PropertyProcessor propertyProcessor, MortgagePropertyBoxGUI mortgagePropertyBoxGUI) {
        // loop applies a mouse listener to each property tile button when clicked
        for(PropertyTile propertyTile : PropertyTile.values()){
            JButton tile = propertyProcessorGUI.getTileButtonMap().get(propertyTile);
            tile.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e){
                if(propertyProcessorGUI.getMortgageMap().get(propertyTile)) {;
                    setCurrentPropertyToMortgage(propertyTile);
                    mortgagePropertyBoxGUI.mortgagePropertyMenu(propertyProcessorGUI, moneyProcessor, playerProcessor, paymentBoxGUI);
                    //sellPropertyBoxGUI.sellingPropertyMenu(paymentBoxGUI, propertyProcessorGUI, playerProcessor, transactionHistoryGUI, moneyProcessor, propertyProcessor);
                    commandBoxGUI.setMessage("Select a property to mortgage");
                }
                }
            });
        }
    }

    public void setCurrentPropertyToMortgage(PropertyTile propertyTile){
        currentPropertyToMortgage = propertyTile;
    }

    public PropertyTile getCurrentPropertyToMortgage(){
        return currentPropertyToMortgage;
    }
    public int getMortgageValue(PropertyTile propertyTile){
        PropertyNames propertyName = tileOrderConvertToPropertyNames.get(propertyTile);
        return propertyMap.get(propertyName).getMortgageAmount();
    }
}
