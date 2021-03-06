/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.User;

/**
 *
 * @author manish
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
      
            /* TODO output your page here. You may use following sample code. */
            
            String emailId = request.getParameter("emailid");
            String password = request.getParameter("password");
            String role = request.getParameter("role");
            
            UserDAO userDao = new UserDAO();
            User u= userDao.doesUserExist(role,emailId,password);
            if(u==null){
                System.out.println("No User exist with this mail id or password ");
                response.sendRedirect("./index.jsp");
            }
            else {
                HttpSession session = request.getSession();
                if(session.isNew()){
                    session.setAttribute("user",u);
                request.setAttribute("user",u);
                if(role.equals("Employee")){
                RequestDispatcher rd = request.getRequestDispatcher("empProfile.jsp");
                rd.forward(request,response);
                }
                else if(role.equals("Supervisor")){
                    RequestDispatcher rd = request.getRequestDispatcher("supervisorProfile.jsp");
                rd.forward(request,response);
                }
                else if(role.equals("FSO")){
                    RequestDispatcher rd = request.getRequestDispatcher("fsoProfile.jsp");
                rd.forward(request,response);
                }
                else{
                    System.out.println("There is something problem in login...");
                }
            }
            
        
    }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
    


