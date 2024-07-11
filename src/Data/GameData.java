package Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;

import Initialization.InitPropertyValues;
import Properties.Property;
import Properties.PropertyFinancials;

public class GameData {
    private ArrayList<String> gameBoard;
    private LinkedHashMap<String, Property> propertyMap;
    private LinkedHashMap<String, PropertyFinancials> propertyFinancialsMap;
    InitPropertyValues initPropertyValues;

    public GameData(){
        initializeGameBoard();
        propertyMap = new LinkedHashMap<>();
        propertyFinancialsMap = new LinkedHashMap<>();
        initPropertyValues = new InitPropertyValues();
        initPropertyMap();
    }

    private void initializeGameBoard() {
        gameBoard = new ArrayList<>(Arrays.asList(
                "GO",                         // location 0
                "Mediterranean Avenue",       // location 1
                "Community Chest",            // location 2
                "Baltic Avenue",              // location 3
                "Income Tax",                 // location 4
                "Reading RailRoad",           // location 5
                "Oriental Avenue",            // location 6
                "Chance",                     // location 7
                "Vermont Avenue",             // location 8
                "Connecticut Avenue",         // location 9
                "Just Visiting Jail",         // location 10
                "St. Charles Place",          // location 11
                "Electric Company",           // location 12
                "States Avenue",              // location 13
                "Virginia Avenue",            // location 14
                "Pennsylvania RailRoad",      // location 15
                "St. James Place",            // location 16
                "Community Chest",            // location 17
                "Tennessee Avenue",           // location 18
                "New York Avenue",            // location 19
                "Free Parking",               // location 20
                "Kentucky Avenue",            // location 21
                "Chance",                     // location 22
                "Indiana Avenue",             // location 23
                "Illinois Avenue",            // location 24
                "B&O RailRoad",               // location 25
                "Atlantic Avenue",            // location 26
                "Ventnor Avenue",             // location 27
                "Water Works",                // location 28
                "Marvin Gardens",             // location 29
                "Go To Jail",                 // location 30
                "Pacific Avenue",             // location 31
                "North Carolina Avenue",      // location 32
                "Community Chest",            // location 33
                "Pennsylvania Avenue",        // location 34
                "Short Line Railroad",        // location 35
                "Chance",                     // location 36
                "Park Place",                 // location 37
                "Luxury Tax",                 // location 38
                "Boardwalk"                   // location 39
        ));
    }

    public ArrayList<String> getGameBoard() {return gameBoard;}

    public void setGameBoard(ArrayList<String> gameBoard) {this.gameBoard = gameBoard;}

    private void initPropertyMap() {for (Property property : initPropertyValues.getPropertyAttributes()) propertyMap.put(property.getName(), property);}

    private void initPropertyFinancialMap() {for (PropertyFinancials propertyFinancials : initPropertyValues.getPropertyFinancialAttributes()) propertyFinancialsMap.put(propertyFinancials.getName(), propertyFinancials);}

    public LinkedHashMap<String, Property> getPropertyMap() {
        return propertyMap;
    }

    public void setPropertyMap(LinkedHashMap<String, Property> propertyMap) {
        this.propertyMap = propertyMap;
    }

    public LinkedHashMap<String, PropertyFinancials> getPropertyFinancialsMap() {
        return propertyFinancialsMap;
    }

    public void setPropertyFinancialsMap(LinkedHashMap<String, PropertyFinancials> propertyFinancialsMap) {
        this.propertyFinancialsMap = propertyFinancialsMap;
    }

    @Override
    public String toString() {
        return STR."PropertyData{propertyMap=\{propertyMap}, propertyFinancialsMap=\{propertyFinancialsMap}\{'}'}";
    }
}
