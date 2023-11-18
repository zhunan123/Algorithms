package week13.lab9;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class regex {

    /**
     Capturing Group:
     A capturing group is a part of a regex enclosed in parentheses ().
     It is used to group part of a pattern together. This has two main effects:
     You can apply quantifiers to the entire group, not just a single character.
     It captures the text matched by the part of the regex inside the parentheses for later use.
     For example, in the regex (abc)+, the parentheses create a single capturing group for the letters abc,
     and the + applies to the whole group, meaning "one or more sequences of 'abc'".
     The text that matches the capturing group can be recalled from the resulting Matcher object via the group() method.
     Character Class:

     A character class:
     is defined by square brackets [] and matches any one character from a set of characters.
     If you put several characters inside square brackets, the regex engine will match any one of them.
     For example, the character class [abc] will match any single 'a', 'b', or 'c'.
     If you put a caret ^ at the start of a character class, it negates the class, matching a character that is not listed in the brackets.
     For example, [^abc] will match any single character that is not 'a', 'b', or 'c'.
     The main difference between the two is that a capturing group is used to group parts of
     a pattern and can capture multiple characters as a single unit for subsequent reference,
     whereas a character class matches any one character from a specific set of characters without capturing or grouping.
     * */

    public static final String REGEX = "";
    public static List<String> getValidLinks(String filename) {
        List<String> links = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));

            String line;
            while ((line = br.readLine()) != null) {

                Pattern pattern = Pattern.compile("<a[^>]*?href\\s*=\\s*\"(.*?)[\"#]");
                Matcher matcher = pattern.matcher(line);

                if (matcher.find()) {
                    System.out.println(matcher.group(1));
                    if (matcher.group(1).isEmpty()) {
                        continue;
                    }
                    links.add(matcher.group(1));
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return links;
    }

    public static void writeToHtmlFile(List<String> links, String outputFileName) {
        StringBuilder sb = new StringBuilder();
        try {
            PrintWriter pw = new PrintWriter(outputFileName);

            sb.append("<!DOCTYPE html> <html><br><body>").append(System.lineSeparator());

            for (String link : links) {
                sb.append("<a href = \"").append(link).append("\">").append(link).append("</a><br>").append(System.lineSeparator());
            }

            sb.append("</body></html>");

            pw.println(sb);
            pw.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        List<String> links = getValidLinks("CS601/week13/lab9/touristInfo.html");
        System.out.println(links);
        writeToHtmlFile(links, "CS601/week13/lab9/outputResult.html");
    }
}
