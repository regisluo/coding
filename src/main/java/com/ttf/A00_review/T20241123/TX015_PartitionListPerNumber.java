package com.ttf.A00_review.T20241123;

import com.ttf.A01_basic_ds.list.SingleNode;

public class TX015_PartitionListPerNumber {
    /**
     * partition the list per number, all node less than number on the left,
     * the number in the middle, and greater than the number on the right
     * @param head
     * @param number
     */
    public SingleNode partitionListPerNumber(SingleNode head, int number) {
        SingleNode smallHead = null;
        SingleNode smallEnd = null;
        SingleNode equalHead = null;
        SingleNode equalEnd = null;
        SingleNode bigHead = null;
        SingleNode bigEnd = null;
        SingleNode n = head;
        while (n!=null){
            head=head.next();
            n.setNext(null);
            if (n.getValue()<number){
                if (smallHead==null){
                    smallHead = n;
                    smallEnd = n;
                } else {
                    smallEnd.setNext(n);
                    smallEnd = n;
                }
            } else if (n.getValue()==number){
                if (equalHead==null){
                    equalHead = n;
                    equalEnd = n;
                } else {
                    equalEnd.setNext(n);
                    equalEnd = n;
                }
            } else {
                if (bigHead==null){
                    bigHead = n;
                    bigEnd = n;
                } else {
                    bigEnd.setNext(n);
                    bigEnd = n;
                }
            }
            n = head;
        }
        // connect the end to the head
        if (smallEnd!=null) {
            smallEnd.setNext(equalHead);
            equalEnd = equalEnd==null?smallEnd:equalEnd;
        }

        if (equalEnd!=null) {
            equalEnd.setNext(bigHead);
        }
        return smallHead!=null?smallHead:(equalHead!=null?equalHead:bigHead);
    }
}
