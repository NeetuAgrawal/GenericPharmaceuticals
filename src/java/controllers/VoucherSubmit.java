package controllers;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import daos.GenpharmaDAO;
import daos.UserDAO;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.User;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author hp pc
 */
@WebServlet(urlPatterns = {"/VoucherSubmit"})
public class VoucherSubmit extends HttpServlet {
private final String UPLOAD_DIRECTORY = "C:/uploads";

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
        
        String data[]= new String[6];        

        if(ServletFileUpload.isMultipartContent(request)){
            try{
                List<FileItem> multiparts= new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
                int i=0;
                for( i=0; i<5; i++){
                    data[i]=multiparts.get(i).getString();
                    System.out.println(data[i]);
                }
                
                if(i==5){
                        FileItem item= multiparts.get(i);
                        String name= new File(item.getName()).getName();
                        String loc=UPLOAD_DIRECTORY+"/"+name;
                        data[i]=loc;
                        item.write(new File(loc));
                        request.setAttribute("message", "File Uploaded Successfully!!!");
                    }
                   
                HttpSession session = request.getSession(false);
                if(session!=null){
                 User u = (User)session.getAttribute("user");
                 UserDAO dao = new UserDAO();
                 int id= dao.getUserId(u.getEmailId());
                    System.out.println("USER'S ID IS *********** : "+ id);
                 saveInfo(data,id);
                }
                
                
            }
            catch(Exception e){
                request.setAttribute("message","File upload failed due to "+e);
            }
        }
        else{
            request.setAttribute("message", "Sorry this servlet only handles file upload request.");
        }
        request.getRequestDispatcher("/result.jsp").forward(request, response);

  }

    
    void saveInfo(String[] info,int id){
        
        GenpharmaDAO obj = new GenpharmaDAO();
        
        obj.saveEmpVoucher(id,info[0],info[1],Float.parseFloat(info[2]),info[3],info[4],info[5]);
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
