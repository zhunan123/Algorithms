package week11.servletContinue.lab8.servletPractice;

import org.apache.commons.text.StringEscapeUtils;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


/** An example that demonstrates how to process HTML forms with servlets.
 */
@SuppressWarnings("serial")
public class GreetingServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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
		// use request to get and set cookie
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("USER_NAME")) {
					username = cookie.getValue();
					break;
				}
			}
		}

		// If no such cookie exists, show the html form that allows the user to enter their name
		// FILL IN CODE:
		// Add the method and action attributes to the form below
		// When the form is submitted, GreetingServlet's doPost method should be invoked

		//if username cookie
		if (username != null) {
			out.println("<p>Welcome, " + username + "</p>");
		} else {
			out.println("<form method=\"post\" action=\" "+ request.getServletPath() + "\" >");
			out.println("Enter name:<input type=\"text\" name=\"username\" ><br>"); // change this input element to display the textfield with the username parameter
			out.println("<p><input type=\"submit\" ></p>"); // change the code to display a button
			out.println("</form>");
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

		// This method should be called when the user submits the form with the name.
		// Extract the name parameter from the request, clean it,
		// create a "username" cookie with this name, and add it to the response

		String username = request.getParameter("username");// this username is what user enters
		if (username == null || username.equals("")) {
			username = "anonymous";
		}

		// add cookie to this website when user first visit indicate the website is visited
		// and next time a user visite this site will have this cookie inserted already
		username = StringEscapeUtils.escapeHtml4(username);
		Cookie cookie = new Cookie("USER_NAME", username);// add above user entered username to cookie and add this username cookie to this website
		response.addCookie(cookie);

		// redirect to the same servlet using the sendRedirect method.
		response.setStatus(HttpServletResponse.SC_OK);
		response.sendRedirect(request.getServletPath());

	}

}