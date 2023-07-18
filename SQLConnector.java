package com.example.jvm_lm;
import  java.sql.*;

import static java.sql.DriverManager.getConnection;

public class SQLConnector {

    public Connection createConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/lmela","root","");
    }
}