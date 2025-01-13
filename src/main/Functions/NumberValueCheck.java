package main.Functions;

import java.util.Scanner;

// set of tools to check if a string is a valid number and if it is in a range
public class NumberValueCheck {

    public NumberValueCheck(){}

    // checks if string contains a valid number
    public boolean notValidNumber(String s) {
        int radix = 10;

        if(s.isEmpty()) return true;
        for(int index = 0; index < s.length(); index++) {
            if(index == 0 && s.charAt(index) == '-') {
                if(s.length() == 1) return true;
                else continue;
            }
            if(Character.digit(s.charAt(index),radix) < 0) return true;
        }
        return false;
    }

    // checks if string converted into number is in a range
    public boolean notInRange(String s, int lo, int hi){
        return lo > Integer.parseInt(s) || Integer.parseInt(s) > hi;
    }

    // checks if valid number and correct range
    private boolean notNumberAndInRange(String s, int lo, int hi){

        return notValidNumber(s) || notInRange(s, lo, hi);
    }

    // checks for a valid entry
    public String validEntry(int lo, int hi, Scanner scanner){

        String userEntry = "";

        do {
            System.out.println();
            System.out.print("Please enter a valid selection:  ");
            userEntry = scanner.nextLine().trim().toLowerCase();
        }
        while (notNumberAndInRange(userEntry, lo, hi));

        return userEntry;
    }
}
