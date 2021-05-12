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
<<<<<<< HEAD
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
=======
>>>>>>> first

/**
 *
 * @author SHSS
 */
@WebServlet(name = "AddAsg", urlPatterns = {"/AddAsg"})
public class AddAsg extends HttpServlet {
    String username;
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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AddAsg</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddAsg at " + request.getContextPath() + "</h1>");
>>>>>>> first
            out.println("</body>");
            out.println("</html>");
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
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
         
        // read form fields
        username = request.getParameter("username");
<<<<<<< HEAD
        
=======
        i = Integer.parseInt(username);
>>>>>>> first
 
        // do some processing here...
         
        // get response writer
        PrintWriter writer = response.getWriter();
        writer.println("<html>");
           writer.println("<head>");
           writer.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css\">\n" +
"    <link rel=\"stylesheet\" href=\"http://weareoutman.github.io/clockpicker/dist/bootstrap-clockpicker.min.css\">\n" +
"    <link rel=\"stylesheet\" href=\"choice.css\">\n" +
<<<<<<< HEAD
                   " <link rel=\"shortcut icon\" type=\"image/x-icon\" href=\"logo.PNG\" />"+
=======
>>>>>>> first
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
            
<<<<<<< HEAD
        writer.println("<body>");
=======
        writer.println("<body>");   
>>>>>>> first
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
<<<<<<< HEAD
                      writer.println("<div class=\"bottom\"><i class=\"fa fa-sign-out\"></i><a href=\"index.html\">Log out</a></div>");

=======
                        writer.println("<div class=\"bottom\"><i class=\"fa fa-sign-out\"></i>  Log out</div>");
>>>>>>> first
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
<<<<<<< HEAD
                    if(request.getParameter("added")!=null) {
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
                    
                    
                    }
                   
                        username = request.getParameter("username");
                        i = Integer.parseInt(username);
                        
                    
                    
=======
>>>>>>> first
                    Statement stmt = conn.createStatement();
                    String query = "SELECT moduleName, sectionNumber, year, trimester FROM section AS S INNER JOIN Professor AS P"
                            + " ON S.professorId = P.userID"
                            + " WHERE S.professorId = "+i +
                            " AND year = date_part('year', CURRENT_DATE)\n" +
                            "        AND (((EXTRACT(MONTH FROM CURRENT_DATE) BETWEEN 09 AND 12) AND trimester = 'FA')\n" +
                            "        OR ((EXTRACT(MONTH FROM CURRENT_DATE) BETWEEN 01 AND 05) AND trimester = 'SP')\n" +
                            "        OR ((EXTRACT(MONTH FROM CURRENT_DATE) BETWEEN 06 AND 08) AND trimester = 'SU'));";
                    ResultSet r = stmt.executeQuery(query);
                    
                    while(r.next()) {
                        if(request.getParameter(r.getString(1))!=null && request.getParameter(r.getString(2))!=null) {
                             writer.println("<div class=\"boxy2\">");
                              writer.println("<div class=\"frm\">");
                               writer.println("<div class=\"cap\">");
                            writer.println(r.getString(1));
                            writer.println(r.getString(2));
                             writer.println("</div>");
<<<<<<< HEAD
                            writer.println("<form name='myForm' action='AddAsg' onsubmit=\"alert ('Added successfully!');\" method='post' required>\n");
                            writer.println("<input type='hidden' placeholder ='username2' name='"+ r.getString(1) +"' value =  '"+ r.getString(1) +"'>");
                            writer.println("<input type='hidden' placeholder ='username2' name='"+ r.getString(2) +"' value =  '"+ r.getString(2) +"'>");
=======
                            writer.println("<form name='myForm' action='added' onsubmit=\"alert ('Added successfully!');\" method='post' required>\n");
>>>>>>> first
                            writer.println("<input type='hidden' placeholder ='username2' name='username' value =  '"+ username +"'>");
                            writer.println("<br> <h class=\"cap2\">Title: </h><input type='text' name='title' required>");
                            writer.println("<br> <h class=\"cap2\">Weight:       </h><input type='text' name='weight' required>");
                            writer.println("<br> <h class=\"cap2\">Module:       </h><input class=\"non\" type='text' name='module' value = '"+ r.getString(1)+"'>");
                            writer.println("<br> <h class=\"cap2\">Section:      </h><input class=\"non\"type='text' name='section' value = '"+ r.getString(2)+"'>");
                            writer.println("<br> <h class=\"cap2\">Deadline date: </h><input type='date' name='date_picker' required>");
                            writer.println(" <div class=\"input-group clock\">\n" +
                            "     <h class=\"cap\"> Deadline time:  </h><input type='text' name='deadlinet' value='00:00' class='form-control' value='00:00' required>\n" +
                            "    <i class=\"fa fa-clock-o\"></i>\n" +
                            "    </div>\n" +
                            "    \n" +
                            "    <script src=\"script.js\"></script>");
                            writer.println("<input type='hidden' name='year' value = '" + r.getString(3) + "'>");
<<<<<<< HEAD
                            writer.println("<input type='hidden' name='added' value = '" + r.getString(3) + "'>");
=======
>>>>>>> first
                            writer.println("<input type='hidden' name='trimester' value = '" + r.getString(4) + "'>");
                            writer.println("<h class=\"cap2\"> Description: </h> <br><textarea type='text' name='desc'></textarea><br>\n");
                            writer.println("<input type = 'submit' value='Submit' class='button btnPush btnLightBlue'>"
                            + "</form>");
                            writer.println("</div>");
                            writer.println("</div>");
                        }
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

