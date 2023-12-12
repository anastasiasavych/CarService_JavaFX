package com.example.carservice_javafx;

public class Client {

    private String recordDate;
    private String firstName;
    private String lastName;
    private String selectedService;
    private String brand;
    private String model;
    private String phoneNumber;

    public Client(String recordDate,String firstName, String lastName, String selectedService, String brand, String model,String phoneNumber) {
        this.recordDate = recordDate;
        this.firstName = firstName;
        this.lastName = lastName;
        this.selectedService = selectedService;
        this.brand = brand;
        this.model = model;
        this.phoneNumber = phoneNumber;
    }

    public String getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(String recordDate) {
        this.recordDate = recordDate;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSelectedService() {
        return selectedService;
    }

    public void setSelectedService(String selectedService) {
        this.selectedService = selectedService;
    }

}
