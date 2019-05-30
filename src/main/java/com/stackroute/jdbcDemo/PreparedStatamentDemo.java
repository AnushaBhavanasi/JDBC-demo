package com.stackroute.jdbcDemo;

import java.sql.*;

public class PreparedStatamentDemo {
    public void getCourseByName(String courseName){
        Connection connection=null;
        try{
            //register driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //obtain connection
             connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Collge", "root", "Root@123");
            String sql = "select * from course where name=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,courseName);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {
                int id = result.getInt("id");
                String cName = result.getString("name");
                String duration = result.getString("duration");
                System.out.println(id+"\t"+cName+"\t"+duration);

            }
            result.close();
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
    public void getCourseByNameAndDuration(String courseName,int duration){
        Connection connection=null;
        try {
            //register driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //obtain connection
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Collge", "root", "Root@123");
            String sql = "select * from course where name=? and duration=?";

            PreparedStatement preparedStatement =
                    connection.prepareStatement(sql);

            preparedStatement.setString(1,courseName);
            preparedStatement.setInt(2,duration);

            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {
                int id = result.getInt("id");
                String coursename = result.getString("name");
                String durationCourse = result.getString("duration");
                System.out.println(id+"\t"+coursename+"\t"+durationCourse);

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
