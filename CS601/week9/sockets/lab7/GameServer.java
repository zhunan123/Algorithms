package week9.sockets.lab7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GameServer {
    // still need work on sending back server response text to client and display server side message like your guess is too high

    public static final String END_GAME = "END";
    public static final String SHUTDOWN = "SHUTDOWN";
    public static final int PORT = 8000;
    private ExecutorService poolManager;

    private static volatile boolean isShutdown;

    public GameServer() {
        poolManager = Executors.newFixedThreadPool(4);
        isShutdown = false;
    }

    public void runServer() {
        // FILL IN CODE: repeatedly listen for client requests, create a new "helper", a GameWorker
        // to handle each client
        Runnable serverTask = new Runnable() {

            @Override
            public void run() {
                try {
                    ServerSocket welcomingSocket = new ServerSocket(PORT);

                    while (!isShutdown) {
                        Socket connectionSocket = welcomingSocket.accept();
                        Runnable Worker = new GameWorker(connectionSocket);
                        poolManager.submit(Worker);
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        Thread serverThread = new Thread(serverTask);
        serverThread.start();
    }

    /** Server's helper - deals with one client connected via the connection socket
     */
    static class GameWorker implements Runnable {
        // FILL IN CODE: add instance variables as needed, such as socket
        private Socket connectionSocket;

        public GameWorker(Socket connectionSocket) {
            this.connectionSocket = connectionSocket;
        }

        @Override
        public void run() {
            // FILL IN CODE: generate a random number from 0 to 10, and interact with the client
            // as the client is trying to guess it
            // Stop the game and close the socket once the client guesses the number correctly
            Random random = new Random();
            int number = random.nextInt(11);
            try {
                InputStreamReader reader = new InputStreamReader(connectionSocket.getInputStream());
                BufferedReader br = new BufferedReader(reader);

                String input;
                while (!connectionSocket.isClosed()) {
                    input = br.readLine();

                    if (input.compareTo(String.valueOf(number)) < 0) {
                        System.out.println("you guess is too low");
                    } else if (input.compareTo(String.valueOf(number)) > 0) {
                        System.out.println("your guess is too high");
                    } else {
                        System.out.println("correct guess, game over");
                        isShutdown = true;
                        connectionSocket.close();
                    }

                    if (input.equals(END_GAME)) {
                        connectionSocket.close();
                    } else if (input.equals(SHUTDOWN)) {
                        isShutdown = true;
                        connectionSocket.close();
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            } finally {
                try {
                    if (connectionSocket != null)
                        connectionSocket.close();
                }
                catch (IOException e) {
                    System.out.println("Can't close the socket : " + e);
                }

            }
        }
    }

    public static void main(String[] args) {
        GameServer server = new GameServer();
        server.runServer();
    }
}
