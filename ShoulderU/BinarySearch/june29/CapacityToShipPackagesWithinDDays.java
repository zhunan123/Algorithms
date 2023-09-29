package BinarySearch.june29;

public class CapacityToShipPackagesWithinDDays {

    public int shipWithinDays(int[] weights, int days) {
        // for this case the left and right pointer should we the weight capacity, if with this weight capacity can ship all packages within d days we reduce the capacity, if with this weight capacity we are not able to ship all the packages within  d days, then we need to increase the weight capacity
        // so the left pointer, the minimum weight should be the max weightof the weights array, so make sure each day the capacity is max weight of array, so means with this capacity we can fit all weight since its the max.
        // and right pointer should be sum of all weight
        //

        // binary search on the weights
        int left_cap = 0, right_cap = 0;
        for (int w : weights) {
            right_cap += w;
            if (w > left_cap) {
                left_cap = w;
            }
        }

        while (left_cap < right_cap) {
            int mid_cap = left_cap + (right_cap - left_cap) / 2;
            int d = canShip(weights, mid_cap);
            if (d > days) {
                left_cap = mid_cap + 1;
            } else {
                right_cap = mid_cap;
            }
        }

        return left_cap;
    }

    private int canShip(int[] weights, int capacity){
        int dayCount = 1;
        int sum = 0;
        for (int i = 0; i < weights.length; i++) {
            if (sum + weights[i] > capacity){
                dayCount++;
                sum = 0;
            }
            sum += weights[i];
        }
        return dayCount;
    }
}
