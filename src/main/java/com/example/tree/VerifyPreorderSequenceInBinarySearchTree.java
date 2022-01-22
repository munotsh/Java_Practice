package com.example.tree;

import java.util.Stack;

public class VerifyPreorderSequenceInBinarySearchTree {
    public  static  void main(String[] args){
        VerifyPreorderSequenceInBinarySearchTree bt = new VerifyPreorderSequenceInBinarySearchTree();
        int[] preOrd = {6,4,3,5,8,7,9};
        System.out.println(bt.canRepresentBST(preOrd));
    }

    public boolean canRepresentBST(int pre[]) {
        Stack<Integer> s = new Stack<>();
        int root = Integer.MIN_VALUE;
        for (int val:pre) {
            // If we find a node who is on right side
            // and smaller than root, return false
            if (val < root) {
                return false;
            }

            // If val is in right subtree of stack top,
            // Keep removing items smaller than val
            // and make the last removed item as new
            // root.
            while (!s.empty() && s.peek() < val) {
                root = s.peek();
                s.pop();
            }

            // At this point either stack is empty or
            // val is smaller than root, push val
            s.push(val);
        }
        return true;
    }
}
