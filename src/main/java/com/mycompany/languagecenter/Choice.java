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
@WebServlet(name = "Choice", urlPatterns = {"/Choice"})
public class Choice extends HttpServlet {
    int i, c;
    int flag, flag2, flag1=0;
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
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Schedule</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Schedule at " + request.getContextPath() + "</h1>");
>>>>>>> first
            out.println("</body>");
            out.println("</html>");
        }
    }
    
    @Override
     protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
     // read form fields
        String username = request.getParameter("username");
        
        i=Integer.parseInt(username);
        
        // do some processing here...
         
        // get response writer
        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println("<head>");
        writer.println("<link rel=\"stylesheet\" href=\"choice.css\">\n");
<<<<<<< HEAD
           writer.println(" <link rel=\"shortcut icon\" type=\"image/x-icon\" href=\"logo.PNG\" >\n");
=======
>>>>>>> first
        writer.append("<link href=\"https://fonts.googleapis.com/css2?family=Courgette&display=swap\" rel=\"stylesheet\">\n" +
"");
        writer.println("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js\"></script>");
        writer.println("<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">");
               writer.println("<script src=\"pass.js\"></script>");
               writer.println("<script>function myFunction() {\n" +
"  var x = document.getElementById(\"myDIV\");\n" +
"  if (x.style.display === \"none\") {\n" +
"    x.style.display = \"block\";\n" +
"  } else {\n" +
"    x.style.display = \"none\";\n" +
"  }\n" +
"}\n" +
"function myFunction2() {\n" +
"  var x = document.getElementById(\"myDIV2\");\n" +
"  if (x.style.display === \"none\") {\n" +
"    x.style.display = \"block\";\n" +
"  } else {\n" +
"    x.style.display = \"none\";\n" +
"  }\n" +
"}</script>");
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
                if (request.getParameter("sched") != null) {
       
                Statement stmt = conn.createStatement();
                ResultSet rst = stmt.executeQuery("SELECT moduleName, sectionNumber, trimester, year, meetDays, \n" +
                "                  startTime, endTime, P.firstName, P.lastName, finalGrade,S.firstName, S.lastName    \n" +
                "				  FROM Student AS S INNER JOIN Enroll ON S.userID = Enroll.studentId NATURAL JOIN Section AS SE\n" +
                "                           INNER JOIN Professor AS P ON P.userID = SE.professorId \n" +
                "                    WHERE S.userID = " + i +
                "                    AND year = date_part('year', CURRENT_DATE)\n" +
                "                   	AND (((EXTRACT(MONTH FROM CURRENT_DATE) BETWEEN 09 AND 12) AND trimester = 'FA')\n" +
                "                    OR ((EXTRACT(MONTH FROM CURRENT_DATE) BETWEEN 01 AND 05) AND trimester = 'SP')\n" +
                "                    OR ((EXTRACT(MONTH FROM CURRENT_DATE) BETWEEN 06 AND 08) AND trimester = 'SU'));");
                String query = "SELECT COUNT(*)   \n" +
                "				  FROM Student AS S INNER JOIN Enroll ON S.userID = Enroll.studentId NATURAL JOIN Section AS SE\n" +
                "                           INNER JOIN Professor AS P ON P.userID = SE.professorId \n" +
                "                    WHERE S.userID = " + i +
                "                    AND year = date_part('year', CURRENT_DATE)\n" +
                "                   	AND (((EXTRACT(MONTH FROM CURRENT_DATE) BETWEEN 09 AND 12) AND trimester = 'FA')\n" +
                "                    OR ((EXTRACT(MONTH FROM CURRENT_DATE) BETWEEN 01 AND 05) AND trimester = 'SP')\n" +
                "                    OR ((EXTRACT(MONTH FROM CURRENT_DATE) BETWEEN 06 AND 08) AND trimester = 'SU'));";
                Statement stmt2 = conn.createStatement();
                ResultSet rst2 = stmt2.executeQuery(query);
                if(rst2.next()) {
                    c = rst2.getInt(1);
                    if(c!=0) {
                            rst.next();
                            writer.println("<br>");
                            writer.println("<br>");
                            writer.println("<div class=\"caption\">" + rst.getString(11) + " " + rst.getString(12) + " " + "'s Schedule");
                            writer.println("for the trimester " + rst.getString(3) + " " + rst.getString(4)+ " </div>");
                         
                            writer.println("<br>");
                            writer.println("<table id=\"customers\">");
                            writer.println("<tr><th>Module</th>");
                            writer.println("<th>Section</th>");
                            writer.println("<th>Meeting days</th>");
                            writer.println("<th>Starting Time</th>");
                            writer.println("<th>Ending Time</th>");
                            writer.println("<th>Professor Name</th>");
                            writer.println("<th>Grade</th></tr>");
                            writer.println("<tr>");
                            writer.println("<td>" + rst.getString(1) + "</td>");
                            writer.println("<td>" + rst.getInt(2) + "</td>");
                            writer.println("<td>" + rst.getString(5) + "</td>");
                            writer.println("<td>" + rst.getString(6) + "</td>");
                            writer.println("<td>" + rst.getString(7) + "</td>");
                            writer.println("<td>" + rst.getString(8) + " " + rst.getString(9) + "</td>");
                            if (rst.getString(10) == null) {
                                writer.println("<td>  -- </td>");
                            }
                            else {
                            writer.println("<td>" + rst.getString(10) + "</td>");
                            }

                            writer.println("</tr>\n");
                        } else {
                        writer.println("<h> You are not currently enrolled in any course! </h>");
                    }
                }
                    while (rst.next()) {
                        writer.println("<tr>");
                        writer.println("<td>" + rst.getString(1) + "</td>");
                        writer.println("<td>" + rst.getInt(2) + "</td>");
                        writer.println("<td>" + rst.getString(5) + "</td>");
                        writer.println("<td>" + rst.getString(6) + "</td>");
                        writer.println("<td>" + rst.getString(7) + "</td>");
                        writer.println("<td>" + rst.getString(8) + " " + rst.getString(9) + "</td>");
                        if (rst.getString(10) == null) {
                            writer.println("<td>  -- </td>");
                        }
                        else {
                        writer.println("<td>" + rst.getString(10) + "</td>");
                        }
                        
                        writer.println("</tr>\n");
                    }
            
                      writer.println("</table>");
                writer.println("</html>");
                conn.close();
            }
                else if (request.getParameter("prfl")!=null) {
                    String query = "SELECT firstName, lastName, email, phone "
                            + "FROM Users WHERE userId = " + i + ";";
                    Statement  st  = conn.createStatement();
                    ResultSet r = st.executeQuery(query);
                    
                    if(r.next()) 
                     writer.println("<div class=\"boxy\">");
                        writer.println("<button onclick=\"myFunction2()\">Personal Information <i class=\"fa fa-angle-double-down\"></i></button>");
                        writer.println("<div id=\"myDIV2\">");
                        writer.println("<h class=\"cap\">First Name: </h>" + r.getString(1));
                        writer.println("<br><br>");
                        writer.println("<h class=\"cap\">Last Name: </h>" + r.getString(2));
                        writer.println("<br><br>");
                        writer.println("<h class=\"cap\">Email: </h>" + r.getString(3));
                        writer.println("<br><br>");
                        if(r.getString(4)!=null)
                            writer.println("<h class=\"cap\">Phone number: </h>"+ r.getString(4));
                        
                        else
                             writer.println("<h class=\"cap\">Phone number: --</h>");
                        writer.println("</div>");
                        writer.println("<br>");
                        writer.println("<br>");
                        writer.println("<button onclick=\"myFunction()\">Change password <i class=\"fa fa-angle-double-down\"></i></button>");
                        writer.println("<br><br>");
                        writer.println("<div id=\"myDIV\">");
                        writer.println("<form method='post' action='changepass' onsubmit=\"alert ('Password changed successfully!');\">");
<<<<<<< HEAD
                        writer.println("<label class=\"cap\">password :\n" +
                        "  <input name=\"password\" id=\"password\" type=\"password\" required>\n" +
                        "</label>\n" +
                        "<br><br>\n" +
                        "<label class=\"cap\">confirm password:\n" +
=======
                        writer.println("<label>password :\n" +
                        "  <input name=\"password\" id=\"password\" type=\"password\" required>\n" +
                        "</label>\n" +
                        "<br><br>\n" +
                        "<label>confirm password:\n" +
>>>>>>> first
                        "  <input type=\"password\" name=\"confirm_password\" id=\"confirm_password\" required>\n" +
                        "  <span id='message'></span>"
                                                        + "<script src=\"pass.js\"></script>\n" +
                        "</label>");
                        writer.println("<input type='hidden' placeholder='username' name='username' value = " + username + ">");  
                        writer.println("<br><br>");
<<<<<<< HEAD
                        writer.println("<input type='submit' name='student' class='button btnPush btnLightBlue smtg' value = 'Submit changes'>");
=======
                        writer.println("<input type='submit' class='button btnPush btnLightBlue  middle' value = 'Submit changes'>");
>>>>>>> first
                        writer.println("</form>");
                        writer.println("</div>");
                        writer.println("</div>");

                }
                else if (request.getParameter("assi") != null) {
                    
                     Statement stmt = conn.createStatement();
                ResultSet rst = stmt.executeQuery("SELECT moduleName, sectionNumber" +
                "				  FROM Student AS S INNER JOIN Enroll ON S.userID = Enroll.studentId NATURAL JOIN Section AS SE\n" +
                "                           INNER JOIN Professor AS P ON P.userID = SE.professorId \n" +
                "                    WHERE S.userID = " + i +
                "                    AND year = date_part('year', CURRENT_DATE)\n" +
                "                   	AND (((EXTRACT(MONTH FROM CURRENT_DATE) BETWEEN 09 AND 12) AND trimester = 'FA')\n" +
                "                    OR ((EXTRACT(MONTH FROM CURRENT_DATE) BETWEEN 01 AND 05) AND trimester = 'SP')\n" +
                "                    OR ((EXTRACT(MONTH FROM CURRENT_DATE) BETWEEN 06 AND 08) AND trimester = 'SU'));");
                String  query = "SELECT COUNT(*)" +
                "				  FROM Student AS S INNER JOIN Enroll ON S.userID = Enroll.studentId NATURAL JOIN Section AS SE\n" +
                "                           INNER JOIN Professor AS P ON P.userID = SE.professorId \n" +
                "                    WHERE S.userID = " + i +
                "                    AND year = date_part('year', CURRENT_DATE)\n" +
                "                   	AND (((EXTRACT(MONTH FROM CURRENT_DATE) BETWEEN 09 AND 12) AND trimester = 'FA')\n" +
                "                    OR ((EXTRACT(MONTH FROM CURRENT_DATE) BETWEEN 01 AND 05) AND trimester = 'SP')\n" +
                "                    OR ((EXTRACT(MONTH FROM CURRENT_DATE) BETWEEN 06 AND 08) AND trimester = 'SU'));";
                Statement stmt2 = conn.createStatement();
                ResultSet rst2 = stmt2.executeQuery(query);
                if(rst2.next()) {
                    c = rst2.getInt(1);
                    if (c!=0) {
                        writer.println("<div class=\"caption\"> Select the course </div><br>");
                    }
                     
                    
                }
                    writer.println("<div class=\"smtg\">");
                while(rst.next()) {
                  
                    writer.println("<form method='post' action='Assignments'>");
                    writer.println("<input type='hidden' placeholder='username' name='username' value = " + username + "> </input>");
                     writer.println("<input type='hidden' placeholder='section' name='" + rst.getString(2) + "' value = " +  rst.getString(2) + ">");
                    writer.println("<input type='submit' class='button btnPush btnLightBlue' name='" +  rst.getString(1) + "' value='" +  rst.getString(1) +" Section " + rst.getString(2) + "'>");

                    System.out.println("<h>" + rst.getString(1) + " Section " + rst.getString(2) + "</h><br>");
                    writer.println("</form>");
                    writer.println("<br>");
                    writer.println("<br>");
                }
                  writer.println("</div>");
                if(c==0) {
                    writer.println("<h> You are not currently enrolled in any course! </h>");
                }
                }
                else if (request.getParameter("fee") != null) {
                    String query = "SELECT modulename, statementyear, statementtrimester \n" +
                    "FROM coursefeestatement\n" +
                    "WHERE studentId = " + i +
                    "AND (((EXTRACT(MONTH FROM CURRENT_DATE) BETWEEN 09 AND 12) AND statementtrimester = 'FA')\n" +
                    "            OR ((EXTRACT(MONTH FROM CURRENT_DATE) BETWEEN 01 AND 05) AND statementtrimester = 'SP')\n"
                            + "AND statementyear = date_part('year', CURRENT_DATE)" +
                    "            OR ((EXTRACT(MONTH FROM CURRENT_DATE) BETWEEN 06 AND 08) AND statementtrimester = 'SU'));\n" +
                    "			";
                    Statement stmt2 = conn.createStatement();
                    String query2 = "SELECT COUNT(*)\n" +
                    "FROM coursefeestatement\n" +
                    "WHERE studentId = " + i +
                    "AND (((EXTRACT(MONTH FROM CURRENT_DATE) BETWEEN 09 AND 12) AND statementtrimester = 'FA')\n" +
                    "            OR ((EXTRACT(MONTH FROM CURRENT_DATE) BETWEEN 01 AND 05) AND statementtrimester = 'SP')\n"
                            + "AND statementyear = date_part('year', CURRENT_DATE)" +
                    "            OR ((EXTRACT(MONTH FROM CURRENT_DATE) BETWEEN 06 AND 08) AND statementtrimester = 'SU'));";
                    Statement stmt = conn.createStatement();
                    ResultSet rst = stmt.executeQuery(query2);
                    
                    if(rst.next()) {
                        if(rst.getInt(1)>=1) {
                            writer.println("<div class=\"caption\"> Current semester's fee statements: </div><br>");
                            writer.println("<div class=\"smtg\">");
                            ResultSet rst2 = stmt2.executeQuery(query);
                            while (rst2.next()) {
                                writer.println("<form method='post' action='Fees'>");
                                writer.println("<input type='hidden' placeholder='username' name='username' value = '" + username + "'>");
                                writer.println("<input type='hidden' placeholder='year' name='" + rst2.getString(2) + "' value = '" + rst2.getString(2) + "'>");
                                writer.println("<input type='hidden' placeholder='date' name='" + rst2.getString(3) + "' value = '" + rst2.getString(3) + "'>");
                                writer.println("<input type='submit' class='button btnPush btnLightBlue' name='" +  rst2.getString(1) + "' value='" +  rst2.getString(1) +"'>");
                                writer.println("</form>");
                                writer.println("<br>");
                                
                            }
                             writer.println("</div>");
                        }
                    }
                    else {
                        flag1=1;
                    }
                    String query3 = "SELECT COUNT(*) FROM coursefeestatement WHERE studentId = "+ i + 
                            "EXCEPT " + query2;
                    stmt = conn.createStatement();
                    rst=stmt.executeQuery(query3);
                    
                    if(rst.next()) {
                        if(rst.getInt(1)>=1) {
                            
                            writer.println("<h> Past trimesters' fee statements </h><br>");
                            query2 = "SELECT modulename FROM coursefeestatement"
                                    + " WHERE studentId = " + i + 
                                    "EXCEPT" + query;
                            stmt2 =conn.createStatement();
                            ResultSet rst2 = stmt2.executeQuery(query2);
                            
                            while(rst2.next()) {
                                writer.println("<h>" + rst2.getString(1) + "</h><br>");
                            }
                        }
                        else 
                            flag2=2;
                    }
                    
                    if(flag2==2 && flag1==1) {
                        writer.println("You do not currently have any fee statements!\n");
                    }
                    else if (flag1==1) {
                        writer.println("You don't have any fee statements for this trimester!\n");
                    }
                    
                }
            }
                else {
                writer.println("Error: conn is null ");
            }
            
            }
    } catch (Exception e) {
        //e.printStackTrace();
        writer.println("Exception caught");
        writer.println(e.toString());
    }

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

     
  

