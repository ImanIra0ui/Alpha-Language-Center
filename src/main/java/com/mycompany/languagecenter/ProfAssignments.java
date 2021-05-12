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
@WebServlet(name = "ProfAssignments", urlPatterns = {"/ProfAssignments"})
public class ProfAssignments extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
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

    String username;
    int i, flag=0,c;
   
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
                    if(request.getParameter("delete")!=null) {
                        int c=0;
        String assId = request.getParameter("assId");
        int id = Integer.parseInt(assId);
        
        String username = request.getParameter("username");
        int i = Integer.parseInt(username);
                        Statement stmt = conn.createStatement();
                    String query = "DELETE FROM Assignment"
                            + " WHERE AssignmentId = " + id + ";";
                    int s = stmt.executeUpdate(query);
                    }
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
                            query = "SELECT title, weight, deadlineday, deadlinetime, assignmentId \n" +
                                    "FROM Assignment\n" +
                                    "WHERE moduleName = '" + r.getString(1) + "'" +
                                    "AND sectionNumber ='" + r.getString(2) + "'" +
                                    "AND year = date_part('year', CURRENT_DATE)\n" +
                                    "        AND (((EXTRACT(MONTH FROM CURRENT_DATE) BETWEEN 09 AND 12) AND trimester = 'FA')\n" +
                                    "        OR ((EXTRACT(MONTH FROM CURRENT_DATE) BETWEEN 01 AND 05) AND trimester = 'SP')\n" +
                                    "        OR ((EXTRACT(MONTH FROM CURRENT_DATE) BETWEEN 06 AND 08) AND trimester = 'SU'));";
                       String query2 = "SELECT COUNT(*) \n" +
                                    "FROM Assignment\n" +
                                    "WHERE moduleName = '" + r.getString(1) + "'" +
                                    "AND sectionNumber ='" + r.getString(2) + "'" +
                                    "AND year = date_part('year', CURRENT_DATE)\n" +
                                    "        AND (((EXTRACT(MONTH FROM CURRENT_DATE) BETWEEN 09 AND 12) AND trimester = 'FA')\n" +
                                    "        OR ((EXTRACT(MONTH FROM CURRENT_DATE) BETWEEN 01 AND 05) AND trimester = 'SP')\n" +
                                    "        OR ((EXTRACT(MONTH FROM CURRENT_DATE) BETWEEN 06 AND 08) AND trimester = 'SU'));";
                                    
                       Statement stmt2 = conn.createStatement();
                       ResultSet rst2 = stmt2.executeQuery(query); 
                       Statement stmt3 = conn.createStatement();
                       ResultSet rst3 = stmt3.executeQuery(query2);
                       writer.println("<br>");

                       writer.println("<table id=\"customers\">");
                        if(rst3.next()) {
                            c = rst3.getInt(1);
                            if(c!=0) {
writer.println("<div class=\"caption\">List of Assignments:</div>"); 
  writer.println("<br>");
                                writer.println("<tr><th>Title</th>");
                                writer.println("<th>Weight</th>");
                                writer.println("<th>Due Date </th>");
                                writer.println("<th>Due Time</th></tr>");
                            }
                        }
                       
                        while (rst2.next()) {
                            writer.println("<tr>");
                            writer.println("<form method='post' action='ProfAsgInfo'>");
                            writer.println("<input type='hidden' placeholder='username' name='username' value = '" + username + "'>");
                            writer.println("<input type='hidden' placeholder='assid' name='" + rst2.getInt(5) + "' value = '" + rst2.getInt(5) + "'> ");
                            writer.println("<input type='hidden' placeholder='course' name='course' value = '" + r.getString(1) + "'>");
                            writer.println("<input type='hidden' placeholder='section' name='section' value = '" + r.getString(2) + "'>");
                            writer.println("<td><input type='submit' name='" + rst2.getString(1) + "' value='" + rst2.getString(1) + "'</td>");
                            writer.println("</form>"); 
                            writer.println("<td>" + rst2.getInt(2) + "%</td>");
                            writer.println("<td>" + rst2.getString(3) + "</td>");
                            writer.println("<td>" + rst2.getString(4) + "</td>");
                        }
                           writer.println("</table>");
                        if (c==0) {
                            writer.println("<h class=\"caption\"> There are not yet any assignments in this course. </h> ");
                        }
                        writer.println("<form method='post' action='AddAsg'>");
                        writer.println("<input type='hidden' placeholder='course' name='" + r.getString(1) + "' value = '" + r.getString(1) + "'>");
                        writer.println("<input type='hidden' placeholder='section' name='" + r.getString(2) + "' value = '" + r.getString(2) + "'>");
                        writer.println("<input type='hidden' placeholder='username' name='username' value = '" + username + "'>");
                        writer.println("<input type='submit' class='button mid btnPush btnLightBlue' value = 'Add assignment'>");
                        
                        
                        writer.println("</form>");
                        
                            
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

