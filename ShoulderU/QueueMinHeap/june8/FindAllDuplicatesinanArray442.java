package ShoulderU.QueueMinHeap.june8;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindAllDuplicatesinanArray442 {
    public List<Integer> findDuplicates(int[] nums) {
        // time complexity on, use extra n in space
        Set<Integer> set = new HashSet<>();
        List<Integer> ans = new ArrayList<>();

        for (int num : nums) {
            if (set.contains(num)) {
                ans.add(num);
            } else {
                set.add(num);
            }
        }
        return ans;
    }
}
