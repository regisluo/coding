package com.ttf.A00_review;

import com.ttf.A01_basic_ds.tree.binary.BinaryTreeNode;

public class TX025_CheckBTBalance {
    /**
     * first think about what are needed?
     * for a given Node n, need to know left is balance and height;
     * need to know right is balance and height;
     */
    // recursive solution
    public boolean isBalanceTree(BinaryTreeNode head) {
        return process(head).isBalanced;
    }
    public Info process(BinaryTreeNode node) {
        if (null==node){ // the edge case normally processed in recursive
            return new Info(true, 0);
        }
        Info left = process(node.left);
        Info right= process(node.right);
        boolean isBalanced = left.isBalanced && right.isBalanced && (Math.abs(left.height-right.height)<=1);
        int height = Math.abs(left.height- right.height);
        return new Info(isBalanced, height);
    }

    public static class Info {
        boolean isBalanced;
        int height;
        public Info(boolean i, int h) {
            this.isBalanced = i;
            this.height = h;
        }
    }
}
