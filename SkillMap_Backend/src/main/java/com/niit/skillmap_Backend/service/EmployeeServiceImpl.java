package com.niit.skillmap_Backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.niit.skillmap_Backend.dao.EmployeeDAO;
import com.niit.skillmap_Backend.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeDAO employeeDAO;
	
	public boolean addUser(Employee employee) {
	
		if(employeeDAO.getByid(employee.getEmp_Id())!=null)
		{
			return false;
		}
		else
		{
			employeeDAO.addUser(employee);
		     return true;
		}
	}

	public boolean deleteUser(String emp_Id) {
		if(employeeDAO.getByid(emp_Id)!=null)
		{
			employeeDAO.deleteUser(emp_Id);
			return true;
		}
		else
		{
			return false;
	}
	}
	public Employee getByName(String email) {
	
		return employeeDAO.getByName(email);
	}

	public List<Employee> getAllUsers() {
		
		return employeeDAO.getAllUsers();
	}

	public Employee getByid(String emp_Id) {
		
		return employeeDAO.getByid(emp_Id);
	}

	public boolean updateEmployee(Employee employee) {
		
		if(employeeDAO.getByid(employee.getEmp_Id())!=null)
		{
			employeeDAO.updateEmployee(employee);
			return true;
		}
		else
		{
		return false;
		}
	}

}
