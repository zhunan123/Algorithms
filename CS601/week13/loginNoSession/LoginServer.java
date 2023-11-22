package cs601.week13.loginNoSession;

import cs601.week13.register.RegistrationServlet;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHandler;

public class LoginServer {

  public static final int PORT = 8084;

  public static void main(String[] args) throws Exception {
    DatabaseHandler dhandler = DatabaseHandler.getInstance();
    //dhandler.createTable();

    Server server = new Server(PORT);
    ServletHandler handler = new ServletHandler();
    handler.addServletWithMapping(RegistrationServlet.class, "/register");
    handler.addServletWithMapping(LoginServlet.class, "/login");

    server.setHandler(handler);
    server.start();
    server.join();
  }
}
