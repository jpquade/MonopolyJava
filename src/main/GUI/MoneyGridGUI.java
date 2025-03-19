package main.GUI;

import main.Enums.PlayerToken;
import main.Functions.Player;
import main.Functions.PlayerProcessor;

import javax.swing.*;
import java.awt.*;

public class MoneyGridGUI extends JPanel {
    public JLabel carMoney;
    public JLabel catMoney;
    public JLabel dogMoney;
    public JLabel hatMoney;
    public JLabel ironMoney;
    public JLabel shipMoney;
    public JLabel shoeMoney;
    public JLabel thimbleMoney;

    // money panel tracking
    public MoneyGridGUI(PlayerProcessor playerProcessor, BoardSidePaneGUI boardSidePane) {
        // MoneyGridGUI panel tracking settings
        this.setBounds(270, 700, 450, 100);

        this.setOpaque(false);
        this.setLayout(new GridLayout(2, 8));
        this.setVisible(true);
        this.setAlignmentX(Component.LEFT_ALIGNMENT);
        boardSidePane.add(this, JLayeredPane.PALETTE_LAYER);
        //boardSidePane.add(moneyPanel, JLayeredPane.DRAG_LAYER);


        JLabel car = new JLabel(PlayerToken.CAR + "$");
        JLabel cat = new JLabel(PlayerToken.CAT + "$");
        JLabel dog = new JLabel(PlayerToken.DOG + "$");
        JLabel hat = new JLabel(PlayerToken.HAT + "$");
        JLabel iron = new JLabel(PlayerToken.IRON + "$");
        JLabel ship = new JLabel(PlayerToken.SHIP + "$");
        JLabel shoe = new JLabel(PlayerToken.SHOE + "$");
        JLabel thimble = new JLabel(PlayerToken.THIMBLE + "$");
        thimble.setFont(new Font("Arial", Font.BOLD, 10));

//        carMoney = new JLabel();
//        catMoney = new JLabel();
//        dogMoney = new JLabel();
//        hatMoney = new JLabel();
//        ironMoney = new JLabel();
//        shipMoney = new JLabel();
//        shoeMoney = new JLabel();
//        thimbleMoney = new JLabel();



        if(playerProcessor.ifPlayerExists(PlayerToken.CAR)){
            carMoney = new JLabel(Integer.toString(playerProcessor.getPlayer(PlayerToken.CAR).getCash()));
        } else{
            car.setVisible(false);
            carMoney = new JLabel();
            carMoney.setVisible(false);
        }
        if(playerProcessor.ifPlayerExists(PlayerToken.CAT)){
            catMoney = new JLabel(Integer.toString(playerProcessor.getPlayer(PlayerToken.CAT).getCash()));
        } else{
            cat.setVisible(false);
            catMoney = new JLabel();
            catMoney.setVisible(false);
        }
        if(playerProcessor.ifPlayerExists(PlayerToken.DOG)){
            dogMoney = new JLabel(Integer.toString(playerProcessor.getPlayer(PlayerToken.DOG).getCash()));
        } else{
            dog.setVisible(false);
            dogMoney = new JLabel();
            dogMoney.setVisible(false);
        }
        if(playerProcessor.ifPlayerExists(PlayerToken.HAT)){
            hatMoney = new JLabel(Integer.toString(playerProcessor.getPlayer(PlayerToken.HAT).getCash()));
        } else{
            hat.setVisible(false);
            hatMoney = new JLabel();
            hatMoney.setVisible(false);
        }
        if(playerProcessor.ifPlayerExists(PlayerToken.IRON)){
            ironMoney = new JLabel(Integer.toString(playerProcessor.getPlayer(PlayerToken.IRON).getCash()));
        } else{
            iron.setVisible(false);
            ironMoney = new JLabel();
            ironMoney.setVisible(false);
        }
        if(playerProcessor.ifPlayerExists(PlayerToken.SHIP)){
            shipMoney = new JLabel(Integer.toString(playerProcessor.getPlayer(PlayerToken.SHIP).getCash()));
        } else{
            ship.setVisible(false);
            shipMoney = new JLabel();
            shipMoney.setVisible(false);
        }
        if(playerProcessor.ifPlayerExists(PlayerToken.SHOE)){
            shoeMoney = new JLabel(Integer.toString(playerProcessor.getPlayer(PlayerToken.SHOE).getCash()));
        } else{
            shoe.setVisible(false);
            shoeMoney = new JLabel();
            shoeMoney.setVisible(false);
        }
        if(playerProcessor.ifPlayerExists(PlayerToken.THIMBLE)){
            thimbleMoney = new JLabel(Integer.toString(playerProcessor.getPlayer(PlayerToken.THIMBLE).getCash()));
        } else{
            thimble.setVisible(false);
            thimbleMoney = new JLabel();
            thimbleMoney.setVisible(false);
        }









//        if(playerList.ifPlayerExists(PlayerToken.CAR)) {
//            carMoney.setText(Integer.toString(playerList.getPlayer(PlayerToken.CAR).getCash()));
//            moneyPanel.add(car);
//            moneyPanel.add(carMoney);
//        }
//        if(playerList.ifPlayerExists(PlayerToken.CAT)) {
//            catMoney.setText(Integer.toString(playerList.getPlayer(PlayerToken.CAT).getCash()));
//            moneyPanel.add(cat);
//            moneyPanel.add(catMoney);
//        }
//        if(playerList.ifPlayerExists(PlayerToken.DOG)) {
//            dogMoney.setText(Integer.toString(playerList.getPlayer(PlayerToken.DOG).getCash()));
//            moneyPanel.add(dog);
//            moneyPanel.add(dogMoney);
//        }
//        if(playerList.ifPlayerExists(PlayerToken.HAT)) {
//            hatMoney.setText(Integer.toString(playerList.getPlayer(PlayerToken.HAT).getCash()));
//            moneyPanel.add(hat);
//            moneyPanel.add(hatMoney);
//        }
//        if(playerList.ifPlayerExists(PlayerToken.IRON)) {
//            ironMoney.setText(Integer.toString(playerList.getPlayer(PlayerToken.IRON).getCash()));
//            moneyPanel.add(iron);
//            moneyPanel.add(ironMoney);
//        }
//        if(playerList.ifPlayerExists(PlayerToken.SHIP)) {
//            shipMoney.setText(Integer.toString(playerList.getPlayer(PlayerToken.SHIP).getCash()));
//            moneyPanel.add(ship);
//            moneyPanel.add(shipMoney);
//        }
//        if(playerList.ifPlayerExists(PlayerToken.SHOE)) {
//            shoeMoney.setText(Integer.toString(playerList.getPlayer(PlayerToken.SHOE).getCash()));
//            moneyPanel.add(shoe);
//            moneyPanel.add(shoeMoney);
//        }
//        if(playerList.ifPlayerExists(PlayerToken.THIMBLE)) {
//            thimbleMoney.setText(Integer.toString(playerList.getPlayer(PlayerToken.THIMBLE).getCash()));
//            moneyPanel.add(thimble);
//            moneyPanel.add(thimbleMoney);
//        }
//




        this.add(car);
        this.add(carMoney);
        this.add(cat);
        this.add(catMoney);
        this.add(dog);
        this.add(dogMoney);
        this.add(hat);
        this.add(hatMoney);
        this.add(iron);
        this.add(ironMoney);
        this.add(ship);
        this.add(shipMoney);
        this.add(shoe);
        this.add(shoeMoney);
        this.add(thimble);
        this.add(thimbleMoney);

        System.out.println("Money Panel Components - " + this.getComponentCount());
    }

    public void updateGrid(Player player){
        switch(player.getToken()){
            case CAR:
                carMoney.setText(Integer.toString(player.getCash()));
                break;
            case CAT:
                catMoney.setText(Integer.toString(player.getCash()));
                break;
            case DOG:
                dogMoney.setText(Integer.toString(player.getCash()));
                break;
            case HAT:
                hatMoney.setText(Integer.toString(player.getCash()));
                break;
            case IRON:
                ironMoney.setText(Integer.toString(player.getCash()));
                break;
            case SHIP:
                shipMoney.setText(Integer.toString(player.getCash()));
                break;
            case SHOE:
                shoeMoney.setText(Integer.toString(player.getCash()));
                break;
            case THIMBLE:
                thimbleMoney.setText(Integer.toString(player.getCash()));
                break;
        }
    }

}
