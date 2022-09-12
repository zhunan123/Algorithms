
public class RootOfEquation {
    public double[] rootOfEquation(double a, double b, double c) {
        // write your code here;
        double delta = Math.sqrt(Math.pow(b, 2) - 4 * a * c);

        if(delta >0){
            double root1 = (-b + delta) / (2*a);
            double root2 = (-b - delta) / (2*a);
            return new double[]{Math.min(root1, root2), Math.max(root1, root2)};
        }
        if(delta == 0){
            double root = (- b) / (2* a);
            return new double[]{root};
        }
        return new double[0];
    }
}
