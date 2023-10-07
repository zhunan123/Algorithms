package week2.jsonParsing.midtermReview;


import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class JsonProcessing {
    public static void parseFruitFile(String filePath) {
        Gson gson = new Gson();
        try {
            FileReader fr = new FileReader(filePath);
            Fruit fruit = gson.fromJson(fr, Fruit.class);
            System.out.println(fruit);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void parseOnePersonInfoFile(String filePath) {
        Gson gson = new Gson();
        try {
            FileReader fr = new FileReader(filePath);
            PersonInfo person = gson.fromJson(fr, PersonInfo.class);
            System.out.println(person);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void parsePeopleArrayFile(String filePath) {
        Gson gson = new Gson();
        try {
            FileReader fr = new FileReader(filePath);
            JsonParser parser = new JsonParser();
            JsonObject jo = (JsonObject) parser.parse(fr);
            JsonArray jsonArray = jo.getAsJsonArray("people");

            PersonInfo[] personList = gson.fromJson(jsonArray, PersonInfo[].class);

            for (PersonInfo p : personList) {
                System.out.println(p);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        parseFruitFile("CS601/week2/jsonParsing/midtermReview/input/fruit.json");
        System.out.println("-------------------------------");
        parseOnePersonInfoFile("CS601/week2/jsonParsing/midtermReview/input/personInfo.json");
        System.out.println("-------------------------------");
        parsePeopleArrayFile("CS601/week2/jsonParsing/midtermReview/input/people.json");
    }
}
