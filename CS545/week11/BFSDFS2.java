package CS545.week11;

import java.util.LinkedList;
import java.util.Queue;

public class BFSDFS2 {

    private Edge[] graph; //adjacency list for this graph that stores all nodes

    public static class Edge {
        private int neighbor;
        private Edge next;
        public Edge(int neighbor) {
            this.neighbor = neighbor;
            next = null;
        }
    }

    public BFSDFS2(int numVertices) {
        graph = new Edge[numVertices];
    }

    public void dfs(Edge[] graph, int vertexId, boolean[] visited) {
        // source vertex is "a"
        visited[vertexId] = true;
        System.out.print("enter vertex id:" + vertexId);

        for (Edge head = graph[vertexId]; head != null; head = head.next) {
            if (!visited[head.neighbor]) {
                dfs(graph, head.neighbor, visited);
            }
        }
        System.out.print("here is when starting backtracking");
    }

    void bfsQueue(Edge graph[], int vertexId, boolean visited[]) {
        visited[vertexId] = true;
        System.out.println("entering: " + vertexId);

        Queue<Integer> queue = new LinkedList<>();
        queue.add(vertexId);

        while (!queue.isEmpty()) {
            Edge head = graph[queue.poll()];

            while (head != null) {
                if (!visited[head.neighbor]) {
                    visited[head.neighbor] = true;
                    queue.add(head.neighbor);
                }
                head = head.next;
            }
        }
    }
}
