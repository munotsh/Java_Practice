package com.example.tree;

import java.util.ArrayList;

public class ValidateBinarySearchTree {
    public static void main(String[] args) {
        ValidateBinarySearchTree bt = new ValidateBinarySearchTree();
        Node root = new Node(2);
        root.left = new Node(1);
        root.right = new Node(3);
        System.out.println(bt.isValidBST(root));
        // OP : true
        Node root1 = new Node(5);
        root1.left = new Node(1);
        root1.right = new Node(4);
        root1.right.left = new Node(3);
        root1.right.right = new Node(6);
        System.out.println(bt.isValidBST(root1));
        // OP : false
    }

    public boolean isValidBST(Node root) {
        return validate(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        // anther way using inorder traversal.
        // inOrder(root);
        // return isSorted(list, 0);
    }
    private boolean validate(Node root, int minValue, int maxValue) {
        if (root == null) {
            return true;
        } else if (root.value <= minValue || root.value >= maxValue) {
            return false;
        }
        return validate(root.left, minValue, root.value) && validate(root.right, root.value, maxValue);
    }

    ArrayList<Integer> list = new ArrayList<>();
    private void inOrder(Node root) {
        if (root == null) return;
        inOrder(root.left);
        list.add(root.value);
        inOrder(root.right);
    }
    private boolean isSorted(ArrayList<Integer> list, int index) {
        if (index + 1 == list.size()) return true;
        return list.get(index) < list.get(index + 1) && isSorted(list, index + 1);
    }

}
