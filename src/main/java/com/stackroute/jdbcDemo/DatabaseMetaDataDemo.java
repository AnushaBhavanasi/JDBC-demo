package com.stackroute.jdbcDemo;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseMetaDataDemo {
    public void getDatabaseMetaData(){
        Connection connection=null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");

             connection= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/Collge", "root", "Root@123");
            DatabaseMetaData databaseMetaData=connection.getMetaData();
            System.out.println("Driver Name: "+databaseMetaData.getDriverName());
            System.out.println("Driver Version: "+databaseMetaData.getDriverVersion());
            System.out.println("UserName: "+databaseMetaData.getUserName());
            System.out.println("Database Product Name: "+databaseMetaData.getDatabaseProductName());
            System.out.println("Database Product Version: "+databaseMetaData.getDatabaseProductVersion());

            connection.close();
        }catch(Exception e){ System.out.println(e);}
        finally{
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

