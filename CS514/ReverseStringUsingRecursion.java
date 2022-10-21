package CS514;



public class ReverseStringUsingRecursion {
    public String ReverseStringUsingRecursion(String s) {
        if (s.length() == 1) {
            return s;
        } else {
            return ReverseStringUsingRecursion(s.substring(1, s.length())) + s.charAt(0);
        }
    }

    public static void main(String[] args) {
        ReverseStringUsingRecursion re = new ReverseStringUsingRecursion();
        String res = re.ReverseStringUsingRecursion("HELLO");
        System.out.println(res);
    }
}