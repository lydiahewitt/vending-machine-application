package com.techelevator.file_io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

import com.techelevator.application.VendingMachineApplication;

/**
 * Responsibilities:
 *      create a new receipt file and add the receipt details
 *
 * Dependencies:
 *      ShoppingCart
 *      Product
 */
public class SalesReport {
    private static final String FILE_EXTENSION = ".log";

    private static String directory;

    public SalesReport(String directory)
    {
        this.directory = directory;
        File folder = new File(directory);
        if(!folder.exists()){
            folder.mkdir();
        }
    }

    public void createReport(VendingMachineApplication vendingMachine) {
        LocalDateTime currentTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd-hhmmss");
        String fileName = formatter.format(currentTime);
        String logFilePath = directory + "\\" + fileName + FILE_EXTENSION;
        File logFile = new File(logFilePath);



        // open the log file to append

            try (FileOutputStream outputStream = new FileOutputStream(logFile, true);
                 PrintWriter writer = new PrintWriter(outputStream);) {
                for (Map.Entry<String, Integer> snack : vendingMachine.getSalesMap().entrySet()) {
                    writer.println(snack.getKey() + "|" + (snack.getValue()));
                }
                writer.println("Total Revenue: " + vendingMachine.getTotalPrice());


            } catch (Exception ex) {
                //swallow
            }
        }


    }



