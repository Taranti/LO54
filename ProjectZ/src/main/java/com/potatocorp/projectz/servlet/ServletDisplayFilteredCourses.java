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
@WebServlet(name = "servletDisplayFilteredCourses", urlPatterns = {"/filteredCourses"})
public class ServletDisplayFilteredCourses extends HttpServlet {
     protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
        
        HttpSession session = request.getSession();
        String keyword=(String) session.getAttribute("keyword");
        String date=(String) session.getAttribute("date");
        String location=(String) session.getAttribute("location");
        Date formattedDate=null;
        int formattedLocation=0;
        if(keyword.equals(""))keyword=null;
        if(!date.equals("")){
            SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
            try {
                formattedDate=df.parse(date);
            } catch (ParseException ex) {
                Logger.getLogger(ServletDisplayFilteredCourses.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(!location.equals(""))formattedLocation=Integer.parseInt(location);
        
        List<CourseSession> filteredSessions = filterSessions(formattedDate,keyword,formattedLocation);
        request.setAttribute("sessions",filteredSessions);
        this.getServletContext().getRequestDispatcher( "/WEB-INF/jsp/displayCourses.jsp" ).forward( request, response );
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         processRequest(request, response);
         
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }
    
    private List<CourseSession> filterSessions(Date date,String keyword,int location){
        MYSQLCourseSessionDAO sessionsDAO = new MYSQLCourseSessionDAO();
        List<CourseSession> sessions =sessionsDAO.getRecords();
        List<CourseSession> filtered = new ArrayList<CourseSession>();
        for(CourseSession session : sessions){
            if(date!=null){
                if(session.getStartDate().before(date)){
                    continue;
                }
            }
            if(keyword!=null){
                if(!session.getCourse().getTitle().toLowerCase().contains(keyword.toLowerCase())){
                    continue;
                }
            }
            if(location!=0 && session.getLocation().getId()!=location){
                continue;
            }
            filtered.add(session);
        }
        if(filtered.isEmpty()){
            filtered=sessions;
        }
        return filtered;
    }

    public String getServletInfo() {
        return "Short description";
    }
}
