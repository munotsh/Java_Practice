package com.example.tree;

public class CheckTreeIsBinarySearchTree {
    public static void main(String[] args) {
        /* Construct the following tree
                   6
                 /   \
                4     8
              /  \   /  \
             3    5 7    9
        */
        CheckTreeIsBinarySearchTree bt = new CheckTreeIsBinarySearchTree();
        Node root = bt.insertNode(null, 6);
        root = bt.insertNode(root, 4);
        root = bt.insertNode(root, 8);
        root = bt.insertNode(root, 3);
        root = bt.insertNode(root, 5);
        root = bt.insertNode(root, 7);
        root = bt.insertNode(root, 9);
        System.out.println(bt.isBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
        bt.printTree(root);
    }

    boolean isBSTUtil(Node node, int min, int max) {
        /* an empty tree is BST */
        if (node == null)
            return true;
        /* false if this node violates the min/max constraints */
        if (node.value < min || node.value > max)
            return false;
        /* otherwise check the subtrees recursively tightening the min/max constraints */
        // Allow only distinct values
        return (isBSTUtil(node.left, min, node.value - 1) &&
                isBSTUtil(node.right, node.value + 1, max));
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
