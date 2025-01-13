package main.LocationFunctions;

import main.Enums.BoardSpaceElement;
import main.Functions.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;

public class LocationProcessor {

//    ArrayList<TokenBoardLocation> location = new ArrayList<>();
    LinkedHashMap<BoardSpaceElement, TokenBoardLocation> locationLinkedHashMap = new LinkedHashMap<>();

    public LocationProcessor(){
        initializeLocation();
    }

    // move GUI related elements to Token GUI

    // position on GUI board is determined by the x and y values in the BoardLocation object
    private void initializeLocation() {
        int xFirstThree = 0;
        int xSecondThree = 0;
        int xLastTwo = 0;
        int yFirstThree = 0;
        int XAll = 0;
        int YAll = 0;

        // go
//        location.add(new TokenBoardLocation(new ArrayList<>(Arrays.asList(985 + xFirstThree, 985 + xFirstThree, 985 + xFirstThree, 950 + xSecondThree, 950 + xSecondThree, 950 + xSecondThree, 1020 + xLastTwo, 1020 + xLastTwo)), // x values
//                new ArrayList<>(Arrays.asList(855,885,915,855,885,915,845,885)))); // y values
        locationLinkedHashMap.put(BoardSpaceElement.GO, new TokenBoardLocation(new ArrayList<>(Arrays.asList(985 + xFirstThree, 985 + xFirstThree, 985 + xFirstThree, 950 + xSecondThree, 950 + xSecondThree, 950 + xSecondThree, 1020 + xLastTwo, 1020 + xLastTwo)), // x values
                new ArrayList<>(Arrays.asList(855,885,915,855,885,915,845,885)))); // y values
        // mediterranean avenue
        xFirstThree  -= 85;
        xSecondThree -= 80;
        xLastTwo     -= 95;

//        location.add(new TokenBoardLocation(new ArrayList<>(Arrays.asList(985 + xFirstThree, 985 + xFirstThree, 985 + xFirstThree, 950 + xSecondThree, 950 + xSecondThree, 950 + xSecondThree, 1020 + xLastTwo, 1020 + xLastTwo)), // x values
//                new ArrayList<>(Arrays.asList(855,885,915,855,885,915,845,885)))); // y values
        locationLinkedHashMap.put(BoardSpaceElement.MEDITERRANEAN_AVENUE, new TokenBoardLocation(new ArrayList<>(Arrays.asList(985 + xFirstThree, 985 + xFirstThree, 985 + xFirstThree, 950 + xSecondThree, 950 + xSecondThree, 950 + xSecondThree, 1020 + xLastTwo, 1020 + xLastTwo)), // x values
                new ArrayList<>(Arrays.asList(855,885,915,855,885,915,845,885)))); // y values
        // community chest
        xFirstThree  -= 85;
        xSecondThree -= 85;
        xLastTwo     -= 85;
//        location.add(new TokenBoardLocation(new ArrayList<>(Arrays.asList(985 + xFirstThree, 985 + xFirstThree, 985 + xFirstThree, 950 + xSecondThree, 950 + xSecondThree, 950 + xSecondThree, 1020 + xLastTwo, 1020 + xLastTwo)), // x values
//                new ArrayList<>(Arrays.asList(855,885,915,855,885,915,845,885)))); // y values
        locationLinkedHashMap.put(BoardSpaceElement.COMMUNITY_CHEST, new TokenBoardLocation(new ArrayList<>(Arrays.asList(985 + xFirstThree, 985 + xFirstThree, 985 + xFirstThree, 950 + xSecondThree, 950 + xSecondThree, 950 + xSecondThree, 1020 + xLastTwo, 1020 + xLastTwo)), // x values
                new ArrayList<>(Arrays.asList(855,885,915,855,885,915,845,885)))); // y values
        // baltic avenue
        xFirstThree  -= 75;
        xSecondThree -= 75;
        xLastTwo     -= 75;

//        location.add(new TokenBoardLocation(new ArrayList<>(Arrays.asList(985 + xFirstThree, 985 + xFirstThree, 985 + xFirstThree, 950 + xSecondThree, 950 + xSecondThree, 950 + xSecondThree, 1020 + xLastTwo, 1020 + xLastTwo)), // x values
//                new ArrayList<>(Arrays.asList(855,885,915,855,885,915,845,885)))); // y values
        locationLinkedHashMap.put(BoardSpaceElement.BALTIC_AVENUE, new TokenBoardLocation(new ArrayList<>(Arrays.asList(985 + xFirstThree, 985 + xFirstThree, 985 + xFirstThree, 950 + xSecondThree, 950 + xSecondThree, 950 + xSecondThree, 1020 + xLastTwo, 1020 + xLastTwo)), // x values
                new ArrayList<>(Arrays.asList(855,885,915,855,885,915,845,885)))); // y values
        // income tax
        xFirstThree  -= 75;
        xSecondThree -= 75;
        xLastTwo     -= 75;

//        location.add(new TokenBoardLocation(new ArrayList<>(Arrays.asList(985 + xFirstThree, 985 + xFirstThree, 985 + xFirstThree, 950 + xSecondThree, 950 + xSecondThree, 950 + xSecondThree, 1020 + xLastTwo, 1020 + xLastTwo)), // x values
//                new ArrayList<>(Arrays.asList(855,885,915,855,885,915,845,885)))); // y values
        locationLinkedHashMap.put(BoardSpaceElement.INCOME_TAX, new TokenBoardLocation(new ArrayList<>(Arrays.asList(985 + xFirstThree, 985 + xFirstThree, 985 + xFirstThree, 950 + xSecondThree, 950 + xSecondThree, 950 + xSecondThree, 1020 + xLastTwo, 1020 + xLastTwo)), // x values
                new ArrayList<>(Arrays.asList(855,885,915,855,885,915,845,885)))); // y values
        // reading railroad
        xFirstThree  -= 85;
        xSecondThree -= 75;
        xLastTwo     -= 75;
//        location.add(new TokenBoardLocation(new ArrayList<>(Arrays.asList(985 + xFirstThree, 985 + xFirstThree, 985 + xFirstThree, 950 + xSecondThree, 950 + xSecondThree, 950 + xSecondThree, 1020 + xLastTwo, 1020 + xLastTwo)), // x values
//                new ArrayList<>(Arrays.asList(855,885,915,855,885,915,845,885)))); // y values
        locationLinkedHashMap.put(BoardSpaceElement.READING_RAILROAD, new TokenBoardLocation(new ArrayList<>(Arrays.asList(985 + xFirstThree, 985 + xFirstThree, 985 + xFirstThree, 950 + xSecondThree, 950 + xSecondThree, 950 + xSecondThree, 1020 + xLastTwo, 1020 + xLastTwo)), // x values
                new ArrayList<>(Arrays.asList(855,885,915,855,885,915,845,885)))); // y values
        // oriental avenue
        xFirstThree  -= 80;
        xSecondThree -= 80;
        xLastTwo     -= 85;
//        location.add(new TokenBoardLocation(new ArrayList<>(Arrays.asList(985 + xFirstThree, 985 + xFirstThree, 985 + xFirstThree, 950 + xSecondThree, 950 + xSecondThree, 950 + xSecondThree, 1020 + xLastTwo, 1020 + xLastTwo)), // x values
//                new ArrayList<>(Arrays.asList(855,885,915,855,885,915,845,885)))); // y values
        locationLinkedHashMap.put(BoardSpaceElement.ORIENTAL_AVENUE, new TokenBoardLocation(new ArrayList<>(Arrays.asList(985 + xFirstThree, 985 + xFirstThree, 985 + xFirstThree, 950 + xSecondThree, 950 + xSecondThree, 950 + xSecondThree, 1020 + xLastTwo, 1020 + xLastTwo)), // x values
                new ArrayList<>(Arrays.asList(855,885,915,855,885,915,845,885)))); // y values
        // chance
        xFirstThree  -= 80;
        xSecondThree -= 80;
        xLastTwo     -= 85;
//        location.add(new TokenBoardLocation(new ArrayList<>(Arrays.asList(985 + xFirstThree, 985 + xFirstThree, 985 + xFirstThree, 950 + xSecondThree, 950 + xSecondThree, 950 + xSecondThree, 1020 + xLastTwo, 1020 + xLastTwo)), // x values
//                new ArrayList<>(Arrays.asList(855,885,915,855,885,915,845,885)))); // y values
        locationLinkedHashMap.put(BoardSpaceElement.CHANCE, new TokenBoardLocation(new ArrayList<>(Arrays.asList(985 + xFirstThree, 985 + xFirstThree, 985 + xFirstThree, 950 + xSecondThree, 950 + xSecondThree, 950 + xSecondThree, 1020 + xLastTwo, 1020 + xLastTwo)), // x values
                new ArrayList<>(Arrays.asList(855,885,915,855,885,915,845,885)))); // y values
        // vermont avenue
        xFirstThree  -= 80;
        xSecondThree -= 80;
        xLastTwo     -= 80;
//        location.add(new TokenBoardLocation(new ArrayList<>(Arrays.asList(985 + xFirstThree, 985 + xFirstThree, 985 + xFirstThree, 950 + xSecondThree, 950 + xSecondThree, 950 + xSecondThree, 1020 + xLastTwo, 1020 + xLastTwo)), // x values
//                new ArrayList<>(Arrays.asList(855,885,915,855,885,915,845,885)))); // y values
        locationLinkedHashMap.put(BoardSpaceElement.VERMONT_AVENUE, new TokenBoardLocation(new ArrayList<>(Arrays.asList(985 + xFirstThree, 985 + xFirstThree, 985 + xFirstThree, 950 + xSecondThree, 950 + xSecondThree, 950 + xSecondThree, 1020 + xLastTwo, 1020 + xLastTwo)), // x values
                new ArrayList<>(Arrays.asList(855,885,915,855,885,915,845,885)))); // y values
        // connecticut avenue
        xFirstThree  -= 75;
        xSecondThree -= 80;
        xLastTwo     -= 75;
//        location.add(new TokenBoardLocation(new ArrayList<>(Arrays.asList(985 + xFirstThree, 985 + xFirstThree, 985 + xFirstThree, 950 + xSecondThree, 950 + xSecondThree, 950 + xSecondThree, 1020 + xLastTwo, 1020 + xLastTwo)), // x values
//                new ArrayList<>(Arrays.asList(855,885,915,855,885,915,845,885)))); // y values
        locationLinkedHashMap.put(BoardSpaceElement.CONNECTICUT_AVENUE, new TokenBoardLocation(new ArrayList<>(Arrays.asList(985 + xFirstThree, 985 + xFirstThree, 985 + xFirstThree, 950 + xSecondThree, 950 + xSecondThree, 950 + xSecondThree, 1020 + xLastTwo, 1020 + xLastTwo)), // x values
                new ArrayList<>(Arrays.asList(855,885,915,855,885,915,845,885)))); // y values
        // just visiting jail
        xSecondThree -= 120;
        xLastTwo     -= 75;
        yFirstThree  -= 45;
//        location.add(new TokenBoardLocation(new ArrayList<>(Arrays.asList(985 + xFirstThree - 145, 985 + xFirstThree - 145, 985 + xFirstThree - 110, 950 + xSecondThree, 950 + xSecondThree, 950 + xSecondThree, 1020 + xLastTwo - 30, 1020 + xLastTwo)), // x values
//                new ArrayList<>(Arrays.asList(855 + 45,885 + 40,915,855 - 35,885 + yFirstThree,915 + yFirstThree,845 + 65,885 + 20)))); // y values
        locationLinkedHashMap.put(BoardSpaceElement.JUST_VISITING_JAIL, new TokenBoardLocation(new ArrayList<>(Arrays.asList(985 + xFirstThree - 145, 985 + xFirstThree - 145, 985 + xFirstThree - 110, 950 + xSecondThree, 950 + xSecondThree, 950 + xSecondThree, 1020 + xLastTwo - 30, 1020 + xLastTwo)), // x values
                new ArrayList<>(Arrays.asList(855 + 45,885 + 40,915,855 - 35,885 + yFirstThree,915 + yFirstThree,845 + 65,885 + 20)))); // y values
        // st charles place
        XAll -= 100;
        YAll -= 120;
//        location.add(new TokenBoardLocation(new ArrayList<>(Arrays.asList(256 + XAll, 265 + XAll, 265 + XAll, 240 + XAll, 240 + XAll, 240 + XAll, 290 + XAll, 290 + XAll)), // x values
//                new ArrayList<>(Arrays.asList(855 + YAll + 10,885 + YAll,915 + YAll,855 + YAll + 10,885 + YAll,915 + YAll,845 + YAll + 10,885 + YAll)))); // y values
        locationLinkedHashMap.put(BoardSpaceElement.ST_CHARLES_PLACE, new TokenBoardLocation(new ArrayList<>(Arrays.asList(256 + XAll, 265 + XAll, 265 + XAll, 240 + XAll, 240 + XAll, 240 + XAll, 290 + XAll, 290 + XAll)), // x values
                new ArrayList<>(Arrays.asList(855 + YAll + 10,885 + YAll,915 + YAll,855 + YAll + 10,885 + YAll,915 + YAll,845 + YAll + 10,885 + YAll)))); // y values
        // electric company
        YAll -= 75;
//        location.add(new TokenBoardLocation(new ArrayList<>(Arrays.asList(256 + XAll, 265 + XAll, 265 + XAll, 240 + XAll, 240 + XAll, 240 + XAll, 290 + XAll, 290 + XAll)), // x values
//                new ArrayList<>(Arrays.asList(855 + YAll + 10,885 + YAll,915 + YAll,855 + YAll + 10,885 + YAll,915 + YAll,845 + YAll + 10,885 + YAll)))); // y values
        locationLinkedHashMap.put(BoardSpaceElement.ELECTRIC_COMPANY, new TokenBoardLocation(new ArrayList<>(Arrays.asList(256 + XAll, 265 + XAll, 265 + XAll, 240 + XAll, 240 + XAll, 240 + XAll, 290 + XAll, 290 + XAll)), // x values
                new ArrayList<>(Arrays.asList(855 + YAll + 10,885 + YAll,915 + YAll,855 + YAll + 10,885 + YAll,915 + YAll,845 + YAll + 10,885 + YAll)))); // y values
        // states avenue
        YAll -= 85;
//        location.add(new TokenBoardLocation(new ArrayList<>(Arrays.asList(256 + XAll, 265 + XAll, 265 + XAll, 240 + XAll, 240 + XAll, 240 + XAll, 290 + XAll, 290 + XAll)), // x values
//                new ArrayList<>(Arrays.asList(855 + YAll + 10,885 + YAll,915 + YAll,855 + YAll + 10,885 + YAll,915 + YAll,845 + YAll + 10,885 + YAll)))); // y values
        locationLinkedHashMap.put(BoardSpaceElement.STATES_AVENUE, new TokenBoardLocation(new ArrayList<>(Arrays.asList(256 + XAll, 265 + XAll, 265 + XAll, 240 + XAll, 240 + XAll, 240 + XAll, 290 + XAll, 290 + XAll)), // x values
                new ArrayList<>(Arrays.asList(855 + YAll + 10,885 + YAll,915 + YAll,855 + YAll + 10,885 + YAll,915 + YAll,845 + YAll + 10,885 + YAll)))); // y values
        // virginia avenue
        YAll -= 75;
//        location.add(new TokenBoardLocation(new ArrayList<>(Arrays.asList(256 + XAll, 265 + XAll, 265 + XAll, 240 + XAll, 240 + XAll, 240 + XAll, 290 + XAll, 290 + XAll)), // x values
//                new ArrayList<>(Arrays.asList(855 + YAll + 10,885 + YAll,915 + YAll,855 + YAll + 10,885 + YAll,915 + YAll,845 + YAll + 10,885 + YAll)))); // y values
        locationLinkedHashMap.put(BoardSpaceElement.VIRGINIA_AVENUE, new TokenBoardLocation(new ArrayList<>(Arrays.asList(256 + XAll, 265 + XAll, 265 + XAll, 240 + XAll, 240 + XAll, 240 + XAll, 290 + XAll, 290 + XAll)), // x values
                new ArrayList<>(Arrays.asList(855 + YAll + 10,885 + YAll,915 + YAll,855 + YAll + 10,885 + YAll,915 + YAll,845 + YAll + 10,885 + YAll)))); // y values
        // pennsylvania railroad
        YAll -= 75;
//        location.add(new TokenBoardLocation(new ArrayList<>(Arrays.asList(256 + XAll, 265 + XAll, 265 + XAll, 240 + XAll, 240 + XAll, 240 + XAll, 290 + XAll, 290 + XAll)), // x values
//                new ArrayList<>(Arrays.asList(855 + YAll + 10,885 + YAll,915 + YAll,855 + YAll + 10,885 + YAll,915 + YAll,845 + YAll + 10,885 + YAll)))); // y values
        locationLinkedHashMap.put(BoardSpaceElement.PENNSYLVANIA_RAILROAD, new TokenBoardLocation(new ArrayList<>(Arrays.asList(256 + XAll, 265 + XAll, 265 + XAll, 240 + XAll, 240 + XAll, 240 + XAll, 290 + XAll, 290 + XAll)), // x values
                new ArrayList<>(Arrays.asList(855 + YAll + 10,885 + YAll,915 + YAll,855 + YAll + 10,885 + YAll,915 + YAll,845 + YAll + 10,885 + YAll)))); // y values
        // st james avenue
        YAll -= 80;
//        location.add(new TokenBoardLocation(new ArrayList<>(Arrays.asList(256 + XAll, 265 + XAll, 265 + XAll, 240 + XAll, 240 + XAll, 240 + XAll, 290 + XAll, 290 + XAll)), // x values
//                new ArrayList<>(Arrays.asList(855 + YAll + 10,885 + YAll,915 + YAll,855 + YAll + 10,885 + YAll,915 + YAll,845 + YAll + 10,885 + YAll)))); // y values
        locationLinkedHashMap.put(BoardSpaceElement.ST_JAMES_PLACE, new TokenBoardLocation(new ArrayList<>(Arrays.asList(256 + XAll, 265 + XAll, 265 + XAll, 240 + XAll, 240 + XAll, 240 + XAll, 290 + XAll, 290 + XAll)), // x values
                new ArrayList<>(Arrays.asList(855 + YAll + 10,885 + YAll,915 + YAll,855 + YAll + 10,885 + YAll,915 + YAll,845 + YAll + 10,885 + YAll)))); // y values
        // community chest
        YAll -= 80;
//        location.add(new TokenBoardLocation(new ArrayList<>(Arrays.asList(256 + XAll, 265 + XAll, 265 + XAll, 240 + XAll, 240 + XAll, 240 + XAll, 290 + XAll, 290 + XAll)), // x values
//                new ArrayList<>(Arrays.asList(855 + YAll + 10,885 + YAll,915 + YAll,855 + YAll + 10,885 + YAll,915 + YAll,845 + YAll + 10,885 + YAll)))); // y values
        locationLinkedHashMap.put(BoardSpaceElement.COMMUNITY_CHEST2, new TokenBoardLocation(new ArrayList<>(Arrays.asList(256 + XAll, 265 + XAll, 265 + XAll, 240 + XAll, 240 + XAll, 240 + XAll, 290 + XAll, 290 + XAll)), // x values
                new ArrayList<>(Arrays.asList(855 + YAll + 10,885 + YAll,915 + YAll,855 + YAll + 10,885 + YAll,915 + YAll,845 + YAll + 10,885 + YAll)))); // y values
        // tennessee avenue
        YAll -= 80;
//        location.add(new TokenBoardLocation(new ArrayList<>(Arrays.asList(256 + XAll, 265 + XAll, 265 + XAll, 240 + XAll, 240 + XAll, 240 + XAll, 290 + XAll, 290 + XAll)), // x values
//                new ArrayList<>(Arrays.asList(855 + YAll + 10,885 + YAll,915 + YAll,855 + YAll + 10,885 + YAll,915 + YAll,845 + YAll + 10,885 + YAll)))); // y values
        locationLinkedHashMap.put(BoardSpaceElement.TENNESSEE_AVENUE, new TokenBoardLocation(new ArrayList<>(Arrays.asList(256 + XAll, 265 + XAll, 265 + XAll, 240 + XAll, 240 + XAll, 240 + XAll, 290 + XAll, 290 + XAll)), // x values
                new ArrayList<>(Arrays.asList(855 + YAll + 10,885 + YAll,915 + YAll,855 + YAll + 10,885 + YAll,915 + YAll,845 + YAll + 10,885 + YAll)))); // y values
        // new york avenue
        YAll -= 80;
//        location.add(new TokenBoardLocation(new ArrayList<>(Arrays.asList(256 + XAll, 265 + XAll, 265 + XAll, 240 + XAll, 240 + XAll, 240 + XAll, 290 + XAll, 290 + XAll)), // x values
//                new ArrayList<>(Arrays.asList(855 + YAll + 10,885 + YAll,915 + YAll,855 + YAll + 10,885 + YAll,915 + YAll,845 + YAll + 10,885 + YAll)))); // y values
        locationLinkedHashMap.put(BoardSpaceElement.NEW_YORK_AVENUE, new TokenBoardLocation(new ArrayList<>(Arrays.asList(256 + XAll, 265 + XAll, 265 + XAll, 240 + XAll, 240 + XAll, 240 + XAll, 290 + XAll, 290 + XAll)), // x values
                new ArrayList<>(Arrays.asList(855 + YAll + 10,885 + YAll,915 + YAll,855 + YAll + 10,885 + YAll,915 + YAll,845 + YAll + 10,885 + YAll)))); // y values
        // free parking
        YAll -= 100;
//        location.add(new TokenBoardLocation(new ArrayList<>(Arrays.asList(256 + XAll, 265 + XAll, 265 + XAll, 240 + XAll, 240 + XAll, 240 + XAll, 290 + XAll, 290 + XAll)), // x values
//                new ArrayList<>(Arrays.asList(855 + YAll + 10,885 + YAll,915 + YAll,855 + YAll + 10,885 + YAll,915 + YAll,845 + YAll + 10,885 + YAll)))); // y values
        locationLinkedHashMap.put(BoardSpaceElement.FREE_PARKING, new TokenBoardLocation(new ArrayList<>(Arrays.asList(256 + XAll, 265 + XAll, 265 + XAll, 240 + XAll, 240 + XAll, 240 + XAll, 290 + XAll, 290 + XAll)), // x values
                new ArrayList<>(Arrays.asList(855 + YAll + 10,885 + YAll,915 + YAll,855 + YAll + 10,885 + YAll,915 + YAll,845 + YAll + 10,885 + YAll)))); // y values
        // kentucky avenue
        XAll += 100;
//        location.add(new TokenBoardLocation(new ArrayList<>(Arrays.asList(256 + XAll, 265 + XAll, 265 + XAll, 240 + XAll, 240 + XAll, 240 + XAll, 290 + XAll, 290 + XAll)), // x values
//                new ArrayList<>(Arrays.asList(855 + YAll + 10,885 + YAll,915 + YAll,855 + YAll + 10,885 + YAll,915 + YAll,845 + YAll + 10,885 + YAll)))); // y values
        locationLinkedHashMap.put(BoardSpaceElement.KENTUCKY_AVENUE, new TokenBoardLocation(new ArrayList<>(Arrays.asList(256 + XAll, 265 + XAll, 265 + XAll, 240 + XAll, 240 + XAll, 240 + XAll, 290 + XAll, 290 + XAll)), // x values
                new ArrayList<>(Arrays.asList(855 + YAll + 10,885 + YAll,915 + YAll,855 + YAll + 10,885 + YAll,915 + YAll,845 + YAll + 10,885 + YAll)))); // y values
        // chance
        XAll += 80;
//        location.add(new TokenBoardLocation(new ArrayList<>(Arrays.asList(256 + XAll, 265 + XAll, 265 + XAll, 240 + XAll, 240 + XAll, 240 + XAll, 290 + XAll, 290 + XAll)), // x values
//                new ArrayList<>(Arrays.asList(855 + YAll + 10,885 + YAll,915 + YAll,855 + YAll + 10,885 + YAll,915 + YAll,845 + YAll + 10,885 + YAll)))); // y values
        locationLinkedHashMap.put(BoardSpaceElement.CHANCE2, new TokenBoardLocation(new ArrayList<>(Arrays.asList(256 + XAll, 265 + XAll, 265 + XAll, 240 + XAll, 240 + XAll, 240 + XAll, 290 + XAll, 290 + XAll)), // x values
                new ArrayList<>(Arrays.asList(855 + YAll + 10,885 + YAll,915 + YAll,855 + YAll + 10,885 + YAll,915 + YAll,845 + YAll + 10,885 + YAll)))); // y values
        // indiana avenue
        XAll += 80;
//        location.add(new TokenBoardLocation(new ArrayList<>(Arrays.asList(256 + XAll, 265 + XAll, 265 + XAll, 240 + XAll, 240 + XAll, 240 + XAll, 290 + XAll, 290 + XAll)), // x values
//                new ArrayList<>(Arrays.asList(855 + YAll + 10,885 + YAll,915 + YAll,855 + YAll + 10,885 + YAll,915 + YAll,845 + YAll + 10,885 + YAll)))); // y values
        locationLinkedHashMap.put(BoardSpaceElement.INDIANA_AVENUE, new TokenBoardLocation(new ArrayList<>(Arrays.asList(256 + XAll, 265 + XAll, 265 + XAll, 240 + XAll, 240 + XAll, 240 + XAll, 290 + XAll, 290 + XAll)), // x values
                new ArrayList<>(Arrays.asList(855 + YAll + 10,885 + YAll,915 + YAll,855 + YAll + 10,885 + YAll,915 + YAll,845 + YAll + 10,885 + YAll)))); // y values
        // illinois avenue
        XAll += 80;
//        location.add(new TokenBoardLocation(new ArrayList<>(Arrays.asList(256 + XAll, 265 + XAll, 265 + XAll, 240 + XAll, 240 + XAll, 240 + XAll, 290 + XAll, 290 + XAll)), // x values
//                new ArrayList<>(Arrays.asList(855 + YAll + 10,885 + YAll,915 + YAll,855 + YAll + 10,885 + YAll,915 + YAll,845 + YAll + 10,885 + YAll)))); // y values
        locationLinkedHashMap.put(BoardSpaceElement.ILLINOIS_AVENUE, new TokenBoardLocation(new ArrayList<>(Arrays.asList(256 + XAll, 265 + XAll, 265 + XAll, 240 + XAll, 240 + XAll, 240 + XAll, 290 + XAll, 290 + XAll)), // x values
                new ArrayList<>(Arrays.asList(855 + YAll + 10,885 + YAll,915 + YAll,855 + YAll + 10,885 + YAll,915 + YAll,845 + YAll + 10,885 + YAll)))); // y values
        // b&o railroad
        XAll += 80;
//        location.add(new TokenBoardLocation(new ArrayList<>(Arrays.asList(256 + XAll, 265 + XAll, 265 + XAll, 240 + XAll, 240 + XAll, 240 + XAll, 290 + XAll, 290 + XAll)), // x values
//                new ArrayList<>(Arrays.asList(855 + YAll + 10,885 + YAll,915 + YAll,855 + YAll + 10,885 + YAll,915 + YAll,845 + YAll + 10,885 + YAll)))); // y values
        locationLinkedHashMap.put(BoardSpaceElement.B_AND_O_RAILROAD, new TokenBoardLocation(new ArrayList<>(Arrays.asList(256 + XAll, 265 + XAll, 265 + XAll, 240 + XAll, 240 + XAll, 240 + XAll, 290 + XAll, 290 + XAll)), // x values
                new ArrayList<>(Arrays.asList(855 + YAll + 10,885 + YAll,915 + YAll,855 + YAll + 10,885 + YAll,915 + YAll,845 + YAll + 10,885 + YAll)))); // y values
        // atlantic avenue
        XAll += 70;
//        location.add(new TokenBoardLocation(new ArrayList<>(Arrays.asList(256 + XAll, 265 + XAll, 265 + XAll, 240 + XAll, 240 + XAll, 240 + XAll, 290 + XAll, 290 + XAll)), // x values
//                new ArrayList<>(Arrays.asList(855 + YAll + 10,885 + YAll,915 + YAll,855 + YAll + 10,885 + YAll,915 + YAll,845 + YAll + 10,885 + YAll)))); // y values
        locationLinkedHashMap.put(BoardSpaceElement.ATLANTIC_AVENUE, new TokenBoardLocation(new ArrayList<>(Arrays.asList(256 + XAll, 265 + XAll, 265 + XAll, 240 + XAll, 240 + XAll, 240 + XAll, 290 + XAll, 290 + XAll)), // x values
                new ArrayList<>(Arrays.asList(855 + YAll + 10,885 + YAll,915 + YAll,855 + YAll + 10,885 + YAll,915 + YAll,845 + YAll + 10,885 + YAll)))); // y values
        // water works
        XAll += 80;
//        location.add(new TokenBoardLocation(new ArrayList<>(Arrays.asList(256 + XAll, 265 + XAll, 265 + XAll, 240 + XAll, 240 + XAll, 240 + XAll, 290 + XAll, 290 + XAll)), // x values
//                new ArrayList<>(Arrays.asList(855 + YAll + 10,885 + YAll,915 + YAll,855 + YAll + 10,885 + YAll,915 + YAll,845 + YAll + 10,885 + YAll)))); // y values
        locationLinkedHashMap.put(BoardSpaceElement.WATER_WORKS, new TokenBoardLocation(new ArrayList<>(Arrays.asList(256 + XAll, 265 + XAll, 265 + XAll, 240 + XAll, 240 + XAll, 240 + XAll, 290 + XAll, 290 + XAll)), // x values
                new ArrayList<>(Arrays.asList(855 + YAll + 10,885 + YAll,915 + YAll,855 + YAll + 10,885 + YAll,915 + YAll,845 + YAll + 10,885 + YAll)))); // y values
        // ventnor avenue
        XAll += 80;
//        location.add(new TokenBoardLocation(new ArrayList<>(Arrays.asList(256 + XAll, 265 + XAll, 265 + XAll, 240 + XAll, 240 + XAll, 240 + XAll, 290 + XAll, 290 + XAll)), // x values
//                new ArrayList<>(Arrays.asList(855 + YAll + 10,885 + YAll,915 + YAll,855 + YAll + 10,885 + YAll,915 + YAll,845 + YAll + 10,885 + YAll)))); // y values
        locationLinkedHashMap.put(BoardSpaceElement.VENTNOR_AVENUE, new TokenBoardLocation(new ArrayList<>(Arrays.asList(256 + XAll, 265 + XAll, 265 + XAll, 240 + XAll, 240 + XAll, 240 + XAll, 290 + XAll, 290 + XAll)), // x values
                new ArrayList<>(Arrays.asList(855 + YAll + 10,885 + YAll,915 + YAll,855 + YAll + 10,885 + YAll,915 + YAll,845 + YAll + 10,885 + YAll)))); // y values
        // marvin gardens
        XAll += 80;
//        location.add(new TokenBoardLocation(new ArrayList<>(Arrays.asList(256 + XAll, 265 + XAll, 265 + XAll, 240 + XAll, 240 + XAll, 240 + XAll, 290 + XAll, 290 + XAll)), // x values
//                new ArrayList<>(Arrays.asList(855 + YAll + 10,885 + YAll,915 + YAll,855 + YAll + 10,885 + YAll,915 + YAll,845 + YAll + 10,885 + YAll)))); // y values
        locationLinkedHashMap.put(BoardSpaceElement.MARVIN_GARDENS, new TokenBoardLocation(new ArrayList<>(Arrays.asList(256 + XAll, 265 + XAll, 265 + XAll, 240 + XAll, 240 + XAll, 240 + XAll, 290 + XAll, 290 + XAll)), // x values
                new ArrayList<>(Arrays.asList(855 + YAll + 10,885 + YAll,915 + YAll,855 + YAll + 10,885 + YAll,915 + YAll,845 + YAll + 10,885 + YAll)))); // y values
        // go to jail
        XAll += 110;
//        location.add(new TokenBoardLocation(new ArrayList<>(Arrays.asList(256 + XAll, 265 + XAll, 265 + XAll, 240 + XAll, 240 + XAll, 240 + XAll, 290 + XAll, 290 + XAll)), // x values
//                new ArrayList<>(Arrays.asList(855 + YAll + 10,885 + YAll,915 + YAll,855 + YAll + 10,885 + YAll,915 + YAll,845 + YAll + 10,885 + YAll)))); // y values
        locationLinkedHashMap.put(BoardSpaceElement.GO_TO_JAIL, new TokenBoardLocation(new ArrayList<>(Arrays.asList(256 + XAll, 265 + XAll, 265 + XAll, 240 + XAll, 240 + XAll, 240 + XAll, 290 + XAll, 290 + XAll)), // x values
                new ArrayList<>(Arrays.asList(855 + YAll + 10,885 + YAll,915 + YAll,855 + YAll + 10,885 + YAll,915 + YAll,845 + YAll + 10,885 + YAll)))); // y values
        // pacific avenue
        YAll += 105;
//        location.add(new TokenBoardLocation(new ArrayList<>(Arrays.asList(256 + XAll, 265 + XAll, 265 + XAll, 240 + XAll, 240 + XAll, 240 + XAll, 290 + XAll, 290 + XAll)), // x values
//                new ArrayList<>(Arrays.asList(855 + YAll + 10,885 + YAll,915 + YAll,855 + YAll + 10,885 + YAll,915 + YAll,845 + YAll + 10,885 + YAll)))); // y values
        locationLinkedHashMap.put(BoardSpaceElement.PACIFIC_AVENUE, new TokenBoardLocation(new ArrayList<>(Arrays.asList(256 + XAll, 265 + XAll, 265 + XAll, 240 + XAll, 240 + XAll, 240 + XAll, 290 + XAll, 290 + XAll)), // x values
                new ArrayList<>(Arrays.asList(855 + YAll + 10,885 + YAll,915 + YAll,855 + YAll + 10,885 + YAll,915 + YAll,845 + YAll + 10,885 + YAll)))); // y values
        // north carolina avenue
        YAll += 70;
//        location.add(new TokenBoardLocation(new ArrayList<>(Arrays.asList(256 + XAll, 265 + XAll, 265 + XAll, 240 + XAll, 240 + XAll, 240 + XAll, 290 + XAll, 290 + XAll)), // x values
//                new ArrayList<>(Arrays.asList(855 + YAll + 10,885 + YAll,915 + YAll,855 + YAll + 10,885 + YAll,915 + YAll,845 + YAll + 10,885 + YAll)))); // y values
        locationLinkedHashMap.put(BoardSpaceElement.NORTH_CAROLINA_AVENUE, new TokenBoardLocation(new ArrayList<>(Arrays.asList(256 + XAll, 265 + XAll, 265 + XAll, 240 + XAll, 240 + XAll, 240 + XAll, 290 + XAll, 290 + XAll)), // x values
                new ArrayList<>(Arrays.asList(855 + YAll + 10,885 + YAll,915 + YAll,855 + YAll + 10,885 + YAll,915 + YAll,845 + YAll + 10,885 + YAll)))); // y values
        // community chest
        YAll += 80;
//        location.add(new TokenBoardLocation(new ArrayList<>(Arrays.asList(256 + XAll, 265 + XAll, 265 + XAll, 240 + XAll, 240 + XAll, 240 + XAll, 290 + XAll, 290 + XAll)), // x values
//                new ArrayList<>(Arrays.asList(855 + YAll + 10,885 + YAll,915 + YAll,855 + YAll + 10,885 + YAll,915 + YAll,845 + YAll + 10,885 + YAll)))); // y values
        locationLinkedHashMap.put(BoardSpaceElement.COMMUNITY_CHEST3, new TokenBoardLocation(new ArrayList<>(Arrays.asList(256 + XAll, 265 + XAll, 265 + XAll, 240 + XAll, 240 + XAll, 240 + XAll, 290 + XAll, 290 + XAll)), // x values
                new ArrayList<>(Arrays.asList(855 + YAll + 10,885 + YAll,915 + YAll,855 + YAll + 10,885 + YAll,915 + YAll,845 + YAll + 10,885 + YAll)))); // y values
        // pennsylvania avenue
        YAll += 80;
//        location.add(new TokenBoardLocation(new ArrayList<>(Arrays.asList(256 + XAll, 265 + XAll, 265 + XAll, 240 + XAll, 240 + XAll, 240 + XAll, 290 + XAll, 290 + XAll)), // x values
//                new ArrayList<>(Arrays.asList(855 + YAll + 10,885 + YAll,915 + YAll,855 + YAll + 10,885 + YAll,915 + YAll,845 + YAll + 10,885 + YAll)))); // y values
        locationLinkedHashMap.put(BoardSpaceElement.PENNSYLVANIA_AVENUE, new TokenBoardLocation(new ArrayList<>(Arrays.asList(256 + XAll, 265 + XAll, 265 + XAll, 240 + XAll, 240 + XAll, 240 + XAll, 290 + XAll, 290 + XAll)), // x values
                new ArrayList<>(Arrays.asList(855 + YAll + 10,885 + YAll,915 + YAll,855 + YAll + 10,885 + YAll,915 + YAll,845 + YAll + 10,885 + YAll)))); // y values
        // short line
        YAll += 80;
//        location.add(new TokenBoardLocation(new ArrayList<>(Arrays.asList(256 + XAll, 265 + XAll, 265 + XAll, 240 + XAll, 240 + XAll, 240 + XAll, 290 + XAll, 290 + XAll)), // x values
//                new ArrayList<>(Arrays.asList(855 + YAll + 10,885 + YAll,915 + YAll,855 + YAll + 10,885 + YAll,915 + YAll,845 + YAll + 10,885 + YAll)))); // y values
        locationLinkedHashMap.put(BoardSpaceElement.SHORT_LINE_RAILROAD, new TokenBoardLocation(new ArrayList<>(Arrays.asList(256 + XAll, 265 + XAll, 265 + XAll, 240 + XAll, 240 + XAll, 240 + XAll, 290 + XAll, 290 + XAll)), // x values
                new ArrayList<>(Arrays.asList(855 + YAll + 10,885 + YAll,915 + YAll,855 + YAll + 10,885 + YAll,915 + YAll,845 + YAll + 10,885 + YAll)))); // y values
        // chance
        YAll += 80;
//        location.add(new TokenBoardLocation(new ArrayList<>(Arrays.asList(256 + XAll, 265 + XAll, 265 + XAll, 240 + XAll, 240 + XAll, 240 + XAll, 290 + XAll, 290 + XAll)), // x values
//                new ArrayList<>(Arrays.asList(855 + YAll + 10,885 + YAll,915 + YAll,855 + YAll + 10,885 + YAll,915 + YAll,845 + YAll + 10,885 + YAll)))); // y values
        locationLinkedHashMap.put(BoardSpaceElement.CHANCE3, new TokenBoardLocation(new ArrayList<>(Arrays.asList(256 + XAll, 265 + XAll, 265 + XAll, 240 + XAll, 240 + XAll, 240 + XAll, 290 + XAll, 290 + XAll)), // x values
                new ArrayList<>(Arrays.asList(855 + YAll + 10,885 + YAll,915 + YAll,855 + YAll + 10,885 + YAll,915 + YAll,845 + YAll + 10,885 + YAll)))); // y values
        // park place
        YAll += 75;
//        location.add(new TokenBoardLocation(new ArrayList<>(Arrays.asList(256 + XAll, 265 + XAll, 265 + XAll, 240 + XAll, 240 + XAll, 240 + XAll, 290 + XAll, 290 + XAll)), // x values
//                new ArrayList<>(Arrays.asList(855 + YAll + 10,885 + YAll,915 + YAll,855 + YAll + 10,885 + YAll,915 + YAll,845 + YAll + 10,885 + YAll)))); // y values
        locationLinkedHashMap.put(BoardSpaceElement.PARK_PLACE, new TokenBoardLocation(new ArrayList<>(Arrays.asList(256 + XAll, 265 + XAll, 265 + XAll, 240 + XAll, 240 + XAll, 240 + XAll, 290 + XAll, 290 + XAll)), // x values
                new ArrayList<>(Arrays.asList(855 + YAll + 10,885 + YAll,915 + YAll,855 + YAll + 10,885 + YAll,915 + YAll,845 + YAll + 10,885 + YAll)))); // y values
        // luxury tax
        YAll += 75;
//        location.add(new TokenBoardLocation(new ArrayList<>(Arrays.asList(256 + XAll, 265 + XAll, 265 + XAll, 240 + XAll, 240 + XAll, 240 + XAll, 290 + XAll, 290 + XAll)), // x values
//                new ArrayList<>(Arrays.asList(855 + YAll + 10,885 + YAll,915 + YAll,855 + YAll + 10,885 + YAll,915 + YAll,845 + YAll + 10,885 + YAll)))); // y values
        locationLinkedHashMap.put(BoardSpaceElement.LUXURY_TAX, new TokenBoardLocation(new ArrayList<>(Arrays.asList(256 + XAll, 265 + XAll, 265 + XAll, 240 + XAll, 240 + XAll, 240 + XAll, 290 + XAll, 290 + XAll)), // x values
                new ArrayList<>(Arrays.asList(855 + YAll + 10,885 + YAll,915 + YAll,855 + YAll + 10,885 + YAll,915 + YAll,845 + YAll + 10,885 + YAll)))); // y values
        // board walk
        YAll += 80;
//        location.add(new TokenBoardLocation(new ArrayList<>(Arrays.asList(256 + XAll, 265 + XAll, 265 + XAll, 240 + XAll, 240 + XAll, 240 + XAll, 290 + XAll, 290 + XAll)), // x values
//                new ArrayList<>(Arrays.asList(855 + YAll + 10,885 + YAll,915 + YAll,855 + YAll + 10,885 + YAll,915 + YAll,845 + YAll + 10,885 + YAll)))); // y values
        locationLinkedHashMap.put(BoardSpaceElement.BOARDWALK, new TokenBoardLocation(new ArrayList<>(Arrays.asList(256 + XAll, 265 + XAll, 265 + XAll, 240 + XAll, 240 + XAll, 240 + XAll, 290 + XAll, 290 + XAll)), // x values
                new ArrayList<>(Arrays.asList(855 + YAll + 10,885 + YAll,915 + YAll,855 + YAll + 10,885 + YAll,915 + YAll,845 + YAll + 10,885 + YAll)))); // y values
    }

    public TokenBoardLocation getBoardLocation(BoardSpaceElement boardSpaceElement){
        return locationLinkedHashMap.get(boardSpaceElement);
    }

    public void locationProcessing(Player player, BoardSpaceElement boardSpaceElement){
        // empty - come up way of dealing with rental on property or buying it
        
        player.setBoardLocation(boardSpaceElement);
    }

    public void locationProcessing(Player player, BoardSpaceElement boardSpaceElement, Integer paymentModification){
        // empty - come up way of dealing with rental on property or buying it

        player.setBoardLocation(boardSpaceElement);
    }
}
