package week11.servletContinue;

import org.apache.commons.text.StringEscapeUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ConcurrentLinkedQueue;

public class MessageServlet extends HttpServlet {

    private static final String TITLE = "Messages";

    private ConcurrentLinkedQueue<String> messages; // thread-safe, from the concurrent package
    /**
     need to share this queue data
     any method called on this queue will be synchronization
     if this queue need to be share by multiple request for synchornization
     * */

    public MessageServlet() {
        super();
        messages = new ConcurrentLinkedQueue<>();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        /*
        Each %n will be replaced by a newline character appropriate for the platform the code is being run on.
        This is especially useful when generating content like HTML, where whitespace formatting isn't reflected in the rendered output
        but can make the source code easier to read.

        %s will be replaced by the value of the TITLE variable. This variable is expected
        to contain a string that will be inserted into the <title> tag of the HTML page.
        * */
        PrintWriter out = response.getWriter();
        out.printf("<html>%n%n");
        out.printf("<head><title>%s</title></head>%n", TITLE);
        out.printf("<body>%n");

        out.printf("<h1>Message Board</h1>%n%n");

        /**
         go over the current queue and output the result in html and display in webpage
         because it is thread safe, read operation will be synchronzied
         * */
        for (String message : messages) {
            out.printf("<p>%s</p>%n%n", message);
        }

        printForm(request, response);

        out.printf("<p>This request was handled by thread %s.</p>%n", Thread.currentThread().getName());

        out.printf("%n</body>%n");
        out.printf("</html>%n");

        response.setStatus(HttpServletResponse.SC_OK);
    }

    private static void printForm(HttpServletRequest request, HttpServletResponse response) throws IOException {

        PrintWriter out = response.getWriter();

        /*
        \" is " in a double quote
         <form action=""> The action attribute specifies where to send the form data when the form is submitted.
         form action=\"" + Dynamic variable + "\"  -> request.getServletPath() is /messageBoard this case,
         send data when form submit to /messageBoard which is MessageServlet, but since the method is post, send to doPost()

         method=\"post\": The method="post" part sets the HTTP method used to send the form data to the server. send message to doPost()
        * */
        out.println("<form action=\"" + request.getServletPath() + "\" method = \"post\">");
        out.println("Name: <br>");
        out.println("<input type=\"text\" name=\"username\"><br>");

        out.println("Message: <br>");
        out.println("<input type=\"text\" name=\"message\">");
        out.println("<br><br>");
        out.println("<input type=\"submit\">");
        out.println("</form>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");

        String username = request.getParameter("username");
        String message = request.getParameter("message");

        username = (username == null || username.equals(""))  ? "anonymous" : username;
        message = message == null ? "" : message;

        // Avoid XSS attacks using Apache Commons StringUtils
        // Comment out if you don't have this library installed
        username = StringEscapeUtils.escapeHtml4(username);
        message = StringEscapeUtils.escapeHtml4(message);

        // what happened after in doPost()? --->create string and combine all message info and add to concurrent synchronized queue and display it
        String formatted = String.format("%s<br><font size=\"-2\">[ posted by %s at %s ]</font>", message, username,
            getDate());

        // Keep in mind multiple threads may access at once, added formatted message to concurrent queue
        messages.add(formatted);

        // Only keep the latest 5 messages
//        if (messages.size() > 5) {
//            String first = messages.poll();
//        }

        response.setStatus(HttpServletResponse.SC_OK);
        response.sendRedirect(request.getServletPath());// go back to doGet() shows all queue, printForm, hope somebody will fill in the form and go doPost()..
        /*
        will be redirect to /messageBoard doGet() method which is default, then doGet() will hope someone fill in the message form and continue..
        * */
    }

    private static String getDate() {
        String format = "hh:mm a 'on' EEEE, MMMM dd yyyy";
        DateFormat formatter = new SimpleDateFormat(format);
        return formatter.format(new Date());
    }
}
