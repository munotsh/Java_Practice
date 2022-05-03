package com.example.tree;

import java.util.HashSet;
import java.util.Set;

public class LowestCommonAncestorOfBinaryTree_III {
    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node parent;

        public Node(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        LowestCommonAncestorOfBinaryTree_III obj = new LowestCommonAncestorOfBinaryTree_III();
        Node root = new Node(3);
        root.left = new Node(5);
        root.right = new Node(1);
        root.left.left = new Node(6);
        root.left.right = new Node(2);
        root.right.left = new Node(0);
        root.right.right = new Node(8);
        root.left.right.left = new Node(7);
        root.left.right.right = new Node(4);

        root.left.parent = root;
        root.right.parent = root;
        root.left.left.parent = root.left;
        root.left.right.parent = root.left;
        root.left.right.left.parent = root.left.right;
        root.left.right.right.parent = root.left.right;
        root.right.left.parent = root.right;
        root.right.right.parent = root.right;
        //System.out.println(obj.lowestCommonAncestor(root.left.right.right, root.right.right).val);
        //  OP: 3
        // System.out.println(obj.lowestCommonAncestorSolutionOne(root.left, root.right).val);
        // System.out.println(obj.lowestCommonAncestorSolutionTwo(root.left, root.right).val);
        // OP: 3
        System.out.println(obj.lowestCommonAncestorSolutionOne(root.left, root.left.right).val);
        System.out.println(obj.lowestCommonAncestorSolutionTwo(root.left, root.left.right).val);
    }

    private Node lowestCommonAncestorSolutionTwo(Node p , Node q) {
        Set<Integer> seen = new HashSet<>();
        while(p!=null){
            seen.add(p.val);
            p=p.parent;
        }
        while(q!=null){
            if(!seen.contains(q.val)){
                seen.add(q.val);
                q=q.parent;
            }
            else
                break;
        }
        return q;
    }

    public Node lowestCommonAncestorSolutionOne(Node p, Node q) {
        Node pCopy = p;
        Node qCopy = q;
        while (pCopy != qCopy) {
            if (pCopy == null)
                pCopy = q;
            else
                pCopy = pCopy.parent;
            if (qCopy == null)
                qCopy = p;
            else
                qCopy = qCopy.parent;
        }
        return pCopy;
    }
}
