package com.niit.skillmap.test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;


import com.niit.skillmap.model.Skills;

import com.niit.skillmap.repository.SkillsRepository;

public class InsertSkillsTest {

	SkillsRepository skillsRepo;
	@Before
	public void setUp() throws Exception {
		skillsRepo=new SkillsRepository();
		
	}

	@Test
	public void testSkillsInsert1(Skills skill) throws IOException, SQLException {
		Skills skills=new Skills();
		
		skills.setEmp_Id("100");
		skills.setCompetencies("Java");
		skills.setCertifications("Java");
		assertEquals("Emp record1 ",1,skillsRepo.insertSkillsRecords(skills.getEmp_Id(), skills.getCompetencies(), skills.getCertifications()));
		
	}
	
	@Test
	public void testEmpInsert2() throws IOException, SQLException {
Skills skills=new Skills();
		
		skills.setEmp_Id("100");
		skills.setCompetencies("Java");
		skills.setCertifications("Java");
		assertEquals("Emp record1 ",1,skillsRepo.insertSkillsRecords(skills.getEmp_Id(), skills.getCompetencies(), skills.getCertifications()));
		
	}

}


