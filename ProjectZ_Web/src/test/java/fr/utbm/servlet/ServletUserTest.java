/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.servlet;

import static org.mockito.Mockito.when;
 
import java.io.PrintWriter;
import java.io.StringWriter;
 
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import static org.mockito.Mockito.verify;
import org.mockito.MockitoAnnotations;

/**
 *
 * @author mokon
 */
public class ServletUserTest {
    
    @Mock
    ServletUser servletUser = new ServletUser();
    
    @Mock
    HttpServletRequest request;
 
    @Mock
    HttpServletResponse response;
    
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }
    
    /**
     * Test of doPost method, of class ServletUser.
     */
    @Test
    public void testDoPost() throws Exception {
        
        String lastname, firstname, address, phonenumber, mail;
        
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
 
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
         
        when(response.getWriter()).thenReturn(pw);
 

        servletUser.doPost(request, response);
        
        verify(servletUser).doPost(request, response);
    }
    
}
