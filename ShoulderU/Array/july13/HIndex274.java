package ShoulderU.Array.july13;

import java.util.Arrays;

public class HIndex274 {
    public int hIndex(int[] citations) {
        // need to find max h that is to have h paper and citated at least h times
        // [3,0,6,1,5] we find max 3 paper and citated at least 3 times
        // sort the citations, start from end index since we want the maximum, for each i citation, check the count(count is when citations[index] > i) if >= i, means  i people citated this paper at least i times
        // [0,1,3,5,6]

        // sorting the citations in ascending order
        Arrays.sort(citations);
        // finding h-index by linear search
        int i = 0;
        while (i < citations.length && citations[citations.length - 1 - i] > i) {
            i++;
        }
        return i; // after the while loop, i = i' + 1
    }
}
