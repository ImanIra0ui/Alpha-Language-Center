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
@WebServlet(name = "changepass", urlPatterns = {"/changepass"})
public class changepass extends HttpServlet {
    String username;
    int i;
    String pass;
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
<<<<<<< HEAD
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
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet changepass</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet changepass at " + request.getContextPath() + "</h1>");
>>>>>>> first
            out.println("</body>");
            out.println("</html>");
        }
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        username = request.getParameter("username");
        i = Integer.parseInt(username);
        pass = request.getParameter("password");
 
        // do some processing here...
         
        // get response writer
        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println("<head>");
<<<<<<< HEAD
      writer.println("<link rel=\"stylesheet\" href=\"choice.css\">\n");
         writer.println(" <link rel=\"shortcut icon\" type=\"image/x-icon\" href=\"logo.PNG\" >\n");
        writer.append("<link href=\"https://fonts.googleapis.com/css2?family=Courgette&display=swap\" rel=\"stylesheet\">\n" +"");
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
        
                    if(request.getParameter("student")!=null) {
             
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
                    }
                    else {
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
                 
                    }
=======
        writer.println("</head>");
        writer.println("<body>");
>>>>>>> first
       
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
                    String query = "UPDATE  Account"
                            + " SET password = '" + pass + "'"+
                            " WHERE userID = " + i + ";";
                    int rst = stmt.executeUpdate(query);
                    
                    query = "SELECT firstName, lastName, email, phone "
                            + "FROM Users WHERE userId = " + i + ";";
                    Statement  st  = conn.createStatement();
                    ResultSet r = st.executeQuery(query);
                    
                    if(r.next()) 
<<<<<<< HEAD
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
                        writer.println("<label class=\"cap\">password :\n" +
                        "  <input name=\"password\" id=\"password\" type=\"password\" required>\n" +
                        "</label>\n" +
                        "<br><br>\n" +
                        "<label class=\"cap\">confirm password:\n" +
                        "  <input type=\"password\" name=\"confirm_password\" id=\"confirm_password\" required>\n" +
                        "  <span id='message'></span>"
                                                        + "<script src=\"pass.js\"></script>\n" +
                        "</label>");
                        writer.println("<input type='hidden' placeholder='username' name='username' value = " + username + ">");  
                        writer.println("<br><br>");
                        writer.println("<input type='submit' class='button btnPush btnLightBlue smtg' value = 'Submit changes'>");
                        writer.println("</form>");
                        writer.println("</div>");
                        writer.println("</div>");
=======
                        writer.println("First Name: " + r.getString(1));
                        writer.println("Last Name: " + r.getString(2));
                        
                        writer.println("Email: " + r.getString(3));
                        if(r.getString(4)!=null)
                            writer.println("Phone number: "+ r.getString(4));
                        
                        else
                            writer.println("Phone number: --");
                        writer.println("Change password: ");
                    writer.println("<form method='post' action='changepass' onsubmit=\"alert ('Password changed successfully!');\">");
                        writer.println("<label>password :\n" +
"  <input name=\"password\" id=\"password\" type=\"password\" required>\n" +
"</label>\n" +
"<br>\n" +
"<label>confirm password:\n" +
"  <input type=\"password\" name=\"confirm_password\" id=\"confirm_password\" required>\n" +
"  <span id='message'></span>"
                                + "<script src=\"pass.js\"></script>\n" +
"</label>");
                        writer.println("<input type='hidden' placeholder='username' name='username' value = " + username + ">");
                        writer.println("<input type='submit' value = 'Submit changes'>");
                        writer.println("</form>");
>>>>>>> first

                }
            }
        }catch (Exception e) {
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