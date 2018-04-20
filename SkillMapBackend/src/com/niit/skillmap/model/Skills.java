package com.niit.skillmap.model;

public class Skills {
	
	private String emp_Id;
	private String competencies;
	private String certifications;
	
	
	public Skills() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Skills(String emp_Id, String competencies, String certifications) {
		
		this.emp_Id = emp_Id;
		this.competencies = competencies;
		this.certifications = certifications;
	}

	//Getters and Setters
	
	public String getEmp_Id() {
		return emp_Id;
	}


	public void setEmp_Id(String emp_Id) {
		this.emp_Id = emp_Id;
	}


	public String getCompetencies() {
		return competencies;
	}


	public void setCompetencies(String competencies) {
		this.competencies = competencies;
	}


	public String getCertifications() {
		return certifications;
	}


	public void setCertifications(String certifications) {
		this.certifications = certifications;
	}
	
	

}
