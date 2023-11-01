package week11.servletContinue;

import org.apache.commons.text.StringEscapeUtils;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class EchoServlet extends HttpServlet {

    /**
     first go to doGet(), fill up the form then submit the form
     then call doPost()
     * */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        //GET /echo

        response.setContentType("text/html");
        response.setStatus(HttpServletResponse.SC_OK);

        PrintWriter out = response.getWriter();
        out.println("<html><title>EchoServlet</title><body>");

        out.println("<form action=\"echo\" method=\"post\">");
        out.println("Message: <br/>");

        // notice that the message will be stored in the parameter "usermsg"
        out.println("<input type=\"text\" name=\"usermsg\"><br/>");

        out.println("<input type=\"submit\" value=\"Submit\"></form>");

        out.println("</body></html>");
    }

    /** The method that will process the form once it's submitted */
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        //POST /echo
        response.setContentType("text/html");
        response.setStatus(HttpServletResponse.SC_OK);

        PrintWriter out = response.getWriter();

        String msg = request.getParameter("usermsg");
        msg = StringEscapeUtils.escapeHtml4(msg); // clean up whatever the user typed


        out.println("<html><title>EchoServlet</title><body>You said: " + msg + "</body></html>");

    }
}
