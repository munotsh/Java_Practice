package com.example.tree;

public class SumRootToLeafNumbers {
    /* Construct the following tree
                     6
                   /   \
                  4     8
                /  \   /  \
               3    5 7    9
          */
    int sum = 0;
    public static void main(String[] args) {
        SumRootToLeafNumbers bt = new SumRootToLeafNumbers();
        Node root = new Node(6);
        root.left = new Node(4);
        root.right = new Node(8);
        root.left.left = new Node(3);
        root.left.right = new Node(5);
        root.right.left = new Node(7);
        root.right.right = new Node(9);
        System.out.println(bt.sumNumbers(root));
    }

    public int sumNumbers(Node root) {
        sumNumbers(root, 0);
        return sum;
    }

    public void sumNumbers(Node root, int i) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            sum = sum + (i * 10) + root.value;
            return;
        }
        i = (i * 10) + root.value;
        sumNumbers(root.left, i);
        sumNumbers(root.right, i);
    }

}
