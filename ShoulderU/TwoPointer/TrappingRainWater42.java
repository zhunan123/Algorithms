package TwoPointer;

public class TrappingRainWater42 {

    // https://www.youtube.com/watch?v=bu1quf2rOp8

    public int trap(int[] height) {

        // find highest bar
        int highest_index = 0;
        for (int i = 1; i < height.length; i++) {
            if (height[i] > height[highest_index]) {
                highest_index = i;
            }
        }

        // find left most bar and find sum of water in left side
        int left_most_bar_height = 0;
        int water_sum = 0;
        for (int i = 0; i < highest_index; i++) {
            if (height[i] > left_most_bar_height) {
                left_most_bar_height = height[i];
            } else {
                water_sum = water_sum + left_most_bar_height - height[i];
            }
        }

        // find sum of water in right side
        int right_most_bar_height = 0;;
        for (int i = height.length - 1; i > highest_index; i--) {
            if (height[i] >= right_most_bar_height) {
                right_most_bar_height = height[i];
            } else {
                water_sum = water_sum + right_most_bar_height - height[i];
            }
        }

        return water_sum;
    }
}
