<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=windows-1252"%>
<HTML>
<HEAD>
<TITLE>Expression Language Examples</TITLE>
</HEAD>

<BODY>

<H3>JSP Expression Language Examples</H3>
<P>
The following table contains some EL expressions and the result of evaluating them:

<TABLE BORDER="1">
  <THEAD>
    <TD><B>Expression</B></TD>
    <TD><B>Value</B></TD>
  </THEAD>
  <TR>
    <TD>\${2 + 5}</TD>
    <TD>${2 + 5}</TD>
  </TR>
  <TR>
    <TD>\${4/5}</TD>
    <TD>${4/5}</TD>
  </TR>
  <TR>
    <TD>\${5 div 6}</TD>
    <TD>${5 div 6}</TD>
  </TR>
  
  <TR>
    <TD>\${5 mod 7}</TD>
    <TD>${5 mod 7}</TD>
  </TR>
  <TR>
    <TD>\${2 < 3}</TD>
    <TD>${2 < 3}</TD>
  </TR>
  <TR>
    <TD>\${2 gt 3}</TD>
    <TD>${2 gt 3}</TD>
  </TR>
  <TR>
    <TD>\${3.1 le 3.2}</TD>
    <TD>${3.1 le 3.2}</TD>
  </TR>
  <TR>
    <TD>\${(5 > 3) ? 5 : 3}</TD>
    <TD>${(5 > 3) ? 5 : 3}</TD>
  </TR>
  <TR>
    <TD>\${header["host"]}</TD>
    <TD>${header["host"]}</TD>
  </TR>
  <TR>
    <TD>\${header["user-agent"]}</TD>
    <TD>${header["user-agent"]}</TD>
  </TR>

</TABLE>

</BODY>
</HTML>
