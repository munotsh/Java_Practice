package com.example.tree;

public class RecoverBinarySearchTree {
    Node prev = null;

    public static void main(String[] args) {
        RecoverBinarySearchTree bt = new RecoverBinarySearchTree();
        Node root = new Node(1);
        root.left = new Node(3);
        root.left.right = new Node(2);
        bt.printTree(root);
        System.out.println();
        bt.recoverTree(root);
        bt.printTree(root);
    }

    public void recoverTree(Node root) {
        boolean isInOrder = false;
        do {
            prev = null;
            isInOrder = inOrderTraverse(root);
        } while (!isInOrder);
    }

    public boolean inOrderTraverse(Node node) {
        if (node == null) {
            return true;
        }
        boolean left = inOrderTraverse(node.left);
        if (prev != null && prev.value > node.value) {
            int temp = node.value;
            node.value = prev.value;
            prev.value = temp;
            return false;
        }
        prev = node;
        boolean right = inOrderTraverse(node.right);
        return left & right;
    }

    void printTree(Node root) {
        if (root == null) {
            return;
        }
        System.out.printf("%d ", root.value);
        printTree(root.left);
        printTree(root.right);
    }
}
