package Data;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Scanner;

import Enums.Color;
import Enums.PropertyType;
import Enums.Token;
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

    private void initTempMap() throws FileNotFoundException {
        Scanner tempScan = new Scanner(new File("propertyInputs.txt"));

        for(int i = 0; i < 28; i++){
            String propertyType = tempScan.next();
            String color = tempScan.next();
            String owner = tempScan.next();
            String propertyName = tempScan.nextLine().trim();
        }

        System.out.println();

        //new Property.PropertyBuilder().propertyType(PropertyType.STANDARD).name("Mediterranean Avenue") .color(Color.BROWN).improvementAllowed(true).owner(Token.NONE).build(),
    }
}
