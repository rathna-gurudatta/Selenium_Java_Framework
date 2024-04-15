package factories;

import enums.ConfigProperties;
import utils.ReadPropertyFile;

import java.io.IOException;
import java.sql.*;

public class SQLDBVERIFICATION {

    // for Oracle db_url: "jdbc:oracle:thin:@127.0.0.1:1521/sid"
    // for Oracle driver: "oracle.jdbc.driver.OracleDriver"
    //Mongo db port number: 27017

    public static Connection connection = null; // Connection object
    private static Statement statement; // Statement object
    private static ResultSet resultSet = null; // Result set
    private static final String DB_URL = ReadPropertyFile.getValue(ConfigProperties.DB_URL); // Constant for database url
    private static final String DB_USER = ReadPropertyFile.getValue(ConfigProperties.DB_USER);// Constant for database url
    private static final String DB_PASSWORD = ReadPropertyFile.getValue(ConfigProperties.DB_PASSWORD); // Constant for database password
    private static String driver = ReadPropertyFile.getValue(ConfigProperties.DB_PASSWORD); // JDBC driver


    public static Connection SQLDBVerification_DBConnect_Main() throws IOException
    {
        try
        {
            //Create connection object
            Class.forName(driver).newInstance();
            if(connection == null)
                connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            return connection;
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public static ResultSet ExecuteSelectQuery(String query) throws IOException, SQLException {
        try {
            statement = SQLDBVerification_DBConnect_Main().createStatement();
            return statement.executeQuery(query);
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new SQLException("Test case cannot be executed. Problem Executing Query");
        }

    }

    public static int ExecuteUpdateQuery(String query) throws IOException
    {
        try
        {

            return statement.executeUpdate(query);
        }
        catch (Exception ex) {
            ex.printStackTrace();
            throw new IOException();
        }
    }



}
