package com.techelevator.application;

import com.techelevator.file_io.FileProductLoader;
import com.techelevator.products.Product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ItemStock {

    private static List<Product> itemsList;
    private static Map<String, Product> vendingMachineItems = new HashMap<>();

    public static List<Product> getProducts() {
        return itemsList;
    }

    public ItemStock() {
        FileProductLoader loader = new FileProductLoader();
        itemsList = loader.getProducts();
        for (Product product: itemsList) {
          //  int quantity = 5;
            vendingMachineItems.put(product.getSlotLocation(), product);

        }
    }

// creating a map of the products in the machine

    public static Map<String, Product> getVendingMachineItems() {
        return vendingMachineItems;
    }
    public static Product findProduct(String stockId){
        return vendingMachineItems.get(stockId);
    }

    public static Product purchaseProduct(String stockId) {
        Product current = findProduct(stockId);
        current.purchaseItem();
//        Product updateProduct = new Product(current.getSlotLocation()
//                , current.getName()
//                , current.getPrice()
//                , current.getType()
//                , current.getQuantity()-1);
//
//        vendingMachineItems.put(stockId, updateProduct);
        return current;

    }






}
