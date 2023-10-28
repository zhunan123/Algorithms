package week10.http;

import java.io.*;
import java.net.Socket;

public class HttpFetcher {
    public static int PORT = 80;

    public static String fetch(String host, String pathAndResource) {

        StringBuffer buf = new StringBuffer();
        try {
            Socket socket = new Socket(host, PORT);

            OutputStream out = socket.getOutputStream();
            InputStream instream = socket.getInputStream();

            BufferedReader reader = new BufferedReader(new InputStreamReader(instream));

            String request = getRequest(host, pathAndResource);
            System.out.println("Request = " + request);

            out.write(request.getBytes()); // send HTTP request to the server
            out.flush();

            String line = reader.readLine();
            while (line != null) {
                buf.append(line + System.lineSeparator());
                line = reader.readLine();
            }
        } catch (IOException e) {
            System.out.println("HTTPFetcher::IOException occured during download: " + e.getMessage());
        }
        return buf.toString();
    }

    private static String getRequest(String host, String pathResourceQuery) {
        String request = "GET " + pathResourceQuery + " HTTP/1.1" + System.lineSeparator() // GET request
            + "Host: " + host + System.lineSeparator() // Host header required for HTTP/1.1
            + "Connection: close" + System.lineSeparator() // make sure the server closes the connection after we fetch one page
            + System.lineSeparator();
        return request;
    }

    public static void main(String[] args) {
//        String res = HttpFetcher.fetch("example.com", "/");
        String res = HttpFetcher.fetch("tutoringcenter.cs.usfca.edu", "/resources/");
        System.out.println(res);

    }
}
