package com.example.marqeta;
import java.util.*;

public class LRUCache {
    private final int capacity;
    private final Map<Integer, Node> map;
    private final DoublyLinkedList dll;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.dll = new DoublyLinkedList();
    }

    public String get(int key) {
        if (!map.containsKey(key)) return null;
        Node node = map.get(key);
        dll.moveToFront(node);
        return node.value;
    }

    public void put(int key, String value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            dll.moveToFront(node);
        } else {
            if (map.size() == capacity) {
                Node lru = dll.removeLast();
                map.remove(lru.key);
            }
            Node newNode = new Node(key, value);
            dll.addFirst(newNode);
            map.put(key, newNode);
        }
    }

    private static class Node {
        int key;
        String value;
        Node prev, next;

        Node(int k, String v) {
            key = k;
            value = v;
        }
    }

    private static class DoublyLinkedList {
        private Node head, tail;

        void addFirst(Node node) {
            node.next = head;
            node.prev = null;
            if (head != null) head.prev = node;
            head = node;
            if (tail == null) tail = head;
        }

        void moveToFront(Node node) {
            if (node == head) return;
            remove(node);
            addFirst(node);
        }

        Node removeLast() {
            if (tail == null) return null;
            Node removed = tail;
            remove(tail);
            return removed;
        }

        void remove(Node node) {
            if (node.prev != null) node.prev.next = node.next;
            else head = node.next;
            if (node.next != null) node.next.prev = node.prev;
            else tail = node.prev;
        }
    }
        public static void main(String[] args) {
            LRUCache cache = new LRUCache(3);

            cache.put(1, "A");
            cache.put(2, "B");
            cache.put(3, "C");
            System.out.println("Get 1: " + cache.get(1)); // Access 1 to make it recently used
            cache.put(4, "D"); // This should evict key 2 (least recently used)

            System.out.println("Get 2: " + cache.get(2)); // Should return null
            System.out.println("Get 3: " + cache.get(3)); // Should still be present
            System.out.println("Get 4: " + cache.get(4)); // Should return D
        }
}