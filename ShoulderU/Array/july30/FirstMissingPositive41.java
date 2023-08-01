package ShoulderU.Array.july30;

public class FirstMissingPositive41 {
  public int firstMissingPositive(int[] nums) {
    // https://www.youtube.com/watch?v=4VpBKinOTYA&ab_channel=NareshGupta
    // idea: first add all element into hash set, this is On time complexity and On space compexity but need constand space complexity
    //     HashSet<Integer> set = new HashSet<>();
    //     for (int num : nums) {
    //         set.add(num);
    //     }
    //     int current = 1;
    //     while (set.contains(current)){
    //         current++;
    //     }
    //     return current;
    // }

    // better idea, in the first pass, we mark all num < 0 and nums[i] > nums.length with nums.length + 1, second step start the loop if index = Math.abs(nums[i]) <= nums.length, (only do if index < nums.length)index --, nums[index]= - nums[index]), step three then just check whcih index in the array is not negative, then just return the index of this number + 1 or return default

    // step 1 [3,4,-1,1] -->[3,4,5,1]
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] <= 0 || nums[i] > nums.length) {
        nums[i] = nums.length + 1;
      }
    }

    //step2 [3,4,5,1] ->[-3,4,-5,-1]
    for (int i = 0; i < nums.length; i++) {
      int index = Math.abs(nums[i]);
      if (index <= nums.length) {
        index--;
        if (nums[index]> 0) {
          nums[index] = -nums[index];
        }
      }
    }

    //step 3 check index of positive number then just return index + 1
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] > 0) {
        return i + 1;
      }
    }

    // return default like[1,2,3,4] return 5
    return nums.length + 1;
  }
}
