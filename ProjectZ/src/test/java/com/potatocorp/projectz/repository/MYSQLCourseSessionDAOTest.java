/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.potatocorp.projectz.repository;

import com.potatocorp.projectz.entity.Course;
import com.potatocorp.projectz.entity.CourseSession;
import com.potatocorp.projectz.entity.Location;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

/**
 *
 * @author mokon
 */
public class MYSQLCourseSessionDAOTest {
    
    @Mock
    private MYSQLCourseSessionDAO mysqlCourseSessionDAOMocked = new MYSQLCourseSessionDAO();
        
    private CourseSession c = new CourseSession();
    private Location l = new Location();
    private Course co = new Course();
       
    @Before
    public void init() {
        List<CourseSession> list = new ArrayList<CourseSession>();
        MockitoAnnotations.initMocks(this);
        when(mysqlCourseSessionDAOMocked.saveRecord(c)).thenReturn(1);
        when(mysqlCourseSessionDAOMocked.getRecords()).thenReturn(list);
    }
    
    
    /**
     * Test of saveRecord method, of class MYSQLCourseSessionDAO.
     */
    @Test
    public void testSaveRecord() {
        System.out.println("saveRecord");
        
        Date d = new Date(2019,12,12);
        Date df = new Date(2019,12,13);
        c.setId(1);
        c.setLocation(l);
        c.setStartDate(d);
        c.setEndDate(df);
        c.setCourse(co);
        c.setMax(25);
        
        int i = mysqlCourseSessionDAOMocked.saveRecord(c);
        verify(mysqlCourseSessionDAOMocked).saveRecord(c);
        assertEquals(i,1);
    }

    /**
     * Test of getRecords method, of class MYSQLCourseSessionDAO.
     */
    @Test
    public void testGetRecords() {
        System.out.println("getRecords");
        List<CourseSession> result = new ArrayList<CourseSession>();
        mysqlCourseSessionDAOMocked.getRecords();
        verify(mysqlCourseSessionDAOMocked).getRecords();
        assertEquals(result.getClass(), mysqlCourseSessionDAOMocked.getRecords().getClass());
        
    }

    /**
     * Test of updateRecord method, of class MYSQLCourseSessionDAO.
     */
    @Test
    public void testUpdateRecord() {
        System.out.println("updateRecord");        
        mysqlCourseSessionDAOMocked.updateRecord(c);
        verify(mysqlCourseSessionDAOMocked).updateRecord(c);
    }

    /**
     * Test of deleteRecord method, of class MYSQLCourseSessionDAO.
     */
    @Test
    public void testDeleteRecord() {
       System.out.println("deleteRecord");

        mysqlCourseSessionDAOMocked.deleteRecord(c);
        verify(mysqlCourseSessionDAOMocked).deleteRecord(c);
    }
    
}
