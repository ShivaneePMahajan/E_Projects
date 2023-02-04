package com.main;

import java.util.Scanner;

import com.daoImplementation.LibraryDaoImplementation;

public class AppMain {
	public static void main(String[] args) {
		LibraryDaoImplementation l = new LibraryDaoImplementation();

		String s;
		do {
			Scanner sc = new Scanner(System.in);
			System.out.println("------------Book Library System");
			System.out.println("\n 1.Create and Insert");
			System.out.println("\n 2.Select");
			System.out.println("\n 3.Update");
			System.out.println("\n 4.Delete");
			System.out.println("enter the choice");

			int choice = sc.nextInt();

			switch (choice) {
			case 1:
				l.createUser();
				break;
			case 2:
				l.loadUser();
				break;
			case 3:
				System.out.println("enter the user Id");
				int uid = sc.nextInt();
				l.updateUser(uid);
			case 4:
				l.deleteCustomer();

			}
			System.out.println("do u want to continue");
			s = sc.next();
		} while (s.equals("yes"));

	}

}
