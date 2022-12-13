package com.shivanee.EmpManagementSystem;

public class Employee {

	private int empId;
	private String empName;
	private String empAddress;
	private long empContactNo;
	private double salary;

	public Employee() {
		super();

	}

	public Employee(int empId, String empName, String empAddress, long empContactNo, double salary) {
		this();
		this.empId = empId;
		this.empName = empName;
		this.empAddress = empAddress;
		this.empContactNo = empContactNo;
		this.salary = salary;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpAddress() {
		return empAddress;
	}

	public void setEmpAddress(String empAddress) {
		this.empAddress = empAddress;
	}

	public long getEmpContactNo() {
		return empContactNo;
	}

	public void setEmpContactNo(long empContactNo) {
		this.empContactNo = empContactNo;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public double getAnnualSalary() {
		double annualSal = salary * 12;
		return annualSal;
	}

	public double getPf() {

		double pf = ((salary * 12) * 18) / 100;
		return pf;

	}

	@Override
	public String toString() {
		return "Employee Id =" + empId + ", Employee Name=" + empName + ", Employee Address=" + empAddress
				+ ", Employee ContactNo=" + empContactNo + ", Annual Salary =" + getAnnualSalary() + ", PF = "
				+ getPf();
	}

}
