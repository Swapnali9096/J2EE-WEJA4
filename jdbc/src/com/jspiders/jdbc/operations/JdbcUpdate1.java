package com.jspiders.jdbc.operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class JdbcUpdate1 {
	private static Connection connection;
	private static PreparedStatement preparedStatement;
	private static String query;

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("enter password:");
		String password=scanner.nextLine();
		
		try {
			openConnection();
			query="UPDATE user SET password=? WHERE id=2";
			preparedStatement=connection.prepareStatement(query);
			preparedStatement.setString(1, password);
			int res=preparedStatement.executeUpdate();
			System.out.println("user updated");
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