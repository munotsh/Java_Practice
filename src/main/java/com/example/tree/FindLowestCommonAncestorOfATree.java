package com.example.tree;

public class FindLowestCommonAncestorOfATree {
    public static void main(String[] args) {
        FindLowestCommonAncestorOfATree bt = new FindLowestCommonAncestorOfATree();
        Node root = new Node(3);
        root.left = new Node(5);
        root.right = new Node(1);
        root.left.left = new Node(6);
        root.left.right = new Node(2);
        root.left.right.left = new Node(7);
        root.left.right.right = new Node(4);
        root.right.left = new Node(0);
        root.right.right = new Node(8);

        bt.printTree(root);
        System.out.println();
        System.out.println(bt.lowestCommonAncestor(root, root.left, root.right).value);
        System.out.println(bt.lowestCommonAncestor(root, root.left, root.left.right.right).value);
        System.out.println(bt.lowestCommonAncestor(root, root.right, root.left.right).value);

    }

    public Node lowestCommonAncestor(Node root, Node p, Node q) {
        if (root == null || root == p || root == q) return root;
        Node left = lowestCommonAncestor(root.left, p, q);
        Node right = lowestCommonAncestor(root.right, p, q);
        return left == null ? right : right == null ? left : root;
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
