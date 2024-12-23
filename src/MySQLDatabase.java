import java.sql.*;

public class MySQLDatabase {

    private Connection connection;

    MySQLDatabase() {

        try {
            String url = "jdbc:mysql://localhost:3306/UMS";
            String username = "root";
            String passwrod = "";
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            connection = DriverManager.getConnection(url, username, passwrod);
            connection.commit();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
