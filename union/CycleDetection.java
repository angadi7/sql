package union;

public class CycleDetection {
    public static boolean hasCycle(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            if (!uf.union(u, v)) {
                return true;  // Cycle detected
            }
        }

        return false;  // No cycle found
    }

    public static void main(String[] args) {
        int n = 5;  // Number of vertices
        int[][] edges = {
            {0, 1},
            {1, 2},
            {2, 3},
            {3, 4},
            {4, 0},
          
            
            
        };

        boolean result = hasCycle(n, edges);
        if (result) {
            System.out.println("Graph contains a cycle");
        } else {
            System.out.println("Graph does not contain a cycle");
        }
    }
}
