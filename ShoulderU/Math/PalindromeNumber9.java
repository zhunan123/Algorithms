package ShoulderU.Math;

public class PalindromeNumber9 {
    public boolean isPalindrome(int x) {
        // idea: basic case if x = 0 is true but x < 0 or x is multiple of 10 return false. then start to reverse the int, initialized a revesed int, while reversed < x get the last digit, get the remaining besides last digit. update the reverse number
        // then if x == reversed means its palindrome
        if (x == 0) {
            return true;
        }

        if (x < 0 || x % 10 == 0) {
            return false;
        }
        int reversed = 0;
        // only reverse half of it say odd like 12321 3 in the mid dont matter, because x = x / 10 and reversed numbner is updating as well
        // we only compare half of it say x originally == 1221, end of while loop x will be 12 and reversed will be 12 as wll so x== reversed
        // For example when the input is 12321, at the end of the while loop we get x = 12, revertedNumber = 123, 3 in the middle wont matter, so we can modified the condition to if reversd /10 == x, reversed == 123 / 10 == 12 == x, its also ok
        while (x > reversed) {
            int last_digit = x % 10;
            x /= 10;
            reversed = reversed * 10 + last_digit;
        }

        if (reversed == x || reversed / 10 == x) {
            return true;
        }
        return false;
    }
}
