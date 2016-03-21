/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author richou
 */
public class Request {
    String driverClass;
    String url;
    String user;
    String pass;
    Connection connection;

    public Request() throws SQLException {
        driverClass = "com.mysql.jdbc.Driver";
        url = "jdbc:mysql://localhost:3306/POO_TP3";
        user = "richou";
        pass = "rIchOU";
        try {
            Class.forName(driverClass);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Request.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
        connection = DriverManager.getConnection(url, user, pass);
    }
    
    public Collection<Person> getPeople() throws SQLException {
        Collection<Person> people = new ArrayList<>();
        String request = "SELECT * FROM PERSON";
        
        ResultSet rs = connection.createStatement().executeQuery(request);
        
        while(rs.next()) {
            people.add(new Person(rs.getString("first"), rs.getString("last")));
        }
        
        return people;
    }
    
    public void registerPerson(Person p) throws SQLException {
        String request = "INSERT INTO PERSON VALUES (null, ?, ?)";
        
        PreparedStatement ps = connection.prepareCall(request);
        ps.setString(1, p.getFirstName());
        ps.setString(2, p.getLastName());
        
        ps.execute();
    }
}
