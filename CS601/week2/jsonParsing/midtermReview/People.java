package week2.jsonParsing.midtermReview;

import java.util.List;

public class People {

    private List<PersonInfo> personList;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (PersonInfo p : personList) {
            sb.append(p);
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }
}
