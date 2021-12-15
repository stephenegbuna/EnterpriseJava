<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=windows-1252"
	errorPage="Dodgy.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type"
	content="text/html; charset=windows-1252" />
<title>Save Name</title>
</head>
<body>
	<FORM METHOD=POST ACTION="SaveName.jsp">
		First Name <INPUT TYPE=TEXT NAME=firstName SIZE=20><BR>
		Last Name <INPUT TYPE=TEXT NAME=lastName SIZE=20><BR> Tel
		<INPUT TYPE=TEXT NAME=tel SIZE=4>
		<P>
			<INPUT TYPE=SUBMIT>
	</FORM>
	<jsp:useBean id="user" class="jsp.UserData" scope="session" />
	<jsp:setProperty name="user" property="*" />
	You entered
	<BR> First Name:
	<%= user.getFirstName() %><BR> Last Name:
	<%= user.getLastName() %><BR> Tel:
	<%= user.getTel() %><BR>
</body>
</html>