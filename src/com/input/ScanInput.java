package com.input;

import java.util.Scanner;

public class ScanInput {


   private String userinput;
    Scanner one = new Scanner(System.in);

    //Scanner method for integer inputs from user.
//    public int userChoice() {
//       // Scanner one = new Scanner(System.in);
//         choice = one.nextInt();
//        one.nextLine();
//        return choice;
//    }

    public String userInput(){
       // Scanner one = new Scanner(System.in);
         userinput = one.nextLine();
       // one.nextLine();
        return userinput;
    }

}
