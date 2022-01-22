package com.example.tree;

public class BinaryTreeMaximumPathSum {
int max_sum=Integer.MIN_VALUE;

    public static void main(String[] args) {
        BinaryTreeMaximumPathSum bt = new BinaryTreeMaximumPathSum();
        Node root = new Node(-10);
        root.left = new Node(9);
        root.right = new Node(20);
        root.right.left = new Node(15);
        root.right.right = new Node(7);
        System.out.println(bt.maxPathSum(root));
    }

    public int maxPathSum(Node root) {

        findsum(root);

        return max_sum;

    }
    public int findsum(Node root)
    {
        if(root == null)
            return 0;
        int left = findsum(root.left);
        int right = findsum(root.right);
        //check if root+left+right is greater than the root value;
        max_sum = Math.max(max_sum,Math.max(root.value+left+right,root.value));
        //checking if we can get maxvalueue for either side(left or right with root).if it is we set max_sum valueue
        max_sum = Math.max(max_sum,root.value+Math.max(left,right));

        //finally returning valueue. there is a case where we get negative valueue for left or right at that time we just need to return the root valueue
        return Math.max(root.value+Math.max(left,right),root.value);


    }
}
