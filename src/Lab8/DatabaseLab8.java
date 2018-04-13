package Lab8;

import java.security.AccessControlException;
import java.security.Permission;
import java.sql.*;
import java.util.Vector;

public class DatabaseLab8 {
    public static void main(String[] args) {
        Connection connection = null;

        // Enable the security manager
        try {
            SecurityManager securityManager = new SecurityManager();
            System.setSecurityManager(securityManager);
        }
        catch(AccessControlException ace ){
            System.out.println( "Read access not allowed." );
        }
        catch (SecurityException se) {

        }


        Permission perm = new java.io.FilePermission("C:\\Users\\petri\\Desktop\\essex\\2. Second year\\CE203-5-AU-CO Application Programming", "read");
        SecurityManager sm = System.getSecurityManager();
        if (sm != null) {
            sm.checkPermission(perm);
   }


        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver loaded");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/orderdb", "root", "root");

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
        // ---------------------------- new ReadFile
        try {
            ReadFile oo = new ReadFile(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }

        //----------------------------------
        queryDatabase(statement);

        try {
            statement.close();
            connection.close();
            System.out.println();
            System.out.println("Connection closed");
        } catch (SQLException e) {
            System.out.println("problems closing connection");
            System.exit(1);
        }
    }


    static void queryDatabase(Statement statement) {
        ResultSet price = null;
        Vector names = new Vector(5);
        ResultSet findName = null;
        ResultSet findNameQuery = null;

   //     try {
   //         statement.executeUpdate("INSERT INTO orders " + "VALUES (8,3,'MacBook', 899.00)");
     //       statement.executeUpdate("INSERT INTO customers " + "VALUES (6,'Ian Daly', 'i.daly@essex.ac.uk')");
      //  statement.executeUpdate("INSERT INTO customers " + "VALUES (7,'Iulia Petria', 'petria_iulia@yahoo.com')");
    //    statement.executeUpdate("INSERT INTO orders " + "VALUES(8,6,'java course', 9999.00)");
      //  statement.executeUpdate("INSERT INTO orders " + "VALUES (9,7,'MacBook', 899.00)");
    //    } catch (SQLException e) {
    //        e.printStackTrace();
     //   }

        try {
            findName = statement.executeQuery("SELECT custid, name FROM customers");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            while (findName.next()) {
                names.add(findName.getObject(2));
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
            price= statement.executeQuery("SELECT * FROM orders WHERE price > 20");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            System.out.println("Customers who have placed orders greater than 20");
            System.out.println("First approach");
            System.out.println("Name");
            System.out.println();
            while (price.next()) {
                System.out.println(names.elementAt((Integer)price.getObject(2)-1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            findNameQuery= statement.executeQuery("SELECT customers.name, orders.custid from customers inner join orders ON customers.custid = orders.custid WHERE price > 20 ");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            System.out.println();
            System.out.println("Second approach, INNER JOIN");
            System.out.println("Name");
            System.out.println();
            while (findNameQuery.next()) {
                System.out.println(findNameQuery.getObject(1));
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }
}




