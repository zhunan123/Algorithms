package Week2;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class bfsLinedInConnection {
    private class People {
        private People[] otherConnections;
        private String name;
        private int id;
        public People(People[] otherConnections, String name, int id) {
            this.otherConnections = otherConnections;
            this.name = name;
            this.id = id;
        }

        public People[] getOtherConnections() {
            return otherConnections;
        }

        public String getName() {
            return name;
        }

        public int getId() {
            return id;
        }
    }
    Map<String, Integer> findConnectionDistance(People mySelf, boolean[] visited) {
        Queue<People> queue = new LinkedList<>();
        queue.add(mySelf);
        visited[mySelf.getId()] = true;
        HashMap<String, Integer> map = new HashMap<>();
        int connectionDistance = 0;
        map.put(mySelf.getName(), connectionDistance);

        while (!queue.isEmpty()) {
            People currPeople = queue.poll();
            People[] connections = currPeople.getOtherConnections();
            for (People people : connections) {
                if (!visited[people.getId()]) {
                    visited[people.getId()] = true;
                    queue.add(people);
                    map.put(people.getName(), connectionDistance + 1);
                }
            }
        }
        return map;
    }
}
