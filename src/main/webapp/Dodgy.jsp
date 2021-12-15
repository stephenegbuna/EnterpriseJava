<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=windows-1252" isErrorPage="true"
         import="java.io.CharArrayWriter, java.io.PrintWriter"%>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=windows-1252"/>
    <title>Dodgy</title>
  </head>
  <body><strong>DOH!</strong><br/><pre>
    <%
      if (exception != null) 
      { 
        out.println(exception.getMessage());
      } 
    %>
    </pre></body>
</html>