<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
</head>
<body>

 <c:forEach var="error" items="${requestScope.error}" varStatus="status">
 
   	 <div><font color="red">${error}</font></div>
   	 
</c:forEach>

	<form action="Registration" method="post">
		<table>
			<tr>
				<td>Employee ID</td>
				<td><input type="text" name="empId"></td>
			</tr>
			<tr>
				<td>Employee Name</td>
				<td><input type="text" name="empName"></td>
			</tr>
			<tr>
				<td>Address</td>
				<td><textarea rows="10" cols="20" name="empAddress"></textarea></td>
			</tr>
			<tr>
				<td>EmailId</td>
				<td><input type="email" name="empEmail" value="${requestScope.employee.emp_Email}"></td>
			</tr>
			<tr>
				<td>Qualifications</td>
				<td><textarea rows="10" cols="20" name="empQual"></textarea></td>
			</tr>
			<tr>
				<td>IBU Name</td>
				<td><input type="text" name="empIBU"></td>
			</tr>
			<tr>
				<td>Center Code</td>
				<td><input type="text" name="empCenter"></td>
			</tr>
			<tr>
				<td>Designation</td>
				<td><input type="text" name="empDesig"></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="empPassword"></td>
			</tr>
			<tr>
				<td>Confirm Password</td>
				<td><input type="password" name="empCPassword"></td>
			</tr>
			<tr>
				<td>Students Taught</td>
				<td><input type="text" name="students"></td>
			</tr>
			<tr>
				<td>Phone Number</td>
				<td><input type="text" name="empPh" value="${requestScope.employee.emp_Ph}"></td>
			</tr>
			<tr ><td></td>
			<td>HR<input name="role"  type="radio" value="hr">
  Employer<input name="role" type="radio" value="employer">
  Employee<input name="role" type="radio" value="employee">
  </td></tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Register"></td>
			</tr>

		</table>
		<div>
		<a href="login">Login Here</a>
		</div>
	</form>

</body>
</html>