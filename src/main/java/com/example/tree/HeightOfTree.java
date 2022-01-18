package com.example.tree;

public class HeightOfTree {

    public static void main(String[] args) {
        HeightOfTree bt = new HeightOfTree();
        Node root = bt.insertNode(null, 6);
        root = bt.insertNode(root, 4);
        root = bt.insertNode(root, 8);
        root = bt.insertNode(root, 3);
        root = bt.insertNode(root, 5);
        root = bt.insertNode(root, 7);
        root = bt.insertNode(root, 9);
        bt.printTree(root);
        System.out.println();
        System.out.println(bt.getTreeHieght(root));
    }
    public int getTreeHieght(Node node)
    {
        if (node == null)
            return -1;
        else
        {
            int lDepth = getTreeHieght(node.left);
            int rDepth = getTreeHieght(node.right);
            if (lDepth > rDepth)
                return (lDepth + 1);
            else
                return (rDepth + 1);
        }
    }
    public Node insertNode(Node root, int value) {
        if (root == null)
            return new Node(value);
        if (root.value >= value) root.left = insertNode(root.left, value);
        else root.right = insertNode(root.right, value);
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
