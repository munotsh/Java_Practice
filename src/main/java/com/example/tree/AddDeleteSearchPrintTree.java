package com.example.tree;

public class AddDeleteSearchPrintTree {

    public static void main(String[] args) {
        AddDeleteSearchPrintTree bt = new AddDeleteSearchPrintTree();
        Node root = bt.insertNode(null, 6);
        root = bt.insertNode(root, 4);
        root = bt.insertNode(root, 8);
        root = bt.insertNode(root, 3);
        root = bt.insertNode(root, 5);
        root = bt.insertNode(root, 7);
        root = bt.insertNode(root, 9);
        bt.print(root);
        bt.deleteRec(root, 4);
        System.out.println();
        bt.print(root);
        System.out.println();
        System.out.println(bt.containsNode(root, 5));
    }

    public Node insertNode(Node root, int value) {
        if (root == null)
            return new Node(value);
        if (root.value >= value) root.left = insertNode(root.left, value);
        else root.right = insertNode(root.right, value);
        return root;
    }

    private Node deleteRec(Node root, int key) {
        if (root == null)
            return root;

        if (key < root.value)
            root.left = deleteRec(root.left, key);
        else if (key > root.value)
            root.right = deleteRec(root.right, key);

        else {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            root.value = minValue(root.right);

            root.right = deleteRec(root.right, root.value);
        }

        return root;
    }

    int minValue(Node root) {
        int minv = root.value;
        while (root.left != null) {
            minv = root.left.value;
            root = root.left;
        }
        return minv;
    }

    void print(Node root) {
        if (root == null) {
            return;
        }
        System.out.printf("%d ", root.value);
        print(root.left);
        print(root.right);
    }

    boolean containsNode(Node root, int value) {
        if (root == null)
            return false;
        if (value == root.value)
            return true;
        return value < root.value ? containsNode(root.left, value) : containsNode(root.right, value);
    }
}
