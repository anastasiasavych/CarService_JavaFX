package com.example.carservice_javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;

public class Report {


    @FXML
    static void information(ActionEvent event) {

        javafx.scene.control.Alert alert = new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.INFORMATION);
        alert.setTitle("Successfully");

        alert.setHeaderText("Results:");
        alert.setContentText("The operation was completed successfully!");

        alert.showAndWait();
    }


    @FXML
    static void warning(ActionEvent event) {

        javafx.scene.control.Alert alert = new javafx.scene.control.Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warning");

        alert.setHeaderText("Results:");
        alert.setContentText("Pay attention to the correctness of your input and continue request later");

        alert.showAndWait();
    }


    @FXML
    static void error(ActionEvent event) {

        javafx.scene.control.Alert alert = new javafx.scene.control.Alert(Alert.AlertType.ERROR);
        alert.setTitle("Access is missing");

        alert.setHeaderText("Results:");
        alert.setContentText("Incorrectly entered username or password. Check the data and try again!");

        alert.showAndWait();
    }

}
