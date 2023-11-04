package week11.servletContinue;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import week11.servletContinue.project1Servlet.HotelReviewData;
import week11.servletContinue.project1Servlet.Review;

import java.util.ArrayList;

public class HotelServerContextExample {
    public static final int PORT = 8080;

    public static void main(String[] args) {
        Server server = new Server(PORT);
        HotelReviewData hdata = new HotelReviewData();

        ArrayList<Review> reviewList = new ArrayList<>();
        Review review1 = new Review( "10323", "562vb4", 5.00, "Nice Hotel", "It's pretty good", "Bob", "2016-9-28");
        Review review2 = new Review( "10323", "562vb3", 6.00, "Nice Hotel1", "It's pretty good1", "marry", "2016-9-29");
        reviewList.add(review1);
        reviewList.add(review2);

        hdata.addReviews("10323", reviewList);

        /*
            in server -->
            use ServletContextHandler is example how to share hotelReviewData map from server to servlet
            handler = new ServletContextHandler()
            handler.setAttribute("hotelReviewData", hdata);

            then in servlet -->
            getServletContext().getAttribute("hotelReviewData")
            ---> to achieve how to share data from server to servlet
        * */

        ServletContextHandler handler = new ServletContextHandler(ServletContextHandler.SESSIONS);
        handler.addServlet(HotelServletContextExample.class, "/hotels");
        handler.setAttribute("hotelReviewData", hdata);
        server.setHandler(handler);

        try {
            server.start();
            server.join();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
