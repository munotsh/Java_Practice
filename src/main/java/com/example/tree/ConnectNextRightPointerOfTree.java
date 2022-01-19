package com.example.tree;

public class ConnectNextRightPointerOfTree {

    /* Construct the following tree
                   6  -> null
                 /   \
                4  -> 8  -> null
              /  \   /  \
             3 ->5->7 -> 9 -> null
        */

    public class BTNode {
        int value;
        BTNode left;
        BTNode right;
        BTNode next;

        public BTNode(int value) {
            this.value = value;
            right = null;
            left = null;
            next = null;
        }
    }

    public static void main(String[] args) {
        ConnectNextRightPointerOfTree bt = new ConnectNextRightPointerOfTree();
        BTNode root = bt.insertNode(null, 6);
        root = bt.insertNode(root, 4);
        root = bt.insertNode(root, 8);
        root = bt.insertNode(root, 3);
        root = bt.insertNode(root, 5);
        root = bt.insertNode(root, 7);
        root = bt.insertNode(root, 9);
        bt.printTree(root);
        BTNode root1 = bt.connect(root);
    }
    public BTNode connect(BTNode root) {
        if(root==null)
            return null;

        if(root.left!=null){
            root.left.next = root.right;
            connect(root.left);
            root.right.next = null!= root.next ? root.next.left : null;
            connect(root.right);
        }
        return root;
    }
    public BTNode insertNode(BTNode root, int value) {
        if (root == null)
            return new BTNode(value);
        if (root.value >= value) root.left = insertNode(root.left, value);
        else root.right = insertNode(root.right, value);
        return root;
    }

    void printTree(BTNode root) {
        if (root == null) {
            return;
        }
        System.out.printf("%d ", root.value);
        printTree(root.left);
        printTree(root.right);
    }
}
