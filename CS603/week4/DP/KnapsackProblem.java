package week4.DP;

public class KnapsackProblem {

    // this is a 2D dimensional DP since need to find max value given n items while managing under a certain weight limit

    /**
     Definition: find the max sum of value while given i items and managing under a weight limits.

     Goal: M[i, w] = find the optimal max sum of values given i item i1, i2, i3....in while under a weight limit w

     Equation:
        M[i, w] =
                    => 0 if i = 0
                    => M[i - 1, w] if wi > w (out of current weight capacity)
                    => max(M[i - 1, w], M[i - 1, w - wi] + vi)  if otherwise (means we will select max value under 2 condition, either exclude this ith item and go next, or include this item and update weight limit and go next)
     * */
}
