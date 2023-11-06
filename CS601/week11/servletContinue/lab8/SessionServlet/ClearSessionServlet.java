package week11.servletContinue.lab8.SessionServlet;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

/** A servlet that processes the get request coming to the "/clear"
 * endpoint. Clears the "username" cookie.
 */
@SuppressWarnings("serial")
public class ClearSessionServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Clear the "username" cookie
//		clearCookies(request, response);

		HttpSession session = request.getSession();
		session.removeAttribute("USER_NAME");

		// Output to the response that the cookie has been cleared
		PrintWriter out = response.getWriter();
		out.println("<p>Cookie has been cleared</>");
	}

}