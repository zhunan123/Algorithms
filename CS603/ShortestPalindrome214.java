public class ShortestPalindrome214 {

    // https://www.youtube.com/watch?v=c4akpqTwE5g
    // KMP : https://www.youtube.com/watch?v=V5-7GzOfADQ


    public String shortestPalindrome(String s) {
        String reversedS = new StringBuilder(s).reverse().toString();
        String newS = s + "#" + reversedS;

        // create piArray table, which is length of the longest proper prefix that matches a proper suffix
        int[] piArray = new int[newS.length()];

        // compute piArray
        for (int i = 1; i < newS.length(); i++) {
            int k = piArray[i - 1];
            while (k > 0 && newS.charAt(i) != newS.charAt(k)) { // no match
                k = piArray[k - 1];
            }
            if (newS.charAt(i) == newS.charAt(k)) { // if match is char
                k++;
            }
            piArray[i] = k; // assign
        }

        return reversedS.substring(0, s.length() - piArray[newS.length() - 1]) + s;
    }
}
