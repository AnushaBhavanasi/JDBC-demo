package com.stackroute;

import com.stackroute.jdbcDemo.*;

/**
 * Hello world!
 *
 */
public class JdbcMainClass
{
    public static void main( String[] args )
    {

        DataManager dataManager=new DataManager();
       dataManager.getAllStudents();
        RowSetDemo rowSetDemo=new RowSetDemo();
        //rowSetDemo.getAllStudents();
        System.out.println("Prepared Statement");
        PreparedStatamentDemo preparedStatamentDemo=new PreparedStatamentDemo();
        preparedStatamentDemo.getCourseByName("angular");
        preparedStatamentDemo.getCourseByNameAndDuration("full stack",4);
        //Database metadata demo
        DatabaseMetaDataDemo databaseMetaDataDemo=new DatabaseMetaDataDemo();
        databaseMetaDataDemo.getDatabaseMetaData();
        //Resultset metadata
        System.out.println("resultset meta data");
        ResultSetDemo resultSetDemo=new ResultSetDemo();
        resultSetDemo.getAllStudents();
        //transaction demo
        System.out.println("Transactions");
        JdbcTransactionDemo jdbcTransactionDemo=new JdbcTransactionDemo();
        //jdbcTransactionDemo.transactionDemo();
        //batch processing
        System.out.println("batch processing");
        JdbcBatchProcessingDemo jdbcBatchProcessingDemo=new JdbcBatchProcessingDemo();
        jdbcBatchProcessingDemo.batchProcessingDemo();
    }
}
