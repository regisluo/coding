package com.ttf.A00_review.unionset;

public class TX040_FriendCircle {

    /**
     * friendships is a N*N matrix, friendships[i][j] == 1 means i and j are friends.
     * return the number of friend circles.
     */
    private int findCircleNumber(int[][] friendships) {
        int N = friendships.length;
        Integer[] values = new Integer[N];
        // init values
        for (int i = 0; i < N; i++) {
            values[i] = i;
        }
        TX039_UnionSet<Integer> unionSet = new TX039_UnionSet<>(values);
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (friendships[i][j] == 1) {
                    unionSet.unionSet(i, j);
                }
            }
        }
        return unionSet.getRankMap().size();
    }

    public static void main(String[] args) {
        int[][] friendships = {
            {1, 1, 0},
            {1, 1, 0},
            {0, 0, 1}
        };
        TX040_FriendCircle friendCircle = new TX040_FriendCircle();
        System.out.println(friendCircle.findCircleNumber(friendships)==2);

        int[][] friendships2 = {
            {1, 1, 0},
            {1, 1, 1},
            {0, 1, 1}
        };
        System.out.println(friendCircle.findCircleNumber(friendships2)==1);
    }
}
