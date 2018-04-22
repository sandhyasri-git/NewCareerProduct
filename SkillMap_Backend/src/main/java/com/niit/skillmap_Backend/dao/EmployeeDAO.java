package com.niit.skillmap_Backend.dao;

import java.util.List;

import com.niit.skillmap_Backend.model.Employee;

public interface EmployeeDAO {

	public boolean addUser(Employee employee);
	
	public boolean deleteUser(String emp_Id);
	public Employee getByName(String email);
	public List<Employee>getAllUsers();

	public Employee getByid(String emp_Id);
	public boolean updateEmployee(Employee employee);

}
