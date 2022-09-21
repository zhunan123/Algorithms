package chapterTwoString;

public class LowerCaseToUpperCase {

    public static void main(String[] args){
        test("abc");
    }
    public static String test(String letters){
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<letters.length(); i++){
            if(letters.charAt(i)>='a' && letters.charAt(i) <='z'){
                sb.append((char)(letters.charAt(i) - 32));
            }else {
                sb.append(letters.charAt(i));
            }
        }
        return sb.toString();
    }
}
