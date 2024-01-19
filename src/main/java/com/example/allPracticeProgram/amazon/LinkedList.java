package com.example.allPracticeProgram.amazon;

import java.util.ArrayDeque;
import java.util.Deque;

public class LinkedList {
	
	private int size = 0;
    private Node node;
    class Node {
        Integer data;
        private Node node;
        Node(Integer d) {
            data = d;
        }
    }

    public void add(Integer data) {
        if (data == null) {
            return;
        }
        if (node == null) {
            node = new Node(data);
        } else {
            Node newNode = new Node(data);
            Node lastNode = getLastNode(node);
            lastNode.node = newNode;
        }
        size++;
    }

    public void addAtFirst(Integer data) {
        if (data == null) {
            return;
        }
        Node newNode = new Node(data);
        if (this.node != null) {
            newNode.node = this.node;
            this.node = newNode;
        } else {
            this.node = newNode;
        }
        size++;
    }

    public void add(Integer data, int index) throws IndexOutOfBoundsException {
        if (data == null) {
            return;
        }
        if (index == 0) {
            addAtFirst(data);
            return;
        }
        if (index == this.size) {
            add(data);
        } else if (index < this.size) {
            Node newNode = new Node(data);
            Node leftNode = getNode(index - 1);
            Node rightNode = getNode(index);
            newNode.node = rightNode;
            leftNode.node = newNode;
            size++;
        } else {
            throw new IndexOutOfBoundsException("Index not available.");
        }
    }


    private Node getNode(int index) {
        if (index < 0 || index > this.size - 1) {
            throw new IndexOutOfBoundsException("Index not available.");
        }
        if (index == 0) {
            return this.node;
        }
        if (index == this.size - 1) {
            return getLastNode(this.node);
        }
        int pointer = 0;
        Node pointerNode = this.node;
        while (pointer <= index) {
            if (pointer == index) {
                return pointerNode;
            } else {
                pointerNode = next(pointerNode);
                pointer++;
            }
        }
        return null;
    }

    private Node getLastNode(Node node) {

        Node lastNode = node;
        if (lastNode.node != null) {
            return getLastNode(lastNode.node);
        } else {
            return lastNode;
        }
    }


    private Node next(Node node) {
        if (node.node != null) {
            return node.node;
        } else {
            return null;
        }
    }

    public int size() {
        return this.size;
    }


//    @Override
//    public String toString() {
//        String represent = "[";
//        Node nextNode = this.node;
//        while (nextNode != null) {
//            represent = represent + nextNode.data.toString();
//            nextNode = next(nextNode);
//            if (nextNode != null) {
//                represent = represent + ",";
//            }
//        }
//        represent = represent + "]";
//        return represent;
//    }

    public  void print(LinkedList customSinglyLinkedList){
        Node n = customSinglyLinkedList.node;
        Deque<Integer> dq = new ArrayDeque<>();
        while(n!=null){
//            System.out.println(n.data);
            dq.add(n.data);
            n = n.node;
        }
        int max = 0;
        while(!dq.isEmpty()) {
        	int first =0;
        	int last = 0;
        	if(dq.size() > 1) {
        		first = dq.removeFirst();
            	last = dq.removeLast();	
        	}
        	else {
        		first = dq.removeFirst();
        	}
        	max = Math.max(max,first+last);
//        	System.out.println(first+last);
        }
        System.out.println(max);

    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList linkedList=new LinkedList();
		System.out.println("****** ADDING Items TO END OF THE LINKED LIST ******");
	    linkedList.add(1);
	    linkedList.add(4);
	    linkedList.add(3);
	    linkedList.add(2);
//	    linkedList.add(1);
	    linkedList.print(linkedList);
	}

}
