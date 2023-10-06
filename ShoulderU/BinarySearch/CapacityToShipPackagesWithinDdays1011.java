package BinarySearch;

public class CapacityToShipPackagesWithinDdays1011 {
    public int shipWithinDays(int[] weights, int days) {
        // for this case the left and right pointer should we the weight capacity, if with this weight capacity can ship all packages within d days we reduce the capacity, if with this weight capacity we are not able to ship all the packages within  d days, then we need to increase the weight capacity
        // so the left pointer, the minimum weight should be the max weightof the weights array, so make sure each day the capacity is max weight of array, so means with this capacity we can fit all weight since its the max.
        // and right pointer should be sum of all weight
        //

        int left = 0, right = 0;
        for (int w : weights) {
            left = Math.max(left, w);
            right += w;
        }

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canShip(weights, mid) <= days) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private int canShip(int[] weights, int capacity){
        int countDays = 1;
        int totalW = 0;
        for (int i = 0; i < weights.length; i++) {
            if (totalW + weights[i] <= capacity) {
                totalW += weights[i];
                continue;
            }
            countDays++;
            totalW = weights[i];
        }
        return countDays;
    }
}
