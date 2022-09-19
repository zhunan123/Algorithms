package chapterTwoString;

public class ReverseAsciiEncodedString {

    //79 76 76 69 72  ----->HELLO
    public static void main(String[] args){
        test("7976766972");
    }

    public static String test(String encodedString){
        StringBuilder sb = new StringBuilder();
        for(int i = encodedString.length(); i >=2; i -=2){
            String substr = encodedString.substring(i - 2, i);
            int num = Integer.parseInt(substr);
            sb.append((char)num);
        }
        System.out.println(sb.toString());
        return sb.toString();
    }
}
