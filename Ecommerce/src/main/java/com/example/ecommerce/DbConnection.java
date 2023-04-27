package com.example.ecommerce;
import  java.sql.*;

public class DbConnection {
    private final String dburl = "jdbc:mysql://localhost:3307/ecommerce";
    private final String userName = "root";
    private final String password = "1234";

    private Statement getStatement(){
        try {
            Connection connection = DriverManager.getConnection(dburl,userName,password);
            return connection.createStatement();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public  ResultSet getQueryTable(String query){
        try {
            Statement statement=getStatement();
            return statement.executeQuery(query);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public int updateDatabase(String query){
        try {
            Statement statement=getStatement();
            return statement.executeUpdate(query);
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    public static void main(String[] args) {
        DbConnection conn = new DbConnection();
        ResultSet rs= conn.getQueryTable("SELECT * FROM customers");
        if(rs!=null){
            System.out.println("Connection Sucessfull");
        }
        else System.out.println("Failed");

    }

}
