package com.example.tree;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class BinaryTreeAllPaths {
    public static void main(String[] args) {
         /* Construct the following tree
                   6
                 /   \
                4     8
              /  \   /  \
             3    5 7    9
        */
        BinaryTreeAllPaths bt = new BinaryTreeAllPaths();
        Node root = new Node(6);
        root.left = new Node(4);
        root.right = new Node(8);
        root.left.left = new Node(3);
        root.left.right = new Node(5);
        root.right.left = new Node(7);
        root.right.right = new Node(9);
        System.out.println(bt.binaryTreePaths(root));

    }
    public List<String> binaryTreePaths(Node root) {
        List<String> list = new ArrayList<>();
        binaryTreePathsRec(root,"",list);
        return  list;
    }
    void binaryTreePathsRec(Node root,String row,List<String> list) {
        if (root == null) {
            return;
        }
        if (root.left == null || root.right == null) {
            list.add(row+root.value);
            return;
        }
        row =row+root.value;
        row = row + " -> ";
        binaryTreePathsRec(root.left,row,list);
        binaryTreePathsRec(root.right,row,list);
    }
}
