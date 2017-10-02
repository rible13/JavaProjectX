package com.services;

import com.models.Vehicle;
import java.util.ArrayList;

public class Sort {
    public void sortplates(ArrayList<Vehicle> list) {
        for(int i = 0; i < list.size(); ++i) {
            for(int j = 1; j < list.size()-i; ++j) {
                if ((list.get(j - 1)).compareTo(list.get(j)) > 0) {
                    Vehicle temp = list.get(j - 1);
                    list.set(j - 1, list.get(j));
                    list.set(j, temp);
                }
            }
        }
    }


    public void sortFilePlates(ArrayList<String> list) {
        for(int i = 0; i < list.size(); ++i) {
            for(int j = 1; j < list.size()-i; ++j) {
                if ((list.get(j - 1)).compareTo(list.get(j)) > 0) {
                    String temp = list.get(j - 1);
                    list.set(j - 1, list.get(j));
                    list.set(j, temp);
                }
            }
        }
    }
}
