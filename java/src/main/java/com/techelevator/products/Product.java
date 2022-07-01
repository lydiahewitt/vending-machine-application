package com.techelevator.products;

import java.math.BigDecimal;

/**
 * Responsibilities:
 *      Knows the id, name, price and type of the product
 */
public class Product
{
    private String slotLocation;
    private String name;
    private BigDecimal price;
    private String type;
    private int quantity;



    public Product(String slotLocation, String name, BigDecimal price, String type, int quantity) {
        this.slotLocation = slotLocation;
        this.name = name;
        this.price = price;
        this.type = type;
        this.quantity = quantity;
    }


    public String getSlotLocation() {
        return slotLocation;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }

    public int getQuantity() {
        return quantity;
    }

    public void purchaseItem(){
        quantity--;
    }


    @Override
    public String toString()
    {
        return slotLocation + " - " + name + " - $" + price + " - " + type + " - " + quantity;
    }

}
