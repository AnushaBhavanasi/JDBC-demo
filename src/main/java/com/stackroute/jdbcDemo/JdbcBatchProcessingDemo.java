package com.stackroute.jdbcDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcBatchProcessingDemo {
    public void batchProcessingDemo(){
        Connection connection=null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Collge", "root", "Root@123");
            connection.setAutoCommit(false);
            Statement statement = connection.createStatement();
            String sql="update course set duration=3 where id=4";
            String sqlInsert="insert into course values(6,'oracle',3)";
            statement.executeUpdate(sql);
            statement.executeUpdate(sqlInsert);
            //adding quries to batch
            statement.addBatch(sql);
            statement.addBatch(sqlInsert);
            statement.executeBatch();
            System.out.println("committed the batch processing");
        }catch (Exception e){
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
