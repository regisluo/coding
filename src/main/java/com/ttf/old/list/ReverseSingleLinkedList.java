package com.ttf.old.list;

import com.ttf.A01_basic_ds.list.Node;

public class ReverseSingleLinkedList {

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(null);

        Node node = reverseList(node1);
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
    public static Node reverseList(Node head) {
        Node pre = null;
        Node next = null;
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
