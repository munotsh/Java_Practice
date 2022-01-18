package com.example.tree;

public class ConstructBSTFromPostOrder {

    public  static  void main(String[] args){
        ConstructBSTFromPostOrder bt = new ConstructBSTFromPostOrder();
        int[] postOrd = {3,5,4,7,9,8,6};
        Node root = bt.construct(postOrd, 0, postOrd.length-1);
        bt.printTree(root);
    }

    public Node construct(int[] post, int start, int end)
    {
        if (start > end) {
            return null;
        }
        Node node = new Node(post[end]);
        int i;
        for (i = end; i >= start; i--)
        {
            if (post[i] < node.value) {
                break;
            }
        }
        node.right = construct(post, i + 1, end-1);
        node.left = construct(post, start, i);
        return node;
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
