/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.potatocorp.projectz.repository;

import com.potatocorp.projectz.entity.Client;
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
public class MYSQLClientDAO {
<<<<<<< HEAD
    
    public void saveNewClient(Client c) {
        Connection con = null;
        try {
            Class.forName("org.hibernate.dialect.MySQLDialect");
            //con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectz", "root", "root");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3308/projectz", "root", "root");
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
            //con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectz", "root", "root");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3308/projectz", "root", "root");
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery(sql);
            while(rs.next()){
                Client c = new Client(rs.getInt("ID"),rs.getString("LAST_NAME"),rs.getString("FIRST_NAME"),rs.getString("ADDRESS"),rs.getString("PHONE"),rs.getString("EMAIL"));
                clients.add(c);
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
=======
    public Integer saveRecord (Client c) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        System.out.println("Session created");

        Transaction transactobj = session.beginTransaction();

        session.save(c);

        transactobj.commit();
        
        System.out.println("Succesfully Created " + c.toString());
        return c.getId();
    }
    
    public List<Client> getRecords(){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        
        Transaction transactobj = session.beginTransaction();
        
        List<Client> recordobj =  session.createQuery("FROM Client").list();
        
        transactobj.commit();
        
        return recordobj;
    }
    
    public void updateRecord(Client c){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        
        Transaction transactobj = session.beginTransaction();
        
        Client recordobj = (Client) session.load(Client.class, c.getId());
        recordobj.setLastName(c.getLastName());
        recordobj.setFirstName(c.getFirstName());
        recordobj.setAddress(c.getAddress());
        recordobj.setPhone(c.getPhone());
        recordobj.setEmail(c.getEmail());
        recordobj.setSession(c.getSession());
                
        transactobj.commit();
        
        System.out.println("Succesfully Updated " + c.toString());
    }
    
    public void deleteRecord(Client c){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        
        Transaction transactobj = session.beginTransaction();
        
        Client recordobj = (Client) session.load(Client.class, c.getId());
        session.delete(recordobj);
        
        transactobj.commit();
        System.out.println("Succesfully Deleted " + c.toString());
>>>>>>> pierre
    }
}
