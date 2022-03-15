package com.example.tree;

public class DiameterOfBinaryTree {
    public static void main(String[] args) {
        DiameterOfBinaryTree bt = new DiameterOfBinaryTree();
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(5);
        root.left.left = new Node(3);
        root.left.right = new Node(4);
        root.right.right = new Node(6);
        System.out.println(bt.diameterOfBinaryTree(root));
    }

    public int diameterOfBinaryTree(Node root) {
        int diameter[] = new int[1];
        if (root == null) {
            return 0;
        }
        height(root, diameter);
        return diameter[0];
    }

    // Function to get height of tree.
    private int height(Node node, int[] diameter) {
        if (node == null) {
            return 0;
        }
        int lh = height(node.left, diameter);
        int rh = height(node.right, diameter);
        diameter[0] = Math.max(lh + rh, diameter[0]);
        return Math.max(lh, rh) + 1;
    }
}
