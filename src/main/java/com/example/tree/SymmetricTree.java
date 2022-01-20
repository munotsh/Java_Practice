package com.example.tree;

public class SymmetricTree {
    public static void main(String[] args) {
        SymmetricTree bt = new SymmetricTree();
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(4);
        root.right.left = new Node(4);
        root.right.right = new Node(3);
        System.out.println(bt.isSymmetric(root));

        Node root1 = new Node(1);
        root1.left = new Node(2);
        root1.right = new Node(2);
        root1.left.right = new Node(3);
        root1.right.right = new Node(3);
        System.out.println(bt.isSymmetric(root1));
    }

    public boolean isSymmetric(Node root) {
        return isSym(root.left, root.right);
    }

    private boolean isSym(Node left, Node right) {
        if (left == null && right == null)
            return true;
        else if (left == null && right != null)
            return false;
        else if (left != null && right == null)
            return false;
        return left.value == right.value && isSym(left.left, right.right) && isSym(left.right, right.left);
    }
}
