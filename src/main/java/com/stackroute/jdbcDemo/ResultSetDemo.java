package com.stackroute.jdbcDemo;

import java.sql.*;

public class ResultSetDemo {
    public void getAllStudents(){
        Connection connection=null;
        try {
            //register for driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //connection
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Collge", "root", "Root@123");
            String  sql="select * from course";
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            ResultSet resultSet=preparedStatement.executeQuery();
            ResultSetMetaData resultSetMetaData=resultSet.getMetaData();
            System.out.println("total no of columns: "+resultSetMetaData.getColumnCount());
            System.out.println("column name: "+resultSetMetaData.getColumnName(2));
            System.out.println("column datatype: "+resultSetMetaData.getColumnTypeName(2));
            connection.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
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
