/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.potatocorp.projectz.core;

import com.potatocorp.projectz.entity.Course;
import com.potatocorp.projectz.tools.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author thoma
 */
public class App {
    
    public static void main(String[] args){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        System.out.println("Session created");

        Transaction tx = session.beginTransaction();

        Course c = new Course("CODE3","Titre");
        session.save(c);

        tx.commit();
        
        System.out.println(c.getCode());
    }
    
}
