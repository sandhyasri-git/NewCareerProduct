package com.niit.skillmap.repository;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.niit.skillmap.config.EmployeeUtility;
import com.niit.skillmap.model.Employee;

public class EmployeeRepository {
	
	static EmployeeUtility utility=new EmployeeUtility();
	
	Employee employee;
	
	Connection con=null;
	
	PreparedStatement ps=null;
	
	String emp_Id,emp_Name,emp_Address,emp_Phno,emp_Email,emp_Qual,emp_IBU, emp_Center,emp_Desig, emp_Students,emp_Password,emp_role,emp_status;

	
	public EmployeeRepository() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmployeeRepository(String emp_Id, String emp_Name, String emp_Address, String emp_Phno, String emp_Email,
			String emp_Qual, String emp_IBU, String emp_Center, String emp_Desig, String emp_Students,
			String emp_Password,String emp_role,String emp_status) {
		
		this.emp_Id = emp_Id;
		this.emp_Name = emp_Name;
		this.emp_Address = emp_Address;
		this.emp_Phno = emp_Phno;
		this.emp_Email = emp_Email;
		this.emp_Qual = emp_Qual;
		this.emp_IBU = emp_IBU;
		this.emp_Center = emp_Center;
		this.emp_Desig = emp_Desig;
		this.emp_Students = emp_Students;
		this.emp_Password = emp_Password;
		this.emp_role=emp_role;
		this.emp_status=emp_status;
	}
	
	//To Insert Employee Records
	public int insertEmp() throws IOException, SQLException
	{
		con=utility.createConnection();
		
		employee=new Employee(emp_Id, emp_Name, emp_Address, emp_Phno, emp_Email,
			emp_Qual, emp_IBU, emp_Center, emp_Desig, emp_Students,emp_Password,emp_role,emp_status);
		
		System.out.println("Emp Repository Desig "+employee.getEmp_Designation()+" Password "+employee.getEmp_Password());
		
		ps=con.prepareStatement("insert into Employee values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
		
		ps.setString(1, employee.getEmp_Id());	
		
		ps.setString(2,employee.getEmp_Name());
        
        ps.setString(3,employee.getEmp_Address());
        ps.setString(4,employee.getEmp_Phone());
        ps.setString(5, employee.getEmp_Email());
                
        ps.setString(6, employee.getEmp_Qualification());
        
        ps.setString(7,employee.getEmp_IbuName());
        
        ps.setString(8,employee.getEmp_Center());
        
        ps.setString(9, employee.getEmp_Designation());
        
        ps.setString(10,employee.getEmp_Students());
        
        
        ps.setString(11, employee.getEmp_Password());  
        
        ps.setString(12, employee.getEmp_role());
        ps.setString(13, employee.getEmp_status());
               
        int x=ps.executeUpdate();
        
        System.out.println("Password "+employee.getEmp_Password()+" Desig: "+employee.getEmp_Designation());
        
        System.out.println("Inside Emp Repo");
        if(x>0)
        {
            System.out.println("Row inserted");
        }
        else
        {
            System.out.println("not inserted");
        }
        return 1;
        }
	
		
	public void deleteEmp(String code) throws IOException {
		con=utility.createConnection();
		try {
		    ps = con.prepareStatement("delete from employee where emp_id=?");
		    ps.setString(1, code);
		    int i = ps.executeUpdate();
		    if (i != 0) {
		        System.out.println("deleted");
		    } else {
		        System.out.println("not deleted");
		    }
		} catch (Exception e) {
		    e.printStackTrace();
		}
		}
	
	public void displayAll() {
		try {
		    Statement st = con.createStatement();
		    ResultSet res = st.executeQuery("select * from employee");
		    while (res.next()) {
		        System.out.print(res.getInt(1));
		        System.out.print(res.getString(2));
		        System.out.print(res.getString(3));
		        System.out.println(res.getString(4));
		    }
		} catch (SQLException e) {
		    e.printStackTrace();
		}
	}
	public int validateUser(String email,String password) throws IOException
	{
		con=utility.createConnection();
		int counter=0;
		try
		{
			ps=con.prepareStatement("Select * from employee where emailid=? and password=?");
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet resultSet=ps.executeQuery();
			while(resultSet.next())
				counter++;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();	
		}
		return counter;
		
		
	}
	
	public Employee getEmployeeData(String empEmail)
	{

		Employee employee=new Employee();
		try {
			ps = con.prepareStatement("select * from employee where emailid=?");
			ps.setString(1, empEmail);
			
			ResultSet resultSet=ps.executeQuery();
			while(resultSet.next())
			{
				
				employee.setEmp_Id(resultSet.getString(1));
				employee.setEmp_Name(resultSet.getString(2));
				employee.setEmp_Address(resultSet.getString(3));
				employee.setEmp_Phone(resultSet.getString(4));
				employee.setEmp_Email(resultSet.getString(5));
				employee.setEmp_Qualification(resultSet.getString(6));
				employee.setEmp_IbuName(resultSet.getString(7));
				employee.setEmp_Center(resultSet.getString(8));
				employee.setEmp_Designation(resultSet.getString(9));
				employee.setEmp_Students(resultSet.getString(10));
				employee.setEmp_Password(resultSet.getString(11));
				employee.setEmp_role(resultSet.getString(12));
				employee.setEmp_status(resultSet.getString(13));
				
						}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employee;
		
	}
	
	public int updateEmp(Employee employee,String id)
	{
		int count=0;
		try {
			ps = con.prepareStatement("update employee set emp_name=?,emp_address=?,emp_Ph=?,emp_Email=?,emp_Qualification=?,emp_ibuname=?,emp_Center=?,emp_designation=?,no_of_students=?,emp_Password=? where employeeId=?");
			
						
			ps.setString(1,employee.getEmp_Name());
			
			ps.setString(2,employee.getEmp_Address());
	        
			ps.setString(3,employee.getEmp_Phone());
			
	        ps.setString(4, employee.getEmp_Email());
	        
	        	                
	        ps.setString(5, employee.getEmp_Qualification());
	        
	        ps.setString(6,employee.getEmp_IbuName());
	        
	        ps.setString(7,employee.getEmp_Center());
	        
	        ps.setString(8, employee.getEmp_Designation());
	        
	        ps.setString(9,employee.getEmp_Students());
	        
	        
	        ps.setString(10, employee.getEmp_Password());  
	        
	        ps.setString(11, employee.getEmp_role());  
	        
	       
			count=ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return count;
	}

}
