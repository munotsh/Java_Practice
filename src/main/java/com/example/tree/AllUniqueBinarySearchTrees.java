package com.example.tree;

import java.util.ArrayList;
import java.util.List;

public class AllUniqueBinarySearchTrees {
    public static void main(String[] args) {
        AllUniqueBinarySearchTrees bt = new AllUniqueBinarySearchTrees();
        int k =3;
        List<Node> list = bt.generateTrees(k);
        for(Node l:list){
            bt.printTree(l);
            System.out.println();
        }
    }

    public List<Node> generateTrees(int n) {
        List<Node> ans = BST(1,n);
        return ans;
    }

    public List<Node> BST(int start, int end){
        if(start>end){
            List<Node> nullList = new ArrayList<>();
            nullList.add(null);
            return nullList;
        }
        List<Node> ans = new ArrayList<>();
        for(int i=start;i<=end;i++){
            List<Node> left = BST(start,i-1);
            List<Node> right = BST(i+1,end);
            for(Node l:left){
                for(Node r:right){
                    Node root = new Node(i);
                    root.left = l;
                    root.right = r;
                    ans.add(root);
                }
            }
        }
        return ans;
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
