/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.potatocorp.projectz.repository;

import com.potatocorp.projectz.entity.Course;
import com.potatocorp.projectz.tools.HibernateUtil;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author thoma
 */
public class MYSQLCourseDAO {
    
    public void saveNewCourse (Course c) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        System.out.println("Session created");

        Transaction tx = session.beginTransaction();

        session.save(c);

        tx.commit();
        
        System.out.println(c.getCode());
    }
    
    public ArrayList<Course> getCourses(){
        ArrayList<Course> courses = new ArrayList<Course>();
        Connection con = null;
        String sql = "SELECT * FROM COURSE";
        try {
            Class.forName("org.hibernate.dialect.MySQLDialect");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectz", "root", "root");
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery(sql);
            while(rs.next()){
                Course c = new Course(rs.getString("ID"),rs.getString("TITLE"));
                courses.add(c);
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
        return courses;   
    }
}
