package week11.servletContinue;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;

public class SessionServer {
    /**
     both session and cookie is storing/remembering some information from visitor last visits
     you can receive information from last cookie from last visit
     or from last visit session
     retrieve date and count from last visit if same user visited before

     so the purpose for session is remembered information from last visit to this website from same user

     so every time you visit this website, this website will remember how many times the count you have visited
     this website, and the date your last visit if there is a last visit.
     * */
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
