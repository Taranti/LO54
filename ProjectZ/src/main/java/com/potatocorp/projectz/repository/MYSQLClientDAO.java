/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.potatocorp.projectz.repository;

import com.potatocorp.projectz.entity.Client;
import com.potatocorp.projectz.tools.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author thoma
 */
public class MYSQLClientDAO {
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
    }
}
