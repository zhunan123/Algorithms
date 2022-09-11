public class Palindrome {
    public static void main (String[] args){
        int origin_num = 8374642;
        testPalindrome(origin_num);
    }
    public static boolean testPalindrome(int origin_num) {

        int number = origin_num;
        int reverse = 0;

        while (number != 0) {
            int remainder = number % 10;
            reverse = reverse * 10 + remainder;
            number /= 10;
        }

        if (origin_num == reverse){
            System.out.println("true");
            return true;
        }
        System.out.println("false");
        return false;
    }
}