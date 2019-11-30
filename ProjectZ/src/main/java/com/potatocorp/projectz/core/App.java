/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.potatocorp.projectz.core;

import com.potatocorp.projectz.entity.Course;
import com.potatocorp.projectz.repository.MYSQLCourseDAO;
import java.util.List;

/**
 *
 * @author thoma
 */
public class App {
    
    public static void main(String[] args){
        MYSQLCourseDAO m = new MYSQLCourseDAO();
        String n = m.saveRecord(new Course("CODE7","TITRE"));
        List<Course> crss = m.getRecords();
        Course c = new Course("CODE7", "TITRE2");
        m.updateRecord(c);
        try {
            Thread.sleep(3000);
        }  catch (InterruptedException e) {
            System.out.println(e);
        }
        m.deleteRecord(c);
    }
    
}
