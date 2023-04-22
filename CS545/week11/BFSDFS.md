* DFS BFS traversal in graph
  * #1 Recursive version on DFS
    * we colored the node if all the neighbor nodes are visited, then we need to do the backtracking and color the node, means go back to the previous node.
    * if in a connected graph, when we backtrack to original vertex source and all the neighbor nodes are visited. and we are done. but if it's not a connected graph so we need start at another vertex source.
    * purpose of backtracking is to explore path to go and find unvisited node
    * when a for loop function is done, means all the nodes is visited. then we need to do backtracking to find next available node
      * it's automatically backtracking when for loop is done since it will go back to the previous node who called this node so dont need to write any backtracking node
      - when we do backtracking, print ")" after finish with for loop
      - if want to print whenever go to next unvisited neighbor, print inside if statement after dfs recursive function.
      - print in the top if every time visit a node
  * #2 non-Recursive version on DFS
  * #1 non-Recursive version on BFS