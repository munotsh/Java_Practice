package com.example.linkedlistprogram;

class Node {
    int data;
    Node next;
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class IntersectionOfTwoLinkedList {

    public static void main(String[] args) {
        // Shared part
        Node common = new Node(8);
        common.next = new Node(10);

        // List A: 3 -> 7 -> 8 -> 10
        Node headA = new Node(3);
        headA.next = new Node(7);
        headA.next.next = common;

        // List B: 99 -> 1 -> 2 -> 8 -> 10
        Node headB = new Node(99);
        headB.next = new Node(1);
        headB.next.next = new Node(2);
        headB.next.next.next = common;

        Node intersection = getIntersectionNode(headA, headB);
        if (intersection != null)
            System.out.println("Intersection at node with data: " + intersection.data);
        else
            System.out.println("No intersection.");
    }

    private static Node getIntersectionNode(Node headA, Node headB) {
        Node startA = headA;
        Node startB = headB;
        while(startA != startB){
            startA = (startA == null) ? headB : startA.next;
            startB = (startB == null) ? headA : startB.next;
        }
        return startA;
    }
}
