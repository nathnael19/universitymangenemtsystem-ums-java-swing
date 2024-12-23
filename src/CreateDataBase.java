import java.sql.*;

public class CreateDataBase {
    Statement statement;

    CreateDataBase() {
        String url = "jdbc:mysql://localhost:3306/";
        String username = "root";
        String passwrod = "";

        try (Connection connection = DriverManager.getConnection(url, username, passwrod)) {

            Class.forName("com.mysql.cj.jdbc.Driver");
            connection.setAutoCommit(true);
            statement = connection.createStatement();
            // Create DataBase
            try {            
                String createDatabase = "CREATE DATABASE IF NOT EXISTS UMS;";
                statement.executeUpdate(createDatabase);
                
                String useDB = "USE UMS;";
                statement.executeUpdate(useDB);

                //Create Student Leave Table
                String createStudentLeaveTable = "CREATE TABLE IF NOT EXISTS studentleave (" + "id VARCHAR(15)," + "date VARCHAR(20)," + "duration VARCHAR(20));";
                statement.executeUpdate(createStudentLeaveTable);

                //Create Student Table
                String createStudentTable = "CREATE TABLE IF NOT EXISTS students (" + "id VARCHAR(15)," + "firstName VARCHAR(20)," + "lastName VARCHAR(20)," + "dob VARCHAR(20)," + "address VARCHAR(20)," + "phoneNumber VARCHAR(15)," + "email VARCHAR(35)," + "department VARCHAR(30));";
                statement.executeUpdate(createStudentTable);

                //Create Teacher Leave Table
                String createTeacherLeaveTable = "CREATE TABLE IF NOT EXISTS teacherleave (" + "id VARCHAR(15)," + "date VARCHAR(20)," + "duration VARCHAR(20));";
                statement.executeUpdate(createTeacherLeaveTable);

                //Create Teacher Table
                String createTeacherTable = "CREATE TABLE IF NOT EXISTS teachers (" + "id VARCHAR(15)," + "firstName VARCHAR(20)," + "lastName VARCHAR(20)," + "dob VARCHAR(20)," + "address VARCHAR(20)," + "phoneNumber VARCHAR(15)," + "email VARCHAR(35)," + "department VARCHAR(30));";
                statement.executeUpdate(createTeacherTable);

                //Create Subject Table
                String createSubjectTable = "CREATE TABLE IF NOT EXISTS subject (" + "id VARCHAR(15)," + "semester VARCHAR(25)," + "sub1 VARCHAR(20)," + "sub2 VARCHAR(20)," + "sub3 VARCHAR(20)," + "sub4 VARCHAR(20)," + "sub5 VARCHAR(15));";
                statement.executeUpdate(createSubjectTable);

                //Create Mark Table
                String createMarkTable = "CREATE TABLE IF NOT EXISTS mark (" + "id VARCHAR(15)," + "semester VARCHAR(25)," + "mark1 VARCHAR(20)," + "mark2 VARCHAR(20)," + "mark3 VARCHAR(20)," + "mark4 VARCHAR(20)," + "mark5 VARCHAR(15));";
                statement.executeUpdate(createMarkTable);

            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }

        } catch (Exception e) {
            // TODO: handle exception
        }

    }

}
