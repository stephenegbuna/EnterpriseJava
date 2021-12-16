<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=windows-1252" errorPage="Dodgy.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<TITLE>More Names</TITLE>
</HEAD>

<BODY>

<P>
<!-- The square brackets below are more flexible than the dot notation
The dot only works for bean properties, ie user.firstName in the last example-->
<FORM action="SaveName.jsp" method="GET">
   First Name <input type="text" name="firstName" value="${param['firstName']}"><br>
   Last Name       <input type="text" name="lastName" value="${param['lastName']}"><br>
   Tel       <input type="text" name="tel" value="${param['tel']}">
          <input type="submit" value="Submit Name">
</FORM>

<P>
First Name: ${param.firstName}<br>
Last Name:  ${param.lastName}<br>
Tel:        ${param.tel}

</body>
</html>