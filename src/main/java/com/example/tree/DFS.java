package com.example.tree;

public class DFS {
    public static void main(String[] args) {
         /* Construct the following tree
                   6
                 /   \
                4     8
              /  \   /  \
             3    5 7    9
        */
        DFS bt = new DFS();
        Node root = new Node(6);
        root.left = new Node(4);
        root.right = new Node(8);
        root.left.left = new Node(3);
        root.left.right = new Node(5);
        root.right.left = new Node(7);
        root.right.right = new Node(9);
        System.out.println();
        bt.generateDFS(root);
        //6435879
    }

    private void generateDFS(Node root) {
        if(root == null)
            return;
        System.out.print(root.value);
        generateDFS(root.left);

        generateDFS(root.right);
    }
}
