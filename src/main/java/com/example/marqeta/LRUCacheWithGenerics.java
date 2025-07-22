package com.example.marqeta;
import java.util.*;

public class LRUCacheWithGenerics<K, V> {

        private final int capacity;
        private final Map<K, Node> map;
        private final DoublyLinkedList dll;

        public LRUCacheWithGenerics(int capacity) {
            this.capacity = capacity;
            this.map = new HashMap<>();
            this.dll = new DoublyLinkedList();
        }

        public V get(K key) {
            if (!map.containsKey(key)) return null;
            Node node = map.get(key);
            dll.moveToFront(node);
            return node.value;
        }

        public void put(K key, V value) {
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

        private class Node {
            K key;
            V value;
            Node prev, next;

            Node(K k, V v) {
                key = k;
                value = v;
            }
        }

        private class DoublyLinkedList {
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
        LRUCacheWithGenerics<Integer, String> cache = new LRUCacheWithGenerics<>(3);

        cache.put(1, "One");
        cache.put(2, "Two");
        cache.put(3, "Three");
        System.out.println(cache.get(2)); // Access key 2

        cache.put(4, "Four");             // Evict least recently used (key 1)
        System.out.println(cache.get(1)); // null (evicted)
        System.out.println(cache.get(3)); // "Three"
    }

}
