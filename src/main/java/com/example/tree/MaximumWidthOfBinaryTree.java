package com.example.tree;

import java.util.ArrayList;
import java.util.List;

public class MaximumWidthOfBinaryTree {
    List<Long> mins = new ArrayList<>();
    List<Long> maxs = new ArrayList<>();

    public static void main(String[] args) {
        MaximumWidthOfBinaryTree bt = new MaximumWidthOfBinaryTree();
        Node root = new Node(1);
        root.left = new Node(3);
        root.right = new Node(2);
        root.left.left = new Node(5);
        root.left.right = new Node(3);
        root.right.right = new Node(9);
        bt.printTree(root);
        System.out.println();
        System.out.println(bt.widthOfBinaryTree(root));
    }

    public int widthOfBinaryTree(Node root) {
        long[] res = {1};
        dfs(root, 0, 1, res);
        return (int) res[0];
    }

    public void dfs(Node root, long ind, int depth, long[] res) {
        if (root == null) return;
        if (mins.size() < depth) {
            mins.add(ind);
            maxs.add(ind);
        } else {
            if (ind < mins.get(depth - 1)) {
                mins.set(depth - 1, ind);
            } else if (ind > maxs.get(depth - 1)) {
                maxs.set(depth - 1, ind);
            }
            res[0] = Math.max(res[0], maxs.get(depth - 1) - mins.get(depth - 1) + 1);
        }
        dfs(root.left, 2 * ind, depth + 1, res);
        dfs(root.right, 2 * ind + 1, depth + 1, res);
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
