package com.niit.skillsfront.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.niit.skillsbackend.config.EmployeeUtility;
import com.niit.skillsbackend.repository.EmpRepo;

/**
 * Servlet implementation class RegistrationController
 */
@WebServlet("/Registration")
public class RegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EmpRepo emp;
	
	public RegistrationController() {
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/views/Registration.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		//request.getRequestDispatcher(getServletContext().getInitParameter("views")+"Registration.jsp").forward(request, response);	
		String empId=request.getParameter("empId");
		String empName=request.getParameter("empName");
		String empAddress=request.getParameter("empAddress");
		String empPh=request.getParameter("empPh");
		//System.out.println("EmpID "+str1);
		String empEmail=request.getParameter("empEmail");
		String empQual=request.getParameter("empQual");
		String empIBU=request.getParameter("empIBU");
		String empCenter=request.getParameter("empCenter");
		String empDesig=request.getParameter("empDesig");
		String students=request.getParameter("students");
		String empPassword=request.getParameter("empPassword");
		String empCPassword=request.getParameter("empCPassword");
		
		System.out.println(empId+" "+ empName+" , "+ empAddress+", "+ empPh+ ","+ empEmail+ ", "+ empQual+ ","+ empIBU+ ","+ empCenter+","+ empDesig+","+ students +","+ empPassword);
		int i=-1;
		try {
			
			emp=new EmpRepo(empId, empName, empAddress, empPh, empEmail, empQual, empIBU, empCenter, empDesig, students, empPassword);
			try {
				i=emp.insertRecords(empId, empName, empAddress, empPh, empEmail, empQual, empIBU, empCenter, empDesig, students, empPassword);
				if(i>0)
				{
					System.out.println("Inserted");
					RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/views/login.jsp");
					rd.include(request, response);
					
				}
				else
				{
					System.out.println("Not inserted");
				}
			} catch (ClassNotFoundException  e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (SQLException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
