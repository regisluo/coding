package com.ttf.A00_review;

import com.ttf.A01_basic_ds.tree.binary.BinaryTreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class TX022_BTMaxWidth {

    /**
     * find the max width of a BT.
     * Level traversal, and record the number of nodes in each level,
     * return the max number
     */
    public static int btMaxWidth(BinaryTreeNode head) {
        // first step: level traversal
        if (null == head) {
            return 0;
        }
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(head);
        int curLevelCount = 1;
        int i=0;
        int nextLevelCount = 0;
        int max = 0; // the final max width to be returned
        while (!queue.isEmpty()) {
            BinaryTreeNode cur = queue.poll();
            i++;
            if (cur.left!=null){
                nextLevelCount++;
                queue.add(cur.left);
            }
            if (cur.right!=null){
                nextLevelCount++;
                queue.add(cur.right);
            }
            // process cur
            if (i>=curLevelCount){
                // arrives the last node of the cur level
                max = Math.max(max, curLevelCount);
                curLevelCount = nextLevelCount;
                nextLevelCount = 0;
                i=0;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        BinaryTreeNode head = BinaryTreeNode.getBT(true);
        System.out.println(btMaxWidth(head));
    }
}
