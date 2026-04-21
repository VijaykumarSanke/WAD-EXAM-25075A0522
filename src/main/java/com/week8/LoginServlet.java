package com.week8;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");

        HttpSession session = request.getSession();
        session.setAttribute("user", username);

        Cookie userCookie = new Cookie("username", username);
        userCookie.setMaxAge(3600); // 1 hour
        response.addCookie(userCookie);

        session.setAttribute("lastAction", "Logged in successfully");

        response.getWriter().println("Welcome, " + username);
        response.getWriter().println("<br>Session + Cookie created");
        response.getWriter().println("<br><a href='ProfileServlet'>Go to Profile</a>");
    }
}
