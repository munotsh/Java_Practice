package com.example.tree;

public class ConvertSortedLinkedListToBinarySearchTree {
    public static void main(String[] args) {
        ConvertSortedLinkedListToBinarySearchTree bt = new ConvertSortedLinkedListToBinarySearchTree();
        LinkListNode head = new LinkListNode(-10);
        head.next = new LinkListNode(-3);
        head.next.next = new LinkListNode(0);
        head.next.next.next = new LinkListNode(5);
        head.next.next.next.next = new LinkListNode(9);
        Node root = bt.sortedListToBST(head);
        bt.printTree(root);
    }

    public Node sortedListToBST(LinkListNode head) {
        if (head == null) {
            return null;
        }
        LinkListNode slow = head, fast = head, prev = head;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        Node root = new Node(slow.val);
        if (slow == head) {
            return root;
        }
        prev.next = null;
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(slow.next);
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
