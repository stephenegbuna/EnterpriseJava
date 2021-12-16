package jdbc;

import java.sql.*;

public class OrdersUpdatable {
    public static void main(String[] args) {
        try {
            String connString = "jdbc:mysql://localhost:3306/sat";
            String user = "user1";
            String password = "Letmein_1";
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            Connection conn = 
                DriverManager.getConnection(connString, user, password);
                
            Statement stat = conn.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE, 
                    ResultSet.CONCUR_UPDATABLE);

            ResultSet result = stat.executeQuery(
                "SELECT ORDER_NR,PRODUCT_CODE, CUSTOMER_NR, ORDER_DATE, QUANTITY " +
                "FROM ORDERS");
            
            // Move to the fourth row to update one of its columns
            result.absolute(4);
            result.updateString("ORDER_DATE","2019-04-27 00:00:00.0");
            result.updateRow();

            result.moveToInsertRow();
            result.updateInt("ORDER_NR", 1050);
            result.updateString("PRODUCT_CODE", "AM17");
            result.updateInt("CUSTOMER_NR", 1317);
            result.updateDate("ORDER_DATE",null);
            result.updateInt("QUANTITY", 100);
            result.insertRow();
            
            // Return to the fourth row of the resultset
            result.moveToCurrentRow();

            result.close();
            stat.close();
            conn.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
