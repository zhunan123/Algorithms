package ShoulderU.Array.july30;

public class NextPermutation31 {
  public void nextPermutation(int[] nums) {
    // idea: 从后往前便利，找到第一个降序(index)，called x, 处理一下edge condition 321(没有第一个降序，就直接全部反一下321 变成123)， 直接改成123， 然后在从后往前找到第一个比x大的数(index), called y, 然后交换x和y，然后将x(index -> x + 1)之后的数字sort ascending 排列 （交换之前x之后的数字一定是成descending order的，所以可以写一个reverse function 利用2 pointer logn instead of sort nlogn）

    //https://www.youtube.com/watch?v=K-QCteGM-Bk&ab_channel=%E8%B4%BE%E8%80%83%E5%8D%9A

    int x = -1;
    int y = -1;
    for (int i = nums.length - 1; i > 0; i--) {
      if (nums[i] > nums[i - 1]) {
        x = i - 1;
        break;
      }
    }
    if (x == -1) { // 321 -->123 can use reserve as well
      // Arrays.sort(nums);
      reverse(0, nums.length - 1, nums);
      return;
    }
    for (int i = nums.length - 1; i >= 0; i--) {
      if (nums[i] > nums[x]) {
        y = i;
        break;
      }
    }

    swap(x, y, nums);

    reverse(x + 1, nums.length - 1, nums);
  }

  public void swap(int x, int y, int[] nums) {
    int temp = nums[x];
    nums[x] = nums[y];
    nums[y] = temp;
  }
  // 54321
  public void reverse(int x, int y, int[] nums) {
    int left = x, right = y;
    while (x < y) {
      swap(x, y, nums);
      x++;
      y--;
    }
  }
}
