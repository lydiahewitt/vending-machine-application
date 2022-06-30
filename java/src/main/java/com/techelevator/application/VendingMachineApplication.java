package com.techelevator.application;

import com.techelevator.file_io.FileProductLoader;
import com.techelevator.products.Money;
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
    BigDecimal remainingBalance = BigDecimal.ZERO;

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
                        displayItems();
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
       // ItemStock.getVendingMachineItems().put(chosenProductLocation, ItemStock.getVendingMachineItems().get(chosenProductLocation) - 1);
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

    public BigDecimal feedMoney() {
        paymentInput = paymentInput.add(UserInput.getCash());
        System.out.println("Current Money Provided: $" + paymentInput);
        return paymentInput;
    }

    public void selectProduct() {

        String chosenProductLocation = UserInput.getSelectedProduct();
        if (!ItemStock.getVendingMachineItems().containsKey(chosenProductLocation)){
            System.out.println("Invalid Stock number");
        }
        if (ItemStock.getVendingMachineItems().get(chosenProductLocation).getQuantity() == 0 ){

            System.out.println(chosenProductLocation + " is out of stock");
        }
        remainingBalance = paymentInput.subtract(ItemStock.getVendingMachineItems().get(chosenProductLocation).getPrice());
        System.out.println(ItemStock.findProduct(chosenProductLocation).getName() + " "
                + "Price: $" + ItemStock.getVendingMachineItems().get(chosenProductLocation).getPrice() + " "
                + "\nRemaining balance: $" + remainingBalance);
        Product updateProduct = new Product(ItemStock.getVendingMachineItems().get(chosenProductLocation).getSlotLocation(), ItemStock.getVendingMachineItems().get(chosenProductLocation).getName(), ItemStock.getVendingMachineItems().get(chosenProductLocation).getPrice(), ItemStock.getVendingMachineItems().get(chosenProductLocation).getType(), ItemStock.getVendingMachineItems().get(chosenProductLocation).getQuantity() - 1);
         ItemStock.getVendingMachineItems().put(chosenProductLocation, updateProduct);
         if (ItemStock.getVendingMachineItems().get(chosenProductLocation).getType().equalsIgnoreCase("Chip")){
             System.out.println("Crunch Crunch, Yum!");
             System.out.println(" ");

         } else if (ItemStock.getVendingMachineItems().get(chosenProductLocation).getType().equalsIgnoreCase("Candy")){
             System.out.println("Munch Munch, Yum!");
             System.out.println(" ");

        }else if (ItemStock.getVendingMachineItems().get(chosenProductLocation).getType().equalsIgnoreCase("Drink")){
             System.out.println("Glug Glug, Yum!");
             System.out.println(" ");

         } else if (ItemStock.getVendingMachineItems().get(chosenProductLocation).getType().equalsIgnoreCase("Gum")){
         System.out.println("Chew Chew, Yum!");
             System.out.println(" ");

    }
    }

    public void finishTransaction() {
        Money.getChange(this.remainingBalance);
        remainingBalance = BigDecimal.ZERO;
        paymentInput = BigDecimal.ZERO;
    }

}
