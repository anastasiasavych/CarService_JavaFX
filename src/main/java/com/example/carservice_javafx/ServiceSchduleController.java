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


public class ServiceSchduleController {

    @FXML
    private Button btnAddEmployee;

    @FXML
    private Button btnListOfEmployee;

    @FXML
    private Button btnServiceSchdl;

    @FXML
    private Button btnExit;

    @FXML
    private Button btnCreateClient;

    @FXML
    private TableView<Client> tableServiceRecordLog;

    @FXML
    private TableColumn<Client,String> colDate;

    @FXML
    private TableColumn<Client,String> colFirstName;

    @FXML
    private TableColumn<Client,String> colLastName;

    @FXML
    private TableColumn<Client,String> colService;

    @FXML
    private TableColumn<Client,String> colBrand;

    @FXML
    private TableColumn<Client,String> colModel;


    @FXML
    private TableColumn<Client,String> colPhoneNumber;

    DatabaseConnection databaseConnection = new DatabaseConnection();

    ObservableList<Client> clientList = FXCollections.observableArrayList();


    public void initialize(){
        addClientData();
        colDate.setCellValueFactory(new PropertyValueFactory<>("recordDate"));
        colFirstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        colLastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        colService.setCellValueFactory(new PropertyValueFactory<>("selectedService"));
        colBrand.setCellValueFactory(new PropertyValueFactory<>("brand"));
        colModel.setCellValueFactory(new PropertyValueFactory<>("model"));
        colPhoneNumber.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));

        tableServiceRecordLog.setItems(clientList);
    }


    private void addClientData(){
        ResultSet result = databaseConnection.getClientData();
        try {
            while (result.next()){
                Client client = new Client(result.getString(1),
                        result.getString(2),result.getString(3),
                        result.getString(4),result.getString(5),
                        result.getString(6), result.getString(7));
                clientList.add(client);
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


