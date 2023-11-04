package week11.servletContinue.cookies;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class CookieBaseServlet extends HttpServlet {

    /**
        * Prepares the HTTP response by setting the content type and adding header
        * HTML code.
     */
    public static void prepareResponse(String title, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE HTML>");
        out.println("<html><head>");
        out.println("\t<title>" + title + "</title>");
        out.println("<content=\"text/html;charset=utf-8\">");
        out.println("</head>");
        out.println("<body>");
    }

    /**
     * Gets the cookies form the HTTP request, and maps the cookie key to the
     * cookie value.
     * @return map from cookie key to cookie value
     */
    public Map<String, String> getCookieMap(HttpServletRequest request) {
        HashMap<String, String> map = new HashMap<>();
        Cookie[] cookies = request.getCookies();

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                map.put(cookie.getName(), cookie.getValue());
            }
        }
        return map;
    }

    /**
     * Clears all of the cookies included in the HTTP request.
     * @param response - HTTP response
     */
    public void clearCookies(HttpServletRequest request, HttpServletResponse response) {

        Cookie[] cookies = request.getCookies();

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                cookie.setValue(null);
                cookie.setMaxAge(0);
                response.addCookie(cookie);
            }
        }
    }

    /**
     * Returns the current date and time in a short format.
     * @return current date and time
     */
    public static String getDate() {
        String format = "yyyy-MM-dd"; //"yyyy-MM-dd hh:mm";
        DateFormat formatter = new SimpleDateFormat(format);
        return formatter.format(Calendar.getInstance().getTime());
    }
}
