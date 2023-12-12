package com.example.carservice_javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class UserRegistrationController {

    @FXML
    private TextField txtPhoneNumber;

    @FXML
    private TextField txtUsername;

    @FXML
    private Button btnLogIn;

    @FXML
    private Button btnContinue;

    @FXML
    private TextField txtLastName;

    @FXML
    private TextField txtFirstName;

    @FXML
    private TextField txtPassword;


    @FXML
    void initialize(){
        btnContinue.setOnAction(actionEvent -> {
            continueBtnOn(actionEvent);
        });
        }


    @FXML
    void continueBtnOn(ActionEvent event) {
        DatabaseConnection databaseConnection = new DatabaseConnection();

        String firstName = txtFirstName.getText();
        String lastName = txtLastName.getText();
        String phoneNumber = txtPhoneNumber.getText();
        String username = txtUsername.getText();
        String password = txtPassword.getText();

        User user = new User(firstName,lastName,phoneNumber,username,password);
        databaseConnection.signUpUser(user);

        Report.information(event);
        Action.navigateToPage(event,btnContinue,"menu.fxml");
    }


    @FXML
    void logInBtnOn(ActionEvent event) {
        Action.navigateToPage(event,btnLogIn,"hello-view.fxml");
    }

}
