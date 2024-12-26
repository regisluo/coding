package com.ttf.A00_review.unionset;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * findAncestor(T value) is the most important function in UnionSet.
 */
public class TX039_UnionSet<T> {
    private T[] values;
    private Map<T, T> parentMap;
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
     * 1. findAncestor(T value): find the parent of the value
     * 2. union(T value1, T value2): union the two values (this is to union th two sets which
     * are represented by the two values, respectively)
     */

    private T findAncestor(T value) {
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

    private void unionSet(T v1, T v2) {
        T ancestor1 = findAncestor(v1);
        T ancestor2 = findAncestor(v2);
        if (ancestor1 != ancestor2) {
            int rank1 = rankMap.get(v1);
            int rank2 = rankMap.get(v2);

            if (rank1 > rank2) {
                parentMap.put(v2, v1);
                rankMap.put(v1, rank1 + rank2);
                rankMap.remove(v2);
            } else {
                parentMap.put(v1, v2);
                rankMap.put(v2, rank1 + rank2);
                rankMap.remove(v1);
            }
        }
    }

    private int getSetSize(T v) {
        return rankMap.get(findAncestor(v));
    }

}
