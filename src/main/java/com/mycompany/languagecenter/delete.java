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
@WebServlet(name = "delete", urlPatterns = {"/delete"})
public class delete extends HttpServlet {
    
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
            out.println("<title>Servlet delete</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet delete at " + request.getContextPath() + "</h1>");
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
        writer.println("</head>");
        writer.println("<body>");
        
        int c=0;
        String assId = request.getParameter("assId");
        int id = Integer.parseInt(assId);
        
        String username = request.getParameter("username");
        int i = Integer.parseInt(username);
       
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
                    String query = "DELETE FROM Assignment"
                            + " WHERE AssignmentId = " + id + ";";
                    int s = stmt.executeUpdate(query);
                    
                    Statement stmt2 = conn.createStatement();
                    query = "SELECT moduleName, sectionNumber FROM section AS S INNER JOIN Professor AS P"
                            + " ON S.professorId = P.userID"
                            + " WHERE S.professorId = "+i +
                            " AND year = date_part('year', CURRENT_DATE)\n" +
                            "        AND (((EXTRACT(MONTH FROM CURRENT_DATE) BETWEEN 09 AND 12) AND trimester = 'FA')\n" +
                            "        OR ((EXTRACT(MONTH FROM CURRENT_DATE) BETWEEN 01 AND 05) AND trimester = 'SP')\n" +
                            "        OR ((EXTRACT(MONTH FROM CURRENT_DATE) BETWEEN 06 AND 08) AND trimester = 'SU'));";
                    ResultSet r = stmt2.executeQuery(query);
                    
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
                                    
                       stmt2 = conn.createStatement();
                       ResultSet rst2 = stmt2.executeQuery(query); 
                       Statement stmt3 = conn.createStatement();
                       ResultSet rst3 = stmt3.executeQuery(query2);
                       writer.println("<br>");

                       writer.println("<table id=\"customers\">");
                       
                        if(rst3.next()) {
                            c = rst3.getInt(1);
                            if(c!=0) {
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
                            writer.println("<input type='hidden' placeholder='assid' name='" + rst2.getInt(5) + "' value = '" + rst2.getInt(5) + "'> ");
                            writer.println("<td><input type='submit' name='" + rst2.getString(1) + "' value='" + rst2.getString(1) + "'</td>");
                            writer.println("</form>"); 
                            writer.println("<td>" + rst2.getInt(2) + "%</td>");
                            writer.println("<td>" + rst2.getString(3) + "</td>");
                            writer.println("<td>" + rst2.getString(4) + "</td><br>");
                            writer.println("</tr>");
                        }
                        
                        if (c==0) {
                            writer.println("<h> There are not yet any assignments in this course. </h> ");
                        }
                        writer.println("<form method='post' action='AddAsg'>");
                        writer.println("<input type='hidden' placeholder='course' name='" + r.getString(1) + "' value = '" + r.getString(1) + "'>");
                        writer.println("<input type='hidden' placeholder='section' name='" + r.getString(2) + "' value = '" + r.getString(2) + "'>");
                        writer.println("<input type='hidden' placeholder='username' name='username' value = '" + username + "'>");
                        writer.println("<input type='submit' value = 'Add assignment'>");
                        
                        
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

  

    }