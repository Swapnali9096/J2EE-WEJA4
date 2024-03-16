package com.jspiders.jdbc.cardekho;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class CarDekhoUpdate {
private static Connection connection;
private static PreparedStatement preparedStatement;
private static String query;

public static void update() {
	Scanner scanner=new Scanner(System.in);
	System.out.println("enter car id:");
	int id=scanner.nextInt();
	scanner.nextLine();
	System.out.println("enter new model name:");
	String model=scanner.nextLine();
	System.out.println("enter new color:");
	String color=scanner.nextLine();
	System.out.println("enter latest price:");
	String price=scanner.nextLine();
scanner.close();

	try {
		openConnection();
		query="UPDATE cars SET model=?, color=?, price=? WHERE id=? ";
		preparedStatement=connection.prepareStatement(query);
		preparedStatement.setInt(4, id);
		preparedStatement.setString(2, color);
		preparedStatement.setString(3, price);
		preparedStatement.setString(1, model);
		int res =preparedStatement.executeUpdate();
		System.out.println("car updated");
		System.out.println(res + " row(s) updated");
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
	if(preparedStatement != null) {
		preparedStatement
		.close();
	}
	if(connection!=null) {
		connection.close();
	}
}
}