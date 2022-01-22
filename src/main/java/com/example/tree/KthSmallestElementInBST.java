package com.example.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class KthSmallestElementInBST {
    public static void main(String[] args) {
         /* Construct the following tree
                   6
                 /   \
                4     8
              /  \   /  \
             3    5 7    9
        */
        KthSmallestElementInBST bt = new KthSmallestElementInBST();
        Node root = new Node(6);
        root.left = new Node(4);
        root.right = new Node(8);
        root.left.left = new Node(3);
        root.left.right = new Node(5);
        root.right.left = new Node(7);
        root.right.right = new Node(9);
        int k =3;
        // for Binary Search Tree
        int ans = bt.kthSmallestInBinarySearchTreeUsingInOrderTraversal(root, k);
        System.out.println(ans);
        // for Binary Tree
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        bt.kthSmallestInBinaryTreeUsingPriorityQueue(root, queue);
        for(int i =0;i<k;i++){
            ans = queue.poll();
        }
        System.out.println(ans);

    }

    public int kthSmallestInBinarySearchTreeUsingInOrderTraversal(Node root, int k) {
        List<Integer> list = new ArrayList<>();
        addValues(root, list);
        return list.get(k - 1);
    }

    private void addValues(Node root, List<Integer> list) {
        if (root == null)
            return;
        addValues(root.left, list);
        list.add(root.value);
        addValues(root.right, list);
    }

    private void kthSmallestInBinaryTreeUsingPriorityQueue(
            Node root, PriorityQueue<Integer> queue) {
        if (root != null) {
            queue.add(root.value);
            kthSmallestInBinaryTreeUsingPriorityQueue(root.left, queue);
            kthSmallestInBinaryTreeUsingPriorityQueue(root.right, queue);
        }
    }
}
