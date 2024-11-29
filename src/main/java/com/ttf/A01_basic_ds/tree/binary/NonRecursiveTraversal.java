package com.ttf.A01_basic_ds.tree.binary;

import java.util.Stack;

public class NonRecursiveTraversal {
    // pre-traversal of the given tree;
    // using a stack
    public void pre(BinaryTreeNode root) {
        Stack<BinaryTreeNode> stack = new Stack<>();
        BinaryTreeNode node = root;
        if (root != null) {
            stack.push(node);
            while (!stack.isEmpty()) {
                node = stack.pop();
                visit(node);
                stack.push(node.right);
                stack.push(node.left);
            }
        }
    }

    // post traversal: left, right, head
    // Need two stacks;
    public void post(BinaryTreeNode root) {
        Stack<BinaryTreeNode> stack = new Stack<>();
        Stack<BinaryTreeNode> stack2 = new Stack<>();
        BinaryTreeNode node = root;
        if (root != null) {
            stack.push(node);
            while (!stack.isEmpty()) {
                node = stack.pop();
                stack2.push(node);
                stack.push(node.left);
                stack.push(node.right);
            }
            // now the node in Stack2 is: root, right, left
            // so all pop will be left, right, root
            while (!stack2.isEmpty()) {
                visit(stack2.pop());
            }
        }
    }

    public void in(BinaryTreeNode root) {
        if (root!=null) {
            Stack<BinaryTreeNode> stack = new Stack<>();
            BinaryTreeNode cur = root;
            while (cur != null || !stack.isEmpty()) {
                if (cur != null) { // push all the left
                    stack.push(cur);
                    cur = cur.left;
                } else {
                    cur = stack.pop();
                    visit(cur); // process 'root'
                    cur = cur.right; // move to right
                }
            }
        }
    }

    private void visit(BinaryTreeNode node) {
        System.out.println(node.value);
    }


}
