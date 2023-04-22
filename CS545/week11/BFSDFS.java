package CS545.week11;

import CS545.week6.queue.ImplementQueueUsingArray;

import java.util.Stack;

public class BFSDFS {

    private Edge[] graph; //adjacency list for this graph that stores all nodes

    public static class Edge {
        private int neighbor;
        private Edge next;
        public Edge(int neighbor) {
            this.neighbor = neighbor;
            next = null;
        }
    }

    public BFSDFS(int numVertices) {
        graph = new Edge[numVertices];
    }

    void dfsRecursive(Edge[] graph, int vertexId, boolean[] visited) {
        //print when visit a node
        System.out.print("visiting node: " + vertexId); //this vertexId is the source vertex
        Edge temp;
        visited[vertexId] = true;

        for (temp = graph[vertexId]; temp != null; temp = temp.next) {
            if (!visited[temp.neighbor]) {
                dfsRecursive(graph, temp.neighbor, visited);
            }
        }
        System.out.println("here is when we do the backtracking");
    }

    void dfsStack(Edge graph[], int vertexId, boolean visited[]) {
        Edge temp;
        Stack<Integer> stack = new Stack<>();
        stack.push(vertexId);


        while (!stack.isEmpty()) {
            int vertex = stack.pop();
            System.out.print("visiting vertex: " + vertex);
            visited[vertex] = true;

            temp = graph[vertex];
            while (temp != null) {
                if (!visited[temp.neighbor]) {
                    visited[temp.neighbor] = true;
                    stack.push(temp.neighbor);
                }
                temp = temp.next;
            }
        }
    }

    void bfsQueue(Edge graph[], int vertexId, boolean visited[]) {
        ImplementQueueUsingArray queue = new ImplementQueueUsingArray();
        queue.enqueue(vertexId);

        while (!queue.isEmpty()) {
            int vertex = (int) queue.dequeue();
            Edge temp = graph[vertex];

            while (temp != null) {
                if (!visited[temp.neighbor]) {
                    visited[temp.neighbor] = true;
                    queue.enqueue(temp.neighbor);
                }
                temp = temp.next;
            }

        }
    }
}
