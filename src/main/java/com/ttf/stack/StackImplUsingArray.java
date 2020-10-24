package com.ttf.stack;

/**
 * Stack impl using a fix length array
 */
public class StackImplUsingArray {
    public static class MyStack {
        private int[] arr;
        private int size; // the current number of elements in the stack
        private final int length; // max lenght of the stack
        private int top; // current index pointing to the top element

        private int[] minArr; // array used to store the min values

        public MyStack(int length) {
            this.length = length;
            arr = new int[length];
            minArr = new int[length];
            this.size = 0;
            this.top = -1;
        }

        // add an element into the stack
        private void push(int value) {
            if (size == length) {
                throw new RuntimeException("stack full");
            }
            arr[top + 1] = value;
            size++;

            // push min value int minArr
            if (top == -1) {
                minArr[top + 1] = value;
            } else if (value < minArr[top]) {
                minArr[top + 1] = value;
            } else {
                minArr[top + 1] = minArr[top];
            }
            top++;
        }

        // remove an element from the stack
        private int pop() {
            if (size == 0) {
                throw new RuntimeException("stack empty");
            }
            int value = arr[top];
            top--;
            size--;
            return value;
        }

        private int peek() {
            if (size == 0) {
                throw new RuntimeException("stack empty");
            }
            return this.arr[top];
        }

        /**
         * return the min value in the stack
         *
         * @return
         */
        private int getMin() {
            if (size == 0) {
                throw new RuntimeException("stack empty");
            }
            return minArr[top];
        }

        private boolean empty(){
            return size==0;
        }

    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack(5);
        myStack.push(4);
        myStack.push(3);
        myStack.push(5);
        myStack.push(2);
        myStack.push(2);

        System.out.println(myStack.peek());
        System.out.println(myStack.getMin());
        myStack.pop();
        myStack.pop();
        System.out.println(myStack.peek());
        System.out.println(myStack.getMin());
    }
}
