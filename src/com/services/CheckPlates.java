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
    public String plateNumber() {
        String userPlate = null;
        String validPlate = "([A-Z]{3})-\\d{4}";
        do {

            //userPlate = file.fileInput();
         //   System.out.print("Enter the plate Number: ");
          //  userPlate = scanner.userInput();
        } while ( !Pattern.matches(validPlate, userPlate));
        System.out.println("OK! Your Plate number is " + userPlate);

        return userPlate;
    }
}
