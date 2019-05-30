package com.stackroute.jdbcDemo;

import java.sql.*;

public class DataManager {

    public void getAllStudents() {
        Connection connection=null;
        try {
            //register to the driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //obtaining connection
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Collge", "root", "Root@123");
            //create statement
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from course");
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                System.out.println(id);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                connection.close();
            }
            catch (SQLException sqlException){
                sqlException.printStackTrace();
            }
        }

    }
}
