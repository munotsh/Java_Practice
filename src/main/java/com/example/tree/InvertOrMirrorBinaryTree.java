package com.example.tree;

public class InvertOrMirrorBinaryTree {
    public static void main(String[] args) {
         /* Construct the following tree
                   6
                 /   \
                4     8
              /  \   /  \
             3    5 7    9
        */
        InvertOrMirrorBinaryTree bt = new InvertOrMirrorBinaryTree();
        Node root = new Node(6);
        root.left = new Node(4);
        root.right = new Node(8);
        root.left.left = new Node(3);
        root.left.right = new Node(5);
        root.right.left = new Node(7);
        root.right.right = new Node(9);
        bt.printTree(root);
        System.out.println();
        Node root1 = bt.invertTree(root);
        bt.printTree(root1);
    }

    public Node invertTree(Node root) {
//Approach 1 (my)
//        if (root != null) {
//            Node temp = root.left;
//            root.left = root.right;
//            root.right = temp;
//            invertTree(root.left);
//            invertTree(root.right);
//        return root;
//        }
// Approach 2
        if(root == null)
            return root;
        Node left = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(left);
        return root;
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
