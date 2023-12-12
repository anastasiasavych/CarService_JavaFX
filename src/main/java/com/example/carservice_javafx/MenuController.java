package com.example.carservice_javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MenuController {


        @FXML
        private Button btnAddEmployee;

        @FXML
        private Button btnListOfEmployee;

        @FXML
        private Button btnServiceSchdl;

        @FXML
        private Button btnCreateClient;

        @FXML
        private Button btnExit;



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



