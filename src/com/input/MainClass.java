package com.input;

import java.util.Scanner;

public class MainClass {

    public static void main(String[] args) {


        int mainchoice = 0;
        int sortchoice = 0;
        int exportchoice = 0;
        String timeframeinput = "";


        ScanInput scanner = new ScanInput();

       // while (mainchoice != 4) {
            do {
                Menu.mainmenu();
                String taskInput = scanner.userInput();
                try {
                    mainchoice = Integer.parseInt(taskInput);

                } catch (NumberFormatException e) {
                    System.out.println("Character Detected!");
                }
                if (mainchoice < 1 || mainchoice > 3) {
                    System.out.println("Please enter number between 1-3..");
                }

            } while (mainchoice < 1 || mainchoice > 3);

            if (mainchoice == 1) {

                System.out.println("Enter the plate Number: ");

                String userinput = scanner.userInput();

                CheckPlates check = new CheckPlates();
                check.setPlate(userinput);
                check.check();

            } else if (mainchoice == 2) {

               // System.out.println("Enter timeframe in days:");

                do {
                    System.out.println("Please enter a number in days..");

                    timeframeinput = scanner.userInput();

                }while (!ScanInput.isInteger(timeframeinput));
                   Menu.sortmenu();

                    do {
                        String taskInput1 = scanner.userInput();
                        try {
                            sortchoice = Integer.parseInt(taskInput1);
                        } catch (NumberFormatException e) {
                            System.out.println("Character Detected!");
                        }
                        if (sortchoice < 1 || sortchoice > 2) {
                            System.out.println("Please enter a number between 1-2..");
                        }
                    } while (sortchoice < 1 || sortchoice > 2);

                        Menu.exportmenu();


                        do {
                            String taskInput3 = scanner.userInput();
                            try {
                                exportchoice = Integer.parseInt(taskInput3);

                            } catch (NumberFormatException e) {
                                System.out.println("Character Detected!");
                            }
                            if (exportchoice < 1 || exportchoice > 2) {
                                System.out.println("Please enter number between 1-2..");
                            }
                            if (exportchoice == 1) {
                                System.out.println("Plates to be expired are:");
                                System.out.println("Press \"ENTER\" to continue...");
                                Scanner liner = new Scanner(System.in);
                                liner.nextLine();

                            }
                            else if (exportchoice == 2) {
                                System.out.println("Results have been exported in a file");


                                System.out.println("Press \"ENTER\" to continue...");
                                Scanner liner = new Scanner(System.in);
                                liner.nextLine();
                            }
                        } while (exportchoice < 1 || exportchoice > 2);







            }
        else if (mainchoice == 3) {
            System.out.println("You have to pay as fine:");


        }
        else {

            System.out.println("Invalid selection");
        }
       // scanner.next();
        }

    }
//}


