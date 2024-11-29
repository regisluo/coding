package com.ttf.old.list;

import com.ttf.A01_basic_ds.list.SingleNode;

public class ReverseSingleLinkedList {

    public static void main(String[] args) {
        SingleNode node1 = new SingleNode(1);
        SingleNode node2 = new SingleNode(2);
        SingleNode node3 = new SingleNode(3);
        SingleNode node4 = new SingleNode(4);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(null);

        SingleNode node = reverseList(node1);
        while (node != null) {
            System.out.println(node.getValue());
            node = node.next();
        }
    }

    /**
     * solution: move the head pointer from beginning to the end step by step.
     * Three pointers needed (head included)
     *
     * @param head
     * @return
     */
    public static SingleNode reverseList(SingleNode head) {
        SingleNode pre = null;
        SingleNode next = null;
        while (head != null) {
            // capture the next node
            next = head.next();
            // process the current node
            head.setNext(pre);
            //move all pointers forward
            pre = head;
            head = next;
        }
        return pre;
    }
}
