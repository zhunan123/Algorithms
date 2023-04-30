package ShoulderU.Graph;

public class FindCenterOfStarGraph {

    /**
     * There is an undirected star graph consisting of n nodes labeled from 1 to n. A star graph is a graph where there is one center node and exactly n - 1 edges that connect the center node with every other node.
     *
     * You are given a 2D integer array edges where each edges[i] = [ui, vi] indicates that there is an edge between the nodes ui and vi. Return the center of the given star graph.
     *
     *
     *
     * Example 1:
     *
     *
     * Input: edges = [[1,2],[2,3],[4,2]]
     * Output: 2
     * Explanation: As shown in the figure above, node 2 is connected to every other node, so 2 is the center.
     * */

    public int findCenter(int[][] edges) {
        // idea is finding the vertex has edges which is equals to edges length, means any other vertes has path on this vertex
        // in this case degree length will be edges length + index 0 + 1(since the biggest number is 1 large than edges length)
        int[] degree = new int[edges.length + 2];

        for (int i = 0; i < edges.length; i++) {
            int[] temp = edges[i];
            degree[temp[0]]++;
            degree[temp[1]]++;
        }

        int index = 0;
        for (int i = 0; i < degree.length; i++) {
            if (degree[i] == edges.length) {
                index = i;
            }
        }

        return index;
    }
}
