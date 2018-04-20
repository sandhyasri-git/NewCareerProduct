<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table border=1>
		<tr>
			<th>Employee Id:</th>
			<td>${requestScope.employee.emp_Id}</td>
		</tr>
		<tr>
			<th>Employee Name:</th>
			<td>${requestScope.employee.emp_Name}</td>
		</tr>
		<tr>
			<th>Email:</th>
			<td>${requestScope.employee.emp_Email}</td>
			</tr>
		<tr>
			<th>Phone:</th>
			<td>${requestScope.employee.emp_Ph}</td>
			
		</tr>

		<tr>
			<th>Qualification:</th>
			<td>${requestScope.employee.emp_Qualification}</td>
		</tr>
		<tr>
			<th>Center :</th>
			<td>${requestScope.employee.emp_center}</td>
		</tr>
		<tr>
			<th>Designation:</th>
			<td>${requestScope.employee.emp_designation}</td>
		</tr>

		<tr>
			<td colspan=2><a
				href="edit?employeeId=${requestScope.employee.emp_Id}">Edit</a></td>
		</tr>
	</table>
</body>
</html>