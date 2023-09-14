/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 *
 * @author DELL
 */
public class DbConnectionFactory {
    
    private Connection connection;
    private static DbConnectionFactory instance;

    public DbConnectionFactory() {
    }

    public Connection getConnection() throws Exception {
        if(connection == null || connection.isClosed()){
            Properties properties = new Properties();
            properties.load(new FileInputStream("config/dbconfig.properties"));
                
            String url = properties.getProperty("url");
            String user = properties.getProperty("username");
            String password = properties.getProperty("password");
            connection = DriverManager.getConnection(url, user, password);
            connection.setAutoCommit(false);
        }
        return connection;
    }

    public static DbConnectionFactory getInstance() {
        if(instance == null){
            instance = new DbConnectionFactory();
        }
        return instance;
    }
    
}
