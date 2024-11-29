package com.ttf.A01_basic_ds.list;

public class SinglyLinkedList {
    private SingleNode head; // Head of the list
    private int size;  // Number of elements in the list

    public SingleNode head(){
        return this.head;
    }

    public int size() {
        return this.size;
    }

    // Constructor
    public SinglyLinkedList() {
        this.head = null;
        this.size = 0;
    }

    // Add a node at the end of the list
    public void add(int value) {
        SingleNode newNode = new SingleNode(value);
        if (head == null) {
            head = newNode; // If the list is empty, set head to the new node
        } else {
            SingleNode current = head;
            while (current.next() != null) { // Traverse to the end of the list
                current = current.next();
            }
            current.setNext(newNode); // Append the new node
        }
        size++;
    }

    // Remove a node from the list by value
    public boolean remove(int value) {
        if (head == null) return false; // List is empty
        if (head.getValue() == value) { // Value is in the head node
            head = head.next();
            size--;
            return true;
        }
        SingleNode current = head;
        while (current.next() != null && current.next().getValue() != value) {
            current = current.next(); // Traverse to find the node to remove
        }
        if (current.next() == null) return false; // Value not found
        current.setNext(current.next().next()); // Remove the node
        size--;
        return true;
    }

    // Display the list
    public void display() {
        SingleNode current = head;
        while (current != null) {
            System.out.print(current.getValue() + " -> ");
            current = current.next();
        }
        System.out.println("null");
    }

    // Get the size of the list
    public int getSize() {
        return size;
    }
}

