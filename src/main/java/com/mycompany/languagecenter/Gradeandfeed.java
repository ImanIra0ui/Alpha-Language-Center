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
@WebServlet(name = "Gradeandfeed", urlPatterns = {"/Gradeandfeed"})
public class Gradeandfeed extends HttpServlet {
    String username;
    int i, flag=0,c=0;
    
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // read form fields
         
          username = request.getParameter("username");
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
                    if(request.getParameter("courses")!=null) {
                        String sID = request.getParameter("StudentID");
                    String assID = request.getParameter("asgId");
                    String grade = request.getParameter("grade"); 
                    String feedback = request.getParameter("feedback"); 

                    int i = Integer.parseInt(sID);
                    int f = Integer.parseInt(assID);
                    float g = Float.parseFloat(grade);

                    String query = "UPDATE Submission\n" +
                    "SET grade = " + g + ",\n" +
                    "    feedback='" + feedback + "'\n" +
                    "WHERE assignmentId = "+ f + "\n" +
                    "AND studentId = " + i + ";";
                    
                    Statement stmt  = conn.createStatement();
                    int rst = stmt.executeUpdate(query);
                    
                    query = "SELECT answer, S.firstName, S.lastName"
                            + " FROM Student AS S INNER JOIN Submission AS Su"
                            + " ON S.userID = Su.studentID"
                            + " WHERE S.userID = " + sID + ";";
                    Statement stmt2 =conn.createStatement();
                    ResultSet r3 = stmt2.executeQuery(query);
                    }
                   String query = "SELECT DISTINCT(S.userID), Su.answer, S.lastName, S.firstName, grade, feedback, A.assignmentID \n" +
                    " FROM Student AS S INNER JOIN Enroll AS E \n" +
                    " ON E.studentID = S.userID\n" +
                    " NATURAL JOIN Section\n" +
                    " NATURAL JOIN Assignment AS A\n" +
                    " FULL OUTER JOIN Submission AS Su\n" +
                    " ON Su.studentID = S.userID AND Su.assignmentID=A.assignmentID" +
                    " WHERE A.moduleName = '" + request.getParameter("course") + "' AND A.sectionNumber = " + request.getParameter("section") + " \n" +
                    "AND A.year = date_part('year', CURRENT_DATE)\n" +
                    "AND (((EXTRACT(MONTH FROM CURRENT_DATE) BETWEEN 09 AND 12) AND A.trimester = 'FA')\n" +
                    "OR ((EXTRACT(MONTH FROM CURRENT_DATE) BETWEEN 01 AND 05) AND A.trimester = 'SP')\n" +
                    " OR ((EXTRACT(MONTH FROM CURRENT_DATE) BETWEEN 06 AND 08) AND A.trimester = 'SU'))\n" +
                    " AND A.assignmentId = "+ request.getParameter("assId") + ";\n" ;
                   
                   Statement stmt3= conn.createStatement();
                    ResultSet r3 = stmt3.executeQuery(query);
                                
                    while(r3.next()) {
                        if(request.getParameter(r3.getString(1))!=null) {
                            if(r3.getString(2)==null) {
                                writer.println("No submission has been made yet by this student!");
                            }
                            else {
                                username = request.getParameter("username");
                                  writer.println("<div class=\"boxy2\">");
                               writer.println("<div class=\"frm\">");
                                writer.println("<form method='post' action='./Gradeandfeed' onsubmit=\"alert ('Modified successfully!');\">");
                                writer.println("<input type='hidden' name='StudentID' value =  '" + r3.getString(1) + "' >");
                                writer.println("<input type='hidden' name='" + r3.getString(1) + "' value =  '" + r3.getString(1) + "' >");
                                writer.println("<input type='hidden' name='asgId' value =  '" + r3.getString(7) + "' >");
                                writer.println("<input type='hidden' name='assId' value =  '" + r3.getString(7) + "' >");
                                writer.println("<input type='hidden' name='course' value =  '" + request.getParameter("course") + "' >");
                                writer.println("<input type='hidden' name='section' value =  '" + request.getParameter("section") + "' >");
                                writer.println("<br><br><h class=\"cap2\">Student ID: </h> " + r3.getString(1));
                                writer.println("<br><br><h class=\"cap2\">Full Name:  </h>" + r3.getString(3) + " "+ r3.getString(4));
                                writer.println("<br><br><h class=\"cap2\">Answer:  </h>" + r3.getString(2));
                                writer.println("<input type='hidden' placeholder='username' name= 'username' value = '" + username + "'>");
                              
                                writer.println("<br><br><h class=\"cap2\">Grade:</h><input type='number' name='grade' value =  '" + r3.getFloat(5) + "' required>");
                                writer.println("<br><br><h class=\"cap2\"> Feedback: </h><br><textarea name='feedback' >" + r3.getString(6) + "</textarea>");
                                writer.println("<br><br><input  class='button smtg2 btnPush btnLightBlue' type='submit' name='courses' value='Modify grade and feedback'>");
                                writer.println("</form>");
                                writer.println("</div>");
                                writer.println("</dv>");
                            }
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