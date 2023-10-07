package week3.designPattern.comparator;

import java.util.Comparator;

public class ComparatorByBattingAverage implements Comparator<Player> {
    @Override
    public int compare(Player p1, Player p2) {
        if (p1.getBattingAverage() > p2.getBattingAverage()) {
            return 1;
        } else if (p1.getBattingAverage() < p2.getBattingAverage()) {
            return -1;
        } else {
            return 0;
        }
    }
}
