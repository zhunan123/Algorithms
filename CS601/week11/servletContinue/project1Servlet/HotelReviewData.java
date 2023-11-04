package week11.servletContinue.project1Servlet;

import java.util.*;

public class HotelReviewData {
    // add data and get data
    private Map<String, Hotel> mapStoredHotel;
    private Map<String, List<Review>> mapStoredReview;


    public HotelReviewData() {
        this.mapStoredHotel = new HashMap<>();
        this.mapStoredReview = new HashMap<>();
    }


    public void addHotels(Hotel[] hotels) {
        for (Hotel hotel : hotels) {
            mapStoredHotel.put(hotel.getHotelId(), hotel);
        }
    }

    public Hotel getHotelById(String hotelId) {
        return mapStoredHotel.get(hotelId);
    }

    public List<Review> getReviewList(String hotelId) {
        List<Review> reviewList = mapStoredReview.get(hotelId);
        if (reviewList != null) {
            return Collections.unmodifiableList(reviewList);
        } else {
            return null;
        }
    }

    public void addReviews(String hotelId, List<Review> reviewList) {
        mapStoredReview.put(hotelId, reviewList);
    }
}

