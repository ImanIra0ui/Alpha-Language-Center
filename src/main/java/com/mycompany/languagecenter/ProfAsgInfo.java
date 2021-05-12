
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
@WebServlet(name = "ProfAsgInfo", urlPatterns = {"/ProfAsgInfo"})
public class ProfAsgInfo extends HttpServlet {
     String username,five,four;
     int i,c=0,flag=0;
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
          
        // get response writer
        PrintWriter writer = response.getWriter();
        writer.println("<html>");
           writer.println("<head>");
            writer.println("<link rel=\"stylesheet\" href=\"choice.css\">\n");
               writer.println(" <link rel=\"shortcut icon\" type=\"image/x-icon\" href=\"logo.PNG\" >\n");
        writer.append("<link href=\"https://fonts.googleapis.com/css2?family=Courgette&display=swap\" rel=\"stylesheet\">\n" +
"");
        
       writer.append("<link href=\"https://fonts.googleapis.com/css2?family=Courgette&display=swap\" rel=\"stylesheet\">\n" +
"");
        writer.println("<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">");
        writer.println("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js\"></script>");
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
            writer.println("<body class=\"len\">");   
                        writer.println("<div id=\"sideBar\" class=\"len\">");
                             
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
                 
                    
                    Statement stmt = conn.createStatement();
                    String query = "SELECT title, weight, deadlineday, deadlinetime, description, assignmentID, moduleName, sectionNumber \n" +
                                    "FROM Assignment\n" +
                                    "WHERE moduleName = '" + request.getParameter("course") + "'" +
                                    "AND sectionNumber ='" + request.getParameter("section") + "'" +
                                    "AND year = date_part('year', CURRENT_DATE)\n" +
                                    "        AND (((EXTRACT(MONTH FROM CURRENT_DATE) BETWEEN 09 AND 12) AND trimester = 'FA')\n" +
                                    "        OR ((EXTRACT(MONTH FROM CURRENT_DATE) BETWEEN 01 AND 05) AND trimester = 'SP')\n" +
                                    "        OR ((EXTRACT(MONTH FROM CURRENT_DATE) BETWEEN 06 AND 08) AND trimester = 'SU'));";
                    
                    ResultSet rst = stmt.executeQuery(query); 
                    
                    while (rst.next()) {
                        if(request.getParameter(rst.getString(6))!=null) {
                            
                            c=1;
                             writer.println("<div class=\"boxy3\">");
                            writer.println("<button onclick=\"myFunction2()\">Assignment Information<i class=\"fa fa-angle-double-down\"></i></button>");
                            writer.println("<div id=\"myDIV2\">");
                            writer.println("<div class=\"asg\">");
                            writer.println("<h class=\"cap2\" > Title </h>");
                            writer.println("<h>" + rst.getString(1) + " </h><br><br>");
                                    
                            writer.println("<h class=\"cap2\"> Weight </h>");
                            writer.println("<h>" + rst.getInt(2) + "%</h><br><br>");
                            writer.println("<h class=\"cap2\"> Due date </h>");
                            writer.println("<h >" + rst.getString(3) + " </h><br><br>");
                            writer.println("<h class=\"cap2\"> Due time </h>");
                            writer.println("<h>" + rst.getString(4) + " </h><br><br>");
                            writer.println("<h class=\"cap2\"> Description </h>");
                            
                            if(rst.getString(5)!=null && !(rst.getString(5).trim().isEmpty()))
                                writer.println("<h>" + rst.getString(5) + " </h><br><br>");
                            else
                                writer.println("<h> -- </h><br><br>");
                            
                            writer.println("<h class=\"cap2\"> Class average </h>");
                            int asId = rst.getInt(6);
                            
                            String query2 = "SELECT calculateAvgAssignment("+ asId +"::smallint,"+ rst.getString(8) +""
                                    + "::smallint,'"+ rst.getString(7) +"'::varchar(20));";
                            Statement s = conn.createStatement();
                            ResultSet r = s.executeQuery(query2);
                            
                            while(r.next()) {
                                if(r.getString(1)!=null)
                                    writer.println("<h>" + r.getFloat(1) + " </h><br><br>");
                                else
                                    writer.println("<h> -- </h><br><br>");
                            }
                            writer.println("<div class=\"grid\">");
                            writer.println("<div class=\"itom\">");
                            writer.println("<form method='post' action='ModifyASG'>");
                            writer.println("<input type='hidden' name='assId' value='" + asId + "'>");
                            writer.println("<input type='hidden' name='username' value='" + username + "'>");
                            writer.println("<input type='Submit' class='button btnPush btnLightBlue' value='Modify assignment information'>");
                            writer.println("</form>");  
                            
                            writer.println("<div class=\"itom\">");
              
                            writer.println("<form method='post' action = 'ProfAssignments' onSubmit=\"return confirm('Do you want to delete the assignment?')\" ;>");
                            writer.println("<input type='hidden' name='" + rst.getString(7) + "' value='" + rst.getString(7) + "'>");
                            writer.println("<input type='hidden' name='" + rst.getString(8) + "' value='" + rst.getString(8)  + "'>");
                            writer.println("<input type='hidden' name='assId' value='" + asId + "'>");
                            writer.println("<input type='hidden' name='delete' value='" + asId + "'>");
                            writer.println("<input type='hidden' name='username' value='" + username + "'>");
                            writer.println("<input type='Submit' class='button btnPush btnLightBlue' value='Delete Assignment'>");
                            writer.println("</form>");
                            writer.println("</div>"); 
                           
                            writer.println("</div>"); 
                            writer.println("</div>"); 
                            writer.println("</div>"); 
                            writer.println("</div>"); 
                            query = "SELECT S.firstName, S.lastName, S.userID \n" +
                            "FROM Student AS S INNER JOIN Enroll AS E ON E.studentID = S.userID "
                                    + "NATURAL JOIN section " 
                            +" WHERE moduleName = '" + request.getParameter("course") + "' AND sectionNumber = " + request.getParameter("section") + 
                                    " AND year = date_part('year', CURRENT_DATE)\n" +
                            "        AND (((EXTRACT(MONTH FROM CURRENT_DATE) BETWEEN 09 AND 12) AND trimester = 'FA')\n" +
                            "        OR ((EXTRACT(MONTH FROM CURRENT_DATE) BETWEEN 01 AND 05) AND trimester = 'SP')\n" +
                            "        OR ((EXTRACT(MONTH FROM CURRENT_DATE) BETWEEN 06 AND 08) AND trimester = 'SU'))"
                                    +";";
                            
                            Statement stmt2= conn.createStatement();
                            ResultSet r2 = stmt2.executeQuery(query);
                            if(r2.next()) {
                                flag=1;
                                writer.println("<button onclick=\"myFunction2()\">Students' grades<i class=\"fa fa-angle-double-down\"></i></button>");
                                writer.println("<div id=\"myDIV2\">");
                                writer.println("<table id=\"customers\">"); 
                                writer.println("<tr><th>Last Name:</th><th>First Name:</th><th>Grade:</th><th>Feedback:</th><tr><br>");
                                
                                query = "SELECT DISTINCT(S.userID), Su.answer, S.lastName, S.firstName, grade, feedback, A.assignmentID \n" +
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
                                " AND A.assignmentId = "+ asId + ";\n" ;
                                
                                   writer.println("<div class=\"grid\">");
                            writer.println("<div class=\"itom\">");
                                writer.println("<form method='post' action='ProfAsgInfo'>");
                                writer.println("<input type='hidden' name='"+ asId +"' value='" + asId + "'>");
                                writer.println("<input type='hidden' name='username' value='" + username + "'>");
                                writer.println("<input type='hidden' name='course' value='" + request.getParameter("course") + "'>");
                                writer.println("<input type='hidden' name='section' value='" + request.getParameter("section") + "'>");
                                writer.println("<input type='Submit' name='below' class='button btnPush btnLightBlue' value='Display grades below average'>");
                                writer.println("</form>");  
                                 writer.println("</div>");
                                
                                   writer.println("<div class=\"itom\">");
                                writer.println("<form method='post' action='ProfAsgInfo'>");
                                writer.println("<input type='hidden' name='"+ asId +"' value='" + asId + "'>");
                                writer.println("<input type='hidden' name='username' value='" + username + "'>");
                                writer.println("<input type='hidden' name='course' value='" + request.getParameter("course") + "'>");
                                writer.println("<input type='hidden' name='section' value='" + request.getParameter("section") + "'>");
                                writer.println("<input type='Submit' name='above' class='button btnPush btnLightBlue' value='Display grades above average'>");
                                writer.println("</form>");  
                                writer.println("</div>");
                              writer.println("<div class=\"itom\">");
                                writer.println("<form method='post' action='ProfAsgInfo'>");
                                writer.println("<input type='hidden' name='"+ asId +"' value='" + asId + "'>");
                                writer.println("<input type='hidden' name='username' value='" + username + "'>");
                                writer.println("<input type='hidden' name='course' value='" + request.getParameter("course") + "'>");
                                writer.println("<input type='hidden' name='section' value='" + request.getParameter("section") + "'>");
                                writer.println("<input type='Submit' name='normal' class='button btnPush btnLightBlue' value='Display grades of all students'>");
                                writer.println("</form>");
                                writer.println("</div>");
                                 writer.println("</div>");
                                ResultSet r3;
                                
                                Statement stmt3= conn.createStatement();
                               
                                
                                if (request.getParameter("above")!=null) {
                                    query = "SELECT studentID, answer, lastname, firstname, submisssiongrade, feedback FROM fetchgradesAboveAvg("+ asId +"::smallint,"+ request.getParameter("section") + "::smallint,\n" +
"					'" + request.getParameter("course") + "'::varchar(20));";
                                    
                                }
                                else if (request.getParameter("below")!=null) {
                                    query = "SELECT studentID, answer, lastname, firstname, submisssiongrade, feedback FROM fetchgradesbellowAvg("+ asId +"::smallint,"+ request.getParameter("section") + "::smallint,\n" +
"					'" + request.getParameter("course") + "'::varchar(20));";
                                }
                                
                                
                                else if (request.getParameter("normal")!=null){
                                    query = "SELECT DISTINCT(S.userID), Su.answer, S.lastName, S.firstName, grade, feedback, A.assignmentID \n" +
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
                                " AND A.assignmentId = "+ asId + ";\n" ;
                                }
                                
                                r3 = stmt3.executeQuery(query);
                                if(r3.next()) {
                                    
                                    flag=1;
                                    if(r3.getString(5)==null) 
                                        four="--";
                                     else if (r3.getString(5)!=null)
                                       four = r3.getString(5);
                                    
                                    if(r3.getString(6)==null) 
                                        five = "--";
                                    else if (r3.getString(6)!=null)
                                       five=r3.getString(6);
                                    
                                   
                                    
                                    writer.println("<form method='post' action='Gradeandfeed'>");
                                    writer.println("<input type='hidden' placeholder='username2' name='" + r3.getString(1) + "' value = '" + r3.getString(1) + "'>");
                                    writer.println("<input type='hidden' placeholder='username' name= 'username' value = '" + username + "'>");
                                    writer.println("<input type='hidden' placeholder='course' name='assId' value = '" + asId + "'>");
                                    writer.println("<input type='hidden' placeholder='section' name='section' value = '" + request.getParameter("section") + "'>");
                                    writer.println("<input type='hidden' placeholder='assId' name='course' value = '" + request.getParameter("course") + "'> ");
     
                                    
                                    writer.println("<tr><td> <input type='submit' value = '" + r3.getString(3) + "'></td><td>" + r3.getString(4) + "</td>"
                                        + "<td>" + four + "</td><td>" + five + "</td></tr>");
                                     
                                    
                                    writer.println("</form>");
                                    
                                    
                                    while(r3.next()) {
                                    if(r3.getString(5)==null) 
                                        four="--";
                                    else if (r3.getString(5)!=null)
                                       four = r3.getString(5);
                                    
                                    if(r3.getString(6)==null) 
                                        five = "--";
                                    else if (r3.getString(6)!=null)
                                       five=r3.getString(6);
                                    
                                    writer.println("<form method='post' action='Gradeandfeed'>");
                                    writer.println("<input type='hidden' placeholder='username2' name='" + r3.getString(1) + "' value = '" + r3.getString(1) + "'>");
                                    writer.println("<input type='hidden' placeholder='assId' name='assId' value = '" + asId + "'>");
                                    writer.println("<input type='hidden' placeholder='section' name='section' value = '" + request.getParameter("section") + "'>");
                                    writer.println("<input type='hidden' placeholder='course' name='course' value = '" + request.getParameter("course") + "'> ");
                                    writer.println("<input type='hidden' placeholder='username' name= 'username' value = '" + username + "'>");

                                        writer.println("<tr><td> <input type='submit' value = '" + r3.getString(3) + "'></td><td>" + r3.getString(4) + "</td>"
                                            + "<td>" + four + "</td><td>" + five + "</td></tr>");
                                     
                                    
                                    
                                    writer.println("</form>");
                                    }
                                    }
                                    writer.println("</table>"); 
                             writer.println("</div>"); 
                                }
                            
                                
                            }
                           
                           
                            
                        }
                    if(flag==0)
                                writer.println("<h class=\"err\">No students currently enrolled!</h>");
                        
                       
                    }
                    
                }
            
        }catch (Exception e) {
        //e.printStackTrace();
        writer.println("Exception caught");
        writer.println(e.toString());
        }
    }
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



    
