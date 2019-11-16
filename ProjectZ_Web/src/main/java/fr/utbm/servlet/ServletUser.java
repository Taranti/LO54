/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
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
@WebServlet(name = "servletUser", urlPatterns = {"/createUser"})
public class ServletUser extends HttpServlet{
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher( "/createUser.html" ).forward( request, response );
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String lastname = request.getParameter("lastname");
        String firstname=request.getParameter("firstname");
        String address=request.getParameter("address");
        String phonenumber=request.getParameter("phonenumber");
        String mail=request.getParameter("mail");
        response.setContentType("text/html;charset=UTF-8");
        
        try (PrintWriter out = response.getWriter()) {
            out.println("Last Name : "+lastname);
            out.println("First Name : "+firstname);
            out.println("Address : "+address);
            out.println("Phone Number : "+phonenumber);
            out.println("Mail : "+mail);
        }
    }

    public String getServletInfo() {
        return "Short description";
    }
}
