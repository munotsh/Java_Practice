package com.example.tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeRightSideView {
    public static void main(String[] args) {
        BinaryTreeRightSideView bt = new BinaryTreeRightSideView();
        Node root = new Node(6);
        root.left = new Node(4);
        root.right = new Node(8);
        root.left.left = new Node(3);
        root.left.right = new Node(5);
        root.right.left = new Node(7);
        root.right.right = new Node(9);
        root.right.right.left = new Node(10);
        List<Integer> r = bt.rightSideView(root);
        System.out.println(r);
    }

    public List<Integer> rightSideView(Node root) {
        return rightSideViewSolve(root, new ArrayList<Integer>());
    }

    private List<Integer> rightSideViewSolve(Node root, ArrayList<Integer> list) {
        if(root!=null){
            list.add(root.value);
            rightSideViewSolve(root.right,list);
        }
        return list;
    }
}
