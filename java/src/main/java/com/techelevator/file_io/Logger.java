package com.techelevator.file_io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * FIND LOG FILE IN RESOURCES FOLDER
 */

public class Logger {

    private static final String FILE_EXTENSION = ".log";

    private static String directory;

    public Logger(String directory)
    {
        this.directory = directory;
        File folder = new File(directory);
        if(!folder.exists()){
            folder.mkdir();
        }
    }

    public static void logMessage(String message)
    {
        String fileName = LocalDate.now().format(DateTimeFormatter.ISO_DATE); //YYYY-MM-DD
        String logFilePath = directory + "\\" + fileName + FILE_EXTENSION;
        File logFile = new File(logFilePath);

        LocalDateTime currentTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm:ss a ");

        // open the log file to append
        try(FileOutputStream outputStream = new FileOutputStream(logFile, true);
            PrintWriter writer = new PrintWriter(outputStream);)
        {
            String line = String.format("%s %s", formatter.format(currentTime), message);
            writer.println(line);
        }
        catch(Exception ex)
        {
            //swallow
        }


    }

}
