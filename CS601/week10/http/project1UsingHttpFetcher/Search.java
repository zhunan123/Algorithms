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
                /**
                 // request console log, System.out.println("Request = " + request);
                 Request = GET /v1/forecast?latitude=37.837773&longitude=-122.298142&current_weather=true HTTP/1.1
                 Host: api.open-meteo.com
                 Connection: close


                 // weather result display below
                 // header part
                 HTTP/1.1 200 OK
                 Date: Fri, 10 Nov 2023 23:06:29 GMT
                 Content-Type: application/json; charset=utf-8
                 Transfer-Encoding: chunked
                 Connection: close

                 // body part
                 1db
                 {
                    "latitude":37.81809,
                    "longitude":-122.29039,
                    "generationtime_ms":0.08499622344970703,
                    "utc_offset_seconds":0,
                    "timezone":"GMT",
                    "timezone_abbreviation":"GMT",
                    "elevation":3.0,
                    "current_weather_units":{
                        "time":"iso8601",
                        "interval":"seconds",
                        "temperature":"�C",
                        "windspeed":"km/h",
                        "winddirection":"�",
                        "is_day":"",
                        "weathercode":"wmo code"
                    },
                    "current_weather":{"time":"2023-11-10T23:00","interval":900,"temperature":17.4,"windspeed":13.0,"winddirection":312,"is_day":1,"weathercode":3}
                 }
                 0
                 * */
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
