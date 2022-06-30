package com.techelevator.application;

import com.techelevator.file_io.FileProductLoader;
import com.techelevator.products.Product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ItemStock {

    private static List<Product> itemsList;
    private static Map<String, Integer> vendingMachineItems = new HashMap<>();

    public static List<Product> getProducts() {
        return itemsList;
    }

    public ItemStock() {
        FileProductLoader loader = new FileProductLoader();
        itemsList = loader.getProducts();
        for (Product product: itemsList) {
            int quantity = 5;
            vendingMachineItems.put(product.getSlotLocation(), quantity);
        }
    }

// creating a map of the products in the machine

    public static Map<String, Integer> getVendingMachineItems() {
        return vendingMachineItems;
    }







}