/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.potatocorp.projectz.repository;

import com.potatocorp.projectz.entity.Location;
import java.util.ArrayList;
import java.util.List;
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
public class MYSQLLocationDAOTest {
    
    
    @Mock
    private MYSQLLocationDAO mysqlLocationDAOMocked = new MYSQLLocationDAO();
        
    private Location l = new Location();
       
    @Before
    public void init() {
        List<Location> list = new ArrayList<Location>();
        MockitoAnnotations.initMocks(this);
        when(mysqlLocationDAOMocked.saveRecord(l)).thenReturn(1);
        when(mysqlLocationDAOMocked.getRecords()).thenReturn(list);
    }
    
    /**
     * Test of saveRecord method, of class MYSQLLocationDAO.
     */
    @Test
    public void testSaveRecord() {
        System.out.println("saveRecord");
        
        l.setId(1);
        l.setCity("Paris");
        
        int i = mysqlLocationDAOMocked.saveRecord(l);
        verify(mysqlLocationDAOMocked).saveRecord(l);
        assertEquals(i,1);
    }

    /**
     * Test of getRecords method, of class MYSQLLocationDAO.
     */
    @Test
    public void testGetRecords() {
        System.out.println("getRecords");
        List<Location> result = new ArrayList<Location>();
        mysqlLocationDAOMocked.getRecords();
        verify(mysqlLocationDAOMocked).getRecords();
        assertEquals(result.getClass(), mysqlLocationDAOMocked.getRecords().getClass());
    }

    /**
     * Test of updateRecord method, of class MYSQLLocationDAO.
     */
    @Test
    public void testUpdateRecord() {
        System.out.println("updateRecord");        
        mysqlLocationDAOMocked.updateRecord(l);
        verify(mysqlLocationDAOMocked).updateRecord(l);
    }

    /**
     * Test of deleteRecord method, of class MYSQLLocationDAO.
     */
    @Test
    public void testDeleteRecord() {
       System.out.println("deleteRecord");

        mysqlLocationDAOMocked.deleteRecord(l);
        verify(mysqlLocationDAOMocked).deleteRecord(l);
    }
    
}
