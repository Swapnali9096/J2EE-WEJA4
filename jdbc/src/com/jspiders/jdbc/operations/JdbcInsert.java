package com.jspiders.jdbc.operations;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcInsert {
public static void main(String[] args) throws SQLException {
	Driver driver=new com.mysql.cj.jdbc.Driver();
	DriverManager.registerDriver(driver);
	
	//open connection
	Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/weja4?user=root&&password=root");
	
	//create the statement
	Statement statement=connection.createStatement();
	
	//execute the statement
    statement.execute("INSERT INTO user VALUES (1,'Ramesh','ramesh@gmail.com','ramesh@1234')");
    //process the result
    System.out.println("data insterted");
    //close the statement
    statement.close();
    connection.close();
    //deregister  the driver
    DriverManager.deregisterDriver(driver);
     
     
}
}