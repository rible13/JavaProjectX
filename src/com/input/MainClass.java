package com.input;

import java.util.Scanner;

public class MainClass {

    public static void main(String[] args) {


        int choice = 0;


        while (choice != 3) {
            ScanInput scanner = new ScanInput();
            Menu.menu1();

            do {
                String taskInput = scanner.userInput();
                try {
                    choice = Integer.parseInt(taskInput);

                }
                catch (NumberFormatException e) {
                    System.out.println("Character detected!");
                    System.out.println("Please enter number between 1-3..");
                }


            } while (choice < 1 || choice > 3);

            if (choice == 1) {

                System.out.println("Enter the plate Number: ");

                String userinput = scanner.userInput();

                CheckPlates check = new CheckPlates();
                check.setPlate(userinput);
                check.check();

            } else if (choice == 2) {

                System.out.println("Enter timeframe in days:");
                String userinput = scanner.userInput();
                Menu.menu2();

                if (choice == 1) {
                    System.out.println("Plates to be expired are:");

                } else if (choice == 2) {
                    System.out.println("Results have been exported in a file");


                    System.out.println("Press \"ENTER\" to continue...");
                    Scanner liner = new Scanner(System.in);
                    liner.nextLine();
                } else if (choice == 3) {
                    System.out.println("Enter Plate Number:");


                } else {

                    System.out.println("Invalid selection");
                }
            }

        }
    }
}
