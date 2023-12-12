package com.example.carservice_javafx;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;


public class DatabaseConnection extends Configs {

    Connection dbConnection;

    public Connection getDbConnection()
            throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:mysql://localhost:3306/CarService";

        Class.forName("com.mysql.cj.jdbc.Driver");
        dbConnection = DriverManager.getConnection(connectionString,
                dbUser, dbPass);
        return dbConnection;
    }


    public void signUpUser(User user){
        String insert = "INSERT INTO "+ Const.USER_TABLE +"("+Const.USER_FIRST_NAME +","
                + Const.USER_LAST_NAME + "," + Const.USER_PHONE_NUMBER +","+ Const.USERNAME +","
                + Const.PASSWORD+")" + "VALUES(?,?,?,?,?)";

        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(insert);
            preparedStatement.setString(1,user.getFirstName());
            preparedStatement.setString(2,user.getLastName());
            preparedStatement.setString(3,user.getPhoneNumber());
            preparedStatement.setString(4,user.getUsername());
            preparedStatement.setString(5,user.getPassword());
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

/*
Повертає дані користувача, якщо вони містяться в базі даних
В разі їх відсутності - отримуємо порожню строку
 */
    public ResultSet getUserData(User user){
        ResultSet resultSet = null;
        String select = "SELECT * FROM "+Const.USER_TABLE+" WHERE "+Const.USERNAME+"=? AND "+
                Const.PASSWORD+"=?";
        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(select);
            preparedStatement.setString(1,user.getUsername());
            preparedStatement.setString(2,user.getPassword());
            resultSet = preparedStatement.executeQuery();
        }catch (SQLException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public void signUpClient(Client client){
        String insert = "INSERT INTO "+ Const.SAVED_CLIENT +"("+Const.RECORD_DATE+","+Const.CLIENT_FIRST_NAME +","
                + Const.CLIENT_LAST_NAME + "," + Const.SELECTED_SERVICE +","+ Const.CAR_BRAND +","
                + Const.CAR_MODEL+","+Const.CLIENT_PHONE_NUMBER+")" + "VALUES(?,?,?,?,?,?,?)";

        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(insert);
            preparedStatement.setString(1,client.getRecordDate());
            preparedStatement.setString(2,client.getFirstName());
            preparedStatement.setString(3,client.getLastName());
            preparedStatement.setString(4,client.getSelectedService());
            preparedStatement.setString(5,client.getBrand());
            preparedStatement.setString(6,client.getModel());
            preparedStatement.setString(7,client.getPhoneNumber());
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public ResultSet getClientData(){
        ResultSet resultSet = null;
        String select = "SELECT * FROM "+Const.SAVED_CLIENT;
        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(select);
            resultSet = preparedStatement.executeQuery();
        }catch (SQLException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return resultSet;
    }


    public void signUpEmployee(Employee employee){
        String insert = "INSERT INTO "+ Const.EMPLOYEE_RECORDS +"("+Const.EMPLOYEE_ROLL_NUMBER+","
                +Const.EMPLOYEE_FIRST_NAME + "," + Const.EMPLOYEE_LAST_NAME
                + "," + Const.EMPLOYEE_POSITION +","+ Const.EMPLOYEE_PROF_DIRECTION +","
                + Const.EMPLOYEE_EXPERIENCE+","
                +Const.EMPLOYEE_PHONE_NUMBER+")" + "VALUES(?,?,?,?,?,?,?)";

        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(insert);
            preparedStatement.setString(1,employee.getRollNumber());
            preparedStatement.setString(2,employee.getFirstName());
            preparedStatement.setString(3,employee.getLastName());
            preparedStatement.setString(4,employee.getPosition());
            preparedStatement.setString(5,employee.getProfDirection());
            preparedStatement.setString(6, employee.getExperience());
            preparedStatement.setString(7,employee.getPhoneNumber());
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public ResultSet getEmployeeData(){
        ResultSet resultSet = null;
        String select = "SELECT * FROM "+Const.EMPLOYEE_RECORDS;
        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(select);
            resultSet = preparedStatement.executeQuery();
        }catch (SQLException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

}
