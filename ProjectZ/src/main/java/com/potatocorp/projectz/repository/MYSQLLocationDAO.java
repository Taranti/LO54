/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.potatocorp.projectz.repository;

import com.potatocorp.projectz.entity.Location;
<<<<<<< HEAD
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
=======
import com.potatocorp.projectz.tools.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
>>>>>>> pierre

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
    
<<<<<<< HEAD
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
=======
    public Integer saveRecord (Location l) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        System.out.println("Session created");

        Transaction transactobj = session.beginTransaction();

        session.save(l);

        transactobj.commit();
        
        System.out.println("Succesfully Created " + l.toString());
        return l.getId();
    }
    
    public List<Location> getRecords(){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        
        Transaction transactobj = session.beginTransaction();
        
        List<Location> recordobj =  session.createQuery("FROM Location").list();
        
        transactobj.commit();
        
        return recordobj;
    }
    
    public void updateRecord(Location l){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        
        Transaction transactobj = session.beginTransaction();
        
        Location recordobj = (Location) session.load(Location.class, l.getId());
        recordobj.setCity(l.getCity());
        
        transactobj.commit();
        
        System.out.println("Succesfully Updated " + l.toString());
    }
    
    public void deleteRecord(Location l){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        
        Transaction transactobj = session.beginTransaction();
        
        Location recordobj = (Location) session.load(Location.class, l.getId());
        session.delete(recordobj);
        
        transactobj.commit();
        System.out.println("Succesfully Deleted " + l.toString());
>>>>>>> pierre
    }
}
