package jdbc;

import java.sql.*;

public class CustomerQuery {

    public static void main(String[] args) {
        try {
            String connString = "jdbc:mysql://localhost:3306/sat";
            String user = "user1";
            String password = "Letmein_1";
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            //Class.forName("oracle.jdbc.OracleDriver");
            //System.setProperty("jdbc.drivers","oracle.jdbc.OracleDriver");
            Connection conn = 
                DriverManager.getConnection(connString, user, password);
            Statement stat = conn.createStatement();
            ResultSet result = stat.executeQuery("select * from customer");
            while (result.next())
                System.out.println(result.getString("surname") + "\t" + 
                                   result.getString("town"));
            System.out.println(result.getFetchSize() + " rows retrieved");
            result.close();
            stat.close();
            conn.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
