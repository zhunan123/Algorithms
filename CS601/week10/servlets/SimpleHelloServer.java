package week10.servlets;


import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHandler;


public class SimpleHelloServer {

    public static final int PORT = 8081;

    public static void main(String[] args) throws Exception {
        Server server = new Server(PORT); //create jetty server

        ServletHandler handler = new ServletHandler(); // how each endpoint will be connected to each individual servlets

        // when the user goes to http://localhost:8081/welcome, the get request is
        // going to go to a SimpleHelloServlet
//        handler.addServletWithMapping(SimpleHelloServlet.class, "/welcome"); // map endpoint to simple hello servlets
        handler.addServletWithMapping(WelcomeServlet.class, "/welcome"); // map endpoint to welcome servlet
        /**
         * http://localhost:8081/welcome?name=zhunan
         * ---> Hello, zhunan
         * */


        server.setHandler(handler);

        server.start();
        server.join();
    }
}
