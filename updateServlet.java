/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import business.student;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author tabe-ebob
 */
@WebServlet(urlPatterns = {"/updateServlet"})
public class updateServlet extends HttpServlet {

     protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            int id = Integer.parseInt(request.getParameter("id"));
            String pass = request.getParameter("password");
            String first = request.getParameter("firstname");
            String last = request.getParameter("lastname");
            String street = request.getParameter("street");
            String city = request.getParameter("city");
            String state = request.getParameter("state");
            int zip = Integer.parseInt(request.getParameter("zipcode"));
            String email = request.getParameter("email");
            int gpa = Integer.parseInt(request.getParameter("gpa"));
            
          
           
            student i1 = new student();
                i1.setId(id);
                i1.setPassword(pass);
                i1.setFirstName(first);
                i1.setLastName(last);
                i1.setStreet(street);
                i1.setCity(city);
                i1.setState(state);
                i1.setZip(zip);
                i1.setEmail(email);
                i1.setGpa(gpa);
            
                i1.update(id,pass,first,last,street,city,state,zip,email,gpa);
                i1.display();
            
            
            RequestDispatcher rd = request.getRequestDispatcher("/updateInfo.jsp");
              rd.forward(request, response); 
        }
        finally {                               	                    
           			out.close();
                        } //end finally/try
    } //end processRequest()
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
