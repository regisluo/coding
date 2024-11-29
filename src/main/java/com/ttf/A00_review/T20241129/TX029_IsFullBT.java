package com.ttf.A00_review.T20241129;

import com.ttf.A01_basic_ds.tree.binary.BinaryTreeNode;

public class TX029_IsFullBT {
    /**
     * check if a BT is full BT
     * Definition: from math perspective.
     * BT's height is h, and has 2^h-1 nodes is a full BT.
     */
    public boolean isFull(BinaryTreeNode head) {
        return process(head).isFull;
    }

    public Info process(BinaryTreeNode n) {
        if (n == null) {
            return new Info(true, 0);
        }
        Info leftInfo = process(n.left);
        Info rightInfo = process(n.right);
        boolean isFull = leftInfo.isFull && rightInfo.isFull && leftInfo.height == rightInfo.height;
        int height = Math.max(leftInfo.height, rightInfo.height) + 1;
        return new Info(isFull, height);
    }

    public static class Info {
        boolean isFull;
        int height;

        public Info(boolean isFull, int height) {
            this.isFull = isFull;
            this.height = height;
        }
    }

    public static void main(String[] args) {
        TX029_IsFullBT ins = new TX029_IsFullBT();
        BinaryTreeNode fullBT = BinaryTreeNode.getBT(true);
        System.out.println("Expected true: "+ins.isFull(fullBT));

        BinaryTreeNode nonfullBT = BinaryTreeNode.getBT(false);
        System.out.println("Expected false: " + ins.isFull(nonfullBT));
    }
}
