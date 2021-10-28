package ies;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
@WebServlet(name = "MyFirstServlet", urlPatterns = {"/MyFirstServlet"})
public class MyFirstServlet extends HttpServlet {
    private static final long serialVersionUID = -1915463532411657451L;
 
    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException 
    {
         
        Map<String,String> data = getData();

        String username = request.getParameter("username");
         
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            // Write some content
            out.println("<html>");
            out.println("<head>");
            out.println("<title>MyFirstServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h2>Hello " + username + ", " + data.get("message") + "</h2>");
            out.println("<h2>The time right now is : Pickle</h2>");
            out.println("<img src='https://pbs.twimg.com/media/DsjY1NmX4AAEYqJ.png'></img>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }
     
    //This method will access some external system as database to get user name, and his personalized message
    private Map<String, String> getData() 
    {
        Map<String, String> data = new HashMap<String, String>();
        data.put("username", "Guest");
        data.put("message",  "Welcome to my world !!");
        return data;
    }
}