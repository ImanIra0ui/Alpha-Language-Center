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
@WebServlet(name = "added", urlPatterns = {"/added"})
public class added extends HttpServlet {
    String username;
    int i, c;
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
            out.println("<title>Servlet added</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet added at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

   @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
          username=request.getParameter("username");
          i = Integer.parseInt(username);
        // get response writer
        PrintWriter writer = response.getWriter();
        writer.println("<html>");
           writer.println("<head>");
            writer.println("<link rel=\"stylesheet\" href=\"choice.css\">\n");
        writer.append("<link href=\"https://fonts.googleapis.com/css2?family=Courgette&display=swap\" rel=\"stylesheet\">\n" +
"");
        
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
                        writer.println("<div class=\"bottom\"><i class=\"fa fa-sign-out\"></i>  Log out</div>");
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
                    String query = "Insert into Assignment (title,description,weight,"
                            + " deadlineday, deadlinetime, modulename, sectionnumber, year, trimester)"
                            + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";
                    PreparedStatement prepStmt = conn.prepareStatement(query);
                    prepStmt.setString(1, request.getParameter("title"));
                    prepStmt.setString(2, request.getParameter("desc"));
                    String w = request.getParameter("weight");
                    int f = Integer.parseInt(w);
                    prepStmt.setInt(3, f);
                    prepStmt.setString(6, request.getParameter("module"));
                    prepStmt.setString(9, request.getParameter("trimester"));
                    f = Integer.parseInt(request.getParameter("year"));
                    prepStmt.setInt(8, f);
                    String section = request.getParameter("section");
                    int i = Integer.parseInt(section);
                    prepStmt.setInt(7, i);
                    SimpleDateFormat formatdate = new SimpleDateFormat("yyyy-MM-dd");
                    LocalDate dt = java.time.LocalDate.now();
                    java.util.Date utilDate = formatdate.parse(request.getParameter("date_picker"));
                    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
                    prepStmt.setDate (4, sqlDate);
                    Date date;
                    date = new Date();
                    String strDateFormat = "HH:mm";
                    SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat);
                    Date d = sdf.parse(request.getParameter("deadlinet"));
                    java.sql.Time sqltime = new java.sql.Time(d.getTime());
                    prepStmt.setTime(5, sqltime);
                    prepStmt.execute();
                    
                   
                            query = "SELECT title, weight, deadlineday, deadlinetime, assignmentId \n" +
                                    "FROM Assignment\n" +
                                    "WHERE moduleName = '" + request.getParameter("module") + "'" +
                                    "AND sectionNumber ='" + request.getParameter("section") + "'" +
                                    "AND year = date_part('year', CURRENT_DATE)\n" +
                                    "        AND (((EXTRACT(MONTH FROM CURRENT_DATE) BETWEEN 09 AND 12) AND trimester = 'FA')\n" +
                                    "        OR ((EXTRACT(MONTH FROM CURRENT_DATE) BETWEEN 01 AND 05) AND trimester = 'SP')\n" +
                                    "        OR ((EXTRACT(MONTH FROM CURRENT_DATE) BETWEEN 06 AND 08) AND trimester = 'SU'));";
                       String query2 = "SELECT COUNT(*) \n" +
                                    "FROM Assignment\n" +
                                    "WHERE moduleName = '" + request.getParameter("module") + "'" +
                                    "AND sectionNumber ='" + request.getParameter("section") + "'" +
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
                            writer.println("<input type='hidden' placeholder='course' name='course' value = '" + request.getParameter("module") + "'>");
                            writer.println("<input type='hidden' placeholder='section' name='section' value = '" + request.getParameter("section") + "'>");
                            writer.println("<td><input type='submit' name='" + rst2.getString(1) + "' value='" + rst2.getString(1) + "'</td>");
                            writer.println("</form>"); 
                            writer.println("<td>" + rst2.getInt(2) + "%</td>");
                            writer.println("<td>" + rst2.getString(3) + "</td>");
                            writer.println("<td>" + rst2.getString(4) + "</td>");
                        }
                           writer.println("</table>");
                        if (c==0) {
                            writer.println("<h> There are not yet any assignments in this course. </h> ");
                        }
                        writer.println("<form method='post' action='AddAsg'>");
                        writer.println("<input type='hidden' placeholder='course' name='" + request.getParameter("module") + "' value = '" + request.getParameter("module") + "'>");
                        writer.println("<input type='hidden' placeholder='section' name='" + request.getParameter("section") + "' value = '" + request.getParameter("section") + "'>");
                        writer.println("<input type='hidden' placeholder='username' name='username' value = '" + username + "'>");
                        writer.println("<input type='submit' class='button mid btnPush btnLightBlue' value = 'Add assignment'>");
                        
                        
                        writer.println("</form>");
                        
                            
                        
                    
                }
            }
         }catch (Exception e) {
        //e.printStackTrace();
        writer.println("Exception caught");
        writer.println(e.toString());
        }
    }
    
  

    }