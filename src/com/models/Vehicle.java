package com.models;


public class Vehicle {

    private int vid;
    private String plate_number;
    private String exp_date;
    private String person_ssn;

    public Vehicle(int vid,String plate_number,String exp_date,String person_ssn) {
        this.vid=vid;
        this.plate_number=plate_number;
        this.exp_date=exp_date;
        this.plate_number=person_ssn;
    }

    public int getVid() {
        return vid;
    }

    public void setVid(int vid) {
        this.vid = vid;
    }

    public String getPlateNumber() {
        return plate_number;
    }

    public void setPlateNumber(String plateNumber) {
        this.plate_number = plateNumber;
    }

    public String getExpDate() {
        return exp_date;
    }

    public void setExpDate(String expDate) {
        this.exp_date = expDate;
    }

    public String getPersonSsn() {
        return person_ssn;
    }

    public void setPersonSsn(String personSsn) {
        this.person_ssn = personSsn;
    }
    public int compareTo(Vehicle vehicle) {
        String vehicle1 = this.plate_number;
        String vehicle2 = vehicle.getPlateNumber();

        for(int i = 0; i < vehicle1.length(); ++i) {
            if (vehicle1.charAt(i) > vehicle2.charAt(i)) {
                return 1;
            }

            if (vehicle1.charAt(i) < vehicle2.charAt(i)) {
                return -1;
            }
        }

        return 0;
    }
}