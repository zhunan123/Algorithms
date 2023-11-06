package week11.servletContinue.cookies;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

/**
 * Demonstrates how to create, use, and clear cookies. Vulnerable to attack
 * since cookie values are not sanitized prior to use!
 *
 * @see CookieBaseServlet
 * @see CookieVisitsServlet
 * @see CookieConfigServlet
 */
@SuppressWarnings("serial")
public class CookieVisitsServlet extends CookieBaseServlet {

    public static final String VISIT_DATE = "Visited";
    public static final String VISIT_COUNT = "Count";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/*if (request.getRequestURI().endsWith("favicon.ico")) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return;
		} */

        prepareResponseHeader("CookieServer", response);

        // add cookies which send attached in client web request to cookie array, then add each cookie to cookie map
        Map<String, String> cookies = addCookieValueToCookieMap(request);

        // get cookie from cookie map
        String visitDate = cookies.get(VISIT_DATE);
        String visitCount = cookies.get(VISIT_COUNT);

        PrintWriter out = response.getWriter();
        out.printf("<p>");

        // if no date and count cookie return it's first visit, but after you first visit will have date not null,
        // so can increment count cookie in this case
        if ((visitDate == null) || (visitCount == null)) {
            visitCount = "0";

            out.println("You have never been to this webpage before! ");
            out.println("Thank you for visiting.");
        } else {
            // if visited this website before. so we should have this cookie named Visited
            // and increment the count
            visitCount = Integer.toString(Integer.parseInt(visitCount) + 1);

            out.println("You have visited this website " + visitCount + " times.");
            out.printf("Your last visit was on " + visitDate);
        }

        out.println("</p>");

        // Checks if the browser indicates visits should not be tracked. DNT is do not track,
        //  1 means the user do not wish to be tracked, != 1 means user can be tracked
        // Try this in Safari private browsing mode.
        if (request.getIntHeader("DNT") != 1) {
//			System.out.println("cookie: " + getDate());
            response.addCookie(new Cookie("Visited", getDate())); // crete visited date cookie and add visited cookie with current date to cookie
            response.addCookie(new Cookie("Count", visitCount)); // create count cookie add count cookie to cookie
        } else {
            // if user do not wish to be tracked, clear all cookie
            clearCookies(request, response);
            out.printf("<p>Your visits will not be tracked.</p>");
        }

        // finish response part
        finishResponse(request, response);
    }
}
