package week11.servletContinue;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHandler;
import week10.servlets.WelcomeServlet;

public class HtmlFormServer {
    public static final int PORT = 8083;

    public static void main(String[] args) throws Exception {
        Server server = new Server(PORT);

        ServletHandler handler = new ServletHandler();
        handler.addServletWithMapping(HtmlFormServlet.class, "/form");
        handler.addServletWithMapping(WelcomeServlet.class, "/welcome");
        server.setHandler(handler);
        server.start();
        server.join();
    }
}
