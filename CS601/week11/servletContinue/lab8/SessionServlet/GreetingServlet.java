package week11.servletContinue.lab8.SessionServlet;

import org.apache.commons.text.StringEscapeUtils;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;


/** An example that demonstrates how to process HTML forms with servlets.
 */
@SuppressWarnings("serial")
public class GreetingServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println();
		response.setContentType("text/html");
		response.setStatus(HttpServletResponse.SC_OK);
		PrintWriter out = response.getWriter();
		String username = null;

		// FILL IN CODE:
		// Is there a cookie with the name "username"?
		// If yes, get the value of this cookie and show
		// Welcome, username!

		// check if this website is already visited which means it has the username cookie inserted already
		// if it has username cookie means it already visited
//		Cookie[] cookies = request.getCookies();

		// use session to get and set cookie
		HttpSession session = request.getSession();
		username = (String) session.getAttribute("USER_NAME");

		// If no such cookie exists, show the html form that allows the user to enter their name
		// FILL IN CODE:
		// Add the method and action attributes to the form below
		// When the form is submitted, GreetingServlet's doPost method should be invoked


		if (username != null) { //if exist username cookie
			out.println("<p>Welcome, " + username + "</p>");
		} else { //if not exist username cookie
			out.println("<form method=\"post\" action=\" "+ request.getServletPath() + "\" >");
			out.println("Enter name:<input type=\"text\" name=\"username\" ><br>");
			out.println("<p><input type=\"submit\" ></p>");
			out.println("</form>");
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		HttpSession session = request.getSession();

		// This method should be called when the user submits the form with the name.
		// Extract the name parameter from the request, clean it,
		// create a "username" cookie with this name, and add it to the response

		// this username is what user enters from the web browser (user entered in doGet()) and we get it from parameter here
		String username = request.getParameter("username");
		if (username == null || username.equals("")) {
			username = "anonymous";
		}

		// add cookie to this website when user first visit indicate the website is visited
		// and next time a user visit this site will have this cookie inserted already
		username = StringEscapeUtils.escapeHtml4(username);
		session.setAttribute("date", username);

		// redirect to the same servlet using the sendRedirect method.
		response.setStatus(HttpServletResponse.SC_OK);
		response.sendRedirect(request.getServletPath());

	}

}