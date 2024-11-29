package com.ttf.A01_basic_ds.tree.binary;

public class RecursiveTraversal {
    public void pre(BinaryTreeNode root) {
        if (root!=null){
            visit(root);
            pre(root.left);
            pre(root.right);
        }
    }

    private void visit(BinaryTreeNode root) {
        System.out.println(root.value);
    }

    public void in(BinaryTreeNode root) {
        if (root!=null){
            pre(root.left);
            visit(root);
            pre(root.right);
        }
    }

    public void post(BinaryTreeNode root) {
        if (root!=null){
            pre(root.left);
            pre(root.right);
            visit(root);
        }
    }

}
