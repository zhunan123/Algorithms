package week11.servletContinue;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;

public class SessionServer {
    public final static int PORT = 8081;

    public static void main(String[] args) {
        Server server = new Server(PORT);

        ServletContextHandler servHandler = new ServletContextHandler(ServletContextHandler.SESSIONS);
        servHandler.addServlet(SessionServlet.class, "/session");
        server.setHandler(servHandler);

        try {
            server.start();
            server.join();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
