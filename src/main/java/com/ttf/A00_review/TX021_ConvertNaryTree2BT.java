package com.ttf.A00_review;

import com.ttf.A01_basic_ds.tree.binary.BinaryTreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class TX021_ConvertNaryTree2BT {
    public static class NaryNode {
        private int value;
        NaryNode[] children;

        public NaryNode(int value){
            this.value = value;
            children= null;
        }
    }
    /**
     * convert an N-ary tree to Binary tree.
     * using level traversal. all sibling nodes
     * using right pointer linked together and linked as
     * the left child of their parent.
     * So level traversal -> queue
     *
     */
    public BinaryTreeNode fromNaryTree(NaryNode root){
        if (root == null){
            return null;
        }

        Queue<NaryNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            NaryNode cur = queue.poll();
            BinaryTreeNode head = fromNarNode(cur);
            BinaryTreeNode children = fromChildren(queue, cur.children);
            head.left = children;
        }

return null;
    }

    private BinaryTreeNode fromChildren(Queue<NaryNode> queue, NaryNode[] children) {
        for (NaryNode node:children){
            queue.add(node);

        }
        return null;
    }


    private BinaryTreeNode fromNarNode(NaryNode root) {
     return null;
    }


}
