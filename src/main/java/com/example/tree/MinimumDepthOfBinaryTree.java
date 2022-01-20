package com.example.tree;

public class MinimumDepthOfBinaryTree {
    public static void main(String[] args) {
        MinimumDepthOfBinaryTree bt = new MinimumDepthOfBinaryTree();
        Node root = new Node(3);
        root.left = new Node(9);
        root.right = new Node(20);
        root.right.left = new Node(15);
        root.right.right = new Node(7);
        System.out.println(bt.minDepth(root));
    }

    public int minDepth(Node root) {
        if (root == null)
            return 0;

        if (root.left == null && root.right == null)
            return 1;

        if (root.left == null)
            return minDepth(root.right) + 1;

        if (root.right == null)
            return minDepth(root.left) + 1;

        return Math.min(minDepth(root.left),
                minDepth(root.right)) + 1;
    }
}
