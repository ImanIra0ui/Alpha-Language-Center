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
@WebServlet(name = "ModifyGF", urlPatterns = {"/ModifyGF"})
public class ModifyGF extends HttpServlet {

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
            out.println("<title>Servlet ModifyGF</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ModifyGF at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println("<head>");
        writer.println("<link rel=\"stylesheet\" href=\"choice.css\">\n");
        writer.append("<link href=\"https://fonts.googleapis.com/css2?family=Courgette&display=swap\" rel=\"stylesheet\">\n" +
"");
          writer.println("</head>");
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
                                
                    if(r3.next()) {
                        
                                writer.println("<form method='post' action='./ModifyGF' onsubmit=\"alert ('Modified successfully!');\">");
                                writer.println("<input type='hidden' name='StudentID' value =  '" + sID + "' >");
                                writer.println("<input type='hidden' name='asgId' value =  '" + assID + "' >");
                                writer.println("<br>Student ID: " + sID );
                                writer.println("<br>Full Name:" + r3.getString(3) + " " + r3.getString(2));
                                writer.println("<br>Answer:" + r3.getString(1));
                                
                                writer.println("<br><br>Grade: <input type='number' name='grade' value =  '" + grade + "' required>");
                                writer.println("<br><br> Feedback: <textarea name='feedback' >" + feedback + "</textarea>");
                                writer.println("<br><br><input  class='block' type='submit' name='courses' value='Modify grade and feedback'>");
                                writer.println("</form>");
                            
                        }
                    
        
                }
            }
            
 }catch (Exception e) {
        //e.printStackTrace();
        writer.println("Exception caught");
        writer.println(e.toString());
        }
    }

  

}

   
