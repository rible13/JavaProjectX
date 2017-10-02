package com.services;

import com.input.ScanInput;
import java.util.regex.Pattern;

public class CheckPlates {

 private ScanInput scanner;
 private FileProcessing file;


    public CheckPlates() {
        this.scanner = new ScanInput();
        this.file = new FileProcessing();

    }
    public String checkplateNumber() {
        String userPlate = null;
        String validPlate = "([A-Z]{3})-\\d{4}";
        do {

            //userPlate = file.fileInput();
           System.out.print("Enter the plate Number: ");
            userPlate = scanner.userInput();
        } while ( !Pattern.matches(validPlate, userPlate));
        System.out.println("OK! Your Plate number is " + userPlate);
        return userPlate;
    }

    public String checkSsn(){

        String userSsn = null;
        String valisSsn = "^(?!\\s*$)[0-9\\s]{9}$";

        do {

            //userPlate = file.fileInput();
            System.out.print("Enter Social Security Number: ");
            userSsn = scanner.userInput();
        } while ( !Pattern.matches(valisSsn, userSsn));
        return userSsn;




    }
}
