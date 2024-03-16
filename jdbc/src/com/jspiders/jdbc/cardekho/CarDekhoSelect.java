package com.jspiders.jdbc.cardekho;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class CarDekhoSelect {
private static Connection connection;
private static PreparedStatement preparedStatement;
private static ResultSet resultSet;
private static String query;

public static void main(String[] args)  {
	Scanner scanner=new Scanner(System.in);
	System.out.println("enter car id:");
	int id=scanner.nextInt();
	scanner.close();
	try {
		openConnection();
		query="SELECT * FROM cars WHERE id=?";
		preparedStatement=connection.prepareStatement(query);
		preparedStatement.setInt(1, id);
		resultSet=preparedStatement.executeQuery();
		if(resultSet.next()) {
			System.out.println(resultSet.getInt(1));
			System.out.println(resultSet.getString(2));
			System.out.println(resultSet.getString(3));
			System.out.println(resultSet.getString(4));
			System.out.println(resultSet.getString(5));
			System.out.println(resultSet.getString(6));
			System.out.println(resultSet.getDouble(7));
	}
		else {
			System.out.println("car not found");
		}

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
	if(resultSet!=null) {
		resultSet.close();
	}
	if(preparedStatement!=null) {
		preparedStatement.close();
	}
	if(connection!=null) {
		connection.close();
	}
}
}