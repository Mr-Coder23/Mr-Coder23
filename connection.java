package Mini_Banking;

import java.sql.Connection;
import java.sql.DriverManager;

public class connection { // Renamed class for clarity
    private static Connection con; // Global Connection Object

    public static Connection getConnection() {
        String url = "jdbc:mysql://localhost:3306/mydata"; // MySQL URL
        String user = "root"; // MySQL username
        String pass = "soauniversity"; // MySQL password

        try {
            // Optional for recent JDBC versions: Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, pass);
            System.out.println("Connection Successful!");
        } catch (Exception e) {
            System.out.println("Connection Failed! " + e.getMessage());
            e.printStackTrace();
        }

        return con;
    }
}
