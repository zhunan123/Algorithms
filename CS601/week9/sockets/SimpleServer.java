package week9.sockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * SimpleServer ("Echo" Server). Opens a welcoming socket, listens for client
 * requests. Once the client asks to connect, creates a new "connection socket"
 * for the client. Reads messages from the client from the input stream. Prints
 * them to the console.
 *
 * Modified from the example of Prof. Engle.
 *
 */
public class SimpleServer extends Thread {
    public static final int PORT = 5556;
    public static final String EOT = "EOT";
    public static final String SHUTDOWN = "SHUTDOWN";

    private boolean alive; // whether the server is alive or shutdown

    public SimpleServer() {
        alive = true;
    }

    @Override
    public void run() {
        ServerSocket welcomingSocket = null;
        Socket connectionSocket = null;
        try {
            // for listening for connection requests from clients
            welcomingSocket = new ServerSocket(PORT);
            while (alive) {
                System.out.println("Server: Waiting for connection...");
                // Waits for a client to connect, creates a new connection
                // socket for talking to this client.
                // // listen request from client will tak the request adn response back, the three-way hand shake, if talk is successful. will return back a connection socket
                // if no client, program will never pass next line since we are waiting a client to connect
                connectionSocket = welcomingSocket.accept(); // use this connectionSocket to open inputstream and outputstream and exchange data
                System.out.println("Server: Client connected.");
                // Note: welcomingSocket will continue listening for connections
                // from other clients after it is done talking to the client.
                // Generally, we should create a new runnable task for each client request, but it
                // is not done in this example

                try (BufferedReader reader = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()))) {
                    // The server can now read lines sent by the client using BufferedReader
                    // server read line from data
                    // input stream data is send from client to server, then sending response back to client
                    String input;
                    while (!connectionSocket.isClosed()) {
                        input = reader.readLine();
                        System.out.println("Server received: " + input); // echo the same string to the console

                        if (input.equals(EOT)) { // close the connection socket for this client
                            System.out.println("Server: Closing socket.");
                            connectionSocket.close(); // not shutting down the server
                        } else if (input.equals(SHUTDOWN)) { // close connection and welcoming socket, shutting down server and not accepting more client request
                            alive = false;
                            System.out.println("Server: Shutting down.");
                            connectionSocket.close();
                            welcomingSocket.close();
                        }
                    }
                } catch (IOException e) {
                    System.out.println(e);
                }
            }
        } catch (Exception ex) {
            System.out.println("Exception occurred while using the socket: " + ex);
        } finally {
            try {
                if (welcomingSocket != null && !welcomingSocket.isClosed())
                    welcomingSocket.close();
                if (connectionSocket != null && !connectionSocket.isClosed())
                    connectionSocket.close();
            } catch (IOException e) {
                System.out.println("Could not close the socket");
            }
        }
    }

    public static void main(String[] args) {
        SimpleServer server = new SimpleServer();
        server.start();
        try {
            server.join();
        } catch (InterruptedException e) {
            System.out.println("InterruptedException occurred " + e);
        }

    }
}