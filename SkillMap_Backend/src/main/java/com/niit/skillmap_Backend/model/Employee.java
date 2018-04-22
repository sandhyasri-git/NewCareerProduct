package com.niit.skillmap_Backend.model;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;

@Entity
@Table(name = "Employee")
public class Employee {

	@Id
	private String emp_Id;
	@NotNull
	private String emp_Name;
	@NotNull
	private String emp_Address;
	@NotNull
	private String emp_Phone;

	@Column(unique = true)
	@Email
	private String emp_Email;
	@NotNull
	private String emp_Qualification;
	@NotNull
	private String emp_IbuName;
	@NotNull
	private String emp_Center;
	@NotNull
	private String emp_Designation;
	@NotNull
	private String emp_Students;
	@NotNull
	private String emp_Password;
	@Transient
	private String emp_CPassword;
	@NotNull
	private String emp_role;

	private String emp_status;
	
	@Transient
	List<String> errorMap=new ArrayList();;

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

	public String getEmp_CPassword() {
		return emp_CPassword;
	}

	public void setEmp_CPassword(String emp_CPassword) {
		this.emp_CPassword = emp_CPassword;
	}

	public String getEmp_role() {
		return emp_role;
	}

	public void setEmp_role(String emp_role) {
		this.emp_role = emp_role;
	}

	public String getEmp_status() {
		return emp_status;
	}

	public void setEmp_status(String emp_status) {
		this.emp_status = emp_status;
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
	        
	        Pattern p = Pattern.compile("(0/91)?[7-9][0-9]{9}");
	 
	        Matcher m = p.matcher(s);
	        return (m.find() && m.group().equals(s));
	    }
}
