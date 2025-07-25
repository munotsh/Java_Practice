package com.example.allPracticeProgram.amazon1;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


public class Tree {
	public class Node {
		int value;
		Node left;
		Node right;

		public Node(int value) {
			this.value = value;
			right = null;
			left = null;
		}
	}

	Node root;

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

	public void add(int value) {
		root = addRecursive(root, value);
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

	void deleteKey(int key) {
		root = deleteRec(root, key);
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

	public boolean containsNode(int value) {
		return containsNodeRecursive(root, value);
	}

	void inorderRec(Node root) {
		if (root != null) {
			inorderRec(root.left);
			System.out.print(root.value + " ");
			inorderRec(root.right);
		}
	}

	void inorder() {
		inorderRec(root);
	}

	void postOrderRec(Node node) {
		if (node == null)
			return;

		postOrderRec(node.left);
		postOrderRec(node.right);
		System.out.print(node.value + " ");
	}

	void postorder() {
		postOrderRec(root);
	}

	void preOrderRec(Node node) {
		if (node == null)
			return;

		System.out.print(node.value + " ");
		preOrderRec(node.left);
		preOrderRec(node.right);
	}

	void preOrder() {
		preOrderRec(root);
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
	
	void levelOrderOrder() {
		levelOrderTraversal(root);
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
	
	public int getTreeHieght() {
		return treeHight(root);
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
	
	public boolean isDegenerated() {
		return degenerate(root);
	}
//	{6,4,3,5,8,7,9}
	public Node constructBSTFromPreOrder(int[] pre, int start, int end)
    {
        if (start > end) {
            return null;
        }
        Node node = new Node(pre[start]);
        int i;
        for (i = start; i <= end; i++)
        {
        	if (pre[i] > node.value) {
                break;
            }
        }
        node.left = constructBSTFromPreOrder(pre, start + 1, i - 1);
        node.right = constructBSTFromPreOrder(pre, i, end);
        return node;
    }
	
	public Node constructBSTFromPostOrder(int[] post, int start, int end)
    {
        if (start > end) {
            return null;
        }
        Node node = new Node(post[end]);
        int i;
        for (i = end; i >= start; i--)
        {
        	if (post[i] < node.value) {
                break;
            }
        }
        node.right = constructBSTFromPostOrder(post, i + 1, end-1);
        node.right = constructBSTFromPostOrder(post, start, i);
        return node;
    }
	public Node constructBSTFromInOrder(int[] inOrd, int[] preOrd)
    {
		
		 if(preOrd.length == 0 || inOrd.length == 0) return null;
	        int rootVal = preOrd[0];
	        Node root = new Node(rootVal);       
	        
	        if(preOrd.length == 1 || inOrd.length == 1) return root;

	        int breakPoint = 0;
	        for(int i = 0; i < inOrd.length; i++) {
	            if(inOrd[i] == rootVal) {
	                breakPoint = i;
	                break;
	            }
	        }

	        int[] leftInorder = Arrays.copyOfRange(inOrd, 0, breakPoint);
	        int[] rightInorder = Arrays.copyOfRange(inOrd, breakPoint+1, inOrd.length);

	        System.out.println(preOrd);
	        int[] leftPreorder = Arrays.copyOfRange(preOrd, 1, leftInorder.length+1);
	        int[] rightPreorder = Arrays.copyOfRange(preOrd, leftInorder.length+1, preOrd.length);
	        
	        root.left = constructBSTFromInOrder(leftPreorder, leftInorder);
	        root.right = constructBSTFromInOrder(rightPreorder, rightInorder);
	        
	        return root;
    }
	
	
	public static void main(String[] args) {

		Tree bt = new Tree();
		bt.add(6);
		bt.add(4);
		bt.add(8);
		bt.add(3);
		bt.add(5);
		bt.add(7);
		bt.add(9);
//		check whether tree is degenerated
//		bt.add(10);bt.add(9);bt.add(8);bt.add(7);bt.add(6);bt.add(5);bt.add(4);
//		System.out.println(bt.isDegenerated());
		
//		System.out.println(bt.getTreeHieght());
		
		
		
//		bt.postorder();
//		int[] post = {3,5,4,7,9,8,6};
//		bt.constructBSTFromPostOrder(post, 0, post.length-1);

//		bt.preOrder();
//		int[] preOrd = {6,4,3,5,8,7,9};
//		bt.constructBSTFromPreOrder(preOrd, 0, preOrd.length-1);
		
//		bt.inorder();
//		int[] inOrd = {3,4,5,6,7,8,9};
//		bt.constructBSTFromInOrder(inOrd,preOrd);
		
//		bt.levelOrderOrder();
//		System.out.println(bt.containsNode(8));
//		bt.deleteKey(8);
//		bt.inorder();
//		System.out.println(bt.containsNode(8));
	}
}
