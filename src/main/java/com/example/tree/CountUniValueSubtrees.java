package com.example.tree;

public class CountUniValueSubtrees {
    public static void main(String args[])
    {
           /* Let us construct the below tree
                5
              /   \
            4      5
          /  \      \
         4    4      5 */
        CountUniValueSubtrees bt = new CountUniValueSubtrees();
        Node root = new Node(5);
        root.left = new Node(4);
        root.right = new Node(5);
        root.left.left = new Node(4);
        root.left.right = new Node(4);
        root.right.right = new Node(5);

        System.out.println("The count of single valued sub trees is : "
                + bt.countSingle(root));
    }

    private int countSingle(Node root) {
        int[] ans = new int[1];
        countSingleRec(root,ans);
        return ans[0];
    }

    private boolean countSingleRec(Node root, int[] ans) {
        if (root == null)
            return true;
        // Recursively count in left and right subtrees also
        boolean left = countSingleRec(root.left, ans);
        boolean right = countSingleRec(root.right, ans);

        // If any of the subtrees is not singly, then this
        // cannot be singly.
        if (left == false || right == false)
            return false;

        // If left subtree is singly and non-empty, but data
        // doesn't match
        if (root.left != null && root.value != root.left.value)
            return false;

        // Same for right subtree
        if (root.right != null && root.value != root.right.value)
            return false;

        // If none of the above conditions is true, then
        // tree rooted under root is single valued, increment
        // count and return true.
        ans[0]++;
        return true;
    }
        
}
