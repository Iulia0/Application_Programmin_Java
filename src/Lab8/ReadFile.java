package Lab8;

import java.io.*;
import java.security.AccessControlException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class ReadFile {
    String filePath = "C:\\Users\\petri\\Desktop\\essex\\2. Second year\\CE203-5-AU-CO Application Programming\\orders_2.txt";
    Connection connection;
    ReadFile(Connection connection) throws SQLException, IOException {
        this.connection = connection;

        String sql = "INSERT INTO orders (orderid, custid, goods, price) values (?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);

        try {
            Scanner in = new Scanner(new File(filePath));
            //       while(in.hasNextLine()){
            statement.setInt(1, Integer.parseInt(in.next()));
            statement.setInt(2, Integer.parseInt(in.next()));
            statement.setString(3, in.next());
            statement.setDouble(4, Double.parseDouble(in.next()));
            statement.executeUpdate();
            //      }
        }
        catch(AccessControlException ace ){
            System.out.println( "Read access not allowed." );
        }

       // System.out.println("Update successful");
    }
}

