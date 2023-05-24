package ShoulderU.Array.May23;

public class MinimumWindowSubstring76 {
    public String minWindow(String s, String t) {
        //define table
        int[] windowTable = new int[128];
        //increment each character in t by 1
        char[] arrS = s.toCharArray();
        char[] arrT = t.toCharArray();
        for (char curChar : arrT) {
            // int type variable will not store a character but its ASCII value, so we can store char letter as index in array since array will convert letter char to ascii number
            windowTable[curChar]++;
        }
        //define pointers
        int left = 0;
        int right = 0;
        //define minLen, counter
        int minLen = Integer.MAX_VALUE;
        int counter = 0;
        //define ans
        String ans = "";
        //find the min window
        while (right < s.length()) {
            //expand the window
            // update the window table
            char currentChar = arrS[right];
            windowTable[currentChar]--;
            if (windowTable[currentChar] >= 0) { //means we found the character in t
                counter++;
            }
            //shrink the window
            while (counter == t.length()) { //all character in t is found, need to shrink
                // update minLen and ans
                int currentLen = right - left + 1;
                if (currentLen < minLen) {
                    minLen = currentLen;
                    ans = s.substring(left, right + 1);
                }
                // update the windowTable, when shrink, increment the character in window table and decrease the counter
                char leftChar = arrS[left];
                windowTable[leftChar]++;
                if (windowTable[leftChar] > 0) {
                    counter--;
                }
                left++;
            }

            right++;
        }

        //return ans
        return ans;
    }
}
