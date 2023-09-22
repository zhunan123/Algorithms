package week5.nestedClass.AnonymousClass;

import java.util.*;

public class AnonymousClassExample {

    public static void main(String[] args) {
        // example 1, use comparator to sort the treeSet based on object toString value
        Comparator<Object> comparator = new Comparator<Object>() {
            @Override
            public int compare(Object o1, Object o2) {
                return o1.toString().compareTo(o2.toString());
            }
        };
        // how to use this comparator
        Set<Object> sets = new TreeSet<Object>(comparator);

        System.out.println("---------------------");

        // example 2
        List<Object> list = new ArrayList<>();
        Collections.sort(list, new ComparatorByBattingAverage());

        System.out.println("---------------------");

        // example 3 - Anonymous class
        Collections.sort(list, new Comparator<Object>() {
            @Override
            public int compare(Object o1, Object o2) {

                int result = o1.toString().compareTo(o2.toString());
                if (result > 0) {
                    return 1;
                } else if (result < 0) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });

        System.out.println("---------------------");

        // example 4 - more convenient way
        Collections.sort(list, (o1, o2) -> {
            int result = o1.toString().compareTo(o2.toString());
            if (result > 0) {
                return 1;
            } else if (result < 0) {
                return -1;
            } else {
                return 0;
            }
        });

        System.out.println("---------------------");
        // example - 5
        // approach 1
        Comparator<Student> comparator1 = new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.toString().compareTo(o2.toString());
            }
        };
        // approach 2
        Comparator<Student> comparator2 = (s1, s2) -> s1.toString().compareTo(s2.toString());
        // approach 3
        Comparator<Student> comparator3= (s1, s2) -> {
            // add more statement
            System.out.println("s1" + s1 + "s2" + s2);
            return s1.toString().compareTo(s2.toString());
        };

        System.out.println("------test------");

        // how to use this comparator
        Set<Student> students = new TreeSet<>(comparator3);
        students.add(new Student("jacl", 0));
        students.add(new Student("jawl", 1));
        students.add(new Student("jasl", 2));

        System.out.println(students);
    }
}
