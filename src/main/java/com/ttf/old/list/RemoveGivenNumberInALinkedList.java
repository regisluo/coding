package com.ttf.old.list;

import com.ttf.basic_ds.list.Node;

public class RemoveGivenNumberInALinkedList {

    // remove all the given number in the linked list
    public Node removeAndReturn(Node head, int number){
        Node newHead=head;
        // find out the first number that does not need to be removed
        while (head != null){
            if (head.getValue() != number)
                break;
            head = head.next();
        }
        Node next = head.next();
        while (head!=null) {
            if (next.getValue()==number) {
                next = next.next();
                break;
            }
            head.setNext(next);
            next = next.next();
        }
        return newHead;
    }

    public static void main(String[] args) {

    }
}