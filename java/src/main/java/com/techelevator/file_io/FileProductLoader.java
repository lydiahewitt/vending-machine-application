package com.techelevator.file_io;

import com.techelevator.products.Product;

import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class FileProductLoader
{

    public List<Product> getProducts()
    {
        List<Product> products = new ArrayList<Product>();

        File productsPath = new File("data/vendingmachine.csv");
        try(Scanner fileScanner = new Scanner(productsPath))
        {
            // read one line to skip the header
            fileScanner.nextLine();

            //loop and add each product to the list
            while(fileScanner.hasNextLine())
            {
                String line = fileScanner.nextLine();
                // create the product
                String[] components = line.split("\\|");

                String slotLocation = components[0];
                String name = components[1];
                BigDecimal price = new BigDecimal(components[2]);
                String type = components[3];

                Product product = new Product(slotLocation, name, price, type, 5);

                // add it to the list
                products.add(product);
            }
        }
        catch(Exception ex)
        {

        }

        return products;
    }

}
