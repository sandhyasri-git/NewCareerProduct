package com.niit.skillmap_Backend;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringRunner;

import com.niit.skillmap_Backend.config.AppConfig;
import com.niit.skillmap_Backend.service.EmployeeService;

@RunWith(SpringRunner.class)
@SpringJUnitConfig(classes=AppConfig.class)
public class EmployeeTest1 {
	
	@Autowired
	private EmployeeService employeeService;

	@Before
	public void setUp() throws Exception {
		
		/*if(employeeService.getByName(email)("Ryan")!=null) {
			employeeService.deleteEmployee(employeeService.findEmployeesByName("Ryan").getEmpId());
		}
		
		if(employeeService.findEmployeesByName("John")!=null) {
			employeeService.deleteEmployee(employeeService.findEmployeesByName("John").getEmpId());
		}
		
		if(employeeService.findEmployeesByName("Chris")!=null) {
			employeeService.deleteEmployee(employeeService.findEmployeesByName("Chris").getEmpId());
		}
		Employee emp1=new Employee();
		emp1.setName("John");
		emp1.setEmail("john@gmail.com");
		Employee emp2=new Employee();
		emp2.setName("Chris");
		emp2.setEmail("chris@gmail.com");
		employeeService.addEmployee(emp1);
		employeeService.addEmployee(emp2);
*/	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
