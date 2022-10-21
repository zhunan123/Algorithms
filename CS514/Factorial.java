package CS514;

public class Factorial {
    public int Factorial(int x) {
        if (x < 0) {
            throw new IllegalArgumentException();
        } else if (x == 0) {
            return 1;
        } else {
            return x * Factorial(x - 1);
        }
    }
}