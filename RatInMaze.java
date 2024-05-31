package com.Day22;

public class RatInMaze {
    private static final int N = 6;

    public static void main(String[] args) {
        int[][] maze = {
            {1, 0, 0, 0, 0, 0},
            {1, 1, 0, 1, 1, 0},
            {0, 1, 0, 0, 1, 0},
            {1, 1, 1, 0, 1, 1},
            {0, 0, 1, 1, 0, 1},
            {0, 0, 0, 1, 1, 1}
        };

        int[][] solution = new int[N][N];
        if (solveMaze(maze, 0, 0, solution)) {
            printSolution(solution);
        } else {
            System.out.println("No solution exists");
        }
    }

    public static boolean solveMaze(int[][] maze, int x, int y, int[][] solution) {
        // If (x, y) is the goal, return true
        if (x == N - 1 && y == N - 1 && maze[x][y] == 1) {
            solution[x][y] = 1;
            return true;
        }

        // Check if maze[x][y] is valid
        if (isSafe(maze, x, y)) {
            // Mark x, y as part of the solution path
            solution[x][y] = 1;

            // Move forward in x direction
            if (solveMaze(maze, x + 1, y, solution)) {
                return true;
            }

            // If moving in x direction doesn't give solution then
            // move down in y direction
            if (solveMaze(maze, x, y + 1, solution)) {
                return true;
            }

            // If none of the above movements work then
            // BACKTRACK: unmark x, y as part of solution path
            solution[x][y] = 0;
            return false;
        }

        return false;
    }

    public static boolean isSafe(int[][] maze, int x, int y) {
        // Check if x and y are in bounds and maze[x][y] is not 0
        return (x >= 0 && x < N && y >= 0 && y < N && maze[x][y] == 1);
    }

    public static void printSolution(int[][] solution) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(solution[i][j] + " ");
            }
            System.out.println();
        }
    }
}
