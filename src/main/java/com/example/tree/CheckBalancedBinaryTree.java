package com.example.tree;

public class CheckBalancedBinaryTree {
    public static void main(String[] args) {
        CheckBalancedBinaryTree bt = new CheckBalancedBinaryTree();
        Node root = new Node(3);
        root.left = new Node(9);
        root.right = new Node(20);
        root.right.left = new Node(15);
        root.right.right = new Node(7);
        System.out.println(bt.isBalanced(root));
    }

    public boolean isBalanced(Node root) {
        if (root == null) return true;
        // use -1 to denote the tree is not balanced
        // >= 0 value means the tree is balanced and it is the actual height of tree
        return height(root) != -1;
    }
    private int height(Node root) {
        if (root == null) {
            return 0;
        }
        // if left subtree is already not balanced, we do not need to continue
        // and we can return -1 directly, same for right subtree
        int leftHeight = height(root.left);
        if (leftHeight == -1) return -1;
        int rightHeight = height(root.right);
        if (rightHeight == -1) return -1;
        // if not balanced, return -1
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
