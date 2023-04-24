package CS545.week10;

public class Graph2 {

    private Edge[] graph; //adjacency list for this graph that stores all nodes

    public static class Edge {
        private int neighbor;
        private Edge next;
        public Edge(int neighbor) {
            this.neighbor = neighbor;
            next = null;
        }
    }

    public Graph2(int numVertices) {
        graph = new Edge[numVertices];
    }

    public void addEdge(int vertexId, Edge edge) {
        Edge head = graph[vertexId];
        graph[vertexId] = edge;

        if (head != null) {
            edge.next = head;
        }
    }

    public int getNumVertices() {
        return graph.length;
    }

    public int getTotalEdges() {
        int count = 0;
        for (int i = 0; i < graph.length; i++) {
            Edge head = graph[i];
            while (head != null) {
                count++;
                head = head.next;
            }
        }
        return count;
    }

    public boolean hasEdge(int vertexId1, int vertexId2) {
        Edge head = graph[vertexId1];

        while (head != null) {
            if (head.neighbor == vertexId2) {
                return true;
            }
            head = head.next;
        }
        return false;
    }

    public int countIncomingEdges(int vertexId) {
        int count = 0;

        for (int i = 0; i < graph.length; i++) {
            if (i != vertexId) { // for example vertexId 2 will not have outgoing edge to vertexId, so we just skip vertexid 2
                Edge head = graph[i];
                while (head != null) {
                    if (head.neighbor == vertexId) {
                        count++;
                        break;
                    }
                    head = head.next;
                }
            }
        }
        return count;
    }
}
