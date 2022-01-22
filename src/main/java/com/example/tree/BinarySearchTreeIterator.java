package com.example.tree;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class BinarySearchTreeIterator {

    Queue<Node> stack;

    public static void main(String[] args) {
        Node root = new Node(7);
        root.left = new Node(3);
        root.right = new Node(15);
        root.right.left = new Node(9);
        root.right.right = new Node(20);
        BinarySearchTreeIterator bt = null;
        String[] input = {"BSTIterator", "next", "next", "hasNext", "next", "hasNext", "next", "hasNext", "next", "hasNext"};
        for (String s : input) {
            switch (s) {
                case "BSTIterator":
                    bt = new BinarySearchTreeIterator(root);
                    break;
                case "next":
                    System.out.print(bt.next() + " ");
                    break;
                case "hasNext":
                    System.out.print(bt.hasNext() + " ");
                    break;
            }
        }
    }

    public BinarySearchTreeIterator(Node root) {
        stack = new ArrayDeque<>();
        inOrderRec(root);
    }

    void inOrderRec(Node root) {
        if (root != null) {
            inOrderRec(root.left);
            stack.add(root);
            inOrderRec(root.right);
        }
    }

    public int next() {
        return stack.remove().value;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }
}
