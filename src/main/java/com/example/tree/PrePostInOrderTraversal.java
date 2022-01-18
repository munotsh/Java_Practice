package com.example.tree;

import java.util.LinkedList;
import java.util.Queue;

public class PrePostInOrderTraversal {
    public static void main(String[] args) {
        PrePostInOrderTraversal bt = new PrePostInOrderTraversal();
        Node root = bt.insertNode(null, 6);
        root = bt.insertNode(root, 4);
        root = bt.insertNode(root, 8);
        root = bt.insertNode(root, 3);
        root = bt.insertNode(root, 5);
        root = bt.insertNode(root, 7);
        root = bt.insertNode(root, 9);
        System.out.println("Pre order Traversal");
        bt.preOrderRec(root);
        System.out.println("\n In order Traversal");
        bt.inOrderRec(root);
        System.out.println("\n Post order Traversal");
        bt.postOrderRec(root);
    }
    void preOrderRec(Node node) {
        if (node == null)
            return;

        System.out.print(node.value + " ");
        preOrderRec(node.left);
        preOrderRec(node.right);
    }
    void inOrderRec(Node root) {
        if (root != null) {
            inOrderRec(root.left);
            System.out.print(root.value + " ");
            inOrderRec(root.right);
        }
    }
    void postOrderRec(Node node) {
        if (node == null)
            return;

        postOrderRec(node.left);
        postOrderRec(node.right);
        System.out.print(node.value + " ");
    }
    public Node insertNode(Node root, int value) {
        if (root == null)
            return new Node(value);
        if (root.value >= value) root.left = insertNode(root.left, value);
        else root.right = insertNode(root.right, value);
        return root;
    }
}
