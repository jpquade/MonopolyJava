package GUI;

import Enums.Chance;
import Enums.CommunityChest;
import Misc.PlayerProcessing;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class DrawCardGUI {

    private final LinkedList<Chance> chanceCards;
    private final LinkedList<CommunityChest> communityChestCards;

    private final ArrayList<JLabel> chanceLabelList;
    private final ArrayList<JLabel> communityChestLabelList;

    private JLayeredPane cardPane;

    public DrawCardGUI(JLayeredPane pane) throws IOException {

        chanceCards = new LinkedList<>();
        chanceCards.addAll(Arrays.asList(Chance.values()));

        communityChestCards = new LinkedList<>();
        communityChestCards.addAll(Arrays.asList(CommunityChest.values()));
//        for(String card : communityChestCards){
//            this.communityChestCards.add(card);
//        }

        //this.communityChestCards = communityChestCards;

        this.chanceLabelList = new ArrayList<>();
        this.communityChestLabelList = new ArrayList<>();

        Collections.shuffle(chanceCards);
        Collections.shuffle(communityChestCards);
        //shuffleCards(chanceCards);
        //shuffleCards(communityChestCards);

        // cardsList will be used to add the name of each card to the label
        LinkedList<String> cardsList = new LinkedList<>();

        for(Chance card : chanceCards){
            cardsList.add(STR."ChanceList/Chance_\{card.toString()}");
        }

        guiSetup(cardsList, pane, chanceLabelList);

        cardsList.clear();

        for(CommunityChest card : communityChestCards){
            cardsList.add(STR."CommunityChestList/Community_Chest_\{card.toString()}");
        }

        guiSetup(cardsList, pane, communityChestLabelList);

        InvisibleOverLayButtonGUI chanceInvisibleButton = new InvisibleOverLayButtonGUI(cardPane, chanceLabelList);
        InvisibleOverLayButtonGUI communityChestInvisibleButton = new InvisibleOverLayButtonGUI(cardPane, communityChestLabelList);

        pane.add(chanceInvisibleButton);
        pane.add(communityChestInvisibleButton);

    }

    private void guiSetup(LinkedList<String> cards, JLayeredPane pane, ArrayList<JLabel> labelList) throws IOException {

        int imageWidth = 350;
        int imageHeight = 200;

        // layered pane for chance/community chest cards
        cardPane = new JLayeredPane();
        cardPane.setVisible(false);     // set this cardPane.setVisible() and labellist.get(i).setVisible() both to true, these are on two separate lines
        pane.add(cardPane, JLayeredPane.POPUP_LAYER);
        cardPane.setBounds(450,350,imageWidth,imageHeight);

        for (int i = 0; i < cards.size();i++) {
            String card = cards.get(i);

            String s = STR."src/MonopolyImages/\{card}.png";
            BufferedImage image = ImageIO.read(new File(s));
            labelList.add(new JLabel(new ImageIcon(image.getScaledInstance(imageWidth, imageHeight, Image.SCALE_DEFAULT))));

            //label.get(i).setBounds(420, 350, imageWidth, imageHeight);
            labelList.get(i).setBounds(0, 0, imageWidth, imageHeight);
            labelList.get(i).setVisible(false);
            cardPane.add(labelList.get(i), JLayeredPane.DEFAULT_LAYER);

            //pane.add(label.get(i), JLayeredPane.DRAG_LAYER);

        }
    }

//    private void shuffleCards(LinkedList<String> cards){
//
//        Collections.shuffle(cards);
//
//    }

//    public String drawACard(String card, Player player, LocationProcessor locationProcessor, RaiseMoney raiseMoney,
//                            LinkedHashMap<String, PropertyAttributes> propertyAttributes, NumberValueCheck numberValueCheck,
//                            LinkedHashMap<String, PropertyFinancials> propertyFinancials, ArrayList<Player> playerList, Scanner scanner,
//                            JLabel label, JButton overLayButton){

    public String drawAChanceCard(JLabel label, JButton overLayButton, PlayerProcessing playerProcessing){

        cardPane.setVisible(true);
        label.setVisible(true);
        switch(chanceCards.peek()) {
            case Chance.ADVANCE_TO_BOARDWALK:
                overLayButton.setVisible(true);
                chanceLabelList.get(0).setVisible(true);
                //playerProcessing.movePlayerToLocation( 39);
                break;
            case Chance.ADVANCE_TO_GO:
                //locationProcessor.locationProcessing(player, 0);
                break;
            case Chance.ATIA:
                //locationProcessor.locationProcessing(player, 24);
                break;
            case Chance.ATSCP:
                //locationProcessor.locationProcessing(player, 11);
                break;
            case Chance.ATTNR:
//                    int rrLocation;
//
//                    if(player.getBoardLocation() == 7) rrLocation = 15;
//                    else if(player.getBoardLocation() == 22) rrLocation = 35;
//                    else rrLocation = 5;
//
//                    locationProcessor.locationProcessing(player, rrLocation, 2);
                break;
            case Chance.ATTNU:
//                    int utilityLocation;

//                    if(player.getBoardLocation()  == 7) utilityLocation = 12;
//                    else if(player.getBoardLocation()  == 22) utilityLocation = 28;
//                    else utilityLocation = 12;
//
//                    locationProcessor.locationProcessing(player, utilityLocation, 10);

                break;
            case Chance.BPYD:
                //player.setCash(player.getCash() + 50);
                break;
            case Chance.GB3S:
                //locationProcessor.locationProcessing(player, player.getBoardLocation() - 3);
                break;
            case Chance.GOOJF:

//                    player.setGetOutOfJailFreeCount(player.getGetOutOfJailFreeCount() + 1);
//                    player.setChanceGetOutOfJailFreeCount(player.getChanceGetOutOfJailFreeCount() + 1);
                break;
            case Chance.GTJ:

                // go to jail logic
                //locationProcessor.locationProcessing(player, 40);
                break;
            case Chance.MGR:
//                    int totalImprovementCost = player.getTotalHotels() * 100 + player.getTotalHotels() * 25;
//                    if(player.getCash() < totalImprovementCost) raiseMoney.raiseMoneyOptions(player, propertyAttributes,
//                            numberValueCheck, propertyFinancials, playerList, scanner);
//
//                    player.setCash(player.getCash() - totalImprovementCost);
                break;
            case Chance.PPT:
//                    int poorTax = 15;
//
//                    if(player.getCash() < poorTax) raiseMoney.raiseMoneyOptions(player, propertyAttributes,
//                            numberValueCheck, propertyFinancials, playerList, scanner);
//                    player.setCash(player.getCash() - poorTax);
                break;
            case Chance.TAROTR:
                // if pass go collect 200
//                    locationProcessor.locationProcessing(player, 5);
                break;
            case Chance.YBALM:
//                    player.setCash(player.getCash() + 150);
                break;
            case Chance.YHBAECOTB:
//                    int playerCount = 0;
//
//                    for(int i = 0; i < playerList.size(); i++){
//                        Player tempPlayer = playerList.get(i);
//
//                        if(!tempPlayer.isBankrupt() && tempPlayer.getPlayerToken() != player.getToken()) playerCount++;
//                    }
//
//                    int chairmanMoney = playerCount * 50;
//
//                    if(player.getCash() < chairmanMoney) raiseMoney.raiseMoneyOptions(player, propertyAttributes,
//                            numberValueCheck, propertyFinancials, playerList, scanner);
//                    player.setCash(player.getCash() - chairmanMoney);
//                    for (Player tempPlayer : playerList) {
//                        if (!tempPlayer.isBankrupt() && tempPlayer.getPlayerToken() != player.getToken())
//                            tempPlayer.setCash(tempPlayer.getCash() + 50);
//                    }
                break;
            case null:
                break;
        }
        return chanceCards.pop().toString();
    }

    public String drawACommunityChestCard(JLabel label, JButton overLayButton){


        return "temp string";
    }
}
