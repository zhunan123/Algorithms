package week11.servletContinue;

import week11.servletContinue.project1Servlet.HotelReviewData;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HotelServletContextExample extends HttpServlet {
    private HotelReviewData data;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setStatus(HttpServletResponse.SC_OK);

        try {
            String hotelId = request.getParameter("id");
            HotelReviewData hdata = (HotelReviewData) getServletContext().getAttribute("hotelReviewData");

            response.getWriter().println("Hotel id:" + hotelId + " " + hdata.getReviewList(hotelId));
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
