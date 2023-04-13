package CS545.week10;

public class Graph {
    private Edge[] graph; //adjacency list for this graph that stores all nodes

    public static class Edge {
        private int neighbor;
        private Edge next;
        public Edge(int neighbor) {
            this.neighbor = neighbor;
            next = null;
        }
    }

    public Graph(int numVertices) {
        graph = new Edge[numVertices];
    }

    public void addEdge(int vertexId, Edge edge) {
        //add the new Edge originated from vertexId
        //adds the given edge as an outgoing edge from the given vertex
        //add will to the head of linkedlist

        //idea: found previous head, make the graph[vertexId] to new graph, this means make new edge to head
        //then connect new head to previous

        Edge head = graph[vertexId]; //head of linkedlist for this node
        graph[vertexId] = edge; // insert in front, this is actual head

        if (head != null) {
            edge.next = head;
        }
    }

    public int getNumVertices() {
        return graph.length;
    }

    public int totalNumberOfEdges() {
        //idea: create a count variable, go through each vertexId, and linkedlist within this vertexId, and add count
        int numEdges = 0;
        for (int vertexId = 0; vertexId < graph.length; vertexId++) {
            Edge head = graph[vertexId];
            while (head != null) {
                numEdges++;
                head = head.next;
            }
        }
        return numEdges;
    }

    public boolean hasEdge(int vertexId1, int vertexId2) {
        //check if vertexId2 is the edge of vertexId 1, or if vertexId1 has edge vertexId2,
        //so we only need to started from head of vertexId1
        Edge head = graph[vertexId1];
        while (head != null) {
            if (head.neighbor == vertexId2) {
                return true;
            }
            head = head.next;
        }
        return false;
    }

    public boolean isBidirectional(int vertexId1, int vertexId2) {
        if (hasEdge(vertexId1, vertexId2) && hasEdge(vertexId2, vertexId1)) {
            return true;
        }
        return false;
    }

    public int countIncomingEdges(int vertexId) {
        //this method will count incoming edges which means count incoming arrow from whatever nodes to this particular vertexId

        int countIncomingEdge = 0;
        for (int id = 0; id < graph.length; id++) {
            Edge head = graph[0];
            while (head != null) {
                if (head.neighbor == vertexId) {
                    //means in this linkedlist originated from graph[id], we found the incoming edges originates from the graph[id] to the particular vertexId
                    countIncomingEdge++;
                    break;
                }
                head = head.next;
            }
        }
        return countIncomingEdge;
    }
}
