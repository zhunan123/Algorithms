package week11.servletContinue.lab8.cookieServletPractice;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/** A servlet that processes the get request coming to the "/clear"
 * endpoint. Clears the "username" cookie.
 */
@SuppressWarnings("serial")
public class ClearCookieServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// FILL IN CODE
		// Clear the "username" cookie
		clearCookies(request, response);

		// Output to the response that the cookie has been cleared
		PrintWriter out = response.getWriter();
		out.println("<p>Cookie has been cleared</>");
	}

	public void clearCookies(HttpServletRequest request, HttpServletResponse response) {
		// clear cookie named USER_NAME with this browser
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("USER_NAME")){
					cookie.setValue(null);
					cookie.setMaxAge(0);
					response.addCookie(cookie);
				}
			}
		}
	}
}