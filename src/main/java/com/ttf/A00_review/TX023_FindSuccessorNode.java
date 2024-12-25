package com.ttf.A00_review;

import com.ttf.A01_basic_ds.tree.binary.BinaryTreeNode;

public class TX023_FindSuccessorNode {

    /**
     * next node is when in-order travel, the next node of the given node;
     * so for a given node:
     * 1) if has right, then the leftMost node of the right-tree is the next node;
     * 2) if no right, all the way up, if curNode is left of parent, then parent is
     * the next; or if parent is null (cur is root this time), means the given
     * node the right most, then next node is null;
     */
     public BinaryTreeNode findSuccessorNode(BinaryTreeNode node){
         if (node == null) {
             return null;
         }
         if (node.right != null) {
             return getLeftMost(node.right);
         } else {
             BinaryTreeNode parent = node.parent;
             while (parent != null && node == parent.right) {
                 node = parent;
                 parent = node.parent;
             }
             return parent;
         }
     }

    private BinaryTreeNode getLeftMost(BinaryTreeNode node) {
         if (node == null){
             return null;
         }
        while (node.left!=null) {
            node = node.left;
        }
        return node;

    }
}
