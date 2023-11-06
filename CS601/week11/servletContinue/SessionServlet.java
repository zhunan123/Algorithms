package week11.servletContinue;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Demonstrates how to use the HttpSession class to keep track of the number of visits for each client
 */

@SuppressWarnings("serial")
public class SessionServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        HttpSession session = request.getSession();

        // get session attribute but data and visitCount
        String visitDate = (String) session.getAttribute("date");
        Integer visitCount = (Integer) session.getAttribute("visitCount");

        if (visitCount == null){
            visitCount = 0;
        }
        visitCount = visitCount + 1;

        // add or update visitCount to session attribute
        session.setAttribute("visitCount", visitCount);

        PrintWriter out = response.getWriter();
        String title = "Session Servlet for Zhunan";
        String header = "<!DOCTYPE html\n>" + "	<head>\n" + "<title>" + title + "</title>\n" + "</head>\n";

        // session will remember visitCount
        String body = "	<body>\n" + "<p>Hello! You have visited " + visitCount + " time(s).</p>\n";
        if (visitDate != null) {
            // if user visited before
            body = body + "<p> Your last visit was on " + visitDate + "</p>\n";
        }

        body = body + "	</body>\n";
        String footer = "</html>";

        String page = header + body + footer;
        out.println(page);

        String format = "yyyy-MM-dd hh:mm a";
        DateFormat formatter = new SimpleDateFormat(format);
        visitDate = formatter.format(Calendar.getInstance().getTime());

        // if first visit, no last visit text from above will display since not set date session attribute yet,
        // if first visit,below will set date attribute to session
        // if not first visit, can also update date attribute to current Date to session
        session.setAttribute("date", visitDate);


        response.setStatus(HttpServletResponse.SC_OK);

    }

}
