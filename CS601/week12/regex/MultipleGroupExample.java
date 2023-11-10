package week12.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MultipleGroupExample {
  public static void main(String[] args) {
    String text = "John writes about this, and John Doe writes about that, and John Wayne writes about everything.";

    /**
     => greedy quantifier, will match as much as possible
     => .+ means match any char once or more times with greedy quantifier
     last ele in text is . will match [,\.], greedy quantifier will match as much as possible to last . after everything
     */
    String patternString1 = "(John) (.+)[,\\.]";

    /**
     => reluctant quantifier, will match as less as possible have ?
     => the question mark ? after the + quantifier makes it a reluctant or non-greedy quantifier.
     when match first , or . in [,\.] with given text, matching is done
     * */
    String patternString2 = "(John) (.+?)[,\\.]";

    /**
     another reluctant quantifier
     will only match 1 next char

     (.+?): This is a capturing group that uses a reluctant (also known as lazy) quantifier +?.
     The dot . matches any character except newline characters, and the +? means "match one or more times,
     but as few times as possible".
     When you apply this pattern to the string text, the reluctant quantifier .+? in the second group will match
     as few characters as possible while still fulfilling/satisfying the condition of the regex. Since there is no specified
     ending condition or delimiter after the second group in the pattern (.+?), the regex engine will match only
     the first character that comes after "John ".
     * */
    String patternString3 = "(John) (.+?)";

    Pattern pattern = Pattern.compile(patternString1);
    Matcher matcher = pattern.matcher(text);

    if (matcher.find()) {
      System.out.println("Found:");
      System.out.println("group 1: " + matcher.group(1));
      System.out.println("group 2: " + matcher.group(2));
      System.out.println("");

    }
  }
}
