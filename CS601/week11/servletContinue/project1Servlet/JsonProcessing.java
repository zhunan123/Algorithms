package week11.servletContinue.project1Servlet;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileReader;
import java.io.IOException;

public class JsonProcessing {

    public static void parseHotelFileIntoMap(String filePath, HotelReviewData mapData) {
        Gson gson = new Gson();
        try {
            FileReader fr = new FileReader(filePath);
            JsonParser parser = new JsonParser();
            JsonObject jo = (JsonObject) parser.parse(fr);
            JsonArray jsonArr = jo.getAsJsonArray("sr");

            Hotel[] hotels = gson.fromJson(jsonArr, Hotel[].class);
            mapData.addHotels(hotels);
        } catch (IOException e) {
            System.out.println("Could not read the file:" + e);
        }
    }
}
