package week10.http.project1UsingHttpFetcher;

import java.util.HashMap;
import java.util.Map;

public class Search {

    public class HotelReviewData {
        private static Map<String, Hotel> mapStoredHotel = new HashMap<>();
        public static Hotel getHotelById(String hotelId) {
            return mapStoredHotel.get(hotelId);
        }
    }

    public static void main(String[] args) {
        String[] strArr = new String[10];
        if (strArr[0].equals("find")) {
            if (strArr.length == 2) {
                String hotelId = strArr[1];
                Hotel hotelResult = HotelReviewData.getHotelById(hotelId);

                String lat = hotelResult.getLocation().getLat();
                String lng = hotelResult.getLocation().getLng();

                String res = HttpFetcher.fetch("api.open-meteo.com", "/v1/forecast?latitude="+ lat + "&longitude=" + lng + "&current_weather=true");
                if (hotelResult != null) {
                    System.out.println(hotelResult);
                    System.out.println(res);
                } else {
                    System.out.println("No hotel found, please enter a valid hotel id.");
                }
            } else {
                System.out.println("Missing argument, please search for a hotel id...");
            }
        }
    }
}
