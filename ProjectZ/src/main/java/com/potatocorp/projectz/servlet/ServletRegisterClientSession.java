/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.potatocorp.projectz.servlet;

import com.potatocorp.projectz.entity.Client;
import com.potatocorp.projectz.entity.CourseSession;
import com.potatocorp.projectz.repository.MYSQLClientDAO;
import com.potatocorp.projectz.repository.MYSQLCourseSessionDAO;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Pierre
 */
@WebServlet(name = "servlettRegisterClientSession", urlPatterns = {"/register"})
public class ServletRegisterClientSession extends HttpServlet{
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String sessionNumber=request.getParameter("session");
        request.setAttribute("session",sessionNumber);
        
       
        this.getServletContext().getRequestDispatcher( "//WEB-INF/jsp/createUser.jsp" ).forward( request, response );
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         processRequest(request, response);
         
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //HttpSession session = request.getSession();
        MYSQLCourseSessionDAO csDAO=new MYSQLCourseSessionDAO();
        MYSQLClientDAO clientDAO=new MYSQLClientDAO();
        
        
        String sessionNumber=request.getParameter("session");
        Integer sessionID=Integer.parseInt(sessionNumber);
        CourseSession cs =csDAO.getRecordsByID(sessionID);
        
        
        String lastname = request.getParameter("lastname");
        String firstname=request.getParameter("firstname");
        String address=request.getParameter("address");
        String phonenumber=request.getParameter("phonenumber");
        String mail=request.getParameter("mail");
        Client client=new Client(null,lastname,firstname,address,phonenumber,mail,cs);
        clientDAO.saveRecord(client);
        response.sendRedirect("/");
    }
    

    public String getServletInfo() {
        return "Short description";
    }
}
