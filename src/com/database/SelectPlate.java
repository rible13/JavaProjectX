package com.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectPlate {



    public String selectById(int vehicleid) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectionConf.getConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM vehicle WHERE vid = ?");
            preparedStatement.setInt(1, vehicleid);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                vehicleid  = resultSet.getInt("vid");
                String plate_number = resultSet.getString("plate_number");
                String exp_date = resultSet.getString("exp_date");
                String person_ssn = resultSet.getString("person_ssn");

                System.out.print("Vehicle ID: " + vehicleid);
                System.out.print(", Name: " + plate_number);
                System.out.print(", Name: " + exp_date);
                System.out.print(", Name: " + person_ssn);

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


