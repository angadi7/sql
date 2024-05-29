package com.dynamicprogrammingalgorithms;

public class KnapsackAssign {
    
    public static int Knapsack(int W, int[] weights, int[] values) {
        int n = weights.length;
        int[][] dp = new int[n + 1][W + 1];

        // Initialize the dp array
        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= W; w++) {
                if (i == 0 || w == 0) {
                    dp[i][w] = 0;
                } else if (weights[i - 1] <= w) {
                    dp[i][w] = Math.max(values[i - 1] + dp[i - 1][w - weights[i - 1]], dp[i - 1][w]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        return dp[n][W];
    }

    public static void main(String[] args) {
        int W = 50;
        int[] weights = {10, 20, 30};
        int[] values = {60, 100, 120};
        
        int maxValue = Knapsack(W, weights, values);
        System.out.println("The maximum value that can be put in a knapsack of capacity " + W + " is " + maxValue);
    }
}
