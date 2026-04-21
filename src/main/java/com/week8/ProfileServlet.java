package com.week8;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/ProfileServlet")
public class ProfileServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        if (session != null && session.getAttribute("user") != null) {

            String username = (String) session.getAttribute("user");
            String action = (String) session.getAttribute("lastAction");

            Cookie[] cookies = request.getCookies();
            String cookieUser = "Not found";

            if (cookies != null) {
                for (Cookie c : cookies) {
                    if (c.getName().equals("username")) {
                        cookieUser = c.getValue();
                    }
                }
            }

            response.getWriter().println("Session User: " + username);
            response.getWriter().println("<br>Cookie User: " + cookieUser);
            response.getWriter().println("<br>Last Action: " + action);

        } else {
            response.getWriter().println("Please login first.");
        }
    }
}
