package com.example.tree;

public class ConstructBSTFromPreOrder {
    public  static  void main(String[] args){
        ConstructBSTFromPreOrder bt = new ConstructBSTFromPreOrder();
        int[] preOrd = {6,4,3,5,8,7,9};
        Node root = bt.construct(preOrd, 0, preOrd.length-1);
        bt.printTree(root);
    }
    public Node construct(int[] pre, int start, int end)
    {
        if (start > end) {
            return null;
        }
        Node node = new Node(pre[start]);
        int i;
        for (i = start; i <= end; i++)
        {
            if (pre[i] > node.value) {
                break;
            }
        }
        node.left = construct(pre, start + 1, i - 1);
        node.right = construct(pre, i, end);
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
