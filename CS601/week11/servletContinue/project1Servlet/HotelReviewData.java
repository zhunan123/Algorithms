package week11.servletContinue.project1Servlet;

import java.util.*;

public class HotelReviewData {
    // add data and get data
    private Map<String, Hotel> mapStoredHotel;


    public HotelReviewData() {
        this.mapStoredHotel = new HashMap<>();
    }


    public void addHotels(Hotel[] hotels) {
        for (Hotel hotel : hotels) {
            mapStoredHotel.put(hotel.getHotelId(), hotel);
        }
    }

    public Hotel getHotelById(String hotelId) {
        return mapStoredHotel.get(hotelId);
    }
}

