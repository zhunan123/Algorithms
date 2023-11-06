package week11.servletContinue.lab8.cookieServletPractice;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHandler;

/**  The webserver that should behave as following:
 *   When it receives the request to /greet, it will check if there is a "username"
 *   cookie for this client; If yes, it will get the username from the value of the cookie and display
 *   Welcome, username!
 *   If there is no cookie with the name "username", it should show the form that asks
 *   the user to enter the name. Then it saves it in the "username" cookie and redirects to /greet.
 *
 *   When the webserver receives the request to /clear, it should clear the "username" cookie.
 */
public class GreetingServer {

	public static final int PORT = 8080;

	public static void main(String[] args) throws Exception {
		Server server = new Server(PORT);
		ServletHandler handler = new ServletHandler();
		// FILL IN CODE:
		// Use the handler to map "/greet" to GreetingServlet
		// Use the handler to map "/clear" to ClearCookieServlet
		handler.addServletWithMapping(GreetingServlet.class, "/greet"); // store user information using cookie
		handler.addServletWithMapping(ClearCookieServlet.class, "/clear");


		server.setHandler(handler);
		server.start();
		server.join();
	}
}