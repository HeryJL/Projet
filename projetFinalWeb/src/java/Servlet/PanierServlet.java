/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlet;

import dao.CommandeDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import model.PanierModel;

/**
 *
 * @author Hery
 */
public class PanierServlet extends HttpServlet {

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
            String login = request.getParameter("login");
            String date_depart = request.getParameter("date_depart");
            int nb = Integer.parseInt(request.getParameter("nb"));
            String dur = request.getParameter("duree");
            int duree = 1;
            if (dur != null) {
                duree = Integer.parseInt(dur);
            }
            String h = request.getParameter("hotel");
            String v = request.getParameter("vol");
            CommandeDao dao = new CommandeDao();
            PanierModel panier = new PanierModel();
            panier.setDuree(duree);
            panier.setNb_pers(nb);
            panier.setNom_user(login);
            panier.setDate_depart(date_depart);
            int id_hotel;
            int id_vol;
            if (h != null) {
                id_hotel = Integer.parseInt(h);
                panier.setType_item("hotel");
                panier.setId_item(id_hotel);
                dao.ajoutPanier(panier);
            }
            if (v != null) {
                id_vol = Integer.parseInt(v);
                panier.setType_item("vol");
                panier.setId_item(id_vol);
                dao.ajoutPanier(panier);
            }

            request.getRequestDispatcher("Link?page=panier").forward(request, response);

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
