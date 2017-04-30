/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Conexion.mySql;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author JUAN
 */
public class Mostrar extends HttpServlet {

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
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            mySql Consulta = new mySql();
            ResultSet rs;
            if (request.getMethod().equals("POST")) {
                rs = Consulta.mostrar_datos(request.getParameter("usuario"));

                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet Mostrar usuario</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Servlet Mostrar usuario</h1>");
                out.println("<p>El nombre ingresado es: " + request.getParameter("usuario") + "</p>");
                while (rs.next()) {
                    out.println("<p>EL ID ES: " + rs.getInt("ID_PERSONA") + "</p>");
                    out.println("<p>EL NOMBRE ES: " + rs.getString("NOMBRE") + "</p>");
                    out.println("<p>EL CORREO ES: " + rs.getString("CORREO") + "</p>");
                    out.println("<p>LA DIRECCIÓN ES: " + rs.getString("DIRECCION") + "</p>");
                    out.println("<p>EL TELÉFONO ES: " + rs.getString("TELEFONO") + "</p>");
                }
                out.println("</body>");
                out.println("</html>");
            }
           
            if (request.getMethod().equals("GET")) {
                rs= Consulta.mostrar_todos();
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet Mostrar usuario</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Lista de todos las Personas</h1>");
                
                out.println("<table border='1'>"
                        + "<thead>"
                        + "<tr>"
                        + "<th>ID</th>"
                        + "<th>NOMBRE</th>"
                        + "<th>CORREO</th>"
                        + "<th>DIRECCIÓN</th>"
                        + "<th>TELÉFONO</th>"
                        + "<th>PAÍS</th>"
                        + "<th>SEXO</th>"
                        + "<tr>"
                        + "<thead>"
                        + "<tbody>");
                while (rs.next())
                {
                    out.println("<tr><td>"+rs.getInt("ID_PERSONA")+"</td>"
                    + "<td>" + rs.getString("NOMBRE")+"</td>"
                    + "<td>" + rs.getString("CORREO")+"</td>"
                    + "<td>" + rs.getString("DIRECCION")+"</td>"
                    + "<td>" + rs.getString("TELEFONO")+"</td>"
                    + "<td>" + rs.getString("PAIS")+"</td>"
                    + "<td>" + rs.getString("SEXO")+"</td>"
                    + "</tr>");
                }
                
                out.println("</tbody>\n"
                + "</table>");
                
                out.println("</body>");
                out.println("</html>");             
            }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Mostrar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Mostrar.class.getName()).log(Level.SEVERE, null, ex);
        }
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
