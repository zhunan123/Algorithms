package week2.jsonParsing.midtermReview;

public class Fruit {
    private String name;
    private String color;
    private double price;
    private boolean organic;

    public Fruit(String name, String color, double price, boolean organic) {
        this.name = name;
        this.color = color;
        this.price = price;
        this.organic = organic;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public double getPrice() {
        return price;
    }

    public boolean isOrganic() {
        return organic;
    }

    @Override
    public String toString() {
        return "Fruit{" +
            "name='" + name + '\'' +
            ", color='" + color + '\'' +
            ", price=" + price +
            ", organic=" + organic +
            '}';
    }
}
