package Week2;

import java.util.LinkedList;

public class dfs {
    double r = 0;
    double current_r = 1;
    LinkedList path = new LinkedList<>();
    LinkedList finalPath = new LinkedList<>();

    public static class Edge {
        private int neighbor;
        private Edge next;
        private double r;
        private int u;
        public Edge(int neighbor) {
            this.neighbor = neighbor;
            next = null;
        }
    }
    LinkedList<Integer> dfs(Edge[] graph, boolean[] visited, int vertexStart, int vertexEnd) {
        Edge currentEdge;
        visited[vertexStart] = true;
        path.add(vertexStart);
        for (currentEdge = graph[vertexStart]; currentEdge != null; currentEdge = currentEdge.next){
            current_r *= currentEdge.r;
            if (!visited[currentEdge.u]){
                if (currentEdge.u == vertexEnd){
                    if (current_r > r){
                        r = current_r;
                        finalPath = path;
                        current_r = 1;
                        path.clear();
                    }
                }
                dfs(graph, visited, currentEdge.u, vertexEnd);
            }
        }
        return finalPath;
    }
}
