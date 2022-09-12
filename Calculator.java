public class Calculator {
    public int calculate(int a, char op, int b) {
        // write your code here
        if(op == '+'){
            return a + b;
        } else if(op == '-'){
            return a - b;
        } else if(op == '*'){
            return a * b;
        } else {
            return a / b;
        }
    }

    public static void main(String[] args){
        Calculator cal = new Calculator();
        cal.calculate(3, '+' , 4);
    }
}
