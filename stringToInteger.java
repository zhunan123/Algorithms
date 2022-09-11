public class stringToInteger {
    public static void main(String[] args) {
        test("-1234");
    }

    public static int test(String target) {
        //1234
        //-1234

        if(target == null || target.isEmpty()) {
            return 0;
        }

        boolean isNegative = target.charAt(0) == '-';
        int start = isNegative ? 1 : 0;
        int result = 0;
        for(int i = start; i<target.length();i++){
            char ch = target.charAt(i);
            int digit = ch - '0';
            if (!isNegative) {
                result = result * 10 + digit;
            } else {
                result = result * 10 - digit;
            }
        }

        return result;
    }
}
