package com.techelevator.application;

import com.techelevator.file_io.FileProductLoader;
import com.techelevator.products.Product;
import com.techelevator.ui.UserInput;
import com.techelevator.ui.UserOutput;
import com.techelevator.application.ItemStock;

import java.math.BigDecimal;
import java.util.List;

public class VendingMachineApplication {

/*
The vending machine application is the main application.
 */

    ItemStock inventory = new ItemStock();
    BigDecimal paymentInput = BigDecimal.ZERO;

    public void run() {

        while (true) {
            // todo: display home screen

            // todo: and get user choice
            String userChoice = UserInput.getHomeScreenOption();

            if (userChoice.equalsIgnoreCase("display")) {
                // todo: logic to display all vending machine items
                displayItems();

            } else if (userChoice.equalsIgnoreCase("purchase")) {
                // todo: logic to display purchase options
                while (true) {
                    String purchaseChoice = UserInput.getPurchaseScreenOption();
                    if (purchaseChoice.equals("Feed Money")) {
                        feedMoney();
                    } else if (purchaseChoice.equals("Select Product")) {
                        selectProduct();
                    } else if (purchaseChoice.equals("Finish Transaction")) {
                        finishTransaction();
                        break;
                    }
                }

            } else if (userChoice.equalsIgnoreCase("exit")) {
                // break out of the loop and end the application
                break;
            }
        }
    }

    public void displayItems() {
        UserOutput.displayInventory(inventory);
    }

    public void makeAPurchase() {
        String chosenProductLocation = UserInput.getSelectedProduct();
        //reduce quantity
        ItemStock.getVendingMachineItems().put(chosenProductLocation, ItemStock.getVendingMachineItems().get(chosenProductLocation) - 1);
        //give change
        BigDecimal chosenProductPrice = BigDecimal.ZERO;
        for (Product product : ItemStock.getProducts()) {
            if (product.getSlotLocation().equals(chosenProductLocation)) {
                chosenProductPrice = product.getPrice();
            }
        }
        paymentInput = paymentInput.add(UserInput.getCash());
        BigDecimal change = paymentInput.subtract(chosenProductPrice);
    }

    public void feedMoney() {
        paymentInput = paymentInput.add(UserInput.getCash());
        System.out.println("Current Money Provided: $" + paymentInput);
    }

    public String selectProduct() {
        String chosenProductLocation = UserInput.getSelectedProduct();
        return chosenProductLocation;
    }

    public void finishTransaction() {
        BigDecimal chosenProductPrice = BigDecimal.ZERO;
        for (Product product : ItemStock.getProducts()) {
            if (product.getSlotLocation().equals(selectProduct())) {
                chosenProductPrice = product.getPrice();
            }
        }
    }

}
