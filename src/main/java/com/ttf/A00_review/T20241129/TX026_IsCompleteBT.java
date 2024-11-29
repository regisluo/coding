package com.ttf.A00_review.T20241129;

import com.ttf.A01_basic_ds.tree.binary.BinaryTreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class TX026_IsCompleteBT {

    /**
     * level traversal, for a node:
     * 1. if has right no left, return false;
     * 2. if found a node which is not full, then all the following nodes must be leaf, otherwise, return false;
     * 3. if no the above two cases, return true
     */
    public boolean isCompleteBT(BinaryTreeNode node) {
        if (node == null) {
            return true;
        }
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(node);
        // meet an un-full node.
        // either a leaf node; or only has either left or right child
        boolean hasMetUnFull = false;
        while (!queue.isEmpty()) {
            BinaryTreeNode n = queue.poll();
            if ((n.right != null && n.left == null) ||
                 (hasMetUnFull && (!isFull(n))))
                return false;
            if (!isFull(n)){//
                hasMetUnFull=true;
            }
        }
        return true;
    }

    private boolean isFull(BinaryTreeNode node){
        return node.left!=null && node.right!=null;
    }
}
