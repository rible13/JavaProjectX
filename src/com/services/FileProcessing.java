package com.services;

import com.database.QueryDatabase;
import com.models.Vehicle;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import com.opencsv.CSVWriter;

import java.util.Arrays;
import java.util.List;


public class FileProcessing {

    private QueryDatabase select;
    private Sort sorting;


    public FileProcessing(){

        this.select = new QueryDatabase();
        this.sorting = new Sort();
    }


    public List<String> fileInput() {

        URL path = FileProcessing.class.getResource("VehiclesData.csv");
        File csvFile = new File(path.getFile());
        String csvSplitBy = ";";
        BufferedReader br = null;

        List<String> filePlateData = new ArrayList<String>();


        try {

            br = new BufferedReader(new FileReader(csvFile));
            String line;
            while ((line = br.readLine()) != null) {
                String[] splitValues = line.split(csvSplitBy);

                for (int i = 0; i < splitValues.length; i++) {
                    if (!(splitValues[i] == null) || !(splitValues[i].length() == 0)) {
                        filePlateData.add(splitValues[0]);
                   }
                }
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
        finally {
            try {
                if (br != null) br.close();
            }
            catch (IOException crunchifyException) {
                crunchifyException.printStackTrace();
            }
        }
            return filePlateData;
        }


    public void fileExport(Integer timeFrame, Boolean sort ) {

        String fileName = "src/com/services/plates.csv";

        ArrayList <Vehicle> listfromdb = select.selectAllExpired(timeFrame);
        if(sort){
            sorting.sortplates(listfromdb);
        }
            try {
                CSVWriter writer = new CSVWriter(new FileWriter(fileName));
                for (Vehicle i : listfromdb) {
                    writer.writeNext(new String[]{i.getPlateNumber()});
                }
                writer.close();

            }
            catch (IOException e) {
                e.printStackTrace();
            }

    }

}