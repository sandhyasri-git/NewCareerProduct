package com.niit.skillsfront.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.niit.skillmap.model.Employee;
import com.niit.skillmap.repository.EmployeeRepository;

/**
 * Servlet implementation class UpdateController
 */
@WebServlet("/update")
public class UpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session= request.getSession();
		String employeeId=request.getParameter("eid");
		String employeeName=request.getParameter("name");
		String employeePhone=request.getParameter("phone");
		String employeeEmail=request.getParameter("email");
		String employeeCity=request.getParameter("city");
		String employeeQualification=request.getParameter("qualification");
		String employeeSkill=request.getParameter("skill");
		String employeeCertification=request.getParameter("certification");
		
		Employee employee=new Employee();
		employee.setEmp_Id(employeeId);
		employee.setEmp_Name(employeeName);
		employee.setEmp_Phone(employeePhone);
		employee.setEmp_Email(employeeEmail);
		employee.setEmp_Qualification(employeeQualification);
		
		
		EmployeeRepository repository=new EmployeeRepository();
		int status=repository.updateEmp(employee, employeeId);
		if(status>0)
		{		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/mydata.jsp");
	        request.setAttribute("employee", employee);
	        dispatcher.forward(request, response);
			
		}
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
