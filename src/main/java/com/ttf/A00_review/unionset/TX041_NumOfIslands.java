package com.ttf.A00_review.unionset;

public class TX041_NumOfIslands {
    /*
    * 1. DFS
    * given a 2D grid map of '1's (land) and '0's (water), count the number of islands.
     */
    public int numIslands_1(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    infection(grid, i, j, rows, cols);
                }
            }
        }
        return count;
    }

    /**
     * O(m*n): best solution
     */
    private void infection(char[][] grid, int i, int j, int rows, int cols) {
        if (i < 0 || i >= rows || j < 0 || j >= cols || grid[i][j] != '1') {
            return;
        }
        grid[i][j] = '2';
        infection(grid, i - 1, j, rows, cols);
        infection(grid, i + 1, j, rows, cols);
        infection(grid, i, j - 1, rows, cols);
        infection(grid, i, j + 1, rows, cols);
    }

    public static void main(String[] args) {
        char[][] grid = {
            {'1', '1', '0', '0', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '1', '0', '0'},
            {'0', '0', '0', '1', '1'}
        };
        TX041_NumOfIslands numOfIslands = new TX041_NumOfIslands();
        System.out.println(numOfIslands.numIslands_1(grid)==3);
    }
}
