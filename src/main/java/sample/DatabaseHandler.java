package sample;


import model.Doctor;
import model.Patient;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class DatabaseHandler extends Configs {

    Connection dbConnection;

    public Connection getDbConnection()
        throws ClassNotFoundException, SQLException{
       // String connectionString = "jdbc:h2://"+ dbHost + ":"+ dbPort + "/"+ dbName +"?autoReconnect=true&useSSL=false";
        Class.forName("org.h2.Driver");

        dbConnection = DriverManager.getConnection("jdbc:h2:"+"./Database/dantistApp","root","root");
        return dbConnection;
    }



    }


