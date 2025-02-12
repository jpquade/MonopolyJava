package main.Functions;

import main.Enums.PlayerToken;
import main.Enums.PropertyGroup;
import main.Enums.PropertyNames;
import main.Enums.PropertyType;
import main.Properties.Property;

import java.util.HashMap;

public class PropertyProcessor {

    private final HashMap<PropertyNames, Property> propertyMap;

    public PropertyProcessor() {
        propertyMap = new HashMap<>();
        initializePropertyMap();
    }

    public Property getProperty(PropertyNames propertyNames) {
        return propertyMap.get(propertyNames);
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
}
