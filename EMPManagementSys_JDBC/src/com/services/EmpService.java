package com.services;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.dao.EmpDaoImplementation;
import com.entity.Employee;

public class EmpService {
	
	public void displayAll() throws ClassNotFoundException, SQLException {
		EmpDaoImplementation iref = new EmpDaoImplementation();

		List<Employee> list = iref.displayAll();

		for (Employee e : list) {
			System.out.println(e);
		}

	}
	
	public void insertData() throws ClassNotFoundException, SQLException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the employee id");
		int empId = sc.nextInt();
		System.out.println("Enter the employee name");
		String empName = sc.next();
		System.out.println("Enter the employee address");
		String empAddress = sc.next();
		System.out.println("Enter the Contact number");
		long empContactNo = sc.nextLong();
		System.out.println("Enter the Salary");
		double salary=sc.nextDouble();
	    Employee e = new Employee();

		e.setEmpId(empId);
		e.setEmpName(empName);
		e.setEmpAddress(empAddress);
		e.setEmpContactNo(empContactNo);
		e.setSalary(salary);
		new EmpDaoImplementation().insertEmployee(e);
	}
	
	public void updateData() throws ClassNotFoundException, SQLException {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the Employee Id");
		int empId = sc.nextInt();
		System.out.println("enter the Employee Name");
		String empName = sc.next();
		System.out.println("enter the Employee Address");
		String empAddress = sc.next();
		System.out.println("enter the Contact Number");
		long empContactNo = sc.nextLong();
		System.out.println("enter the Salary");
		double salary=sc.nextDouble();
		Employee e = new Employee();

		e.setEmpName(empName);
		e.setEmpAddress(empAddress);
		e.setEmpContactNo(empContactNo);
		e.setSalary(salary);
		e.setEmpId(empId);
		
		new EmpDaoImplementation().updateEmployeeById(e);
	}

	public void deleteData() throws ClassNotFoundException, SQLException {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the Employee Id");
		int empId = sc.nextInt();
		Employee e = new Employee();
		e.setEmpId(empId);
		new EmpDaoImplementation().deleteEmployeeById(e);
	}
}
