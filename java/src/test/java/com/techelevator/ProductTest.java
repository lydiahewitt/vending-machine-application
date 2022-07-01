package com.techelevator;

import com.techelevator.application.VendingMachineApplication;
import com.techelevator.products.Money;
import com.techelevator.products.Product;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class ProductTest {
    @Test
    public void feedMoney_currentBalance(){
        // arrange
        VendingMachineApplication newApplication = new VendingMachineApplication();
        BigDecimal cash = BigDecimal.valueOf(8);
        BigDecimal expected = cash;

        // act
        BigDecimal actual = newApplication.feedMoney(cash);

        // assert


        String message = "$8.00 was added, the expected amount is" + expected;
        assertEquals(expected, actual);

    }

}

