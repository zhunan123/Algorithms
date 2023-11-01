package week11.servletContinue;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class HelloServer {

    public static final int PORT = 8081;

    public static void main(String[] args) throws Exception {
        Server server = new Server(PORT);
        ServletHandler handler = new ServletHandler();

         //handler.addServletWithMapping(HelloServlet.class, "/hello");
        handler.addServletWithMapping(new ServletHolder(new HelloServlet()), "/hello");
        server.setHandler(handler);

        server.start();
        server.join();
    }
}
