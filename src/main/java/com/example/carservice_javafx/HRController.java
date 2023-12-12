package com.example.carservice_javafx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.ResultSet;
import java.sql.SQLException;

public class HRController {


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
    private TableColumn<Employee, String> colLastName;

    @FXML
    private TableColumn<Employee, String> colPhoneNumber;

    @FXML
    private TableColumn<Employee, String> colRollNumber;

    @FXML
    private TableView<Employee> employeeAccountingTable;

    @FXML
    private TableColumn<Employee, String> colPosition;

    @FXML
    private TableColumn<Employee, String> colFirstName;

    @FXML
    private TableColumn<Employee, String> colProfDirection;

    @FXML
    private TableColumn<Employee, String> colExperience;


    DatabaseConnection databaseConnection = new DatabaseConnection();

    ObservableList<Employee> employeesList = FXCollections.observableArrayList();


    public void initialize(){
        addEmployeeData();
        colRollNumber.setCellValueFactory(new PropertyValueFactory<>("rollNumber"));
        colFirstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        colLastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        colPosition.setCellValueFactory(new PropertyValueFactory<>("position"));
        colProfDirection.setCellValueFactory(new PropertyValueFactory<>("profDirection"));
        colExperience.setCellValueFactory(new PropertyValueFactory<>("experience"));
        colPhoneNumber.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));

        employeeAccountingTable.setItems(employeesList);
    }


    private void addEmployeeData(){
        ResultSet result = databaseConnection.getEmployeeData();
        try {
            while (result.next()){
                Employee employee = new Employee(result.getString(1),
                        result.getString(2),result.getString(3),
                        result.getString(4),result.getString(5),
                        result.getString(6), result.getString(7));
                employeesList.add(employee);
            }
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
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

