package main.GUI;

import main.Enums.PlayerToken;
import main.Functions.Player;
import main.Functions.PlayerList;

import javax.swing.*;
import java.awt.*;

public class MoneyGridGUI {
    public JLabel carMoney;
    public JLabel catMoney;
    public JLabel dogMoney;
    public JLabel hatMoney;
    public JLabel ironMoney;
    public JLabel shipMoney;
    public JLabel shoeMoney;
    public JLabel thimbleMoney;

    // money panel tracking
    public MoneyGridGUI(PlayerList playerList, JLayeredPane boardSidePane){
        // money panel tracking settings
        JPanel moneyPanel = new JPanel();
        moneyPanel.setBounds(270, 700, 450, 100);
        //moneyPanel.setBackground();
        moneyPanel.setOpaque(false);
        moneyPanel.setLayout(new GridLayout(2, 8));
        //moneyPanel.setBorder(BorderFactory);
        //moneyPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        moneyPanel.setVisible(true);
        moneyPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        boardSidePane.add(moneyPanel, JLayeredPane.PALETTE_LAYER);

        JLabel car = new JLabel(STR."\{PlayerToken.CAR} $");
        JLabel cat = new JLabel(STR."\{PlayerToken.CAT} $");
        JLabel dog = new JLabel(STR."\{PlayerToken.DOG} $");
        JLabel hat = new JLabel(STR."\{PlayerToken.HAT} $");
        JLabel iron = new JLabel(STR."\{PlayerToken.IRON} $");
        JLabel ship = new JLabel(STR."\{PlayerToken.SHIP} $");
        JLabel shoe = new JLabel(STR."\{PlayerToken.SHOE} $");
        JLabel thimble = new JLabel(STR."\{PlayerToken.THIMBLE} $");
        thimble.setFont(new Font("Arial", Font.BOLD, 10));

        if(playerList.ifPlayerExists(PlayerToken.CAR)){
            carMoney = new JLabel(Integer.toString(playerList.getPlayer(PlayerToken.CAR).getCash()));
        } else{
            carMoney = new JLabel("NA");
        }

        if(playerList.ifPlayerExists(PlayerToken.CAT)){
            catMoney = new JLabel(Integer.toString(playerList.getPlayer(PlayerToken.CAT).getCash()));
        } else{
            catMoney = new JLabel("NA");
        }

        if(playerList.ifPlayerExists(PlayerToken.DOG)){
            dogMoney = new JLabel(Integer.toString(playerList.getPlayer(PlayerToken.DOG).getCash()));
        } else{
            dogMoney = new JLabel("NA");
        }

        if(playerList.ifPlayerExists(PlayerToken.HAT)){
            hatMoney = new JLabel(Integer.toString(playerList.getPlayer(PlayerToken.HAT).getCash()));
        } else{
            hatMoney = new JLabel("NA");
        }

        if(playerList.ifPlayerExists(PlayerToken.IRON)){
            ironMoney = new JLabel(Integer.toString(playerList.getPlayer(PlayerToken.IRON).getCash()));
        } else{
            ironMoney = new JLabel("NA");
        }

        if(playerList.ifPlayerExists(PlayerToken.SHIP)){
            shipMoney = new JLabel(Integer.toString(playerList.getPlayer(PlayerToken.SHIP).getCash()));
        } else{
            shipMoney = new JLabel("NA");
        }

        if(playerList.ifPlayerExists(PlayerToken.SHOE)){
            shoeMoney = new JLabel(Integer.toString(playerList.getPlayer(PlayerToken.SHOE).getCash()));
        } else{
            shoeMoney = new JLabel("NA");
        }

        if(playerList.ifPlayerExists(PlayerToken.THIMBLE)){
            thimbleMoney = new JLabel(Integer.toString(playerList.getPlayer(PlayerToken.THIMBLE).getCash()));
        } else{
            thimbleMoney = new JLabel("NA");
        }

        moneyPanel.add(car);
        moneyPanel.add(carMoney);
        moneyPanel.add(cat);
        moneyPanel.add(catMoney);
        moneyPanel.add(dog);
        moneyPanel.add(dogMoney);
        moneyPanel.add(hat);
        moneyPanel.add(hatMoney);
        moneyPanel.add(iron);
        moneyPanel.add(ironMoney);
        moneyPanel.add(ship);
        moneyPanel.add(shipMoney);
        moneyPanel.add(shoe);
        moneyPanel.add(shoeMoney);
        moneyPanel.add(thimble);
        moneyPanel.add(thimbleMoney);

        System.out.println(STR."Money Panel Components - \{moneyPanel.getComponentCount()}");
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
