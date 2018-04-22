package com.niit.skillmap_Backend;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.skillmap_Backend.dao.EmployeeDAO;
import com.niit.skillmap_Backend.model.Employee;

public class EmpTest1 {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com");
		context.refresh();
		context.getBean("employee");
		
		EmployeeDAO employeeDAO= (EmployeeDAO)context.getBean("employeeDAO");
		Employee employee=(Employee)context.getBean("employee");
		
		employee.setEmp_Id("18047");
		employee.setEmp_Name("Rajesh");
		employee.setEmp_Address("Hyd");
		employee.setEmp_Phone("9908638763");
		employee.setEmp_Designation("TM");
		employee.setEmp_IbuName("HYD");
		employee.setEmp_Qualification("MCA");
		employee.setEmp_Center("11065");
		employee.setEmp_Email("Rajesh@yahoo.com");
		employee.setEmp_Password("abcd");
		employee.setEmp_CPassword("abcd");
		employee.setEmp_Students("100");
		employee.setEmp_role("TM");
		employeeDAO.addUser(employee);


	}

}
