package com.example.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PathSum {
    public static void main(String[] args) {
        PathSum bt = new PathSum();
        Node root = new Node(5);
        root.left = new Node(4);
        root.right = new Node(8);
        root.left.left = new Node(11);
        root.left.left.left = new Node(7);
        root.left.left.right = new Node(2);
        root.right.left = new Node(7);
        root.right.right = new Node(4);
        root.right.right.left = new Node(5);
        root.right.right.right = new Node(1);

        System.out.println(bt.pathSum(root,22));
    }
    public List<List<Integer>> pathSum(Node root, int targetSum) {
        List<List<Integer>>  list=new ArrayList<>();
        LinkedList<Integer> sb =new LinkedList<>();
        pathSum(root,targetSum,list,sb);
        return list;
    }
    public void pathSum(Node root, int targetSum,List<List<Integer>> list,  LinkedList<Integer>  sb) {
        if(root==null) return ;

        if(root.left==null && root.right==null  ) {
            sb.add(root.value);
            targetSum-=root.value;
            if(targetSum==0) list.add(new LinkedList(sb));
            return;
        }
        sb.add(root.value);
        pathSum(root.left,targetSum-root.value,list,sb);
        if(root.left!=null) sb.removeLast();
        pathSum(root.right,targetSum-root.value,list,sb);
        if(root.right!=null) sb.removeLast();
    }
}
