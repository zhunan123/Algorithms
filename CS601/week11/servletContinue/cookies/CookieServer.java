package week11.servletContinue.cookies;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHandler;

public class CookieServer {
    /**
     use cookie to store information from same user last time visit website
     * */

    public final static int PORT = 8090;
    public static void main(String[] args) throws Exception {
        Server server = new Server(PORT);

        ServletHandler handler = new ServletHandler();

        // first you will see "You have never been to this webpage before! Thank you for visiting."
        // You have visited this website 8 times. Your last visit was on 2023-11-05
        handler.addServletWithMapping(CookieVisitsServlet.class, "/visits"); // add date cookie and count cookie to overall browser cookie

        // To clear saved cookies, please press "Clear".
        // Your cookies for this site have been cleared.
        handler.addServletWithMapping(CookieConfigServlet.class, "/config"); // give option to clear cookie
        // after clear cookie. you will see "You have never been to this webpage before! Thank you for visiting."

        server.setHandler(handler);
        server.start();
        server.join();
    }
}
