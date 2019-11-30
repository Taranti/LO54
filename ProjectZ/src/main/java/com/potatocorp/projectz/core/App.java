/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.potatocorp.projectz.core;

import com.potatocorp.projectz.entity.Client;
import com.potatocorp.projectz.entity.Course;
import com.potatocorp.projectz.entity.CourseSession;
import com.potatocorp.projectz.entity.Location;
import com.potatocorp.projectz.repository.MYSQLClientDAO;
import com.potatocorp.projectz.repository.MYSQLCourseDAO;
import com.potatocorp.projectz.repository.MYSQLCourseSessionDAO;
import com.potatocorp.projectz.repository.MYSQLLocationDAO;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author thoma
 */
public class App {
    
    public static void main(String[] args){
        
        // COURSE CLASSE DAO TEST
        MYSQLCourseDAO mc = new MYSQLCourseDAO();
        
        String n = mc.saveRecord(new Course("CODE7","TITRE"));
        
        List<Course> cs = mc.getRecords();
        
        Course c = new Course("CODE7", "TITRE2");
        
        mc.updateRecord(c);
        
        waitT();
        
        mc.deleteRecord(c);
        
        // LOCATION CLASSE DAO TEST
        MYSQLLocationDAO ml = new MYSQLLocationDAO();
        
        int n2 = ml.saveRecord(new Location(2,"CITY"));
        
        List<Location> ls = ml.getRecords();
        
        Location l = new Location(2, "CITY2");
        
        ml.updateRecord(l);
        
        waitT();
        
        ml.deleteRecord(l);
        
        // COURSE_SESSION CLASSE DAO TEST
        MYSQLCourseSessionDAO mcl = new MYSQLCourseSessionDAO();
        int n3 = mcl.saveRecord(new CourseSession(2,  new Date(2020,12,1), new Date(2020,12,4), 20, cs.get(0), ls.get(0)));
        
        List<CourseSession> css = mcl.getRecords();
        
        CourseSession crs = new CourseSession(2, new Date(2020,12,1), new Date(2020,12,4), 20, cs.get(1), ls.get(0));
        
        mcl.updateRecord(crs);
        
        waitT();
        
        mcl.deleteRecord(crs);
        
        
        // CLIENT CLASSE DAO TEST
        MYSQLClientDAO mct = new MYSQLClientDAO();
        int n4 = mct.saveRecord(new Client(2, "lastName", "firstName", "address", "phone", "email", css.get(0)));
        
        List<Client> cts = mct.getRecords();
        
        Client ct = new Client(2, "lastName", "firstName2", "address", "phone", "email", css.get(0));
        
        mct.updateRecord(ct);
        
        waitT();
        
        mct.deleteRecord(ct);
    }
    
    public static void waitT(){
        try {
            Thread.sleep(3000);
        }  catch (InterruptedException e) {
            System.out.println(e);
        }
    }
    
}
