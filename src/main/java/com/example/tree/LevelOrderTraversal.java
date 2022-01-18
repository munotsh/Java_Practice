package com.example.tree;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {
    public static void main(String[] args) {
        LevelOrderTraversal bt = new LevelOrderTraversal();
        Node root = bt.insertNode(null, 6);
        root = bt.insertNode(root, 4);
        root = bt.insertNode(root, 8);
        root = bt.insertNode(root, 3);
        root = bt.insertNode(root, 5);
        root = bt.insertNode(root, 7);
        root = bt.insertNode(root, 9);
        System.out.println();
        bt.levelOrderTraversal(root);
    }

    public void levelOrderTraversal(Node startNode) {
        Queue<Node> queue=new LinkedList<>();
        queue.add(startNode);
        while(!queue.isEmpty())
        {
            Node tempNode=queue.poll();
            System.out.println(tempNode.value);
            if(tempNode.left!=null)
                queue.add(tempNode.left);
            if(tempNode.right!=null)
                queue.add(tempNode.right);
        }
    }
    public Node insertNode(Node root, int value) {
        if (root == null)
            return new Node(value);
        if (root.value >= value) root.left = insertNode(root.left, value);
        else root.right = insertNode(root.right, value);
        return root;
    }
}
