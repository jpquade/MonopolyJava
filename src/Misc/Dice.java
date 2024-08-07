package Misc;

import java.util.concurrent.ThreadLocalRandom;

public class Dice {

    private int diceOne;
    private int diceTwo;

    public Dice(){
        diceOne = 0;
        diceTwo = 0;
    }

    public void roll(){
        System.out.println("Rolling dice...");

        // sets dice to random number between 1 and 6 inclusive
        diceOne = ThreadLocalRandom.current().nextInt(1, 6 + 1);

        diceTwo = ThreadLocalRandom.current().nextInt(1, 6 + 1);

//        enabled while debugging
//        diceOne = 2;
//        diceTwo = 2;

        System.out.println(STR."Dice 1: \{diceOne}");
        System.out.println(STR."Dice 2: \{diceTwo}");
    }

    public int getDiceOne() {
        return diceOne;
    }

    public void setDiceOne(int diceOne) {
        this.diceOne = diceOne;
    }

    public int getDiceTwo() {
        return diceTwo;
    }

    public void setDiceTwo(int diceTwo) {
        this.diceTwo = diceTwo;
    }
}
