package com.ttf.A01_basic_ds.list;

public class DoublyLinkedList {
    private DoubleNode<Integer> head; // Head of the list
    private DoubleNode<Integer> tail; // Tail of the list
    private int size;  // Number of elements in the list

    // Constructor
    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    // Add a node at the end of the list
    public void add(int value) {
        DoubleNode<Integer> newNode = new DoubleNode<Integer>(value);
        if (head == null) { // If the list is empty
            head = newNode;
            tail = newNode;
        } else {
            tail.setNext(newNode); // Link the new node to the end of the list
            newNode.setPre(tail);  // Set the previous pointer of new node
            tail = newNode;         // Update the tail to the new node
        }
        size++;
    }

    // Remove a node from the list by value
    public boolean remove(int value) {
        if (head == null) return false; // List is empty

        if (head.getValue() == value) { // Value is in the head node
            if (head.getNext() != null) { // If there is more than one node
                head.getNext().setPre(null);
            }
            head = head.getNext(); // Move the head to the next node
            size--;
            return true;
        }

        DoubleNode<Integer> current = head;
        while (current != null && current.getValue() != value) {
            current = current.getNext(); // Traverse to find the node to remove
        }

        if (current == null) return false; // Value not found

        // Re-link the previous and next nodes of the current node
        if (current.getPre() != null) {
            current.getPre().setNext(current.getNext());
        }
        if (current.getNext() != null) {
            current.getNext().setPre(current.getPre());
        } else { // cur is tail node
            tail = current.getPre(); // Update the tail if the node to remove is the last one

        }
        size--;
        return true;
    }

    // Display the list (from head to tail)
    public void displayForward() {
        DoubleNode<Integer> current = head;
        while (current != null) {
            System.out.print(current.getValue() + " <-> ");
            current = current.getNext();
        }
        System.out.println("null");
    }

    // Display the list (from tail to head)
    public void displayBackward() {
        DoubleNode<Integer> current = tail;
        while (current != null) {
            System.out.print(current.getValue() + " <-> ");
            current = current.getPre();
        }
        System.out.println("null");
    }

    // Get the size of the list
    public int getSize() {
        return size;
    }
}

