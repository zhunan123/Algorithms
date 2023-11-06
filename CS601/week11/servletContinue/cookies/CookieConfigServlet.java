package week11.servletContinue.cookies;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class CookieConfigServlet extends CookieBaseServlet{

    @Override
    protected void doGet(
        HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        prepareResponseHeader("Configure", response); // this has html head, and body stuff

        PrintWriter out = response.getWriter();
        out.println("<p>To clear saved cookies, please press \"Clear\".</p>");
        out.println();

        out.println("<form method=\"post\" action=\"" + request.getRequestURI() + " \">");
        out.println("\t<input type=\"submit\" value=\"Clear\">");
        out.println("</form>");

        // finish response part
        finishResponse(request, response);

        out.flush();

        response.setStatus(HttpServletResponse.SC_OK);
        response.flushBuffer();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        // clear all cookie if user press clear cookie button
        clearCookies(request, response);

        prepareResponseHeader("Configure", response);

        PrintWriter out = response.getWriter();
        out.printf("<p>Your cookies for this site have been cleared.</p>%n%n");

        // finish response part
        out.println("");
        out.println("</body>");
        out.println("</html>");

        out.flush();

        response.setStatus(HttpServletResponse.SC_OK);
        response.flushBuffer();
    }
}
