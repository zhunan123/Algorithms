package ShoulderU.Stack.june4;

public class RemoveAllAdjacentDuplicatesinStringII1209 {
    public String removeDuplicates(String s, int k) {
        int count = 0;
        while (s.length() != 0) {// need to find condition when theres nothing to remove
            // need to track the initial length
            // later on we compare the length after process to remove duplicate
            // if there are no more duplicates the length after process will be the same
            // thus then we know its time to break out the while loop
            int initialLength = s.length(); // set a initial length in order to compare with final string if no change means nothing to remove then break out the while loop
            for (int i = 0; i < s.length(); i++) { // this is need to start from 0 and will considier this case later on when i == 0

                if (i == 0 || s.charAt(i) != s.charAt(i - 1)) {
                    // if i = 0, count = 1, skip s.charAt(i) != s.charAt(i - 1)
                    count = 1;
                } else {
                    // there is duplicate found
                    // here need to increment count and compare to k
                    // otherwise compare will need to take place in next loop which can be ignored
                    if (++count == k) {
                        int removeStartIndex = i - k + 1;
                        int removeEndIndex = i + 1;
                        s = s.substring(0, removeStartIndex) + s.substring(removeEndIndex);

                        break; // start from loop again
                    }
                }
            }
            // need to check s length after remove duplicate process
            // if length is same as the initial lenght before process remove duplicate
            // then we know if time to break out the while loop since no more need
            // to remove
            if (s.length() == initialLength) {
                break;
            }
        }
        return s;
    }
}
