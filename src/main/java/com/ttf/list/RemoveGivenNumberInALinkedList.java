package com.ttf.list;

import com.ttf.ds.list.Node;

public class RemoveGivenNumberInALinkedList {

    // remove all the given number in the linked list
    public Node removeAndReturn(Node head, int number){
        Node newHead=head;
        // find out the first number that does not need to be removed
        while (head != null){
            if (head.getValue() != number)
                break;
            head = head.getNext();
        }
        Node next = head.getNext();
        while (head!=null) {
            if (next.getValue()==number) {
                next = next.getNext();
                break;
            }
            head.setNext(next);
            next = next.getNext();
        }
        return newHead;
    }

    public static void main(String[] args) {

    }
}
