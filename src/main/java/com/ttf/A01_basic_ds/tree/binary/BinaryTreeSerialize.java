package com.ttf.A01_basic_ds.tree.binary;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树序列化：先序（后序），层序可以；中序不能实现序列化，这是因为中序遍历与序列化不一定一一对应，即不同的
 * 二叉树有可能对应相同的序列
 *
 *        1         1
 *      2  #      #   2
 *  上面两个二叉树对应的中序遍历都是
 */
public class BinaryTreeSerialize {
    public Queue<String> preSerialize(BinaryTreeNode root) {
        Queue<String> queue = new LinkedList<>();
        preserializeRecur(root, queue);
        return queue;
    }

    private void preserializeRecur(BinaryTreeNode cur, Queue<String> queue) {
        if (cur==null){
            queue.add(null);// null must be added as well
        } else {
            queue.add(String.valueOf(cur.value));
            preserializeRecur(cur.left, queue);
            preserializeRecur(cur.right, queue);
        }
    }

    // re-build a tree from the preSerialize list
    public BinaryTreeNode PreDeSerialize(Queue<String> queue) {
        String value = queue.poll();
        if (value==null) {
            return null;
        }
        BinaryTreeNode node = new BinaryTreeNode(Integer.valueOf(value));
        node.left = PreDeSerialize(queue);
        node.right = PreDeSerialize(queue);
        return node;
    }
}
