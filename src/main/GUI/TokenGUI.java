package main.GUI;

import main.Enums.BoardSpaceElement;
import main.Enums.PlayerToken;
import main.Functions.Player;
import main.Functions.PlayerProcessor;
import main.LocationFunctions.TokenBoardLocation;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class TokenGUI {

    private final int tokenSize;
    private final ArrayList<BufferedImage> tokenImage;
    private final ArrayList<String> tokenImageSrc;
    private final ArrayList<JLabel> tokenLabel;
    private final HashMap<BoardSpaceElement, TokenBoardLocation> locationHashMap;

    public TokenGUI(JLayeredPane boardSidePane) throws IOException {

        tokenSize = 40;
        tokenImage = new ArrayList<>();
        tokenImageSrc = new ArrayList<>(Arrays.asList(
                "src/main/MonopolyImages/Tokens/car.png",
                "src/main/MonopolyImages/Tokens/cat.png",
                "src/main/MonopolyImages/Tokens/dog.png",
                "src/main/MonopolyImages/Tokens/hat.png",
                "src/main/MonopolyImages/Tokens/iron.png",
                "src/main/MonopolyImages/Tokens/ship.png",
                "src/main/MonopolyImages/Tokens/shoe.png",
                "src/main/MonopolyImages/Tokens/thimble.png"));
        tokenLabel = new ArrayList<>();

        for(int i = 0; i < tokenImageSrc.size(); i++){

            tokenImage.add(ImageIO.read(new File(tokenImageSrc.get(i))));
            tokenLabel.add(new JLabel(new ImageIcon(tokenImage.get(i).getScaledInstance(tokenSize,tokenSize, Image.SCALE_DEFAULT))));
            boardSidePane.add(tokenLabel.get(i), JLayeredPane.PALETTE_LAYER);
            tokenLabel.get(i).setVisible(true);
        }

        locationHashMap = new LinkedHashMap<>();

        initializeLocation();
    }

    public void addTokenToBoardSpaceLocation(PlayerToken playerToken, BoardSpaceElement boardSpaceElement){

//        // remove player from its current location
//        locationHashMap.get(playerList.getPlayer(playerToken).getBoardLocation()).removeToken(playerToken);

        // add player to new location
        ArrayList<Integer> locationList = locationHashMap.get(boardSpaceElement).addToken(playerToken);
        int xLoc = locationList.get(0);
        int yLoc = locationList.get(1);

        switch(playerToken){
            case PlayerToken.CAR :
                tokenLabel.get(0).setBounds(xLoc, yLoc, tokenSize, tokenSize);
                break;
            case PlayerToken.CAT :
                tokenLabel.get(1).setBounds(xLoc, yLoc, tokenSize, tokenSize);
                break;
            case PlayerToken.DOG:
                tokenLabel.get(2).setBounds(xLoc, yLoc, tokenSize, tokenSize);
                break;
            case PlayerToken.HAT :
                tokenLabel.get(3).setBounds(xLoc, yLoc, tokenSize, tokenSize);
                break;
            case PlayerToken.IRON :
                tokenLabel.get(4).setBounds(xLoc, yLoc, tokenSize, tokenSize);
                break;
            case PlayerToken.SHIP :
                tokenLabel.get(5).setBounds(xLoc, yLoc, tokenSize, tokenSize);
                break;
            case PlayerToken.SHOE :
                tokenLabel.get(6).setBounds(xLoc, yLoc, tokenSize, tokenSize);
                break;
            case PlayerToken.THIMBLE :
                tokenLabel.get(7).setBounds(xLoc, yLoc, tokenSize, tokenSize);
                break;

        }
    }

    public void moveToken(PlayerProcessor playerProcessor, PlayerToken playerToken, BoardSpaceElement boardSpaceElement){

        // remove player from its current location
        locationHashMap.get(playerProcessor.getPlayer(playerToken).getBoardLocation()).removeToken(playerToken);

        // add player to new location
        addTokenToBoardSpaceLocation(playerToken, boardSpaceElement);
    }

    public void startingPosition(PlayerProcessor playerProcessor){
        for(Player player : playerProcessor.getMapOfPlayers().values()){
            addTokenToBoardSpaceLocation(player.getToken(), player.getBoardLocation());
        }
    }

    private void initializeLocation() {
        int xFirstThree = 0;
        int xSecondThree = 0;
        int xLastTwo = 0;
        int yFirstThree = 0;
        int XAll = 0;
        int YAll = 0;

        // go
        locationHashMap.put(BoardSpaceElement.GO, new TokenBoardLocation(new ArrayList<>(Arrays.asList(985 + xFirstThree, 985 + xFirstThree, 985 + xFirstThree, 950 + xSecondThree, 950 + xSecondThree, 950 + xSecondThree, 1020 + xLastTwo, 1020 + xLastTwo)), // x values
                new ArrayList<>(Arrays.asList(855,885,915,855,885,915,845,885)))); // y values
        // mediterranean avenue
        xFirstThree  -= 85;
        xSecondThree -= 80;
        xLastTwo     -= 95;

        locationHashMap.put(BoardSpaceElement.MEDITERRANEAN_AVENUE, new TokenBoardLocation(new ArrayList<>(Arrays.asList(985 + xFirstThree, 985 + xFirstThree, 985 + xFirstThree, 950 + xSecondThree, 950 + xSecondThree, 950 + xSecondThree, 1020 + xLastTwo, 1020 + xLastTwo)), // x values
                new ArrayList<>(Arrays.asList(855,885,915,855,885,915,845,885)))); // y values
        // community chest
        xFirstThree  -= 85;
        xSecondThree -= 85;
        xLastTwo     -= 85;

        locationHashMap.put(BoardSpaceElement.COMMUNITY_CHEST1, new TokenBoardLocation(new ArrayList<>(Arrays.asList(985 + xFirstThree, 985 + xFirstThree, 985 + xFirstThree, 950 + xSecondThree, 950 + xSecondThree, 950 + xSecondThree, 1020 + xLastTwo, 1020 + xLastTwo)), // x values
                new ArrayList<>(Arrays.asList(855,885,915,855,885,915,845,885)))); // y values
        // baltic avenue
        xFirstThree  -= 75;
        xSecondThree -= 75;
        xLastTwo     -= 75;

        locationHashMap.put(BoardSpaceElement.BALTIC_AVENUE, new TokenBoardLocation(new ArrayList<>(Arrays.asList(985 + xFirstThree, 985 + xFirstThree, 985 + xFirstThree, 950 + xSecondThree, 950 + xSecondThree, 950 + xSecondThree, 1020 + xLastTwo, 1020 + xLastTwo)), // x values
                new ArrayList<>(Arrays.asList(855,885,915,855,885,915,845,885)))); // y values
        // income tax
        xFirstThree  -= 75;
        xSecondThree -= 75;
        xLastTwo     -= 75;

        locationHashMap.put(BoardSpaceElement.INCOME_TAX, new TokenBoardLocation(new ArrayList<>(Arrays.asList(985 + xFirstThree, 985 + xFirstThree, 985 + xFirstThree, 950 + xSecondThree, 950 + xSecondThree, 950 + xSecondThree, 1020 + xLastTwo, 1020 + xLastTwo)), // x values
                new ArrayList<>(Arrays.asList(855,885,915,855,885,915,845,885)))); // y values
        // reading railroad
        xFirstThree  -= 85;
        xSecondThree -= 75;
        xLastTwo     -= 75;

        locationHashMap.put(BoardSpaceElement.READING_RAILROAD, new TokenBoardLocation(new ArrayList<>(Arrays.asList(985 + xFirstThree, 985 + xFirstThree, 985 + xFirstThree, 950 + xSecondThree, 950 + xSecondThree, 950 + xSecondThree, 1020 + xLastTwo, 1020 + xLastTwo)), // x values
                new ArrayList<>(Arrays.asList(855,885,915,855,885,915,845,885)))); // y values
        // oriental avenue
        xFirstThree  -= 80;
        xSecondThree -= 80;
        xLastTwo     -= 85;

        locationHashMap.put(BoardSpaceElement.ORIENTAL_AVENUE, new TokenBoardLocation(new ArrayList<>(Arrays.asList(985 + xFirstThree, 985 + xFirstThree, 985 + xFirstThree, 950 + xSecondThree, 950 + xSecondThree, 950 + xSecondThree, 1020 + xLastTwo, 1020 + xLastTwo)), // x values
                new ArrayList<>(Arrays.asList(855,885,915,855,885,915,845,885)))); // y values
        // chance
        xFirstThree  -= 80;
        xSecondThree -= 80;
        xLastTwo     -= 85;

        locationHashMap.put(BoardSpaceElement.CHANCE1, new TokenBoardLocation(new ArrayList<>(Arrays.asList(985 + xFirstThree, 985 + xFirstThree, 985 + xFirstThree, 950 + xSecondThree, 950 + xSecondThree, 950 + xSecondThree, 1020 + xLastTwo, 1020 + xLastTwo)), // x values
                new ArrayList<>(Arrays.asList(855,885,915,855,885,915,845,885)))); // y values
        // vermont avenue
        xFirstThree  -= 80;
        xSecondThree -= 80;
        xLastTwo     -= 80;

        locationHashMap.put(BoardSpaceElement.VERMONT_AVENUE, new TokenBoardLocation(new ArrayList<>(Arrays.asList(985 + xFirstThree, 985 + xFirstThree, 985 + xFirstThree, 950 + xSecondThree, 950 + xSecondThree, 950 + xSecondThree, 1020 + xLastTwo, 1020 + xLastTwo)), // x values
                new ArrayList<>(Arrays.asList(855,885,915,855,885,915,845,885)))); // y values
        // connecticut avenue
        xFirstThree  -= 75;
        xSecondThree -= 80;
        xLastTwo     -= 75;

        locationHashMap.put(BoardSpaceElement.CONNECTICUT_AVENUE, new TokenBoardLocation(new ArrayList<>(Arrays.asList(985 + xFirstThree, 985 + xFirstThree, 985 + xFirstThree, 950 + xSecondThree, 950 + xSecondThree, 950 + xSecondThree, 1020 + xLastTwo, 1020 + xLastTwo)), // x values
                new ArrayList<>(Arrays.asList(855,885,915,855,885,915,845,885)))); // y values
        // just visiting jail
        xSecondThree -= 120;
        xLastTwo     -= 75;
        yFirstThree  -= 45;

        locationHashMap.put(BoardSpaceElement.JUST_VISITING_JAIL, new TokenBoardLocation(new ArrayList<>(Arrays.asList(985 + xFirstThree - 145, 985 + xFirstThree - 145, 985 + xFirstThree - 110, 950 + xSecondThree, 950 + xSecondThree, 950 + xSecondThree, 1020 + xLastTwo - 30, 1020 + xLastTwo)), // x values
                new ArrayList<>(Arrays.asList(855 + 45,885 + 40,915,855 - 35,885 + yFirstThree,915 + yFirstThree,845 + 65,885 + 20)))); // y values
        // st charles place
        XAll -= 100;
        YAll -= 120;

        locationHashMap.put(BoardSpaceElement.ST_CHARLES_PLACE, new TokenBoardLocation(new ArrayList<>(Arrays.asList(256 + XAll, 265 + XAll, 265 + XAll, 240 + XAll, 240 + XAll, 240 + XAll, 290 + XAll, 290 + XAll)), // x values
                new ArrayList<>(Arrays.asList(855 + YAll + 10,885 + YAll,915 + YAll,855 + YAll + 10,885 + YAll,915 + YAll,845 + YAll + 10,885 + YAll)))); // y values
        // electric company
        YAll -= 75;

        locationHashMap.put(BoardSpaceElement.ELECTRIC_COMPANY, new TokenBoardLocation(new ArrayList<>(Arrays.asList(256 + XAll, 265 + XAll, 265 + XAll, 240 + XAll, 240 + XAll, 240 + XAll, 290 + XAll, 290 + XAll)), // x values
                new ArrayList<>(Arrays.asList(855 + YAll + 10,885 + YAll,915 + YAll,855 + YAll + 10,885 + YAll,915 + YAll,845 + YAll + 10,885 + YAll)))); // y values
        // states avenue
        YAll -= 85;

        locationHashMap.put(BoardSpaceElement.STATES_AVENUE, new TokenBoardLocation(new ArrayList<>(Arrays.asList(256 + XAll, 265 + XAll, 265 + XAll, 240 + XAll, 240 + XAll, 240 + XAll, 290 + XAll, 290 + XAll)), // x values
                new ArrayList<>(Arrays.asList(855 + YAll + 10,885 + YAll,915 + YAll,855 + YAll + 10,885 + YAll,915 + YAll,845 + YAll + 10,885 + YAll)))); // y values
        // virginia avenue
        YAll -= 75;

        locationHashMap.put(BoardSpaceElement.VIRGINIA_AVENUE, new TokenBoardLocation(new ArrayList<>(Arrays.asList(256 + XAll, 265 + XAll, 265 + XAll, 240 + XAll, 240 + XAll, 240 + XAll, 290 + XAll, 290 + XAll)), // x values
                new ArrayList<>(Arrays.asList(855 + YAll + 10,885 + YAll,915 + YAll,855 + YAll + 10,885 + YAll,915 + YAll,845 + YAll + 10,885 + YAll)))); // y values
        // pennsylvania railroad
        YAll -= 75;

        locationHashMap.put(BoardSpaceElement.PENNSYLVANIA_RAILROAD, new TokenBoardLocation(new ArrayList<>(Arrays.asList(256 + XAll, 265 + XAll, 265 + XAll, 240 + XAll, 240 + XAll, 240 + XAll, 290 + XAll, 290 + XAll)), // x values
                new ArrayList<>(Arrays.asList(855 + YAll + 10,885 + YAll,915 + YAll,855 + YAll + 10,885 + YAll,915 + YAll,845 + YAll + 10,885 + YAll)))); // y values
        // st james avenue
        YAll -= 80;

        locationHashMap.put(BoardSpaceElement.ST_JAMES_PLACE, new TokenBoardLocation(new ArrayList<>(Arrays.asList(256 + XAll, 265 + XAll, 265 + XAll, 240 + XAll, 240 + XAll, 240 + XAll, 290 + XAll, 290 + XAll)), // x values
                new ArrayList<>(Arrays.asList(855 + YAll + 10,885 + YAll,915 + YAll,855 + YAll + 10,885 + YAll,915 + YAll,845 + YAll + 10,885 + YAll)))); // y values
        // community chest
        YAll -= 80;

        locationHashMap.put(BoardSpaceElement.COMMUNITY_CHEST2, new TokenBoardLocation(new ArrayList<>(Arrays.asList(256 + XAll, 265 + XAll, 265 + XAll, 240 + XAll, 240 + XAll, 240 + XAll, 290 + XAll, 290 + XAll)), // x values
                new ArrayList<>(Arrays.asList(855 + YAll + 10,885 + YAll,915 + YAll,855 + YAll + 10,885 + YAll,915 + YAll,845 + YAll + 10,885 + YAll)))); // y values
        // tennessee avenue
        YAll -= 80;

        locationHashMap.put(BoardSpaceElement.TENNESSEE_AVENUE, new TokenBoardLocation(new ArrayList<>(Arrays.asList(256 + XAll, 265 + XAll, 265 + XAll, 240 + XAll, 240 + XAll, 240 + XAll, 290 + XAll, 290 + XAll)), // x values
                new ArrayList<>(Arrays.asList(855 + YAll + 10,885 + YAll,915 + YAll,855 + YAll + 10,885 + YAll,915 + YAll,845 + YAll + 10,885 + YAll)))); // y values
        // new york avenue
        YAll -= 80;

        locationHashMap.put(BoardSpaceElement.NEW_YORK_AVENUE, new TokenBoardLocation(new ArrayList<>(Arrays.asList(256 + XAll, 265 + XAll, 265 + XAll, 240 + XAll, 240 + XAll, 240 + XAll, 290 + XAll, 290 + XAll)), // x values
                new ArrayList<>(Arrays.asList(855 + YAll + 10,885 + YAll,915 + YAll,855 + YAll + 10,885 + YAll,915 + YAll,845 + YAll + 10,885 + YAll)))); // y values
        // free parking
        YAll -= 100;

        locationHashMap.put(BoardSpaceElement.FREE_PARKING, new TokenBoardLocation(new ArrayList<>(Arrays.asList(256 + XAll, 265 + XAll, 265 + XAll, 240 + XAll, 240 + XAll, 240 + XAll, 290 + XAll, 290 + XAll)), // x values
                new ArrayList<>(Arrays.asList(855 + YAll + 10,885 + YAll,915 + YAll,855 + YAll + 10,885 + YAll,915 + YAll,845 + YAll + 10,885 + YAll)))); // y values
        // kentucky avenue
        XAll += 100;

        locationHashMap.put(BoardSpaceElement.KENTUCKY_AVENUE, new TokenBoardLocation(new ArrayList<>(Arrays.asList(256 + XAll, 265 + XAll, 265 + XAll, 240 + XAll, 240 + XAll, 240 + XAll, 290 + XAll, 290 + XAll)), // x values
                new ArrayList<>(Arrays.asList(855 + YAll + 10,885 + YAll,915 + YAll,855 + YAll + 10,885 + YAll,915 + YAll,845 + YAll + 10,885 + YAll)))); // y values
        // chance
        XAll += 80;

        locationHashMap.put(BoardSpaceElement.CHANCE2, new TokenBoardLocation(new ArrayList<>(Arrays.asList(256 + XAll, 265 + XAll, 265 + XAll, 240 + XAll, 240 + XAll, 240 + XAll, 290 + XAll, 290 + XAll)), // x values
                new ArrayList<>(Arrays.asList(855 + YAll + 10,885 + YAll,915 + YAll,855 + YAll + 10,885 + YAll,915 + YAll,845 + YAll + 10,885 + YAll)))); // y values
        // indiana avenue
        XAll += 80;

        locationHashMap.put(BoardSpaceElement.INDIANA_AVENUE, new TokenBoardLocation(new ArrayList<>(Arrays.asList(256 + XAll, 265 + XAll, 265 + XAll, 240 + XAll, 240 + XAll, 240 + XAll, 290 + XAll, 290 + XAll)), // x values
                new ArrayList<>(Arrays.asList(855 + YAll + 10,885 + YAll,915 + YAll,855 + YAll + 10,885 + YAll,915 + YAll,845 + YAll + 10,885 + YAll)))); // y values
        // illinois avenue
        XAll += 80;

        locationHashMap.put(BoardSpaceElement.ILLINOIS_AVENUE, new TokenBoardLocation(new ArrayList<>(Arrays.asList(256 + XAll, 265 + XAll, 265 + XAll, 240 + XAll, 240 + XAll, 240 + XAll, 290 + XAll, 290 + XAll)), // x values
                new ArrayList<>(Arrays.asList(855 + YAll + 10,885 + YAll,915 + YAll,855 + YAll + 10,885 + YAll,915 + YAll,845 + YAll + 10,885 + YAll)))); // y values
        // b&o railroad
        XAll += 80;

        locationHashMap.put(BoardSpaceElement.B_AND_O_RAILROAD, new TokenBoardLocation(new ArrayList<>(Arrays.asList(256 + XAll, 265 + XAll, 265 + XAll, 240 + XAll, 240 + XAll, 240 + XAll, 290 + XAll, 290 + XAll)), // x values
                new ArrayList<>(Arrays.asList(855 + YAll + 10,885 + YAll,915 + YAll,855 + YAll + 10,885 + YAll,915 + YAll,845 + YAll + 10,885 + YAll)))); // y values
        // atlantic avenue
        XAll += 70;

        locationHashMap.put(BoardSpaceElement.ATLANTIC_AVENUE, new TokenBoardLocation(new ArrayList<>(Arrays.asList(256 + XAll, 265 + XAll, 265 + XAll, 240 + XAll, 240 + XAll, 240 + XAll, 290 + XAll, 290 + XAll)), // x values
                new ArrayList<>(Arrays.asList(855 + YAll + 10,885 + YAll,915 + YAll,855 + YAll + 10,885 + YAll,915 + YAll,845 + YAll + 10,885 + YAll)))); // y values
        // water works
        XAll += 80;

        locationHashMap.put(BoardSpaceElement.WATER_WORKS, new TokenBoardLocation(new ArrayList<>(Arrays.asList(256 + XAll, 265 + XAll, 265 + XAll, 240 + XAll, 240 + XAll, 240 + XAll, 290 + XAll, 290 + XAll)), // x values
                new ArrayList<>(Arrays.asList(855 + YAll + 10,885 + YAll,915 + YAll,855 + YAll + 10,885 + YAll,915 + YAll,845 + YAll + 10,885 + YAll)))); // y values
        // ventnor avenue
        XAll += 80;

        locationHashMap.put(BoardSpaceElement.VENTNOR_AVENUE, new TokenBoardLocation(new ArrayList<>(Arrays.asList(256 + XAll, 265 + XAll, 265 + XAll, 240 + XAll, 240 + XAll, 240 + XAll, 290 + XAll, 290 + XAll)), // x values
                new ArrayList<>(Arrays.asList(855 + YAll + 10,885 + YAll,915 + YAll,855 + YAll + 10,885 + YAll,915 + YAll,845 + YAll + 10,885 + YAll)))); // y values
        // marvin gardens
        XAll += 80;

        locationHashMap.put(BoardSpaceElement.MARVIN_GARDENS, new TokenBoardLocation(new ArrayList<>(Arrays.asList(256 + XAll, 265 + XAll, 265 + XAll, 240 + XAll, 240 + XAll, 240 + XAll, 290 + XAll, 290 + XAll)), // x values
                new ArrayList<>(Arrays.asList(855 + YAll + 10,885 + YAll,915 + YAll,855 + YAll + 10,885 + YAll,915 + YAll,845 + YAll + 10,885 + YAll)))); // y values
        // go to jail
        XAll += 110;

        locationHashMap.put(BoardSpaceElement.GO_TO_JAIL, new TokenBoardLocation(new ArrayList<>(Arrays.asList(256 + XAll, 265 + XAll, 265 + XAll, 240 + XAll, 240 + XAll, 240 + XAll, 290 + XAll, 290 + XAll)), // x values
                new ArrayList<>(Arrays.asList(855 + YAll + 10,885 + YAll,915 + YAll,855 + YAll + 10,885 + YAll,915 + YAll,845 + YAll + 10,885 + YAll)))); // y values
        // pacific avenue
        YAll += 105;

        locationHashMap.put(BoardSpaceElement.PACIFIC_AVENUE, new TokenBoardLocation(new ArrayList<>(Arrays.asList(256 + XAll, 265 + XAll, 265 + XAll, 240 + XAll, 240 + XAll, 240 + XAll, 290 + XAll, 290 + XAll)), // x values
                new ArrayList<>(Arrays.asList(855 + YAll + 10,885 + YAll,915 + YAll,855 + YAll + 10,885 + YAll,915 + YAll,845 + YAll + 10,885 + YAll)))); // y values
        // north carolina avenue
        YAll += 70;

        locationHashMap.put(BoardSpaceElement.NORTH_CAROLINA_AVENUE, new TokenBoardLocation(new ArrayList<>(Arrays.asList(256 + XAll, 265 + XAll, 265 + XAll, 240 + XAll, 240 + XAll, 240 + XAll, 290 + XAll, 290 + XAll)), // x values
                new ArrayList<>(Arrays.asList(855 + YAll + 10,885 + YAll,915 + YAll,855 + YAll + 10,885 + YAll,915 + YAll,845 + YAll + 10,885 + YAll)))); // y values
        // community chest
        YAll += 80;

        locationHashMap.put(BoardSpaceElement.COMMUNITY_CHEST3, new TokenBoardLocation(new ArrayList<>(Arrays.asList(256 + XAll, 265 + XAll, 265 + XAll, 240 + XAll, 240 + XAll, 240 + XAll, 290 + XAll, 290 + XAll)), // x values
                new ArrayList<>(Arrays.asList(855 + YAll + 10,885 + YAll,915 + YAll,855 + YAll + 10,885 + YAll,915 + YAll,845 + YAll + 10,885 + YAll)))); // y values
        // pennsylvania avenue
        YAll += 80;

        locationHashMap.put(BoardSpaceElement.PENNSYLVANIA_AVENUE, new TokenBoardLocation(new ArrayList<>(Arrays.asList(256 + XAll, 265 + XAll, 265 + XAll, 240 + XAll, 240 + XAll, 240 + XAll, 290 + XAll, 290 + XAll)), // x values
                new ArrayList<>(Arrays.asList(855 + YAll + 10,885 + YAll,915 + YAll,855 + YAll + 10,885 + YAll,915 + YAll,845 + YAll + 10,885 + YAll)))); // y values
        // short line
        YAll += 80;

        locationHashMap.put(BoardSpaceElement.SHORT_LINE_RAILROAD, new TokenBoardLocation(new ArrayList<>(Arrays.asList(256 + XAll, 265 + XAll, 265 + XAll, 240 + XAll, 240 + XAll, 240 + XAll, 290 + XAll, 290 + XAll)), // x values
                new ArrayList<>(Arrays.asList(855 + YAll + 10,885 + YAll,915 + YAll,855 + YAll + 10,885 + YAll,915 + YAll,845 + YAll + 10,885 + YAll)))); // y values
        // chance
        YAll += 80;

        locationHashMap.put(BoardSpaceElement.CHANCE3, new TokenBoardLocation(new ArrayList<>(Arrays.asList(256 + XAll, 265 + XAll, 265 + XAll, 240 + XAll, 240 + XAll, 240 + XAll, 290 + XAll, 290 + XAll)), // x values
                new ArrayList<>(Arrays.asList(855 + YAll + 10,885 + YAll,915 + YAll,855 + YAll + 10,885 + YAll,915 + YAll,845 + YAll + 10,885 + YAll)))); // y values
        // park place
        YAll += 75;

        locationHashMap.put(BoardSpaceElement.PARK_PLACE, new TokenBoardLocation(new ArrayList<>(Arrays.asList(256 + XAll, 265 + XAll, 265 + XAll, 240 + XAll, 240 + XAll, 240 + XAll, 290 + XAll, 290 + XAll)), // x values
                new ArrayList<>(Arrays.asList(855 + YAll + 10,885 + YAll,915 + YAll,855 + YAll + 10,885 + YAll,915 + YAll,845 + YAll + 10,885 + YAll)))); // y values
        // luxury tax
        YAll += 75;

        locationHashMap.put(BoardSpaceElement.LUXURY_TAX, new TokenBoardLocation(new ArrayList<>(Arrays.asList(256 + XAll, 265 + XAll, 265 + XAll, 240 + XAll, 240 + XAll, 240 + XAll, 290 + XAll, 290 + XAll)), // x values
                new ArrayList<>(Arrays.asList(855 + YAll + 10,885 + YAll,915 + YAll,855 + YAll + 10,885 + YAll,915 + YAll,845 + YAll + 10,885 + YAll)))); // y values
        // board walk
        YAll += 80;

        locationHashMap.put(BoardSpaceElement.BOARDWALK, new TokenBoardLocation(new ArrayList<>(Arrays.asList(256 + XAll, 265 + XAll, 265 + XAll, 240 + XAll, 240 + XAll, 240 + XAll, 290 + XAll, 290 + XAll)), // x values
                new ArrayList<>(Arrays.asList(855 + YAll + 10,885 + YAll,915 + YAll,855 + YAll + 10,885 + YAll,915 + YAll,845 + YAll + 10,885 + YAll)))); // y values
    }

    // todo - add a overloaded method for moveToken that takes in a player token and a number to increment token by
}
