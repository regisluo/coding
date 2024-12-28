package com.ttf.A00_review.unionset;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * findHead(T value) is the most important function in UnionSet.
 */
public class TX039_UnionSet<T> {
    private T[] values;
    // per node
    private Map<T, T> parentMap;
    // per set, the Key is the ancestor of the set, the value is the size of the set
    private Map<T, Integer> rankMap;

    public TX039_UnionSet(T[] values) {
        this.values = values;
        parentMap = new HashMap<>();
        rankMap = new HashMap<>();
        for (T value : values) {
            // the parent of each value is itself
            parentMap.put(value, value);
            // the rank of each value is 1
            rankMap.put(value, 1);
        }
    }

    /**
     * There are two important functions in UnionSet:
     * 1. findHead(T value): find the parent of the value
     * 2. union(T value1, T value2): union the two values (this is to union th two sets which
     * are represented by the two values, respectively)
     */

    public T findHead(T value) {
        T ancestor = parentMap.get(value);
        Stack<T> pathValues = new Stack<>();
        pathValues.add(value);
        while (ancestor != parentMap.get(ancestor)) {
            pathValues.add(ancestor);
            ancestor = parentMap.get(ancestor);
        }
        while (!pathValues.isEmpty()) {
            parentMap.put(pathValues.pop(), ancestor); // path compression
        }
        return ancestor;
    }

    public void unionSet(T v1, T v2) {
        T ancestor1 = findHead(v1);
        T ancestor2 = findHead(v2);
        if (ancestor1 != ancestor2) {
            int rank1 = rankMap.get(ancestor1);
            int rank2 = rankMap.get(ancestor2);

            if (rank1 >= rank2) {
                parentMap.put(v2, v1);
                rankMap.put(ancestor1, rank1 + rank2);
                rankMap.remove(ancestor2);
            } else {
                parentMap.put(v1, v2);
                rankMap.put(ancestor2, rank1 + rank2);
                rankMap.remove(ancestor1);
            }
        }
    }

    public boolean isSameSet(T v1, T v2){
        return findHead(v1).equals(findHead(v2));
    }

    public int getSetSize(T v) {
        return rankMap.get(findHead(v));
    }

    // getters
    public T[] getValues() {
        return values;
    }

    public Map<T, T> getParentMap() {
        return parentMap;
    }

    public Map<T, Integer> getRankMap() {
        return rankMap;
    }


    public static void main(String[] args) {
        Integer[] values = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        TX039_UnionSet<Integer> unionSet = new TX039_UnionSet<>(values);
        unionSet.unionSet(1, 2);
        unionSet.unionSet(3, 4);
        unionSet.unionSet(5, 6);
        unionSet.unionSet(7, 8);

        System.out.println(unionSet.getSetSize(1) == 2);
        System.out.println(unionSet.getSetSize(4) == 2);
        System.out.println(unionSet.getSetSize(6) == 2);
        System.out.println(unionSet.getSetSize(7) == 2);

        unionSet.unionSet(1, 3);
        unionSet.unionSet(5, 7);
        System.out.println(unionSet.getSetSize(1) == 4);
        System.out.println(unionSet.getSetSize(8) == 4);

        unionSet.unionSet(1, 5);
        System.out.println(unionSet.getSetSize(1) == 8);
        System.out.println(unionSet.getSetSize(6) == 8);

        unionSet.unionSet(3,9);
        for (int i = 1; i <= 9; i++) {
            System.out.println(unionSet.getSetSize(i) == 9);
        }
    }

}
