<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=windows-1252"%>
<%@ page import="java.util.*" %>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=windows-1252"/>
    <title>Help</title>
  </head>
  <body>	
        <h1>Java Server Pages</h1>
	<hr/>
	<p>Java Server Pages can be as simple as this!</p>
	<hr/>
	<%= new Date() %>
        <%@ include file="name.html" %>
        <%! int x = 23; %>
        <% if (x > 20) {%>
            <H3>Someone set X to <%= x%>!</h3>
        <%}%>
</body>
</html>
