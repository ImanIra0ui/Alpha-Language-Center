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
@WebServlet(name = "StudentsList", urlPatterns = {"/StudentsList"})
public class StudentsList extends HttpServlet {
    String username, course, section;
    int i, flag=0;
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
            out.println("</body>");
            out.println("</html>");
        }
    }
     @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
         
        // read form fields
        username = request.getParameter("username");
        i = Integer.parseInt(username);
 
        // do some processing here...
         
        // get response writer
        PrintWriter writer = response.getWriter();
        writer.println("<html>");
           writer.println("<head>");
            writer.println("<link rel=\"stylesheet\" href=\"choice.css\">\n");
               writer.println(" <link rel=\"shortcut icon\" type=\"image/x-icon\" href=\"logo.PNG\" >\n");
        writer.append("<link href=\"https://fonts.googleapis.com/css2?family=Courgette&display=swap\" rel=\"stylesheet\">\n" +
"");
        writer.println(" <script> function validateForm() {\n" +
"  var x = document.forms[\"myForm\"][\"answer\"].value;\n" +
"  if (x == \"\" || x == null) {\n" +
"    alert(\"You must fill out an answer first!\");\n" +
"    return false;\n" +
"  }\n" +
"}"
   + "</script>");
        
         
      writer.println("<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">");
        writer.println("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js\"></script>");
          writer.println("</head>");
         writer.println("<title>Alpha</title>");
        writer.println("</head>");
        writer.println("  <div class=\"topnav\">\n" +
"            <h2 id=\"logo\">ALpha</h2>\n" +
"            <a href=\"#about\" class=\"active\"><i class=\"fa fa-bars\"></i></a>\n" +
"            <a href=\"#contact\">about</a>\n" +
"            <a ref=\"#home\"><i class=\"fa fa-home\"></i> Home</a>\n" +
"          </div>");
            
        writer.println("<body>");   
                        writer.println("<div id=\"sideBar\">");
                             
                        writer.println("<form method='post' action='./ProfChoice'>");
                        writer.println("<input type='hidden' placeholder ='username2' name='username' value =  '"+ username +"'>");
                        writer.println("<input  class='nav-element' type='submit' name='prof' value='My Profile'>");
                        writer.println("</form>");
                        
                        writer.println("<form method='post' action='./ProfChoice'>");
                        writer.println("<input type='hidden' placeholder='username' name='username' value = '" + username + "'>");
                        writer.println("<input class='nav-element' type='submit' name='sched' value='My Schedule'>");
                        writer.println("</form>");

                        writer.println("<form method='post' action='./ProfChoice'>");
                        writer.println("<input type='hidden' placeholder ='username2' name='username' value =  '"+ username +"'>");
                        writer.println("<input  class='nav-element' type='submit' name='courses' value='My Courses'>");
                        writer.println("</form>");
                        writer.println("<br><br><br><br><br><br><br>");
                        writer.println("<div class=\"bottom\"><i class=\"fa fa-sign-out\"></i><a href=\"index.html\">Log out</a></div>");
                        writer.println("</div>");
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
                    String query = "SELECT moduleName, sectionNumber FROM section AS S INNER JOIN Professor AS P"
                            + " ON S.professorId = P.userID"
                            + " WHERE S.professorId = "+i +
                            " AND year = date_part('year', CURRENT_DATE)\n" +
                            "        AND (((EXTRACT(MONTH FROM CURRENT_DATE) BETWEEN 09 AND 12) AND trimester = 'FA')\n" +
                            "        OR ((EXTRACT(MONTH FROM CURRENT_DATE) BETWEEN 01 AND 05) AND trimester = 'SP')\n" +
                            "        OR ((EXTRACT(MONTH FROM CURRENT_DATE) BETWEEN 06 AND 08) AND trimester = 'SU'));";
                    ResultSet r = stmt.executeQuery(query);
                    
                    while(r.next()) {
                        if (request.getParameter(r.getString(1))!=null && request.getParameter(r.getString(2))!=null) {
                            query = "SELECT S.firstName, S.lastName, E.finalgrade\n" +
                            "FROM Student AS S INNER JOIN Enroll AS E NATURAL JOIN section\n" +
                            "ON E.studentID = S.userID\n" +
                            "WHERE moduleName = '" + r.getString(1) + "' AND sectionNumber = " + r.getString(2) + 
                                    " AND year = date_part('year', CURRENT_DATE)\n" +
                            "        AND (((EXTRACT(MONTH FROM CURRENT_DATE) BETWEEN 09 AND 12) AND trimester = 'FA')\n" +
                            "        OR ((EXTRACT(MONTH FROM CURRENT_DATE) BETWEEN 01 AND 05) AND trimester = 'SP')\n" +
                            "        OR ((EXTRACT(MONTH FROM CURRENT_DATE) BETWEEN 06 AND 08) AND trimester = 'SU'));";
                                    
                            Statement stmt2 = conn.createStatement();
                            ResultSet rst = stmt2.executeQuery(query);
                            if(rst.next()) {
                               

                                flag=1;
                                writer.println("<div class=\"caption\">List of the students enrolled in this section</div>"); 
                                writer.println("<table id=\"customers\">"); 
                                writer.println("<tr><th>First Name:</th><th>Last Name:</th><th>Overall Grade:</th><tr>");
                                if(rst.getString(3)==null)
                                    writer.println("<tr><td>" + rst.getString(1) + "</td><td>" + rst.getString(2) + "</td><td> -- </td></tr>"); 
                                else
                                    writer.println("<tr><td>" + rst.getString(1) + "</td><td>" + rst.getString(2) + "</td><td>" + rst.getString(3) + "</td></tr>"); 

                            }
                            while(rst.next()) {
                                if(rst.getString(3)==null)
                                    writer.println("<tr><td>" + rst.getString(1) + "</td><td>" + rst.getString(2) + "</td><td> -- </td></tr><br>"); 
                                else
                                    writer.println("<tr><td>" + rst.getString(1) + "</td><td>" + rst.getString(2) + "</td><td>" + rst.getString(3) + "</td></tr>"); 
                            }
                    
                            writer.println("</table>"); 
                             if(flag==1){
                                writer.println("<h class=\"caption \">Section average:");
                                String query3 = "SELECT calculateAvgSection("+ r.getString(2) +"::smallint,'"+ r.getString(1) +"'::varchar(20));";
                                Statement stmt3 = conn.createStatement();
                                ResultSet rst4 = stmt3.executeQuery(query3);
                                
                                if(rst4.next()) {
                                    writer.println(rst4.getFloat(1));
                                }
                                 writer.println("</h>");}
                            if(flag==0)
                                writer.println("<h class=\"caption\">No students currently enrolled!</h>");
                            
                        }
                    }
                    
                }
            }
        }catch (Exception e) {
        //e.printStackTrace();
        writer.println("Exception caught");
        writer.println(e.toString());
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
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
  

}
