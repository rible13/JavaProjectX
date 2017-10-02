package com.input;

import java.util.Scanner;

public class ScanInput {


   private String userinput;
   private Float fineValue;
    Scanner one = new Scanner(System.in);

    public String userInput(){
         userinput = one.nextLine();
        return userinput;
    }

    public Float floatValue(){

        fineValue = one.nextFloat();
        return fineValue;
    }
}
