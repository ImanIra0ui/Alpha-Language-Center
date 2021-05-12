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
@WebServlet(name = "Submit", urlPatterns = {"/Submit"})
public class Submit extends HttpServlet {
    String asId, username;
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
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Submit</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Submit at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
     protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
         
        // read form fields
        username = request.getParameter("username");
        i = Integer.parseInt(username);
        asId = request.getParameter("assid");
        int assId = Integer.parseInt(asId);
        // do some processing here...
         
        // get response writer
        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        
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
           
                    stmt = conn.createStatement();
                    query = "SELECT title, weight, deadlineday, deadlinetime, description \n" +
                                    "FROM Assignment\n" +
                                    "WHERE assignmentId = "+ assId + ";";
                    
                    ResultSet rst = stmt.executeQuery(query); 
                     writer.println("<div class=\"boxy2 idk frm\" >");
                     
                    while(rst.next()) {
                            writer.println("ANSWER SUBMITTED SUCCESSFULY!");
                            writer.println("<h class=\"cap\" > Title: </h>");
                            writer.println("<h>" + rst.getString(1) + " </h><br><br>");
                            writer.println("<h class=\"cap\"> Weight: </h>");
                            writer.println("<h>" + rst.getInt(2) + "%</h><br><br>");
                            writer.println("<h class=\"cap\"> Due date: </h>");
                            writer.println("<h >" + rst.getString(3) + " </h><br><br>");
                            writer.println("<h class=\"cap\"> Due time: </h>");
                            writer.println("<h>" + rst.getString(4) + " </h><br><br>");
                            writer.println("<h class=\"cap\"> Description: </h>");
                            writer.println("<h>" + rst.getString(5) + " </h><br><br>");
                    }
                        
                    String query2 = "SELECT answer, grade, feedback, submissionDate, submissionTime\n" +
                            "FROM Submission\n" +
                            "WHERE studentID ="+ i +" AND AssignmentID = " + assId + ";";
                    query = "SELECT COUNT(*) "+
                            "FROM Submission\n" +
                            "WHERE studentID ="+ i +" AND AssignmentID = " + assId + ";" ;
                    
                    Statement stmt2 = conn.createStatement();
                    Statement stmt3 = conn.createStatement();
                    ResultSet rst2 = stmt2.executeQuery(query2);
                    ResultSet rst3 = stmt3.executeQuery(query);
                    if (rst3.next()) {
                        if(rst3.getInt(1)!=0) {
                            writer.println("<br><h  class=\"cap\"> You have submitted an answer to this assignment </h><br><br>");
                            if(rst2.next()) {
                                writer.println("<h class=\"cap\"> Your answer: </h><h>" + rst2.getString(1) + "</h><br><br><br>");
                                if (rst2.getString(2)!=null) {
                               writer.println("<h> Grade:"+ rst2.getFloat(2)+"</h><br>");
                           }
                                if(rst2.getString(3)!=null) {
                               writer.println("<h> Feedback " + rst2.getString(3)+ "</h><br>");
                           }
                            }
                        }
                        else {
                            writer.println("<form name='myForm' action='Submit' onsubmit='return validateForm()' method='post' required>\n");
                            writer.println("<input type='hidden' placeholder='username' name='username' value = '" + username + "'>");
                            writer.println("<input type='hidden' placeholder='assid' name='assid' value = '" + asId + "'>");
writer.println("  Answer: <br><textarea type='text' name='answer'></textarea><br>\n");
writer.println("<input type = 'submit' value='Submit' class='button btnPush btnLightBlue'>"
+ "</form>");
                        
                        }
                          writer.println("</div>");
                    }
                    
                }
            }
        }  catch (Exception e) {
        //e.printStackTrace();
        writer.println("Exception caught");
        writer.println(e.toString());
        }
    }
    

}
