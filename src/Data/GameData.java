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

    public GameData() throws FileNotFoundException {
        initializeData = new InitializeData();
        gameBoard = new ArrayList<>();
        propertyMap = new LinkedHashMap<>();
        propertyFinancialsMap = new LinkedHashMap<>();
        initGameBoard();
        //initPropertyMap(); // disabled while debugging
        initPropertyFinancialMap();
        initTempMap();
    }

    private void initGameBoard() {gameBoard = initializeData.getGameBoard();}

    private void initPropertyMap() {for (Property property : initializeData.getPropertyAttributes()) propertyMap.put(property.getName(), property);}

    private void initPropertyFinancialMap() {for (PropertyFinancials propertyFinancials : initializeData.getPropertyFinancialAttributes()) propertyFinancialsMap.put(propertyFinancials.getName(), propertyFinancials);}

    public ArrayList<String> getGameBoard() {return gameBoard;}

    public LinkedHashMap<String, Property> getPropertyMap() {return propertyMap;}

    public LinkedHashMap<String, PropertyFinancials> getPropertyFinancialsMap() {
        return propertyFinancialsMap;
    }

    // enabled while debugging
    private void initTempMap() throws FileNotFoundException {
        Scanner tempScan = new Scanner(new File("propertyInputs.txt"));

        for(int i = 0; i < 28; i++){
            String propertyType = tempScan.next();
            String color = tempScan.next();
            String canMortgage = tempScan.next();
            String owner = tempScan.next();
            boolean hasHotel = false;
            int houseCount = 0;

            if(i < 2) owner = "CAT";
            if(i == 10){
                owner = "CAT";
                hasHotel = true;
            }
            if(i == 17) owner = "CAT";
            if(i == 18) owner = "CAT";
            if(i == 19) owner = "CAT";

            if(i == 26) owner = "CAT";
            if(1 < i && i < 4) owner = "DOG";
            if(i == 0) houseCount = 4;
            if(i == 1) houseCount = 4;
            if(i == 2) houseCount = 4;




            String propertyName = tempScan.nextLine().trim();

            System.out.println(STR."Property Type: \{propertyType} Color: \{color} Can Mortgage: \{canMortgage} Owner: \{owner} Property Name: \{propertyName}");
            propertyMap.put(propertyName,
                    new Property.PropertyBuilder().propertyType(PropertyType.valueOf(propertyType)).name(propertyName) .color(Color.valueOf(color)).improvementAllowed(true).owner(Token.valueOf(owner)).house(houseCount).hotel(hasHotel).build());

        }
    }
}
