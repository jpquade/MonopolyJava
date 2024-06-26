package Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import Initialization.InitPropertyValues;
import Properties.Property;
import Properties.PropertyFinancials;

public class GameData {
    private ArrayList<String> gameBoard;
    private HashMap<String, Property> propertyMap;
    private HashMap<String, PropertyFinancials> propertyFinancialsMap;
    InitPropertyValues initPropertyValues;

    public GameData(){
        initializeGameBoard();
        propertyMap = new HashMap<>();
        propertyFinancialsMap = new HashMap<>();
        initPropertyValues = new InitPropertyValues();
        initPropertyMap();
    }

    private void initializeGameBoard() {
        gameBoard = new ArrayList<>(Arrays.asList(
                "GO",
                "Mediterranean Avenue",
                "Community Chest",
                "Baltic Avenue",
                "Income Tax",
                "Reading RailRoad",
                "Oriental Avenue",
                "Chance",
                "Vermont Avenue",
                "Connecticut Avenue",
                "Jail",
                "St. Charles Place",
                "Electric Company",
                "States Avenue",
                "Virginia Avenue",
                "Pennsylvania RailRoad",
                "St. James Place",
                "Community Chest",
                "Tennessee Avenue",
                "New York Avenue",
                "Free Parking",
                "Kentucky Avenue",
                "Chance",
                "Indiana Avenue",
                "Illinois Avenue",
                "B&O RailRoad",
                "Atlantic Avenue",
                "Ventnor Avenue",
                "Water Works",
                "Marvin Gardens",
                "Go To Jail",
                "Pacific Avenue",
                "North Carolina Avenue",
                "Community Chest",
                "Pennsylvania Avenue",
                "Short Line Railroad",
                "Chance",
                "Park Place",
                "Luxury Tax",
                "Boardwalk"
        ));
    }

    public ArrayList<String> getGameBoard() {return gameBoard;}

    public void setGameBoard(ArrayList<String> gameBoard) {this.gameBoard = gameBoard;}

    private void initPropertyMap() {for (Property property : initPropertyValues.getPropertyAttributes()) propertyMap.put(property.getName(), property);}

    private void initPropertyFinancialMap() {for (PropertyFinancials propertyFinancials : initPropertyValues.getPropertyFinancialAttributes()) propertyFinancialsMap.put(propertyFinancials.getName(), propertyFinancials);}

    public HashMap<String, Property> getPropertyMap() {
        return propertyMap;
    }

    public void setPropertyMap(HashMap<String, Property> propertyMap) {
        this.propertyMap = propertyMap;
    }

    public HashMap<String, PropertyFinancials> getPropertyFinancialsMap() {
        return propertyFinancialsMap;
    }

    public void setPropertyFinancialsMap(HashMap<String, PropertyFinancials> propertyFinancialsMap) {
        this.propertyFinancialsMap = propertyFinancialsMap;
    }

    @Override
    public String toString() {
        return STR."PropertyData{propertyMap=\{propertyMap}, propertyFinancialsMap=\{propertyFinancialsMap}\{'}'}";
    }
}
