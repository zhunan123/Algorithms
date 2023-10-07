package week3.designPattern.immutability;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateFormattingExample {

    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String date = "2022-06-29";
        LocalDate localDate = LocalDate.parse(date, formatter);
        System.out.println(localDate);
        System.out.println(localDate.getDayOfMonth());
    }
}
