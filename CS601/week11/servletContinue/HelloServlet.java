package week11.servletContinue;

import org.apache.commons.text.StringEscapeUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        response.setContentType("text/html");
        response.setStatus(HttpServletResponse.SC_OK);

        PrintWriter out = response.getWriter();
        String name = request.getParameter("name");
        if (name == null || name.isEmpty())
            name = "anonymous";


        name = StringEscapeUtils.escapeHtml4(name); // need to "clean up" whatever, make more secure
        /*
        Hello, <script>window.open("http://www.usfca.edu/");</script>!
        * */


        out.println("<html>");
        out.println("<body>");
        out.println("<h1>Hello, " + name + "!</h1>");
        out.println("</body>");
        out.println("</html>");


        // If we did not call escapeHtml4,
        // if we just used the name (we read from the user) in our response,
        // our site would be prone to cross-site scripting attacks (XSS attacks)

        // You can comment out this line: name = StringEscapeUtils.escapeHtml4(name);
        // and uncomment the line below to disable security feature in the browser
//        response.setIntHeader("X-XSS-Protection", 0);
        // Then in the browser, try specifying the text below instead of the name:
        // ?name=<script>window.open("http://www.usfca.edu/");</script>
        // Did you see what happened? This script opened another page with usfca.edu website!

    }
}
