package org.launchcode.examples;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by mmenne on 10/27/16.
 */

@WebServlet(name="newBookmarkServlet", urlPatterns = {"/servlet3"})
public class NewBookmarkServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        String simpleParam = getServletConfig().getInitParameter("simpleParam");
        out.println("<p>This servlet uses the Servlet 3.0 spec (released in 2012).  It replaces the web.xml with annotations." + simpleParam);
        out.close();
    }
}
