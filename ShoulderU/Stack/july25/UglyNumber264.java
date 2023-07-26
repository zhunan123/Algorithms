package ShoulderU.Stack.july25;

public class UglyNumber264 {
    public int nthUglyNumber(int n) {
        // ugly number : [1, 2, 3, 4, 5, 6, 8, 9, 10, 12]

        int[] arr = new int[n];
        arr[0] = 1;
        int multipleOf2 = 0;
        int multipleOf3 = 0;
        int multipleOf5 = 0;
        for (int i = 1; i < n; i++) {
            arr[i] = Math.min(arr[multipleOf2] * 2, Math.min(arr[multipleOf3] * 3, arr[multipleOf5] * 5));
            if (arr[i] == arr[multipleOf2] * 2) {
                multipleOf2++;
            }
            if (arr[i] == arr[multipleOf3] * 3) {
                multipleOf3++;
            }
            if (arr[i] == arr[multipleOf5] * 5) {
                multipleOf5++;
            }
        }
        return arr[n - 1];
    }
}
