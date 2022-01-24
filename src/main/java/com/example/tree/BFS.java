package com.example.tree;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    public static void main(String[] args) {
         /* Construct the following tree
                   6
                 /   \
                4     8
              /  \   /  \
             3    5 7    9
        */
        BFS bt = new BFS();
        Node root = new Node(6);
        root.left = new Node(4);
        root.right = new Node(8);
        root.left.left = new Node(3);
        root.left.right = new Node(5);
        root.right.left = new Node(7);
        root.right.right = new Node(9);
        System.out.println();
        bt.generateBFS(root);
        //3456789
    }

    public void generateBFS(Node root) {
        if (root == null)
            return;
        Queue<Node> q = new LinkedList<>();

        q.add(root);
        while (!q.isEmpty()) {
            Node temp = q.poll();
            System.out.print(temp.value);
            if (temp.left != null)
                q.add(temp.left);
            if (temp.right != null)
                q.add(temp.right);
        }
    }
}
