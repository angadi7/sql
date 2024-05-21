package dfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Graphdfs {
    private int vertices;
    private List<List<Integer>> adjList;

    // Constructor
    public Graphdfs(int vertices) {
        this.vertices = vertices;
        adjList = new ArrayList<>(vertices);
        for (int i = 0; i < vertices; i++) {
            adjList.add(new LinkedList<>());
        }
    }

    // Add edge
    public void addEdge(int src, int dest) {
        adjList.get(src).add(dest);
        adjList.get(dest).add(src); // For undirected graph
    }

    // Print adjacency list
    public void printAdjList() {
        for (int i = 0; i < vertices; i++) {
            System.out.print(i + ": ");
            for (Integer neighbor : adjList.get(i)) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }

    // DFS traversal from a given source node (recursive)
    public void DFS(int start) {
        boolean[] visited = new boolean[vertices];
        DFSUtil(start, visited);
    }

    // Utility function for DFS traversal (recursive)
    private void DFSUtil(int node, boolean[] visited) {
        visited[node] = true;
        System.out.print(node + " ");

        for (Integer neighbor : adjList.get(node)) {
            if (!visited[neighbor]) {
                DFSUtil(neighbor, visited);
            }
        }
    }
}


