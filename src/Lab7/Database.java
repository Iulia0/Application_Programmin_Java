package Lab7;
import java.sql.*;

public class Database {
    public static void main(String[] args) {
        Connection connection = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver loaded");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/orderdb", "root", "root");
            // past experience has shown that using the one-argument version of getConnection doesn't work for some students
        } catch (ClassNotFoundException e) {
            System.out.println("driver not found");
            System.exit(1);
        } catch (SQLException e) {
            System.out.println("failed to connect to Database");
            System.exit(1);
        }

        Statement statement = null;

        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            System.out.println("failed to access Database");
            System.exit(1);
        }

        queryDatabase(statement);

        try {
            statement.close();
            connection.close();
            System.out.println("Connection closed");
        } catch (SQLException e) {
            System.out.println("problems closing connection");
            System.exit(1);
        }
    }
     //display some queries
    static void queryDatabase(Statement statement) {
        ResultSet query = null;
        ResultSet price = null;
        try {
            statement.executeUpdate("DELETE FROM customers " + "WHERE custid = 6");
            statement.executeUpdate("DELETE FROM customers " + "WHERE custid = 7");
            statement.executeUpdate("DELETE FROM orders " + "WHERE orderid = 8");
            statement.executeUpdate("DELETE FROM orders " + "WHERE orderid = 9");

            statement.executeUpdate("INSERT INTO customers " + "VALUES (6,'Ian Daly', 'i.daly@essex.ac.uk')");
            statement.executeUpdate("INSERT INTO customers " + "VALUES (7,'Iulia Petria', 'petria_iulia@yahoo.com')");
            statement.executeUpdate("INSERT INTO orders " + "VALUES(8,6,'java course', 9999.00)");
            statement.executeUpdate("INSERT INTO orders " + "VALUES (9,7,'MacBook', 899.00)");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            query = statement.executeQuery("SELECT custid, name FROM customers");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            System.out.println("CustId| Name");
            while (query.next()) {
                System.out.print( "     " + query.getObject(1) + "|");
                System.out.println( query.getObject(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            price= statement.executeQuery("SELECT * FROM orders WHERE price > 20");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            System.out.println();
            System.out.println("Price > 20");
            System.out.println("orderid|CustId                  |goods                        |price                                     ");
            while (price.next()) {
                System.out.print("      " + price.getObject(1));
                System.out.print("|" + price.getObject(2));
                System.out.print("                       |" + price.getObject(3) );
                System.out.println("                    |" + price.getObject(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
