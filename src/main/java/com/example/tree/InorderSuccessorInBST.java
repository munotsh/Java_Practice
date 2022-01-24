package com.example.tree;

public class InorderSuccessorInBST {
    public static void main(String[] args) {
         /* Construct the following tree
                   6
                 /   \
                4     8
              /  \   /  \
             3    5 7    9
        */
        InorderSuccessorInBST bt = new InorderSuccessorInBST();
        Node root = new Node(6);
        root.left = new Node(4);
        root.right = new Node(8);
        root.left.left = new Node(3);
        root.left.right = new Node(5);
        root.right.left = new Node(7);
        root.right.right = new Node(9);
        System.out.println();
        int k=4;
        bt.inOrderSuccessor(root,k);
        //3456789
    }
    private void inOrderSuccessor(Node root, int val) {
        Integer[] ans = new Integer[1];
        inOrderSuccessorOfBinaryTree(root,ans,val);
    }

    private void inOrderSuccessorOfBinaryTree(Node root, Integer[] pre, int searchNode)
    {
        if(root.right != null)
            inOrderSuccessorOfBinaryTree(root.right, pre, searchNode);

        if(root.value == searchNode)
            System.out.println("inorder successor of " + searchNode + " is: "+pre[0]);

        pre[0] = root.value;

        if(root.left != null)
            inOrderSuccessorOfBinaryTree(root.left, pre, searchNode);
    }

}
