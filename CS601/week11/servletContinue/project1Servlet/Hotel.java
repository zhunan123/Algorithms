package week11.servletContinue.project1Servlet;

public class Hotel {

    private final String f;
    private final String id;
    private final String ad;
    private final Location ll;
    private final String ci;
    private final String pr;
    private final String c;

    public Hotel(String hotelName, String hotelId, String address, Location location, String cityName, String provinceName, String countryName) {
        this.f = hotelName;
        this.id = hotelId;
        this.ad = address;
        this.ll = location;
        this.ci = cityName;
        this.pr = provinceName;
        this.c = cityName;
    }

    public String getHotelName() {
        return f;
    }

    public String getHotelId() {
        return id;
    }

    public Location getLocation() {
        return ll;
    }

    public String toString() {
        return "hotelName = " + f + System.lineSeparator()
            + "hotelId = " + id + System.lineSeparator()
            + ll + System.lineSeparator()
            + "address = " + ad + ", " + ci + ", " + pr + ", " + c;
    }
}