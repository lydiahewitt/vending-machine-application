package com.techelevator.application;

import com.techelevator.file_io.FileProductLoader;
import com.techelevator.file_io.Logger;
import com.techelevator.file_io.SalesReport;
import com.techelevator.products.Money;
import com.techelevator.products.Product;
import com.techelevator.ui.UserInput;
import com.techelevator.ui.UserOutput;
import com.techelevator.application.ItemStock;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VendingMachineApplication {

/*
The vending machine application is the main application.
 */
    Logger logger = new Logger("logs");
    private SalesReport salesReport = new SalesReport("sales");

    ItemStock inventory = new ItemStock();
    BigDecimal paymentInput = BigDecimal.ZERO;
    BigDecimal currentBalance = BigDecimal.ZERO;
    static Map<String, Integer> salesMap = new HashMap<>();
    BigDecimal totalPrice = BigDecimal.ZERO;


    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public static Map<String, Integer> getSalesMap() {
        return salesMap;
    }

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
            } else if (userChoice.equalsIgnoreCase("Sales Report")){
                salesReport.createReport(this);

            }
        }
    }

    public void displayItems() {
        UserOutput.displayInventory(inventory);
    }

    public BigDecimal feedMoney() {
        paymentInput = BigDecimal.ZERO;
        paymentInput = paymentInput.add(UserInput.getCash());
       feedMoney(paymentInput);
        System.out.println("Current Money Provided: $" + currentBalance);
        Logger.logMessage("FEED MONEY: " + "$" + paymentInput + " " + "$" + currentBalance);
        return currentBalance;
    }
    public BigDecimal feedMoney (BigDecimal amount){
        currentBalance = (currentBalance.add(amount));
        return currentBalance;
    }


    public void selectProduct() {


        String chosenProductLocation = UserInput.getSelectedProduct();


        if (!ItemStock.getVendingMachineItems().containsKey(chosenProductLocation)){
            System.out.println("Invalid Stock number");
            System.out.println();
            return;
        }


        if (ItemStock.findProduct(chosenProductLocation).getQuantity() == 0 ){
            System.out.println(chosenProductLocation + " is out of stock");
            System.out.println();
            return;

        }
        if (ItemStock.getVendingMachineItems().get(chosenProductLocation).getPrice().compareTo(currentBalance) == 1) {
            System.out.println("Insert more money");
            System.out.println();
            return;
        }
        Product updateProduct = ItemStock.purchaseProduct(chosenProductLocation);
        if (ItemStock.getVendingMachineItems().get(chosenProductLocation).getPrice().compareTo(currentBalance) == -1 || ItemStock.getVendingMachineItems().get(chosenProductLocation).getPrice().compareTo(currentBalance) == 0 ) {
            currentBalance = currentBalance.subtract(ItemStock.getVendingMachineItems().get(chosenProductLocation).getPrice());
        }
        System.out.println(ItemStock.findProduct(chosenProductLocation).getName() + " "
                + "Price: $" + ItemStock.getVendingMachineItems().get(chosenProductLocation).getPrice() + " "
                + "\nRemaining balance: $" + currentBalance);




         if (updateProduct.getType().equalsIgnoreCase("Chip")){
             System.out.println("Crunch Crunch, Yum!");


             System.out.println(" ");

         } else if (ItemStock.getVendingMachineItems().get(chosenProductLocation).getType().equalsIgnoreCase("Candy")){
             System.out.println("Munch Munch, Yum!");

             System.out.println(" ");

        }else if (ItemStock.getVendingMachineItems().get(chosenProductLocation).getType().equalsIgnoreCase("Drink")){
             System.out.println("Glug Glug, Yum!");

             System.out.println(" ");

         } else if (updateProduct.getType().equalsIgnoreCase("Gum")){
         System.out.println("Chew Chew, Yum!");

             System.out.println(" ");




    }

        totalPrice = totalPrice.add(updateProduct.getPrice());
        if (salesMap.containsKey(updateProduct.getName())){

            salesMap.put(updateProduct.getName(), salesMap.get(updateProduct.getName()) + 1 );

        } else {
            salesMap.put(updateProduct.getName(), 1);
        }

        Logger.logMessage(ItemStock.findProduct(chosenProductLocation).getName() + " " +
                chosenProductLocation + " $" + (currentBalance.add(ItemStock.findProduct(chosenProductLocation).getPrice()))
                + " $" + currentBalance);
    }

    public void finishTransaction() {
        Money.getChange(this.currentBalance);
        Logger.logMessage("GIVE CHANGE: $" + currentBalance + " $0.00");
        currentBalance = BigDecimal.ZERO;
        paymentInput = BigDecimal.ZERO;
    }


}
