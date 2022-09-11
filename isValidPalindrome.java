public class isValidPalindrome {
    public static boolean test(String s) {
        //"abcdcba"

        s = s.toLowerCase();

        int i = 0, j = s.length() - 1;
        while (i < j) {

            char c1 = s.charAt(i);
            if(!Character.isLetterOrDigit(c1)){
                i++;
                continue;
            }
            char c2 = s.charAt(j);
            if(!Character.isLetterOrDigit(c2)){
                j--;
                continue;
            }

            if (c1 != c2){
                return false;
            }

            i++;
            j--;
        }
        return true;
    }
    public static void main(String[] args){
        test("abcdcba");
    }
}
