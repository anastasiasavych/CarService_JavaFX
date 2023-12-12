package com.example.carservice_javafx;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class EmployeeRegistrationController {

    @FXML
    private TextField txtRollNumber;

    @FXML
    private ChoiceBox<String> rangeOfPosition;

    @FXML
    private Button btnContinue;

    @FXML
    private Button btnAddEmployee;

    @FXML
    private ChoiceBox<String> rangeOfProfDirection;

    @FXML
    private Button btnListOfEmployee;

    @FXML
    private Button btnServiceSchdl;

    @FXML
    private TextField txtPhoneNumber;


    @FXML
    private TextField txtLastName;

    @FXML
    private TextField txtFirstName;

    @FXML
    private TextField txtExperience;

    @FXML
    private Button btnExit;

    @FXML
    private Button btnCreateClient;


    public void initialize(){
        ObservableList<String> positionItems = rangeOfPosition.getItems();
        positionItems.add("Junior specialist");
        positionItems.add("Middle specialist");
        positionItems.add("Senior specialist");

        ObservableList<String> profDirectionItems = rangeOfProfDirection.getItems();
        profDirectionItems.add("Mechanic");
        profDirectionItems.add("Electrician");
        profDirectionItems.add("Diagnostician");
        profDirectionItems.add("Painter");
    }

    @FXML
    String choiceBoxRangeOfPosition() {
        String position = rangeOfPosition.getValue();
        return position;
    }

    @FXML
    String choiceBoxRangeOfProfDirection() {
        String profDirection = rangeOfProfDirection.getValue();
        return profDirection;
    }



    @FXML
    void continueBtnOn(ActionEvent event) {
        DatabaseConnection databaseConnection = new DatabaseConnection();

        String rollNumber = String.valueOf(Employee.generateFiveDigitId());
        String firstName = txtFirstName.getText();
        String lastName = txtLastName.getText();
        String position = choiceBoxRangeOfPosition();
        String profDirection = choiceBoxRangeOfProfDirection();
        String experience = txtExperience.getText();
        String phoneNumber = txtPhoneNumber.getText();
        Employee employee = new Employee(rollNumber,firstName,lastName,position,profDirection,experience,phoneNumber);
        databaseConnection.signUpEmployee(employee);

        Report.information(event);
        Action.navigateToPage(event,btnContinue,"HR.fxml");
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
