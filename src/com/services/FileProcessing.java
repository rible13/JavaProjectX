package com.services;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

public class FileProcessing {


    public void fileInput() {

        URL path = FileProcessing.class.getResource("VehiclesData.csv");
        File csvFile = new File(path.getFile());
        String line;
        String csvSplitBy = ";";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {

                String[] data = line.split(csvSplitBy);

                System.out.println("[plate number= " + data[0] + " , SSN=" + data[1] + " , Expiration Date=" + data[2] + "]");

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void checkFile() {



    }

}