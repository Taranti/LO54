/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author pneau
 */
 @WebServlet(name = "servletCoursesSelection", urlPatterns = {"/courses"})
public class ServletGetCourses extends HttpServlet{
   

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ArrayList<Map> locationList= new ArrayList<Map>();
        Map<String, String> city1 = new HashMap<String, String>();
        city1.put("id","1");
        city1.put("name","Belfort");
        locationList.add(city1);
        Map<String, String> city2 = new HashMap<String, String>();
        city2.put("id","2");
        city2.put("name","Montbéliard");
        locationList.add(city2);
        request.setAttribute("locationList", locationList);
        this.getServletContext().getRequestDispatcher( "/WEB-INF/jsp/filterCourses.jsp" ).forward( request, response );
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String keyword = request.getParameter("keyword");
        String date=request.getParameter("date");
        String locationID=(request.getParameter("location"));
        response.setContentType("text/html;charset=UTF-8");
        
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

