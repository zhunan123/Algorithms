import java.util.Arrays;

public class Fibonacci {
    public static void main(String[] args) {
        Fibonacci fb = new Fibonacci();
        fb.test(10);
    }

    public int test(int n) {
        // 0, 1, 1, 2, 3
//       int[] arr = new int[n];
//       arr[0] = 0;
//       arr[1] =1;
//       int i = 2;
//       while(i < n){
//           arr[i] = arr[i - 1] + arr[i - 2];
//           i++;
//       }
//       System.out.println(arr[n-1]);
//       return arr[n - 1];

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            if (i == 0 || i == 1) {
                arr[i] = i;
                continue;
            }
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        System.out.println(arr[n-1]);
        return arr[n - 1];
    }
}
