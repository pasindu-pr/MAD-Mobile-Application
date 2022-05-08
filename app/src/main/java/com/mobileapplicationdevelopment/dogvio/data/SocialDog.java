package com.mobileapplicationdevelopment.dogvio.data;

import com.mobileapplicationdevelopment.dogvio.SocialDogListAdapter;

public class SocialDog {
    private String name;
    private String breed;
    private String sex;
    private int age;
    private String contactNumber;
    private String image;
    private String description;
    private double longtitude;
    private double latitude;
    private int dogId;
    String color;
    private String userID;
    private String birthdate;


    public SocialDog(String name, String breed, String sex, int age,
                     String contactNumber, String image, String description,
                     double longtitude, double latitude, int id, String color,
                     String userID, String birthdate) {
        this.name = name;
        this.breed = breed;
        this.sex = sex;
        this.age = age;
        this.contactNumber = contactNumber;
        this.image = image;
        this.description = description;
        this.longtitude = longtitude;
        this.latitude = latitude;
        this.dogId = id;
        this.color = color;
        this.userID = userID;
        this.birthdate = birthdate;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public SocialDog(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getLongtitude() {
        return longtitude;
    }

    public void setLongtitude(double longtitude) {
        this.longtitude = longtitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public int getId() {
        return dogId;
    }

    public void setId(int id) {
        this.dogId = id;
    }


    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }
}
