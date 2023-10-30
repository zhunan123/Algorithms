package week10.http.project1UsingHttpFetcher;

public class Location {

    private final String lat;
    private final String lng;

    public Location(String latitude, String longitude) {
        this.lat = latitude;
        this.lng = longitude;
    }

    public String getLat() {
        return lat;
    }

    public String getLng() {
        return lng;
    }

    public String toString() {
        return "latitude = " + lat + System.lineSeparator()
            + "longitude = " + lng;
    }
}
