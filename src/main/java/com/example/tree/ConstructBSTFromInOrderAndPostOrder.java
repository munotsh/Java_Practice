package com.example.tree;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class ConstructBSTFromInOrderAndPostOrder {
    public static void main(String[] args) {
        /* Construct the following tree
                   6
                 /   \
                4     8
              /  \   /  \
             3    5 7    9
        */

        int[] inorder = {3, 4, 5, 6, 7, 8, 9};
        int[] postorder = {3, 5, 4, 7, 9, 8, 6};
        ConstructBSTFromInOrderAndPostOrder bt = new ConstructBSTFromInOrderAndPostOrder();
        Node root = bt.construct(inorder, postorder);
        bt.printTree(root);
    }

    private Node construct(int[] inorder, int[] postorder) {
        int n = inorder.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(inorder[i], i);
        }
        AtomicInteger pIndex = new AtomicInteger(n - 1);
        return buildTree(0, n - 1, postorder, pIndex, map);
    }

    public Node buildTree(int start, int end,
                                 int[] postorder, AtomicInteger pIndex,
                                 Map<Integer, Integer> map) {
        if (start > end) {
            return null;
        }
        Node root = new Node(postorder[pIndex.getAndDecrement()]);
        int index = map.get(root.value);
        root.right = buildTree(index + 1, end, postorder, pIndex, map);
        root.left = buildTree(start, index - 1, postorder, pIndex, map);
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
