package dfs;

public class GraphRepresentationdfs {
    public static void main(String[] args) {
        Graphdfs g = new Graphdfs(5); // Number of vertices are 5
        g.addEdge(0, 1);
        g.addEdge(2, 3);
        g.addEdge(1, 2);
        g.addEdge(3, 4);
        g.addEdge(0, 4);
        g.addEdge(1, 4);
        g.printAdjList();
        
        System.out.println("DFS traversal starting from node 0:");
        g.DFS(0);
    }
}
