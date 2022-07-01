package com.techelevator.products;

import java.math.BigDecimal;

public class Money {

    BigDecimal change;
    public static String getChange(BigDecimal change) {
        int current = (change.multiply(BigDecimal.valueOf(100))).intValue();
        int quarters = (current/25);
        current -= (quarters * 25);
        int dimes = (current/10);
        current -= (dimes * 10);
        int nickels = (current/5);
        System.out.println("Your change is " + quarters + " quarters, " +
                dimes + " dimes, " + nickels + " nickels.");
        return ("Your change is " + quarters + " quarters, " +
                dimes + " dimes, " + nickels + " nickels.");
    }
}
