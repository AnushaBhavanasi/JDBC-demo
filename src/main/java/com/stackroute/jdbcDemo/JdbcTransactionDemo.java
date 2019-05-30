package com.stackroute.jdbcDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcTransactionDemo {
    public void transactionDemo() {
        Connection connection=null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Collge", "root", "Root@123");
            connection.setAutoCommit(false);
            Statement stmt = connection.createStatement();
            String sql="update course set duration=5 where id=3";
            String sqlInsert="insert into course values(5,'salesforce',3)";
            stmt.executeUpdate(sql);
            stmt.executeUpdate(sqlInsert);
            connection.commit();
            connection.close();
            System.out.println("commited");
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