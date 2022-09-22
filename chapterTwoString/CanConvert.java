package chapterTwoString;

public class CanConvert {
    public static void main(String[] args){
        test("lintcode", "ide");
//        test("adda", "aad");
    }
    public static boolean test(String s, String t){
        if (s == "" && t == ""){
            return true;
        }
        if (s == null){
            return false;
        }
        int n = s.length(), m = t.length();
        int i = 0, j = 0;
        while (i < n && j < m) {
            if (s.charAt(i) == t.charAt(j)) {
                j++;
            }
            i++;
        }
        return j == m;
    }
}
