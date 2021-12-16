package jdbc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class DataSourceUser
 */
@WebServlet("/DataSourceUser")
public class DataSourceUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		try {
			Context ctx = new InitialContext();
			//Context envContext  = (Context) ctx.lookup("java:/comp/env");
			DataSource ds = (DataSource) ctx.lookup("java:/MySqlDS");
			Connection conn = ds.getConnection();
			Statement stat = conn.createStatement();
			ResultSet result = stat.executeQuery("select * from employee");
			while (result.next())
                out.println("<h2>" + result.getString("surname") + "</h2>");
		} catch (SQLException | NamingException e) {
			e.printStackTrace();
		}
	}	

}
