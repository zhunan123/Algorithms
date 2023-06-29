package ShoulderU.BinarySearch.june28;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FindSmallestCommonElementinAllRows1198 {
    public int smallestCommonElement(int[][] mat) {
        // We can go through each element in the first row, and then use binary search to check if that element exists in all other rows.
        // Arrays.binarySearch(array, target) only works for sorted array
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < mat[0].length; i++) {
            boolean found = true;
            for (int j = 1; j < mat.length && found; j++) {
                if (Arrays.binarySearch(mat[j], mat[0][i]) >= 0) {
                    found = true;
                } else {
                    found = false;
                }
            }
            if (found) {
                list.add(mat[0][i]);
            }
        }
        Collections.sort(list, (num1, num2) -> num1 - num2);
        if (list.size() == 0) {
            return -1;
        } else {
            return list.get(0);
        }
    }
}
