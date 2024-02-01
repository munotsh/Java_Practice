package com.example.test;

import java.util.LinkedList;
import java.util.Queue;

public class Tree {
	static class Node {
		int value;
		Node left;
		Node right;

		Node(int value) {
			this.value = value;
			right = null;
			left = null;
		}
	}

	public Node root;

	private Node addRecursive(Node current, int value) {
		if (current == null) {
			return new Node(value);
		}

		if (value < current.value) {
			current.left = addRecursive(current.left, value);
		} else if (value > current.value) {
			current.right = addRecursive(current.right, value);
		} else {
			// value already exists
			return current;
		}

		return current;
	}

	private Node deleteRec(Node root, int key) {
		if (root == null)
			return root;

		if (key < root.value)
			root.left = deleteRec(root.left, key);
		else if (key > root.value)
			root.right = deleteRec(root.right, key);

		else {
			if (root.left == null)
				return root.right;
			else if (root.right == null)
				return root.left;

			root.value = minValue(root.right);

			root.right = deleteRec(root.right, root.value);
		}

		return root;
	}

	int minValue(Node root) {
		int minv = root.value;
		while (root.left != null) {
			minv = root.left.value;
			root = root.left;
		}
		return minv;
	}

	private boolean containsNodeRecursive(Node current, int value) {
		if (current == null) {
			return false;
		}
		if (value == current.value) {
			return true;
		}
		return value < current.value ? containsNodeRecursive(current.left, value)
				: containsNodeRecursive(current.right, value);
	}

	void inorderRec(Node root) {
		if (root != null) {
			inorderRec(root.left);
			System.out.print(root.value + " ");
			inorderRec(root.right);
		}
	}


	void postOrderRec(Node node) {
		if (node == null)
			return;

		postOrderRec(node.left);
		postOrderRec(node.right);
		System.out.print(node.value + " ");
	}

	void preOrderRec(Node node) {
		if (node == null)
			return;

		System.out.print(node.value + " ");
		preOrderRec(node.left);
		preOrderRec(node.right);
	}

	public void levelOrderTraversal(Node startNode) {
        Queue<Node> queue=new LinkedList<Node>();
        queue.add(startNode);
        while(!queue.isEmpty())
        {
            Node tempNode=queue.poll();
            System.out.println(tempNode.value);
            if(tempNode.left!=null)
                queue.add(tempNode.left);
            if(tempNode.right!=null)
                queue.add(tempNode.right);
        }
    }
	
	public int treeHight(Node node)
    {
        if (node == null)
            return -1;
        else 
        {
            int lDepth = treeHight(node.left);
            int rDepth = treeHight(node.right);
            if (lDepth > rDepth)
                return (lDepth + 1);
             else 
                return (rDepth + 1);
        }
    }
	
	public boolean degenerate(Node node) {
	    if (node.left != null) {
	        if (node.right != null) {
	            return false; // not degenerate, has two children
	        } else {
	            return degenerate(node.left);
	        }
	    } else {
	        if (node.right != null) {
	            return degenerate(node.right);
	        } else {
	            return true; // we arrived at the bottom without seeing any node with two children
	        }
	    }
	}
	
	public int largestElement(Node temp){
		//Check whether tree is empty
		if(root == null) {
			return 0;
		}
		else{
			int leftMax, rightMax;
			//Max will store temp's data
			int max = temp.value;
			//It will find largest element in left subtree
			if(temp.left != null){
				leftMax = largestElement(temp.left);
				max = Math.max(max, leftMax);
			}
			//It will find largest element in right subtree
			if(temp.right != null){
				rightMax = largestElement(temp.right);
				max = Math.max(max, rightMax);
			}
			return max;
		}
	}

	public int lowestElement(Node temp){
		//Check whether tree is empty
		if(root == null) {
			System.out.println("Tree is empty");
			return 0;
		}
		else{
			int leftMax, rightMax;
			//Max will store temp's data
			int min = temp.value;
			//It will find lowest element in left subtree
			if(temp.left != null){
				leftMax = lowestElement(temp.left);
				min = Math.min(min, leftMax);
			}

			//It will find lowest element in right subtree
			if(temp.right != null){
				rightMax = lowestElement(temp.right);
				min = Math.min(min, rightMax);
			}
			return min;
		}
	}

	public static void main(String[] args) {

		Tree bt = new Tree();
		bt.root = new Node(6);
		bt.addRecursive(bt.root,4);
		bt.addRecursive(bt.root,8);
		bt.addRecursive(bt.root,3);
		bt.addRecursive(bt.root,5);
		bt.addRecursive(bt.root,7);
		bt.addRecursive(bt.root,9);
//		check whether tree is degenerated
//		bt.addRecursive(bt.root,10);bt.addRecursive(bt.root,9);
//		bt.addRecursive(bt.root,8);bt.addRecursive(bt.root,7);
//		bt.addRecursive(bt.root,6);bt.addRecursive(bt.root,5);
//		bt.addRecursive(bt.root,4);
//		System.out.println(bt.degenerate(bt.root));
		System.out.println(bt.treeHight(bt.root));
		bt.inorderRec(bt.root);
		bt.postOrderRec(bt.root);
		bt.preOrderRec(bt.root);
		bt.levelOrderTraversal(bt.root);
		System.out.println(bt.containsNodeRecursive(bt.root,8));
		bt.deleteRec(bt.root,8);
		bt.inorderRec(bt.root);
		System.out.println(bt.containsNodeRecursive(bt.root,8));
		System.out.println(bt.largestElement(bt.root));
		System.out.println(bt.lowestElement(bt.root));
	}
}
