package com.ttf.A00_review.T20241130;

import com.ttf.A01_basic_ds.tree.binary.BinaryTreeNode;

public class TX030_MaxSubBSTSize {
    /**
     * return the max nodes of the sub BST for a given BT
     */
    public int getMaxSizeOfSubBSTFrom(BinaryTreeNode root) {
        if (null == root) {
            return 0;
        }
        return process(root).size;
    }


    public Info process(BinaryTreeNode x) {
        // Two edge cases
        if (x == null) {
            return new Info(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }
        if (x.left == null && x.right == null) {
            return new Info(x.value, x.value, 1);
        }
        Info leftInfo = process(x.left);
        Info rightInfo = process(x.right);
        Info ans = new Info();
        ans.max = x.value;
        ans.min = x.value;
        // if the sub tree rooted as x
        if (x.value > leftInfo.max && x.value < rightInfo.min) {
            ans.max = rightInfo.max;
            ans.min = leftInfo.min;
            ans.size = leftInfo.size + rightInfo.size + 1;
            return ans;
        }
        // if x is not involved, the ans in either left or right
        ans.size = Math.max(leftInfo.size, rightInfo.size);
        // because x.value does not meet the BST property, thus no
        // need to change its value; return ans directly
        return ans;
    }

    public static class Info {
        public int max;
        public int min;
        public int size;
        public Info(){}
        public Info(int max, int min, int size) {
            this.max = max;
            this.min = min;
            this.size=size;
        }
    }

    public static void main(String[] args) {
        BinaryTreeNode bst = BinaryTreeNode.getBST();
        BinaryTreeNode bst2 = BinaryTreeNode.getBT(true);
        TX030_MaxSubBSTSize ins = new TX030_MaxSubBSTSize();
        System.out.println(ins.getMaxSizeOfSubBSTFrom(bst));
        System.out.println(ins.getMaxSizeOfSubBSTFrom(bst2));

    }


}
