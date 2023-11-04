package week11.servletContinue.cookies;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHandler;

public class CookieServer {

    public final static int PORT = 8090;
    public static void main(String[] args) throws Exception {
        Server server = new Server(PORT);

        ServletHandler handler = new ServletHandler();
        handler.addServletWithMapping(CookieVisitsServlet.class, "/visits");
        handler.addServletWithMapping(CookieConfigServlet.class, "/config");

        server.setHandler(handler);
        server.start();
        server.join();
    }
}
