/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.potatocorp.projectz.core;

import com.potatocorp.projectz.entity.Course;
import com.potatocorp.projectz.repository.MYSQLCourseDAO;
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
        MYSQLCourseDAO m = new MYSQLCourseDAO();
        m.saveNewCourse(new Course("CODE4","TITRE"));
    }
    
}
