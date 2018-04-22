package com.niit.skillmap_frontend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.niit.skillmap_Backend.model.Employee;
import com.niit.skillmap_Backend.service.EmployeeService;

@RestController
@RequestMapping("/api/employee")

public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping
	public ResponseEntity<List<Employee>>showAllEmployees(){
		
		return new ResponseEntity<List<Employee>>(employeeService.getAllUsers(),HttpStatus.CREATED);
	}
	
	@GetMapping("/{empId}")
	public ResponseEntity<Employee>getEmployee(@PathVariable("empId") String emp_Id){
		if(employeeService.getByid(emp_Id)!=null)
		{
			return new ResponseEntity<Employee>(employeeService.getByid(emp_Id),HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<Employee>(employeeService.getByid(emp_Id),HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/{empId}")
	public ResponseEntity<Void>deleteEmp(@PathVariable("empId") String emp_Id){
		
		if(employeeService.getByid(emp_Id)!=null)
		{
			employeeService.deleteUser(emp_Id);
			
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		
	}
	@PostMapping
	public ResponseEntity<Void>addEmp(@RequestBody Employee employee){
		
		if(employeeService.getByName(employee.getEmp_Email())!=null){
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		else
		{
			employeeService.addUser(employee);
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		}
	}
	@PostMapping
	public ResponseEntity<Void>upDateEmp(@RequestBody Employee employee)
	{
		if(employeeService.getByid(employee.getEmp_Id())!=null)
		{
			employeeService.updateEmployee(employee);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
			
	}
	
}
























