package ShoulderU.Array.May26;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle118 {
    /**
     * triangle[row][col] = triangle[row - 1][col - 1] + triangle[row - 1][col]
     * */
    public List<List<Integer>> generate(int numRows) {
        // create ans list
        List<List<Integer>> ans = new ArrayList<>();

        //create first row
        List<Integer> first = new ArrayList<>();
        first.add(1);

        ans.add(first);

        // start to loop from second row
        for (int numRow = 1; numRow < numRows; numRow++) {
            List<Integer> currentRow = new ArrayList<>();
            List<Integer> prevRow = ans.get(numRow - 1);

            // add begining 1 to current arraylist
            currentRow.add(1);

            //start fill in the current row that has sum value from the previousRow
            // current row = previousRow[col - 1] + previousRow[col]
            for (int i = 1; i < prevRow.size(); i++) {
                // this line is key
                currentRow.add(prevRow.get(i - 1) + prevRow.get(i));
            }

            // add the trailing 1
            currentRow.add(1);
            ans.add(currentRow);
        }
        return ans;
    }
}
