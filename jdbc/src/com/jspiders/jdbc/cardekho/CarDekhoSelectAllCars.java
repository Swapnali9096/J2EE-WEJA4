package com.jspiders.jdbc.cardekho;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CarDekhoSelectAllCars {
private static Connection connection;
private static Statement statement;
private static ResultSet resultSet;
private static String query;

public static void select() {
	try {
		openConnection();
		statement=connection.createStatement();
		query="SELECT * FROM cars";
		statement.execute(query);
		resultSet=statement.getResultSet();
		while(resultSet.next()) {
			System.out.println(resultSet.getInt(1));
			System.out.println(resultSet.getString(2));
			System.out.println(resultSet.getString(3));
			System.out.println(resultSet.getString(4));
			System.out.println(resultSet.getString(5));
			System.out.println(resultSet.getString(6));
			System.out.println(resultSet.getDouble(7));


		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	finally {
		try {
			closeConnenction();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
private static void openConnection() throws SQLException {
connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/weja4","root","root");	
}
private static void closeConnenction() throws SQLException {
	if(resultSet!=null) {
		resultSet.close();
	}
	if(statement!=null) {
		statement.close();
	}
	if(connection!=null) {
		connection.close();
	}
}
}