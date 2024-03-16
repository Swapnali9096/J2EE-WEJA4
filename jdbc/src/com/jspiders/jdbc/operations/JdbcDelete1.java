package com.jspiders.jdbc.operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JdbcDelete1 {
	private static Connection connection;
	private static PreparedStatement preparedStatement;
	private static String query;
public static void main(String[] args) {
	Scanner scanner=new Scanner(System.in);
	System.out.println("enter user id");
	int id=scanner.nextInt();
	try {
		openConnection();
		query="DELETE FROM user WHERE id=?";
		preparedStatement=connection.prepareStatement(query);
		preparedStatement.setInt(1, id);
		preparedStatement.executeUpdate();
		System.out.println("user deleted");
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
	if(preparedStatement !=null) {
		preparedStatement.close();
	}
	if(connection != null) {
		connection.close();
	}
}

}