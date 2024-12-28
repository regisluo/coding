package com.ttf.A00_review.unionset;

import java.util.ArrayList;
import java.util.List;

/**
 * 305. Number of Islands II
 * Description: https://leetcode.com/problems/number-of-islands-ii/
 */
public class TX042_NumOfIslands2 {
    /**
     * For a given 2D binary matrix, say m rows and n columns, and for a given
     * positions, find the number of islands.
     * @param positions: the positions to be added to the matrix to indicate the islands
     * @return
     */
    public static List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> res = new ArrayList<>();
        UnionSet unionSet = new UnionSet(m, n);
        for (int[] position: positions) {
            int x = position[0];
            int y = position[1];
            res.add(unionSet.add(x, y));
        }
        return res;
    }

    public static class UnionSet {
        private int[] parent;
        private int[] size;
        private int[] help;
        private int count;
        int r; // row
        int c; // column

        UnionSet(int m, int n) {
            r = m;
            c = n;
            int len = m * n;
            parent = new int[len];
            size = new int[len];
            help = new int[len];
            count = 0;
        }

        public int index(int x, int y) {
            return x * c + y;
        }

        public int findHead(int index) {
            int hi = 0;
            while (parent[index] != index) {
                help[hi++] = index;
                index = parent[index];
            }

            // path compression
            for (hi--; hi >= 0; hi--) {
                parent[help[hi]] = index;
            }
            return index;
        }

        public void union(int x1, int y1, int x2, int y2) {
            if (x1 < 0 || x1 >= r || y1 < 0 || y1 >= c || x2 < 0 || x2 >= r || y2 < 0 || y2 >= c) {
                return;
            }
            int x = index(x1, y1);
            int y = index(x2, y2);
            if (size[x] == 0 || size[y] == 0) {
                // either of the two nodes is not in the matrix
                return;
            }

            int rootX = findHead(x);
            int rootY = findHead(y);

            if (rootX != rootY) {
                if (size[rootX] >= size[rootY]) {
                    parent[rootY] = rootX;
                    size[rootX] += size[rootY];
                } else {
                    parent[rootX] = rootY;
                    size[rootY] += size[rootX];
                }
                count--;
            }

        }

        public int getCount() {
            return count;
        }

        public int add(int x, int y) {
            int index = index(x, y);
            if (size[index] == 0){
                parent[index] = index;
                size[index] = 1;
                count++;
                union(x, y, x - 1, y);
                union(x, y, x + 1, y);
                union(x, y, x, y - 1);
                union(x, y, x, y + 1);
            }
            return count;
        }
    }

    public static void main(String[] args) {
        int m = 3;
        int n = 3;
        int[][] positions = {
            {0, 0},
            {0, 1},
            {1, 2},
            {2, 1}
        };
        System.out.println(numIslands2(m, n, positions).equals(List.of(1, 1, 2, 3)));
    }
}
