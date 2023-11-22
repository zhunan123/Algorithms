package cs601.week13.javascript.ajax;

import org.apache.velocity.app.VelocityEngine;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;

// Ajax example. Example modified from Prof. Rollins' example.
public class BookServer {

	public static void main(String[] args) {
		Server server = new Server(8080);
		ServletContextHandler handler = new ServletContextHandler(ServletContextHandler.SESSIONS);
		handler.addServlet(BookServlet.class, "/books");

		VelocityEngine velocity = new VelocityEngine();
		velocity.init();
		handler.setAttribute("templateEngine", velocity);

		ResourceHandler resourceHandler = new ResourceHandler(); // a handler for serving static pages
		resourceHandler.setDirectoriesListed(true);
		resourceHandler.setResourceBase("static");

		HandlerList handlers = new HandlerList();
		handlers.setHandlers(new Handler[] { resourceHandler, handler });
		server.setHandler(handlers);

		try {
			server.start();
			server.join();
		} catch (Exception e) {
			System.out.println("Exception occurred while running the server: " + e);
		}

	}

}
