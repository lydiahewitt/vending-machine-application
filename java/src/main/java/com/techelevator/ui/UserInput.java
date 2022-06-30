package com.techelevator.ui;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * Responsibilities:
 *      This class should handle receiving ALL input from the User
 *
 * Dependencies:
 *      None
 */
public class UserInput
{
    private static Scanner scanner = new Scanner(System.in);


    public static String getHomeScreenOption()
    {
        System.out.println("1) Display Vending Machine Items");
        System.out.println("2) Purchase");
        System.out.println("3) Exit");

        System.out.println();
        System.out.print("Please select an option: ");

        String selectedOption = scanner.nextLine();
        String option = selectedOption.trim().toLowerCase();

        if(option.equals("1"))
        {
            return "display";
        }
        else if(option.equals("2"))
        {
            return "purchase";
        }
        else if(option.equals("3"))
        {
            return "exit";
        }
        else
        {
            return "";
        }

    }

    public static String getPurchaseScreenOption()
    {
        System.out.println("1) Feed Money");
        System.out.println("2) Select Product");
        System.out.println("3) Finish Transaction");

        System.out.println();
        System.out.print("Please select an option: ");

        String selectedOption = scanner.nextLine();
        String option = selectedOption.trim().toLowerCase();

        if(option.equals("1"))
        {
            return "Feed Money";
        }
        else if(option.equals("2"))
        {
            return "Select Product";
        }
        else if(option.equals("3"))
        {
            return "Finish Transaction";
        }
        else
        {
            return "";
        }

    }



    public static String getSelectedProduct()
    {
        System.out.print("Enter the slot location: ");
        String productId = scanner.nextLine();

        return productId.toUpperCase().trim();
    }

    public static BigDecimal getCash()
    {
        System.out.print("Enter the payment amount: ");
        String payment = scanner.nextLine().trim();
        BigDecimal paymentAmount = new BigDecimal(payment);
        return paymentAmount;
    }
}
