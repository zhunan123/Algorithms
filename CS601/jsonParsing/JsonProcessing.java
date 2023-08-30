package CS601.jsonParsing;
import com.google.gson.*;

public class JsonProcessing {

    public static void main(String[] args) {
        parseFruitFile("input/fruit.json");
    }

    public static void parseFruitFile(String filePath) {
        Gson gson = new Gson();

        try {
            FileReader fr = new FileReader(filePath);
            // store the fruit into Fruit class
            Fruit fruit = gson.fromJson(fr, Fruit.class);
            System.out.println(fruit);
            String jsonInString = gson.toJson(fruit);
            System.out.println(jsonInString);
        } catch (IOException e) {
            System.out.println("Could not read this file: " + e);
        }
    }

    public static void parsePersonFile(String filePath) {
        try {
            FileReader fr = new FileReader(filePath);
            Person person = gson.fromJson(fr, Person.class);
            System.out.println(person);
            String jsonInString = gson.toJson(Person);
            System.out.println(jsonInString);
        } catch(IOException e) {
            System.out.println("Could not read this file: " + e);
        }
    }

    public static void parsePeopleFile(String filePath) {
        Gson gson = new Gson();
        try {
            FileReader fr = new FileReader(filePath);
            JsonParser parser = new JsonParser();
            JsonObject jo = (JsonObject) parser.parse(fr);
            JsonArray jsonArr = jo.getAsJsonArray("people");

            Person[] personList = gson.fromJson(jsonArr, Person[].class);
            for (Person person : personList) {
                System.out.println("person: " + person);
            }
        } catch () {

        }
    }
}
