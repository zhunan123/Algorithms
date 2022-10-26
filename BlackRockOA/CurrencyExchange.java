package BlackRockOA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class CurrencyExchange {
    /**
     * Given A list of foreign exchange rates, A selected Currency, A target currency
     * Your goal is to calculate the max amount of the target currency to 1 unit of the selected currency through the FX
     * transactions, Assume all transations are free and done immediately. if you cannot finish the exchange, return -1.0.
     *
     * 输入：
     * you will be provided a list of fx rates, a selected currency, and a target currency;
     * for example:
     * FX rates list:
     *  USD to JPY 1 to 109;
     *  USD to GBP 1 to 0.71;
     *  GBP to JPY 1 to 155;
     * Original currency: USD;
     * target currency: JPY
     *
     * 输出：
     * Calculated the max target currency Will can get;
     * for example:
     * USD to JPY -> 109
     * USD to GBP to JPY = 0.71 * 155 = 110.05 > 109,
     * so the max value will be 110.05;
     * */

    public static double solve(Map<String, Map<String, Double>> map, String now, String end, double value) {
        double res = Double.MIN_VALUE;
        if (now.equals(end)) {
            return value;
        }
        if (map.containsKey(now)) {
            for (String next : map.get(now).keySet()) {
                res = Math.max(res, solve(map, next, end, value * map.get(now).get(next)));
            }
        }
        return res;
    }

    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
        BufferedReader in = new BufferedReader(reader);
        String line;
        Map<String, Map<String, Double>> map = new HashMap<>();
        String[] trans = in.readLine().split(";");
        String from = in.readLine();
        String to = in.readLine();
        for (String t : trans) {
            String[] attrs = t.split(",");
            map.putIfAbsent(attrs[0], new HashMap<>());
            map.get(attrs[0]).put(attrs[1], Double.valueOf(attrs[2]));
        }
        double res = solve(map, from, to, 1.0);
        if (res == Double.MIN_VALUE) {
            System.out.println(-1.0);
        } else {
            System.out.println(res);
        }
    }
}
