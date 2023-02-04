package com.shivanee.EmpManagementSystem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class EmployeeMain {

	List<Employee> empList = new ArrayList();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	EmployeeMain() {
		empList.add(new Employee(101, "Shivanee", "Burhanpur", 900968035, 25000));
		empList.add(new Employee(102, "Monali", "Burhanpur", 82245678, 30000));
		empList.add(new Employee(103, "Sonali", "Indore", 856773489, 20000));
		empList.add(new Employee(104, "AT", "Shahapur", 906464778, 34000));
		empList.add(new Employee(105, "Shiva", "Dehli", 99894655, 45000));

	}

	public void addEmployeeInfo() throws NumberFormatException, IOException {
		System.out.println("Enter Employee Id: ");
		int empId = Integer.parseInt(br.readLine());
		System.out.println("Enter Employee Name: ");
		String empName = br.readLine();
		System.out.println("Enter Employee Address: ");
		String empAddress = br.readLine();
		System.out.println("Enter Employee Contact Number : ");
		long empContact = Long.parseLong(br.readLine());
		System.out.println("Enter Employee Salary : ");
		double salary = Double.parseDouble(br.readLine());

		Employee emp = new Employee(empId, empName, empAddress, empContact, salary);

		empList.add(emp);
	}

	public void viewEmployeeInfoById() throws NumberFormatException, IOException {
		System.out.println("Enter Employee id:");
		int empId = Integer.parseInt(br.readLine());
		int flag = 0;
		System.out.println(
				"=====================================================================================================================================");

		for (Employee e : empList) {

			if (empId == e.getEmpId()) {
				flag = 1;
				System.out.println("Employee Name:" + e.getEmpName() + "\t Address :" + e.getEmpAddress()
						+ "\t Contact No :" + e.getEmpContactNo() + "\t  Anuual Salary :" + e.getAnnualSalary()
						+ "\t Pf amount : " + e.getPf());
			}
		}

		if (flag == 0)
			System.out.println("Employee Id does not exist!!");
		System.out.println(
				"=====================================================================================================================================");

	}

	public void viewEmployeeInfoByName() throws NumberFormatException, IOException {
		System.out.println("Enter Employee Name:");
		String empName = br.readLine();
		int flag = 0;
		System.out.println(
				"========================================================================================================================================================");

		for (Employee e : empList) {

			if (empName.equalsIgnoreCase(e.getEmpName())) {
				flag = 1;
				System.out.println("Employee Id :" + e.getEmpId() + "\t Employee Name:" + e.getEmpName()
						+ "\t Address :" + e.getEmpAddress() + "\t Contact No :" + e.getEmpContactNo()
						+ "\t  Anuual Salary :" + e.getAnnualSalary() + "\t Pf amount : " + e.getPf());
			}
		}

		if (flag == 0)
			System.out.println("Employee Name does not exist!!");
		System.out.println(
				"========================================================================================================================================================");

	}

	public void viewAllEmployeeInfo() {
		System.out.println(
				"====================================================================================================================================================================================");

		if (empList.size() == 0) {
			System.out.println("No record found!!");
		}

		for (Employee e : empList) {

			System.out.println("Employee Id :" + e.getEmpId() + "\t Employee Name :" + e.getEmpName() + "\t  Address:"
					+ e.getEmpAddress() + "\t  Contact Number :" + e.getEmpContactNo() + "\t Anuual Salary :"
					+ e.getAnnualSalary() + "\t Pf amount : " + e.getPf());

		}
		System.out.println(
				"====================================================================================================================================================================================");

	}

	public void deleteEmployeeById() throws NumberFormatException, IOException {
		System.out.println("Enter Employee id :");
		int empId = Integer.parseInt(br.readLine());
		int index = 0, flag = 0;
		Employee e = null;

		for (Employee emp : empList) {
			if (empId == emp.getEmpId()) {
				flag = 1;
				index = empList.indexOf(emp);
				e = emp;
				System.out.println(index);
				break;
			}
		}
		System.out.println(
				"=====================================================================================================================================");

		if (flag == 0) {
			System.out.println("Employee Id does not exist!!");
		} else {
			empList.remove(e);
			System.out.println("Employee record deleted successfully!!");
		}

		System.out.println(
				"=====================================================================================================================================");

	}

	public void deleteAllEmployeeInfo() {
		System.out.println(
				"===========================================================================================================================");

		if (empList.size() > 0) {
			empList.clear();
			System.out.println("All records deleted successfully!!");
		} else {
			System.out.println("No record available!!");
		}
		System.out.println(
				"============================================================================================================================");

	}

	public void updateEmployeeById() throws NumberFormatException, IOException {
		System.out.println("Enter Employee id:");
		int empId = Integer.parseInt(br.readLine());
		int flag = 0, index = 0;
		Employee e = null;
		for (Employee emp : empList) {
			if (emp.getEmpId() == empId) {
				flag = 1;
				index = empList.indexOf(emp);
				e = emp;
				break;
			}
		}

		if (flag == 1) {
			System.out.println("Enter Employee Name: ");
			String empName = br.readLine();
			System.out.println("Enter Employee Address: ");
			String empAddress = br.readLine();
			System.out.println("Enter Contact Number: ");
			long empContact = Long.parseLong(br.readLine());
			System.out.println("Enter salary : ");
			double salary = Double.parseDouble(br.readLine());

			e.setEmpName(empName);
			e.setEmpAddress(empAddress);
			e.setEmpContactNo(empContact);
			e.setSalary(salary);

			empList.set(index, e);
			System.out.println(
					"=================================================================================================================================");

			System.out.println("Employee Details updated!!");
		} else {
			System.out.println("Id does not exist!!");
		}
		System.out.println(
				"=====================================================================================================================================");

	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		System.out.println("                    Employee Management System BY SHIVANEE MAHAJAN");
		System.out.println("                 ----------------------------------------------------");
		String ch = null;
		EmployeeMain sm = new EmployeeMain();
		do {
			System.out.println("                      Select Any One Option for further Process ");
			System.out.println("                     --------------------------------------------\n");
			System.out.println(
					"\t\t 1. --> INSERT Employee Information\r\n" + "\t\t 2. --> VIEW Employee info by Employee id.\r\n"
							+ "\t\t 3. --> VIEW Employee info by Employee Name.\r\n"
							+ "\t\t 4. --> VIEW all Employee information.\r\n"
							+ "\t\t 5. --> UPDATE Employee information by id.\r\n"
							+ "\t\t 6. --> DELETE Employee information by id.\r\n"
							+ "\t\t 7. --> DELETE all Employee information.\n");
			System.out.println("====================================================================");
			System.out.println("Enter your choice number:");
			int choice = Integer.parseInt(br.readLine());

			switch (choice) {
			case 1:
				sm.addEmployeeInfo();
				System.out.println("Employee Information inserted!!");
				break;
			case 2:
				sm.viewEmployeeInfoById();
				break;
			case 3:
				sm.viewEmployeeInfoByName();
				break;
			case 4:
				sm.viewAllEmployeeInfo();
				break;
			case 5:
				sm.updateEmployeeById();
				break;
			case 6:
				sm.deleteEmployeeById();
				break;
			case 7:
				sm.deleteAllEmployeeInfo();
				break;
			default:
				System.out.println("Wrong choice!!");

			}

			System.out.println("Do you want to continue? (Y-Yes / N-No)");
			ch = br.readLine();
		} while (ch.equals("Y") || ch.equals("y"));
		System.out.println("=====================================================================================");

		System.out.println("Bye....");

		System.out.println("======================================================================================");

	}

}
