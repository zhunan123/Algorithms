package week9.sockets;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ReversedStringClient extends Thread{
    public ReversedStringClient() {
        this.start();
    }

    public void run() {
        System.out.println("Client: Started...");
        System.out.println("port: " + ReversedStringServer.PORT);
        Scanner sc = null;
        BufferedReader readerSocket = null;
        PrintWriter writer = null;

        try {
            Socket socket = new Socket("localhost", ReversedStringServer.PORT);
            sc = new Scanner(System.in);

            readerSocket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);

            String input;
            while (!socket.isClosed()) {
                input = sc.nextLine();

                writer.println(input);

                String res = readerSocket.readLine();
                System.out.println("Client received: " + res);

                if (input.equals(SimpleServer.EOT)) {
                    System.out.println("Client: Ending client.");
                    socket.close();
                } else if (input.equals(SimpleServer.SHUTDOWN)) {
                    System.out.println("Client: Shutting down server.");
                    socket.close();
                }
            }

        } catch (IOException ex) {
            System.out.println(ex);
        } finally {
            try {
                if (sc != null)
                    sc.close();

                if (readerSocket != null)
                    readerSocket.close();

                if (writer != null)
                    writer.close();
            } catch (IOException e) {
                System.out.println("Could not close streams: " + e);
            }
        }
    }

    public static void main(String[] args) {
        new ReversedStringClient();
    }
}
