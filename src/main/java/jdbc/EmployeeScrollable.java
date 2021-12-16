package jdbc;

import java.sql.*;

public class EmployeeScrollable {

    public static void main(String[] args) {
        try {
            String connString = "jdbc:mysql://localhost:3306/sat";
            String user = "user1";
            String password = "Letmein_1";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = 
                DriverManager.getConnection(connString, user, password);
            Statement stat = 
                conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, 
                                     ResultSet.CONCUR_READ_ONLY);

            ResultSet result = stat.executeQuery("SELECT * FROM Employee");

            while (result.next()) {
                StringBuffer rowText = new StringBuffer("");
                rowText.append(result.getString("SURNAME") + "\t");
                rowText.append(result.getString("JOB") + "\t");
                rowText.append(result.getDouble("SALARY") + "\t");
                System.out.println(rowText.toString());
            }

            result.close();
            stat.close();
            conn.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
