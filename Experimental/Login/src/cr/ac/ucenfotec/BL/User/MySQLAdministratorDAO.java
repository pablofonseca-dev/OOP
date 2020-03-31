package cr.ac.ucenfotec.BL.User;

import cr.ac.ucenfotec.Connector;

import java.sql.*;
import java.util.ArrayList;
import java.util.TreeMap;

public class MySQLAdministratorDAO implements IAdministrator{

    public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    public static final String URL = "jdbc:mysql://localhost:3306/";
    public static final String DATABASE = "logindatabase";
    public static final String USER = "root";
    public static final String PASSWORD = "mysqlserver82019Pass!";

    public static final String CONNECTION = URL + DATABASE;

    @Override
    public boolean signUpAdministrator(String firstName, String password, String email) throws SQLException, Exception {
        Connection connection = DriverManager.getConnection(CONNECTION, USER, PASSWORD);
        try {
            System.out.println("Connection opened");
            //Load MySQL Connector Driver
            Class.forName(DRIVER);
            //MySQL INSERT Statement
            String query = "INSERT INTO ADMINISTRATOR (AdministratorName, AdministratorEmail, AdministratorPassword)" +
                    "VALUES (?, ?, ?)";
            //MySQL Insert PreparedStatement
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, password);
            //Execute the PreparedStatement
            preparedStatement.execute();
            //Close the current connection
            connection.close();
            return true;
        }catch(SQLException sqlException) {
            System.err.println("Got an exception in administrator insert statement!");
            sqlException.printStackTrace();
            return false;
        }finally {
            if(connection != null){
                connection.close();
                System.out.println("Connection Closed");
            }
        }
    }

    @Override
    public boolean validateAdministratorExistence() throws SQLException, Exception {
        Connection connection = DriverManager.getConnection(CONNECTION, USER, PASSWORD);
        boolean administratorExistence  = false;
        try {
            System.out.println("Connection opened");
            //Load MySQL Connector Driver
            Class.forName(DRIVER);
            //MySQL SELECT Statement
            String query = "SELECT * FROM ADMINISTRATOR";
            //Create the Java Statement
            Statement statement = connection.createStatement();
            //Execute the query, and get a java Result Set
            ResultSet resultSet = statement.executeQuery(query);
            if(resultSet.next()){
                administratorExistence = true;
            }
        }catch(SQLException sqlException){
            System.err.println("Got an exception in administrator existence validation statement!");
            sqlException.printStackTrace();
            return false;
        }finally {
            if(connection != null){
                connection.close();
                System.out.println("Connection Closed");
            }
        }
        return administratorExistence;
    }

    @Override
    public boolean validateCredentials(String email, String password) throws SQLException, Exception {
        Connection connection = DriverManager.getConnection(CONNECTION, USER, PASSWORD);
        boolean credentialsCorrect = false;
        try{
            System.out.println("Connection Opened");
            //Load MySQL Connector Driver
            Class.forName(DRIVER);
            //MySQL Statement
            String query = "SELECT * FROM ADMINISTRATOR WHERE AdministratorEmail = ? AND AdministratorPassword = ?";
            //MySQL Insert PreparedStatement
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            //Execute PreparedStatement
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                credentialsCorrect = true;
            }
        }catch(SQLException sqlException){
            System.err.println("Got an exception in administrator credentials validation statement!");
            sqlException.printStackTrace();
            return false;
        }finally{
            if(connection != null){
                connection.close();
                System.out.println("Connection Closed");
            }
        }
        return credentialsCorrect;
    }

    @Override
    public TreeMap<String, Administrator> listUsers() throws SQLException, Exception {
        return null;
    }
}


