package CS545.week12;

public class DisjointKruskals {
  int[] parent;

  int find(int x) {

    while (parent[x] != -1) {
      x = parent[x];
    }
    return x;
  }

  int findRecursive(int x) {
    if (parent[x] < 0) {
      return x;
    } else {
      parent[x] = findRecursive(parent[x]); // parent of x will not be just parent of x is the root parent of x because its a recursive call
      //recursion will continue until find the root parent
      return parent[x];
    }


  }

  void union(int x, int y) {
    int root1 = find(x);
    int root2 = find(y);
    if (root1 == root2) {
      return; //they already in the same set
    }
    parent[root1] = root2;
  }

  void unionByHeight(int x, int y) {
    int root1 = find(x);
    int root2 = find(y);
    if (root1 == root2) {
      return; //they already in the same set
    }
    if (parent[root1] < parent[root2]) { //condition1
      parent[root2] = root1;
    } else {
      if (parent[root1] == parent[root2]) { //condition 2 when need to decrement tree height
        parent[root2]--;// decrement root2 tree height and then make root1 points to root2
      }
      //for two condition need to do following
      //1. when parent[root1] == parent[root2], mentioned above
      //2.parent[root1] > parent[root2] other condition need to point root1 to root2
      parent[root1] = root2;
    }
  }
}
