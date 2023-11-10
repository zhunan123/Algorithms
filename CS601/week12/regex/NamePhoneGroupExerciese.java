package week12.regex;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NamePhoneGroupExerciese {

  public static void extractLastNameAndPhone(String line) {
    Pattern pattern = Pattern.compile("([A-Z][a-z]*)\\s([A-Za-z]+(\\s[A-Za-z]+)*)\\s([1-9]\\d{2}-\\d{3}-\\d{4})");

    Pattern pattern1 = Pattern.compile("([A-Z][a-z]*)\\s([A-Z][a-z]*([ '-][A-Za-z]+)*)\\s([1-9]\\d{2}-\\d{3}-\\d{4})");
    Matcher matcher = pattern1.matcher(line);

    if (matcher.matches()) {
      System.out.println(matcher.group(1) + matcher.group(2) +  " => "+ matcher.group(4));
    }
  }

  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new FileReader("cs601/week12/regex/NamesAndPhones"))) {
      String line = "";
      while ((line = br.readLine()) != null) {
        extractLastNameAndPhone(line);
      }
    }
    catch (IOException e) {
      System.out.println(e);
    }

  }
}
