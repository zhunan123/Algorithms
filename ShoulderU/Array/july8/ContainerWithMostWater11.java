package ShoulderU.Array.july8;

public class ContainerWithMostWater11 {

  public int maxArea(int[] height) {
    // use two pointer to find the highest in each side, then we can calculate the maximum area
    // then if we find hight[left] < hight[right], calculate max area, left = left + 1
    // hight[left] > hight[right], calculate max area, right = right - 1

    int maxArea = 0;
    int left = 0;
    int right = height.length - 1;

    while (left < right) {
      if (height[left] < height[right]) {
        maxArea = Math.max(maxArea, height[left] * (right - left));
        left++;
      } else {
        maxArea = Math.max(maxArea, height[right] * (right - left));
        right--;
      }
    }
    return maxArea;
  }
}
