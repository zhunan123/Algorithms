package cs601.week13.register;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHandler;

public class RegisterServer {
  public static final int PORT = 8084;

  public static void main(String[] args) throws Exception {
    DatabaseHandler dhandler = DatabaseHandler.getInstance();
    //dhandler.createTable();

    Server server = new Server(PORT);
    ServletHandler handler = new ServletHandler();
    handler.addServletWithMapping(RegistrationServlet.class, "/register");
    server.setHandler(handler);
    server.start();
    server.join();
  }
}
