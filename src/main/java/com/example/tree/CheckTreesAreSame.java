package com.example.tree;

public class CheckTreesAreSame {

    public static void main(String[] args) {
        CheckTreesAreSame bt = new CheckTreesAreSame();
        Node root = new Node(1);
        root.left = new Node(3);
        root.left.right = new Node(2);

        Node root1 = new Node(1);
        root1.left = new Node(2);
        root1.left.right = new Node(3);

        bt.printTree(root);
        System.out.println();
        System.out.println(bt.isSameTree(root,root));
        System.out.println(bt.isSameTree(root,root1));
    }
    public boolean isSameTree(Node p, Node q) {
        if(p == null && q== null){
            return true;
        }

        if((p == null && q !=null) || (q == null && p !=null) || (p.value != q.value )){
            return false;
        }

        boolean l = isSameTree(p.left,q.left);
        boolean r = isSameTree(p.right,q.right);
        return (l && r);
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
