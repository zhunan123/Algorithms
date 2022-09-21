package chapterTwoString;

public class capitalizesFirst {
    public static void main(String[] args){
        test("i jidls    mdijf  i  lsidj  i p l  ");
    }
    public static String test(String s){
        //思路就是第0个走要小写，从第一个开始，只要当前元素前一个是空集，但是当前元素不为空，就判断为开头，就变成大写。
        char[] chars = s.toCharArray();
        if(chars[0]>='a' && chars[0]<='z'){
            chars[0] -= 32;
        }

        for(int i=1;i<chars.length;i++){
            if(chars[i - 1] == ' ' && chars[i] != ' '){
                chars[i] -=32;
            }
        }
        System.out.println(String.valueOf(chars));
        return String.valueOf(chars);
    }
}
