package week9.sockets.lab7;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class GameClient implements Runnable {

    /**
     Fill in code in the GameServer and GameClient so that clients could play a number guessing game:
     The server generates a random number from 0 to 10, the client tries to guess it,
     while the server provides the hints:

     This is a sample output from the client side:

     Client: Started...
     Server: I guessed a number from 0 to 10, guess it:
     4
     Server: Your guess is too low
     7
     Server: Your guess is too high
     5
     Server: Your guess is too low
     6
     Server: Correct guess! Game over.
     ---------------------------------

     You should be using sockets for the server and the client, and each client should be handled by a different Runnable.
     * */
    @Override
    public void run() {
        try {
            System.out.println("Client: Started...");
            // FILL IN CODE to play the number guessing name with the server
            Socket socket = new Socket("localhost", GameServer.PORT);
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader readerSocket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            Scanner sc = new Scanner(System.in);

            String input = null;
            while (!socket.isClosed()) {
                input = sc.nextLine();
                writer.println(input);

                String res = readerSocket.readLine();
                System.out.println(res);

                if (input.equals(GameServer.END_GAME)) {
                    socket.close();
                } else if (input.equals(GameServer.SHUTDOWN)) {
                    socket.close();
                }
            }
            writer.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public static void main(String[] args) {
        GameClient client = new GameClient();
        Thread t1 = new Thread(client);
        t1.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
            System.out.println("The thread got interrupted " + e);
        }
    }
}
