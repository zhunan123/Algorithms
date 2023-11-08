package week12.velocityAndTemplate.velocity;

import org.apache.commons.text.StringEscapeUtils;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;

public class HotelServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        response.setStatus(HttpServletResponse.SC_OK);
        PrintWriter out = response.getWriter();

        String name = request.getParameter("name");
        if (name == null || name.isEmpty()) {
            name = "anonymous";
        }

        name = StringEscapeUtils.escapeHtml4(name);

        // get velocity object that passed from server to servlet through servletContextHandler
        // this below v is what we initialized in server Velocity velocity = new Velocity();
        // but this velocity object has a name templateEngine, so we can get this attribute
        VelocityEngine v = (VelocityEngine) getServletContext().getAttribute("templateEngine");

        // get velocity context
        VelocityContext context = new VelocityContext();

        // get template using velocity object we initialized
        Template template = v.getTemplate("CS601/week12/velocityAndTemplate/templates/TravelCA.html");

        // add this name variable to velocityContext, and this "name" will be mapping to template
        context.put("name", name);
        // map context name variable to variable in template



        // usually the data would come from some kind of database. Using a
        // simple ArrayList here instead
        // add hotels variables
        ArrayList<Hotel> hotels = new ArrayList<>();
        hotels.add(new Hotel("Sheraton Pier 39"));
        hotels.add(new Hotel("Best Western SF Downtown"));
        hotels.add(new Hotel("Marriott SF Airport"));

        // add this hotels variable to velocityContext, and this "hotels" will be mapping to template
        context.put("hotels", hotels);
        // map context hotels variable to variable in template




        // last step, create StringWriter
        // and merge/write context variable to template
        StringWriter writer = new StringWriter();
        // merge $hotels in template with hotels context that is arraylist variable
        // merge  $name in template with name context that is a variable that user enters
        template.merge(context, writer);

        // send back using outWriter
        out.println(writer.toString());
    }
}
