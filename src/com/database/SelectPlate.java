package com.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectPlate {



    public String selectById(String plateNumber) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectionConf.getConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM vehicle WHERE plate_number = ?");
            preparedStatement.setString(1, plateNumber);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                plateNumber  = resultSet.getString("vid");
                int vid = resultSet.getInt("vid");
                String exp_date = resultSet.getString("exp_date");
                String person_ssn = resultSet.getString("person_ssn");

                System.out.print("Plate Number: " + plateNumber);
                System.out.print(", Vehicle ID: " + vid);
                System.out.print(", Expiration Date: " + exp_date);
                System.out.print(", Person SSN: " + person_ssn);

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    return "";
    }

}


