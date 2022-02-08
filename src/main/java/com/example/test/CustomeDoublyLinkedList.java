package com.example.test;

public class CustomeDoublyLinkedList {

	Node head;
	Node tail;
	int size;

	class Node {
		int data;
		Node prev;
		Node next;

		Node(int d) {
			data = d;
		}
	}

	// Adding a node at the front of the list
	public void pushNodeAtFront(int new_data) {
		Node new_Node = new Node(new_data);
		new_Node.next = head;
		new_Node.prev = null;

		if (head != null)
			head.prev = new_Node;
		head = new_Node;
		if (tail == null)
			tail = new_Node;
		size++;
	}

	/* Given a node as prev_node, insert a new node after the given node */
	public void InsertAfter(Node prev_Node, int new_data) {
		if (prev_Node == null) {
			System.out.println("The given previous node cannot be NULL ");
			return;
		}
		Node new_node = new Node(new_data);
		new_node.next = prev_Node.next;
		prev_Node.next = new_node;
		new_node.prev = prev_Node;
		if (new_node.next != null)
			new_node.next.prev = new_node;
		size++;
	}

	// Add a node at the end of the list
	void addAtEnd(int new_data) {
		Node newNode = new Node(new_data);
		newNode.next = null;
		newNode.prev = tail;
		if (tail != null)
			tail.next = newNode;
		tail = newNode;
		if (head == null)
			head = newNode;
		size++;
	}

	public Node deleteFirst() {
		if (head == null)
			throw new RuntimeException("Doubly linked list is already empty");
		Node temp = head;
		head = head.next;
		head.prev = null;
		size--;
		return temp;
	}

	/* Given a node as prev_node, insert a new node before the given node */
	public void InsertBefore(Node next_node, int new_data) {
		if (next_node == null) {
			System.out.println("The given next node can not be NULL");
			return;
		}
		Node new_node = new Node(new_data);
		new_node.prev = next_node.prev;
		next_node.prev = new_node;
		new_node.next = next_node;
		if (new_node.prev != null)
			new_node.prev.next = new_node;
		else
			head = new_node;
		size++;
	}

	// delete node after particular node
	public void deleteAfter(Node after) {
		Node temp = head;
		while (temp.next != null && temp.data != after.data) {
			temp = temp.next;
		}
		if (temp.next != null)
			temp.next.next.prev = temp;
		temp.next = temp.next.next;
		size--;
	}

	// delete node before particular node
	public void deleteBefore(Node after) {
		Node temp = head;
		while (temp.next != null && temp.data != after.data) {
			temp = temp.next;
		}
		if (temp.next != null)
			temp.prev.prev.next = temp;
		temp.prev = temp.prev.prev;
		size--;
	}

	// delete lats node
	public Node deleteLast() {
		Node temp = tail;
		tail = tail.prev;
		tail.next = null;
		size--;
		return temp;
	}
	public void printForwardDirection(Node node) {
		Node last = null;
		System.out.println("Traversal in forward Direction");
		while (node != null) {
			System.out.print(node.data + " ");
			last = node;
			node = node.next;
		}
	}
	public void printBackwordDirection(Node node) {
		Node last = null;
		System.out.println("Traversal in Backword Direction");
		while (node != null) {
			System.out.print(node.data + " ");
			last = node;
			node = node.prev;
		}
	}
	public static void main(String[] args) {
		CustomeDoublyLinkedList dll = new CustomeDoublyLinkedList();
		dll.addAtEnd(6);
		dll.pushNodeAtFront(7);
		dll.pushNodeAtFront(1);
		dll.addAtEnd(4);
		dll.InsertAfter(dll.head.next, 8);
		dll.InsertBefore(dll.head.next.next, 5);
		System.out.println("Created DLL is: ");
		dll.printForwardDirection(dll.head);
		dll.printBackwordDirection(dll.tail);
	}
}
