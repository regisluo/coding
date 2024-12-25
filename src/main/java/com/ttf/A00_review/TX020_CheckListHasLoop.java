package com.ttf.A00_review;

import com.ttf.A01_basic_ds.list.SingleNode;

/**
 * check a given linked list has loop or not
 */
public class TX020_CheckListHasLoop {
    // return the joint Node if it has loop, otherwise return null
    public SingleNode getLoop(SingleNode head) {
        if (head==null){
            return null;
        }
        SingleNode fast = head;
        SingleNode slow = head;

        // core logic
        while(fast!=null && fast.next()!=null){
            slow = slow.next();
            fast=fast.next().next();
            if (fast ==slow){
                break;
            }
        }
        if (fast==null){
            return null;
        } else {
            fast=head; // move fast back to head
            while (fast!=null && fast!=slow){
                fast=fast.next();
                slow=slow.next();
            }
            return fast;
        }
    }

    public static void main(String[] args) {
        TX020_CheckListHasLoop ins = new TX020_CheckListHasLoop();
       /* SingleNode head1 = new SingleNode(0);
        SingleNode n1 = new SingleNode(1);
        SingleNode n2 = new SingleNode(1);
        head1.setNext(n1);
        n1.setNext(n2);
        n2.setNext(n1);

        SingleNode joint = ins.getLoop(head1);
        System.out.println(joint!=null?joint.getValue():"-1");

*/        //--------single node
     /*   SingleNode head2 = new SingleNode(0);
        head2.setNext(head2);
        SingleNode joint2 = ins.getLoop(head2);
        System.out.println(joint2!=null?joint2.getValue():"-1");
*/
        //-- no loop
        SingleNode head3 = new SingleNode(0);
        SingleNode n31 = new SingleNode(1);
        SingleNode n32 = new SingleNode(1);
        head3.setNext(n31);
        n31.setNext(n32);
        SingleNode joint3 = ins.getLoop(head3);
        System.out.println(joint3!=null?joint3.getValue():"-1");
    }
}
