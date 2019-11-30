/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.potatocorp.projectz.repository;

import com.potatocorp.projectz.entity.CourseSession;
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
public class MYSQLCourseSessionDAO {
    
    public Integer saveRecord (CourseSession cs) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        System.out.println("Session created");

        Transaction transactobj = session.beginTransaction();

        session.save(cs);

        transactobj.commit();
        
        System.out.println("Succesfully Created " + cs.toString());
        return cs.getId();
    }
    
    public List<CourseSession> getRecords(){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        
        Transaction transactobj = session.beginTransaction();
        
        List<CourseSession> recordobj =  session.createQuery("FROM CourseSession").list();
        
        transactobj.commit();
        
        return recordobj;
    }
    
    public void updateRecord(CourseSession cs){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        
        Transaction transactobj = session.beginTransaction();
        
        CourseSession recordobj = (CourseSession) session.load(CourseSession.class, cs.getId());
        recordobj.setStartDate(cs.getStartDate());
        recordobj.setEndDate(cs.getEndDate());
        recordobj.setMax(cs.getMax());
        recordobj.setCourse(cs.getCourse());
        recordobj.setLocation(cs.getLocation());
                
        transactobj.commit();
        
        System.out.println("Succesfully Updated " + cs.toString());
    }
    
    public void deleteRecord(CourseSession cs){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        
        Transaction transactobj = session.beginTransaction();
        
        CourseSession recordobj = (CourseSession) session.load(CourseSession.class, cs.getId());
        session.delete(recordobj);
        
        transactobj.commit();
        System.out.println("Succesfully Deleted " + cs.toString());
    }
}
