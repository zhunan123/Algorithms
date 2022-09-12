public class Palindrome {
    public static void main (String[] args){
        int origin_num = 1534236469;
        testPalindrome(origin_num);
    }
    public static int testPalindrome(int origin_num) {

        int number = origin_num;
        long reverse = 0;

        while (number != 0) {
            int remainder = number % 10;
            reverse = reverse * 10 + remainder;
            number /= 10;
        }

        if(reverse < Integer.MIN_VALUE || reverse > Integer.MAX_VALUE){
            return 0;
        }
        return (int)reverse;

//        if (origin_num == reverse){
//            System.out.println("true");
//            return true;
//        }
//        System.out.println("false");
//        return false;
    }
}