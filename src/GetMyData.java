import java.sql.*;

public class GetMyData {
    Connection connection;
    Statement statement;

    GetMyData() {
        try {
            String url = "jdbc:mysql://localhost:3306/UMS";
            String username = "root";
            String passwrod = "";
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, passwrod);
            statement = connection.createStatement();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

}
