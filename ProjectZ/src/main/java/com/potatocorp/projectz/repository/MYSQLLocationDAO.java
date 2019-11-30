/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.potatocorp.projectz.repository;

import com.potatocorp.projectz.entity.Location;
import com.potatocorp.projectz.tools.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author thoma
 */
public class MYSQLLocationDAO {
    
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
    }
}
