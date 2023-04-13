# Graphs

* directed graph
  * connected
  * unconnected
* undirected graph
  * connected
  * unconnected

* strong connected graph -> every node can go to every node
* weakly connected graph -> some node cannot go to particular node, but if we change this directed graph to undirected graph, it's all connected and any node can go anywhere

* graph representation 
  * Adjacency Matrix
    * see the graph in the notebook
      * find node's outgoing arrows originate from node: need to check node's row, 1 means found node
      * find node's incoming arrows: need to check node's column, 1 means found node
      * find node 0's neighbor(outgoing arrow originated from 0), we can check node 0's row, 1 means found node with outgoing arrow from 0 means found neighbor
      * find whose neighbor is node 0, need to check incoming arrow to node 0, so to check node 0's column, 1 means found node

  * Adjacency List
    * first we have all the node listed in column fashion
    * graph is Edge[] graph filled with Edge, graph[0] indicate the head of linkedlist where store all the edges(outgoing arrow) originated from node 0 
      * then if we do graph[0] say here we want to search for edges that originates from node 0, then we can search inside the linkedlist to find desired edges.
      * if we want to add 4, `addEdge(0, new Edge(4))` means add new edge 4 that originates from node 0, and this new edge 4 will be added to head of linkedlist `graph[0]`
    * in the `public class graph`
      * `int neighbor` neighbor more like node.data其实就是node他自己，是一个destination_id, 就是edge id from originate node, 因为linkedlist上面 store edge 就是edge从from originate node to destination. 
      * `Edge next`
    * `graph[vertexId]` will give head of each linkedlist that contains all edges(outgoing arrow) originated from vertexId.
    * vertexId2 is the edge of vertexId1 is there is a edge connected between vertexId1 and vertexId2 and this edge is originated from vertexId1 to vertexId2
    * if edge is bidirectional means the edge between vertexId1 and vertexId2, this edge can go both direction, one can originated from vertexId1 and goes vertexId2 and other can originat4ed from vertexId2 and goes to vertexId1