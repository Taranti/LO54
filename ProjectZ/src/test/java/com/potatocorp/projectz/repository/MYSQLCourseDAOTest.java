/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.potatocorp.projectz.repository;

import com.potatocorp.projectz.entity.Course;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
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
public class MYSQLCourseDAOTest {
    
    @Mock
    MYSQLCourseDAO mysqlCourseDAOMocked = new MYSQLCourseDAO();
    
    Course c = new Course();
    
    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        when(mysqlCourseDAOMocked.saveRecord(c)).thenReturn("CODE");
    }       
    

    /**
     * Test of saveRecord method, of class MYSQLCourseDAO.
     */
    @Test
    public void testSaveRecord() {
       System.out.println("saveRecord");
       
       c.setCode("CODE");
       c.setTitle("Course");
       
      String s =  mysqlCourseDAOMocked.saveRecord(c);
      verify(mysqlCourseDAOMocked).saveRecord(c);
      assertEquals(s,c.getCode());
    }

    /**
     * Test of getRecords method, of class MYSQLCourseDAO.
     */
//   @Test
    public void testGetRecords() {
        System.out.println("getRecords");
        List<Course> result = new ArrayList<Course>();
        mysqlCourseDAOMocked.getRecords();
        verify(mysqlCourseDAOMocked).getRecords();
        assertEquals(result.getClass(), mysqlCourseDAOMocked.getRecords().getClass());
    }

    /**
     * Test of updateRecord method, of class MYSQLCourseDAO.
     */
    @Test
    public void testUpdateRecord() {
        System.out.println("updateRecord");
        
        
        mysqlCourseDAOMocked.updateRecord(c);
        verify(mysqlCourseDAOMocked).updateRecord(c);
    }

    /**
     * Test of deleteRecord method, of class MYSQLCourseDAO.
     */
    @Test
    public void testDeleteRecord() {
        System.out.println("deleteRecord");

        mysqlCourseDAOMocked.deleteRecord(c);
        verify(mysqlCourseDAOMocked).deleteRecord(c);
        
    }
    
}
