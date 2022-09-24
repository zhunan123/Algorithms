package chapterTwoString;

import java.util.HashSet;

public class RotateString {
    public static void main(String[] args){
        test("abcdefg", 3);
    }


    public static void test(String chars, int offset) {
        char[] s = chars.toCharArray();
        if(s.length == 0 || s == null){
            return;
        }

        //开始旋转
        char prev = ' ';
        char cur = ' ';
        int cnt = offset % s.length;
        for(int i =0;i<cnt; i++){

            prev = s[0];
            for(int j=1;j<s.length;j++){
                cur = s[j];
                s[j] = prev;
                prev = cur;
            }
            s[0] = prev;
        }
    }
}
