/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.potatocorp.projectz.repository;

import com.potatocorp.projectz.entity.Client;
import com.potatocorp.projectz.tools.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.hibernate.engine.SessionFactoryImplementor;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

/**
 *
 * @author ASaunier
 */
public class MYSQLClientDAOTest {
    
    @Mock
    private MYSQLClientDAO mysqlClientDAOMocked = new MYSQLClientDAO();
        
    private Client c = new Client();
       
    @Before
    public void init() {
        List<Client> list = new ArrayList<Client>();
        MockitoAnnotations.initMocks(this);
        when(mysqlClientDAOMocked.saveRecord(c)).thenReturn(1);
        when(mysqlClientDAOMocked.getRecords()).thenReturn(list);
    }
    /**
     * Test of saveRecord method, of class MYSQLClientDAO.
     */
    @Test
    public void testSaveRecord() {
        System.out.println("saveRecord");
        c.setId(1);
        c.setLastName("testLname");
        c.setFirstName("testFname");
        c.setAddress("testAddress");
        c.setPhone("0123456789");
        c.setEmail("test.email@test.test");
        c.setSession(null);
        
        int i = mysqlClientDAOMocked.saveRecord(c);
        verify(mysqlClientDAOMocked).saveRecord(c);
        assertEquals(i,1);
        
          
        
        
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getRecords method, of class MYSQLClientDAO.
     */
    @Test
    public void testGetRecords() {
        System.out.println("getRecords");
        List<Client> result = new ArrayList<Client>();
        mysqlClientDAOMocked.getRecords();
        verify(mysqlClientDAOMocked).getRecords();
        assertEquals(result.getClass(), mysqlClientDAOMocked.getRecords().getClass());
    }

    /**
     * Test of updateRecord method, of class MYSQLClientDAO.
     */
    @Test
    public void testUpdateRecord() {
        System.out.println("updateRecord");
        c.setId(1);
        c.setLastName("testLname");
        c.setFirstName("testFname");
        c.setAddress("testAddress");
        c.setPhone("0123456789");
        c.setEmail("test.email@test.test");
        c.setSession(null);
        
        mysqlClientDAOMocked.updateRecord(c);
        verify(mysqlClientDAOMocked).updateRecord(c);
    }

    /**
     * Test of deleteRecord method, of class MYSQLClientDAO.
     */
    @Test
    public void testDeleteRecord() {
        System.out.println("deleteRecord");

        mysqlClientDAOMocked.deleteRecord(c);
        verify(mysqlClientDAOMocked).deleteRecord(c);
        
    }
    
}
