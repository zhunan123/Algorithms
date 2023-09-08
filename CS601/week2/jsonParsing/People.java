package week2.jsonParsing;

import java.util.List;

public class People {

    private List<Person> people;

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < people.size(); i++) {
            sb.append(people.get(i));
            sb.append(System.lineSeparator());
        }

        return sb.toString();
    }
}
