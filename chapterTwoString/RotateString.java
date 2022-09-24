package chapterTwoString;

import java.util.HashSet;

public class RotateString {
    public static void main(String[] args){
        test("abcdefg", 3);
    }


    public static void test(String s, int offset) {
        char[] chars = s.toCharArray();
        if (chars.length == 0 || s == null) {
            return;
        }
        offset = offset % chars.length;

        char temp = ' ';
        char next = ' ';
        //相当于不断将数组往后移动一位;
        for (int j = 0; j < offset; j++) {
            temp = chars[0];
            for (int i = 1; i < chars.length; i++) {
                next = chars[i];
                chars[i] = temp;
                temp = next;
            }
            chars[0] = temp;

        }
    }
}
