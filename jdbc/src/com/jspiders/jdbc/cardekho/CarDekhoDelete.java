package com.jspiders.jdbc.cardekho;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class CarDekhoDelete {
private static Connection connection;
private static PreparedStatement preparedStatement;
private static String query;

public static void delete() {
	Scanner scanner=new Scanner(System.in);
	System.out.println("enter car id:");
	int id=scanner.nextInt();
	scanner.close();
	try {
		openConnection();
		query="DELETE FROM cars WHERE id=?";
		preparedStatement=connection.prepareStatement(query);
		preparedStatement.setInt(1, id);
		int res=preparedStatement.executeUpdate();
		System.out.println("cars deleted");
		System.out.println(res +" row(s) deleted");
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
	if(preparedStatement!=null) {
		preparedStatement.close();
	}
	if(connection!=null) {
		connection.close();
	}
}
}