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

/**
 *
 * @author SHSS
 */
@WebServlet(name = "Modified", urlPatterns = {"/Modified"})
public class Modified extends HttpServlet {

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
            out.println("<title>Servlet Modified</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Modified at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        PrintWriter writer = response.getWriter();
        writer.println("<html>");
           writer.println("<head>");
           writer.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css\">\n" +
"    <link rel=\"stylesheet\" href=\"http://weareoutman.github.io/clockpicker/dist/bootstrap-clockpicker.min.css\">\n" +
"    <link rel=\"stylesheet\" href=\"choice.css\">\n" +
"    <script src=\"http://code.jquery.com/jquery-2.2.0.min.js\"></script>\n" +
"    <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js\"></script>\n" +
"    <script src=\"http://weareoutman.github.io/clockpicker/dist/bootstrap-clockpicker.min.js\"></script>");
        writer.append("<link href=\"https://fonts.googleapis.com/css2?family=Courgette&display=swap\" rel=\"stylesheet\">\n" +
""); writer.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css\">\n" +
"    <link rel=\"stylesheet\" href=\"http://weareoutman.github.io/clockpicker/dist/bootstrap-clockpicker.min.css\">\n" +
"    <link rel=\"stylesheet\" href=\"choice.css\">\n" +
"    <script src=\"http://code.jquery.com/jquery-2.2.0.min.js\"></script>\n" +
"    <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js\"></script>\n" +
"    <script src=\"http://weareoutman.github.io/clockpicker/dist/bootstrap-clockpicker.min.js\"></script>");
         writer.append("<link href=\"https://fonts.googleapis.com/css2?family=Courgette&display=swap\" rel=\"stylesheet\">\n" +
"");
       
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
                        writer.println("<div id=\"sideBar\">");
                             
                        writer.println("<form method='post' action='./ProfChoice'>");
                        writer.println("<input type='hidden' placeholder ='username2' name='username' value = '"+ username +"'>");
                        writer.println("<input  class='nav-element' type='submit' name='prof' value='My Profile'>");
                        writer.println("</form>");
                        
                        writer.println("<form method='post' action='./ProfChoice'>");
                        writer.println("<input type='hidden' placeholder='username' name='username' value = '" + username + "'>");
                        writer.println("<input class='nav-element' type='submit' name='sched' value='My Schedule'>");
                        writer.println("</form>");

                        writer.println("<form method='post' action='./ProfChoice'>");
                        writer.println("<input type='hidden' placeholder ='username2' name='username' value =  '"+ username+ "'>");
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
                    
                    String id = request.getParameter("asID");
                    int asId = Integer.parseInt(id);
                    String title = request.getParameter("title");
                    String desc = request.getParameter("desc");
                    String w = request.getParameter("weight");
                    int f = Integer.parseInt(w);
                    
                    
                    SimpleDateFormat formatdate = new SimpleDateFormat("yyyy-MM-dd");
                    LocalDate dt = java.time.LocalDate.now();
                    java.util.Date utilDate = formatdate.parse(request.getParameter("date_picker"));
                    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
                    
                    
                    java.util.Date date;
                    date = new java.util.Date();
                    String strDateFormat = "HH:mm";
                    SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat);
                    java.util.Date d = sdf.parse(request.getParameter("deadlinet"));
                    java.sql.Time sqltime = new java.sql.Time(d.getTime());
                    
                    String query = "UPDATE  Assignment"
                            + " SET deadlineday = '" + sqlDate + "'"+
                            ", deadlinetime = '" + sqltime + "'"+
                            ", title = '" + title +"'" +
                            ", description = '" + desc + "'" +
                            ", weight = " + f +
                            " WHERE assignmentId = " + asId + ";";
                    
                    Statement stmt  = conn.createStatement();
                    int rst = stmt.executeUpdate(query);
                    
                    String assID = request.getParameter("assId");
                    
                    query = "SELECT assignmentId, title, weight, sectionNumber, moduleName, year, trimester, description, deadlineday, deadlinetime "
                            + " FROM Assignment WHERE AssignmentId=" + asId+ ";";
                    
                    Statement stmt2 = conn.createStatement();
                    ResultSet r= stmt2.executeQuery(query);
                    
                    if(r.next()) {
                        writer.println("<div class=\"boxy2\">");
                        writer.println("<div class=\"frm\">");
                        writer.println("<form name='myForm' action='./Modified' onsubmit=\"alert ('Modified successfully!');\" method='post'>\n");
                        writer.println("<input type='hidden' name='asID' value = '" + r.getString(1) + "'>");
                        writer.println("<br> <h class=\"cap2\">Title: </h><input type='text' name='title' value = '" + r.getString(2) + "'>");
                        writer.println("<br><h class=\"cap2\">Weight:       </h><input type='number' name='weight' value = '" + r.getInt(3) + "'>");
                        writer.println("<br><h class=\"cap2\">Module:       </h><input type='text' disabled='disabled' name='module' value = '" + r.getString(5) + "'>");
                        writer.println("<br><h class=\"cap2\">Trimester:      </h><input type='text' disabled = 'disabled' name='trimester' value = '" + r.getString(7) + "'>");
                        writer.println("<br><h class=\"cap2\">year:      </h><input type='text' disabled = 'disabled' name='year' value = '" + r.getString(6) + "'>");
                        writer.println("<br><h class=\"cap2\">Description:      </h><br><textarea name='desc'>" + r.getString(8) + "</textarea>");
                        writer.println("<br><h class=\"cap2\">Deadline Day:      </h><input type='date' value='" + r.getString(9) + "' name='date_picker' required>");
                            writer.println(" <div class=\"input-group clock\">\n" +
                            "        <br><h class=\"cap2\">Deadline Time:      </h><input type='text' name='deadlinet' value='" + r.getString(10)+ "' class='form-control' required>\n" +
                          
                            "    </div>\n" +
                            "    \n" +
                            "    <script src=\"script.js\"></script>");
                        writer.println("<input type='Submit'  class='button btnPush btnLightBlue' value='Modify'>");
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
    

