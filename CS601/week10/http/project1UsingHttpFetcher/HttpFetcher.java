package week10.http.project1UsingHttpFetcher;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.Socket;
import java.net.URL;
import java.net.URLConnection;

public class HttpFetcher { // for http, less secure using regular http fetch
    public static int PORT = 80;
    public static URL url;

    // open connection method hide some socket stuff and more company level
    public static String fetchOpenConnection() {
        String line = "";
        try{
            url = new URL("https://api.open-meteo.com/v1/forecast?latitude=37.7&longitude=122&current_weather=true");
            URLConnection connection = url.openConnection();
            HttpsURLConnection httpsConnection = (HttpsURLConnection) connection;

            System.out.println(httpsConnection.getResponseCode() + " " + httpsConnection.getResponseMessage());

            try {
                BufferedReader br = new BufferedReader(new InputStreamReader(httpsConnection.getInputStream()));
                System.out.println(br.readLine());
            } catch (IOException e) {
                System.out.println(e);
            }
        } catch (IOException e) {
            System.out.println(e);
        }
        return line;
    }


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

            String line = reader.readLine(); // read HTTP response from server
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

}
