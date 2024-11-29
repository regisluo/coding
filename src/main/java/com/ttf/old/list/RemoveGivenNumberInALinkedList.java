package com.ttf.old.list;

import com.ttf.A01_basic_ds.list.SingleNode;

public class RemoveGivenNumberInALinkedList {

    // remove all the given number in the linked list
    public SingleNode removeAndReturn(SingleNode head, int number){
        SingleNode newHead=head;
        // find out the first number that does not need to be removed
        while (head != null){
            if (head.getValue() != number)
                break;
            head = head.next();
        }
        SingleNode next = head.next();
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
