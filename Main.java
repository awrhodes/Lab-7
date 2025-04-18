class Main {
  public static void main(String[] args) {
    String[] vertices = {
          // 0            1                         2
      "Liberal Arts", "Student Services", "Health Careers & Sciences",
      //          3                         4                       5
      "Health Technologies Center", "Recreation Center", "Techonology Learning Center",
      //          6                7
      "Business & Technology", "Theatre"
    };

    int[][] edges = {
      {0,1}, {0, 7}, {0, 6},
      {1, 0}, {1, 5}, {1, 2}, {1, 3},
      {2, 3}, {2, 4}, {2, 1},
      {3, 2}, {3, 1}, {3, 4},
      {4, 2}, {4, 3},
      {5, 1}, {5, 6}, {5, 7},
      {6, 7}, {6, 0}, {6, 5},
      {7, 0}, {7, 6}, {7, 5}
    };

    Graph<String> graph = new UnweightedGraph<>(vertices, edges);
    UnweightedGraph<String>.SearchTree dfs = graph.dfs(graph.getIndex("Business & Technology")); // Get a dfs starting at the Business and Technology Building. Change this if you called it something different in your vertices!

    java.util.List<Integer> searchOrders = dfs.getSearchOrder();
    System.out.println(dfs.getNumberOfVerticesFound() + " vertices are searched in this DFS order:");
    for (int i = 0; i < searchOrders.size(); i++)
      System.out.print(graph.getVertex(searchOrders.get(i)) + " ");
    System.out.println();

    for (int i = 0; i < searchOrders.size(); i++)
      if (dfs.getParent(i) != -1)
        System.out.println("parent of " + graph.getVertex(i) +
          " is " + graph.getVertex(dfs.getParent(i)));

    System.out.println("\n----- Paths -----\n");
    dfs.printPath(3);
    System.out.print("\n\n");
    dfs.printPath(1);
    System.out.print("\n\n");
    dfs.printPath(4);
    System.out.print("\n\n");
    
    System.out.println("\n----- Whole Tree -----\n");
    dfs.printTree();

  }
}