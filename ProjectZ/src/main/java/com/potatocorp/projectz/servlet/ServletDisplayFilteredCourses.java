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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
@WebServlet(name = "servletDisplayFilteredCourses", urlPatterns = {"/filteredCourses"})
public class ServletDisplayFilteredCourses extends HttpServlet {
     protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /*MYSQLCourseSessionDAO sessionsDAO = new MYSQLCourseSessionDAO();
        List<CourseSession> sessions =sessionsDAO.getRecords();
        request.setAttribute("sessions",sessions);*/
        HttpSession session = request.getSession();
        String keyword=(String) session.getAttribute("keyword");
        String date=(String) session.getAttribute("date");
        String location=(String) session.getAttribute("location");
        request.setAttribute("date",date);
        request.setAttribute("keyword",keyword);
        request.setAttribute("location",location);
        this.getServletContext().getRequestDispatcher( "/WEB-INF/jsp/displayFilteredCourses.jsp" ).forward( request, response );
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
