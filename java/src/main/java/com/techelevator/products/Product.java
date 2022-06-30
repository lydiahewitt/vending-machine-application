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
    private int quantity = 5;

    public Product(String slotLocation, String name, BigDecimal price, String type) {
        this.slotLocation = slotLocation;
        this.name = name;
        this.price = price;
        this.type = type;
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

    @Override
    public String toString()
    {
        return slotLocation + " - " + name + " - $" + price + "-" + type + "-" + quantity;
    }

}
