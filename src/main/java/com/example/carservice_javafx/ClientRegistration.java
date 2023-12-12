package com.example.carservice_javafx;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ClientRegistration {

    @FXML
    private TextField txtPhoneNumber;

    @FXML
    private ChoiceBox<String> rangeOfServices;

    @FXML
    private Button btnContinue;

    @FXML
    private TextField txtBrand;

    @FXML
    private TextField txtLastName;

    @FXML
    private TextField txtFirstName;

    @FXML
    private TextField txtModel;

    @FXML
    private DatePicker datePicker;

    @FXML
    private Button btnExit;

    @FXML
    private Button btnAddEmployee;

    @FXML
    private Button btnListOfEmployee;

    @FXML
    private Button btnServiceSchdl;

    @FXML
    private Button btnCreateClient;




    public void initialize(){
        ObservableList<String> options = rangeOfServices.getItems();
        options.add("Repair");
        options.add("Diagnostic");
        options.add("Painting");
    }


    @FXML
    String choiceBoxRangeOfService() {
        String selectedService = rangeOfServices.getValue();
        return selectedService;
    }

    @FXML
    String selectDate(){
        LocalDate localDate = datePicker.getValue();
        String datePattern = localDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        return datePattern;
    }


    @FXML
    void continueBtnOn(ActionEvent event) {
        DatabaseConnection databaseConnection = new DatabaseConnection();

        String recordDate = selectDate();
        String firstName = txtFirstName.getText();
        String lastName = txtLastName.getText();
        String selectedService = choiceBoxRangeOfService();
        String brand = txtBrand.getText();
        String model = txtModel.getText();
        String phoneNumber = txtPhoneNumber.getText();

        Client client = new Client(recordDate,firstName,lastName,selectedService,brand,model,phoneNumber);
        databaseConnection.signUpClient(client);

        Report.information(event);

        Action.navigateToPage(event,btnContinue,"serviceSchedule.fxml");
    }


    @FXML
    void createClientBtnOn(ActionEvent event) {
        Action.navigateToPage(event,btnCreateClient,"clientRegistration.fxml");
    }

    @FXML
    void serviceSchdlBtnOn(ActionEvent event) {
        Action.navigateToPage(event,btnServiceSchdl,"serviceSchedule.fxml");
    }

    @FXML
    void addEmployeeBtnOn(ActionEvent event) {
        Action.navigateToPage(event,btnAddEmployee,"employeeRegistration.fxml");
    }

    @FXML
    void listOfEmployeeBtnOn(ActionEvent event) {
        Action.navigateToPage(event,btnListOfEmployee,"HR.fxml");
    }

    @FXML
    void exitBtnOn(ActionEvent event) {
        Action.navigateToPage(event,btnExit,"hello-view.fxml");
    }
}
