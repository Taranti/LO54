/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.potatocorp.projectz.servlet;

import com.potatocorp.projectz.entity.Location;
import com.potatocorp.projectz.repository.MYSQLLocationDAO;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author pneau
 */
 @WebServlet(name = "servletCoursesSelection", urlPatterns = {"/filter"})
public class ServletGetCourses extends HttpServlet{
   

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        SimpleDateFormat formater=new SimpleDateFormat("yyyy-MM-dd");
        MYSQLLocationDAO locationDAO=new MYSQLLocationDAO();
        List<Location> locationList= locationDAO.getRecords();
        Date todayDate = Calendar.getInstance().getTime();
        String today = formater.format(todayDate);
        request.setAttribute("today",today);
        request.setAttribute("locationList", locationList);
        this.getServletContext().getRequestDispatcher( "/WEB-INF/jsp/filterCourses.jsp" ).forward( request, response );
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
        response.sendRedirect("filteredCourses");
        
    }

    public String getServletInfo() {
        return "Short description";
    }
}

