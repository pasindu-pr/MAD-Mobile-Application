package com.mobileapplicationdevelopment.dogvio;

public class Doctor_Appointment_Model_Class {

    private int id;
    private String date,time,DrName ,DogCount,UserName ;

    public Doctor_Appointment_Model_Class(){

    }

    public Doctor_Appointment_Model_Class(int id, String date, String time, String drName, String dogCount, String userName) {
        this.id = id;
        this.date = date;
        this.time = time;
        this.DrName = drName;
        this.DogCount = dogCount;
        this.UserName = userName;
    }

    public Doctor_Appointment_Model_Class(String date, String time, String drName, String dogCount, String userName) {
        this.date = date;
        this.time = time;
        this.DrName = drName;
        this.DogCount = dogCount;
        this.UserName = userName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDrName() {
        return DrName;
    }

    public void setDrName(String drName) {
        DrName = drName;
    }

    public String getDogCount() {
        return DogCount;
    }

    public void setDogCount(String dogCount) {
        DogCount = dogCount;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

}
