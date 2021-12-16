package jdbc;

import java.sql.*;

public class EmployeeCallable {

    public static void main(String[] args) {
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            Connection conn = 
                DriverManager.getConnection("jdbc:mysql://localhost:3306/sat", 
                                            "user1", "Letmein_1");
            conn.setAutoCommit(false);
            Statement stat = conn.createStatement();
            String query = "select surname,salary from employee where job = 'Chairman'";
                
            ResultSet result = stat.executeQuery(query);
            while (result.next())
                System.out.println(result.getString("surname") + "\t" + 
                                   result.getString("salary"));
                                   
            CallableStatement cs = conn.prepareCall("{ call update_employee }");
            result = cs.executeQuery();
            
            result = stat.executeQuery(query);
            while (result.next())
                System.out.println(result.getString("surname") + "\t" + 
                                   result.getString("salary"));
            conn.commit();
            cs.close();
            stat.close();
            conn.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

