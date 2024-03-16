package com.jspiders.jdbc.operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcInsertTask {
 private static Connection connection;
 private static Statement statement;
 private static String query;
 
 public static void main(String[] args) {
	 try {
		openConnection();
		statement=connection.createStatement();
		query="INSERT INTO student VALUES(1,'Ramesh','ramesh@gmail.com',23)";
		query="INSERT INTO student VALUES(2,'Suresh','suresh@gmail.com',24)";
		query="INSERT INTO student VALUES(3,'Ganesh','ganesh@gmail.com',22)";
		query="INSERT INTO student VALUES(4,'Ajay','ajay@gmail.com',21)";
		query="INSERT INTO student VALUES(5,'Vijay','vijay@gmail.com',20)";
		statement.execute(query);
		System.out.println("data inserted");
	} catch (SQLException e) {
		e.printStackTrace();
	}
	 finally {
		try {
			closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
 private static void openConnection() throws SQLException {
	 connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/weja4","root","root");
 }
 private static void closeConnection() throws SQLException {
	 if(statement != null) {
		 statement.close();
	 }
	 if(connection != null) {
		 connection.close();
	 }
 }
}