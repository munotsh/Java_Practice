package com.example.tree;

import java.util.Arrays;

public class ConvertSortedArrayToBinarySearchTree {
    public static void main(String[] args) {
        ConvertSortedArrayToBinarySearchTree bt = new ConvertSortedArrayToBinarySearchTree();
        int[] arr = {-10, -3, 0, 5, 9};
        Node root = bt.sortedArrayToBST(arr);
        bt.printTree(root);
    }

    public Node sortedArrayToBST(int[] nums) {
        int size = nums.length;
        if (size == 0) return null;
        if (size == 1) return new Node(nums[0]);

        int rootIndex = size / 2;
        Node root = new Node(nums[rootIndex]);

        root.left = sortedArrayToBST(Arrays.copyOfRange(nums, 0, rootIndex));
        root.right = sortedArrayToBST(Arrays.copyOfRange(nums, rootIndex + 1, size));
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
