package com.techelevator.file_io;

import com.techelevator.products.Product;

import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



/**
 * Responsibilities:
 *      Read a txt/csv file and convert each line to a product
 *      returns a list of all products found in the file
 *
 * Dependencies:
 *      Product
 */
public class FileProductLoader
{

    public List<Product> getProducts()
    {
        List<Product> products = new ArrayList<Product>();

        File productsPath = new File("data/products.csv");
        try(Scanner fileScanner = new Scanner(productsPath))
        {
            // read one line to skip the header
            fileScanner.nextLine();

            //loop and add each product to the list
            while(fileScanner.hasNextLine())
            {
                String line = fileScanner.nextLine();
                // create the product
                String[] parts = line.split("\\|");

                String id = parts[0];
                String name = parts[1];
                BigDecimal price = new BigDecimal(parts[2]);

                Product product = new Product(id, name, price, type);

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
