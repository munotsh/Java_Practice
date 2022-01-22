package com.example.tree;

import java.util.ArrayList;
import java.util.List;

public class CountCompleteTreeNodes {
    public static void main(String[] args) {
        CountCompleteTreeNodes bt = new CountCompleteTreeNodes();
        Node root = new Node(6);
        root.left = new Node(4);
        root.right = new Node(8);
        root.left.left = new Node(3);
        root.left.right = new Node(5);
        root.right.left = new Node(7);
        root.right.right = new Node(9);
        System.out.println(bt.countNodes(root));
    }
    public int countNodes(Node root) {
//        List<Node> nodes = new ArrayList<>();
//        countNodesOfTreeMyApproach(root,nodes);
        return countNodes_recursive(root);
    }

    public int countNodes_recursive(Node root) {
        if (root == null)
            return 0;

        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    private void countNodesOfTreeMyApproach(Node root, List<Node> nodes) {
        if (root == null)
            return;
        nodes.add(root);
        countNodesOfTreeMyApproach(root.left, nodes);
        countNodesOfTreeMyApproach(root.right, nodes);
    }
}
