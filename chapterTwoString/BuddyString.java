package chapterTwoString;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BuddyString {

    public static void main(String[] args){
//        test("aaaaaaabc", "aaaaaaacb");
        test("aa", "aa");
//        test("ab", "ab");
    }
    public static boolean test(String a, String b) {
        // Write your code here
        //show three conditions, two string length not equal, eaual string but cannot change
        //two char and get equal, not equal but change 2 char will equal

        int alen = a.length();
        int blen = b.length();
        //first condition
        if (alen != blen) {
            return false;
        }

        //second condition
        if (a.equals(b)) {
            Set<Character> set = new HashSet<Character>();
            for (char c : a.toCharArray()) {
                set.add(c);
            }
            return set.size() < alen;
        }

        //third condition
        ArrayList<Integer> list = new ArrayList();
        for (int i = 0; i < alen; i++) {
            if (a.charAt(i) != b.charAt(i)) {
                list.add(i);
            }
        }

        if (list.size() == 2 && (a.charAt(list.get(0)) == b.charAt(list.get(1)) && a.charAt(list.get(1)) == b.charAt(list.get(0)))) {
            return true;
        }
        return false;
    }
}
