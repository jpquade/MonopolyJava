package main.Functions;

import java.util.concurrent.ThreadLocalRandom;

public class Dice {

    private int diceOne;
    private int diceTwo;
    private final int diceMin;
    private final int diceMax;
    private final int diceOffSetInclusive;

    public Dice(){
        diceOne = 0;
        diceTwo = 0;
        diceMin = 1;
        diceMax = 6;
        diceOffSetInclusive = 1;
    }

    public void roll(){
        System.out.println("Rolling dice...");

        // sets dice to random number between 1 and 6 inclusive
        diceOne = ThreadLocalRandom.current().nextInt(diceMin, diceMax + diceOffSetInclusive);

        diceTwo = ThreadLocalRandom.current().nextInt(diceMin, diceMax + diceOffSetInclusive);

//        enabled while debugging
//        diceOne = 2;
//        diceTwo = 2;

        System.out.println(STR."Dice 1: \{diceOne}");
        System.out.println(STR."Dice 2: \{diceTwo}");
    }

    public int getDiceOne() {
        return diceOne;
    }

    public int getDiceTwo() {
        return diceTwo;
    }
}
