package chapterTwoString;

import java.util.HashSet;
import java.util.Set;

public class isUnique {

    public static void main(String[] args){
        test("cabc");
    }


    public static boolean test(String s){
        //method 1 解题思路：冲后面开始，跟前面第一个i的index不一样，就说明有重复
//        for(int i=s.length()-1; i>=0;i--){
//            if(s.indexOf(s.charAt(i)) != i){
//                return false;
//            }
//        }
//        return true;
        //method 2
        HashSet<Character> set = new HashSet<>();
        for(int i=0;i<s.length();i++){
            set.add(s.charAt(i));
        }
        return set.size() == s.length() ? true: false;
    }
}
