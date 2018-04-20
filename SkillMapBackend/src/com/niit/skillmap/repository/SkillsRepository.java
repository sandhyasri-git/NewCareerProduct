package com.niit.skillmap.repository;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.niit.skillmap.config.EmployeeUtility;
import com.niit.skillmap.model.Skills;


public class SkillsRepository {
	
	static EmployeeUtility utility=new EmployeeUtility();
	Skills skills;
	
	Connection con=null;
	PreparedStatement ps;
	String emp_id,competencise,certifications;
	
	public SkillsRepository(String emp_id, String competencise, String certifications) {
		
		this.emp_id = emp_id;
		this.competencise = competencise;
		this.certifications = certifications;
	}
	public SkillsRepository() {
		
	}
	public int insertSkillsRecords(String empId,String comp,String certfications) throws IOException, SQLException
    {
		con=utility.createConnection();
		skills=new Skills(empId,comp,certfications);
		System.out.println("Emp Repo "+skills.getEmp_Id()+" "+skills.getCertifications()+" "+skills.getCompetencies());
       
       
        ps=con.prepareStatement("insert into Skills values(?,?,?)");
        
        ps.setString(1,skills.getEmp_Id());
        
        ps.setString(2,skills.getCompetencies());
        
        ps.setString(3,skills.getCertifications());
        
        int x=ps.executeUpdate();
        if(x>0)
        {
            System.out.println("Row inserted");
        }
        else
        {
            System.out.println("not inserted");
        }
        return 0;
        }
	
	
	public void dispAll() {
		try {
		    Statement st = con.createStatement();
		    ResultSet res = st.executeQuery("select * from skills");
		    while (res.next()) {
		        System.out.print(res.getString(1));
		        System.out.print(res.getString(2));
		        System.out.print(res.getString(3));
		      
		    }
		} catch (SQLException e) {
		    e.printStackTrace();
		}
	}

}
