package com.dao;

import java.sql.SQLException;
import java.util.List;
import com.entity.Employee;

public interface EmpDao {
	
	public List<Employee>displayAll() throws ClassNotFoundException, SQLException;
	
	public void insertEmployee(Employee e) throws ClassNotFoundException, SQLException;
	
	public void updateEmployeeById(Employee e) throws ClassNotFoundException, SQLException;

	public void deleteEmployeeById(Employee e) throws ClassNotFoundException, SQLException;

}
