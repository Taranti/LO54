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
@WebServlet(name = "servletDisplayCourses", urlPatterns = {"/allCourses"})
public class ServletDisplayCourses extends HttpServlet{
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        MYSQLCourseSessionDAO sessionsDAO = new MYSQLCourseSessionDAO();
        List<CourseSession> sessions =sessionsDAO.getRecords();
        request.setAttribute("sessions",sessions);
        this.getServletContext().getRequestDispatcher( "/WEB-INF/jsp/displayCourses.jsp" ).forward( request, response );
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String keyword = request.getParameter("keyword");
        String date=request.getParameter("date");
        String locationID=(request.getParameter("location"));
        response.setContentType("text/html;charset=UTF-8");
        session.setAttribute("keyword", keyword);
        session.setAttribute("date", date);
        session.setAttribute("location", locationID);
        response.sendRedirect("/content/test.jsp");
        try (PrintWriter out = response.getWriter()) {
            if(keyword!=""){
                out.println("Keyword : "+keyword);
            }
            if(date!=""){
                out.println("Date : "+date);
            }
            if(locationID!=""){
                out.println("locationID : "+locationID);
            }
            
        }
    }

    public String getServletInfo() {
        return "Short description";
    }

}
