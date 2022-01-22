package com.example.customImplementation;

public class CustomSinglyLinkedList<T> {
    private int size = 0;
    private Node node;
    class Node {
        T data;
        private Node node;
        Node(T d) {
            data = d;
        }
    }

    public void add(T data) {
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

    public void addAtFirst(T data) {
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

    public void add(T data, int index) throws IndexOutOfBoundsException {
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


    @Override
    public String toString() {
        String represent = "[";
        Node nextNode = this.node;
        while (nextNode != null) {
            represent = represent + nextNode.data.toString();
            nextNode = next(nextNode);
            if (nextNode != null) {
                represent = represent + ",";
            }
        }
        represent = represent + "]";
        return represent;
    }

public static void main(String[] args) {
    CustomSinglyLinkedList<String> linkedList=new CustomSinglyLinkedList<>();

    System.out.println("****** ADDING Items TO END OF THE LINKED LIST ******");
    linkedList.add("one");
    linkedList.add("two");
    linkedList.add("three");
    System.out.println("Items : "+linkedList);
    System.out.println(" ");

    System.out.println("****** ADDING Items TO START OF THE LINKED LIST ******");
    linkedList.addAtFirst("four");
    System.out.println("Items : "+linkedList);
    System.out.println(" ");

    System.out.println("****** ADDING Items AT PARTICULAR POSITION THE LINKED LIST ******");
    linkedList.add("five" , 2);
    System.out.println("Items : "+linkedList);

}
}