package com.example.tree;

public class MaximumDepthOfBinaryTree {
    public static void main(String[] args) {
        MaximumDepthOfBinaryTree bt = new MaximumDepthOfBinaryTree();
        Node root = new Node(3);
        root.left = new Node(9);
        root.right = new Node(20);
        root.right.left = new Node(15);
        root.right.right = new Node(7);
        System.out.println(bt.maxDepth(root));

        Node root1 = new Node(1);
        root1.right = new Node(2);
        System.out.println(bt.maxDepth(root1));
    }
    public int maxDepth(Node root) {
        if(root==null) {
            return 0;
        } else {
            return Math.max(maxDepth(root.left), maxDepth(root.right))+1;
        }
    }
}
