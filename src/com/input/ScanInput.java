package com.input;

import java.util.Scanner;

public class ScanInput {


   private String userinput;


    public String userInput(){
       Scanner one = new Scanner(System.in);
         userinput = one.next();
        return userinput;
    }

}
