package week10.http;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.*;
import java.net.URL;

public class WebClientSSL {
    public static String callAPI() {
        String s = "";
        String urlString = "https://www.googleapis.com/books/v1/volumes?q=isbn:9787508318134";

        PrintWriter out = null;
        BufferedReader in = null;
        SSLSocket socket = null;

        try {
            URL url = new URL(urlString);
            SSLSocketFactory factory = (SSLSocketFactory) SSLSocketFactory.getDefault();
            socket = (SSLSocket) factory.createSocket(url.getHost(), 443);

            out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
            String request = getRequest(url.getHost(), url.getPath() + "?"+ url.getQuery());
            System.out.println("Request: " + request);

            out.println(request); // send the request to the server
            out.flush();

            // read response from google server with fetched data
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // use input stream to read server's response
            String line;
            StringBuffer sb = new StringBuffer();
            while ((line = in.readLine()) != null) {
                System.out.println(line);
                sb.append(line);
            }
            s = sb.toString();
        } catch (IOException e) {
            System.out.println(
                "An IOException occured while writing to the socket stream or reading from the stream: " + e);
        } finally {
            try {
                // close the streams and the socket
                out.close();
                in.close();
                socket.close();
            } catch (IOException e) {
                System.out.println("An exception occured while trying to close the streams or the socket: " + e);
            }
        }

        return s;
    }

    private static String getRequest(String host, String pathResourceQuery) {
        String request = "GET " + pathResourceQuery + " HTTP/1.1" + System.lineSeparator() // GET
            // request
            + "Host: " + host + System.lineSeparator() // Host header required for HTTP/1.1
            + "Connection: close" + System.lineSeparator() // make sure the server closes the
            // connection after we fetch one page
            + System.lineSeparator();
        return request;
    }

    public static void main(String[] args) {
        String jsonResult = callAPI();
        System.out.println(jsonResult);
    }
}
