package com.input;

import java.util.List;
import java.util.Scanner;
import com.database.QueryDatabase;
import com.services.CheckPlates;
import com.services.FileProcessing;
import com.models.Vehicle;
import com.services.Sort;
import java.util.ArrayList;
import java.util.Arrays;

public class MainClass {

    private ScanInput scanner;
    private FileProcessing file;
    private QueryDatabase select;
    private CheckPlates plateInput;
    private Sort sorting;

    public MainClass() {
        this.scanner = new ScanInput();
        this.file = new FileProcessing();
        this.select = new QueryDatabase();
        this.plateInput = new CheckPlates();
        this.sorting = new Sort();

    }


    public void showMenu () {
        System.out.println("=============================");
        System.out.println("|   MENU SELECTION          |");
        System.out.println("=============================");
        System.out.println("| Select Functionality:     |");
        System.out.println("| 1. Plate Number           |");
        System.out.println("| 2. Forecoming Expiries    |");
        System.out.println("| 3. Fine Calculation       |");
        System.out.println("| 4. Exit                   |");
        System.out.println("=============================");
        String[] validInputs = { "1", "2", "3", "4" };
        String userInput = "";
        do {
            System.out.print("Your choice: ");
            userInput = scanner.userInput();
        } while ( !Arrays.asList(validInputs).contains(userInput));

        switch(userInput) {
            case "1":
                this.plateNumber();
                break;
            case "2":
                this.forecomingExpiries();
                break;
            case "3":
           //     this.selectInput();
                this.fineCalculation();
                break;
            case "4":
                this.quit();
                break;
        }
    }

    public boolean selectInput() {
            System.out.println("=============================");
            System.out.println("|  Select Input Method      |");
            System.out.println("=============================");
            System.out.println("| 1. File                   |");
            System.out.println("| 2. Database               |");
            System.out.println("=============================");
            String userInput = "";
            String[] validInputs = {"1", "2"};
            do {
                System.out.print("Your choice: ");
                userInput = scanner.userInput();
            } while (!Arrays.asList(validInputs).contains(userInput));

        return userInput.equals("1");
        }


    public void plateNumber() {
        String userPlate = null;
        userPlate = plateInput.checkplateNumber();
        int counter =  select.selectBySsn(select.selectById(userPlate));
     //   System.out.println("Plates Expired from this user are " +counter);

     //   System.out.println("You Have to Pay As Fine " + counter*800);

        promptEnterKey();
        this.showMenu();
    }

    public void forecomingExpiries() {
        boolean inputType = this.selectInput();
        int days = this.forecomingExpiriesDays();
        boolean exportToFile = this.forecomingExpiriesExport();

            if (exportToFile) {
                this.forecomingExpiriesExportToFile(days);
            } else {
                this.forecomingExpiriesExportToConsole(inputType,days);
            }
        promptEnterKey();
        this.showMenu();
    }

    public int forecomingExpiriesDays () {

        String userInput = "";
        int days = -1;
        do {
            System.out.print("Enter days: ");
            userInput = scanner.userInput();
            try {
                days = Integer.parseInt(userInput);
            } catch ( NumberFormatException e ) {
                days = -1;
            }
        } while ( days == -1 );
        return days;
    }

    public boolean forecomingExpiriesSort () {
        System.out.println("=============================");
        System.out.println("|  Do you want to sort it   |");
        System.out.println("=============================");
        System.out.println("| Choose your decision:     |");
        System.out.println("| 1. Yes - Sort it          |");
        System.out.println("| 2. No - Don't Sort it     |");
        System.out.println("=============================");
        String userInput = "";
        String[] validInputs = { "1", "2" };
        do {
            System.out.print("Your choice: ");
            userInput = scanner.userInput();
        } while ( !Arrays.asList(validInputs).contains(userInput));
        return userInput.equals("1");
    }

    public boolean forecomingExpiriesExport () {
        System.out.println("=============================");
        System.out.println("|        EXPORT TYPE        |");
        System.out.println("=============================");
        System.out.println("| 1. Console                |");
        System.out.println("| 2. File                   |");
        System.out.println("=============================");
        String userInput = "";
        String[] validInputs = { "1", "2" };
        do {
            System.out.print("Your choice: ");
            userInput = scanner.userInput();
        } while ( !Arrays.asList(validInputs).contains(userInput));
        return userInput.equals("2");
    }

    public void forecomingExpiriesExportToConsole (boolean inputType,Integer days) {

        boolean sort = this.forecomingExpiriesSort();


        if(inputType) {
         List <String> filePlateData = file.fileInput();
           ArrayList<String> filePlateDataList = new ArrayList(filePlateData);

            if (sort) {
                System.out.println("Exporting to console...");
                sorting.sortFilePlates(filePlateDataList);
                    System.out.println(filePlateDataList);
            }
            else {
                System.out.println("Exporting to console...");
                System.out.println(filePlateDataList);
            }

        }
        else{

            ArrayList<Vehicle> listfromdb = select.selectAllExpired(days);
            if (sort) {
                System.out.println("Exporting to console...");
                sorting.sortplates(listfromdb);
                for (int i = 0; i < listfromdb.size(); i++) {
                    Vehicle v = listfromdb.get(i);
                    System.out.println(v.getPlateNumber());
                }
            }
            else {
                System.out.println("Exporting to console...");
                for (int i = 0; i < listfromdb.size(); i++) {
                    Vehicle v = listfromdb.get(i);
                    System.out.println(v.getPlateNumber());
                }
            }
        }
    }

    public void forecomingExpiriesExportToFile (Integer days) {

        boolean sort = this.forecomingExpiriesSort();
        System.out.println("Exporting to file...");
        file.fileExport(days,sort);
    }


    
    public void fineCalculation() {

        String userPlate= null;
        userPlate = plateInput.checkSsn();

        int counter =  select.selectBySsn(userPlate);

        String userInput= "";
        float fineValue = -1;
        do {
            System.out.println("Enter a fine value:");
            userInput = scanner.userInput();
            try {
                fineValue = Float.parseFloat(userInput);
            } catch ( NumberFormatException e ) {
                fineValue = -1;
            }
        } while ( fineValue == -1 );


        System.out.println("Plates Expired from this user are " +counter);
        System.out.println("You Have to Pay As Fine " + counter*fineValue + " Euros");
        this.showMenu();
    }

    public void quit() {
        System.out.println("Goodbye!");
        System.exit(0);
    }

    public static void main(String[] args) {
        MainClass menu = new MainClass();
        menu.showMenu();
    }

    public void promptEnterKey(){
        System.out.println("Press \"ENTER\" to continue...");
        Scanner skip = new Scanner(System.in);
        skip.nextLine();
    }

}