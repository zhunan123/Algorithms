package week2.jsonParsing.midtermReview;

public class PersonInfo {
    private String name;
    private String id;
    private String title;
    private Address address;

    public PersonInfo(String name, String id, String title, Address address) {
        this.name = name;
        this.id = id;
        this.title = title;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Address getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "PersonInfo{" +
            "name='" + name + '\'' +
            ", id='" + id + '\'' +
            ", title='" + title + '\'' +
            ", address=" + address +
            '}';
    }
}
