package week12.velocityAndTemplate.velocity;

import org.apache.velocity.app.VelocityEngine;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;

public class HotelServer {

    public static final int PORT = 8080;

    public static void main(String[] args)  {
        Server server = new Server(PORT);
        ServletContextHandler handler = new ServletContextHandler(ServletContextHandler.SESSIONS);
        handler.addServlet(HotelServlet.class, "/hotels");

        // initialize Velocity
        VelocityEngine velocity = new VelocityEngine();
        velocity.init();

        // Set velocity as an attribute of the context so that we can access it from servlets
        // initialize velocity and name it templateEngine in contextHandler and pass
        // it from this velocity object from server to servlet
        handler.setAttribute("templateEngine", velocity);
        server.setHandler(handler);

        try {
            server.start();
            server.join();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
