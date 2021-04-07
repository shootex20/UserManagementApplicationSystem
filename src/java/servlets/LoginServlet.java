/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.Users;
import services.AccountService;

/**
 *
 * @author 813017
 */
@WebServlet(name = "LoginSevlet", urlPatterns = {"/LoginSevlet"})
public class LoginServlet extends HttpServlet {

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
//        HttpSession session = request.getSession();
//
//        if (session.getAttribute("email") != null) {
//            response.sendRedirect("home");
//            return;
//        }

        getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);

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
        
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        
        AccountService as = new AccountService();
        Users user = as.login(email, password);
        
        if (user == null) {
            request.setAttribute("loginmessage", "Please enter a username and password.");
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            return;
        }
        
        HttpSession session = request.getSession();
        //session.setAttribute("email", email);

        if (user.getIsAdmin() == true && user.getIsActive() == true) {
            response.sendRedirect("home");
        } else if(user.getIsActive() == true){
            response.sendRedirect("home");
        }
        else
        {
        request.setAttribute("loginmessage", "Account is either not active or invalid information has been given.");
        doGet(request, response);
        }
    }
}
