package com.javacodegeeks.example;
 
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.servlet.ServletHandler;
 
public class EmbeddedJettyExample {
 
    public static void main(String[] args) throws Exception {
         
        Server server = new Server(8680);       
         
        ServletHandler servletHandler = new ServletHandler();
        server.setHandler(servletHandler);
                 
        servletHandler.addServletWithMapping(HelloServlet.class, "/");
         
        server.start();
        server.join();
 
    }
     
    public static class HelloServlet extends HttpServlet 
    {

        Map<String,String> data = getData();

        

        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
        {
            String username = request.getParameter("username");
            response.setContentType("text/html");
            response.setStatus(HttpServletResponse.SC_OK);
            response.getWriter().println("<html>");
            response.getWriter().println("<head>");
            response.getWriter().println("<title>MyFirstServlet</title>");
            response.getWriter().println("</head>");
            response.getWriter().println("<body>");
            response.getWriter().println("<h2>Hello " + username + ", " + data.get("message") + "</h2>");
            response.getWriter().println("<h2>The time right now is : Pickle</h2>");
            response.getWriter().println("<img src='https://pbs.twimg.com/media/DsjY1NmX4AAEYqJ.png'></img>");
            response.getWriter().println("</body>");
            response.getWriter().println("</html>");
             
        } 

        private Map<String, String> getData() 
        {
            Map<String, String> data = new HashMap<String, String>();
            data.put("username", "Guest");
            data.put("message",  "Welcome to my world !!");
            return data;
        }
    }
 }