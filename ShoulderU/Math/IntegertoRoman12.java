package ShoulderU.Math;

public class IntegertoRoman12 {
    public String intToRoman(int num) {
        // thousands, only up to 3999
        String[] M = {"", "M", "MM", "MMM"};
        // hundreds
        String[] C = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        // tens
        String[] X = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        // digits
        String[] I = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

        // concatenate numbers
        return M[num / 1000] + C[(num / 100) % 10] + X[(num / 10) % 10] + I[num % 10];
    }
}
