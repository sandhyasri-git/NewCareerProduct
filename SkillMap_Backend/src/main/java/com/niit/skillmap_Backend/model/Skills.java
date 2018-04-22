package com.niit.skillmap_Backend.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="Skills")
public class Skills {

	@Id
	private String emp_Id;
	@NotNull
	private String competencies;
	@NotNull
	private String certifications;
	
	
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
