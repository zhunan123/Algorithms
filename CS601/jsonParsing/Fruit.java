package CS601.jsonParsing;
//import com.google.gson.annotations.SerializaedName;

public class Fruit {
    private String name;
    private String color;
    private String price;

//    @SerializaedName(value ="organic")
    private boolean organic;

    public Fruit(String name, String color, String price, boolean organic) {
        this.name = name;
        this.color = color;
        this.price = price;
        this.organic = organic;
    }

    public String toString() {
        return "Fruit: " + System.lineSeparator()
            + "name= " + name + " , "
            + "color= " + color + " , "
            + "price= " + price + " , "
            + "organic= " + organic;
    }
}
