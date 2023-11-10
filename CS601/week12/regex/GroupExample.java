package week12.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GroupExample {

    public static void main(String[] args) {

        // example 1
        System.out.println("Example 1 ===============");
        String str = "Hello: This is a Test:1, 2, 3";

        Pattern p1 = Pattern.compile("(.*):(.*)"); // greedy quantifier, will keep searching : greedily
        // group1 will continue til end of sting then will back off to :

        Matcher m1 = p1.matcher(str);
        if (m1.find()) {
            System.out.println(m1.group(1)); // Hello: This is a Test:
            System.out.println(m1.group(2)); // 1, 2, 3

        }

        System.out.println("----------------");
        String word = "string";
        // move substring(can occur or not occur) that is not aeiou before aeiou to second group
        // match the pattern that you can move first group to second group
        // string has group1 str and group2 ing

        // so this pattern is group1 is not aeiou can exist or nor exist at all.
        //  in this string "str" will be group1 since matches [^aeiou]*,
        //  so ".*" means all the rest of the characters, means group2 in this case and will be ing that starts with aeiou
        Pattern p = Pattern.compile("([^aeiou]*)(.*)");
        Matcher m = p.matcher(word);
        if (m.matches()) {
            System.out.println(word);
            System.out.println(m.group(1)); //str
            System.out.println(m.group(2)); // ing
        }


		// example 2
        // String str = "Hello: This is a Test:1, 2, 3";
		System.out.println("Example 2===============");
		Pattern p2 = Pattern.compile("(.*?):(.*)"); // ? made this quantifier "reluctant", will stop when see first :
		Matcher m2 = p2.matcher(str);
		if (m2.find()) {
			System.out.println(m2.group(1)); // Hello
			System.out.println(m2.group(2)); //  This is a Test:1, 2, 3 is remaining
		}
    }
}
