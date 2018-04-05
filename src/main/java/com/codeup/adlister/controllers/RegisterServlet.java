package com.codeup.adlister.controllers;

import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.RegisterServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    // TODO: show the registration form
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") != null) {
            response.sendRedirect("/login");
            return;
        }
        request.getRequestDispatcher("/WEB-INF/users/register.jsp").forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
            // TODO: ensure the submitted information is valid
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String email = request.getParameter("email");

            boolean validAttempt = false;

            if (validAttempt) {
                // TODO: store the logged in user object in the session, instead of just the username
                // TODO: create a new user based off of the submitted information
                User user = new User();
                response.sendRedirect("/profile");
            }

        // TODO: if a user was successfully created, send them to their profile
    }
}


