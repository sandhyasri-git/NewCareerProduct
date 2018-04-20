package com.niit.skillmap.test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import com.niit.skillmap.model.Employee;
import com.niit.skillmap.repository.EmployeeRepository;

public class InsertEmpTest {

	EmployeeRepository empRepo;
	@Before
	public void setUp() throws Exception {
		empRepo=new EmployeeRepository();
		
	}

	@Test
	public void testEmpInsert1() throws IOException, SQLException {
		Employee employee=new Employee();
		employee.setEmp_Id("101");
		employee.setEmp_Name("Sandhya");
		employee.setEmp_Address("Hyd");
		employee.setEmp_Phone("2345679");
		employee.setEmp_Email("ss@yahoo.com");
		employee.setEmp_Qualification("MCA");
		employee.setEmp_IbuName("HYD");
		employee.setEmp_Center("11065");
		employee.setEmp_Designation("TM");
		employee.setEmp_Students("100");
		employee.setEmp_Password("abcd");
		employee.setEmp_role("Employee");
		
		assertEquals("Emp record1 ",1,empRepo.insertEmp());
		
	}
	
	@Test
	public void testEmpInsert2() throws IOException, SQLException {
		Employee employee=new Employee();
		employee.setEmp_Id("101");
		employee.setEmp_Name("Sandhya");
		employee.setEmp_Address("Hyd");
		employee.setEmp_Phone("2345679");
		employee.setEmp_Email("ss@yahoo.com");
		employee.setEmp_Qualification("MCA");
		employee.setEmp_IbuName("HYD");
		employee.setEmp_Center("11065");
		employee.setEmp_Designation("TM");
		employee.setEmp_Students("100");
		employee.setEmp_Password("abcd");
		employee.setEmp_role("Employee");
		
		assertEquals("record inserted",1,empRepo.insertEmp());
		
	}

}
