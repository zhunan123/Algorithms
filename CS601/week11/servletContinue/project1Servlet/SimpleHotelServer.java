package week11.servletContinue.project1Servlet;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHandler;

public class SimpleHotelServer {

    public static final int PORT = 8080;

    public static void main(String[] args) throws Exception {

        Server server = new Server(PORT);

        ServletHandler handler = new ServletHandler();

        handler.addServletWithMapping(SimpleHotelServlet.class, "/hotels");

        /**
         localhost:8080/hotels?id=10323
         {"10323":"hotelName = Hilton Garden Inn San Francisco/Oakland Bay Bridge\nhotelId = 10323\nlatitude = 37.837773\nlongitude = -122.298142\naddress = 1800 Powell Street, Emeryville, CA, USA"}
         * */

        server.setHandler(handler);

        server.start();
        server.join();
    }
}