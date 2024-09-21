package com.example;

import jakarta.servlet.*;

import java.io.IOException;
import java.io.PrintWriter;

public class ServletConfigDemo implements Servlet {

    ServletConfig config;

    @Override
    public void init(ServletConfig config) throws ServletException {
        this.config = config;
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {

        String servletName = config.getServletName();
        String nameParameter = config.getInitParameter("name");
        String topicParameter = config.getInitParameter("topic");

        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>ServletConfigDemo</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Servlet Name : "+servletName+"</h1>");
        out.println("<h1>Name =  "+nameParameter+"</h1>");
        out.println("<h1>topic =  "+topicParameter+"</h1>");
        out.println("</body>");
        out.println("</html>");
        out.close();
    }

    @Override
    public String getServletInfo() {
        return "";
    }

    @Override
    public void destroy() {

    }
}
