package week2.jsonParsing.midtermReview;

public class Address {
    private String state;
    private String city;
    private String street;
    private int number;

    public Address(String state, String city, String street, int number) {
        this.state = state;
        this.city = city;
        this.street = street;
        this.number = number;
    }

    public String getState() {
        return state;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "Address{" +
            "state='" + state + '\'' +
            ", city='" + city + '\'' +
            ", street='" + street + '\'' +
            ", number=" + number +
            '}';
    }
}
