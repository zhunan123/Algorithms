package Graph;

import java.util.PriorityQueue;

public class CheapestFlightsWithinKStopsDijkstra787 {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // in this case use modified Dijkstra, but should use Bellman-Ford and is better
        // 1.build greaph adjacency matrix
        //2. use dijkstra alogirithms, poll() min weighted path
        // heap[price, currentPlace, remainingStops]
        // graph[startCityt][endCity] = price
        // this will have time limit error with Dijkstra approach since have k stops restricted
        // need to use bellman-ford

        int[][] graph = new int[n][n];
        for (int[] f : flights) {
            graph[f[0]][f[1]] = f[2];
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.add(new int[]{0, src, k});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int price = current[0];
            int currentPlace = current[1];
            int remainingStops = current[2];

            if (currentPlace == dst) {
                return price;
            }

            if (remainingStops >= 0) {
                for (int i = 0; i < n; i++) {
                    if (graph[currentPlace][i] > 0) {
                        pq.add(new int[]{price + graph[currentPlace][i], i, remainingStops - 1});
                    }
                }
            }
        }
        return -1;
    }
}
