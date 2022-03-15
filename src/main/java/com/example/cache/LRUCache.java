package com.example.cache;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(4);
        cache.put(1,1);
        cache.put(2,2);
        cache.put(3,3);
        cache.put(1,1);
        cache.put(4,4);
        cache.put(5,5);
        cache.put(2,2);
        cache.put(2,2);
        cache.put(1,1);
        cache.display();
    }
    class Node {
        private int key;
        private int val;
        private Node next;

        private Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    private int size;
    private int capacity;

    Node dummy = new Node(0, 0);
    Node end = dummy;

    Map<Integer, Node> mapOfPrevious = new HashMap<>();

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!mapOfPrevious.containsKey(key)) {
            return -1;
        }

        Node prev = mapOfPrevious.get(key);
        Node node = prev.next;

        //push node to the latest
        pushToEnd(prev);


        return node.val;
    }

    public void put(int key, int value) {
        //if exists
        if (mapOfPrevious.containsKey(key)) {
            Node prev = mapOfPrevious.get(key);
            Node node = prev.next;

            //update value
            node.val = value;

            //push node to the latest
            pushToEnd(prev);

        } else {
            //if not exists
            Node node = new Node(key, value);
            mapOfPrevious.put(key, end);

            //add to linked list
            end.next = node;
            end = node;

            size++;

            //eviction logic
            if (size > capacity) {
                Node evict = dummy.next;
                mapOfPrevious.remove(evict.key);

                //update map
                mapOfPrevious.put(dummy.next.next.key, dummy);

                dummy.next = dummy.next.next;

                size--;
            }
        }
    }

    public void pushToEnd(Node prev) {
        Node node = prev.next;
        if (node == end) {
            return;
        }

        //update map
        mapOfPrevious.put(prev.next.next.key, prev);

        //de-link
        prev.next = prev.next.next;
        node.next = null;

        //update map
        mapOfPrevious.put(node.key, end);

        //re-link
        end.next = node;
        end = node;

    }

    private void display() {
    }
}
