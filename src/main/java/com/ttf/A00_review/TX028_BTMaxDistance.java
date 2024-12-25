package com.ttf.A00_review;

import com.ttf.A01_basic_ds.tree.binary.BinaryTreeNode;

public class TX028_BTMaxDistance {
    /**
     * 返回二叉树的节点最大距离.
     * The definition of distance is the count of the linking-nodes, which
     * means it is the longest path between two nodes.
     * 这个可以变通：算法是返回节点数（含头含尾），但如果要求是返回路径数，则减一即可。
     * 比如，5个节点，中间有4个edge，所以5-1=4.
     */
    /**
     * thoughts: for a given node x, the max distance may pass x or may not.
     * 1. if pass x: the max = maxHeight(left) + maxHeight(right) + 1
     * 2. if not pass x: then the max should appear in either left or right.
     *      max = Math.max(maxHeight(left), maxHeight(right))
     * @param root
     * @return
     */
     public int maxDistance(BinaryTreeNode root) {
            return process(root).maxDis;
     }

     public Info process(BinaryTreeNode x) {
         if (null== x) {
             return new Info(0, 0);
         }
         Info leftInfo = process(x.left);
         Info rightInfo = process(x.right);
         int height = Math.max(leftInfo.height, rightInfo.height);
         int maxDistance = Math.max(Math.max(leftInfo.maxDis, rightInfo.maxDis),
                 leftInfo.height+rightInfo.height +1);
         return new Info(maxDistance, height);
     }

     public static class Info {
         int maxDis;
         int height;
         public Info(int maxD, int h){
             this.maxDis = maxD;
             this.height = h;
         }
     }


}
