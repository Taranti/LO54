/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.potatocorp.projectz.repository;

import com.potatocorp.projectz.entity.Client;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author thoma
 */
public class MYSQLClientDAO {
    
    public void saveNewClient(Client c) {
        Connection con = null;
        try {
            Class.forName("org.hibernate.dialect.MySQLDialect");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectz", "root", "root");
            PreparedStatement ps = con.prepareStatement("INSERT INTO CLIENT(LAST_NAME,FIRST_NAME,ADDRESS,PHONE,EMAIL) VALUES(?,?,?,?,?)");
            ps.setString(1, c.getLastName());
            ps.setString(2, c.getLastName());
            ps.setString(3, c.getAddress());
            ps.setString(4, c.getPhone());
            ps.setString(5, c.getEmail());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    public ArrayList<Client> getClients(){
        ArrayList<Client> clients = new ArrayList<Client>();
        Connection con = null;
        String sql = "SELECT * FROM CLIENT";
        try {
            Class.forName("org.hibernate.dialect.MySQLDialect");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectz", "root", "root");
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery(sql);
            while(rs.next()){
                //Client c = new Client(rs.getInt("ID"),rs.getString("LAST_NAME"),rs.getString("FIRST_NAME"),rs.getString("ADDRESS"),rs.getString("PHONE"),rs.getString("EMAIL"));
                //clients.add(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();

            }
        }
        return clients;   
    }
}
