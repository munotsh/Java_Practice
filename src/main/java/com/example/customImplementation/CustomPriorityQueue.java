package com.example.customImplementation;

public class CustomPriorityQueue {
    int[] queue;
    public static int DEFAULT_SIZE = 10;
    private int size = 0;

    public CustomPriorityQueue() {
        this(DEFAULT_SIZE);
    }

    public CustomPriorityQueue(int capacity) {
        queue = new int[capacity];
        DEFAULT_SIZE = capacity;
    }

    public void insert(int val) {
        if (size == 0) {
            queue[size] = val;
            size++;
            return;
        }
        int i;
        for (i = size - 1; i >= 0; i--) {
            if (queue[i] < val) {
                queue[i + 1] = queue[i];

            } else {
                break;
            }
        }
        queue[i + 1] = val;
        size++;
    }

    public void printPriorityQueue() {
        System.out.print("[");
        for (int i : queue) {
            System.out.print(i + " ");
        }
        System.out.print("]");
    }

    public int remove() {
        return queue[--size];
    }

    public boolean isFull() {
        return DEFAULT_SIZE == size;
    }

    public boolean isEmpty() {
        return 0 == size;
    }

    public static void main(String[] args) {
        CustomPriorityQueue cpq = new CustomPriorityQueue(5);
        cpq.insert(12);
        cpq.insert(10);
        cpq.insert(9);
        cpq.insert(8);
        cpq.insert(11);
        cpq.printPriorityQueue();

        for (int i = 0; i < cpq.DEFAULT_SIZE; i++) {
            System.out.println(cpq.remove());
        }
    }
}



