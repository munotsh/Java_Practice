package com.example.tree;

import java.util.Arrays;

public class ConstructBSTFromInOrder {

    public  static  void main(String[] args){
        ConstructBSTFromInOrder bt = new ConstructBSTFromInOrder();

        /*We can construct tree from only inOrder traversal
         if and only if all the root node of the tree arr
         grater that its child node
         Input: inorder[] = {5, 10, 40, 30, 28}
                 40
               /   \
              10     30
             /         \
            5          28
        or else we will need preOrder traversal along with inOrder traversal
        */

        // example for all the root ar grater than its child node
        int[] inOrder1 = {5, 10, 40, 30, 28};
        Node root1 = bt.constructFromOnlyInOrder(inOrder1, 0, inOrder1.length-1,null);
        bt.printTree(root1);

        // example for all the root ar grater than its child node
        int[] inOrd = {3,4,5,6,7,8,9};
        int[] preOrd = {6,4,3,5,8,7,9};
        Node root2 = bt.constructFromInOrderAndPreOrder(inOrd, preOrd);
        bt.printTree(root2);
    }

    Node constructFromOnlyInOrder(int inorder[], int start, int end, Node node)
    {
        if (start > end) return null;

        int i = max(inorder, start, end);
        node = new Node(inorder[i]);
        if (start == end)
            return node;
        node.left = constructFromOnlyInOrder(inorder, start, i - 1, node.left);
        node.right = constructFromOnlyInOrder(inorder, i + 1, end, node.right);
        return node;
    }

    int max(int arr[], int strt, int end)
    {
        int i, max = arr[strt], maxind = strt;
        for (i = strt + 1; i <= end; i++)
        {
            if (arr[i] > max)
            {
                max = arr[i];
                maxind = i;
            }
        }
        return maxind;
    }

    public Node constructFromInOrderAndPreOrder(int[] inOrd, int[] preOrd)
    {
        if(preOrd.length == 0 || inOrd.length == 0)
            return null;
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
//        System.out.println(preOrd);
        int[] leftPreorder = Arrays.copyOfRange(preOrd, 1, leftInorder.length+1);
        int[] rightPreorder = Arrays.copyOfRange(preOrd, leftInorder.length+1, preOrd.length);

        root.left = constructFromInOrderAndPreOrder(leftPreorder, leftInorder);
        root.right = constructFromInOrderAndPreOrder(rightPreorder, rightInorder);
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
