package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.entity.Employee;

public class EmpDaoImplementation implements EmpDao {

	@Override
	public List<Employee> displayAll() throws ClassNotFoundException, SQLException {
		ArrayList<Employee> list = new ArrayList<Employee>();
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shivanee_db", "root", "root");
		PreparedStatement st = con.prepareStatement(" select * from EmpTable ");
		ResultSet rs = st.executeQuery();
		while (rs.next()) {
			Employee e = new Employee();
			e.setEmpId(rs.getInt(1));
			e.setEmpName(rs.getString(2));
			e.setEmpAddress(rs.getString(3));
			e.setEmpContactNo(rs.getLong(4));
			e.setSalary(rs.getDouble(4));
			list.add(e);
			
		}

		return list;
	}

	


	@Override
	public void updateEmployeeById(Employee e) throws ClassNotFoundException, SQLException {
		int row = 0;
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shivanee_db", "root", "root");
		PreparedStatement st = con.prepareStatement("update EmpTable set empName=?,empAddress=?,empContactNo=?,salary=? where empId =? ");
        st.setString(1, e.getEmpName());
		st.setString(2, e.getEmpAddress());
		st.setLong(3, e.getEmpContactNo());
		st.setDouble(4, e.getSalary());
		st.setInt(5, e.getEmpId());
		row = st.executeUpdate();
		System.out.println("Update Success!");
		
	}

	@Override
	public void deleteEmployeeById(Employee e) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shivanee_db", "root", "root");
		PreparedStatement st = con.prepareStatement("delete from EmpTable where empId=? ");
		st.setInt(1, e.getEmpId());
		st.executeUpdate();
		System.out.println("SuccessFully Deleted!");
		
	}




	@Override
	public void insertEmployee(Employee e) throws ClassNotFoundException, SQLException {
		int row = 0;
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shivanee_db", "root", "root");
		PreparedStatement st = con.prepareStatement("insert into EmpTable values(?,?,?,?,?) ");
		st.setInt(1, e.getEmpId());
		st.setString(2, e.getEmpName());
		st.setString(3, e.getEmpAddress());
	    st.setLong(4, e.getEmpContactNo());
		st.setDouble(5, e.getSalary());
		row=st.executeUpdate();
		System.out.println("Insert Success!");
		
	}
	

}
