package com.niit.skillmap.model;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//Model class to capture employee details
public class Employee {
	
	//Member variables
	
	private String emp_Id;
	private String emp_Name;
	private String emp_Address;
	private String emp_Phone;
	private String emp_Email;
	private String emp_Qualification;
	private String emp_IbuName;
	private String emp_Center;
	private String emp_Designation;
	private String emp_Students;
	private String emp_Password;
	
	private String emp_role;
	
	private String emp_status;
	
	List<String> errorMap;
	
	//Default Constructor
	public Employee() {
		errorMap=new ArrayList();
	}

	// Parameterized Constructor
	public Employee(String emp_Id, String emp_Name, String emp_Address, String emp_Phone, String emp_Email,
			String emp_Qualification, String emp_IbuName, String emp_Center, String emp_Designation,
			String emp_Students, String emp_Password,String emp_role,String emp_status) {
		
		this.emp_Id = emp_Id;
		this.emp_Name = emp_Name;
		this.emp_Address = emp_Address;
		this.emp_Phone = emp_Phone;
		this.emp_Email = emp_Email;
		this.emp_Qualification = emp_Qualification;
		this.emp_IbuName = emp_IbuName;
		this.emp_Center = emp_Center;
		this.emp_Designation = emp_Designation;
		this.emp_Students = emp_Students;
		this.emp_Password = emp_Password;
		this.emp_role=emp_role;
		this.emp_status=emp_status;
	}

	//Getters and Setters
	
	public String getEmp_Id() {
		return emp_Id;
	}

	public void setEmp_Id(String emp_Id) {
		this.emp_Id = emp_Id;
	}

	public String getEmp_Name() {
		return emp_Name;
	}

	public void setEmp_Name(String emp_Name) {
		this.emp_Name = emp_Name;
	}

	public String getEmp_Address() {
		return emp_Address;
	}

	public void setEmp_Address(String emp_Address) {
		this.emp_Address = emp_Address;
	}

	public String getEmp_Phone() {
		return emp_Phone;
	}

	public void setEmp_Phone(String emp_Phone) {
		
		if(isValidPh(emp_Phone))
		{
		this.emp_Phone = emp_Phone;
		}
		else
		{
			errorMap.add("Invalid Phone Number.......... Try Again");
			System.out.println("Invalid Phone Number.......... Try Again");
		}
	}

	public String getEmp_Email() {
		return emp_Email;
	}

	public void setEmp_Email(String emp_Email) {
		
		if(isValid(emp_Email))
		{
		this.emp_Email = emp_Email;
		}
		else
		{
			errorMap.add("Invalid Email Id... Try Again");
			System.out.println("Invalid Email Id... Try Again");
		}
	}

	public String getEmp_Qualification() {
		return emp_Qualification;
	}

	public void setEmp_Qualification(String emp_Qualification) {
		this.emp_Qualification = emp_Qualification;
	}

	public String getEmp_IbuName() {
		return emp_IbuName;
	}

	public void setEmp_IbuName(String emp_IbuName) {
		this.emp_IbuName = emp_IbuName;
	}

	public String getEmp_Center() {
		return emp_Center;
	}

	public void setEmp_Center(String emp_Center) {
		this.emp_Center = emp_Center;
	}

	public String getEmp_Designation() {
		return emp_Designation;
	}

	public void setEmp_Designation(String emp_Designation) {
		this.emp_Designation = emp_Designation;
	}

	public String getEmp_Students() {
		return emp_Students;
	}

	public void setEmp_Students(String emp_Students) {
		this.emp_Students = emp_Students;
	}

	public String getEmp_Password() {
		return emp_Password;
	}

	public void setEmp_Password(String emp_Password) {
		this.emp_Password = emp_Password;
	}
	
	
	
	public String getEmp_role() {
		return emp_role;
	}

	public String getEmp_status() {
		return emp_status;
	}

	public void setEmp_status(String emp_status) {
		this.emp_status = emp_status;
	}

	public void setEmp_role(String emp_role) {
		this.emp_role = emp_role;
	}

	// Email Id validation
	private static boolean isValid(String email)
    {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                            "[a-zA-Z0-9_+&*-]+)*@" +
                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                            "A-Z]{2,7}$";
                            
        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
    }
	
	//Phone Number validation
	private static boolean isValidPh(String s)
    {
        // The given argument to compile() method 
        // is regular expression. With the help of 
        // regular expression we can validate mobile
        // number. 
        // 1) Begins with 0 or 91
        // 2) Then contains 7 or 8 or 9.
        // 3) Then contains 9 digits
        Pattern p = Pattern.compile("(0/91)?[7-9][0-9]{9}");
 
        // Pattern class contains matcher() method
        // to find matching between given number 
        // and regular expression
        Matcher m = p.matcher(s);
        return (m.find() && m.group().equals(s));
    }
 
	public List<String> getMap()
	{
		return errorMap;
	}

	
	

}
