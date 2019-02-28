<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hello Page</title>
</head>
<body>
<% //scriptlet
 String str="Hello everyone";
%>

<h1><%=str.toUpperCase() %></h1>
<center>
<%
	for(int i=1;i<=6;i++){
		
%>
	<b><font size="<%= i%>">Hello World!!!</font><br/><b>
<% 	
	}
%>
</center>
</body>
</html>