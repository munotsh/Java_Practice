package com.example.tree;

public class ConvertBinarySearchTreeToSortedDoublyLinkedList {


    public static void main(String[] args) {
        ConvertBinarySearchTreeToSortedDoublyLinkedList obj =
                new ConvertBinarySearchTreeToSortedDoublyLinkedList();
        Node root = new Node(25);
        root.left = new Node(20);
        root.left.left = new Node(10);
        root.left.right = new Node(22);
        root.left.left.left = new Node(5);
        root.left.left.right = new Node(12);
        root.right = new Node(36);
        root.right.left = new Node(30);
        root.right.left.left = new Node(28);
        root.right.right = new Node(40);
        root.right.right.left = new Node(38);
        root.right.right.right = new Node(48);
        Node head = obj.convert(root);
        while(head != null){
            System.out.println(head.value);
            head = head.right;
        }
    }

    Node prev = new Node(0);
    //left = previous
    // right = next
    public Node convert(Node root) {
        Node dummy = new Node(-1);
        prev = dummy;
        converter(root);
        Node head = dummy.right;
        // break the link of dummy's next and head's prev
        dummy.right = head.left = null;
        // to create circular
        // head.left = prev;
        // prev.right = head;
        return head;
    }

    private void converter(Node root) {
        if (root == null) return;
        converter(root.left);
        prev.right = root;
        root.left = prev;
        prev = root;
        converter(root.right);
    }
}
