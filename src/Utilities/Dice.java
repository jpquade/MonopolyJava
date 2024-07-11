package Utilities;

import java.util.concurrent.ThreadLocalRandom;

public class Dice {

    private int diceOne;
    private int diceTwo;

    public Dice(){
        diceOne = 0;
        diceTwo = 0;
    }

    public void roll(){
        System.out.println();
        System.out.println("Rolling dice");

        // sets dice to random number between 1 and 6 inclusive
        diceOne = ThreadLocalRandom.current().nextInt(1, 6 + 1);

        diceTwo = ThreadLocalRandom.current().nextInt(1, 6 + 1);

        System.out.println(STR."First Dice Roll:  \{diceOne}");
        System.out.println(STR."Second Dice Roll: \{diceTwo}");
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
