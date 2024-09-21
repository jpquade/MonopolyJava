package GUI;

import Misc.NumberValueCheck;
import Misc.Player;
import Misc.RaiseMoney;
import Properties.LocationProcessor;
import Properties.PropertyAttributes;
import Properties.PropertyFinancials;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class DrawCardGUI {

    private final LinkedList<String> chanceCards;
    private final LinkedList<String> communityChestCards;

    private final ArrayList<JLabel> chanceLabel;
    private final ArrayList<JLabel> communityChestLabel;

    private InvisibleOverLayButtonGUI chanceInvisibleButton;

    public DrawCardGUI(LinkedList<String> chanceCards, LinkedList<String> communityChestCards, JLayeredPane pane) throws IOException {

        this.chanceCards = chanceCards;
        this.communityChestCards = communityChestCards;

        this.chanceLabel = new ArrayList<>();
        this.communityChestLabel = new ArrayList<>();

        //chanceInvisibleButton = new InvisibleOverLayButtonGUI();

        shuffleCards(chanceCards);
        shuffleCards(communityChestCards);

        guiSetup(chanceCards, pane, chanceLabel);
        guiSetup(communityChestCards, pane, communityChestLabel);
    }

    private void guiSetup(LinkedList<String> cards, JLayeredPane pane, ArrayList<JLabel> labelList) throws IOException {

        int imageWidth = 350;
        int imageHeight = 200;

        // layered pane for chance/community chest cards
        JLayeredPane cardPane = new JLayeredPane();
        cardPane.setVisible(false);
        pane.add(cardPane, JLayeredPane.POPUP_LAYER);
        cardPane.setBounds(450,350,imageWidth,imageHeight);

        for (int i = 0; i < cards.size();i++) {
            String card = cards.get(i);

            String s = "src/MonopolyImages/" + card + ".png";
            BufferedImage image = ImageIO.read(new File(s));
            labelList.add(new JLabel(new ImageIcon(image.getScaledInstance(imageWidth, imageHeight, Image.SCALE_DEFAULT))));

            //label.get(i).setBounds(420, 350, imageWidth, imageHeight);
            labelList.get(i).setBounds(0, 0, imageWidth, imageHeight);
            labelList.get(i).setVisible(false);
            cardPane.add(labelList.get(i), JLayeredPane.DEFAULT_LAYER);

            //pane.add(label.get(i), JLayeredPane.DRAG_LAYER);

        }
    }

    private void shuffleCards(LinkedList<String> cards){

        Collections.shuffle(cards);

    }

    public String drawACard(String card, Player player, LocationProcessor locationProcessor, RaiseMoney raiseMoney,
                            LinkedHashMap<String, PropertyAttributes> propertyAttributes, NumberValueCheck numberValueCheck,
                            LinkedHashMap<String, PropertyFinancials> propertyFinancials, ArrayList<Player> playerList, Scanner scanner,
                            JLabel label, JButton overLayButton){

        if(card.equals("chance")){
            switch(chanceCards.peek()){
                case "Chance_Advance_To_BoardWalk":
                    label.setVisible(true);
                    overLayButton.setVisible(true);

                    chanceLabel.get(0).setVisible(true);
                    locationProcessor.locationProcessing(player, 39);
                    break;
                case "Chance_Advance_To_Go":
                    locationProcessor.locationProcessing(player, 0);
                    break;
                case "Chance_ATIA":
                    locationProcessor.locationProcessing(player, 24);
                    break;
                case "Chance_ATSCP":
                    locationProcessor.locationProcessing(player, 11);
                    break;
                case "Chance_ATTNR":
                    int rrLocation;

                    if(player.getBoardLocation()  == 7) rrLocation = 15;
                    else if(player.getBoardLocation()  == 22) rrLocation = 35;
                    else rrLocation = 5;

                    locationProcessor.locationProcessing(player, rrLocation, 2);
                    break;
                case "Chance_ATTNU":
                    int utilityLocation;

                    if(player.getBoardLocation()  == 7) utilityLocation = 12;
                    else if(player.getBoardLocation()  == 22) utilityLocation = 28;
                    else utilityLocation = 12;

                    locationProcessor.locationProcessing(player, utilityLocation, 10);

                    break;
                case "Chance_BPYD":
                    player.setCash(player.getCash() + 50);
                    break;
                case "Chance_GB3S":
                    locationProcessor.locationProcessing(player, player.getBoardLocation() - 3);
                    break;
                case "Chance_GOOJF":
                    player.setGetOutOfJailFreeCount(player.getGetOutOfJailFreeCount() + 1);
                    player.setChanceGetOutOfJailFreeCount(player.getChanceGetOutOfJailFreeCount() + 1);
                    break;
                case "Chance_GTJ":

                    // go to jail logic
                    locationProcessor.locationProcessing(player, 40);
                    break;
                case "Chance_MGR":
                    int totalImprovementCost = player.getTotalHotels() * 100 + player.getTotalHotels() * 25;
                    if(player.getCash() < totalImprovementCost) raiseMoney.raiseMoneyOptions(player, propertyAttributes,
                            numberValueCheck, propertyFinancials, playerList, scanner);

                    player.setCash(player.getCash() - totalImprovementCost);
                    break;
                case "Chance_PPT":
                    int poorTax = 15;

                    if(player.getCash() < poorTax) raiseMoney.raiseMoneyOptions(player, propertyAttributes,
                            numberValueCheck, propertyFinancials, playerList, scanner);
                    player.setCash(player.getCash() - poorTax);
                    break;
                case "Chance_TOROTR":
                    // if pass go collect 200
                    locationProcessor.locationProcessing(player, 5);
                    break;
                case "Chance_YBALM":
                    player.setCash(player.getCash() + 150);
                    break;
                case "Chance_YHBAECOTB":
                    int playerCount = 0;

                    for(int i = 0; i < playerList.size(); i++){
                        Player tempPlayer = playerList.get(i);

                        if(!tempPlayer.isBankrupt() && tempPlayer.getPlayerToken() != player.getToken()) playerCount++;
                    }

                    int chairmanMoney = playerCount * 50;

                    if(player.getCash() < chairmanMoney) raiseMoney.raiseMoneyOptions(player, propertyAttributes,
                            numberValueCheck, propertyFinancials, playerList, scanner);
                    player.setCash(player.getCash() - chairmanMoney);
                    for(int i = 0; i < playerList.size(); i++){
                        Player tempPlayer = playerList.get(i);

                        if(!tempPlayer.isBankrupt() && tempPlayer.getPlayerToken() != player.getToken()) tempPlayer.setCash(tempPlayer.getCash() + 50);
                    }
                    break;
                case null:
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + chanceCards.peek());
            }

            return chanceCards.pop();
        } else{
            return communityChestCards.pop();
        }
    }
}
