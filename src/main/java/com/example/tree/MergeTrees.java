package com.example.tree;

public class MergeTrees {
    public static void main(String[] args) {
/* Construct the following tree
                   6                    7                       13
                 /   \                /   \                    /   \
                4     8             5      9      ==          9     17
              /  \   /  \         /  \    /  \              /  \   /  \
             3    5 7    9      4     6  8    10           7   11 15  19
        */

        MergeTrees bt = new MergeTrees();
        Node root = bt.insertNode(null, 6);
        root = bt.insertNode(root, 4);
        root = bt.insertNode(root, 8);
        root = bt.insertNode(root, 3);
        root = bt.insertNode(root, 5);
        root = bt.insertNode(root, 7);
        root = bt.insertNode(root, 9);
        bt.printTree(root);
        System.out.println();

        Node root1 = bt.insertNode(null, 7);
        root1 = bt.insertNode(root1, 5);
        root1 = bt.insertNode(root1, 9);
        root1 = bt.insertNode(root1, 4);
        root1 = bt.insertNode(root1, 6);
        root1 = bt.insertNode(root1, 8);
        root1 = bt.insertNode(root1, 10);
        bt.printTree(root1);
        System.out.println();
        Node mRoot = bt.merge(root, root1);
        bt.printTree(mRoot);
    }

    private Node merge(Node root, Node root1) {
        if (root == null)
            return root1;
        if (root1 == null)
            return root;
        root.value = root.value + root1.value;
        root.left = merge(root.left, root1.left);
        root.right = merge(root.right, root1.right);
        return root;
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
