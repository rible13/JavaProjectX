package com.database;

import com.models.Vehicle;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Locale;

public class QueryDatabase {


    public String selectById(String statement) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String person_ssn="";

        try {
            connection = ConnectionConf.getConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM vehicle WHERE plate_number = ?");
            preparedStatement.setString(1, statement);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
              String plateNumber  = resultSet.getString("plate_number");
                int vid = resultSet.getInt("vid");
                String exp_date = resultSet.getString("exp_date");
                person_ssn = resultSet.getString("person_ssn");

                System.out.print("Plate Number: " + plateNumber);
                System.out.print(", Vehicle ID: " + vid);
                System.out.print(", Expiration Date: " + exp_date);
                System.out.print(", Person SSN: " + person_ssn +"\n");
                DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                Date date = format.parse(exp_date);
                Date today = new Date();

                SimpleDateFormat print = new SimpleDateFormat("dd-MM-yyyy");
                // date =format2.parse();
                if (date.before(today)) {

                    System.out.println(plateNumber + " has expired");
                   // System.out.print("Your plate number is: " + print.format(date));
                }
                else {
                    System.out.println(plateNumber + " has not expired yet");

                }
             //   System.out.print(", Vehicle ID: " + vid);
              //  System.out.print(", Expiration Date: " + exp_date);
              //  System.out.print(", Person SSN: " + person_ssn + "\n");
                  System.out.print("\n");

//                Date date = sdf.parse(date);
//                SimpleDateFormat print = new SimpleDateFormat("MMM d, yyyy HH:mm:ss");
//                System.out.println(print.format(parsedDate));

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
    return person_ssn;
    }

    public ArrayList<Vehicle> selectAll() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ArrayList<Vehicle> list=new ArrayList<Vehicle>();

        try {
            connection = ConnectionConf.getConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM vehicle ");
            resultSet = preparedStatement.executeQuery();


            while (resultSet.next()) {
                String plateNumber  = resultSet.getString("plate_number");
                int vehicleId = resultSet.getInt("vid");
                String expDate = resultSet.getString("exp_date");
                String personSsn = resultSet.getString("person_ssn");

                Vehicle vehicle = new Vehicle(vehicleId,plateNumber,expDate,personSsn);
                list.add(vehicle);

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
        return list;
    }

    public ArrayList<Vehicle> selectAllExpired(Integer timeframe) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ArrayList<Vehicle> list = new ArrayList<Vehicle>();

        try {
            connection = ConnectionConf.getConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM vehicle ");
            resultSet = preparedStatement.executeQuery();


            while (resultSet.next()) {
                int vehicleId = resultSet.getInt("vid");
                String plateNumber = resultSet.getString("plate_number");
                String expDate = resultSet.getString("exp_date");
                String personSsn = resultSet.getString("person_ssn");

                DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                Calendar c = Calendar.getInstance();
                c.setTime(new Date()); // Now use today date.
                c.add(Calendar.DATE, timeframe); // Adding 5 days
                String output = format.format(c.getTime());
                Date date1 = format.parse(output);
             //   System.out.println(output);
                Date date = format.parse(expDate);
                Date today = new Date();

                SimpleDateFormat print = new SimpleDateFormat("dd-MM-yyyy");

                Vehicle vehicle = new Vehicle(vehicleId, plateNumber, expDate, personSsn);
                if(date.after(today) && date.before(date1)){

                    list.add(vehicle);
                }

            }
        }catch(Exception e){
            e.printStackTrace();
        } finally{
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
        return list;
    }

    public int selectBySsn(String statement) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int counter = 0;

        try {
            connection = ConnectionConf.getConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM vehicle WHERE person_ssn = ?");
            preparedStatement.setString(1, statement);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String plateNumber  = resultSet.getString("plate_number");
                int vid = resultSet.getInt("vid");
                String exp_date = resultSet.getString("exp_date");
                String person_ssn = resultSet.getString("person_ssn");

                System.out.print("Plate Number: " + plateNumber);
                System.out.print(", Vehicle ID: " + vid);
                System.out.print(", Expiration Date: " + exp_date);
                System.out.print(", Person SSN: " + person_ssn +"\n");
                DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                Date date = format.parse(exp_date);
                Date today = new Date();

                SimpleDateFormat print = new SimpleDateFormat("dd-MM-yyyy");
                // date =format2.parse();
                if (date.before(today)) {
                    counter++;
                }

                //   System.out.print(", Vehicle ID: " + vid);
                //  System.out.print(", Expiration Date: " + exp_date);
                //  System.out.print(", Person SSN: " + person_ssn + "\n");

//                Date date = sdf.parse(date);
//                SimpleDateFormat print = new SimpleDateFormat("MMM d, yyyy HH:mm:ss");
//                System.out.println(print.format(parsedDate));

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
        return counter;
    }

}


