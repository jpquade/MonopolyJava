package main.Data;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import main.Enums.PlayerToken;
import main.Enums.PropertyGroup;
import main.Enums.PropertyType;
import main.Initialization.InitializeData;
import main.Functions.TokenBoardLocation;
import main.Functions.PropertyMerchant;
import main.Properties.PropertyGroupProcessor;
import main.Properties.PropertyAttributes;
import main.Properties.PropertyFinancials;

public class GameData {
    InitializeData initializeData;
    private ArrayList<String> gameBoard;
    private final LinkedHashMap<String, PropertyAttributes> propertyAttributesMap;
    private final LinkedHashMap<String, PropertyFinancials> propertyFinancialsMap;
    private final LinkedHashMap<PropertyGroup, PropertyGroupProcessor> colorGroupMap;

    private final ArrayList<TokenBoardLocation> location;
    private final HashMap<Integer, String> singlePropertyBoardDataMap;

    private final LinkedList<String> chanceCards;
    private final LinkedList<String> communityChestCards;

    public GameData() throws FileNotFoundException {
        initializeData = new InitializeData();
        gameBoard = new ArrayList<>();
        propertyAttributesMap = new LinkedHashMap<>();
        propertyFinancialsMap = new LinkedHashMap<>();
        colorGroupMap = new LinkedHashMap<>();
        location = initializeData.getLocation();
        singlePropertyBoardDataMap = new HashMap<>();
        chanceCards = initializeData.getChanceCards();
        communityChestCards = initializeData.getCommunityChestCards();
        initGameBoard();
        initAttributePropertyMap(); // disabled while debugging
        initPropertyFinancialMap();
        initColorGroup();
        initSinglePropertyBoardData();
        //initTempMap();            // enabled for debugging
    }

    private void initGameBoard() {gameBoard = initializeData.getGameBoard();}

    private void initAttributePropertyMap() {for (PropertyAttributes propertyAttributes : initializeData.getPropertyAttributes()) propertyAttributesMap.put(propertyAttributes.getName(), propertyAttributes);}

    private void initPropertyFinancialMap() {for (PropertyFinancials propertyFinancials : initializeData.getPropertyFinancialAttributes()) propertyFinancialsMap.put(propertyFinancials.getName(), propertyFinancials);}

    private void initColorGroup() {for (PropertyGroupProcessor propertyGroupProcessor : initializeData.getColorGroup()) colorGroupMap.put(propertyGroupProcessor.getColor(), propertyGroupProcessor);}

    private void initSinglePropertyBoardData() {
        for (int i = 0; i < initializeData.getSinglePropertyAccess().size(); i++) {
            String SinglePropertyData = initializeData.getSinglePropertyAccess().get(i);
            singlePropertyBoardDataMap.put(i, SinglePropertyData);
        }

    }

    public ArrayList<String> getGameBoard() {return gameBoard;}

    public LinkedHashMap<String, PropertyAttributes> getPropertyAttributesMap() {return propertyAttributesMap;}

    public LinkedHashMap<String, PropertyFinancials> getPropertyFinancialsMap() {
        return propertyFinancialsMap;
    }

    public LinkedHashMap<PropertyGroup, PropertyGroupProcessor> getColorGroupMap() { return colorGroupMap;}

    public ArrayList<TokenBoardLocation> getLocation() {
        return location;
    }

    public HashMap<Integer, String> getSinglePropertyBoardData() { return singlePropertyBoardDataMap;}

    public LinkedList<String> getChanceCards() { return chanceCards; }

    public LinkedList<String> getCommunityChestCards() { return communityChestCards; }

    // enabled while debugging
    private void initTempMap() throws FileNotFoundException {
        Scanner tempScan = new Scanner(new File("propertyInputs.txt"));
        PropertyMerchant merchant = new PropertyMerchant();

        for(int i = 0; i < 28; i++){
            String propertyType = tempScan.next();
            String color = tempScan.next();
            String improvement = tempScan.next();
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

            //System.out.println(STR."Property Type: \{propertyType} Color: \{color} Can Mortgage: \{canMortgage} Owner: \{owner} Property Name: \{propertyName}");
            propertyAttributesMap.put(propertyName,
                    new PropertyAttributes.PropertyBuilder().propertyType(PropertyType.valueOf(propertyType)).name(propertyName)
                            .color(PropertyGroup.valueOf(color)).improvementAllowed(true).owner(PlayerToken.valueOf(owner))
                            .house(houseCount).hotel(hasHotel).build());

        }
    }
}
