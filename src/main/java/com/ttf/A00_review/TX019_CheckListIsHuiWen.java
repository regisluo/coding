package com.ttf.A00_review;

import com.ttf.A01_basic_ds.list.SingleNode;

public class TX019_CheckListIsHuiWen {
    private boolean isHuiWen(SingleNode head) {
        // 1->2->3->2->1
        // 1->2->3->3->2->1
        // edge case
        if (null == head || head.next()==null) {
            return true;
        }
        SingleNode mid = findMiddle(head);

        SingleNode n2 = mid.next();// n2 to be the first node of the right part
        mid.setNext(null);
        SingleNode n1=mid;
        SingleNode n3;
        // revert the pointers on the right part
        while (n2!=null) {
            n3=n2.next();
            n2.setNext(n1);
            n1=n2;
            n2=n3;
        }
        // here, n1 is the last node
        n3=n1;// remember the last node
        // re-point n2 to head
        n2 = head;

        boolean isHuiwen=true;
        // compare the node value
        while (n1!=null && n2!=null){
            if (n1.getValue() != n2.getValue()) {
                isHuiwen=false;
                break;
            }
            n1=n1.next();
            n2=n2.next();
        }
        // here we know it is Huiwen, just need to
        // revert back the list. Now the n3 is last node
        n2 = n3.next();
        n3.setNext(null);
        while (n2!=null){
            n1=n2.next();// save the next node
            n2.setNext(n3);
            n3=n2;
            n2=n1;
        }
    return isHuiwen;
    }
    public static void printLinkedList(SingleNode node) {
        System.out.print("Linked List: ");
        while (node != null) {
            System.out.print(node.getValue() + " ");
            node = node.next();
        }
        System.out.println();
    }
    // return middle node of the given list;
    // move the slow point one step and fast by two steps
    // when the fast to end, the slow is in the middle
    public SingleNode findMiddle(SingleNode head) {
        SingleNode slow = head;
        SingleNode fast = head;
        while(fast.next()!=null && fast.next().next()!=null){
            slow = slow.next();
            fast = fast.next().next();
        }
        return slow;
    }

    public static void main(String[] args) {
        TX019_CheckListIsHuiWen checkListIsHuiWen = new TX019_CheckListIsHuiWen();
        SingleNode head = null;
        System.out.print((head) + " | ");
        System.out.print(checkListIsHuiWen.isHuiWen(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new SingleNode(1);
        System.out.print(checkListIsHuiWen.isHuiWen(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new SingleNode(1);
        head.setNext(new SingleNode(2));
        System.out.print(checkListIsHuiWen.isHuiWen(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new SingleNode(1);
        head.setNext(new SingleNode(1));
        System.out.print(checkListIsHuiWen.isHuiWen(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new SingleNode(1);
        head.setNext(new SingleNode(2));
        head.next().setNext(new SingleNode(3));
        System.out.print(checkListIsHuiWen.isHuiWen(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new SingleNode(1);
        head.setNext(new SingleNode(2));
        head.next().setNext(new SingleNode(1));
        System.out.print(checkListIsHuiWen.isHuiWen(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new SingleNode(1);
        head.setNext(new SingleNode(2));
        head.next().setNext(new SingleNode(3));
        head.next().next().setNext(new SingleNode(1));
        System.out.print(checkListIsHuiWen.isHuiWen(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new SingleNode(1);
        head.setNext(new SingleNode(2));
        head.next().setNext(new SingleNode(2));
        head.next().next().setNext(new SingleNode(1));
        System.out.print(checkListIsHuiWen.isHuiWen(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new SingleNode(1);
        head.setNext(new SingleNode(2));
        head.next().setNext(new SingleNode(3));
        head.next().next().setNext(new SingleNode(2));
        head.next().next().next().setNext(new SingleNode(1));
        System.out.print(checkListIsHuiWen.isHuiWen(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");
    }
}
