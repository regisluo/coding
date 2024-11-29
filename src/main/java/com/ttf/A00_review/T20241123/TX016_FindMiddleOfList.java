package com.ttf.A00_review.T20241123;

import com.ttf.A01_basic_ds.list.SingleNode;
import com.ttf.A01_basic_ds.list.SinglyLinkedList;

public class TX016_FindMiddleOfList {
    public static int findMiddleOfList(SinglyLinkedList list) {
        if (null == list) {
            return 0;
        }
        // two points: quick pointer is twice quicker than slow pointer;
        // both start from the head node
        SingleNode quick = list.head();
        SingleNode slow = quick;
        int position = 1;
        while (quick.next()!=null) {
            int step = 2;
            slow = slow.next();
            position++;
            while (step>0 && quick.next()!=null) {
                quick = quick.next();
                step--;
            }
        }
        return position;
    }

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.add(3);
        list.add(3);
        list.add(3);
        list.add(3);
        list.add(3);
        list.add(3);
        list.add(3);

        System.out.println(findMiddleOfList(list));
    }
}
