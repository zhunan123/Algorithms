package week11.servletContinue.project1Servlet;

import com.google.gson.JsonObject;
import org.apache.commons.text.StringEscapeUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@SuppressWarnings("serial")
public class SimpleHotelServlet extends HttpServlet {

    @Override
    protected void doGet(
        HttpServletRequest request,
        HttpServletResponse response)
        throws ServletException, IOException {

        HotelReviewData hotelReviewData = new HotelReviewData();
        JsonProcessing jp = new JsonProcessing();

        jp.parseHotelFileIntoMap("input/hotels/hotels200.json", hotelReviewData);


        response.setContentType("application/json");
        response.setStatus(HttpServletResponse.SC_OK);

        PrintWriter out = response.getWriter();
        // writing to the response

        String hotelId = request.getParameter("id");
        hotelId =  StringEscapeUtils.escapeHtml4(hotelId);

        Hotel hotel = hotelReviewData.getHotelById(hotelId);

        JsonObject jsonResponseObject = new JsonObject();
        jsonResponseObject.addProperty(hotelId, String.valueOf(hotel));


        out.println(jsonResponseObject);
    }
}
