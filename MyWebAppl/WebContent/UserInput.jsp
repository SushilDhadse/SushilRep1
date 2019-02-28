<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form method="get" action="EmployeeServlet">
		<table align="center" style="border-style: solid" width="290"
			height="150" bgcolor="#99ccff">
			<tr>
				<td><b>Employee ID:</b></td>
				<td bgcolor="#80bfff"><input type="text" name="ename" /></td>
			</tr>
				<td><button type="submit">
						<b>Info</b>
					</button></td>
			</tr>
		</table>
	</form>
<%-- 				<%
	String message=(String) session.getAttribute("invalid");				
	if(message!=null)
	out.println("<b>" +message +"</b>");
	session.removeAttribute("message");
				%> --%>
</body>
</html>