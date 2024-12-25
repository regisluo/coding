package com.ttf.A01_basic_ds.tree.binary;

public class BinaryTreeNode {
    public int value;
    public BinaryTreeNode left;
    public BinaryTreeNode right;
    public BinaryTreeNode parent;

    public BinaryTreeNode(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
        this.parent = null;
    }

    public void visit(){
        System.out.println(this.value);
    }

    public boolean isLeaf(){
        return this !=null && (this.left==null && this.right==null);
    }


    public static BinaryTreeNode getBT(boolean isFull){
        BinaryTreeNode head = new BinaryTreeNode(1);
        BinaryTreeNode left1= new BinaryTreeNode(2);
        BinaryTreeNode right1=new BinaryTreeNode(3);

        BinaryTreeNode left11= new BinaryTreeNode(4);
        BinaryTreeNode left12 = new BinaryTreeNode(5);
        BinaryTreeNode right21=new BinaryTreeNode(6);
        if (isFull){
            BinaryTreeNode right22=new BinaryTreeNode(7);
            right1.right = right22;
        }

        head.left=left1;
        head.right=right1;
        left1.left=left11;
        left1.right = left12;
        right1.left=right21;

        return head;
    }

    public static BinaryTreeNode getBST(){
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
        return head;
    }

    @Override
    public String toString(){
        return this!=null? String.valueOf(this.value):"";
    }

}
