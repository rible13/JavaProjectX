package com.services;

import com.models.Vehicle;
import java.util.ArrayList;

public class Sort {
    public void sortplates(ArrayList<Vehicle> list) {
        for(int i = 0; i < list.size(); ++i) {
            for(int j = 1; j < list.size()-i; ++j) {
                if (((Vehicle)list.get(j - 1)).compareTo((Vehicle)list.get(j)) > 0) {
                    Vehicle temp = (Vehicle)list.get(j - 1);
                    list.set(j - 1, list.get(j));
                    list.set(j, temp);
                }
            }
        }

    }
}
