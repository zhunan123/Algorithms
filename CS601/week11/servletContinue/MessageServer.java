package week11.servletContinue;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHandler;

public class MessageServer {

    public static final int PORT = 8091;

    public static void main(String[] args) throws Exception {
        Server server = new Server(PORT);

        ServletHandler handler = new ServletHandler();
        handler.addServletWithMapping(MessageServlet.class, "/messageBoard");
        server.setHandler(handler);
        server.start();
        server.join();
    }
}
