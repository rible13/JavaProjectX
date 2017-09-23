package com.input;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class CheckPlates {

    private String plate;
    //setter
    public void setPlate(String a) {
        this.plate = a;
    } //getter
    public String getPlate() {

        return this.plate;
    }

    public void check(){
        Pattern pattern = Pattern.compile("([A-Z]{3})-\\d{4}");
        Matcher matcher = pattern.matcher(plate);

        if (matcher.matches()){
            System.out.println("Its a plate!");
            System.out.println("Your Plate number is " +plate);
        }else {
            System.out.println("Its not a plate,try again!");
        }
    }
}