/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlet;

import dao.AdminDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.VolModel;

/**
 *
 * @author Hery
 */
public class AjoutVolSevlet extends HttpServlet {

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
            String depart = request.getParameter("depart");
            String arrive = request.getParameter("arrive");
            String date = request.getParameter("date");
            int prix = Integer.parseInt(request.getParameter("prix"));
            int nb = Integer.parseInt(request.getParameter("nb"));
            String nom_comp = request.getParameter("companie");
            String hdep = request.getParameter("heuredep");
            String duree = request.getParameter("duree");
            VolModel vol = new VolModel();
            vol.setDate_vol(date);
            vol.setDepart(depart);
            vol.setPrix(prix);
            vol.setNom_comp(nom_comp);
            vol.setNb_billet(nb);
            vol.setDestination(arrive);
            vol.setDuree_vol(duree);
            vol.setHeure_dep(hdep);
            AdminDao dao = new AdminDao();
            dao.ajoutVol(vol);
            request.getRequestDispatcher("Link?page=adminVol").forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(AjoutVolSevlet.class.getName()).log(Level.SEVERE, null, ex);
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
        processRequest(request, response);
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
