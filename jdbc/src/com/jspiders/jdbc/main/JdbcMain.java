package com.jspiders.jdbc.main;

import java.util.Scanner;

import com.jspiders.jdbc.services.JdbcService;

public class JdbcMain {
public static void main(String[] args) {
	boolean flag=true;
	Scanner scanner =new Scanner(System.in);
	
while(flag) {
	System.out.println("1.signup\n"
			+ "2.login\n"
			+ "3.exit.");
	int choice=scanner.nextInt();
	switch(choice) {
	case 1:
		JdbcService.signup();
		break;
	case 2:
		JdbcService.login();
		break;
	case 3:
		flag=false;
		System.out.println("Thank you!!");
		break;
	default:
		break;

	}
}
}
}