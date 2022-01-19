package com.example.tree;

import java.util.*;

public class VerticalOrderTraversalOfBinaryTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    class Triplet {
        int col;
        int row;
        TreeNode n;

        public Triplet(int c, int r, TreeNode v) {
            this.col = c;
            this.row = r;
            this.n = v;
        }
    }

    List<Triplet> nodes = new ArrayList<>();

    public static void main(String[] args) {
        VerticalOrderTraversalOfBinaryTree bt = new VerticalOrderTraversalOfBinaryTree();
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);
        System.out.println(bt.verticalTraversal(root));
    }

    private void BFS(TreeNode root) {
        Queue<Triplet> q = new ArrayDeque<>();
        q.offer(new Triplet(0, 0, root));
        while (!q.isEmpty()) {
            Triplet t = q.poll();
            root = t.n;
            int col = t.col;
            int row = t.row;
            if (root == null)
                continue;

            nodes.add(new Triplet(col, row, root));
            q.offer(new Triplet(col - 1, row + 1, root.left));
            q.offer(new Triplet(col + 1, row + 1, root.right));
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        if (root == null)
            return null;
        BFS(root);
        Collections.sort(nodes, new Comparator<Triplet>() {
            @Override
            public int compare(Triplet t1, Triplet t2) {
                if (t1.col == t2.col) {
                    if (t1.row == t2.row) {
                        return t1.n.val - t2.n.val;
                    } else {
                        return t1.row - t2.row;
                    }

                } else {
                    return t1.col - t2.col;
                }
            }
        });
        List<List<Integer>> output = new ArrayList<>();
        int colIndex = nodes.get(0).col;
        List<Integer> curr = new ArrayList<>();
        for (Triplet t : nodes) {
            int col = t.col, v = t.n.val;
            if (col == colIndex) {
                curr.add(v);
            } else {
                output.add(curr);
                curr = new ArrayList<>();
                colIndex = col;
                curr.add(v);
            }
        }
        output.add(curr);
        return output;
    }
}
