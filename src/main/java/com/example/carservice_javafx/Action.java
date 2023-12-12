package com.example.carservice_javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Action {

    @FXML
    static void navigateToPage(ActionEvent event,Button button, String name) {
        button.getScene().getWindow().hide();
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Action.class.getResource(name));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Car Service");
            stage.setScene(new Scene(root1));
            stage.setResizable(false);
            stage.show();
        } catch(Exception e){
            System.out.println("Error!");
        }
    }

}
