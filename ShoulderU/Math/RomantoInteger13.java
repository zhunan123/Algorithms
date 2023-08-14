package ShoulderU.Math;

public class RomantoInteger13 {
    public int romanToInt(String s) {
        // https://www.youtube.com/watch?v=BDpP3Y2si7w&ab_channel=%E8%B4%BE%E8%80%83%E5%8D%9A
        // like IV we first subtrasct 2, then in the below adding we add 6, which is I  and V, so 6-2 we got the right answer
        // subtract 4,9,40, 90,400, 900

        int sum = 0;
        // subtract 4,9,40, 90,400, 900
        if (s.indexOf("IV") != -1) {
            sum -= 2;
        }
        if (s.indexOf("IX") != -1) {
            sum -= 2;
        }
        if (s.indexOf("XL") != -1) {
            sum -= 20;
        }
        if (s.indexOf("XC") != -1) {
            sum -= 20;
        }
        if (s.indexOf("CD") != -1) {
            sum -= 200;
        }
        if (s.indexOf("CM") != -1) {
            sum -= 200;
        }
        //add
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'I') {
                sum += 1;
            }
            if (c == 'V') {
                sum += 5;
            }
            if (c == 'X') {
                sum += 10;
            }
            if (c == 'L') {
                sum += 50;
            }
            if (c == 'C') {
                sum += 100;
            }
            if (c == 'D') {
                sum += 500;
            }
            if (c == 'M') {
                sum += 1000;
            }
        }
        return sum;
    }
}
