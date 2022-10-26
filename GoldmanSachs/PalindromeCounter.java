package GoldmanSachs;

public class PalindromeCounter {

    /**
     * A palindrome is a s trying that reads the same from the left and from the right, For example, mom and tacocat are
     * Palindromes, as are any single-character string, given a string ,determine the number of its substrings that are palindromes,
     * Example: the string is s = "tacocat". palindrome substrings are ['t','a','c','o','c','a','t','coc','acoca','tacocat'] there
     * are 10 palindromic substrings.
     * Function description: complete the countPalindromes funtion in the editor. countPalindromes has the following parameter:
     * string s : the string to analyze, Returns: int: and integer that represents the number of palindromic substrings in the
     * given string.
     * */
    public static int countPalindromes(String s) {
        int res = 0;
        int n = s.length();
        char[] c = s.toCharArray();
        boolean[][] dp = new boolean[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i;j < n; j++) {
                dp[i][j] = (c[i] == c[j]) && (j - i <= 2 || dp[i + 1][j - 1]);
                if (dp[i][j]) {
                    res++;
                }
            }
        }
        return res;
    }
}
