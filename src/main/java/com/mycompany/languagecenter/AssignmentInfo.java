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
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;



/**
 *
 * @author SHSS
 */
@WebServlet(name = "AssignmentInfo", urlPatterns = {"/AssignmentInfo"})
public class AssignmentInfo extends HttpServlet {
    String username;
    int i, flag, asId;
    String course2;
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
         
        writer.println("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js\"></script>");
        writer.println("<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">");
               writer.println("<script src=\"pass.js\"></script>");
       
        writer.println(" <script> function validateForm() {\n" +
"  var x = document.forms[\"myForm\"][\"answer\"].value;\n" +
"  if (x == \"\" || x == null) {\n" +
"    alert(\"You must fill out an answer first!\");\n" +
"    return false;\n" +
"  }\n" +
"}"
   + "</script>");
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
                    if(request.getParameter("submitted")!=null) {
                        username = request.getParameter("username");
                    int i = Integer.parseInt(username);
                    String asId = request.getParameter("assid");
                    int assId = Integer.parseInt(asId);
                        Statement stmt = conn.createStatement();
                    String query = "Insert into Submission (answer, AssignmentId,studentId,submissionDate, submissionTime)"
                            + "VALUES (?, ?, ?, ?, ?);";
                    PreparedStatement prepStmt = conn.prepareStatement(query);
                    prepStmt.setInt (2, assId);
                    prepStmt.setInt(3, i);
                    SimpleDateFormat formatdate = new SimpleDateFormat("yyyy-MM-dd");
                    LocalDate dt = java.time.LocalDate.now();
                    java.util.Date utilDate = formatdate.parse(dt.toString());
                    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
                    prepStmt.setDate (4, sqlDate);
                    Date date;
                    date = new Date();
                    String strDateFormat = "HH:mm";
                    SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat);
                    String dt2 = sdf.format(date);
                    Date d = sdf.parse(dt2);
                    java.sql.Time sqltime = new java.sql.Time(d.getTime());
                    
                    String ans = request.getParameter("answer");
            
                    prepStmt.setString(1, ans);
                    prepStmt.setTime(5, sqltime);
                    prepStmt.execute();
           
                    }
                    
                    Statement stmt = conn.createStatement();
                    String query = "SELECT title, weight, deadlineday, deadlinetime, description, assignmentID \n" +
                                    "FROM Assignment\n" +
                                    "WHERE moduleName = '" + request.getParameter("course") + "'" +
                                    "AND sectionNumber ='" + request.getParameter("section") + "'" +
                                    "AND year = date_part('year', CURRENT_DATE)\n" +
                                    "        AND (((EXTRACT(MONTH FROM CURRENT_DATE) BETWEEN 09 AND 12) AND trimester = 'FA')\n" +
                                    "        OR ((EXTRACT(MONTH FROM CURRENT_DATE) BETWEEN 01 AND 05) AND trimester = 'SP')\n" +
                                    "        OR ((EXTRACT(MONTH FROM CURRENT_DATE) BETWEEN 06 AND 08) AND trimester = 'SU'));";
                    
                    ResultSet rst = stmt.executeQuery(query); 
                     writer.println("<div class=\"boxy2 idk frm\" >");
                    while (rst.next()) {
                      
                        if(request.getParameter(rst.getString(6))!=null) {
                             course2 = rst.getString(6);
                            writer.println("<br><h class=\"cap\" > Title: </h>");
                            writer.println("<h>" + rst.getString(1) + " </h><br><br>");
                            writer.println("<h class=\"cap\"> Weight: </h>");
                            writer.println("<h>" + rst.getInt(2) + "%</h><br><br>");
                            writer.println("<h class=\"cap\"> Due date: </h>");
                            writer.println("<h >" + rst.getString(3) + " </h><br><br>");
                            writer.println("<h class=\"cap\"> Due time: </h>");
                            writer.println("<h>" + rst.getString(4) + " </h><br><br>");
                            writer.println("<h class=\"cap\"> Description: </h>");
                            writer.println("<h>" + rst.getString(5) + " </h><br><br>");
                            asId = rst.getInt(6);
                        }
                        
                        
                    }
                    String query2 = "SELECT answer, grade, feedback, submissionDate, submissionTime\n" +
                            "FROM Submission\n" +
                            "WHERE studentID ="+ i +" AND AssignmentID = " + asId + ";";
                    query = "SELECT COUNT(*) "+
                            "FROM Submission\n" +
                            "WHERE studentID ="+ i +" AND AssignmentID = " + asId + ";" ;
                    Statement stmt2 = conn.createStatement();
                    Statement stmt3 = conn.createStatement();
                    ResultSet rst2 = stmt2.executeQuery(query2);
                    ResultSet rst3 = stmt3.executeQuery(query);
                    if (rst3.next()) {
                        if(rst3.getInt(1)!=0) {
                            writer.println("<br><h  class=\"cap\"> You have submitted an answer to this assignment </h><br><br>");
                            if(rst2.next()) {
                                if (rst2.getString(2)!=null) {
                               writer.println("<h class=\"cap\"> Grade: </h>"+ rst2.getFloat(2)+"</h><br><br>");
                           }
                                if(rst2.getString(3)!=null) {
                               writer.println("<h class=\"cap\"> Feedback: </h>" + rst2.getString(3)+ "<br><br>");
                           }
                            }
                        }
                        else {
                            writer.println("<form name='myForm' action='AssignmentInfo' onsubmit='return validateForm()' method='post' required>\n");
                            writer.println("<input type='hidden' placeholder='submitted' name='submitted' value = '" + username + "'>");
                            writer.println("<input type='hidden' placeholder='username' name='username' value = '" + username + "'>");
                             writer.println("<input type='hidden' placeholder='course' name='course' value = '" + request.getParameter("course") + "'>");
                              
                            writer.println("<input type='hidden' placeholder='course' name='"+ course2 +"' value = '"+course2 +"'>");
                             writer.println("<input type='hidden' placeholder='section' name='section' value = '" + request.getParameter("section") + "'>");
                            writer.println("<input type='hidden' placeholder='assid' name='assid' value = '" + asId + "'>");
writer.println("  Answer: <br><textarea type='text' name='answer'></textarea><br>\n");
writer.println("<input type = 'submit' value='Submit' class='button btnPush btnLightBlue'>"
+ "</form>");
                        
                        }
                          writer.println("</div>");
                    }
                    
                    
                }
            }
        } catch (Exception e) {
        //e.printStackTrace();
        writer.println("Exception caught");
        writer.println(e.toString());
        }
        writer.println("</body>");
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
