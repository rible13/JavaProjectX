package com.services;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

public class FileProcessing {


    public static String[] fileInput() {

        URL path = FileProcessing.class.getResource("VehiclesData.csv");
        File csvFile = new File(path.getFile());
        String line;
        String csvSplitBy = ";";
        String filePlateData = "";
        String[] fileResult = new String[110];

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            int i = 0;
            while ((line = br.readLine()) != null) {
               ;
                String[] data = line.split(csvSplitBy);

               // System.out.println("[plate number= " + data[0] + " , SSN=" + data[1] + " , Expiration Date=" + data[2] + "]");
               filePlateData = data[0];
                System.out.println("[plate number= " + filePlateData);
                fileResult[i] = data[0];
                i++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileResult;
    }

    public static void main(String[] args) {
        fileInput();
    }

    public void checkFile() {



    }

}