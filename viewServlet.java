/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author tabe-ebob
 */
@WebServlet(urlPatterns = {"/viewServlet"})
public class viewServlet extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
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
         response.setContentType("text/html;charset=UTF-8");
         
         try  (PrintWriter out = response.getWriter()){
        
             int id = Integer.parseInt(request.getParameter("id"));
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\tabe-ebob\\Desktop\\RegistrationMDB1.mdb");
           
            Statement statement = con.createStatement();
            
          ResultSet rs = statement.executeQuery("Select * from StudentSchedule where StudentID ='"+id+"'" );
				
          while(rs.next()){
          out.print("<tr><td>");
          out.print(rs.getInt(1));
          out.print("</td>");
          out.print("<td>");
          out.print(rs.getInt(2));
          out.print("</td>");
          out.print("<td>");
          out.print(rs.getInt(3));
          out.print("</td>");
          out.print("</tr>");
        }
        }
        catch(Exception e) {
            System.out.println(e);
        }

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
