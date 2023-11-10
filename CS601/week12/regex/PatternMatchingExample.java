package week12.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatchingExample {

    public static void main(String[] args) {

        // This line compiles a regular expression into a Pattern object
        Pattern p = Pattern.compile("[a-z]+");

        String text = "Now is the time";
//        String text = "noW is the time";

        //A Matcher object is created from the Pattern object for the given text
        Matcher m = p.matcher(text);

        // This line checks if the entire text matches the pattern.
        boolean flag1 = m.matches();


        /**
         boolean flag2 = m.lookingAt();
         this method will find possible substring answer starting from given string beginning, if beginning is no match, then no match from substring for sure

         if String text = "noW is the time"
         This will check if the start of the string matches the pattern.
         Since the string starts with "no", which is lowercase,
         it does match the beginning part of the pattern [a-z]+.
         In this case, flag2 will be true if String text = "noW is the time";


         if String text = "Now is the time" from beginning string, no match of substring since N is uppercase
         * */
        boolean flag2 = m.lookingAt(); // only will look at string from beginning but from middle of string
        System.out.println(flag1 + " " + flag2);
        /*
        System.out.println(m.start()); // or error means no match available
        System.out.println(m.end()); //2,  until W
         */


        /**
         while (m.find()) { ... }

         String text = "Now is the time";

         This while loop uses the find method to search for substring matches in the text.
         The find method scans the text and looks for the next substring that matches the pattern.
         Inside the loop, m.start() and m.end() are used to get the start and
         end indices of the current match, and text.substring(m.start(), m.end())
         is used to extract the matched substring from the text.
         Each matched substring is printed to the console with the prefix "Found: ".

         output---->
         false false
         Found: ow
         Found: is
         Found: the
         Found: time

         false false
         Found: ow 1->3    m.end() will be 1 char next
         Found: is 4->6
         Found: the 7->10
         Found: time 11->15

         * */
        while (m.find()) {
            String s = text.substring(m.start(), m.end()); // will find any match anywhere in the string
            System.out.println("Found: " + s + " " + m.start() + "->" + m.end());
        }
    }
}
