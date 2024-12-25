package com.ttf.A00_review.T20241130;

import com.ttf.A01_basic_ds.tree.binary.BinaryTreeNode;

import java.nio.file.attribute.FileAttribute;

public class TX031_FindLowestAncestor {
    /**
     * Find the lowest ancestor for given two nodes in a BT
     */
    public BinaryTreeNode getLowestAncestor(BinaryTreeNode head,
                                            BinaryTreeNode a,
                                            BinaryTreeNode b) {
        return process(head, a, b).ancestor;
    }

    private Info process(BinaryTreeNode x, BinaryTreeNode a, BinaryTreeNode b) {
        if (x == null) {
            return new Info(false, false, null);
        }

        Info leftInfo = process(x.left, a, b);
        Info rightInfo = process(x.right, a, b);

        boolean hasA = x == a || leftInfo.hasA || rightInfo.hasA;
        boolean hasB = x == b || leftInfo.hasB || rightInfo.hasB;
        BinaryTreeNode ans = null;
        if (leftInfo.ancestor != null) {
            ans = leftInfo.ancestor;
        } else if (rightInfo.ancestor != null) {
            ans = rightInfo.ancestor;
        } else {
            if (hasA && hasB) {
                ans = x;
            }
        }
        return new Info(hasA, hasB, ans);

    }


    private static class Info {
        boolean hasA;
        boolean hasB;
        BinaryTreeNode ancestor;

        public Info(boolean hasA, boolean hasB, BinaryTreeNode ans) {
            this.hasA = hasA;
            this.hasB = hasB;
            this.ancestor = ans;
        }

    }

    public static void main(String[] args) {
        TX031_FindLowestAncestor ins = new TX031_FindLowestAncestor();

        BinaryTreeNode head = new BinaryTreeNode(9);
        BinaryTreeNode left1= new BinaryTreeNode(5);
        BinaryTreeNode right1=new BinaryTreeNode(20);

        BinaryTreeNode left11= new BinaryTreeNode(3);
        BinaryTreeNode left12 = new BinaryTreeNode(6);
        BinaryTreeNode right21=new BinaryTreeNode(19);
        BinaryTreeNode right22=new BinaryTreeNode(21);

        head.left=left1;
        head.right=right1;
        left1.left=left11;
        left1.right = left12;

        right1.left=right21;
        right1.right = right22;

        System.out.println("9="+ins.getLowestAncestor(head, left1, right1));
        System.out.println("5="+ins.getLowestAncestor(head,left11, left12));
        System.out.println("9="+ins.getLowestAncestor(head,left11, right21));
        System.out.println("3="+ins.getLowestAncestor(head,left11, left11));
    }
}
