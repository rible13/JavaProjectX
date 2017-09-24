package com.input;

import java.util.Scanner;

public class ScanInput {


   private String userinput;

    public String userInput(){
       Scanner one = new Scanner(System.in);
         userinput = one.nextLine();
        return userinput;
    }

    public static boolean isInteger(String s){
        try {
            Integer.parseInt(s);
        }
        catch(NumberFormatException e) {
            return false;
        }
        return true;
    }
}
