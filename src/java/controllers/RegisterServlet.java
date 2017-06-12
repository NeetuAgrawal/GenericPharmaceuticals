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
import models.User;

/**
 *
 * @author manish
 */
@WebServlet(name = "RegisterServlet", urlPatterns = {"/register"})
public class RegisterServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
            try(PrintWriter out = response.getWriter()){
            
            String role= request.getParameter("role");
            String fname = request.getParameter("fname");
            String lname= request.getParameter("lname");
            String mailId= request.getParameter("emailid");
            String gender= request.getParameter("gender");
            String password= request.getParameter("password");
            String confirm= request.getParameter("confirm");
            if(password.equals(confirm)){
            User u = new User(role,fname,lname,gender,mailId,password);
            System.out.println("Request is being passed to UserDAO");
            UserDAO  userDao= new UserDAO();
            boolean isAdded=userDao.addUser(u);
            if(isAdded){
                System.out.println("New user has been added successfully...");
            
                request.setAttribute("user",u);
                if(role.equals("Employee")){
                RequestDispatcher rd = request.getRequestDispatcher("empProfile.jsp");
                rd.forward(request,response);
                }else if(role.equals("Supervisor")){
                RequestDispatcher rd = request.getRequestDispatcher("supervisorProfile.jsp");
                rd.forward(request,response);
                    }
                else if(role.equals("FSO")){
                RequestDispatcher rd = request.getRequestDispatcher("fsoProfile.jsp");
                rd.forward(request,response);
                    
                }
            }
            else{
                request.setAttribute("registerError","User Already Exist with this EmailId...");
                RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                rd.forward(request,response);
            }
            }
            else{
                request.setAttribute("passwordError","password and confirm password doesn't match");
                RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                rd.forward(request,response);
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
