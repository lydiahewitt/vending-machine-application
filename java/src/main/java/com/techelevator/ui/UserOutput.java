package com.techelevator.ui;

import com.techelevator.application.ItemStock;
import com.techelevator.products.Product;

public class UserOutput {

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void displayMessage(String message)
    {
        System.out.println();
        System.out.println(message);
        System.out.println();
    }

    public static void displayInventory(ItemStock inventory)
    {
        clearScreen();

        System.out.println();
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("                              Vending Machine Items");
        System.out.println("--------------------------------------------------------------------------");
        System.out.println();

        for(Product product: inventory.getProducts())
        {
            System.out.println(product.toString());
        }
        System.out.println();
    }
}
