package Initialization;

import Enums.Color;
import Enums.Token;
import Enums.PropertyType;
import Properties.Property;
import Properties.PropertyFinancials;

import java.util.ArrayList;
import java.util.Arrays;

public class InitPropertyValues {

    private ArrayList<Property> propertyAttributes;
    private ArrayList<PropertyFinancials> propertyFinancialAttributes;
    public InitPropertyValues() {
        initializePropertyAttributes();
        initializePropertyFinancialAttributes();
    }

    private void initializePropertyAttributes(){

        propertyAttributes = new ArrayList<>(Arrays.asList(
                new Property.PropertyBuilder().propertyType(PropertyType.STANDARD).name("Mediterranean Avenue") .color(Color.BROWN).improvementAllowed(true).owner(Token.NONE).build(),
                new Property.PropertyBuilder().propertyType(PropertyType.STANDARD).name("Baltic Avenue")        .color(Color.BROWN).improvementAllowed(true).owner(Token.NONE).build(),

                new Property.PropertyBuilder().propertyType(PropertyType.STANDARD).name("Oriental Avenue")      .color(Color.LIGHTBLUE).improvementAllowed(true).owner(Token.NONE).build(),
                new Property.PropertyBuilder().propertyType(PropertyType.STANDARD).name("Vermont Avenue")       .color(Color.LIGHTBLUE).improvementAllowed(true).owner(Token.NONE).build(),
                new Property.PropertyBuilder().propertyType(PropertyType.STANDARD).name("Connecticut Avenue")   .color(Color.LIGHTBLUE).improvementAllowed(true).owner(Token.NONE).build(),

                new Property.PropertyBuilder().propertyType(PropertyType.STANDARD).name("St Charles Place")     .color(Color.PINK).improvementAllowed(true).owner(Token.NONE).build(),
                new Property.PropertyBuilder().propertyType(PropertyType.STANDARD).name("States Avenue")        .color(Color.PINK).improvementAllowed(true).owner(Token.NONE).build(),
                new Property.PropertyBuilder().propertyType(PropertyType.STANDARD).name("Virginia Avenue")      .color(Color.PINK).improvementAllowed(true).owner(Token.NONE).build(),

                new Property.PropertyBuilder().propertyType(PropertyType.STANDARD).name("St. James Place")      .color(Color.ORANGE).improvementAllowed(true).owner(Token.NONE).build(),
                new Property.PropertyBuilder().propertyType(PropertyType.STANDARD).name("Tennessee Avenue")     .color(Color.ORANGE).improvementAllowed(true).owner(Token.NONE).build(),
                new Property.PropertyBuilder().propertyType(PropertyType.STANDARD).name("New York Avenue")      .color(Color.ORANGE).improvementAllowed(true).owner(Token.NONE).build(),

                new Property.PropertyBuilder().propertyType(PropertyType.STANDARD).name("Kentucky Avenue")      .color(Color.RED).improvementAllowed(true).owner(Token.NONE).build(),
                new Property.PropertyBuilder().propertyType(PropertyType.STANDARD).name("Indiana Avenue")       .color(Color.RED).improvementAllowed(true).owner(Token.NONE).build(),
                new Property.PropertyBuilder().propertyType(PropertyType.STANDARD).name("Illinois Avenue")      .color(Color.RED).improvementAllowed(true).owner(Token.NONE).build(),

                new Property.PropertyBuilder().propertyType(PropertyType.STANDARD).name("Atlantic Avenue")      .color(Color.YELLOW).improvementAllowed(true).owner(Token.NONE).build(),
                new Property.PropertyBuilder().propertyType(PropertyType.STANDARD).name("Ventnor Avenue")       .color(Color.YELLOW).improvementAllowed(true).owner(Token.NONE).build(),
                new Property.PropertyBuilder().propertyType(PropertyType.STANDARD).name("Marvin Gardens")       .color(Color.YELLOW).improvementAllowed(true).owner(Token.NONE).build(),

                new Property.PropertyBuilder().propertyType(PropertyType.STANDARD).name("Pacific Avenue")       .color(Color.GREEN).improvementAllowed(true).owner(Token.NONE).build(),
                new Property.PropertyBuilder().propertyType(PropertyType.STANDARD).name("North Carolina Avenue").color(Color.GREEN).improvementAllowed(true).owner(Token.NONE).build(),
                new Property.PropertyBuilder().propertyType(PropertyType.STANDARD).name("Pennsylvania Avenue")  .color(Color.GREEN).improvementAllowed(true).owner(Token.NONE).build(),

                new Property.PropertyBuilder().propertyType(PropertyType.STANDARD).name("Park Place")           .color(Color.DARKBLUE).improvementAllowed(true).owner(Token.NONE).build(),
                new Property.PropertyBuilder().propertyType(PropertyType.STANDARD).name("Boardwalk")            .color(Color.DARKBLUE).improvementAllowed(true).owner(Token.NONE).build(),

                new Property.PropertyBuilder().propertyType(PropertyType.UTILITY).name("Electric Company")      .color(Color.WHITE).owner(Token.NONE).build(),
                new Property.PropertyBuilder().propertyType(PropertyType.UTILITY).name("Water Works")           .color(Color.WHITE).owner(Token.NONE).build(),

                new Property.PropertyBuilder().propertyType(PropertyType.RAILROAD).name("Reading Railroad")     .color(Color.BLACK).owner(Token.NONE).build(),
                new Property.PropertyBuilder().propertyType(PropertyType.RAILROAD).name("Pennsylvania RailRoad").color(Color.BLACK).owner(Token.NONE).build(),
                new Property.PropertyBuilder().propertyType(PropertyType.RAILROAD).name("B&O RailRoad")         .color(Color.BLACK).owner(Token.NONE).build(),
                new Property.PropertyBuilder().propertyType(PropertyType.RAILROAD).name("Short Line Railroad")  .color(Color.BLACK).owner(Token.NONE).build()
        ));
    }

    private void initializePropertyFinancialAttributes(){

        propertyFinancialAttributes = new ArrayList<>(Arrays.asList(
                new PropertyFinancials.PropertyFinancialBuilder().name("Mediterranean Avenue")                  .price(60).rent(2).pricePerImprovement(50).rentOneHouse(10).rentTwoHouse(30).rentThreeHouse(90).rentFourHouse(160).rentHotel(250).mortgageCost(30).build(),
                new PropertyFinancials.PropertyFinancialBuilder().name("Baltic Avenue")                         .price(60).rent(4).pricePerImprovement(50).rentOneHouse(20).rentTwoHouse(60).rentThreeHouse(180).rentFourHouse(320).rentHotel(450).mortgageCost(30).build(),

                new PropertyFinancials.PropertyFinancialBuilder().name("Oriental Avenue")                       .price(100).rent(6).pricePerImprovement(50).rentOneHouse(30).rentTwoHouse(90).rentThreeHouse(270).rentFourHouse(400).rentHotel(550).mortgageCost(50).build(),
                new PropertyFinancials.PropertyFinancialBuilder().name("Vermont Avenue")                        .price(100).rent(6).pricePerImprovement(50).rentOneHouse(30).rentTwoHouse(90).rentThreeHouse(270).rentFourHouse(400).rentHotel(550).mortgageCost(50).build(),
                new PropertyFinancials.PropertyFinancialBuilder().name("Connecticut Avenue")                    .price(120).rent(8).pricePerImprovement(50).rentOneHouse(40).rentTwoHouse(100).rentThreeHouse(300).rentFourHouse(450).rentHotel(600).mortgageCost(60).build(),

                new PropertyFinancials.PropertyFinancialBuilder().name("St. Charles Place")                     .price(140).rent(10).pricePerImprovement(100).rentOneHouse(50).rentTwoHouse(150).rentThreeHouse(450).rentFourHouse(625).rentHotel(750).mortgageCost(70).build(),
                new PropertyFinancials.PropertyFinancialBuilder().name("States Avenue")                         .price(140).rent(10).pricePerImprovement(100).rentOneHouse(50).rentTwoHouse(150).rentThreeHouse(450).rentFourHouse(625).rentHotel(750).mortgageCost(70).build(),
                new PropertyFinancials.PropertyFinancialBuilder().name("Virginia Avenue")                       .price(160).rent(12).pricePerImprovement(100).rentOneHouse(60).rentTwoHouse(180).rentThreeHouse(500).rentFourHouse(700).rentHotel(900).mortgageCost(80).build(),

                new PropertyFinancials.PropertyFinancialBuilder().name("St. James Place")                       .price(180).rent(14).pricePerImprovement(100).rentOneHouse(70).rentTwoHouse(200).rentThreeHouse(550).rentFourHouse(750).rentHotel(950).mortgageCost(90).build(),
                new PropertyFinancials.PropertyFinancialBuilder().name("Tennessee Avenue")                      .price(180).rent(14).pricePerImprovement(100).rentOneHouse(70).rentTwoHouse(200).rentThreeHouse(550).rentFourHouse(750).rentHotel(950).mortgageCost(90).build(),
                new PropertyFinancials.PropertyFinancialBuilder().name("New York Avenue")                       .price(200).rent(16).pricePerImprovement(100).rentOneHouse(80).rentTwoHouse(220).rentThreeHouse(600).rentFourHouse(800).rentHotel(1000).mortgageCost(90).build(),

                new PropertyFinancials.PropertyFinancialBuilder().name("Kentucky Avenue")                       .price(220).rent(18).pricePerImprovement(150).rentOneHouse(90).rentTwoHouse(250).rentThreeHouse(700).rentFourHouse(875).rentHotel(1050).mortgageCost(110).build(),
                new PropertyFinancials.PropertyFinancialBuilder().name("Indiana Avenue")                        .price(220).rent(18).pricePerImprovement(150).rentOneHouse(90).rentTwoHouse(250).rentThreeHouse(700).rentFourHouse(875).rentHotel(1050).mortgageCost(110).build(),
                new PropertyFinancials.PropertyFinancialBuilder().name("Illinois Avenue")                       .price(240).rent(20).pricePerImprovement(150).rentOneHouse(100).rentTwoHouse(300).rentThreeHouse(750).rentFourHouse(925).rentHotel(1100).mortgageCost(120).build(),

                new PropertyFinancials.PropertyFinancialBuilder().name("Atlantic Avenue")                       .price(260).rent(22).pricePerImprovement(150).rentOneHouse(110).rentTwoHouse(330).rentThreeHouse(800).rentFourHouse(975).rentHotel(1150).mortgageCost(130).build(),
                new PropertyFinancials.PropertyFinancialBuilder().name("Ventnor Avenue")                        .price(260).rent(22).pricePerImprovement(150).rentOneHouse(110).rentTwoHouse(330).rentThreeHouse(800).rentFourHouse(975).rentHotel(1150).mortgageCost(130).build(),
                new PropertyFinancials.PropertyFinancialBuilder().name("Marvin Gardens")                        .price(280).rent(24).pricePerImprovement(150).rentOneHouse(120).rentTwoHouse(360).rentThreeHouse(850).rentFourHouse(975).rentHotel(1200).mortgageCost(140).build(),

                new PropertyFinancials.PropertyFinancialBuilder().name("Pacific Avenue")                        .price(300).rent(26).pricePerImprovement(200).rentOneHouse(130).rentTwoHouse(390).rentThreeHouse(900).rentFourHouse(1100).rentHotel(1275).mortgageCost(150).build(),
                new PropertyFinancials.PropertyFinancialBuilder().name("North Carolina Avenue")                 .price(300).rent(26).pricePerImprovement(200).rentOneHouse(130).rentTwoHouse(390).rentThreeHouse(900).rentFourHouse(1100).rentHotel(1275).mortgageCost(150).build(),
                new PropertyFinancials.PropertyFinancialBuilder().name("Pennsylvania Avenue")                   .price(320).rent(28).pricePerImprovement(200).rentOneHouse(150).rentTwoHouse(450).rentThreeHouse(1000).rentFourHouse(1200).rentHotel(1400).mortgageCost(160).build(),

                new PropertyFinancials.PropertyFinancialBuilder().name("Park Place")                            .price(350).rent(35).pricePerImprovement(200).rentOneHouse(175).rentTwoHouse(500).rentThreeHouse(1100).rentFourHouse(1300).rentHotel(1500).mortgageCost(175).build(),
                new PropertyFinancials.PropertyFinancialBuilder().name("Boardwalk")                             .price(400).rent(50).pricePerImprovement(200).rentOneHouse(200).rentTwoHouse(600).rentThreeHouse(1400).rentFourHouse(1700).rentHotel(2000).mortgageCost(200).build(),

                new PropertyFinancials.PropertyFinancialBuilder().name("Electric Company")                      .price(150).mortgageCost(75).build(),
                new PropertyFinancials.PropertyFinancialBuilder().name("Water Works")                           .price(150).mortgageCost(75).build(),

                new PropertyFinancials.PropertyFinancialBuilder().name("Reading Railroad")                      .price(200).mortgageCost(100).build(),
                new PropertyFinancials.PropertyFinancialBuilder().name("Pennsylvania RailRoad")                 .price(200).mortgageCost(100).build(),
                new PropertyFinancials.PropertyFinancialBuilder().name("B&O RailRoad")                          .price(200).mortgageCost(100).build(),
                new PropertyFinancials.PropertyFinancialBuilder().name("Short Line Railroad")                   .price(200).mortgageCost(100).build()
        ));
    }

    public ArrayList<Property> getPropertyAttributes() {
        return propertyAttributes;
    }

    public void setPropertyAttributes(ArrayList<Property> propertyAttributes) {
        this.propertyAttributes = propertyAttributes;
    }

    public ArrayList<PropertyFinancials> getPropertyFinancialAttributes() {
        return propertyFinancialAttributes;
    }

    public void setPropertyFinancialAttributes(ArrayList<PropertyFinancials> propertyFinancialAttributes) {
        this.propertyFinancialAttributes = propertyFinancialAttributes;
    }

    @Override
    public String toString() {
        return "Initialization.InitValues{" +
                "propertyAttributes=" + propertyAttributes +
                ", propertyFinancialAttributes=" + propertyFinancialAttributes +
                '}';
    }

    public String propertyToString(){
        return propertyAttributes.toString();
    }

    public String propertyFinancialToString(){
        return propertyFinancialAttributes.toString();
    }
}