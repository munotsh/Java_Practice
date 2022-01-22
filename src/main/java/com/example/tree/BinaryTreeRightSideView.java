package com.example.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
        List<Integer> res =  new ArrayList<Integer>();
        if(root==null)
            return  res;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(! q.isEmpty()){
            int size = q.size();
            List<Integer> rightSide =  new ArrayList<Integer>();
            for(int i =0;i< size;i++){
                Node temp = q.peek();
                rightSide.add(temp.value);
                //add right node first into queue
                if(temp.right!=null)
                    q.add(temp.right);
                if(temp.left!=null)
                    q.add(temp.left);

                q.remove();
            }
            //get the right node ie, first node from the list and add it ro result list
            res.add(rightSide.get(0));
        }


        return res;
    }

}
