package TwoPointer;

public class ContainerWithMostWater11 {
    public int maxArea(int[] height) {
        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            if (height[left] < height[right]) {
                maxArea = Math.max(maxArea, height[left] * (right - left));
                left++; //保留右邊最高的，然後查看其他可能性
            } else {
                maxArea = Math.max(maxArea, height[right] * (right - left));
                right--; //保留左邊中最高的
            }
        }

        return maxArea;
    }
}
