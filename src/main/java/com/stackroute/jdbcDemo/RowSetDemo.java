package com.stackroute.jdbcDemo;

import javax.sql.RowSet;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;
import java.sql.*;

public class RowSetDemo {
    public void getAllStudents() {
        try {
            JdbcRowSet rowSet = RowSetProvider.newFactory().createJdbcRowSet();
            Class.forName("com.mysql.cj.jdbc.Driver");
            rowSet.setUrl("jdbc:mysql://localhost:3306/Collge");
            rowSet.setUsername("root");
            rowSet.setPassword("Root@123");
            rowSet.setCommand("select * from course");
            rowSet.execute();
            while (rowSet.next()) {
                System.out.println("Id: " + rowSet.getInt(1));
                System.out.println("course name " + rowSet.getString(2));
                System.out.println("duration: " + rowSet.getInt(3));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}