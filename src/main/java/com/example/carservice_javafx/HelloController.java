package com.example.carservice_javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HelloController {

    @FXML
    private TextField txtUsername;

    @FXML
    private TextField txtPassword;

    @FXML
    private Button btnLogIn;

    @FXML
    private Button btnSignUp;

    @FXML
    private Button btnCancel;


    @FXML
    public void initialize() {

        btnLogIn.setOnAction(actionEvent -> {
            logInBtnOn(actionEvent);
        });

        btnSignUp.setOnAction(actionEvent -> {
            signUpBtnOn(actionEvent);
        });
    }


    @FXML
    void logInBtnOn(ActionEvent event) {
        btnLogIn.setOnAction(actionEvent -> {
            String usernameText = txtUsername.getText();
            String passwordText = txtPassword.getText();

            if (!usernameText.equals("") && !passwordText.equals("")) {
                loginUser(usernameText, passwordText, event);
            }
        });

    }


    private void loginUser(String usernameText, String passwordText,ActionEvent event) {
        DatabaseConnection databaseConnection = new DatabaseConnection();
        User user = new User();
        user.setUsername(usernameText);
        user.setPassword(passwordText);
        ResultSet result = databaseConnection.getUserData(user);
        int counter = 0;
        while (true) {
            try {
                if (!result.next()) break;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            counter++;
        }
        if (counter >= 1) {
            Action.navigateToPage(event,btnSignUp,"menu.fxml");
        }else{
            Report.error(event);
        }
    }



    @FXML
    void signUpBtnOn(ActionEvent event) {
        Action.navigateToPage(event,btnSignUp,"registrationPage.fxml");
    }


    @FXML
    void cancelBtnOn(ActionEvent event) {
        Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        stage.close();

    }

}
