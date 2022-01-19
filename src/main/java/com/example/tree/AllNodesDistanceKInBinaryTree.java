package com.example.tree;

import java.util.ArrayList;
import java.util.List;

public class AllNodesDistanceKInBinaryTree {

    public static void main(String[] args) {
        AllNodesDistanceKInBinaryTree bt = new AllNodesDistanceKInBinaryTree();
        Node root = new Node(3);
        root.left = new Node(5);
        root.right = new Node(1);
        root.left.left = new Node(6);
        root.left.right = new Node(2);
        root.right.left = new Node(0);
        root.right.right = new Node(8);
        root.left.right.left = new Node(7);
        root.left.right.right = new Node(4);
        System.out.println(bt.distanceK(root,root.left,2));
    }

    public List<Integer> distanceK(Node root, Node target, int k) {
        List<Integer> res = new ArrayList<>();
        // add nodes under target with distance k
        addNodesOnDepthOf(target, 0, k, res);
        // add nodes with distance k cross target's parent
        inorder(root, 0, target, k, res);
        return res;
    }

    // return if target is under root;
    // add nodes of depth: targetDepth to result
    public void addNodesOnDepthOf(Node root, int depth, int targetDepth, List<Integer> res){
        if(root == null || depth > targetDepth) return;

        if(depth == targetDepth) {
            res.add(root.value);
            return;
        }
        addNodesOnDepthOf(root.left, depth + 1, targetDepth, res);
        addNodesOnDepthOf(root.right, depth + 1, targetDepth, res);
    }

    // return target depth if target is under root, otherwise -1
    public int inorder(Node root, int depth, Node target, int k, List<Integer> res){
        if(root == null) return -1;
        if(root == target) return depth;

        int targetDepth = 0;
        targetDepth = inorder(root.left, depth + 1, target, k, res);
        if(targetDepth != -1){
            int needDistance = k - (targetDepth - depth);
            if(needDistance == 0) res.add(root.value);
            else if(needDistance > 0) addNodesOnDepthOf(root.right, 0, needDistance - 1, res);
        }else{
            targetDepth = inorder(root.right, depth + 1, target, k, res);
            if(targetDepth != -1){
                int needDistance = k - (targetDepth - depth);
                if(needDistance == depth) res.add(root.value);
                else if(needDistance > 0) addNodesOnDepthOf(root.left, 0, needDistance - 1, res);
            }
        }

        return targetDepth;
    }
}
