package com.ttf.A01_basic_ds.tree.binary;

import java.util.LinkedList;
import java.util.Queue;

public class LevelTraversal {
    public void levelTraversal(BinaryTreeNode root) {
        if (root==null){
            return;
        }
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            BinaryTreeNode cur = queue.poll();
            cur.visit();
            if (cur.left!=null){
                queue.add(cur.left);
            }
            if (cur.right!=null) {
                queue.add(cur.right);
            }
        }
    }
}
