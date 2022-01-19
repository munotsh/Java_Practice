package com.example.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigZagLeveTravelOrderTree {
    public static void main(String[] args) {
        ZigZagLeveTravelOrderTree bt = new ZigZagLeveTravelOrderTree();
        Node root = new Node(6);
        root.left = new Node(4);
        root.right = new Node(8);
        root.left.left = new Node(3);
        root.left.right = new Node(5);
        root.right.left = new Node(7);
        root.right.right = new Node(9);
        System.out.println(bt.zigzagLevelOrder(root));
    }
    public List<List<Integer>> zigzagLevelOrder(Node root)
    {
        List<List<Integer>> res=new LinkedList<>();
        if(root==null)
            return res;
        Queue<Node> q= new LinkedList<>();
        q.add(root);
        boolean flag=true;
        while(!q.isEmpty())
        {
            int size=q.size();
            List<Integer> subres=new LinkedList<>();
            for(int i=0;i<size;i++)
            {
                Node curr=q.poll();
                if(curr.left!=null)
                {
                    q.add(curr.left);
                }
                if(curr.right!=null)
                {
                    q.add(curr.right);
                }
                if(flag)
                {
                    subres.add(curr.value);
                }
                else
                {
                    subres.add(0,curr.value);
                }
            }
            res.add(subres);
            flag=!flag;
        }
        return res;
    }
}
