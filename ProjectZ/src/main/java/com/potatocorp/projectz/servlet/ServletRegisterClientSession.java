/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.potatocorp.projectz.servlet;

import com.potatocorp.projectz.entity.CourseSession;
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
      
        
        HttpSession session = request.getSession();
        String sessionNumber=request.getParameter("session");
        request.setAttribute("session",sessionNumber);
        this.getServletContext().getRequestDispatcher( "/WEB-INF/jsp/register.jsp" ).forward( request, response );
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         processRequest(request, response);
         
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }
    

    public String getServletInfo() {
        return "Short description";
    }
}
