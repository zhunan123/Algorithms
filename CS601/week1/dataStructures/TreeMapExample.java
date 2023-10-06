package week1.dataStructures;

import java.util.TreeMap;

public class TreeMapExample {
    public static void main(String[] args) {
        TreeMap<String, String> sortedMap = new TreeMap<>();
        // TreeMap sorts its keys based on their natural order,
        sortedMap.put("3", "tres");
        sortedMap.put("1", "uno");
        sortedMap.put("2", "dos");
        sortedMap.put("4", "cuantro");
        System.out.println(sortedMap);
        System.out.println(sortedMap.subMap("2", "4"));

        /*
         sorted result will be
        {1=uno, 2=dos, 3=tres, 4=cuantro}
        {2=dos, 3=tres}

        even though we add 3, tres before 1 uno, but since its treeMap and sorted based on key
        * */
    }
}
