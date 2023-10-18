package Graph;

public class RedundantConnection684 {
    public class UnionFind {
        int[] parents;
        int[] ranks;

        public UnionFind(int n) {
            parents = new int[n];
            ranks = new int[n];

            for (int i = 0; i < n; i++) {
                parents[i] = i;
                ranks[i] = 1;
            }
        }

        public boolean union(int x, int y) {
            int xParent = find(x);
            int yParent = find(y);

            if (xParent == yParent) {
                return false;
            }

            if (ranks[xParent] > ranks[yParent]) {
                parents[yParent] = xParent;
            } else if (ranks[xParent] < ranks[yParent]) {
                parents[xParent] = yParent;
            } else {
                parents[yParent] = xParent;
                ranks[xParent]++;
            }

            return true;
        }

        public int find(int node) {
            if(node == parents[node]) {
                return node;
            }
            return find(parents[node]);
        }
    }
    public int[] findRedundantConnection(int[][] edges) {
        UnionFind node = new UnionFind(edges.length + 1);

        for(int[] edge : edges){
            if(!node.union(edge[0], edge[1])){
                return edge;
            }
        }

        return new int[]{-1, -1};
    }
}
