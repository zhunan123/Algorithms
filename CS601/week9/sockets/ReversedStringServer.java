package week9.sockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ReversedStringServer {

    public final static int PORT = 5534;

    public static void main(String[] args) throws IOException {
        Socket connectionSocket = null;
        try  {
            ServerSocket welcomingSocket = new ServerSocket(ReversedStringServer.PORT);
            System.out.println("Server started: waiting for connections on port " + ReversedStringServer.PORT);

            connectionSocket = welcomingSocket.accept();
            System.out.println("EchoServer: EchoClient connected.");

            PrintWriter out = new PrintWriter(connectionSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));

            String inputLine;
            while ((inputLine = in.readLine()) != null && (!inputLine.equals("EXIT"))) {
                String reversed = new StringBuffer(inputLine).reverse().toString();
                out.println(reversed);
                System.out.println("server: " + reversed);
            }
        } catch (IOException e) {
            System.out.println(
                "Exception caught when trying to listen on port " + ReversedStringServer.PORT + " or listening for a connection");
            System.out.println(e.getMessage());
        }
        finally {
            System.out.println("Bye!");
            if (connectionSocket != null)
                connectionSocket.close();
        }
    }
}
