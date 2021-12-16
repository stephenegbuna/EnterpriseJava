package jdbc;

import java.sql.*;

public class TableMetadata {

    public static void main(String[] args) {

        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/sat";
        String username = "user1";
        String password = "Letmein_1";
        String sql = "SELECT * FROM employee";
        Connection con = null;
        Statement stat = null;
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, username, password);
            stat = con.createStatement();

            String output;
            ResultSet result = stat.executeQuery(sql);
            ResultSetMetaData meta = result.getMetaData();

            for (int i = 1; i <= meta.getColumnCount(); i++) {
                output = meta.getColumnName(i) + "\t" + 
                        meta.getColumnTypeName(i) + "\t";
                if (meta.isNullable(i) == 0)
                    output = output + "NOT NULL";
                System.out.println(output);
            }
            result.close();
            stat.close();
            con.close();
        } catch (ClassNotFoundException e) {
            System.out.println("Driver problems.");
        } catch (SQLException e) {
            System.out.println("Connection or statement problems.");
        } catch (Exception e) {
            e.getMessage();
        }
    }    
}   

