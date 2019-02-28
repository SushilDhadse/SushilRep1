<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form method="get" action="login.page">
		<table align="center" style="border-style: solid" width="290"
			height="150" bgcolor="#99ccff">
			<tr>
				<td><b>USER ID:</b></td>
				<td bgcolor="#80bfff"><input type="text" name="uid" /></td>
			</tr>
			<tr>
				<td><b>PASSWORD:</b></td>
				<td bgcolor="#80bfff"><input type="password" name="pass" /></td>
			</tr>
			<tr>
				<td><button type="submit">
						<b>VERIFY</b>
					</button></td>


			</tr>

		</table>


	</form>
				<%
	String message=(String) session.getAttribute("invalid");				
	if(message!=null)
	out.println("<b>" +message +"</b>");
	session.removeAttribute("message");
				%>
</body>
</html>