package com.view;

import java.sql.SQLException;
import java.util.Scanner;

import com.services.EmpService;

public class EmpMain {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String s;
		System.out.println("--------------------------------------");
		System.out.println("--------IPL Management System---------");
		System.out.println("--------------------------------------");

		do {
			System.out.println("-------------------------------");
			System.out.println("| 1.Display ALL EMPLOYEE DATA |");
			System.out.println("-------------------------------");
		    System.out.println("| 2.insert ALL EMPLOYEE DATA  |");
		    System.out.println("-------------------------------");
		    System.out.println("| 3.Update ALL EMPLOYEE DATA  |");
		    System.out.println("-------------------------------");
	    	System.out.println("| 4.Delete ALL EMPLOYEE DATA  |");
	    	System.out.println("-------------------------------");
		
		
			Scanner sc = new Scanner(System.in);
			System.out.println("\n enter the choice");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				new EmpService().displayAll();
				break;
			case 2:
				new EmpService().insertData();
				break;
			case 3:
				new EmpService().updateData();
				break;
			case 4:
				new EmpService().deleteData();
				break;

			}

			System.out.println("\n do u want to continue");
			s = sc.next();

		} while (s.equals("yes"));
	}
}
