package BFSDFSTree;

public class FibonacciUsingIteration {

    public int Fibonacci(int n) {
        if(n < 1){
            return -1;
        }
        if(n == 1){
            return 0;
        }
        int first = 0;
        int second = 1;
        int count = 2;
        while(count < n){
            int third = first + second;
            first = second;
            second = third;

            count++;
        }
        return second;
    }
}
