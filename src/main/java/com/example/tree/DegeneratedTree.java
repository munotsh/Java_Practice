package com.example.tree;

public class DegeneratedTree {

    // degenerated tree means every parent has only one child
    public static void main(String[] args) {
        DegeneratedTree bt = new DegeneratedTree();
        Node root = bt.insertNode(null, 6);
        root = bt.insertNode(root, 4);
        root = bt.insertNode(root, 8);
        root = bt.insertNode(root, 3);
        root = bt.insertNode(root, 5);
        root = bt.insertNode(root, 7);
        root = bt.insertNode(root, 9);
        bt.print(root);
    }

    public Node insertNode(Node root, int value) {
        if (root == null)
            return new Node(value);
        if (root.value >= value) root.left = insertNode(root.left, value);
        else root.right = insertNode(root.right, value);
        return root;
    }
    void print(Node root) {
        if (root == null) {
            return;
        }
        System.out.printf("%d ", root.value);
        print(root.left);
        print(root.right);
    }
    
}
