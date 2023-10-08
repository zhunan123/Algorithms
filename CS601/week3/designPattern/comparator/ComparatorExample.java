package week3.designPattern.comparator;

import java.util.*;

public class ComparatorExample {

    public static void main(String[] args) {
        Player p1 = new Player("jack", 90.3);
        Player p2 = new Player("marry", 80.3);
        Player p3 = new Player("joe", 70.3);

        /*
            method #1 compare with TreeSet with regular comparator class
        */
        Comparator<Player> comp1 = new Comparator<Player>() { // #1 with regular comparator
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
        };
        TreeSet<Player> sets = new TreeSet<Player>(comp1);
        sets.add(p1);
        sets.add(p2);
        sets.add(p3);
        System.out.println(sets);


        Comparator<Player> comp2 = (player1, player2) -> {  // #2 with lambda expression
            if (player1.getBattingAverage() > player2.getBattingAverage()) {
                return 1;
            } else if (player1.getBattingAverage() < player2.getBattingAverage()) {
                return -1;
            } else {
                return 0;
            }
        };
        TreeSet<Player> sets2 = new TreeSet<Player>(comp2);
        sets2.add(p1);
        sets2.add(p2);
        sets2.add(p3);
        System.out.println(sets2);
        System.out.println("----------------------------------------------------------------");

        /*
            method #2 compare with TreeSet with anonymous comparator class
        */
        Set<Player> sets3 = new TreeSet<Player>(new Comparator<Player>() { // #1 with regular comparator
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
        });
        sets3.add(p1);
        sets3.add(p2);
        sets3.add(p3);
        System.out.println(sets3);


        Set<Player> sets4 = new TreeSet<>((player1, player2) -> { // #2 with lambda expression
            if (player1.getBattingAverage() > player2.getBattingAverage()) {
                return 1;
            } else if (player1.getBattingAverage() < player2.getBattingAverage()) {
                return -1;
            } else {
                return 0;
            }
        });
        sets4.add(p1);
        sets4.add(p2);
        sets4.add(p3);
        System.out.println(sets4);

        System.out.println("----------------------------------------------------------------");

        /*
            method #3 creating a customized comparator class that implements Comparator interface and sort with Collections.sort()
        */
        List<Player> players = new ArrayList<>();
        players.add(p1);
        players.add(p2);
        players.add(p3);

        Collections.sort(players, new ComparatorByBattingAverage()); // regular way

        // anonymous way
        Collections.sort(players, new Comparator<Player>() {
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
        });

        // lambda expression way
        Collections.sort(players, (player1, player2) -> {
            if (player1.getBattingAverage() > player2.getBattingAverage()) {
                return 1;
            } else if (player1.getBattingAverage() < player2.getBattingAverage()) {
                return -1;
            } else {
                return 0;
            }
        });

        System.out.println("----------------------------------------------------------------");
        /*
            method #4 use Comparable<T> to customer compare variables into TreeSet
        */
        class People implements Comparable<People> { // this need to be a class
            double battingAverage;
            public People(double battingAverage) {
                this.battingAverage = battingAverage;
            }

            public double getBattingAverage() {
                return battingAverage;
            }

            @Override
            public int compareTo(People other) {
                if (this.getBattingAverage() > other.getBattingAverage()) {
                    return 1;
                } else if (this.getBattingAverage() < other.getBattingAverage()) {
                    return -1;
                } else {
                    return 0;
                }
            }
        }
        People people1 = new People(123.23);
        People people2 = new People(133.23);
        People people3 = new People(143.23);

        TreeSet<People> sets5 = new TreeSet(); // add people into treeset, the set will be sorted based on Comparable value defined in People class
        sets5.add(people1);
        sets5.add(people2);
        sets5.add(people3);
        System.out.println(sets5);
    }
}
