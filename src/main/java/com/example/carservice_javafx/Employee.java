package com.example.carservice_javafx;

import java.util.Random;

public class Employee {

    private String rollNumber;
    private String firstName;
    private String lastName;
    private String position;
    private String profDirection;
    private String experience;
    private String phoneNumber;

    public Employee(String rollNumber,String firstName, String lastName, String position,
                    String profDirection, String experience, String phoneNumber) {
        this.rollNumber = rollNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        this.profDirection = profDirection;
        this.experience = experience;
        this.phoneNumber = phoneNumber;
    }

    public static String generateFiveDigitId() {
        char randomLetter = (char) ('A' + new Random().nextInt(26));
        int randomDigits = 10000 + new Random().nextInt(90000);
        return String.format("%c%04d", randomLetter, randomDigits);
    }


    public String getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getProfDirection() {
        return profDirection;
    }

    public void setProfDirection(String profDirection) {
        this.profDirection = profDirection;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}