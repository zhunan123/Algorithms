package week4.DP;

public class ComputeMaxWeightRecursive {
    // this is weight interval schedule, and aim to find the maximum sum value of wights given n intervals

    //p[n] array for assign the latest prior job that is compatible with current job
    static int[] p = new int[]{};
    //w[n] is the weight array with each time interval j
    static int[] w = new int[]{};

    public int computeMaxWeight(int n) { // find max weight optimal solution given n jobs
        //base case
        if (n == 0) {
            return 0;
        }

        return Math.max(computeMaxWeight(n - 1), computeMaxWeight(p[n]) + w[n]);
    }

}
