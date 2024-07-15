package Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;

import Initialization.InitializeData;
import Properties.Property;
import Properties.PropertyFinancials;

public class GameData {
    private ArrayList<String> gameBoard;
    private final LinkedHashMap<String, Property> propertyMap;
    private final LinkedHashMap<String, PropertyFinancials> propertyFinancialsMap;
    InitializeData initializeData;

    public GameData(){
        initializeData = new InitializeData();
        gameBoard = new ArrayList<>();
        propertyMap = new LinkedHashMap<>();
        propertyFinancialsMap = new LinkedHashMap<>();
        initGameBoard();
        initPropertyMap();
        initPropertyFinancialMap();
    }

    private void initGameBoard() {gameBoard = initializeData.getGameBoard();}

    private void initPropertyMap() {for (Property property : initializeData.getPropertyAttributes()) propertyMap.put(property.getName(), property);}

    private void initPropertyFinancialMap() {for (PropertyFinancials propertyFinancials : initializeData.getPropertyFinancialAttributes()) propertyFinancialsMap.put(propertyFinancials.getName(), propertyFinancials);}

    public ArrayList<String> getGameBoard() {return gameBoard;}

    public LinkedHashMap<String, Property> getPropertyMap() {return propertyMap;}

    public LinkedHashMap<String, PropertyFinancials> getPropertyFinancialsMap() {
        return propertyFinancialsMap;
    }

}
