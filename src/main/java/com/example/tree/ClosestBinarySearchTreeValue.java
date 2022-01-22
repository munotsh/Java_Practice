package com.example.tree;

public class ClosestBinarySearchTreeValue {
    public static void main(String[] args) {
         /* Construct the following tree
                   6
                 /   \
                4     8
              /  \   /  \
             3    5 7    9
        */
        ClosestBinarySearchTreeValue bt = new ClosestBinarySearchTreeValue();
        Node root = new Node(6);
        root.left = new Node(4);
        root.right = new Node(8);
        root.left.left = new Node(3);
        root.left.right = new Node(5);
        root.right.left = new Node(7);
        root.right.right = new Node(9);
        System.out.println(bt.getCloset(root,2));

    }

    public int getCloset(Node root,int val){
        int[] ans = new int[1];
        getClosetValue(root,val,ans);
        return ans[0];
    }

    private void getClosetValue(Node root, int val, int[] ans) {
        if(root != null){
            if(Math.abs(root.value-val)<Math.abs(ans[0]-val)){
                ans[0] = root.value;
            }
            getClosetValue(root.left,val,ans);
            getClosetValue(root.right,val,ans);
        }
    }
}
