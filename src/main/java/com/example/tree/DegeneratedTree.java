package com.example.tree;

public class DegeneratedTree {

    // degenerated tree means every parent has only one child
    public static void main(String[] args) {
        DegeneratedTree bt = new DegeneratedTree();
        Node root = bt.insertNode(null, 10);
        root = bt.insertNode(root, 9);
        root = bt.insertNode(root, 8);
        root = bt.insertNode(root, 7);
        root = bt.insertNode(root, 6);
        root = bt.insertNode(root, 5);
        root = bt.insertNode(root, 4);
        bt.printTree(root);
        System.out.println();
        System.out.println(bt.degenerate(root));
    }
    public boolean degenerate(Node node) {
        if (node.left != null) {
            if (node.right != null) {
                return false; // not degenerate, has two children
            } else {
                return degenerate(node.left);
            }
        } else {
            if (node.right != null) {
                return degenerate(node.right);
            } else {
                return true; // we arrived at the bottom without seeing any node with two children
            }
        }
    }
    public Node insertNode(Node root, int value) {
        if (root == null)
            return new Node(value);
        if (root.value >= value) root.left = insertNode(root.left, value);
        else root.right = insertNode(root.right, value);
        return root;
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
