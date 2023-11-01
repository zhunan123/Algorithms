package week11.servletContinue;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class EchoServer {

    public static final int PORT = 8082;

    public static void main(String[] args) throws Exception {
        Server server = new Server(PORT);

        ServletHandler handler = new ServletHandler();
        handler.addServletWithMapping(new ServletHolder(new EchoServlet()), "/echo");

        server.setHandler(handler);

        server.start();
        server.join();
    }
}
