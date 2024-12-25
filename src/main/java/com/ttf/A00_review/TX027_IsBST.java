package com.ttf.A00_review;

import com.ttf.A01_basic_ds.tree.binary.BinaryTreeNode;

// check if it is binary search tree
public class TX027_IsBST {
    /**
     *
     */
    public boolean isBST(BinaryTreeNode root) {
        if (root==null){
            return true;
        }
        return process(root).isBST;
    }

    public Info process(BinaryTreeNode n) {
        if (n == null) {
            // it is hard to tell the max and min, thus return null
            // which means need to process null explicitly
            return null;
        }
        Info leftInfo = process(n.left);
        Info rightInfo = process(n.right);
        boolean isBST = true;
        int max = n.value;
        int min = n.value;
        if (leftInfo != null) {
            boolean leftIsBST = leftInfo.isBST;
            isBST = leftIsBST && (n.value > leftInfo.max);
            max = Math.max(max, leftInfo.max);
            if (rightInfo != null)
                max = Math.max(max, rightInfo.max);
        }
        if (rightInfo != null) {
            boolean rightIsBST = rightInfo.isBST;
            isBST = isBST && rightIsBST && (n.value < rightInfo.min);
            min = Math.min(min, rightInfo.min);
            if (leftInfo != null)
                min = Math.min(min, leftInfo.min);
        }
        return new Info(isBST, max, min);
    }

    public static class Info {
        private boolean isBST;
        private int max;
        private int min;

        public Info(boolean i, int ma, int mi) {
            this.isBST = i;
            this.max = ma;
            this.min = mi;
        }
    }

    public static void main(String[] args) {
        TX027_IsBST instance = new TX027_IsBST();
        BinaryTreeNode head1 = BinaryTreeNode.getBT(true);
        System.out.println("Expected false: "+instance.isBST(head1));

        BinaryTreeNode head2 = BinaryTreeNode.getBST();
        System.out.println("Expected true: "+instance.isBST(head2));
    }
}
