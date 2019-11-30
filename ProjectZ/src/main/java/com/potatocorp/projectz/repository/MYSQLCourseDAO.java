/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.potatocorp.projectz.repository;

import com.potatocorp.projectz.entity.Course;
import com.potatocorp.projectz.tools.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author thoma
 */
public class MYSQLCourseDAO {
    
    public String saveRecord (Course c) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        System.out.println("Session created");

        Transaction transactobj = session.beginTransaction();

        session.save(c);

        transactobj.commit();
        
        System.out.println("Succesfully Created " + c.toString());
        return c.getCode();
    }
    
    public List<Course> getRecords(){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        Transaction transactobj = session.beginTransaction();
        List<Course> cs =  session.createQuery("FROM Course").list();
        transactobj.commit();
        return cs;
    }
    
    public void updateRecord(Course c){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        
        Transaction transactobj = session.beginTransaction();
        
        Course cobj = (Course) session.load(Course.class, c.getCode());
        cobj.setTitle(c.getTitle());
        
        transactobj.commit();
        
        System.out.println("Succesfully Updated " + c.toString());
    }
    
    public void deleteRecord(Course c){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        
        Transaction transactobj = session.beginTransaction();
        
        Course cobj = (Course) session.load(Course.class, c.getCode());
        session.delete(cobj);
        
        transactobj.commit();
        System.out.println("Succesfully Deleted " + c.toString());
    }
}
