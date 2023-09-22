package week5.junit;

import java.util.Arrays;

public class StringUtil {

    public static String trimConcatenate(String s1, String s2) {
        if (s1 == null || s2 == null || s1.isEmpty() || s2.isEmpty() )
            throw new IllegalArgumentException();
        return s1.trim() + s2.trim();
    }

    public static String[] splitByCommas(String s) {
        assert(s != null);
        String[] words = s.split(",");
        return words;
    }

    public static void main(String[] args) {
        System.out.println(StringUtil.trimConcatenate("  Halloween  ", "pumpkin "));
        System.out.println(StringUtil.trimConcatenate("Do or do not,     there is no try  ", "."));


        String[] words = StringUtil.splitByCommas("This is a new day, a new beginning");
        System.out.println(Arrays.toString(words));
    }
}
