/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.potatocorp.projectz.servlet;

import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

/**
 *
 * @author mokon
 */
public class ServletUserTest {
    
    @Spy
    private ServletUser servletUserMocket = new ServletUser();
    
    @Mock
    private HttpServletRequest request;
 
    @Mock
    private HttpServletResponse response;
    
    private String lastname, firstname, address, phonenumber, mail;
        
    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        lastname = "User";
        firstname = "Test";
        address = "a";
        phonenumber = "0123456789";
        mail = "user.test@m";
        when(request.getParameter("lastname")).thenReturn(lastname);
        when(request.getParameter("firstname")).thenReturn(firstname);
        when(request.getParameter("address")).thenReturn(address);
        when(request.getParameter("phonenumber")).thenReturn(phonenumber);
        when(request.getParameter("mail")).thenReturn(mail);
    }
    
    
    /**
     * Test of doPost method, of class ServletUser.
     */
    @Test
    public void testDoPost() throws Exception {
        System.out.println("doPost");
                      
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
         
        when(response.getWriter()).thenReturn(pw);       

        servletUserMocket.doPost(request, response);
        
        verify(servletUserMocket).doPost(request, response);
        System.out.flush();
    }
}
