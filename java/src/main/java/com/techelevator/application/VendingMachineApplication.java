package com.techelevator.application;

public class VendingMachineApplication {

    public void run() {

        while(true) {
            // todo: display home screen

            // todo: and get user choice
            String userChoice = "display";

            if(userChoice.equalsIgnoreCase("display")) {
                // todo: logic to display all vending machine items
            } else if(userChoice.equalsIgnoreCase("purchase")) {
                // todo: logic to display purchase options
            } else if(userChoice.equalsIgnoreCase("exit")) {
                // break out of the loop and end the application
                break;
            }
        }
    }
}
