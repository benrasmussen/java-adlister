package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "controllers.RegisterServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (request.getSession().getAttribute("user") != null) {
            response.sendRedirect("/profile");
            return;
        }

        request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String passwordConfirmation = request.getParameter("confirm_password");

        // validate input
        // create and save a new user


//    sets the checks for register form / add more features
        HttpSession session = request.getSession();

        if (password == null || password.trim() == "") {
            session.removeAttribute("password_error");
            session.removeAttribute("email_error");
            session.removeAttribute("username_error");
            session.removeAttribute("password_mismatch");
            session.setAttribute("password_error", "<p style=\"color:red\">Sorry \"password\" error!</p>");
            response.sendRedirect("/register");
        } else if (!password.equals(passwordConfirmation)) {
            session.removeAttribute("password_error");
            session.removeAttribute("email_error");
            session.removeAttribute("username_error");
            session.removeAttribute("password_mismatch");
            session.setAttribute("password_mismatch", "<p style=\"color:red\">Sorry \"passwords\" do not match!</p>");
            response.sendRedirect("/register");
        } else if (email == null || email.trim() == "") {
            session.removeAttribute("password_error");
            session.removeAttribute("email_error");
            session.removeAttribute("username_error");
            session.removeAttribute("password_mismatch");
            session.setAttribute("email_error", "<p style=\"color:red\">Sorry \"email\" error!</p>");
            response.sendRedirect("/register");
        } else if (username == null || username.trim() == "") {
            session.removeAttribute("password_error");
            session.removeAttribute("email_error");
            session.removeAttribute("username_error");
            session.removeAttribute("password_mismatch");
            session.setAttribute("username_error", "<p style=\"color:red\">Sorry \"username\" error!</p>");
            response.sendRedirect("/register");
        } else {
            session.removeAttribute("password_error");
            session.removeAttribute("password_mismatch");
            session.removeAttribute("email_error");
            session.removeAttribute("username_error");
            session.setAttribute("username", username);
            session.setAttribute("password", password);
            session.setAttribute("email", email);

            boolean inputHasErrors = username.isEmpty()
                    || email.isEmpty()
                    || password.isEmpty()
                    || (!password.equals(passwordConfirmation));

            if (inputHasErrors) {
                response.sendRedirect("/register");
                return;
            }

            User user = new User(username, email, password);
            DaoFactory.getUsersDao().insert(user);
            response.sendRedirect("/login");

        }
    }
}