/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.potatocorp.projectz.repository;

import com.potatocorp.projectz.entity.Location;
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
public class MYSQLLocationDAO {
    public void saveNewLocation(Location l) {
        Connection con = null;
        try {
            Class.forName("org.hibernate.dialect.MySQLDialect");
            //con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectz", "root", "root");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3308/projectz", "root", "root");
            PreparedStatement ps = con.prepareStatement("INSERT INTO LOCATION(CITY) VALUES(?)");
            ps.setString(1, l.getCity());
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
    
    public ArrayList<Location> getLocations(){
        ArrayList<Location> locations = new ArrayList<Location>();
        Connection con = null;
        String sql = "SELECT * FROM CLIENT";
        try {
            Class.forName("org.hibernate.dialect.MySQLDialect");
            //con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectz", "root", "root");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3308/projectz", "root", "root");
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery(sql);
            while(rs.next()){
                Location l = new Location(rs.getInt("ID"),rs.getString("CITY"));
                locations.add(l);
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
        return locations;   
    }
}
