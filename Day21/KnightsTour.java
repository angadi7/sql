package com.Day21;

public class KnightsTour {
    private static final int N = 8;

    // Possible moves for a knight
    private static final int[] xMove = {2, 1, -1, -2, -2, -1, 1, 2};
    private static final int[] yMove = {1, 2, 2, 1, -1, -2, -2, -1};

    public static void main(String[] args) {
        int[][] board = new int[N][N];

        // Initialize the chess board
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = -1;
            }
        }

        // Starting position
        int moveX = 0;
        int moveY = 0;
        board[moveX][moveY] = 0;

        if (solveKnightsTour(board, moveX, moveY, 1)) {
            printBoard(board);
        } else {
            System.out.println("No solution exists");
        }
    }

    public static boolean solveKnightsTour(int[][] board, int moveX, int moveY, int moveCount) {
        if (moveCount == N * N) {
            return true;
        }

        for (int k = 0; k < 8; k++) {
            int nextX = moveX + xMove[k];
            int nextY = moveY + yMove[k];

            if (isSafe(nextX, nextY, board)) {
                board[nextX][nextY] = moveCount;
                if (solveKnightsTour(board, nextX, nextY, moveCount + 1)) {
                    return true;
                } else {
                    board[nextX][nextY] = -1; // Backtracking
                }
            }
        }
        return false;
    }

    public static boolean isSafe(int x, int y, int[][] board) {
        return (x >= 0 && x < N && y >= 0 && y < N && board[x][y] == -1);
    }

    public static void printBoard(int[][] board) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(board[i][j] + "\t");
            }
            System.out.println();
        }
    }
}

