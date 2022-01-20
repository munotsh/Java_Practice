package com.example.tree;

public class FlattenBinaryTreeToLinkedList {
    public static void main(String[] args) {
        FlattenBinaryTreeToLinkedList bt = new FlattenBinaryTreeToLinkedList();
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(5);
        root.left.left = new Node(3);
        root.left.right = new Node(4);
        root.right.right = new Node(6);
        bt.printTree(root);
        bt.flatten(root);
        System.out.println();
        bt.printTree(root);
    }

    public void flatten(Node root) {
        if(root==null){
            return;
        }
        Node temp=root.left;
        while(temp!=null && temp.right!=null){
            temp=temp.right;
        }
        if(temp!=null){
            temp.right=root.right;
            root.right=root.left;
            root.left=null;
        }
        flatten(root.right);
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
