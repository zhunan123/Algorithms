package CS603;

public class FindtheDuplicateNumber287 {

  public int findDuplicate(int[] nums) {
    // HashSet set = new HashSet<>();
    // for (int i = 0; i < nums.length; i++) {
    //     if (set.contains(nums[i])){
    //         return nums[i];
    //     } else {
    //         set.add(nums[i]);
    //     }
    // }
    // return 0;

    // using reversing index professor provides method
    //You must solve the problem without modifying the array nums and uses only constant extra space.
    for (int i = 0; i < nums.length; i++) {
      int current_number = Math.abs(nums[i]);
      if (nums[current_number] < 0){
        return current_number;
      } else {
        nums[current_number] = 0 - nums[current_number];
      }
    }
    return 0;
  }
}
