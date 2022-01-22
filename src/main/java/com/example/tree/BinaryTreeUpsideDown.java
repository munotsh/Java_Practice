package com.example.tree;

public class BinaryTreeUpsideDown {
    // For example:
    // Given a binary tree {1,2,3,4,5},
    //     1
    //   / \
    //   2   3
    // / \
    // 4   5
    // return the root of the binary tree [4,5,2,#,#,3,1].
    //   4
    //   / \
    // 5   2
    //     / \
    //   3   1
    public static void main(String[] args) {
        BinaryTreeUpsideDown bt = new BinaryTreeUpsideDown();
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        bt.printTree(root);
        System.out.println();
        Node root1 = bt.upsideDownBinaryTree(root);
     bt.printTree(root1);
    }
    public Node upsideDownBinaryTree(Node root) {
        Node cur = root;
        Node pre = null;
        Node tmp = null;
        Node next = null;
        while(cur != null){
            next = cur.left;
            //need tmp to keep the previous right child
            cur.left = tmp;
            tmp = cur.right;

            cur.right = pre;
            pre = cur;
            cur = next;
        }
        return pre;
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
