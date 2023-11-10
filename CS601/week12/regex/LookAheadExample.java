package week12.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LookAheadExample {

    public static void main(String[] args) {
        applyPositiveLookahead();


        checkPassword("smith$4J"); // fine
        checkPassword("smih$4J"); // too short
        checkPassword("smihgsh4J"); // too short
    }

    public static void applyPositiveLookahead() {

        /**
         The ?= is a specific type of non-capturing group known as a lookahead assertion.
         This means that the part of the pattern inside the lookahead must be present after
         the current point in the regex for it to match, but it will not be captured and included
         in the list of matches. Essentially, ?= checks for a condition without consuming
         any characters in the string, so the matching engine's position within the string doesn't advance.

         a(?=b) means b must be followed after a but is not part of the capturing group or answer.
         so this b will not be captured and included in the list of matches
         in this case only matches a
         * */
        /*
         This line compiles a regular expression that matches an 'a' only if it is followed by a 'b'
         (this is what (?=b) means — it's a positive lookahead).
        * */
        Pattern p = Pattern.compile("a(?=b)"); // only look for a which has b followed
        Matcher m = p.matcher("ab"); // a
        Matcher m1 = p.matcher("abc"); // a, if "b(?=c)" will be b since followed by c
        if (m1.find()) { //  Checks to see if the pattern matches the string "ab".
            System.out.println("Valid");
//            System.out.println(m.group(1));
            /*
            Prints the start and end indices of the matched pattern in the string.
            * */
            System.out.println(m1.start() + " " + m1.end());
        }
        else {
            System.out.println("Invalid password");
        }
    }

    public static void checkPassword(String passwd) {
        /**
         * (?=.{8,}): This is a positive lookahead that asserts that the following characters (at least 8 of them) exist from
         * the beginning of the string. . matches any character (except for line breaks), and {8,} means
         * at least 8 of those characters. This part ensures the password is at least 8 characters long.
         *
         * (?=.*[A-Z]): This is another positive lookahead. .* means any character (.) 0 or more times (*), and [A-Z] means
         * any uppercase letter. This part ensures the password has at least one uppercase letter.
         *
         * (?=.*\d): Yet another positive lookahead. Here, \d represents any digit (0-9). Combined with .*,
         * it ensures the password has at least one digit.
         *
         * (?=.*[$%@#]): This is a positive lookahead similar to the previous ones, but [ and ] define a character set,
         * which in this case includes the special characters $, %, @, and #. This ensures the password
         * contains at least one of these special characters.
         *
         * (.*): Finally, this is not a lookahead, but a capturing group that captures the entire password. .* means any
         * character 0 or more times, so this part captures all characters in the password.
         *
         *
         (?=.{8,}) asserts that at the current position in the string, there must be 8 or more characters
         following it. This is a way to apply a condition to the entire string, saying "the string must be
         at least 8 characters long.

         (?=.{8,}): This is a positive lookahead assertion that ensures the string is at least 8 characters long.
         (?=.*[A-Z]): Ensures that there is at least one uppercase letter anywhere in the string.
         (?=.*\\d): Ensures that there is at least one digit anywhere in the string.
         (?=.*[$%@#]): Ensures that there is at least one special character from the set $, %, @, #.
         (.*): Matches any characters zero or more times, capturing the entire string.

         (?= ... ) is the positive lookahead assertion that tells the regex engine to
         look ahead in the string for a certain pattern without including that pattern in the overall match.
         .*[A-Z] within the lookahead means "match any sequence of characters followed by an uppercase letter".

         IMPORTANT====>
         positive lookahead must be followed by pattern ?=pattern
         .{8,} means start from position of any character, there are at lest 8 character includes and after this char
         I think (?=.{8,}) do not need to followed by anything since nothing before ?= and the patter .{8,} is any string has length of 8 or more
         (.{3,}) will match to rrr or rvb or psdfig89 but not rr has to be length 3 or more
         .{8,} means any string consist any character and have a length at least 8, below is any digits but with . is any character
         \\d{4} 1238 digits have length of 4 same stuff

         (?=.*[A-Z]) means [A-Z] can be appear any place at given string since [A-Z] can follows any char means and starting of string so means anywhere in the string
         so ?= is positive lookahead assertion,
         entire (?=.*[A-Z]) will check if a uppercase letter is in this given string

         if all (?=.{8,})(?=.*[A-Z])(?=.*\d)(?=.*[$%@#]) matches, this positive lookahead will not move current index or actual write anything, so still at beginning index
         then if all the positive lookahead passes, will execute (.*) from current position, .* matches any char 0 or more times
         here in this case will start at beginning
         each () in positive lookahead is separated and will be evaluated individually and not influence other () positive lookahead
         * */
        String regex = "(?=.{8,})(?=.*[A-Z])(?=.*\\d)(?=.*[$%@#])(.*)"; // has an uppercase letter and a digit
        Pattern p = Pattern.compile(regex);
        Matcher matcher = p.matcher(passwd);
        if (matcher.find()) {
            System.out.println("Valid password");
        }
        else {
            System.out.println("Invalid password");
        }
    }
}
