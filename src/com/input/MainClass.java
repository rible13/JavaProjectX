package com.input;

//import java.database.Scanner;
import com.database.QueryDatabase;
import com.services.CheckPlates;
import com.services.FileProcessing;
import com.models.Vehicle;
import com.services.Sort;
//import com.sun.org.apache.bcel.internal.generic.Select;

//import java.util.ArrayList;
import java.util.ArrayList;
import java.util.Arrays;
//import java.database.List;
import java.util.regex.Pattern;
//import java.database.regex.Matcher;

public class MainClass {

    private ScanInput scanner;
    private FileProcessing file;
    private QueryDatabase select;
    private CheckPlates plateInput;

    public MainClass() {
        this.scanner = new ScanInput();
        this.file = new FileProcessing();
        this.select = new QueryDatabase();
        this.plateInput = new CheckPlates();

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
                this.selectInput();
                this.forecomingExpiries();
                break;
            case "3":
                this.selectInput();
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
        System.out.println("Plates Expired from this user are " +counter);

        System.out.println("You Have to Pay As Fine " + counter*800);
        this.showMenu();
    }

    public void forecomingExpiries() {
        int days = this.forecomingExpiriesDays();
        boolean sort = this.forecomingExpiriesSort();
        boolean exportToFile = this.forecomingExpiriesExport();
        if ( exportToFile ) {
            this.forecomingExpiriesExportToFile();
        } else {
            this.forecomingExpiriesExportToConsole();
        }
        this.showMenu();
    }

    public int forecomingExpiriesDays () {
        String userInput = "";
        String[] validInputs = { "1", "2" };
      /* DAYS NUMBER */
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

    public void forecomingExpiriesExportToConsole () {
        System.out.println("Exporting to console...");
        QueryDatabase sp = new QueryDatabase();
        ArrayList<Vehicle> listfromdb = sp.selectAll();
        Sort sorting = new Sort();
        sorting.sortplates(listfromdb);
        for (int i=0; i<listfromdb.size() ; i++){
            Vehicle v = listfromdb.get(i);
            System.out.println(v.getPlateNumber());
        }
    }
    public void forecomingExpiriesExportToFile () {
        System.out.println("Exporting to file...");
    }


    public void fineCalculation() {
        System.out.println("You have to pay as fine:");
        this.file.fileInput();
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


}