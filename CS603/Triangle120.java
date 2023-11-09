package CS603;

import java.util.Collections;
import java.util.List;

public class Triangle120 {
  // Sequence Alignment
    // https://leetcode.com/problems/triangle/editorial/

    public int minimumTotal(List<List<Integer>> triangle) {
        // using arrayList in place method
        // i is row j is col
        // time complexity O(n^2), space complexity O(1) since we are using in place

        for (int i = 1; i < triangle.size(); i++) { // i is row
            for (int j = 0; j <= i; j++) { // j is col
                int minAboveLine = Integer.MAX_VALUE;

                // why this line important, it combines 3 condition
                    // j = first index
                    // j = end of row element
                    // j = element between first element and last element
                if (j > 0){ // not include first element in this row, to last element, in this range can only upper and left element, since last element
                    // do not have triangle[i - 1][j]
                    minAboveLine = triangle.get(i - 1).get(j - 1);
                }

                // why this line important
                if (j < i) { // from first element to second last element since first element do no have trangle[i - 1][j - 1]
                    // compare with previous minAboveLine
                    minAboveLine = Math.min(minAboveLine, triangle.get(i - 1).get(j));
                }
                int pathSum = minAboveLine + triangle.get(i).get(j);
                // update inplace path sum
                triangle.get(i).set(j, pathSum);
            }
        }

        List<Integer> list = triangle.get(triangle.size() - 1);
        return Collections.min(list);
    }
}
