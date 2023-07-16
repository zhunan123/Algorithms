package ShoulderU.Array.july14;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IntersectionofTwoArrays349 {
  public int[] intersection(int[] nums1, int[] nums2) {

    Set<Integer> set1 = new HashSet<>();
    for (int num : nums1) {
      set1.add(num);
    }
    Set<Integer> set2 = new HashSet<>();
    for (int num : nums2) {
      set2.add(num);
    }

    List<Integer> list = new ArrayList<>();

    for (int num : set2) {
      if (set1.contains(num)) {
        list.add(num);
      }
    }

    int[] res = new int[list.size()];
    for (int i = 0; i < res.length; i++) {
      res[i] = list.get(i);
    }

    return res;
  }
}
