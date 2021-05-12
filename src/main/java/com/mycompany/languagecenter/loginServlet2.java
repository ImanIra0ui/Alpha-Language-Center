
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.languagecenter;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.naming.*;
import javax.sql.*;
import java.sql.*;

/**
 *
 * @author SHSS
 */
@WebServlet(name = "loginServlet2", urlPatterns = {"/StudentPortal"})
public class loginServlet2 extends HttpServlet {
    String username;
    String password;
    int i;  

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
        try (PrintWriter out = response.getWriter()) {
<<<<<<< HEAD
             out.println("<!DOCTYPE html>");
               out.println("<html>");
      out.println("<head>");
        out.println("<link rel=\"stylesheet\" href=\"choice.css\">\n");
         out.println(" <link rel=\"shortcut icon\" type=\"image/x-icon\" href=\"logo.PNG\" >\n");
      out.append("<link href=\"https://fonts.googleapis.com/css2?family=Courgette&display=swap\" rel=\"stylesheet\">\n" +
"");
       out.println("<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">");
      out.println("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js\"></script>");
         out.println("<title>Alpha</title>");
       out.println("</head>");
        out.println("  <div class=\"topnav\">\n" +
"            <h2 id=\"logo\">ALpha</h2>\n" +
"            <a href=\"#about\" class=\"active\"><i class=\"fa fa-bars\"></i></a>\n" +
"            <a href=\"#contact\">about</a>\n" +
"            <a ref=\"#home\"><i class=\"fa fa-home\"></i> Home</a>\n" +
"          </div>");
            
            out.println("<body>");
            out.println("<div class=\"errorpic\"><img src=\"error.png\" alt=\"Girl in a jacket\" width=\"300\" height=\"320\"></div>");
            out.println("<h1 class=\"error\">OOPS...</h1>");
            out.println("<h1 class=\"smtg2 error\">something went wrong!</h1>");
=======
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet loginServlet</title>");   
            out.println("<link rel=\"stylesheet\" href=\"page.css\">");
            out.println("</head>");
            out.println("<body>");
            
            out.println("<h1>Servlet loginServlet at " + request.getContextPath() + "</h1>");
>>>>>>> first
            out.println("</body>");
            out.println("</html>");
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
         
        // read form fields
        username = request.getParameter("ID");
        password = request.getParameter("password");
 
        // do some processing here...
         
        // get response writer
        PrintWriter writer = response.getWriter();
        writer.println("<!DOCTYPE html>");
        writer.println("<html>");
        writer.println("<head>");
<<<<<<< HEAD
        writer.println("<link rel=\"stylesheet\" href=\"choice.css\">");
      writer.println(" <link rel=\"shortcut icon\" type=\"image/x-icon\" href=\"logo.PNG\" >\n");
=======
        writer.println("<link rel=\"stylesheet\" href=\"portal.css\">");
>>>>>>> first
        writer.println("<link href=\"https://fonts.googleapis.com/css2?family=Courgette&display=swap\" rel=\"stylesheet\">");
        writer.println("<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">");
        writer.println("<title>Alpha</title>");
        writer.println("</head>");
        writer.println("  <div class=\"topnav\">\n" +
"            <h2 id=\"logo\">ALpha</h2>\n" +
"            <a href=\"#about\" class=\"active\"><i class=\"fa fa-bars\"></i></a>\n" +
"            <a href=\"#contact\">about</a>\n" +
"            <a ref=\"#home\"><i class=\"fa fa-home\"></i> Home</a>\n" +
"          </div>");
            
        writer.println("<body>");   
        
 
     

                                

        try {
            Context ctx = new InitialContext();
            if (ctx == null) {
                throw new Exception("Error - No Context");
            }
            // /jdbc/postgres is the name of the resource in context.xml
            DataSource ds = (DataSource)
            ctx.lookup("java:/comp/env/jdbc/postgres");
            if (ds != null) {
                Connection conn = ds.getConnection();
            if (conn != null) {
                Statement stmt = conn.createStatement();
                i=Integer.parseInt(username);
                ResultSet r = stmt.executeQuery("SELECT COUNT(userID) FROM "
                        + "Account GROUP BY (userID) HAVING userID = "+i+"AND password = '"+password
                        + "' AND userID in (SELECT userID from Student);");
                if(r.next()){
                   
                    ResultSet rst = stmt.executeQuery("SELECT firstName FROM Users where userID ="+i+";\n" );
                   if (rst.next()){
                       
                   writer.println("<div id=\"sideBar\">");
                    writer.println("<form method='post' action='./Choice'>");
                    writer.println("<input type='hidden' placeholder ='username2' name='username' value =  '"+ username +"'>");
                    writer.println("<input  class='nav-element' type='submit' name='prfl' value='My profile'>");
                    writer.println("</form>");
               
                    writer.println("<form method='post' action='./Choice'>");
                    writer.println("<input type='hidden' placeholder='username' name='username' value = '" + username + "'>");
                    writer.println("<input class='nav-element' type='submit' name='sched' value='My Schedule'>");
                    writer.println("</form>");
                                      
                    writer.println("<form method='post' action='./Choice'>");
                    writer.println("<input type='hidden' placeholder ='username2' name='username' value = '" + username +"'>");
                    writer.println("<input class='nav-element' type='submit' name='assi' value='My Classes'>");
                    writer.println("</form>");
               
                    writer.println("<form method='post' action='./Choice'>");
                    writer.println("<input type='hidden' placeholder ='username2' name='username' value =  '"+ username +"'>");
                    writer.println("<input  class='nav-element' type='submit' name='fee' value='My Fee Statements'>");
                    writer.println("</form>");
                    writer.println("<br><br><br><br>");
<<<<<<< HEAD
                        writer.println("<div class=\"bottom\"><i class=\"fa fa-sign-out\"></i><a href=\"index.html\">Log out </a></div>");
=======
                    writer.println("<div class=\"bottom\"><i class=\"fa fa-sign-out\"></i>  Log out</div>");
>>>>>>> first
                    writer.println("</div>");
               
                        writer.println("<section>");
                        writer.println("<br><h1> Hello "+ rst.getString(1) +"!</h1>");
                        writer.println(" </section>");
                  
                }
                   
                
                }else {
                     writer.println("<div class=\"errorpic\"><img src=\"error.png\" alt=\"Girl in a jacket\" width=\"300\" height=\"320\"></div>");
                     writer.println("<div class=\"error\">Invalid credentials! Please try again.<br>");
                     writer.println("<br>");
                     writer.println("<a href=\"StudentLogin.html\"> Go back to login page </a></div>");
                      
           
                    }
         
                writer.println("</body>");
                writer.println("</html>");
                conn.close();
//writer.println("</table>");
            } else {
                writer.println("Error: conn is null ");
            }
        }
            } catch (Exception e) {
        //e.printStackTrace();
        writer.println("Exception caught");
        writer.println(e.toString());
    }

    }
<<<<<<< HEAD
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
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
=======
 
>>>>>>> first
}



