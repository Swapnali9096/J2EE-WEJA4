package com.jspiders.jdbc.cardekho;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CarDekhoInsert {
	 private static Connection connection;
	 private static Statement statement;
	 private static String query;
	 
	 public static void insert() {
		try {
			openConnection();
			statement=connection.createStatement();
			query="INSERT INTO cars VALUES(1,'Ertiga','Maruti Suzuki','Ertiga ZXI plus AT','CNG','Oxford blue',869000.0)";
			query="INSERT INTO cars VALUES(2,'Baleno','Maruti Suzuki','Delta','Petrol','blue',666000.0)";
			query="INSERT INTO cars VALUES(3,'Creta','Hyundai','Creta SX(O)','Diesel','black',1100000.0)";
			query="INSERT INTO cars VALUES(4,'Nexon','Tata Motors','Fearless S DT','Diesel','grey',810000.0)";
			query="INSERT INTO cars VALUES(5,'Seltos','Kia Motors','Seltos HTX','Petrol','red',1518000.0)";
			query="INSERT INTO cars VALUES(6,'Thar','Mahindra','LX hard top trim','Diesel','black',1500000.0)";
			query="INSERT INTO cars VALUES(7,'Fortuner','Toyato','GR S 4*4','Diesel','white',5140000.0)";
			query="INSERT INTO cars VALUES(8,'Scorpio','Mahindra','Z4','Diesel','White',1615000.0)";
			query="INSERT INTO cars VALUES(9,'XUV 700','Mahindra','AX5','Petrol','black',1319000.0)";
			query="INSERT INTO cars VALUES(10,'Harrier','Tata Motors','Fearless plus dark','Diesel','seaweed green',1549000.0)";

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