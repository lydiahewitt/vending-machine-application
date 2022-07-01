package com.techelevator;

import com.techelevator.products.Money;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class MoneyTest {
    @Test
    public void getChange_EightDollars_Should_Return_32Quarters(){
        // arrange
        Money money = new Money();
        BigDecimal cash = BigDecimal.valueOf(8);
        String expected = "Your change is 32 quarters, 0 dimes, 0 nickels.";

        // act
        String actual = money.getChange(cash);

        // assert

        String message = String.format( actual, expected);
        assertEquals(message,expected, actual);

    }

    @Test
    public void getChange_SevenSixtyFive_Should_Return_34Quarters_1Dime_1Nickel(){
        // arrange
        Money money = new Money();
        BigDecimal cash = BigDecimal.valueOf(8.65);
        String expected = "Your change is 34 quarters, 1 dimes, 1 nickels.";

        // act
        String actual = money.getChange(cash);

        // assert

        String message = String.format( actual, expected);
        assertEquals(message,expected, actual);

    }
    @Test
    public void getChange_Zero_Should_Return_0Quarters_0Dime_0Nickel(){
        // arrange
        Money money = new Money();
        BigDecimal cash = BigDecimal.valueOf(0);
        String expected = "Your change is 0 quarters, 0 dimes, 0 nickels.";

        // act
        String actual = money.getChange(cash);

        // assert

        String message = String.format( actual, expected);
        assertEquals(message,expected, actual);

    }
}

