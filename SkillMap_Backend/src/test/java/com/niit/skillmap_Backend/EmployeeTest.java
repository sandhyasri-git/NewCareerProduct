package com.niit.skillmap_Backend;

import org.hibernate.exception.ConstraintViolationException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringRunner;

import com.niit.skillmap_Backend.config.AppConfig;
import com.niit.skillmap_Backend.model.Employee;
import com.niit.skillmap_Backend.service.EmployeeService;

import junit.framework.TestCase;

@RunWith(SpringRunner.class)
@SpringJUnitConfig(classes=AppConfig.class)

public class EmployeeTest extends TestCase {
	
	@Autowired
	EmployeeService employeeService;

	protected void setUp() throws Exception {
		if(employeeService.getByName("S1")!=null)
		{
			employeeService.deleteUser(employeeService.getByName("S1").getEmp_Id());
			
		}
		if(employeeService.getByName("S1")!=null)
		{
			employeeService.deleteUser(employeeService.getByName("S2").getEmp_Id());
			
		}
		if(employeeService.getByName("S1")!=null)
		{
			employeeService.deleteUser(employeeService.getByName("S1").getEmp_Id());
			
		}
		Employee employee=new Employee();
		
		employee.setEmp_Id("S1");
		employee.setEmp_Email("S1@gmail.com");
		Employee emp=new Employee();
		emp.setEmp_Id("S2");
		emp.setEmp_Email("S2@gmail.com");
		employeeService.addUser(employee);
		employeeService.addUser(emp);
		
	}

	protected void tearDown(){
		
		employeeService.deleteUser(employeeService.getByName("S1@gmail.com").getEmp_Id());
		employeeService.deleteUser(employeeService.getByName("S1@gmail.com").getEmp_Id());
		if(employeeService.getByName("S2@gmail.com")!=null) {
			employeeService.deleteUser(employeeService.getByName("S2@gmail.com").getEmp_Id());
		}
	}
	
	@Test
	public void testAddEmployee() {
		
		Employee emp=new Employee();
		emp.setEmp_Name("S2");
		emp.setEmp_Email("s2@gmail.com");
		
		assertEquals(true, employeeService.addUser(emp));
				
	}
	
	@Test(expected=ConstraintViolationException.class)
	public void testAddEmployeeFailure() {
		
		Employee emp=new Employee();
		emp.setEmp_Name("S1");
		emp.setEmp_Email("S1@gmail.com");
		
		assertEquals(false, employeeService.addUser(emp));
				
	}


}
