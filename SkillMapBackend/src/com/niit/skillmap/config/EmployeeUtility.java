package com.niit.skillmap.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class EmployeeUtility {
	
	//Connection Object
	Connection con=null;
	
	//Database UserName
	String userName=null;
	
	//Database Password
	String password=null;
	
	//Driver Class to be used
	String driverClass=null;
	
	//Database URL which to be supplied to getConnection Method
	String url=null;
	
	//Properties File Name
	String propFileName = "D:\\CEB_Project\\SkillMapBackend\\dbdetails.properties";
	
	private static Properties properties;
	
	public Connection createConnection() throws IOException
	{
		try {
				
			File file = new File(propFileName);
			
			FileInputStream fileInput = new FileInputStream(file);
			
			properties = new Properties();
			
			properties.load(fileInput);
			
			fileInput.close();
			
			userName = properties.getProperty("db_user");
			
			password = properties.getProperty("db_password");
			
			driverClass = properties.getProperty("db_driver");
			
			url = properties.getProperty("db_url");
			
			System.out.println(userName+" "+driverClass+"  "+url);
			
			Class.forName(driverClass); //class not found exception
			
			con = DriverManager.getConnection(url, userName, password);
			
			System.out.println("Connection Established");
			
			System.out.println("Inside Utility");
		}
	 catch (Exception e) {
		
		 System.out.println("Exception: " + e);
	} 
		return con;
	}

}
