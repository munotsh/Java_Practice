package com.example.tree;

import java.util.*;

public class VerticalOrderTraversalOfBinaryTree {
    class Triplet {
        int col;
        int row;
        Node n;

        public Triplet(int c, int r, Node v) {
            this.col = c;
            this.row = r;
            this.n = v;
        }
    }

    List<Triplet> nodes = new ArrayList<>();

    public static void main(String[] args) {
        VerticalOrderTraversalOfBinaryTree bt = new VerticalOrderTraversalOfBinaryTree();
        Node root = new Node(6);
        root.left = new Node(4);
        root.right = new Node(8);
        root.left.left = new Node(3);
        root.left.right = new Node(5);
        root.right.left = new Node(7);
        root.right.right = new Node(9);
        System.out.println(bt.verticalTraversal(root));
    }

    private void BFS(Node root) {
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

    public List<List<Integer>> verticalTraversal(Node root) {
        if (root == null)
            return null;
        BFS(root);
        Collections.sort(nodes, new Comparator<Triplet>() {
            @Override
            public int compare(Triplet t1, Triplet t2) {
                if (t1.col == t2.col) {
                    if (t1.row == t2.row) {
                        return t1.n.value - t2.n.value;
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
            int col = t.col, v = t.n.value;
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
