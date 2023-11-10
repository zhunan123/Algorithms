package week11.servletContinue.lab8.SessionServlet;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;

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
	// use session to get

	public static final int PORT = 8080;

	public static void main(String[] args) throws Exception {
		Server server = new Server(PORT);
		ServletContextHandler handler = new ServletContextHandler(ServletContextHandler.SESSIONS);
		// FILL IN CODE:
		// Use the handler to map "/greet" to GreetingServlet
		// Use the handler to map "/clear" to ClearSessionServlet

		// maintain user session using session, not cookie
		handler.addServlet(GreetingServlet.class, "/greet"); // store user information with session
		handler.addServlet(ClearSessionServlet.class, "/clear");

		server.setHandler(handler);
		server.start();
		server.join();
	}
}