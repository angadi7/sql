package travelling;

import java.util.Arrays;

public class TravelingSalesman {

    private static final int INF = Integer.MAX_VALUE;
    private int[][] dp;
    private int[][] graph;
    private int n;

    // Function to find the minimum cost to visit all cities and return to the starting city
    public int FindMinCost(int[][] graph) {
        this.n = graph.length;
        this.graph = graph;
        this.dp = new int[n][1 << n];

        // Initialize the dp array with -1 (indicating uncomputed states)
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        // Start the journey from the first city (index 0) and all cities are unvisited except the first one
        return tsp(0, 1);
    }

    // Helper function for TSP using dynamic programming with memoization
    private int tsp(int city, int mask) {
        // If all cities have been visited, return the cost to return to the starting city
        if (mask == (1 << n) - 1) {
            return graph[city][0];
        }

        // If this state has already been computed, return the stored result
        if (dp[city][mask] != -1) {
            return dp[city][mask];
        }

        int minCost = INF;

        // Try to visit each city from the current city
        for (int nextCity = 0; nextCity < n; nextCity++) {
            // If the next city has not been visited yet
            if ((mask & (1 << nextCity)) == 0) {
                // Calculate the cost for the next state
                int newCost = graph[city][nextCity] + tsp(nextCity, mask | (1 << nextCity));
                minCost = Math.min(minCost, newCost);
            }
        }

        // Store the result in the dp array and return it
        dp[city][mask] = minCost;
        return minCost;
    }

    public static void main(String[] args) {
        // Example usage
        int[][] graph = {
            {0, 10, 15, 20},
            {10, 0, 35, 25},
            {15, 35, 0, 30},
            {20, 25, 30, 0}
        };

        TravelingSalesman tsp = new TravelingSalesman();
        int minCost = tsp.FindMinCost(graph);
        System.out.println("The minimum cost to visit all cities and return to the starting city is: " + minCost);
    }
}

